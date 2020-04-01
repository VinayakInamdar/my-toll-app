package com.VinGoogle.mytoll;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    private EditText e1,e2,e3,e4,e5;
    private Button btn1,btninsert,btnretrieve;
    String url,source,destination,price,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setTitle("Toll Payment");

        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
        btn1=(Button)findViewById(R.id.btn_googlemaps);
        btninsert = (Button) findViewById(R.id.insert_b1_id);
        btnretrieve = (Button) findViewById(R.id.retrieve_b2_id);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main4Activity.this,Main5Activity.class);
                startActivity(intent);
                finish();
            }
        });
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                source = e1.getText().toString();
                destination = e2.getText().toString();
                price = e5.getText().toString();

                if (!source.isEmpty() && !destination.isEmpty() && !price.isEmpty()) {

                    url = "https://devolopers990.000webhostapp.com/insert1.php?source=" + source + "&destination=" + destination + "&price=" + price + "";
                    new insert().execute();
                } else {
                    Toast.makeText(Main4Activity.this, "Invalid Input...Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnretrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Main4Activity.this, Main6Activity.class);
                startActivity(i);

            }
        });
    }
    private class insert extends AsyncTask<Void, Void, Void> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(Main4Activity.this);
            pd.setTitle("Inserting Data");
            pd.setMessage("Please Wait...");
            pd.setIndeterminate(false);///
            pd.setCancelable(true);
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            json j = new json();
            result = j.insert(url);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (pd.isShowing()) {
                pd.dismiss();
            }
            Toast.makeText(Main4Activity.this, result, Toast.LENGTH_SHORT).show();
        }

    }
}

