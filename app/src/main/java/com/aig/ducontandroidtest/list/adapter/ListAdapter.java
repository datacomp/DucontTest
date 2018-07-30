package com.aig.ducontandroidtest.list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aig.ducontandroidtest.R;
import com.aig.ducontandroidtest.list.ListFragment;
import com.aig.ducontandroidtest.models.list.Result;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context mContext;
    private List<Result> resultList;
    public ListFragment.OnListFragmentInteractionListener mListener;


    public ListAdapter(List<Result> resultList) {
//        this.mContext = mContext;
        this.resultList = resultList;
//        this.mListener = listener;
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
/*        Result result = resultList.get(position);
        holder.mItem = result;
        holder.txtTitle.setText(result.getTitle());
        holder.txtAbstract.setText(result.getAbstract());
        holder.txtDate.setText(result.getPublishedDate());
        holder.txtSection.setText(result.getSection());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
        Log.e("****", result.getTitle());*/

       /* // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });*/

        ((RecyclerPresenter) holder.itemView.getTag()).presentListItem(holder, resultList.get(position));
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    /*public static class Presenter {
        void presentListItem(final MyViewHolder holder, Result result) {
            holder.mItem = result;
            holder.txtTitle.setText(result.getTitle());
            holder.txtAbstract.setText(result.getAbstract());
            holder.txtDate.setText(result.getPublishedDate());
            holder.txtSection.setText(result.getSection());
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mListener.onListFragmentInteraction(holder.mItem);
                    }
                }
            });
            Log.e("****", result.getTitle());
        }
    }*/


}
