package com.jadilindo.meau.meau;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

import fragments.CadastrarAdocaoFragment;
import fragments.CadastrarAdotarAjudarFragment;
import fragments.CadastrarAjudarFragment;
import fragments.CadastrarApadrinharAjudarFragment;
import fragments.CadastrarApadrinharFragment;

public class RegisterAnimal extends AppCompatActivity {

    boolean flagb1=true, flagb2=false, flagb3=false;
    private FirebaseAuth mAuth = null;
    public User user;
    public String species;
    public String gender;
    public String size;
    public String age;
    public Animal animal;
    public DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_register_animal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button b1, b2, b3, buttonCadastro;

        b1 = (Button) findViewById(R.id.button_adocao);
        b2 = (Button) findViewById(R.id.button_apadrinhar);
        b3 = (Button) findViewById(R.id.button_ajudar);
        FragmentManager fm = getFragmentManager();

        b1.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
        b2.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
        b3.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
        fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarAdocaoFragment()).commit();
        buttonCadastro = (Button) findViewById(R.id.button_cadastrar_animal);
        buttonCadastro.setText("COLOCAR PARA ADOÇÃO");

    }


    public void startRegisterAnimalForm(View view){
        Button b1, b2, b3, buttonCadastro;
        b1 = (Button) findViewById(R.id.button_adocao);
        b2 = (Button) findViewById(R.id.button_apadrinhar);
        b3 = (Button) findViewById(R.id.button_ajudar);
        buttonCadastro = (Button) findViewById(R.id.button_cadastrar_animal);
        FragmentManager fm = getFragmentManager();
        if (view == b1){
            flagb1 = !flagb1; //swich falg value
            flagb2 = false;
        }
        if (view ==b2){
            flagb2 = !flagb2;
            flagb1 = false;
        }
        if (view == b3){
            flagb3 = !flagb3;
        }

        if(flagb1 && flagb3){
            TextView T = (TextView) findViewById(R.id.cadastro_titulo);
            T.setText("ADOÇÃO");
            b1.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            b2.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b3.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarAdotarAjudarFragment()).commit();
            buttonCadastro.setText("COLOCAR PARA ADOÇÃO");
        }
        else if (flagb2 && flagb3){
            TextView T = (TextView) findViewById(R.id.cadastro_titulo);
            T.setText("APADRINHAR");
            b1.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b2.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            b3.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarApadrinharAjudarFragment()).commit();
            buttonCadastro.setText("PROCURAR PADRINHO");

        }
        else if (flagb1){
            TextView T = (TextView) findViewById(R.id.cadastro_titulo);
            T.setText("ADOÇÃO");
            b1.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            b2.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b3.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarAdocaoFragment()).commit();
            buttonCadastro.setText("COLOCAR PARA ADOÇÃO");
        }
        else if (flagb2){
            TextView T = (TextView) findViewById(R.id.cadastro_titulo);
            T.setText("APADRINHAR");
            b1.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b2.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            b3.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarApadrinharFragment()).commit();
            buttonCadastro.setText("PROCURAR PADRINHO");
        }
        else if (flagb3){
            TextView T = (TextView) findViewById(R.id.cadastro_titulo);
            T.setText("AJUDAR");
            b1.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b2.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b3.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarAjudarFragment()).commit();
            buttonCadastro.setText("PROCURAR AJUDA");

        }
        else {
//            b1.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
//            b2.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
//            b3.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
        }



    }


    public void addAnimal(View view) {
        FirebaseUser currentUser = mAuth.getCurrentUser();


        RadioGroup aux;

        //getting the values to save
        String name = ((EditText)findViewById(R.id.nome_do_animal)).getText().toString().trim();
        int selectedId = ((RadioGroup)findViewById(R.id.radio_especie)).getCheckedRadioButtonId();
        if (selectedId > 0) {
            // find the radiobutton by returned id
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            species = radioButton.getText().toString();
//            Toast.makeText(RegisterAnimal.this,
//                    species, Toast.LENGTH_SHORT).show();
        }
        selectedId = ((RadioGroup)findViewById(R.id.radio_idade)).getCheckedRadioButtonId();
        if (selectedId > 0) {
            // find the radiobutton by returned id
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            age = radioButton.getText().toString();
        }
        selectedId = ((RadioGroup)findViewById(R.id.radio_porte)).getCheckedRadioButtonId();
        if (selectedId > 0) {
            // find the radiobutton by returned id
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            size = radioButton.getText().toString();
        }
        selectedId = ((RadioGroup)findViewById(R.id.radio_sexo)).getCheckedRadioButtonId();
        if (selectedId > 0) {
            // find the radiobutton by returned id
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            gender = radioButton.getText().toString();
        }
        ArrayList<String> temper = new ArrayList<>();
        if (((CheckBox)findViewById(R.id.checkbox_temperamento_amoroso)).isChecked()) temper.add("amoroso");
        if (((CheckBox)findViewById(R.id.checkbox_temperamento_brincalhao)).isChecked()) temper.add("brincalhao");
        if (((CheckBox)findViewById(R.id.checkbox_temperamento_calmo)).isChecked()) temper.add("calmo");
        if (((CheckBox)findViewById(R.id.checkbox_temperamento_guarda)).isChecked()) temper.add("guarda");
        if (((CheckBox)findViewById(R.id.checkbox_temperamento_preguicoso)).isChecked()) temper.add("preguicoso");
        if (((CheckBox)findViewById(R.id.checkbox_temperamento_timido)).isChecked()) temper.add("timido");
        ArrayList<String> health = new ArrayList<>();
        if (((CheckBox)findViewById(R.id.checkbox_saude_doente)).isChecked()) health.add("doente");
        if (((CheckBox)findViewById(R.id.checkbox_saude_vermifugado)).isChecked()) health.add("vermifugado");
        if (((CheckBox)findViewById(R.id.checkbox_saude_castrado)).isChecked()) health.add("castrado");
        if (((CheckBox)findViewById(R.id.checkbox_saude_vacinado)).isChecked()) health.add("vacinado");
        String desease = ((EditText)findViewById(R.id.detalhes_doencas)).getText().toString().trim();
        String about = ((EditText)findViewById(R.id.compartilhe_historia)).getText().toString().trim();
        boolean adoption_term = ((CheckBox)findViewById(R.id.checkbox_termo_adocao)).isChecked();
        boolean pictures_of_house = ((CheckBox)findViewById(R.id.checkbox_fotos_casa_adocao)).isChecked();
        boolean previous_visit = ((CheckBox)findViewById(R.id.checkbox_visita_previa_adocao)).isChecked();
        boolean supervision_1month = ((CheckBox)findViewById(R.id.checkbox_acompanhamento_1_mes)).isChecked();
        boolean supervision_3months = ((CheckBox)findViewById(R.id.checkbox_acompanhamento_3_meses)).isChecked();
        boolean supervision_6months = ((CheckBox)findViewById(R.id.checkbox_acompanhamento_6_meses)).isChecked();



        //checking if the value is provided
        if (!TextUtils.isEmpty(name) &&
            !TextUtils.isEmpty(species) &&
            !TextUtils.isEmpty(gender) &&
            !TextUtils.isEmpty(size) &&
            !TextUtils.isEmpty(age)) {
            //creating an User Object
            String id = databaseUsers.push().getKey();
            String type;
            if (flagb1 && flagb3) type = "para_adocao";
            else if (flagb2 && flagb3) type = "para_apadrinhar";
            else if (flagb1) type = "para_adocao";
            else if (flagb2) type = "para_apadrinhar";
            else if (flagb3) type = "para_ajudar";
            else type = "para_adocao";
            animal = new Animal(
                    id,
                    name,
                    species,
                    gender,
                    size,
                    age,
                    temper,
                    health,
                    desease,
                    about,
                    adoption_term,
                    pictures_of_house,
                    previous_visit,
                    supervision_1month,
                    supervision_3months,
                    supervision_6months,
                    type
            );

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
                                db_user.getRef().removeValue();
                                if (user.owns == null) user.owns = new ArrayList<>();
                                user.owns.add(animal);
                                String user_id = databaseUsers.push().getKey();
                                databaseUsers.child(user_id).setValue(user);
                                Toast.makeText(RegisterAnimal.this,
                                "Animal Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Por favor coloque todos os campos", Toast.LENGTH_LONG).show();
        }
    }

    private void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    private void updateUI() {
        goToMainActivity();
    }

    public void goToMainActivity (){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

}
