package com.eh.paraparbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.eh.paraparbd.login.MainActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle("");
        setContentView(R.layout.activity_splash_screen);

		//This handler works for Splash screen.
		int SPLASH_TIME_OUT = 2000;
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
				startActivity(homeIntent);
				finish();
			}
		}, SPLASH_TIME_OUT);
    }
}
