package com.mtg.speedtest.speedcheck.internet.hikermanager;

public class CommonsModel {
    int id;
    String name;
    String location;
    String date;
    String parkingAvailable;
    String lengthOfTheHike;
    String difficultyLevel;
    String description;

    public CommonsModel(int id, String name, String location, String date, String parkingAvailable, String lengthOfTheHike, String difficultyLevel, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.parkingAvailable = parkingAvailable;
        this.lengthOfTheHike = lengthOfTheHike;
        this.difficultyLevel = difficultyLevel;
        this.description = description;
    }

    public CommonsModel(String name, String location, String date, String parkingAvailable, String lengthOfTheHike, String difficultyLevel, String description) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.parkingAvailable = parkingAvailable;
        this.lengthOfTheHike = lengthOfTheHike;
        this.difficultyLevel = difficultyLevel;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setParkingAvailable(String parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }

    public void setLengthOfTheHike(String lengthOfTheHike) {
        this.lengthOfTheHike = lengthOfTheHike;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getParkingAvailable() {
        return parkingAvailable;
    }

    public String getLengthOfTheHike() {
        return lengthOfTheHike;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getDescription() {
        return description;
    }
}
