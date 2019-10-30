package com.example.myapplication;

import android.app.Dialog;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private static ArrayList<String> mNames = new ArrayList<>();
    private static ArrayList<String> mImageUrls = new ArrayList<>();
    private EditText edit;
    //UI

    private FloatingActionButton fab_main, fab1_mail, fab2_share;
    private Animation fab_open, fab_close, fab_clock, fab_anticlock;
    TextView textview_mail, textview_share;

    Boolean isOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        fab_main = findViewById(R.id.fab);
        fab1_mail = findViewById(R.id.fab1);
        fab2_share = findViewById(R.id.fab2);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock);
        fab_anticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anticlock);

        textview_mail = (TextView) findViewById(R.id.textview_mail);
        textview_share = (TextView) findViewById(R.id.textview_share);

        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen) {

                    textview_mail.startAnimation(fab_close);
                    textview_share.startAnimation(fab_close);
                    fab2_share.startAnimation(fab_close);
                    fab1_mail.startAnimation(fab_close);
                    fab_main.startAnimation(fab_anticlock);
                    fab2_share.setClickable(false);
                    fab1_mail.setClickable(false);
                    isOpen = false;
                } else {
                    textview_mail.startAnimation(fab_open);
                    textview_share.startAnimation(fab_open);
                    fab2_share.startAnimation(fab_open);
                    fab1_mail.startAnimation(fab_open);
                    fab_main.startAnimation(fab_clock);
                    fab2_share.setClickable(true);
                    fab1_mail.setClickable(true);
                    isOpen = true;
                }

            }
        });


        fab2_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textview_mail.startAnimation(fab_close);
                textview_share.startAnimation(fab_close);
                fab2_share.startAnimation(fab_close);
                fab1_mail.startAnimation(fab_close);
                fab_main.startAnimation(fab_anticlock);
                fab2_share.setClickable(false);
                fab1_mail.setClickable(false);
                isOpen = false;
            }
        });

        fab1_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textview_mail.startAnimation(fab_close);
                textview_share.startAnimation(fab_close);
                fab2_share.startAnimation(fab_close);
                fab1_mail.startAnimation(fab_close);
                fab_main.startAnimation(fab_anticlock);
                fab2_share.setClickable(false);
                fab1_mail.setClickable(false);
                isOpen = false;

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_dialog_layout);

                Button addButton = dialog.findViewById(R.id.puntualButton);
                edit = dialog.findViewById(R.id.puntualEdit);
                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(edit.getText().toString().isEmpty()){

                            edit.setHint("Por favor agregue un valor válido");
                            return;

                        }

                        mNames.add(edit.getText().toString());
                        initRecyclerView();
                        dialog.cancel();

                    }
                });

                dialog.show();


            }
        });

    }


    public void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}






















