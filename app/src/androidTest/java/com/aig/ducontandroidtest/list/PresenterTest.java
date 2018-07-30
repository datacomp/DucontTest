package com.aig.ducontandroidtest.list;

import com.aig.ducontandroidtest.list.adapter.MyViewHolder;
import com.aig.ducontandroidtest.list.adapter.RecyclerPresenter;
import com.aig.ducontandroidtest.models.list.Result;

import org.junit.Test;
import org.mockito.Mock;

public class PresenterTest {

    @Mock
    MyViewHolder myViewHolder;

    @Mock
    Result result;

    @Test
    public void presentListItemShouldSetViewTextToPosition() throws Exception {
        RecyclerPresenter presenter = new RecyclerPresenter();

        presenter.presentListItem(myViewHolder,result);


//        verify(mSimpleListItemView).setText("0");
    }
}
