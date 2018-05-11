package com.jadilindo.meau.meau;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterUser extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    boolean logged_in = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

    }

    public void addUser(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //getting the values to save
        String name = ((EditText)findViewById(R.id.name)).getText().toString().trim();
        String age = ((EditText)findViewById(R.id.age)).getText().toString().trim();
        String user_name = ((EditText)findViewById(R.id.user_name)).getText().toString().trim();
        String user_email = ((EditText)findViewById(R.id.user_email)).getText().toString().trim();
        String user_password = ((EditText)findViewById(R.id.user_password)).getText().toString().trim();
        String phone_number = ((EditText)findViewById(R.id.phone_number)).getText().toString().trim();
        String address = ((EditText)findViewById(R.id.address)).getText().toString().trim();
        DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name) &&
                !TextUtils.isEmpty(age) &&
                !TextUtils.isEmpty(user_name) &&
                !TextUtils.isEmpty(user_email) &&
                !TextUtils.isEmpty(user_password) &&
                !TextUtils.isEmpty(phone_number) &&
                !TextUtils.isEmpty(address) ) {


            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our User
            String id = databaseUsers.push().getKey();
            //creating an User Object
            User user = new User(   name,
                                    age,
                                    user_name,
                                    user_email,
                                    user_password,
                                    "-",
                                    address,
                                    phone_number,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null);

            //Saving the User
            databaseUsers.child(id).setValue(user);
            mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(user_email, user_password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI();
                            }
                        }
                    });
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Por favor coloque todos os campos", Toast.LENGTH_LONG).show();
        }
    }

    private void updateUI() {
        goToMainActivity();
    }

    public void goToMainActivity (){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
    public void goToLoginActivity (){
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent);
    }
}
