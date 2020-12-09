package com.example.smartrack.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartrack.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    EditText mail,password;
    TextView newUserText;
    ProgressBar progressBar;
    Button btnLogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mail = (EditText) findViewById(R.id.edit_email);
        password = (EditText) findViewById(R.id.edit_password);
        progressBar = (ProgressBar) findViewById(R.id.loginProgressBar);
        btnLogin = findViewById(R.id.loginButton);
        newUserText=findViewById(R.id.new_user);

        mAuth = FirebaseAuth.getInstance();

        newUserText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, SigninPage.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strMail = mail.getText().toString().trim();
                String strPassword = password.getText().toString().trim();

                //Mail check
                if (strMail.isEmpty()) {
                    mail.setError("Mail is required");
                    mail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(strMail).matches()) {
                    mail.setError("Please enter a valid mail");
                    mail.requestFocus();
                    return;
                }

                //Pass check
                if (strPassword.isEmpty()) {
                    password.setError("Password is required");
                    password.requestFocus();
                    return;
                }

                if (strPassword.length() < 6) {
                    password.setError("Password Must be 6 Characters");
                    password.requestFocus();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Authenticate user
                mAuth.signInWithEmailAndPassword(strMail,strPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginPage.this,"Logged in Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainLandingPage.class));
                            finish();
                        }else{
                            Toast.makeText(LoginPage.this, "Error"+task.getException(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });




    }
}