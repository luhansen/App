package com.jadilindo.meau.meau;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fragments.AtalhoAdotarFragment;
import fragments.AtalhoAjudarFragment;
import fragments.AtalhoApadrinharFragment;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth mAuth = null;
    private DatabaseReference mDatabase;

    private String[] alimentacaoNome = new String[]{"A importância de alimentar o pet com ração",
            "A importância de alimentar o pet com ração",
            "A importância de alimentar o pet com ração"};
    private String[] comportamentoNome = new String[]{"A importância de alimentar o pet com ração",
            "A importância de alimentar o pet com ração",
            "A importância de alimentar o pet com ração"};
    private String[] saudeNome = new String[]{"A importância de alimentar o pet com ração",
            "A importância de alimentar o pet com ração",
            "A importância de alimentar o pet com ração"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

//        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alimentacaoNome);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);


    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        TextView field = findViewById(R.id.login);
        if(field != null) {
            View.OnClickListener logoutListener = new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    mAuth.signOut();
                    goToRegister(view);
                }
            };
            View.OnClickListener loginListener = new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    goToRegister(view);
                }
            };
            if (currentUser != null) {
                field.setText("logout");
                field.setOnClickListener(logoutListener);
            } else {
                field.setText("login");
                field.setOnClickListener(loginListener);
            }
        }
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        View tool_bar = findViewById(R.id.maintoolbar);
        tool_bar.setVisibility(View.INVISIBLE);
        ActionBar actionBar = getActionBar();
        if(actionBar != null) actionBar.hide();
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

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {

        }
        View tool_bar = findViewById(R.id.maintoolbar);
        if(tool_bar!=null)tool_bar.setVisibility(View.VISIBLE);

        if (id == R.id.nav_perfil) {
            // Handle the camera action
            Toast.makeText(this,"pagina do perfil",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new PerfilFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.nav_pets) {
            Toast.makeText(this,"pagina dos pets",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new PetsFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.nav_home) {
            goToHome();

        } else if (id == R.id.nav_favoritos) {
            Toast.makeText(this,"pagina dos favoritos",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new FavoritosFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.nav_chat) {
            Toast.makeText(this,"Chat",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new ChatFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.atalhos_cadastrar) {
            Toast.makeText(this,"cadastrar",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                Intent intent = new Intent (this, RegisterAnimal.class);
                startActivity(intent);
            }

        } else if (id == R.id.atalhos_adotar) {
            Toast.makeText(this,"adotar",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new AtalhoAdotarFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.atalhos_ajudar) {
            Toast.makeText(this,"ajudar",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new AtalhoAjudarFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.atalhos_apadrinhar) {
            Toast.makeText(this,"apadrinhar",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new AtalhoApadrinharFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.nav_dicas) {
            Toast.makeText(this,"dicas",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new DicasFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.nav_eventos) {
            Toast.makeText(this,"eventos",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new EventosFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.nav_legislacao) {
            Toast.makeText(this,"legislação",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new LegislacaoFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.nav_termo) {
            Toast.makeText(this,"termos de adoção",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new TermoFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.nav_historias) {
            Toast.makeText(this,"histórias de adoção",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new HistoriasFragment()).addToBackStack( "tag" ).commit();
            }

        } else if (id == R.id.nav_privacidade) {
            Toast.makeText(this,"privacidade",Toast.LENGTH_SHORT).show();
            if(currentUser != null) {
                fm.beginTransaction().replace(R.id.ContentMainFrame, new PrivacidadeFragment()).addToBackStack( "tag" ).commit();
            }

        }

        if (currentUser == null){
            fm.beginTransaction().replace(R.id.ContentMainFrame, new NotLoginFragment()).addToBackStack( "tag" ).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
    public void goToRegister (View view){
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToSendTermoAdocao (View view){
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.ContentMainFrame, new SendTermFragment()).addToBackStack( "tag" ).commit();

    }
    public void goToSendTermoApadrinhamento (View view){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String email = (String)("mailto:" + currentUser.getEmail());
        String mailto = email +
                "?subject=" + "Termo de apadrinhamento" +
                "&body=" + getResources().getString(R.string.TextTermo);;

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));

            startActivity(emailIntent);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.ContentMainFrame, new SendTermFragment()).addToBackStack( "tag" ).commit();
    }

    public void goToLegislacao (View view){
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.ContentMainFrame, new LegislacaoFragment()).addToBackStack( "tag" ).commit();
    }

    public void goToHome (){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void adoptAnimal(View view){
        FragmentManager fm = getFragmentManager();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this,"adotar",Toast.LENGTH_SHORT).show();
        if(currentUser != null) {
            fm.beginTransaction().replace(R.id.ContentMainFrame, new AtalhoAdotarFragment()).addToBackStack( "tag" ).commit();
        }
    }

    public void registerAnimal(View view){

        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this,"cadastrar",Toast.LENGTH_SHORT).show();
        if(currentUser != null) {
            Intent intent = new Intent (this, RegisterAnimal.class);
            startActivity(intent);
        }
    }

    public void helpAnimal(View view){

        FragmentManager fm = getFragmentManager();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this,"ajudar",Toast.LENGTH_SHORT).show();
        if(currentUser != null) {
            fm.beginTransaction().replace(R.id.ContentMainFrame, new AtalhoAjudarFragment()).addToBackStack( "tag" ).commit();
        }
    }



}
