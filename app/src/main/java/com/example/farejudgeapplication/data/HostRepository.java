package com.example.farejudgeapplication.data;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.farejudgeapplication.models.Host;
import com.example.farejudgeapplication.utils.HostRoomDatabase;

import java.util.List;

public class HostRepository {
    private final HostDao hostDao;
    private final LiveData<List<Host>> allHosts;

    public HostRepository(Application application) {
        HostRoomDatabase database = HostRoomDatabase.getDatabase(application);
        hostDao = database.hostDao();
        allHosts = hostDao.getHosts();
    }
    public LiveData<List<Host>> getAllHosts() {return allHosts;}
    public void insert(Host host){
        HostRoomDatabase.databaseWriteExecutor.execute(()->
                hostDao.insertHost(host)
                );
    }
    public LiveData<Host> get(long id){
        return hostDao.get(id);}
    public void update(Host host){
        HostRoomDatabase.databaseWriteExecutor.execute(()->
                hostDao.updateHost(host));
    }
    public void delete(Host host){
        HostRoomDatabase.databaseWriteExecutor.execute(()->
                hostDao.deleteHost(host));
    }
    public LiveData<Host> findByName(String searchName){
        return hostDao.findByName(searchName);
    }

}
