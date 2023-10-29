package com.example.services_novigrad;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PageBienvenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagebienvenu);
        TextView tv = (TextView) findViewById(R.id.bienvenu);
        String username= getIntent().getStringExtra("USERNAME");
        String role= getIntent().getStringExtra("ROLE");
        tv.setText("Bienvenue "+ username + "! Vous êtes connecté en tant que "+ role);

    }
}
