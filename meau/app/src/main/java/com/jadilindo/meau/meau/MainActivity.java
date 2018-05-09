package com.jadilindo.meau.meau;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

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
import fragments.PerfilFragment;
import fragments.PetsFragment;
import fragments.PrivacidadeFragment;
import fragments.TermoFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.ContentMainFrame, new MainFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fm = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_perfil) {
            // Handle the camera action
            fm.beginTransaction().replace(R.id.ContentMainFrame, new PerfilFragment()).commit();
            Toast.makeText(this,"pagina do perfil",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_pets) {
            Toast.makeText(this,"pagina dos pets",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new PetsFragment()).commit();
        } else if (id == R.id.nav_favoritos) {
            Toast.makeText(this,"pagina dos favoritos",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new FavoritosFragment()).commit();
        } else if (id == R.id.nav_chat) {
            Toast.makeText(this,"Chat",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new ChatFragment()).commit();
        } else if (id == R.id.atalhos_cadastrar) {
            Toast.makeText(this,"cadastrar",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new AtalhoCadastrarFragment()).commit();
        } else if (id == R.id.atalhos_adotar) {
            Toast.makeText(this,"adotar",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new AtalhoAdotarFragment()).commit();
        } else if (id == R.id.atalhos_ajudar) {
            Toast.makeText(this,"ajudar",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new AtalhoAjudarFragment()).commit();
        } else if (id == R.id.atalhos_apadrinhar) {
            Toast.makeText(this,"apadrinhar",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new AtalhoApadrinharFragment()).commit();
        } else if (id == R.id.nav_dicas) {
            Toast.makeText(this,"dicas",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new DicasFragment()).commit();
        } else if (id == R.id.nav_eventos) {
            Toast.makeText(this,"eventos",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new EventosFragment()).commit();
        } else if (id == R.id.nav_legislacao) {
            Toast.makeText(this,"legislação",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new LegislacaoFragment()).commit();
        } else if (id == R.id.nav_termo) {
            Toast.makeText(this,"termos de adoção",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new TermoFragment()).commit();
        } else if (id == R.id.nav_historias) {
            Toast.makeText(this,"histórias de adoção",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new HistoriasFragment()).commit();
        } else if (id == R.id.nav_privacidade) {
            Toast.makeText(this,"privacidade",Toast.LENGTH_SHORT).show();
            fm.beginTransaction().replace(R.id.ContentMainFrame, new PrivacidadeFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
    public void goToRegister (View view){
        Intent intent = new Intent (this, RegisterUser.class);
        startActivity(intent);
    }
}
