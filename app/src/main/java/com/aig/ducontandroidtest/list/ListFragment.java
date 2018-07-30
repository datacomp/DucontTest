package com.aig.ducontandroidtest.list;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aig.ducontandroidtest.R;
import com.aig.ducontandroidtest.list.adapter.ListAdapter;
import com.aig.ducontandroidtest.list.adapter.RecyclerTouchListener;
import com.aig.ducontandroidtest.models.list.PopulatListResponse;
import com.aig.ducontandroidtest.models.list.Result;
import com.aig.ducontandroidtest.retrofit.APIService;
import com.aig.ducontandroidtest.retrofit.RetrofitClient;
import com.aig.ducontandroidtest.util.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ListFragment extends Fragment implements MainView{

    private OnListFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private List<Result> arrListData;
    private ProgressDialog dialog;
    private MainPresenterImpl mainPresenter;
    private View mView;
    private Toolbar mToolbar;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListFragment newInstance(int columnCount) {
        ListFragment fragment = new ListFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Loading...");

        arrListData = new ArrayList<>();
        mAdapter = new ListAdapter(arrListData);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mView ==  null){
            mView = inflater.inflate(R.layout.fragment_item_list, container, false);

            // Set the adapter
            if (mView instanceof RecyclerView) {
                Context context = mView.getContext();
                recyclerView = (RecyclerView) mView;

                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
            }

            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                   mListener.onListFragmentInteraction(arrListData.get(position));
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));

            mainPresenter = new MainPresenterImpl(this);
            mainPresenter.getListData();

        }

        return mView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showDialog() {
        if(dialog != null)
            dialog.show();
    }

    @Override
    public void cancelDialog() {
        if(dialog != null)
            dialog.dismiss();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(getString(R.string.str_title));
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    public void showDataOnFragment(List<Result> arrList) {
        arrListData = arrList;
        mAdapter = new ListAdapter(arrList);
        recyclerView.setAdapter(mAdapter);

    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Result item);
    }
}
