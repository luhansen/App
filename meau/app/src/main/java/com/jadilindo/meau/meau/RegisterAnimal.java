package com.jadilindo.meau.meau;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import fragments.CadastrarAdocaoFragment;
import fragments.CadastrarAdotarAjudarFragment;
import fragments.CadastrarAjudarFragment;
import fragments.CadastrarApadrinharAjudarFragment;
import fragments.CadastrarApadrinharFragment;

public class RegisterAnimal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_animal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    boolean flagb1=false, flagb2=false, flagb3=false;
    public void startRegisterAnimalForm(View view){
        Button b1, b2, b3;
        b1 = (Button) findViewById(R.id.button_adocao);
        b2 = (Button) findViewById(R.id.button_apadrinhar);
        b3 = (Button) findViewById(R.id.button_ajudar);
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
            b1.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            b2.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b3.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarAdotarAjudarFragment()).commit();
        }
        else if (flagb2 && flagb3){
            b1.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b2.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            b3.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarApadrinharAjudarFragment()).commit();

        }
        else if (flagb1){
            b1.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            b2.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b3.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarAdocaoFragment()).commit();
        }
        else if (flagb2){
            b1.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b2.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            b3.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarApadrinharFragment()).commit();
        }
        else if (flagb3){
            b1.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b2.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b3.setBackgroundColor(getResources().getColor(R.color.BackColorYellowButton));
            fm.beginTransaction().replace(R.id.cadastrar_fragment, new CadastrarAjudarFragment()).commit();
        }
        else {
            b1.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b2.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
            b3.setBackgroundColor(getResources().getColor(R.color.UnselectButton));
        }



    }
}
