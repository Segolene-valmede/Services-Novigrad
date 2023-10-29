package com.example.services_novigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText username, password, email, rights;
    Button signUp;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username =(EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);
        rights = (EditText)findViewById(R.id.rights);

        signUp = (Button) findViewById(R.id.btnsignup);

        myDB = new DBHelper(this);

    signUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String utilisateur = username.getText().toString();
            String motdepasse = password.getText().toString();
            String mail = email.getText().toString();
            String droit = rights.getText().toString();

            Boolean nouveau_util = myDB.checkusername(utilisateur);

            if(utilisateur.equals("")|| motdepasse.equals("")|| mail.equals("")){
                Toast.makeText(SignUpActivity.this, "Please fill all the fields.", Toast.LENGTH_SHORT).show();
            } else if (!(mail.contains("@")&mail.contains(".com"))) {
                Toast.makeText(SignUpActivity.this, "Please enter a valid mail.", Toast.LENGTH_SHORT).show();
            } else if((!droit.equals("Admin"))&& (!droit.equals("Employee")) && (!droit.equals("Client"))){
                Toast.makeText(SignUpActivity.this, "Please choose one of the roles.", Toast.LENGTH_SHORT).show();
            } else{
                if(!nouveau_util){
                    Boolean reussi = myDB.insertData(utilisateur, motdepasse, mail, droit);
                    if(reussi){
                        Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SignUpActivity.this, "Registration Failed, please retry.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignUpActivity.this, "Username already exists, please try another one.", Toast.LENGTH_SHORT).show();
                }
            }

        }
    });




    }

}