package com.example.farejudgeapplication.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.farejudgeapplication.models.Host;

import java.util.List;

@Dao
public interface HostDao {
    @Query("SELECT * FROM host_table")
    LiveData<List<Host>> getHosts();

    @Query("DELETE  FROM  host_table")
    void deleteAll();

    @Insert
    void insertHost(Host host);

    @Update
    void updateHost(Host host);

    @Delete
    void deleteHost(Host host);


    @Query("SELECT * FROM host_table WHERE host_table.id == :id")
    LiveData<Host> get(long id);

//    @Query("SELECT * FROM host_table WHERE name LIKE :searchQuery OR lastName LIKE :searchQuery")
//    fun searchDatabase(searchQuery: String): Flow<List<Person>>




    @Query("SELECT * FROM host_table WHERE name LIKE :searchName OR location LIKE :searchName")
    LiveData<Host> findByName(String searchName);


}
