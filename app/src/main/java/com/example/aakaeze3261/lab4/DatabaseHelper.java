package com.example.aakaeze3261.lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aakaeze3261 on 6/3/2016.
 */

//This class manages all database operations

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "students";

    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_MARKS = "marks";
    public static final String COLUMN_ID = "id";

    SQLiteDatabase db;
    /*private static final String TABLE_CREATE = "create table students (id integer primary key not null auto_increment, " +
            "firstname text not null, lastname text not null, marks integer not null);";*/

    //DBHelper constructor
    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //This method creates the Database for the program "execSQL" executes the
    //Table create method created above

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(
                "Create Table" + TABLE_NAME + "("+ COLUMN_ID +" integer primary key, "+ COLUMN_FIRSTNAME +
                        " text, "+ COLUMN_LASTNAME+ " text, "+COLUMN_MARKS+" text)"
        );
        this.db = db;
    }

    // This method handles all data inserted into the database
    public  boolean AddUser(String view_firstname, String view_lastname, String view_marks, String view_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRSTNAME, view_firstname);
        values.put(COLUMN_LASTNAME, view_lastname);
        values.put(COLUMN_MARKS, view_marks);

        db.insert(TABLE_NAME, null , values);
        db.close();

        return true;
    }

    // This method handles all data inserted into the database
    public  boolean UpdateUser(String view_firstname, String view_lastname, String view_marks, String view_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRSTNAME, view_firstname);
        values.put(COLUMN_LASTNAME, view_lastname);
        values.put(COLUMN_MARKS, view_marks);

        db.update(TABLE_NAME, values, COLUMN_ID+ "= ?", new String[]{Integer.toString(id)});
        db.close();

        return true;
    }

    // This method handles all deleted data from the database
    public Integer deleteUser(Integer view_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { Integer.toString(view_id)});
    }

    public ArrayList<AddInfo> getAllUsers()
    {
        //GET ALL INFORMATION ON DB
        ArrayList<AddInfo> List_users = new ArrayList<AddInfo>();

        AddInfo newAddInfo = new AddInfo();

        SQLiteDatabase db = this.getWritableDatabase();
        String selectUsers = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectUsers, null);
        cursor.moveToFirst();

        if(cursor.moveToFirst())
        {
            do{

                AddInfo addInfo = new AddInfo();

                addInfo.view_id = cursor.getString(cursor.getColumnIndex(COLUMN_ID));
                addInfo.view_firstname = cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME));
                addInfo.view_lastname = cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME));
                addInfo.view_marks = cursor.getString(cursor.getColumnIndex(COLUMN_MARKS));

                //Add Users to List
                List_users.add(addInfo);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return List_users;
    }

    ////////////////////////////////////////////
    public Cursor getUsers(int view_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String countUsers = "SELECT * FROM " + TABLE_NAME + "where" + COLUMN_ID + "=" +view_id+ "";
        Cursor cursor = db.rawQuery(countUsers, null);
        //return countUsers
        return cursor;
    }
    //////////////////////////

    public int all_rows()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int allrows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return  allrows;
    }


    @Override
    public  void  onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);

        this.onCreate(db);
    }


}
