package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

/**
 * Created by pedro on 09/05/18.
 */

public class FavoritosFragment extends Fragment {
    public DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mDatabase;
    public User user;
    public LinearLayout container_aux;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_favoritos, container, false);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        container_aux = rootView.findViewById(R.id.container_layout);
        //Saving the User
        Query queryRef = databaseUsers.orderByChild("email").equalTo(currentUser.getEmail());
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot db_user : dataSnapshot.getChildren()) {
                        user = db_user.getValue(User.class);
                        if (user != null) {
                            if((user.getFavorites() == null) || (user.getFavorites().size() == 0)){
                                TextView warning = new TextView(getActivity());
                                warning.setText("Nenhum animal");
                                container_aux.addView(warning);
                            }else {
                                for (Animal animal : user.getFavorites()) {
                                    ImageView imageElement = (ImageView) rootView.findViewById(R.id.image_pet);
                                    if (animal == null) continue;
//                                    ImageView imageViewAnimal = new ImageView(getActivity());
                                    Picasso.with(getActivity())
                                            .load(animal.getPicture())
                                            .noFade().into(imageElement);

//                                    Bitmap myBitmap = BitmapFactory.decodeFile(animal.getPicture());
//                                    File imgFile = new File(animal.getPicture());
//                                    imageElement.set
//                                    imageElement.setImageURI(Uri.fromFile(imgFile));

//                                    Picasso.with(getActivity()).loa

                                    TextView textElement = (TextView) rootView.findViewById(R.id.name_pet);
                                    textElement.setText(animal.getName());
                                    textElement = (TextView) rootView.findViewById(R.id.idade_pet);
                                    textElement.setText(animal.getAge());
                                    textElement = (TextView) rootView.findViewById(R.id.sexo_pet);
                                    textElement.setText(animal.getGender());
                                    textElement = (TextView) rootView.findViewById(R.id.tamanho_pet);
                                    textElement.setText(animal.getSize());
                                    textElement = (TextView) rootView.findViewById(R.id.localizacao_pet);
                                    textElement.setText("vazio");

//                                    TextView name_text_view = new TextView(getActivity());
//                                    name_text_view.setPadding(0, 40, 0, 0);
//                                    name_text_view.setText("Nome do animal: " + animal.getName());
//                                    TextView age_text_view = new TextView(getActivity());
//                                    age_text_view.setText("Idade do animal: " + animal.getAge());
//                                    TextView gender_text_view = new TextView(getActivity());
//                                    gender_text_view.setText("Sexo do animal: " + animal.getGender());
//                                    TextView size_text_view = new TextView(getActivity());
//                                    size_text_view.setText("Tamanho do animal: " + animal.getSize());
//                                    container_aux.addView(imageViewAnimal);
//                                    container_aux.addView(name_text_view);
//                                    container_aux.addView(age_text_view);
//                                    container_aux.addView(gender_text_view);
//                                    container_aux.addView(size_text_view);
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
        return rootView;
    }
}
