package com.example.farejudgeapplication.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Collection;
import java.util.Date;
//import java.sql.Date;
import java.util.Arrays;

@Entity(tableName = "host_table")
public class Host {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    public long hostId;
//    @ColumnInfo(name = "photo")
//    public byte[] hostImage;
    @ColumnInfo(name = "name")
    public String hostName;
    @ColumnInfo(name="type")
    public String hostType;
    @ColumnInfo(name = "location")
    public String hostLocation;
    @ColumnInfo(name = "services")
    public String hostServices;
    @ColumnInfo(name="Rating")
    public int hostNumberOfStars;
    @ColumnInfo(name="comment")
    public String hostComment;
    @ColumnInfo(name="parking")
    public String hostParking;
    @ColumnInfo(name="Date")
    public Date hostDate;
    @ColumnInfo(name = "food")
    public String hostFood;

    public Host(String hostName,
                String hostType,
                String hostLocation, String hostServices, int hostNumberOfStars, String hostComment, String hostParking, Date hostDate, String hostFood) {
        this.hostName = hostName;
        this.hostType = hostType;
        this.hostLocation = hostLocation;
        this.hostServices = hostServices;
        this.hostNumberOfStars = hostNumberOfStars;
        this.hostComment = hostComment;
        this.hostParking = hostParking;
        this.hostDate = hostDate;
        this.hostFood = hostFood;
    }
    //    public Host(byte[] hostImage,
//                String hostName,
//                String hostType,
//                String hostLocation,
//                String hostServices,
//                int hostNumberOfStars,
//                String hostComment,
//                String hostParking,
//                Date hostDate,
//                String hostFood) {
//        this.hostImage = hostImage;
//        this.hostName = hostName;
//        this.hostType = hostType;
//        this.hostLocation = hostLocation;
//        this.hostServices = hostServices;
//        this.hostNumberOfStars = hostNumberOfStars;
//        this.hostComment = hostComment;
//        this.hostParking = hostParking;
//        this.hostDate = hostDate;
//        this.hostFood = hostFood;
//    }

    public String getHostFood() {
        return hostFood;
    }

    public void setHostFood(String hostFood) {
        this.hostFood = hostFood;
    }

    public long getHostId() {
        return hostId;
    }

    public void setHostId(long hostId) {
        this.hostId = hostId;
    }

//    public byte[] getHostImage() {
//        return hostImage;
//    }
//
//    public void setHostImage(byte[] hostImage) {
//        this.hostImage = hostImage;
//    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostType() {
        return hostType;
    }

    public void setHostType(String hostType) {
        this.hostType = hostType;
    }

    public String getHostLocation() {
        return hostLocation;
    }

    public void setHostLocation(String hostLocation) {
        this.hostLocation = hostLocation;
    }

    public String getHostServices() {
        return hostServices;
    }

    public void setHostServices(String hostServices) {
        this.hostServices = hostServices;
    }

    public int getHostNumberOfStars() {
        return hostNumberOfStars;
    }

    public void setHostNumberOfStars(int hostNumberOfStars) {
        this.hostNumberOfStars = hostNumberOfStars;
    }

    public String getHostComment() {
        return hostComment;
    }

    public void setHostComment(String hostComment) {
        this.hostComment = hostComment;
    }

    public String getHostParking() {
        return hostParking;
    }

    public void setHostParking(String hostParking) {
        this.hostParking = hostParking;
    }

    public Date getHostDate() {
        return hostDate;
    }

    public void setHostDate(Date hostDate) {
        this.hostDate = hostDate;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "hostId=" + hostId +
//                ", hostImage=" + Arrays.toString(hostImage) +
                ", hostName='" + hostName + '\'' +
                ", hostType='" + hostType + '\'' +
                ", hostLocation='" + hostLocation + '\'' +
                ", hostServices='" + hostServices + '\'' +
                ", hostNumberOfStars=" + hostNumberOfStars +
                ", hostComment='" + hostComment + '\'' +
                ", hostParking='" + hostParking + '\'' +
                ", hostDate=" + hostDate +
                '}';
    }

}
