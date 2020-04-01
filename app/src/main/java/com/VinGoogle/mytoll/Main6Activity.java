package com.VinGoogle.mytoll;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {

    ListView lv;
    String url, result;
    ArrayList<pojo> list;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        setTitle("Toll payment Bill");

        lv = (ListView)findViewById(R.id.l1_id);

        url = "https://devolopers990.000webhostapp.com/retrieve1.php";

        new retrieve1().execute();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private class retrieve1 extends AsyncTask<Void, Void, Void> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(Main6Activity.this);
            pd.setTitle("Retrieving Data");
            pd.setMessage("Please Wait....");
            pd.setIndeterminate(false);
            pd.setCancelable(true);
            pd.show();
        }


        @Override
        protected Void doInBackground(Void... voids) {

            json o = new json();
            result = o.insert(url);
            list = new ArrayList<>();

            try {
                JSONObject jo = new JSONObject(result);
                JSONArray ja = jo.getJSONArray("data");
                for (int a = 0; a < ja.length(); a++) {
                    JSONObject jo1 = ja.getJSONObject(a);

                    pojo p = new pojo();

                    p.setId(jo1.getString("ID"));
                    p.setSource(jo1.getString("source"));
                    p.setDestination(jo1.getString("destination"));
                    p.setPrice(jo1.getString("price"));


                    list.add(p);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            CustomAdapter adp = new CustomAdapter(Main6Activity.this, list);

            lv.setAdapter(adp);

            if (pd.isShowing()) {
                pd.dismiss();
                //Toast.makeText(RetrieveActivity.this, "\n"+str, Toast.LENGTH_SHORT).show();
            }
        }

    }
}
