package com.example.gatheringapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ChaletAdaptor extends ArrayAdapter<Chalet>{
 Context context;
 int resource;

    public ChaletAdaptor(@NonNull Context context, int resource, @NonNull List<Chalet> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource , parent , false);
         // conertview to help when scroll down list
        TextView name =(TextView) convertView.findViewById(R.id.Name1);
        TextView phone =(TextView) convertView.findViewById(R.id.phone1);

        Chalet currentChalet = getItem(position);

       name.setText(currentChalet.getChalet_name());
       phone.setText(String.valueOf(currentChalet.getChalet_price()));
        return convertView;
    }
}
