package com.example.services_novigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSignUp, buttonSignin;
    EditText username, password;
    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);


        myDB = new DBHelper(this);

        buttonSignUp=(Button) findViewById(R.id.buttonCreateAccount);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpActivity();
            }
        });

        buttonSignin = (Button) findViewById(R.id.buttonSignIn);

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String utilisateur = username.getText().toString();
                String motdepasse = password.getText().toString();
                if(utilisateur.equals("")|| motdepasse.equals("")){
                    Toast.makeText(MainActivity.this, "Please fill all the fields.", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean reussi = myDB.checkusernamePassword(utilisateur,motdepasse);
                    if(reussi){
                        String role = myDB.getRole(utilisateur);
                        openSignInActivity(utilisateur, role);
                    }else{
                        Toast.makeText(MainActivity.this, "Username and/or password not correct, please try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }



    public void openSignUpActivity(){
        Intent intent=new Intent(this, SignUpActivity.class);
        startActivity(intent);

    }
    public void openSignInActivity(String username, String role){
        Intent intent=new Intent(this, PageBienvenu.class);
        intent.putExtra("USERNAME", username);
        intent.putExtra("ROLE", role);
        startActivity(intent);

    }
}