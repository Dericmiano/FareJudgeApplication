package com.example.farejudgeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farejudgeapplication.Util.Util;
import com.example.farejudgeapplication.models.Host;
import com.example.farejudgeapplication.models.HostViewModel;
import com.example.farejudgeapplication.models.SharedViewModel;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.Date;

public class EntryActivity extends AppCompatActivity {
    private HostViewModel hostViewModel;

    private static final int GALLERY_CODE =1 ;
    private String[] types_of_est = {"Restaurant", "Bar", "Cafe","other"};
    private ImageView backBtn;
    private ConstraintLayout submitBtn;
    private ImageView imageView;
    private EditText nameEnter;
    private EditText foodEnter;
    private EditText locationEnter;
    private EditText parkingEnter;
    private EditText commentEnter;
    private RatingBar ratingBarEnter;
    private ImageView imgBtn;
    private EditText serviceEnter;
    private Date todayDate;
    private ImageView dateButton;
    private TextView calendarTextview;
    Calendar calendar = Calendar.getInstance();
    private byte[] myimage;

    private SharedViewModel sharedViewModel;
    private Boolean isEdit;

    private Spinner estType;
    int myRating = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_entry);
//        sharedViewModel = new ViewModelProvider(requireActivity())
//                .get(SharedViewModel.class);

        hostViewModel = new ViewModelProvider.AndroidViewModelFactory(
                EntryActivity.this.getApplication())
                .create(HostViewModel.class);

        backBtn = findViewById(R.id.back);
        submitBtn = findViewById(R.id.submitButton);
        imageView = findViewById(R.id.imageView);
        imgBtn  = findViewById(R.id.entry_image);
        nameEnter = findViewById(R.id.entry_name);
        foodEnter = findViewById(R.id.entry_food);
        locationEnter = findViewById(R.id.entry_location);
        parkingEnter = findViewById(R.id.entry_parking1);
        commentEnter = findViewById(R.id.entry_comment);
        ratingBarEnter = findViewById(R.id.ratingBar);
        calendarTextview = findViewById(R.id.entrytodayDate);
        dateButton = findViewById(R.id.dateBtn);
        estType = findViewById(R.id.spinner);
        serviceEnter = findViewById(R.id.entry_services);


        backBtn.setOnClickListener(v -> startActivity(new Intent(EntryActivity.this,
                MainActivity.class)));
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        sp.setAdapter(new ArrayAdapter<String>(this,
                R.layout.spinner_list_item,types_of_est));


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveHost();
            }
        });
        imgBtn.setOnClickListener(v -> {
//                get image from gallery
            Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
            galleryIntent.setType("image/*");
            startActivityForResult(galleryIntent,GALLERY_CODE);

        });
        dateButton.setOnClickListener(v -> {
            calendar.add(Calendar.DAY_OF_MONTH, 0);
            todayDate = calendar.getTime();
            Log.d("time", "onClick: "+todayDate.toString());
            String formatted = Util.formatDate(todayDate);
            calendarTextview.setText(formatted);
        });
        ratingBarEnter.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                myRating =(int) ratingBar.getRating();
            }
        });

    }

//                textView.setText(String.valueOf(myRating));


    private void saveHost() {
        String name = nameEnter.getText().toString().trim();
        String location = locationEnter.getText().toString().trim();
        String parking = parkingEnter.getText().toString().trim();
        String comment = commentEnter.getText().toString().trim();
        String food = foodEnter.getText().toString().trim();
        String services = serviceEnter.getText().toString().trim();
        int rating = myRating;
        String type = estType.getSelectedItem().toString();

//
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(location) || TextUtils.isEmpty(parking)
                || TextUtils.isEmpty(comment) || TextUtils.isEmpty(food) || rating==0 || todayDate == null) {

            Toast.makeText(EntryActivity.this, "Please enter the blank space", Toast.LENGTH_LONG)
                    .show();

        }else{
            Host host = new Host(
                    name, type, location, services, rating, comment, parking, todayDate, food);
//            if (isEdit){
//                Host updateHost = sharedViewModel.getSelectedItem().getValue();
//                assert updateHost != null;
//                updateHost.setHostDate(todayDate);
//                updateHost.setHostName(name);
//                updateHost.setHostComment(comment);
//                updateHost.setHostLocation(location);
//                updateHost.setHostFood(food);
//                updateHost.setHostType(type);
//                updateHost.setHostParking(parking);
//                updateHost.setHostComment(comment);
//                updateHost.setHostNumberOfStars(rating);
//                HostViewModel.update(updateHost);
//                sharedViewModel.setIsEdit(false);
//                startActivity(new Intent(EntryActivity.this, ViewActivity.class));
//
//            }else {
//                HostViewModel.insert(host);
//                nameEnter.setText("");
//                foodEnter.setText("");
//                locationEnter.setText("");
//                parkingEnter.setText("");
//                commentEnter.setText("");
//                serviceEnter.setText("");
//            }

            HostViewModel.insert(host);

            startActivity(new Intent(EntryActivity.this, ViewActivity.class));

        }
    }





//        @Override
//    protected void onResume() {
//        super.onResume();
//        if(sharedViewModel.getSelectedItem().getValue() != null){
//            isEdit = sharedViewModel.getIsEdit();
//            Host host = sharedViewModel.getSelectedItem().getValue();
//            String formatted = Util.formatDate(host.hostDate);
//            nameEnter.setText(host.getHostName());
//            foodEnter.setText(host.getHostFood());
//            locationEnter.setText(host.getHostLocation());
//            parkingEnter.setText(host.getHostParking());
//            commentEnter.setText(host.getHostComment());
////            ratingBarEnter.setRating(host.getHostNumberOfStars());
//            serviceEnter.setText(host.getHostServices());
//        }
//    }
}

