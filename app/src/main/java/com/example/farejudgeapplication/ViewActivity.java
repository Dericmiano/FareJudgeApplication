package com.example.farejudgeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.farejudgeapplication.Util.Util;
import com.example.farejudgeapplication.adapter.OnTodoClickListener;
import com.example.farejudgeapplication.adapter.RecyclerViewAdapter;
import com.example.farejudgeapplication.models.Host;
import com.example.farejudgeapplication.models.HostViewModel;
import com.example.farejudgeapplication.models.SharedViewModel;

import java.util.Calendar;
import java.util.List;

public class ViewActivity extends AppCompatActivity implements OnTodoClickListener {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private HostViewModel hostViewModel;
    private ImageView addBtn;
    private SharedViewModel sharedViewModel;
    EntryActivity entryActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        recyclerView = findViewById(R.id.recyclerView);
        final List<Host> hostList;

        addBtn = findViewById(R.id.addButton);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sharedViewModel = new ViewModelProvider(this)
                .get(SharedViewModel.class);

        hostViewModel = new ViewModelProvider.AndroidViewModelFactory(
                ViewActivity.this.getApplication())
                .create(HostViewModel.class);
        hostViewModel.getAllHosts().observe(this, hosts -> {
            recyclerViewAdapter = new RecyclerViewAdapter(hosts, this);
            recyclerView.setAdapter(recyclerViewAdapter);

            for (Host host : hosts) {
                Log.d("TAG1", "onCreate: " + host.getHostLocation());
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(ViewActivity.this, EntryActivity.class));
            }
        });


    }
    public void showEntryActivity(){
        sharedViewModel.setIsEdit(false);
        sharedViewModel.getSelectedItem().getValue();

        startActivity(new Intent(ViewActivity.this, EntryActivity.class));

    }

    @Override
    public void onTodoClick(Host host) {

        Intent intent = new Intent(ViewActivity.this,SingleActivity.class);
        String formatted = Util.formatDate(host.getHostDate());


        intent.putExtra("name",host.getHostName());
        intent.putExtra("location",host.getHostLocation());
        intent.putExtra("service",host.getHostServices());
        intent.putExtra("comment",host.getHostComment());
        intent.putExtra("food",host.getHostFood());
        intent.putExtra("parking",host.getHostParking());
        intent.putExtra("type",host.getHostType());
        intent.putExtra("date",formatted);

        startActivity(intent);
        Log.d("9", "onTodoClick: "+host.getHostNumberOfStars());

    }

    @Override
    public void onTodoDeleteButtonClick(Host host) {
        HostViewModel.delete(host);
        recyclerViewAdapter.notifyDataSetChanged();

    }

    @Override
    public void onTodoUpdateButtonClick(Host host) {
        sharedViewModel.selectItem(host);
        sharedViewModel.setIsEdit(true);
        showEntryActivity();
    }






}