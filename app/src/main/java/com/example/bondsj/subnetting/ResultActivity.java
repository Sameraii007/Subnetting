package com.example.bondsj.subnetting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ResultActivity extends AppCompatActivity {
    AdView mAdview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //builds the Ad Banner
        MobileAds.initialize(this,"ca-app-pub-6845925742732617~9464681857");
        mAdview = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        //sets up Back Button in TopBorderBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //receives data from main activity
        Intent intent = getIntent();
        int ipaddress1 = intent.getIntExtra("parameter name", 0);
        int ipaddress2 = intent.getIntExtra("parameter name2", 0);
        int ipaddress3 = intent.getIntExtra("parameter name3", 0);
        int ipaddress4 = intent.getIntExtra("parameter name4", 0);
        int netID1 = intent.getIntExtra("parameter name5", 0);
        int netID2 = intent.getIntExtra("parameter name6", 0);
        int netID3 = intent.getIntExtra("parameter name7", 0);
        int netID4 = intent.getIntExtra("parameter name8", 0);
        int subMask1 = intent.getIntExtra("parameter name9", 0);
        int subMask2 = intent.getIntExtra("parameter name10", 0);
        int subMask3 = intent.getIntExtra("parameter name11", 0);
        int subMask4 = intent.getIntExtra("parameter name12", 0);
        int broad1 = intent.getIntExtra("parameter name13", 0);
        int broad2 = intent.getIntExtra("parameter name14", 0);
        int broad3 = intent.getIntExtra("parameter name15", 0);
        int broad4 = intent.getIntExtra("parameter name16", 0);
        int subnetTotal = intent.getIntExtra("parameter name17",0);
        int hostsTotal = intent.getIntExtra("parameter name18",0);
        int cidr = intent.getIntExtra("parameter name19",0);

        //creates variable for output
        TextView ipaddressText = (TextView) findViewById(R.id.ipaddressText);
        ipaddressText.setText(ipaddress1+"."+ipaddress2+"."+ipaddress3+"."+ipaddress4);
        TextView netID = (TextView)findViewById((R.id.networkaddressText));
        netID.setText(netID1+"."+netID2+"."+netID3+"."+netID4);
        TextView subMastText = (TextView) findViewById(R.id.subnetMaskText);
        subMastText.setText(subMask1+"."+subMask2+"."+subMask3+"."+subMask4);
        TextView broadText = (TextView) findViewById(R.id.broadText);
        broadText.setText(broad1+"."+broad2+"."+broad3+"."+broad4);
        TextView subnetText = (TextView) findViewById(R.id.subnetText);
        subnetText.setText(subnetTotal+"");
        TextView hostText = (TextView) findViewById(R.id.UsableHostsText);
        hostText.setText(hostsTotal+"");
        TextView cidrText = (TextView) findViewById(R.id.cidrOutput);
        cidrText.setText(cidr+"");

        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        if (id == R.id.item1){
        Intent startIntent = new Intent(ResultActivity.this,AboutActivity.class);
        startActivity(startIntent);
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.credits,menu);
        return true;
    }


}
