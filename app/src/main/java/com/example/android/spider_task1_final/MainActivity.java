package com.example.android.spider_task1_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.android.spider_task1_final.R;
import com.example.android.spider_task1_final.secondActivity;

import java.util.ArrayList;
import java.util.Arrays;

import static android.R.attr.x;
import static android.R.id.list;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtinput;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView =(ListView) findViewById(R.id.list_view);
        String[] items={""};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.input_item,arrayList);
        listView.setAdapter(adapter);
        txtinput = (EditText) findViewById(R.id.item_to_be_added);
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem=txtinput.getText().toString();
                arrayList.add(newItem);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(MainActivity.this,secondActivity.class);
                intent.putExtra("ItemName",listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
        Button deleteBtn =(Button) findViewById(R.id.remove);
        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText x = (EditText) findViewById(R.id.pos_to_be_removed);
                String s=x.getText().toString();
                Log.i("the position is",s);
                int position=Integer.parseInt(""+s);
                arrayList.remove(position);
                adapter.notifyDataSetChanged();

            }});
    }
}