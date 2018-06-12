package com.jadilindo.meau.meau;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fragments.CadastrarAdocaoFragment;
import fragments.CadastrarAdotarAjudarFragment;
import fragments.CadastrarAjudarFragment;
import fragments.CadastrarApadrinharAjudarFragment;
import fragments.CadastrarApadrinharFragment;

public class RegisterAnimal extends AppCompatActivity {

    boolean flagb1=true, flagb2=false, flagb3=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
