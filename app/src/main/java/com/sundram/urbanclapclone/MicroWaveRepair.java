package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.sundram.urbanclapclone.viewallserviceactivity.appliance.ViewAllMicrowaveRepair;
import com.sundram.urbanclapclone.viewallserviceactivity.appliance.ViewAllRoAndWaterService;

public class MicroWaveRepair extends AppCompatActivity implements View.OnClickListener {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private VideoView mVideoView;
    private MediaController mediaController;
    private TextView back_tv, login_tv, tv_what_are_u_looking, what_r_u_tv1, what_r_u_tv1_desc1;
    private TextView what_r_u_tv2, what_r_u_tv1_desc2;
    private TextView what_r_u_tv3, what_r_u_tv1_desc3;
    private ImageView img_person, go_one1, go_two2, go_three3;
    private Toolbar toolbar;
    private RelativeLayout relativeLayout_repair, relativeLayout_Service, relativeLayout_UI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_wave_repair);
         gettingIdsOfViews();
          setSupportActionBar(toolbar);
        //setting up the title of collapsableToolbarLayout

        collapsingToolbarLayout.setTitle("Microwave Service and Repair");
    }
    public void gettingIdsOfViews() {
        login_tv = findViewById(R.id.login_button_text);
        collapsingToolbarLayout = findViewById(R.id.collpasableToolbarLayout);

        back_tv = findViewById(R.id.back_tv);
        toolbar = findViewById(R.id.collpasableToolbar);

        what_r_u_tv1 = findViewById(R.id.what_r_u_tv1);
        what_r_u_tv1.setMaxEms(15);
        what_r_u_tv1.setText("Microwave Repair");

        what_r_u_tv2 = findViewById(R.id.what_r_u_tv2);
        what_r_u_tv2.setMaxEms(15);
        what_r_u_tv2.setText("Microwave Service");

        what_r_u_tv3 = findViewById(R.id.what_r_u_tv3);
        what_r_u_tv3.setMaxEms(15);
        what_r_u_tv3.setText("Microwave Install and Uninstall");

        tv_what_are_u_looking = findViewById(R.id.tv_what_are_u_looking);
        tv_what_are_u_looking.setMaxEms(17);
        tv_what_are_u_looking.setText("Here is the Microwave Service Provided on Our Platform");

        what_r_u_tv1_desc1 = findViewById(R.id.what_r_u_tv1_desc);
        what_r_u_tv1_desc1.setText("Improves quality and efficiency");
        what_r_u_tv1_desc1.setMaxEms(15);
        //what_r_u_tv1_desc1.setVisibility(View.INVISIBLE);
        what_r_u_tv1_desc2 = findViewById(R.id.what_r_u_tv2_desc);
        what_r_u_tv1_desc2.setText("Improves quality and efficiency");
        what_r_u_tv1_desc2.setMaxEms(15);
        //what_r_u_tv1_desc2.setVisibility(View.INVISIBLE);
        what_r_u_tv1_desc3 = findViewById(R.id.what_r_u_tv3_desc);
        what_r_u_tv1_desc3.setText("Improves quality and efficiency");
        what_r_u_tv1_desc3.setMaxEms(15);
        //what_r_u_tv1_desc3.setVisibility(View.INVISIBLE);

        relativeLayout_Service = findViewById(R.id.relativeLayout_Service);
        relativeLayout_Service.setVisibility(View.GONE);

        relativeLayout_repair = findViewById(R.id.relativeLayout_repair);

        relativeLayout_UI = findViewById(R.id.relativeLayout_UI);
        relativeLayout_UI.setVisibility(View.GONE);

        setttingUpTheOnClick();
    }
    public void setttingUpTheOnClick() {
        back_tv.setOnClickListener(this);
        //what_r_u_tv1.setOnClickListener(this);
        //what_r_u_tv2.setOnClickListener(this);
        //what_r_u_tv3.setOnClickListener(this);

        //what_r_u_tv1_desc1.setOnClickListener(this);
        //what_r_u_tv1_desc2.setOnClickListener(this);
        //what_r_u_tv1_desc3.setOnClickListener(this);

        //   go_one1.setOnClickListener(this);
        // go_two2.setOnClickListener(this);
        //go_three3.setOnClickListener(this);

       // relativeLayout_UI.setOnClickListener(this);
       // relativeLayout_Service.setOnClickListener(this);
        relativeLayout_repair.setOnClickListener(this);
    }



    @Override
    public void onBackPressed() {
        Intent back = new Intent(MicroWaveRepair.this,ApplianceAndEcRepair.class);
        startActivity(back);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_tv:
                onBackPressed();
                break;
            case R.id.relativeLayout_repair:
                jumpToIntent("0");
                break;
        }
    }
    public Intent jumpToIntent(String tabNumber) {
        Intent jump = new Intent(MicroWaveRepair.this, ViewAllMicrowaveRepair.class);
        jump.putExtra("TabNumber", tabNumber);
        startActivity(jump);
        finish();
        return jump;
    }
}
