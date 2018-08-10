package com.aig.ducontandroidtest.retrofit;


import com.aig.ducontandroidtest.models.list.PopulatListResponse;
import com.aig.ducontandroidtest.util.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET(Constants.URL_LIST)
    Call<PopulatListResponse> getMostPopularList(@Query(Constants.API_KEY) String id);

}

