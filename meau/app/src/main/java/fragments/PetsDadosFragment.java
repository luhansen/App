package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.jadilindo.meau.meau.R;
import com.jadilindo.meau.meau.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by pedro on 28/06/18.
 */

public class PetsDadosFragment extends Fragment {
    public DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference();
    public ArrayList<Animal> animals;
    public String sponsored_animal_id;
    public FirebaseUser currentUser;
    Animal animal;
    public User user;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pet_dados_fragment, container, false);
        animal = (Animal)getArguments().getSerializable("MyData");
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();


        TextView textElement = (TextView) rootView.findViewById(R.id.pet_name_perfil);
        textElement.setText(animal.getName());
        textElement = (TextView) rootView.findViewById(R.id.detalhesIdade);
        textElement.setText(animal.getAge());
        textElement = (TextView) rootView.findViewById(R.id.detalhesPorte);
        textElement.setText(animal.getSize());
        textElement = (TextView) rootView.findViewById(R.id.detalhesSexo);
        textElement.setText(animal.getGender());
        ImageView imageViewAnimal = (ImageView) rootView.findViewById(R.id.pet_image_perfil);
        Picasso.with(getActivity())
                .load(animal.getPicture())
                .noFade().into(imageViewAnimal);

            textElement = (TextView) rootView.findViewById(R.id.detalhesVermifugado);
            textElement.setText("Não");


            textElement = (TextView) rootView.findViewById(R.id.detalhesVacinado);
            textElement.setText("Não");


            textElement = (TextView) rootView.findViewById(R.id.detalhesCastrado);
            textElement.setText("Não");

            textElement = (TextView) rootView.findViewById(R.id.detalhesDoencas);
            textElement.setText("Não");

        if (animal.getHealth() != null) {
            for (String s : animal.getHealth()) {
                if (s.equals("vermifugado")) {
                    textElement = (TextView) rootView.findViewById(R.id.detalhesVermifugado);
                    textElement.setText("Sim");
                } else if (s.equals("vacinado")) {
                    textElement = (TextView) rootView.findViewById(R.id.detalhesVacinado);
                    textElement.setText("Sim");
                } else if (s.equals("castrado")) {
                    textElement = (TextView) rootView.findViewById(R.id.detalhesCastrado);
                    textElement.setText("Sim");
                } else if (s.equals("doente")) {
                    textElement = (TextView) rootView.findViewById(R.id.detalhesDoencas);
                    textElement.setText(animal.getDesease());
                }
            }
        }

        String temperamento = "";
        if (animal.getTemper() != null) {
            for (String s : animal.getTemper()) {
                if (s.equals("amoroso")) {
                    temperamento += "amoroso, ";
                }
                if (s.equals("brincalhao")) {
                    temperamento += "brincalhao, ";
                }
                if (s.equals("calmo")) {
                    temperamento += "calmo, ";
                }
                if (s.equals("preguicoso")) {
                    temperamento += "preguicoso, ";
                }
                if (s.equals("guarda")) {
                    temperamento += "guarda, ";
                }
                if (s.equals("timido")) {
                    temperamento += "timido, ";
                }

            }
        }
        temperamento = temperamento.substring(0, temperamento.length() - 2);
        textElement = (TextView) rootView.findViewById(R.id.DetalhesTemperamento);
        textElement.setText(temperamento);

        textElement = (TextView) rootView.findViewById(R.id.detalhesMais);
        textElement.setText(animal.getAbout());

        textElement = (TextView) rootView.findViewById(R.id.exigencias_Adocao_text);
        String exigencias = "";
        if(animal.isObj_need()){

        }
        if(animal.isAdoption_term()){

        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //FirebaseAuth mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        final ImageButton fav_button = (ImageButton) rootView.findViewById(R.id.imageButtonFav);
        Query queryRef = databaseUsers.orderByChild("email");
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int animal_counter = 0;
                //animais.clear();
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
                                    if ((!animal.getAction_type().equals("para_apadrinhar"))&&(!animal.getAction_type().equals("para_apadrinhar_e_ajuda"))) continue;
                                    if (animal.isSponsored()) continue;
                                    if (animals == null) animals = new ArrayList<>();
                                    //animais.add(animal);
                                    //listAdapter.notifyDataSetChanged();
                                    animal_counter++;
                                    animals.add(animal);
//
//                                    ImageView imageViewAnimal = new ImageView(getActivity());
//                                    Picasso.with(getActivity())
//                                            .load(animal.getPicture())
//                                            .noFade().into(imageViewAnimal);
//
//
//                                    TextView name_text_view = new TextView(getActivity());
//                                    name_text_view.setPadding(0, 40, 0, 0);
//                                    name_text_view.setText("Nome do animal: " + animal.getName());
//                                    TextView age_text_view = new TextView(getActivity());
//                                    age_text_view.setText("Idade do animal: " + animal.getAge());
//                                    TextView gender_text_view = new TextView(getActivity());
//                                    gender_text_view.setText("Sexo do animal: " + animal.getGender());
//                                    TextView size_text_view = new TextView(getActivity());
//                                    size_text_view.setText("Tamanho do animal: " + animal.getSize());
//                                    Button sponsor_button = new Button(getActivity());
//                                    View.OnClickListener mOnClickListener = new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(final View view) {
//                                            sponsor_animal_for_current_user(view);
//                                        }
//                                    };
//
//                                    sponsor_button.setText("Apadrinhar");
//                                    sponsor_button.setTag(animal.getId());
//                                    sponsor_button.setOnClickListener(mOnClickListener);
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
//
//                                    container_aux.addView(imageViewAnimal);
//                                    container_aux.addView(name_text_view);
//                                    container_aux.addView(age_text_view);
//                                    container_aux.addView(gender_text_view);
//                                    container_aux.addView(size_text_view);
//                                    container_aux.addView(sponsor_button);
//                                    container_aux.addView(fav_button);

                                    View.OnClickListener mOnClickListenerFav = new View.OnClickListener() {
                                        @Override
                                        public void onClick(final View view) {
                                            fav_animal_for_current_user(view);
                                        }
                                    };
                                    fav_button.setOnClickListener(mOnClickListenerFav);
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




        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




//        textElement.setText(animal.getHealth());


        return rootView;
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
                            boolean is_already_a_favorite = false;
                            if (current_user.favorites == null)
                                current_user.favorites = new ArrayList<>();
                            for (Animal favorite_animal : current_user.favorites) {
                                if (favorite_animal.getId().equals(animal.getId())) {
                                    is_already_a_favorite = true;
                                }
                            }
                            if (is_already_a_favorite) {
                                Toast.makeText(getActivity(),
                                        "Animal Já é favorito!", Toast.LENGTH_SHORT).show();
                                continue;
                            }
                            current_user.favorites.add(animal);
                            db_user.getRef().child("favorites").setValue(current_user.getFavorites());
                            sponsored_animal_id = animal.getId();
                            Toast.makeText(getActivity(),
                                    "Animal Favoritado com sucesso!", Toast.LENGTH_SHORT).show();
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
