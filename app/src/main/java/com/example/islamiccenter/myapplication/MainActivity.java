package com.example.islamiccenter.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buloginclick(View view) {
        EditText txt =(EditText)findViewById(R.id.editText);
        EditText txt1=(EditText)findViewById(R.id.editText2);


        Intent myintent = new Intent(this ,List_view.class);
//        Bundle b = new Bundle();
//        b.putString("username",txt.getText().toString());
//        b.putString("password",txt1.getText().toString());
//        myintent.putExtras(b);
        startActivity(myintent);

       // Toast.makeText(this, "logedin ", Toast.LENGTH_SHORT).show();
    }

    public void busignupclick(View view) {
        Intent myintent = new Intent(this,sign_up.class);

        startActivity(myintent);

    }
}
