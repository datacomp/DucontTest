package com.aig.ducontandroidtest.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aig.ducontandroidtest.R;
import com.aig.ducontandroidtest.models.list.Result;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView txtTitle, txtAbstract, txtDate, txtSection;
    public View mView;
    public Button btnViewDetails;
    public Result mItem;

    public MyViewHolder(View view) {
        super(view);
        txtTitle = view.findViewById(R.id.txtTitle);
        txtAbstract = view.findViewById(R.id.textView2);
        txtDate = view.findViewById(R.id.textView4);
        txtSection = view.findViewById(R.id.textView3);
        mView = view;
    }
}