package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 1/1/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mxVals = new ArrayList<>();
    private ArrayList<String> myVals = new ArrayList<>();
    private Context mContext;
    private EditText xEdit;
    private EditText yEdit;
    private MainActivity mMain;

    public RecyclerViewAdapter(Context context, ArrayList<String> xVals, ArrayList<String> yVals, MainActivity main) {
        mxVals = xVals;
        myVals = yVals;
        mContext = context;
        mMain = main;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");



        holder.xVal.setText("Pos. X: " + mxVals.get(position).toString());
        holder.yVal.setText("Fuerza: " + myVals.get(position).toString());



        if(Integer.valueOf(myVals.get(position)) > 0){

            holder.image.setImageResource(R.drawable.ic_arrow_down);

        }
        else {

            holder.image.setImageResource(R.drawable.ic_arrow_up);

        }


            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.edit_dialog_layout);

                Button editButton = dialog.findViewById(R.id.editPuntual);
                xEdit = dialog.findViewById(R.id.xEdit);
                yEdit = dialog.findViewById(R.id.yEdit);


                xEdit.setText(mxVals.get(position));
                yEdit.setText(myVals.get(position));



                Window window = dialog.getWindow();
                window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


                editButton.setOnClickListener(new View.OnClickListener() {
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


                        mxVals.set(position, xEdit.getText().toString());
                        myVals.set(position, yEdit.getText().toString());
                        mMain.initRecyclerView();
                        dialog.cancel();

                    }
                });

                Button deleteButton = dialog.findViewById(R.id.deletePuntual);

                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mxVals.remove(position);
                        myVals.remove(position);
                        mMain.initRecyclerView();
                        dialog.cancel();
                    }
                });

                dialog.show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return mxVals.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView xVal;
        TextView yVal;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            xVal = itemView.findViewById(R.id.xVal);
            yVal = itemView.findViewById(R.id.yVal);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}















