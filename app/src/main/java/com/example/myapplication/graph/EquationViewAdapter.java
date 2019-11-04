package com.example.myapplication.graph;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.structures.EquationHolder;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 1/1/2018.
 */

public class EquationViewAdapter extends RecyclerView.Adapter<EquationViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<EquationHolder> mxVals = new ArrayList<>();
    private Context mContext;

    public EquationViewAdapter(Context context, ArrayList<EquationHolder> xVals) {
        mxVals = xVals;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.equation_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        EquationHolder equationHolder = mxVals.get(position);

        String text = equationHolder.getX1().toString() + " < X < " + equationHolder.getX2().toString();

        holder.xVal.setText(text);
        holder.yVal.setText(equationHolder.getEquation());

    }

    @Override
    public int getItemCount() {
        return mxVals.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView xVal;
        TextView yVal;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            xVal = itemView.findViewById(R.id.xVal);
            yVal = itemView.findViewById(R.id.xVal2);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}















