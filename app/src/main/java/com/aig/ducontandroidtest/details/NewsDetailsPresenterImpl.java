package com.aig.ducontandroidtest.details;

import android.util.Log;

import com.aig.ducontandroidtest.models.list.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDetailsPresenterImpl implements NewsDetailsPresenter {

    private newsDetailsView newsDetailsView;
    private String TAG = NewsDetailsPresenterImpl.class.getSimpleName();
    private Result newsDetails;


    public NewsDetailsPresenterImpl(newsDetailsView newsDetailsView){
        this.newsDetailsView = newsDetailsView;
    }


}
