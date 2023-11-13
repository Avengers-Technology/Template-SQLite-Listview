package com.mtg.speedtest.speedcheck.internet.hikermanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "abc";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng và định nghĩa cấu trúc
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY, name TEXT, location TEXT, date TEXT, parkingAvailable TEXT, lengthOfTheHike TEXT, difficultyLevel TEXT, description TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addModel(CommonsModel commonsModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", commonsModel.name);
        values.put("location", commonsModel.location);
        values.put("date", commonsModel.date);
        values.put("parkingAvailable", commonsModel.parkingAvailable);
        values.put("lengthOfTheHike", commonsModel.lengthOfTheHike);
        values.put("difficultyLevel", commonsModel.difficultyLevel);
        values.put("description", commonsModel.description);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
    }

    public void deleteModel(CommonsModel commonsModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[]{String.valueOf(commonsModel.id)});
    }

    public void updateModel(CommonsModel commonsModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", commonsModel.name);
        values.put("location", commonsModel.location);
        values.put("date", commonsModel.date);
        values.put("parkingAvailable", commonsModel.parkingAvailable);
        values.put("lengthOfTheHike", commonsModel.lengthOfTheHike);
        values.put("difficultyLevel", commonsModel.difficultyLevel);
        values.put("description", commonsModel.description);
        db.update(TABLE_NAME, values, "id = ?", new String[]{String.valueOf(commonsModel.getId())});
        db.close();
    }

    public List<CommonsModel> getAllModel() {
        List<CommonsModel> commonsModelList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME + "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            CommonsModel commonsModel = new CommonsModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7));
            commonsModelList.add(commonsModel);
            cursor.moveToNext();
        }
        return commonsModelList;
    }
}
