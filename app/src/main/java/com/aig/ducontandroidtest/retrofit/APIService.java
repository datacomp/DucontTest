package com.aig.ducontandroidtest.retrofit;


import com.aig.ducontandroidtest.models.list.PopulatListResponse;
import com.aig.ducontandroidtest.util.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET(Constants.URL_LIST)
    Call<PopulatListResponse> getMostPopularList(@Query("api-key") String id);
//    Call<String> getMostPopularList(@Query("api-key") String apiKey);


//    @GET(Constants.URL_GET_CATEGORY_NEWS)
//    Call<CategoryNewsData> getCatNews(@Query("id") String id);


}

