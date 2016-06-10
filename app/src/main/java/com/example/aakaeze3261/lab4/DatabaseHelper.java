package com.example.aakaeze3261.lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aakaeze3261 on 6/3/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "students";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_MARKS = "marks";
    public static final String COLUMN_ID = "id";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table students (id integer primary key not null auto_increment, " +
            "firstname text not null, lastname text not null, marks integer not null);";

    public DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME,  null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public  void AddUser(AddInfo add)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRSTNAME, add.GetFirstName());
        values.put(COLUMN_LASTNAME, add.GetLastName());
        values.put(COLUMN_MARKS, add.GetMarks());
        values.put(COLUMN_ID, add.GetID());

        db.insert(TABLE_NAME, null , values);
        db.close();
    }

    public List<AddInfo> getAllUsers()
    {
        //GET ALL INFORMATION ON DB
        List<AddInfo> Listusers = new ArrayList<AddInfo>();

        String selectUsers = "SELECT *FROM*" + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectUsers, null);

        if(cursor.moveToFirst())
        {
            do{
                AddInfo addInfo = new AddInfo();

                addInfo.SetFirstName(cursor.getString(0));
                addInfo.SetLastName((cursor.getString(1)));
                addInfo.SetMarks((cursor.getString(2)));
                addInfo.SetID((cursor.getString(3)));
                //Add Users to List
                Listusers.add(addInfo);
            }
            while (cursor.moveToNext());
        }
        return Listusers;
    }

    public int getUsersNumber()
    {
        String countUsersQuery = "SELECT *FROM*" + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countUsersQuery, null);
        cursor.close();

        //return countUsers
        return cursor.getCount();
    }

    public void deleteUser(AddInfo add)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "=?",
                new String[] {String.valueOf(add.GetID())});
        db.close();
    }

    ////////START FROM PAGE 54 ////////////


    @Override
    public  void  onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);

        this.onCreate(db);
    }



}
