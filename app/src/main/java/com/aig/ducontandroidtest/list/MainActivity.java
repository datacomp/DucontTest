package com.aig.ducontandroidtest.list;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.aig.ducontandroidtest.R;
import com.aig.ducontandroidtest.details.DetailFragment;
import com.aig.ducontandroidtest.eventbus.Events;
import com.aig.ducontandroidtest.eventbus.GlobalBus;
import com.aig.ducontandroidtest.list.adapter.ListAdapter;
import com.aig.ducontandroidtest.models.list.Result;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListFragment.OnListFragmentInteractionListener {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = new ListFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // Home/Up logic handled by onBackPressed implementation
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(Result item) {
        Log.e("Clicked", item.getAbstract());

        //Send data from activity to fragment using eventbus
        Events.ActivityToFragmentMessage activityToFragmentMessage = new Events.ActivityToFragmentMessage(item);
        GlobalBus.getEventBus().postSticky(activityToFragmentMessage);

        //Start detail fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, new DetailFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



}
