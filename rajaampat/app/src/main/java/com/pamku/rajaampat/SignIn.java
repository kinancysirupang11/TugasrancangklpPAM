package com.pamku.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    private TextView signup;
    private Button login;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(SignIn.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_sign_in);
        user = (EditText) findViewById(R.id.editTextUname);
        pass = (EditText) findViewById(R.id.editTextPassword);
        login = findViewById(R.id.buttonLogin);
        signup = findViewById(R.id.regist);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, SignUp.class));
            }
        });

        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String email = user.getText().toString();
                        final String password = pass.getText().toString();
                        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                            Toast.makeText(SignIn.this, "Email/Password Tidak Boleh Kosong!!", Toast.LENGTH_LONG).show();
                            return;
                        }
                        mAuth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete( Task<AuthResult> task) {
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(SignIn.this, "Gagal Login", Toast.LENGTH_LONG).show();
                                        } else {
                                            Intent intent = new Intent(SignIn.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
                                });
                    }
                });

    }
}
