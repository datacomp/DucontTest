package com.aig.ducontandroidtest.list.adapter;

import android.util.Log;
import android.view.View;

import com.aig.ducontandroidtest.list.ListFragment;
import com.aig.ducontandroidtest.models.list.Result;

public class RecyclerPresenter {
    public void presentListItem(final MyViewHolder holder, Result result) {
        holder.mItem = result;
        holder.txtTitle.setText(result.getTitle());
        holder.txtAbstract.setText(result.getAbstract());
        holder.txtDate.setText(result.getPublishedDate());
        holder.txtSection.setText(result.getSection());
       /* holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    listener.onListFragmentInteraction(holder.mItem);
                }
            }
        });*/
        Log.e("****", result.getTitle());
    }
}
