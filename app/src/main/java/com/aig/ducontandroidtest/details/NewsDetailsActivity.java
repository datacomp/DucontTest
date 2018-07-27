package com.aig.ducontandroidtest.details;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aig.ducontandroidtest.R;
import com.aig.ducontandroidtest.models.list.Result;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class NewsDetailsActivity extends AppCompatActivity implements newsDetailsView {

    private NewsDetailsPresenterImpl newsDetailsPresenter;
    private ProgressDialog dialog;
    private String newsType;
//    ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.news_details);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        shareDialog = new ShareDialog(this);


        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");


       /* Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.logo);
        toolbar.setNavigationIcon(drawable);
        toolbar.setTitle("स्वराज्याचा अरुणोदय");*/
        /*TextView txtTitle = (TextView)toolbar.findViewById(R.id.toolbar_title);
        txtTitle.setText("स्वराज्याचा अरुणोदय");
        ImageView imgLogo = toolbar.findViewById(R.id.imgLogoToolbar);
        imgLogo.setVisibility(View.VISIBLE);
        ImageView imgBack = toolbar.findViewById(R.id.back_btn);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setSupportActionBar(toolbar);*/

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                onBackPressed(); // Implemented by activity
//            }
//        });



        newsDetailsPresenter = new NewsDetailsPresenterImpl(this);


    }

    /*@Override
    public void showDetails(Result model) {

      *//*  ImageView imageView = findViewById(R.id.img_banner);
        Glide.with(this).load("http://www.arunodaynews.com/assets/backend/uploads/newsimg/"+model.getImage()).into(imageView);

//        Toast.makeText(getApplicationContext(), model.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
        String desc = model.getDescription();
        if(desc.contains("<p>"))
            desc.replace("<p>","");
        if(desc.contains("</p>"))
            desc.replace("</p>","");
        if(desc.contains("\\r"))
            desc.replace("\\r","");
        if(desc.contains("\\n"))
            desc.replace("\\n","");
        if(desc.contains("<br />"))
            desc.replace("<br />","");

        TextView txtTitle = (TextView)findViewById(R.id.txtTitleDetails);
        txtTitle.setText(model.getTitle());

        TextView txtDesc = (TextView)findViewById(R.id.txtDescription);
        txtDesc.setText(desc);

        TextView txtDate = (TextView)findViewById(R.id.txtDateDetails);
        txtDate.setText(model.getDate());*//*
    }

    @Override
    public void showDialog() {
        dialog.show();
    }

    @Override
    public void cancelDialog() {
        dialog.dismiss();
    }
*/

    @Override
    public void showDetails(Result model) {

    }
}
