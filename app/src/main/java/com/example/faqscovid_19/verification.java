package com.example.faqscovid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class verification extends AppCompatActivity {
EditText code;
    FirebaseAuth  mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        findViewById(R.id.verifyOtp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifySignInCode();
            }
        });
    }

    private void verifySignInCode(){
        code = findViewById(R.id.otpVerify);
        String codeOtp = code.getText().toString();
        if (codeOtp.isEmpty()){
            code.setError("Required");
            code.requestFocus();
            return;
        }
        if (codeOtp.length() < 6){
            code.setError("Not a valid OTP");
            code.requestFocus();
            return;
        }

        Intent intent = getIntent();
        String coder = intent.getStringExtra("code");
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(coder,code.getText().toString());

        signInWithPhoneAuthCredential(credential);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(),"Failed try again !!",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getBaseContext(), login.class);
                            startActivity(intent);
                        }
                    }
                });
    }
}
