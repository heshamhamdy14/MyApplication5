package com.example.islamiccenter.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class List_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ArrayList<ListItem> items=new ArrayList<>();
        items.add(new ListItem("hesham","tired man"));
        items.add(new ListItem("adel","noisy man"));
        items.add(new ListItem("mahmoud","bad man"));
        items.add(new ListItem("mohamed","tall man"));

        mycustom_adapter my_adapter = new mycustom_adapter(items);
        ListView ls=(ListView) findViewById(R.id.List_view);
        ls.setAdapter(my_adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txt_name=(TextView)view.findViewById(R.id.txt_name);
                TextView txt_desc=(TextView)view.findViewById(R.id.textView);
                Toast.makeText(getApplicationContext(),txt_name.toString(),Toast.LENGTH_LONG).show();

            }
        });


    }

    class mycustom_adapter extends BaseAdapter {

        ArrayList<ListItem>items=new ArrayList<>();
        mycustom_adapter(ArrayList<ListItem>items)
        {
            this.items=items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i).name;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater myinflater =getLayoutInflater();
            View myview =myinflater.inflate(R.layout.row_view,null);
            TextView txt_name=(TextView)myview.findViewById(R.id.txt_name);
            TextView txt_desc=(TextView)myview.findViewById(R.id.txt_desc);
            txt_name.setText(items.get(i).name);
            txt_desc.setText(items.get(i).desc);
            return myview;
        }
    }








}

