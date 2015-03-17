package com.webster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Plant extends Activity {
    private ListView listView;
    private String lv_arr[]={"00. фото 0.","01. фото 1.","02. фото2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);


        listView = (ListView) findViewById(R.id.lister); // Получим идентификатор ListView
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lv_arr)); //устанавливаем массив в ListView
        listView.setTextFilterEnabled(true);
        //Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Позиция элемента, по которому щелкнули
                String itemname = new Integer(position).toString();

                Intent intent = new Intent();
                intent.setClass(Plant.this, ViewActivity.class);
                Bundle b = new Bundle();
                b.putString("defStrID", itemname); //defStrID содержит строку, которую отправим через itemname в другое Activity
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_plant, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
