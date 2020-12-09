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
import android.widget.Toast;

import com.example.smartrack.R;
import com.example.smartrack.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class SigninPage extends AppCompatActivity {

    EditText name, surname, phone, mail, password;
    ProgressBar progressBar;
    Button btnSignin;

    FirebaseAuth mAuth;
    FirebaseDatabase rootDB;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_page);

        name = (EditText) findViewById(R.id.editTextPersonName);
        surname = (EditText) findViewById(R.id.editTextPersonSurname);
        phone = (EditText) findViewById(R.id.editTextPhone);
        mail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignin = findViewById(R.id.signinButton);

        mAuth = FirebaseAuth.getInstance();

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = name.getText().toString().trim();
                String strSurname = surname.getText().toString().trim();
                String strPhone = phone.getText().toString().trim();
                String strMail = mail.getText().toString().trim();
                String strPassword = password.getText().toString().trim();

                //Name check
                if (strName.isEmpty()) {
                    name.setError("Name is required");
                    name.requestFocus();
                    return;
                }

                if (strName.length() < 1) {
                    name.setError("Name Length should at least 2");
                    name.requestFocus();
                    return;
                }

                //Surname check
                if (strSurname.isEmpty()) {
                    surname.setError("Surname is required");
                    surname.requestFocus();
                    return;
                }

                if (strName.length() < 1) {
                    surname.setError("Surname Length should at least 1");
                    surname.requestFocus();
                    return;
                }

                //Phone check
                if (strPhone.isEmpty()) {
                    phone.setError("Phone number is required");
                    phone.requestFocus();
                    return;
                }

                if (strPhone.length() != 10) {
                    phone.setError("Phone number is 10 digit number");
                    phone.requestFocus();
                    return;
                }

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

                //register the user
                mAuth.createUserWithEmailAndPassword(strMail, strPassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SigninPage.this, "User Created", Toast.LENGTH_LONG).show();
                                    //put user in firebase DB
                                    rootDB=FirebaseDatabase.getInstance();
                                    mRef=rootDB.getReference("User");
                                    String id= mRef.push().getKey();
                                    User newUser=new User(id,strName,strSurname,strMail,strPhone,strPassword);
                                    mRef.child(id).setValue(newUser);
                                    Intent intent = new Intent(SigninPage.this, MainLandingPage.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(SigninPage.this, "Error" + task.getException(), Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);
                                }

                            }
                        });


            }

        });
    }
}






/*
String id= mRef.push().getKey();
User newUser=new User(id,strName,strSurname,strMail,strPhone,strPassword);
mRef.child(id).setValue(newUser);

public void verification (String id){
        Query checkUser= FirebaseDatabase.getInstance().getReference("user").orderByChild("id").equalTo(id);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Toast.makeText(SigninPage.this,"User alredy registre",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SigninPage.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
 */