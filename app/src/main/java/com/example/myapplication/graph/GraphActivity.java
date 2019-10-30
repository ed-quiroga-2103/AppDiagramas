package com.example.myapplication.graph;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_activity_layout);

        Intent intent = getIntent();
        ArrayList<String> values = intent.getStringArrayListExtra("values");

        LineGraphSeries <DataPoint> series = new LineGraphSeries<>();

        for (String value:values) {

            int x = values.indexOf(value);
            int y = Integer.valueOf(value);

            series.appendData(new DataPoint(x,y), true, 10);
        }

        final GraphView graph = findViewById(R.id.graph);


        try {
            graph.addSeries(series);
        } catch (IllegalArgumentException e) {
            Toast.makeText(GraphActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
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
