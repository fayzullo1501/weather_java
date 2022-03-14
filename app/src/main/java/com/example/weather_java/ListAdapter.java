package com.example.weather_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter <About> {


    public ListAdapter(Context context, ArrayList<About> aboutArrayList){

        super(context,R.layout.home,aboutArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        About about = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.home,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.cityimg);
        TextView cityName = convertView.findViewById(R.id.cityname);
        TextView lastMsg = convertView.findViewById(R.id.slogan);
        TextView time = convertView.findViewById(R.id.msgtime);


        imageView.setImageResource(about.imageId);
        cityName.setText(about.name);
        lastMsg.setText(about.slogan);
        time.setText(about.lastMessage);
        return convertView;
    }
}
