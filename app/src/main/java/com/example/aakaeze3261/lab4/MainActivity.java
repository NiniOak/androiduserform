package com.example.aakaeze3261.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //Declare all properties in the app here

    EditText FirstName, LastName, Marks, ID;
    ImageButton add_btn;
    ListView UserList = null;
    List<AddInfo> UserInfo;
    DatabaseHelper dbconnect;

    public MainActivity()
    {
        //Add all student to array in lists
        UserInfo = new ArrayList<AddInfo>();

        //Instantiate db object


        dbconnect = new DatabaseHelper(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewusers);

        UserList = ()
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
