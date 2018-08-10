package com.aig.ducontandroidtest.list;

import com.aig.ducontandroidtest.list.presenter.MainPresenterImpl;
import com.aig.ducontandroidtest.list.view.MainView;
import com.aig.ducontandroidtest.models.list.PopulatListResponse;
import com.aig.ducontandroidtest.retrofit.APIService;
import com.aig.ducontandroidtest.util.Constants;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import retrofit2.Call;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Smita on 30/07/18.
 */
public class MainPresenterImplTest {

    MainPresenterImpl mainPresenter;

    MainView mainView;

    @Before
    public void setUp() throws Exception {
        mainView = Mockito.mock(MainView.class);

      mainPresenter = new MainPresenterImpl(mainView);

    }

    @Test
    public void getListData() throws Exception {

        APIService apiService = Mockito.mock(APIService.class);
//        verify(apiService,times(1)).getMostPopularList(Constants.API_KEY_VAL);
        Call<PopulatListResponse> response = Mockito.mock(Call.class);
        Mockito.when(apiService.getMostPopularList(Constants.API_KEY_VAL)).thenReturn(response);

    }

    @Test
    public void cancelDialog() throws Exception {
        mainPresenter.cancelDialog();
        verify(mainView, times(1)).cancelDialog();

    }

}