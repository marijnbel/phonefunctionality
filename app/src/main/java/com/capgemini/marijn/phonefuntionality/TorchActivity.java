package com.capgemini.marijn.phonefuntionality;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TorchActivity extends AppCompatActivity {

    @BindView(R.id.IbtnToggleFlashlight)
    ImageButton IbtnToggleFlashlight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        ButterKnife.bind(this);
    }



    @OnClick(R.id.IbtnToggleFlashlight)
    public void toggleFlashlight(){

    }


}
