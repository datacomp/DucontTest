package com.aig.ducontandroidtest.list;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest{

    MainActivity mActivity = null;


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityRule.getActivity();
    }

}
