package com.example.islamiccenter.myapplication;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class sign_up extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ListView list =(ListView)findViewById(R.id.listView);


    }


    public void bu_back_to_login(View view) {
        EditText user_name = (EditText) findViewById(R.id.editText5);
        EditText email = (EditText) findViewById(R.id.editText3);
        EditText password = (EditText) findViewById(R.id.editText4);

        String User_name = user_name.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();

        db.inset_data(User_name, Email, Password);



    Intent myintent = new Intent(this, MainActivity.class);

    startActivity(myintent);

}
    public void showdata() {
        ArrayList<String> listdata = db.getAlldata();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listdata);

    }
}