package com.example.myapplication.ExTraining.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.ExTraining.model.Work;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "WORK_DB";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper sInstance;
    private static final String TABLE_WORK = "WORK";
    private static final String ID_COLUMN = "id";
    private static final String NAMEWORK_COLUMN = "namework";
    private static final String TIME_COLUMN = "time";
    private static final String CREATE_WORD_TABLE_SQL = "CREATE TABLE " + TABLE_WORK + " (" +
            ID_COLUMN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            NAMEWORK_COLUMN + " TEXT NOT NULL," +
            TIME_COLUMN +
            ")";

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Thực thi các câu lệnh tạo bảng
        //Sử dụng db.execSQL(sql); chạy câu lênh sql tạo bảng
        db.execSQL(CREATE_WORD_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Gọi khi bạn thay đổi DATABASE_VERSION
        //Thường sử dụng để thay đổi cấu trúc bảng (ALTER, DROP, ADD CONSTRAIN...)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORK);
        onCreate(db);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private int count = 0;

    //Select Data
    public Work getWork(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Work work = null;
        Cursor cursor = db.query(TABLE_WORK, new String[]{ID_COLUMN, NAMEWORK_COLUMN, TIME_COLUMN}, ID_COLUMN + " = ?",
                new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            work = new Work(cursor.getInt(0), cursor.getString(1), cursor.getFloat(2));
            cursor.close();
        }
        db.close();
        return work;
    }

    //
    public List<Work> getAllWork() {
        SQLiteDatabase db = getReadableDatabase();
        List<Work> words = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_WORK;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                words.add(new Work(cursor.getInt(0), cursor.getString(1), cursor.getFloat(2)));
            } while (cursor.moveToNext());
            cursor.close();
        }

        db.close();
        return words;
    }
    //Insert Data
    public boolean insertWork(Work work) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_COLUMN, count++);
        values.put(NAMEWORK_COLUMN, work.getNameWork());
        values.put(TIME_COLUMN, work.getTime());
        long rowId = db.insert(TABLE_WORK, null, values);
        db.close();
        if (rowId != -1) return true;
        return false;
    }

    //Update Data
    public int updateWork(Work work) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAMEWORK_COLUMN, work.getNameWork());
        values.put(TIME_COLUMN, work.getTime());
        int rowEffect = db.update(TABLE_WORK, values, ID_COLUMN + "= ?", new String[]{String.valueOf(work.getId())});
        db.close();
        return rowEffect;
    }

    //DeleteData
    public int deleteWord(Work work) {
        SQLiteDatabase db = getReadableDatabase();
        int rowEffect = db.delete(TABLE_WORK, ID_COLUMN + " = ?", new String[]{String.valueOf(work.getId())});
        db.close();
        return rowEffect;
    }

}
