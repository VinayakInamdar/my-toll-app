package com.VinGoogle.mytoll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<pojo> list;

    public CustomAdapter(Context context, ArrayList<pojo> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View v=inflater.inflate(R.layout.look,null);

        TextView id = (TextView)v.findViewById(R.id.t1);
        TextView source = (TextView)v.findViewById(R.id.t2);
        TextView destination = (TextView)v.findViewById(R.id.t3);
        TextView price = (TextView)v.findViewById(R.id.t4);

        pojo p = (pojo)list.get(position);

        id.setText("Id : "+p.getId());
        source.setText("Source : "+p.getSource());
        destination.setText("Destination : "+p.getDestination());
        price.setText("Price : "+p.getPrice());
        return v;
    }
}
