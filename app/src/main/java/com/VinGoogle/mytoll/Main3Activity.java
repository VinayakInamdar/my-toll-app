package com.VinGoogle.mytoll;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button paytoll,faqs,settings,aboutus,logout;
    public static final String PREFS_NAME = "Preference";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("Home Page");

        paytoll=(Button)findViewById(R.id.btn_paytoll);
        faqs=(Button)findViewById(R.id.btn_faqs);
        settings=(Button)findViewById(R.id.btn_settings);
        aboutus=(Button)findViewById(R.id.btn_aboutus);
        logout=(Button)findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();

                editor.remove("username").apply();

                Intent j=new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(j);
                finish();
            }
        });

        paytoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main3Activity.this, "opening pay toll page", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(i);
                finish();
            }
        });

        faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(Main3Activity.this,FaqActivity.class);
                startActivity(k);
                finish();
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(Main3Activity.this,Aboutus_Activity.class);
                startActivity(b);
                finish();

            }
        });
    }
}
