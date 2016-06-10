package com.example.aakaeze3261.lab4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by aakaeze3261 on 6/10/2016.
 */
public class AddUser extends Activity{

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddClick(View v)
    {
        if(v.getId()== R.id.add_button)
        {
            EditText firstname = (EditText)findViewById(R.id.FirstName);
            EditText lastname = (EditText)findViewById(R.id.LastName);
            EditText marks = (EditText)findViewById(R.id.Marks);
            EditText id = (EditText)findViewById(R.id.ID);

            String fnameuser = firstname.getText().toString();
            String lnameuser = lastname.getText().toString();
            String marksuser = marks.getText().toString();
            String iduser = id.getText().toString();

            AddInfo add = new AddInfo();
            add.SetFirstName(fnameuser);
            add.SetLastName(lnameuser);
            add.SetMarks(marksuser);
            add.SetID(iduser);


            helper.AddUser(add);

        }
    }
}
