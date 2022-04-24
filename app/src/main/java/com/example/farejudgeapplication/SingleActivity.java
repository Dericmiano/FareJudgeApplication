package com.example.farejudgeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.farejudgeapplication.Util.Util;
import com.example.farejudgeapplication.adapter.OnTodoClickListener;
import com.example.farejudgeapplication.models.Host;
import com.example.farejudgeapplication.models.SharedViewModel;

public class SingleActivity extends AppCompatActivity{
    public TextView nameHost;
    public TextView location;
    public TextView service;
    public TextView comment;
    public TextView date;
    public TextView food;
    public TextView parking;
    private SharedViewModel sharedViewModel;
    private OnTodoClickListener onTodoClickListener;
    private TextView type;
    private ImageView back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
//        sharedViewModel.getSelectedItem().getValue();

        nameHost = findViewById(R.id.single_activity_name);
        location = findViewById(R.id.single_activity_location);
        service = findViewById(R.id.single_activity_services);
        comment = findViewById(R.id.single_activity_comments);
        date = findViewById(R.id.single_activity_date);
        food = findViewById(R.id.single_activity_food);
        parking = findViewById(R.id.single_activity_parking);
        type = findViewById(R.id.single_activity_type_est);
        back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SingleActivity.this,ViewActivity.class));
            }
        });


        String mname = getIntent().getStringExtra("name");
        String mlocation = getIntent().getStringExtra("location");
        String mservice = getIntent().getStringExtra("service");
        String mcomment = getIntent().getStringExtra("comment");
        String mfood = getIntent().getStringExtra("food");
        String mparking = getIntent().getStringExtra("parking");
        String mtype = getIntent().getStringExtra("type");
        String mdate = getIntent().getStringExtra("date");





        nameHost.setText(mname);
        location.setText(mlocation);
        service.setText(mservice);
        comment.setText(mcomment);
        date.setText(mdate);
        food.setText(mfood);
        parking.setText(mparking);
        type.setText(mtype);



    }


}