package com.pamku.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    FirebaseAuth RegistAuth;
    EditText user2, pass2;
    Button regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        RegistAuth = FirebaseAuth.getInstance();
        user2 = findViewById(R.id.editTextUname);
        pass2 = findViewById(R.id.editTextPassword);
        regist = findViewById(R.id.buttonLogin);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = user2.getText().toString().trim();
                String pass = pass2.getText().toString().trim();
                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(SignUp.this, "Email/Password Tidak Boleh Kosong!!", Toast.LENGTH_LONG).show();
                    return;
                }
                RegistAuth.createUserWithEmailAndPassword(user, pass)
                        .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete( Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignUp.this, "Gagal Register " + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(SignUp.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });

    }
}
