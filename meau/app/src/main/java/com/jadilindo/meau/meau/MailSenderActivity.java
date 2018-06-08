package com.jadilindo.meau.meau;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import fragments.AtalhoAdotarFragment;
import fragments.AtalhoAjudarFragment;
import fragments.AtalhoApadrinharFragment;
import fragments.AtalhoCadastrarFragment;
import fragments.ChatFragment;
import fragments.DicasFragment;
import fragments.EventosFragment;
import fragments.FavoritosFragment;
import fragments.HistoriasFragment;
import fragments.LegislacaoFragment;
import fragments.MainFragment;
import fragments.NotLoginFragment;
import fragments.PerfilFragment;
import fragments.PetsFragment;
import fragments.PrivacidadeFragment;
import fragments.SendTermFragment;
import fragments.TermoFragment;

//
//public class MailSenderActivity extends Activity {
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        final Button send = (Button) this.findViewById(R.id.send);
//        send.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                try {
//                    GMailSender sender = new GMailSender("username@gmail.com", "password");
//                    sender.sendMail("This is Subject",
//                            "This is Body",
//                            "user@gmail.com",
//                            "user@yahoo.com");
//                } catch (Exception e) {
//                    Log.e("SendMail", e.getMessage(), e);
//                }
//
//            }
//        });
//
//    }
//}