package com.example.myapplication.graph;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerViewAdapter;
import com.example.myapplication.structures.EquationHolder;
import com.example.myapplication.structures.ValHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class EquationActivity extends AppCompatActivity {

    ArrayList<EquationHolder> equationHolders;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("EquationView", "starting equation view");

        setContentView(R.layout.equation_main);
        Intent intent = getIntent();
        String values = intent.getStringExtra("equations");
        Log.d("EquationActivity", values);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<EquationHolder>>(){}.getType();
        equationHolders = gson.fromJson(values, type);

        Log.d("EquationActivity", equationHolders.get(0).getEquation());

        initRecyclerView();

    }

    public void initRecyclerView(){
        Log.d("Equation Activity", "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        EquationViewAdapter adapter = new EquationViewAdapter(this, equationHolders);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
