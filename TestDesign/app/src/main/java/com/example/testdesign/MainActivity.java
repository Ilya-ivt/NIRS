package com.example.testdesign;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
 /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

  */

    ArrayList<ListContend> listcontend = new ArrayList<ListContend>();
    ListAdapter listadapter;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // создаем адаптер
        fillData();
        listadapter = new ListAdapter(this, listcontend);

        // настраиваем список
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(listadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(parent.getContext(), Answer.class);
                startActivity(intent);
            }
        });



    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 10; i++) {
            listcontend.add(new ListContend(Integer.toString(i), "Вопрос" + i));
        }
    }


}

