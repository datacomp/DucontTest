package com.aig.ducontandroidtest.list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aig.ducontandroidtest.R;
import com.aig.ducontandroidtest.list.view.ListFragment;
import com.aig.ducontandroidtest.models.list.Result;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Result> resultList;
    public ListFragment.OnListFragmentInteractionListener mListener;


    public ListAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        itemView.setTag(new RecyclerPresenter());

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        ((RecyclerPresenter) holder.itemView.getTag()).presentListItem(holder, resultList.get(position));
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

}
