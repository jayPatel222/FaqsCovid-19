package com.example.faqscovid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.arch.core.executor.TaskExecutor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class login extends AppCompatActivity {
     EditText phoneNumber;
     FirebaseAuth mAuth;
     String codeSent;
     FirebaseUser mFirebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        phoneNumber = findViewById(R.id.phoneNumber);

        mFirebaseUser = mAuth.getCurrentUser();
        if (mFirebaseUser != null) {
            Intent i = new Intent(login.this, MainActivity.class);
            startActivity(i);
        } else {
            System.out.println("Please login again");
        }

        findViewById(R.id.b_otp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              sendVerificationCode();
            }
        });
    }
    private void sendVerificationCode(){
        String number = phoneNumber.getText().toString();

        if (number.isEmpty()){
            phoneNumber.setError("Required");
            phoneNumber.requestFocus();
            return;
        }
        if (number.length() < 10){
            phoneNumber.setError("Not a valid number");
            phoneNumber.requestFocus();
            return;
        }



        PhoneAuthProvider.getInstance().verifyPhoneNumber(
               "+1" + number,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                TaskExecutors.MAIN_THREAD,               // Activity (for callback binding)
                mCallbacks);
        // OnVerificationStateChangedCallbacks
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            System.out.println(e.getMessage());
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeSent = s;
            Intent intent = new Intent(getBaseContext(), verification.class);
            intent.putExtra("code",codeSent);
            startActivity(intent);
        }
    };
}
