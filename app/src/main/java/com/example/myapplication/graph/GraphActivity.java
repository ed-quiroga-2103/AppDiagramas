package com.example.myapplication.graph;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.structures.ValHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    private static final String TAG = "GraphActivity";


    String equations = "";

    double xMax = 0;
    double xMin = 0;
    double yMax = 0;
    double yMin = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_activity_layout);


        Intent intent = getIntent();
        String values = intent.getStringExtra("values");
        equations = intent.getStringExtra("equations");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ValHolder>>(){}.getType();
        ArrayList<ValHolder> ValHolders = gson.fromJson(values, type);

        Log.d(TAG, equations);



        LineGraphSeries <DataPoint> series = new LineGraphSeries<>();

        Log.d(TAG, "holders retrieved");

        for (ValHolder valHolder: ValHolders) {

            Double x = valHolder.getPos();
            Double y = valHolder.getVal();

            Log.d(TAG, "Value X: " + x.toString());
            Log.d(TAG, "Value Y: " + y.toString());


            if(y > yMax) yMax = y;
            if(y < yMin) yMin = y;
            if(x > xMax) xMax = x;
            if(x < xMin) xMin = x;



            series.appendData(new DataPoint(x,y), true, 500
            );
        }

        final GraphView graphView = findViewById(R.id.graph);


        graphView.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
        graphView.getViewport().setScrollable(true);  // activate horizontal scrolling
        graphView.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
        graphView.getViewport().setScrollableY(true);  // activate vertical scrolling


        graphView.getViewport().setMinX(xMin);
        graphView.getViewport().setMaxX(xMax);
        graphView.getViewport().setMinY(yMin);
        graphView.getViewport().setMaxY(yMax);

        try {
            graphView.addSeries(series);
            Log.d(TAG,"plot finalized");
        } catch (IllegalArgumentException e) {
            Toast.makeText(GraphActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        Button button = findViewById(R.id.ecuaciones);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GraphActivity.this, EquationActivity.class);

                intent.putExtra("equations", equations);


                startActivity(intent);

            }
        });



    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
