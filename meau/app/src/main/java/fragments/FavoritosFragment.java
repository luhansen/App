package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.jadilindo.meau.meau.ListAdapter;
import com.jadilindo.meau.meau.R;
import com.jadilindo.meau.meau.User;

import java.util.ArrayList;

//import android.widget.ListAdapter;

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

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.listRecycleView);
        final ArrayList<Animal> animais = new ArrayList<>();
        final ListAdapter listAdapter = new ListAdapter(animais, 0);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        container_aux = rootView.findViewById(R.id.container_layout);
        //Saving the User
        Query queryRef = databaseUsers.orderByChild("email").equalTo(currentUser.getEmail());
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            public Animal[] animalString = new Animal[user.getFavorites().size()];
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
                                int i =0;
                                animais.clear();
                                animais.addAll(user.getFavorites());

                                listAdapter.notifyDataSetChanged();
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
