package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.graph.GraphActivity;
import com.example.myapplication.structures.EquationHolder;
import com.example.myapplication.structures.ValHolder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> xVals = new ArrayList<>();
    private ArrayList<String> yVals = new ArrayList<>();

    //UI
    private EditText xEdit;
    private EditText yEdit;
    private FloatingActionButton fab_main, fab1_mail, fab2_share, fab3_flect, fab4;
    private Animation fab_open, fab_close, fab_clock, fab_anticlock;
    TextView textview_mail, textview_share, text3, text4;


    Integer beamSize = 0;
    Boolean isOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        xVals.add("2");
        xVals.add("4");
        xVals.add("6");

        yVals.add("10");
        yVals.add("-20");
        yVals.add("40");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Log.d(TAG, "onCreate: started.");
        fab_main = findViewById(R.id.fab);
        fab1_mail = findViewById(R.id.fab1);
        fab2_share = findViewById(R.id.fab2);
        fab3_flect = findViewById(R.id.fab3);
        fab4 = findViewById(R.id.fab4);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock);
        fab_anticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anticlock);

        textview_mail = findViewById(R.id.textview_mail);
        textview_share = findViewById(R.id.textview_share);
        text3 = findViewById(R.id.textview_share3);
        text4 = findViewById(R.id.textview_mail2);

        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen) {

                    textview_mail.startAnimation(fab_close);
                    textview_share.startAnimation(fab_close);
                    fab2_share.startAnimation(fab_close);
                    fab1_mail.startAnimation(fab_close);
                    fab_main.startAnimation(fab_anticlock);
                    fab3_flect.startAnimation(fab_close);
                    text3.startAnimation(fab_close);
                    fab2_share.setClickable(false);
                    fab1_mail.setClickable(false);
                    fab3_flect.setClickable(false);
                    text4.startAnimation(fab_close);
                    fab4.startAnimation(fab_close);
                    fab4.setClickable(false);
                    isOpen = false;
                } else {
                    textview_mail.startAnimation(fab_open);
                    textview_share.startAnimation(fab_open);
                    fab2_share.startAnimation(fab_open);
                    fab1_mail.startAnimation(fab_open);
                    fab_main.startAnimation(fab_clock);
                    fab3_flect.startAnimation(fab_open);
                    text3.startAnimation(fab_open);
                    fab2_share.setClickable(true);
                    fab1_mail.setClickable(true);
                    fab3_flect.setClickable(true);
                    fab4.startAnimation(fab_open);
                    text4.startAnimation(fab_open);
                    fab4.setClickable(true);
                    isOpen = true;
                }

            }
        });


        fab3_flect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textview_mail.startAnimation(fab_close);
                textview_share.startAnimation(fab_close);
                fab2_share.startAnimation(fab_close);
                fab1_mail.startAnimation(fab_close);
                fab_main.startAnimation(fab_anticlock);
                fab2_share.setClickable(false);
                fab1_mail.setClickable(false);
                fab3_flect.setClickable(false);
                fab3_flect.startAnimation(fab_close);
                text3.startAnimation(fab_close);
                text4.startAnimation(fab_close);
                fab4.startAnimation(fab_close);
                fab4.setClickable(false);
                isOpen = false;

                Intent intent = new Intent(MainActivity.this, GraphActivity.class);


                String jsonVals = new Gson().toJson(getSecondPlottingHolders(8));

                String jsonEq = new Gson().toJson(getEquations2(8));

                intent.putExtra("values", jsonVals);
                intent.putExtra("equations", jsonEq);


                Log.d(TAG, jsonEq);

                startActivity(intent);


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
                fab3_flect.setClickable(false);
                fab3_flect.startAnimation(fab_close);
                text3.startAnimation(fab_close);
                text4.startAnimation(fab_close);
                fab4.startAnimation(fab_close);
                fab4.setClickable(false);
                isOpen = false;


                Intent intent = new Intent(MainActivity.this, GraphActivity.class);


                String jsonVals = new Gson().toJson(transformPlottingHolders(8));

                intent.putExtra("values", jsonVals);

                startActivity(intent);


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
                text4.startAnimation(fab_close);
                fab4.startAnimation(fab_close);
                fab4.setClickable(false);
                fab3_flect.setClickable(false);
                fab3_flect.startAnimation(fab_close);
                text3.startAnimation(fab_close);

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_dialog_layout);

                Window window = dialog.getWindow();
                window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                Button addButton = dialog.findViewById(R.id.puntualButton);
                xEdit = dialog.findViewById(R.id.xAdd);
                yEdit = dialog.findViewById(R.id.yAdd);
                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(xEdit.getText().toString().isEmpty()){

                            xEdit.setHint("Por favor agregue un valor válido");
                            return;

                        }
                        if(yEdit.getText().toString().isEmpty()){

                            yEdit.setHint("Por favor agregue un valor válido");
                            return;

                        }

                        xVals.add(xEdit.getText().toString());
                        yVals.add(yEdit.getText().toString());
                        initRecyclerView();
                        dialog.cancel();

                    }
                });

                dialog.show();


            }
        });

        initRecyclerView();
    }


    public void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, xVals, yVals, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TextView text = findViewById(R.id.textView);

        if(xVals.size() > 0){

            text.setText("");

        }
        else {

            text.setText("No se han registrado cargas.");

        }

    }
    
    private ArrayList<ValHolder> getHolders(){

        Log.d(TAG,"getting holders");

        ArrayList<ValHolder> finalList = new ArrayList<>();

        ArrayList<Double> unsortedX = stringToDouble(xVals);

        ArrayList<Double> sortedX = unsortedX;
        Collections.sort(sortedX);

        unsortedX = stringToDouble(xVals);


        ArrayList<Double> sortedY = sortYVals(sortedX, unsortedX);


        for (int i = 0; i < sortedX.size(); i++) {

            finalList.add(new ValHolder(sortedY.get(i), sortedX.get(i)));

        }

        Log.d(TAG, "holders generated");


        return finalList;
        
    }

    private ArrayList<EquationHolder> getEquations2(int size){
        ArrayList<ValHolder> values = getPlottingHolders(size);

        ArrayList<EquationHolder> finalValues = new ArrayList<>();

        Double m = 0.0;

        int i = 0;

        Double prevY = 0.0;

        while(i+1 < values.size()){

            ValHolder val1 = values.get(i);
            ValHolder val2 = values.get(i+1);

            m += val1.getVal();

            Double b = m*val1.getPos();

            Double y = m*val2.getPos() - b;

            Double finalY = y + prevY;


            Double x1 = val1.getPos();
            Double x2 = val2.getPos();

            Double finalM = (finalY-prevY)/(x2-x1);
            Double finalB = finalY - finalM*x2;
            finalM *= -1;
            finalB *= -1;

            String eq = finalM.toString()+"x+"+finalB.toString();

            Log.d("Equation #", ""+i);
            Log.d("X1, Y1", x1+","+prevY);
            Log.d("X1, Y2", x2+","+finalY);

            Log.d("Equation: ", eq);
            prevY = finalY;


            EquationHolder equationHolder = new EquationHolder(x1, x2, eq);

            finalValues.add(equationHolder);


            i++;

            Log.d("Equation", finalM+"x-"+finalB);

        }


        return finalValues;


    }

    private ArrayList<ValHolder> getSecondPlottingHolders(int size){

        ArrayList<ValHolder> values = getPlottingHolders(size);

        ArrayList<ValHolder> finalValues = new ArrayList<>();

        Double m = 0.0;

        int i = 0;

        Double prevY = 0.0;

        finalValues.add(new ValHolder(0,0));

        while(i+1 < values.size()){

            ValHolder val1 = values.get(i);
            ValHolder val2 = values.get(i+1);

            m += val1.getVal();

            Double b = m*val1.getPos();

            Double y = m*val2.getPos() - b;
            Log.d("Prev Y", prevY.toString());


            Double finalY = y + prevY;

            prevY = finalY;


            Log.d("Y", y.toString());
            Log.d("Final Y", finalY.toString());


            Double x = val2.getPos();

            finalValues.add(new ValHolder(-1*finalY,x));

            i++;

            Log.d("Equation", m+"x-"+b);

        }


        return finalValues;
    }

    private ArrayList<ValHolder> getPlottingHolders(int size){

        ArrayList<ValHolder> holders = getHolders();


        double reactBVal = getReactionB(holders,size);
        double reactAVal = getReactionA(holders, reactBVal);

        ValHolder reactB = new ValHolder(reactBVal, size);
        ValHolder reactA = new ValHolder(reactAVal, 0);

        holders.add(0, reactA);
        holders.add(reactB);

        return holders;

    }

    private ArrayList<ValHolder> transformPlottingHolders(int size){

        ArrayList<ValHolder> holders = getPlottingHolders(size);
        ArrayList<ValHolder> finalHolders = new ArrayList<>();

        ArrayList<Double> xVals = new ArrayList<>();
        ArrayList<Double> yVals = new ArrayList<>();




        ArrayList<Double> finalXVals = new ArrayList<>();
        ArrayList<Double> finalYVals = new ArrayList<>();


        for (ValHolder holder:holders) {

            xVals.add(holder.getPos());
            yVals.add(holder.getVal());

        }


        Log.d("Initial X Vals:", xVals.toString());
        Log.d("Initial Y Vals:", yVals.toString());

        int xInd = 0;
        int yInd = 0;
        int c = 0;
        Double p = 0.0;

        finalHolders.add(new ValHolder(0,0));
        finalHolders.add(new ValHolder(0,0));

        while(xInd < xVals.size()){

            if(c%2 == 0){

                Double x = xVals.get(xInd);
                Double sus = yVals.get(yInd);


                p += sus;

                finalHolders.add(new ValHolder(p, x));

                xInd++;
                c++;


                finalXVals.add(x);
                finalYVals.add(p);
            }
            else{

                Double x = xVals.get(xInd);
                finalHolders.add(new ValHolder(p,x));

                yInd++;
                c++;


                finalXVals.add(x);
                finalYVals.add(p);

            }

        }


        Log.d("Final X Vals:", finalXVals.toString());
        Log.d("Final Y Vals:", finalYVals.toString());

        finalHolders.add(new ValHolder(0,size));
        finalHolders.add(new ValHolder(0,size+2));



        return finalHolders;
    }


    private ArrayList<Double> stringToDouble(ArrayList<String> vals){

        ArrayList<Double> doubleArrayList = new ArrayList<>();

        for (String val:vals) {

            double doubleVal = Double.valueOf(val);
            doubleArrayList.add(doubleVal);

        }

        return doubleArrayList;

    }

    private ArrayList<Double> sortYVals(ArrayList<Double> sortedVals, ArrayList<Double> unsortedVals){

        ArrayList<Double> sortedYVals = new ArrayList<>();

        for (Double val:sortedVals) {

            int ind = unsortedVals.indexOf(val);

            double yVal = Double.valueOf(yVals.get(ind));


            sortedYVals.add(yVal);

        }

        return sortedYVals;

    }

    private double getReactionB(ArrayList<ValHolder> valList, double length){

        double sum = 0;
        for (ValHolder holder:valList) {

            double val = Double.valueOf(holder.getVal());
            double pos = Double.valueOf(holder.getPos());

            sum -= val*pos;


        }

        double reactB = sum/length;

        return reactB;

    }

    private double getReactionA(ArrayList<ValHolder> valList, double reactB){

        double sum = 0;

        for (ValHolder holder:valList) {

            double val = Double.valueOf(holder.getVal());

            sum -= val;

        }

        sum -= reactB;

        return sum;
    }

}


/*
def getPuntos(listaCargas, longitud):

    reaccionB = getReaccionB(listaCargas, longitud)
    reaccionA = getReaccionA(listaCargas, reaccionB)

    listaCargas= [(reaccionA, 0)] + listaCargas + [(reaccionB, longitud)]

    puntos = []
    puntero = 0

    for carga in listaCargas:
        puntero -= carga[0]
        puntos += [(puntero, carga[1])]

    return puntos


 */




















