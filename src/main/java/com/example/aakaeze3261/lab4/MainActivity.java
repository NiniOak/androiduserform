package com.example.aakaeze3261.lab4;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.Display;
import android.view.Menu;
import android.view.View;
=======
import android.view.View;
import android.widget.AdapterView;
>>>>>>> c1bec4d568281eba7da1833c4b19da0567fdf04b
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //Declare all properties in the app here
<<<<<<< HEAD
    EditText FirstName, LastName, Marks, Email;
    DatabaseHelper helper;

=======

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
>>>>>>> c1bec4d568281eba7da1833c4b19da0567fdf04b

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_main);

        //Reference TextView and EditText from Activity_main.xml
        helper = new DatabaseHelper(this);
    }

    public void btn_click(View v)
    {
        if(v.getId()== R.id.add_button)
        {
            EditText firstname = (EditText)findViewById(R.id.FirstName);
            EditText lastname = (EditText)findViewById(R.id.LastName);
            EditText marks = (EditText)findViewById(R.id.Marks);
            EditText email = (EditText)findViewById(R.id.Email);

            String fnameuser = firstname.getText().toString();
            String lnameuser = lastname.getText().toString();
            String marksuser = marks.getText().toString();
            String emailuser = email.getText().toString();

            if (!emailuser.equals(emailuser))
            {
                Toast.makeText(MainActivity.this, "User Already exist", Toast.LENGTH_SHORT).show();
            }
            else {

                AddInfo add = new AddInfo();
                add.SetFirstName(fnameuser);
                add.SetLastName(lnameuser);
                add.SetMarks(marksuser);
                add.SetEmail(emailuser);

                helper.AddUser(add);
            }

        }
=======
        setContentView(R.layout.viewusers);

        UserList = ()
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

>>>>>>> c1bec4d568281eba7da1833c4b19da0567fdf04b
    }
}
