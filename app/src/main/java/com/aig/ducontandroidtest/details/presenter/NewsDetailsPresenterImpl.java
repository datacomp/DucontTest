package com.aig.ducontandroidtest.details.presenter;

import com.aig.ducontandroidtest.details.view.newsDetailsView;
import com.aig.ducontandroidtest.models.list.Result;

public class NewsDetailsPresenterImpl implements NewsDetailsPresenter {

    private com.aig.ducontandroidtest.details.view.newsDetailsView newsDetailsView;
    private String TAG = NewsDetailsPresenterImpl.class.getSimpleName();
    private Result newsDetails;


    public NewsDetailsPresenterImpl(newsDetailsView newsDetailsView){
        this.newsDetailsView = newsDetailsView;
    }


}
