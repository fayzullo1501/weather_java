package com.example.weather_java;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.MenuItem;

import com.example.weather_java.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    ActivityMainBinding binding;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_home_page);

        int[] imageId = {R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,
                R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,};
        String[] name = {"Минск","Минск","Минск","Минск","Минск","Минск","Минск","Минск",};
        String[] slogan = {"+2, Влажно","+2, Влажно","+2, Влажно","+2, Влажно","+2, Влажно","+2, Влажно","+2, Влажно","+2, Влажно",};
        String[] lastMsg = {"15.03.2022","15.03.2022","15.03.2022","15.03.2022","15.03.2022","15.03.2022","15.03.2022","15.03.2022",};

        ArrayList<About> aboutArrayList = new ArrayList<>();

        for (int i = 0; i< imageId.length; i++){

            About about = new About(name[i], slogan[i], lastMsg[i], imageId[i]);
            aboutArrayList.add(about);
        }

        ListAdapter listAdapter = new ListAdapter(HomePage.this,aboutArrayList);




        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new Fragment1()).commit();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.item1:
                        fragment= new Fragment1();
                        break;
                    case R.id.item2:
                        fragment= new Fragment2();
                        break;
                    case R.id.item3:
                        fragment= new Fragment3();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });

    }
}