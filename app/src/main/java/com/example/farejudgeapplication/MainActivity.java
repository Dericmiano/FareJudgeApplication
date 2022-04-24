package com.example.farejudgeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.farejudgeapplication.adapter.RecyclerViewAdapter;
import com.example.farejudgeapplication.models.Host;
import com.example.farejudgeapplication.models.HostViewModel;
import com.example.farejudgeapplication.models.SharedViewModel;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout viewEst;
    private ConstraintLayout  newEst;
    private CardView cardView;

    private SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewEst = findViewById(R.id.view_establishment);
        newEst = findViewById(R.id.new_establishment);
        cardView = findViewById(R.id.about);


        viewEst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewActivity.class));
                ;
            }
        });

        newEst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sharedViewModel.setIsEdit(false);
//                sharedViewModel.getSelectedItem().getValue();
//
//                Intent intent = new Intent(MainActivity.this, EntryActivity.class);
//                sharedViewModel.getSelectedItem().getValue();


                startActivity(new Intent(MainActivity.this, EntryActivity.class));


            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });
    }
}