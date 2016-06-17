package com.example.aakaeze3261.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Declare all properties in the app here
    EditText FirstName, LastName, Marks, ID;
    TextView first_NameLabel, last_nameLabel, marksLabel, id_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference TextView and EditText from Activity_main.xml

        FirstName = (EditText)findViewById(R.id.FirstName);
        LastName = (EditText)findViewById(R.id.LastName);
        Marks = (EditText)findViewById(R.id.Marks);
        ID = (EditText)findViewById(R.id.ID);
        first_NameLabel = (TextView)findViewById(R.id.first_NameLabel);
        last_nameLabel = (TextView)findViewById(R.id.last_nameLabel);
        marksLabel = (TextView)findViewById(R.id.marksLabel);
        id_label = (TextView)findViewById(R.id.id_label);
    }
}
