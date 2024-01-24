package com.cursoandroid.appatmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_servicos,R.id.nav_clientes,  R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){
        //Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse("tel:0119763486"));
        //String imagem = "https://ichef.bbci.co.uk/news/640/cpsprodpb/cffb/live/f5d7e3a0-b770-11ed-89f4-f3657d2bfa3b.jpg";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra( Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"} ); // passando o dado
        intent.putExtra( Intent.EXTRA_SUBJECT, "Contato pelo App" ); // assunto do email
        intent.putExtra( Intent.EXTRA_TEXT, "Mensagem automatica aqui"); // corpo da mensagem

        intent.setType("message/rfc822"); // tipo de dado para envio de email
        startActivity(Intent.createChooser(intent,"compartilhar")); // escolhe o app apartir de uma intent
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
