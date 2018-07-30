package com.aig.ducontandroidtest.list;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aig.ducontandroidtest.R;
import com.aig.ducontandroidtest.list.adapter.ListAdapter;
import com.aig.ducontandroidtest.list.presenter.MainPresenterImpl;
import com.aig.ducontandroidtest.list.view.ListFragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Smita on 30/07/18.
 */
public class ListFragmentTest {

    private ListFragment listFragment;

    @Before
    public void setUp() throws Exception {

        listFragment = new ListFragment();
    }

    @Test
    public void onCreateView() {
        LayoutInflater inflater = Mockito.mock(LayoutInflater.class);
        View view = Mockito.mock(View.class);
        ViewGroup viewGroup = Mockito.mock(ViewGroup.class);
        RecyclerView recyclerView = Mockito.mock(RecyclerView.class);
        ListAdapter listAdapter = Mockito.mock(ListAdapter.class);
        DefaultItemAnimator defaultItemAnimator = Mockito.mock(DefaultItemAnimator.class);
        when(inflater.inflate(R.layout.fragment_item_list, viewGroup, false)).thenReturn(view);
        MainPresenterImpl mainPresenter = Mockito.mock(MainPresenterImpl.class);
        mainPresenter.getListData();
        verify(mainPresenter, times(1)).getListData();

        verify(recyclerView, times(0)).setItemAnimator(defaultItemAnimator);
        verify(recyclerView, times(0)).setAdapter(listAdapter);
    }

}