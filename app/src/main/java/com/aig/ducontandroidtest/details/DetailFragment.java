package com.aig.ducontandroidtest.details;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aig.ducontandroidtest.R;
import com.aig.ducontandroidtest.eventbus.Events;
import com.aig.ducontandroidtest.eventbus.GlobalBus;
import com.aig.ducontandroidtest.models.list.MediaMetaData;
import com.aig.ducontandroidtest.models.list.Medium;
import com.aig.ducontandroidtest.models.list.Result;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


public class DetailFragment extends Fragment implements newsDetailsView{

    private TextView txtTitle, txtAbstract, txtDate;
    private ImageView imgBanner;
    private Result result;

    public DetailFragment() {
        // Required empty public constructor
    }


    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalBus.getEventBus().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.news_details, container, false);
        txtTitle = view.findViewById(R.id.txtTitleDetails);
        txtAbstract = view.findViewById(R.id.txtDescription);
        txtDate = view.findViewById(R.id.txtDateDetails);
        imgBanner = view.findViewById(R.id.img_banner);

        getActivity().setTitle(result.getTitle());

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        txtDate.setText(result.getPublishedDate());
        txtTitle.setText(result.getTitle());
        txtAbstract.setText(result.getAbstract());

        if(result.getMedia() != null  && result.getMedia().size() >0){
            List<Medium> arrMedia = result.getMedia();
            if(arrMedia.get(0).getMediaMetadata() != null && arrMedia.get(0).getMediaMetadata().size() > 0){
                List<MediaMetaData> arrMetaData = arrMedia.get(0).getMediaMetadata();
                String imageUrl = arrMetaData.get(0).getUrl();
                Glide.with(getActivity()).load(imageUrl).into(imgBanner);

            }

        }


        return view;
    }


    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void getMessage(Events.ActivityToFragmentMessage activityToFragmentMessage){
        Toast.makeText(getActivity(),
                 activityToFragmentMessage.getMessage().getTitle(),
                Toast.LENGTH_SHORT).show();

        result = activityToFragmentMessage.getMessage();

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void showDetails(Result model) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        GlobalBus.getEventBus().unregister(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
