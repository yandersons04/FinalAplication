package com.finalaplication.tecinfo.finalaplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationview = findViewById(R.id.nav_view);
        navigationview.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed(){
        DrawerLayout drawerLayout = findViewById(R.id.nav_view);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings){
            Toast.makeText(getApplicationContext(), "Minhas Consigurações", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        if (id == R.id.configuracao) {
            Toast.makeText(getApplicationContext(), "Abrir Configurações", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.calcularmedia) {

            Intent intent = new Intent(MainActivity.this, CalculadoraMedia.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(), "Abrir Calcular Média", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.calculadora) {

            Intent intent = new Intent(MainActivity.this, Calculadora.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(), "Abrir Calculadora", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.chamadaFalsa) {

            Intent intent = new Intent(MainActivity.this, ChamadaFalsa.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(), "Abrir Chamada Falsa", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.perfil) {
            Toast.makeText(getApplicationContext(), "Abrir Perfil", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}
