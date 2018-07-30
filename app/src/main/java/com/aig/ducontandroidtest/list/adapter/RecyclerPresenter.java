package com.aig.ducontandroidtest.list.adapter;

import android.util.Log;

import com.aig.ducontandroidtest.models.list.Result;

public class RecyclerPresenter {
    public void presentListItem(final MyViewHolder holder, Result result) {
        holder.mItem = result;
        holder.txtTitle.setText(result.getTitle());
        holder.txtAbstract.setText(result.getAbstract());
        holder.txtDate.setText(result.getPublishedDate());
        holder.txtSection.setText(result.getSection());

    }
}
