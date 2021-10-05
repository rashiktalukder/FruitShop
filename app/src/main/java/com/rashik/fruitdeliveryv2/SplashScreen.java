package com.rashik.fruitdeliveryv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        auth=FirebaseAuth.getInstance();
        user= auth.getCurrentUser();

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user!=null)
                {
                    startActivity(new Intent(SplashScreen.this,MainActivity.class));
                }
                else
                {
                    startActivity(new Intent(SplashScreen.this,LoginActivity.class));
                }


                finish();
            }
        },3000);

    }
}