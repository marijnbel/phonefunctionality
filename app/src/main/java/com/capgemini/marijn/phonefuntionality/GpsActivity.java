package com.capgemini.marijn.phonefuntionality;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GpsActivity extends AppCompatActivity {

    @BindView(R.id.txlatitude) TextView txlatitude;
    @BindView(R.id.txlongitude) TextView txlongitude;
    @BindView(R.id.btnEnableGps) Button btnEnableGps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        ButterKnife.bind(this);
    }



    @OnClick(R.id.btnEnableGps)
    public void enableLocationTracking(){

    }


}