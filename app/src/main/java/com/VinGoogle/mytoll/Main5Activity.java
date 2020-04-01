package com.VinGoogle.mytoll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {
   private WebView wv;
   private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        setTitle("Google Map");
        wv=(WebView)findViewById(R.id.wid);
        btn=(Button)findViewById(R.id.btn_back);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://www.google.co.in/maps/@21.1795968,72.798208,13z?hl=en");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Main5Activity.this,Main4Activity.class);
                startActivity(j);
                finish();
            }
        });

    }
}
