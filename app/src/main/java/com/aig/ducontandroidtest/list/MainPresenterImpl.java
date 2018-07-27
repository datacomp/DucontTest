package com.aig.ducontandroidtest.list;

import android.util.Log;

import com.aig.ducontandroidtest.list.adapter.ListAdapter;
import com.aig.ducontandroidtest.models.list.PopulatListResponse;
import com.aig.ducontandroidtest.models.list.Result;
import com.aig.ducontandroidtest.retrofit.APIService;
import com.aig.ducontandroidtest.retrofit.RetrofitClient;
import com.aig.ducontandroidtest.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;
    private ListAdapter mAdapter;
    private List<Result> arrListData;
    private APIService apiService;
    private String TAG = MainPresenterImpl.class.getSimpleName();

    public MainPresenterImpl(MainView view){
        this.mainView = view;
        apiService = RetrofitClient.getRetrofitClient().create(APIService.class);
    }

    @Override
    public void getListData() {

        mainView.showDialog();

        Call<PopulatListResponse> callGetData = apiService.getMostPopularList(Constants.API_KEY);
        callGetData.enqueue(new Callback<PopulatListResponse>() {
            @Override
            public void onResponse(Call<PopulatListResponse> call, Response<PopulatListResponse> response) {
                Log.e("Response CopyRight :: ",response.body().getCopyright()+"");
                arrListData = response.body().getResults();

                mainView.showDataOnFragment(arrListData);

                mainView.cancelDialog();
            }

            @Override
            public void onFailure(Call<PopulatListResponse> call, Throwable t) {
                Log.e(TAG, "Error Response : "+t.getMessage());
                mainView.cancelDialog();
            }
        });

    }
}
