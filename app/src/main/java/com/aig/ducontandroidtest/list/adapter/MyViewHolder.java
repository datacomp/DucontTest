package com.aig.ducontandroidtest.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aig.ducontandroidtest.R;
import com.aig.ducontandroidtest.models.list.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txtTitle)
    public TextView txtTitle;

    @BindView(R.id.textView2)
    public TextView txtAbstract;

    @BindView(R.id.textView4)
    public TextView txtDate;

    @BindView(R.id.textView3)
    public TextView txtSection;

    public View mView;
//    public Button btnViewDetails;
    public Result mItem;

    public MyViewHolder(View view) {
        super(view);

        mView = view;
        ButterKnife.bind(this,view);

    }
}