package fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jadilindo.meau.meau.Animal;
import com.jadilindo.meau.meau.ListAdapter;
import com.jadilindo.meau.meau.MainActivity;
import com.jadilindo.meau.meau.R;
import com.jadilindo.meau.meau.User;

import java.util.ArrayList;

/**
 * Created by pedro on 09/05/18.
 */

public class AtalhoAjudarFragment extends Fragment {
    public DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mDatabase;
    public User user;
    public ArrayList<Animal> animals;
    public LinearLayout container_aux;
    public FirebaseUser currentUser;
    public String helped_animal_id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_atalho_ajudar, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.listRecycleViewAjudar);
        final ArrayList<Animal> animais = new ArrayList<>();
        final ListAdapter listAdapter = new ListAdapter(animais, 3);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        container_aux = rootView.findViewById(R.id.container_layout);

        Query queryRef = databaseUsers.orderByChild("email");
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int animal_counter = 0;
                animais.clear();
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot db_user : dataSnapshot.getChildren()) {
                        try{
                            user = db_user.getValue(User.class);
                        }catch (com.google.firebase.database.DatabaseException e){
                            continue;
                        }
                        if ((user!=null)&&(user.getEmail().equals(currentUser.getEmail()))) continue;
                        if (user != null) {
                            if((user.getOwns() != null)&&(user.getOwns().size() != 0)){
                                for (Animal animal : user.getOwns()) {
                                    if (animal == null) continue;
                                    if ((!animal.getAction_type().equals("para_adocao_e_ajuda"))&&(!animal.getAction_type().equals("para_apadrinhar_e_ajuda"))) continue;
                                    if (animal.isHelped()) continue;
                                    if (animals == null) animals = new ArrayList<>();
                                    animais.add(animal);
                                    listAdapter.notifyDataSetChanged();
//                                    animal_counter++;
//                                    animals.add(animal);
//                                    ImageView imageViewAnimal = new ImageView(getActivity());
//                                    Picasso.with(getActivity())
//                                            .load(animal.getPicture())
//                                            .noFade().into(imageViewAnimal);
//                                    TextView name_text_view = new TextView(getActivity());
//                                    name_text_view.setPadding(0, 40, 0, 0);
//                                    name_text_view.setText("Nome do animal: " + animal.getName());
//                                    TextView age_text_view = new TextView(getActivity());
//                                    age_text_view.setText("Idade do animal: " + animal.getAge());
//                                    TextView gender_text_view = new TextView(getActivity());
//                                    gender_text_view.setText("Sexo do animal: " + animal.getGender());
//                                    TextView size_text_view = new TextView(getActivity());
//                                    size_text_view.setText("Tamanho do animal: " + animal.getSize());
//                                    Button help_button = new Button(getActivity());
//                                    View.OnClickListener mOnClickListener = new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(final View view) {
//                                            help_animal_for_current_user(view);
//                                        }
//                                    };
//
//                                    help_button.setText("Ajudar");
//                                    help_button.setTag(animal.getId());
//                                    help_button.setOnClickListener(mOnClickListener);
//                                    Button fav_button = new Button(getActivity());
//                                    View.OnClickListener mOnClickListenerFav = new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(final View view) {
//                                            fav_animal_for_current_user(view);
//                                        }
//                                    };
//
//                                    fav_button.setText("Favoritar");
//                                    fav_button.setTag(animal.getId());
//                                    fav_button.setOnClickListener(mOnClickListenerFav);
//                                    container_aux.addView(imageViewAnimal);
//                                    container_aux.addView(name_text_view);
//                                    container_aux.addView(age_text_view);
//                                    container_aux.addView(gender_text_view);
//                                    container_aux.addView(size_text_view);
//                                    container_aux.addView(help_button);
//                                    container_aux.addView(fav_button);
                                }
                            }
                        }
                    }
                }
//                if(animal_counter == 0){
//                    TextView empty = new TextView(getActivity());
//                    empty.setText("Nenhum Animal");
//                    container_aux.addView(empty);
//                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return rootView;
    }
    private void help_animal_for_current_user(final View view) {
        Query queryRef = databaseUsers.orderByChild("email").equalTo(currentUser.getEmail());
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot db_user : dataSnapshot.getChildren()) {
                        User current_user = db_user.getValue(User.class);
                        if (current_user != null) {
                            String animal_id = (String) view.getTag();
                            for (Animal animal : animals){
                                if(animal.getId().equals(animal_id)){
                                    if (current_user.helps == null) current_user.helps = new ArrayList<>();
                                    current_user.helps.add(animal);
                                    db_user.getRef().child("helps").setValue(current_user.getOwns());
                                    helped_animal_id = animal_id;
                                    set_animal_as_helped();
                                    Toast.makeText(getActivity(),
                                            "Animal Ajudado com sucesso!", Toast.LENGTH_SHORT).show();
                                    goToHome(view);                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void fav_animal_for_current_user(final View view) {
        Query queryRef = databaseUsers.orderByChild("email").equalTo(currentUser.getEmail());
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot db_user : dataSnapshot.getChildren()) {
                        User current_user = db_user.getValue(User.class);
                        if (current_user != null) {
                            String animal_id = (String) view.getTag();
                            for (Animal animal : animals){
                                if(animal.getId().equals(animal_id)){
                                    boolean is_already_a_favorite = false;
                                    if (current_user.favorites == null) current_user.favorites = new ArrayList<>();
                                    for(Animal favorite_animal : current_user.favorites){
                                        if (favorite_animal.getId().equals(animal_id)){
                                            is_already_a_favorite = true;
                                        }
                                    }
                                    if (is_already_a_favorite){
                                        Toast.makeText(getActivity(),
                                                "Animal Já é favorito!", Toast.LENGTH_SHORT).show();
                                        continue;
                                    }
                                    current_user.favorites.add(animal);
                                    db_user.getRef().child("favorites").setValue(current_user.getFavorites());
                                    helped_animal_id = animal_id;
                                    Toast.makeText(getActivity(),
                                            "Animal Favoritado com sucesso!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void goToHome (View view){
        Intent intent = new Intent (getActivity(), MainActivity.class);
        startActivity(intent);
    }

    private void set_animal_as_helped() {
        Query queryRef = databaseUsers.orderByChild("email");
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User target_user;
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot db_user : dataSnapshot.getChildren()) {
                        try{
                            target_user = db_user.getValue(User.class);
                        }catch (com.google.firebase.database.DatabaseException e){
                            continue;
                        }
                        if (target_user != null) {
                            if((target_user.getOwns() != null)&&(target_user.getOwns().size() != 0)){
                                for (int i = 0; i < target_user.getOwns().size(); i++) {
                                    Animal animal = target_user.getOwns().get(i);
                                    if (animal.getId().equals(helped_animal_id)){
                                        animal.setHelped(true);
                                        animal.setUserHelperEmail(currentUser.getEmail());
                                        target_user.getOwns().set(i, animal);
                                    }
                                }
                                db_user.getRef().setValue(target_user);
                            }
                            if((target_user.getFavorites() != null)&&(target_user.getFavorites().size() != 0)){
                                for (int i = 0; i < target_user.getFavorites().size(); i++) {
                                    Animal animal = target_user.getFavorites().get(i);
                                    if (animal.getId().equals(helped_animal_id)){
                                        animal.setHelped(true);
                                        animal.setUserHelperEmail(currentUser.getEmail());
                                        target_user.getFavorites().set(i, animal);
                                    }
                                }
                                db_user.getRef().setValue(target_user);
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}