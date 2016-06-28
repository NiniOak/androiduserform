package com.example.aakaeze3261.lab4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aakaeze3261.lab4.DatabaseHelper;

/**
 * Created by aakaeze3261 on 6/10/2016.
 */
public class AddUser extends Activity {
    //Declare global variable where user information will be stored

    String user_id, user_firstname, user_lastname, user_marks;

    //Declare objects on View page to display stored information
    EditText view_firstname;
    EditText view_lastname;
    EditText view_marks;
    EditText view_id;

    //Declare objects buttons on view page to edit users
    Button view_updateuserbtn, view_deletebtn;

    DatabaseHelper dbconnect;


    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.viewlayout);
    }


=======

        //Set means through which content will be displayed

        setContentView(R.layout.viewusers);

        //initialize viewObjects method on this page
        this.viewObjects();

        //initialize Database for this page
        dbconnect = new DatabaseHelper(this);

        //Initialises data posted from main activity
        this.viewalldata();

        //The update button is linked to the AddUSer class and MAinactivity class
        view_updateuserbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent UserActivity = new Intent(AddUser.this, MainActivity.class);

                UserActivity.putExtra("ID", user_id);
                UserActivity.putExtra("firstname", user_firstname);
                UserActivity.putExtra("lastname", user_lastname);
                UserActivity.putExtra("marks", user_marks);

                //Start AddUser activity
                startActivity(UserActivity);

                //Close Screen
                finish();
            }
        });

        view_deletebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Close screen
                int id = Integer.parseInt(user_id);
                dbconnect.deleteUser(id);

                //dISPLAY A MESSAGE ON SCREEN WHEN DATA HAS BEEN DELETED
                Toast.makeText(getApplicationContext(), user_firstname+""+user_lastname+
                "User Deleted", Toast.LENGTH_SHORT);


                finish();
                startActivity(getIntent());
            }
        });

    }

    private void viewObjects()
    {
        //Defining objects on view page by names
        view_firstname = (EditText) findViewById(R.id.view_firstname);

        view_lastname = (EditText) findViewById(R.id.view_lastname);

        view_id= (EditText) findViewById(R.id.view_id);

        view_lastname = (EditText) findViewById(R.id.view_lastname);

        //Define buttons on View page
        view_updateuserbtn = (Button) findViewById(R.id.view_updateuserbtn);
        view_deletebtn = (Button) findViewById(R.id.view_deletebtn);

    }

    private  void viewalldata() {
        Intent i = getIntent();

        //Revieve all data posted by ID
        EditText view_firstname = (EditText) findViewById(R.id.view_firstname);
        String user_firstname  = view_firstname.getText().toString();

        EditText view_lastname = (EditText) findViewById(R.id.view_lastname);
        String user_lastname  = view_lastname.getText().toString();
>>>>>>> c1bec4d568281eba7da1833c4b19da0567fdf04b

        EditText view_marks = (EditText) findViewById(R.id.view_marks);
        String user_marks  = view_marks.getText().toString();

<<<<<<< HEAD
    public void onAddClick(View v)
    {
        if(v.getId()== R.id.view_button)
        {
            helper.getAllUsers();
        }
=======
        EditText view_id= (EditText) findViewById(R.id.view_id);
        String user_id = view_id.getText().toString();

        user_id = i.getStringExtra("ID");
        user_firstname = i.getStringExtra("firstname");
        user_lastname = i.getStringExtra("lastname");
        user_marks = i.getStringExtra("marks");

        //Set received data to be displayed
        view_id.setText(user_id);
        view_firstname.setText(user_firstname);
        view_lastname.setText(user_lastname);
        view_marks.setText(user_marks);

>>>>>>> c1bec4d568281eba7da1833c4b19da0567fdf04b
    }


}
