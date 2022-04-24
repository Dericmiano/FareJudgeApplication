package com.example.farejudgeapplication.utils;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.farejudgeapplication.data.HostDao;
import com.example.farejudgeapplication.models.Host;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Host.class}, version = 1, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class HostRoomDatabase extends RoomDatabase {
    public static final int NUMBER_OF_THREADS = 4;
    public static final String DATABASE_NAME = "host_database";
    public static  volatile HostRoomDatabase INSTANCE;
    public static final ExecutorService databaseWriteExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static final RoomDatabase.Callback sHostRoomDatabaseCallback =
            new HostRoomDatabase.Callback(){
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    databaseWriteExecutor.execute(()->{
                        HostDao hostDao = INSTANCE.hostDao();
                        hostDao.deleteAll();

                    });
                }
            };
    public static HostRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (HostRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            HostRoomDatabase.class, DATABASE_NAME)
                            .addCallback(sHostRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    public abstract HostDao hostDao();


}
