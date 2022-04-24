package com.example.farejudgeapplication.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.farejudgeapplication.data.HostRepository;

import java.util.List;



public class HostViewModel extends AndroidViewModel {
    public static HostRepository repository;
    public final LiveData<List<Host>> allHosts;

    public HostViewModel(@NonNull Application application) {
        super(application);
        repository = new HostRepository(application);
        allHosts = repository.getAllHosts();
    }
    public LiveData<List<Host>> getAllHosts(){return allHosts;}
    public static void insert(Host host){repository.insert(host); }
    public LiveData<Host> get(long id){return  repository.get(id);}
    public static void update(Host host){repository.update(host);}
    public static void delete(Host host){repository.delete(host);}
    public LiveData<Host> findByName(String searchName){
        return repository.findByName(searchName);
    }

}
