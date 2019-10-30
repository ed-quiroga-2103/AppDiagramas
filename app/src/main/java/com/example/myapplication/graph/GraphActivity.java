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

    double max = 0;
    double min = 0;

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

            if(y > max) max = y;
            if(y < min) min = y;

            series.appendData(new DataPoint(x,y), true, 10);
        }

        final GraphView graphView = findViewById(R.id.graph);


        graphView.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
        graphView.getViewport().setScrollable(true);  // activate horizontal scrolling
        graphView.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
        graphView.getViewport().setScrollableY(true);  // activate vertical scrolling


        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(values.size());
        graphView.getViewport().setMinY(min);
        graphView.getViewport().setMaxY(max);

        try {
            graphView.addSeries(series);
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
