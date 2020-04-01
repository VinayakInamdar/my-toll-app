package com.VinGoogle.mytoll;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.VinGoogle.mytoll.R;

public class Main2Activity extends AppCompatActivity {
    public static final String PREFS_NAME = "Preference";


    EditText edtun,edtpass;
    Button btnlogin;
    String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Login Page");

        edtpass=(EditText)findViewById(R.id.edt_pass);
        edtun=(EditText)findViewById(R.id.edt_un);
        btnlogin=(Button)findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                user =edtun.getText().toString().trim();
                pass =edtpass.getText().toString().trim();
                if (user.length() == 0) {
                    ((EditText) findViewById(R.id.edt_un)).setError("Enter Username");
                    return;
                }
                if (pass.length() == 0) {
                    ((EditText) findViewById(R.id.edt_pass)).setError("Enter Password");
                    return;
                }
                else if(user.equals("vinayak")&&pass.equals("1234")){

                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("username", user).apply();

                    Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                    startActivity(i);
                    finish();
                }
    }
});
    }}