package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.bumptech.glide.Glide;

import org.json.JSONException;


public class MainActivity extends AppCompatActivity  {
    Button buttonQuest;
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonQuest = findViewById(R.id.abutton);
        imgView = findViewById(R.id.qrImageView);
        buttonQuest.setOnClickListener(view -> {
            try {
                sendRequest();
            } catch (AuthFailureError e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });




    }
    public void sendRequest() throws AuthFailureError, JSONException {
        ConnectBinance cn = new ConnectBinance(this);
        String adv = Integer.toString((int)(Math.random()*100));
        cn.getQRlink(adv,"SamSungZflip",imgView);


    }

    }

