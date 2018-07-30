package com.aig.ducontandroidtest.list.view;

import com.aig.ducontandroidtest.models.list.Result;

import java.util.ArrayList;
import java.util.List;

public interface MainView {
    void showDialog();
    void cancelDialog();
    void showDataOnFragment(List<Result> arrList);
}
