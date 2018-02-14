package com.home.apostasjl.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.home.apostasjl.R;

/**
 * Created by Tuca on 13/01/2018.
 */

public class ActSplashScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        mostrarLogin();
    }

    private void mostrarLogin() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        Intent intent = new Intent(ActSplashScreen.this,
                ActMainV.class);
        startActivity(intent);




        finish();
    }

}
