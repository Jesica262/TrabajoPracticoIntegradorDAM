package com.example.myarbolito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        FragmentManager fragm =getSupportFragmentManager();
        FragmentMenu fragmentMenu=new FragmentMenu();
        fragm.beginTransaction().replace(R.id.contenido,fragmentMenu).addToBackStack(null).commit();
    }
}