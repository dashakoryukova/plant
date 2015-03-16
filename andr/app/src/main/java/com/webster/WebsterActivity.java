package com.webster;

import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class WebsterActivity extends Activity implements OnClickListener
{
	private ListView lv1;
	private static final int STOPSPLASH = 0;
	private static final long SPLASHTIME = 1800;
	private ImageView splash;
    Button btnActTwo;
 //массив разделов
 private String lv_arr[]={"00. раст 0.","01. раст 1.","02. раст2"};
 
 private Handler splashHandler = new Handler() {

     @Override
     public void handleMessage(Message msg) {
             switch (msg.what) {
             case STOPSPLASH:

                     splash.setVisibility(View.GONE);
                     break;
             }
             super.handleMessage(msg);
     }
};

@Override
 
 	public void onCreate(Bundle icicle)
 	{
	 	super.onCreate(icicle);

        setContentView(R.layout.main);

        btnActTwo = (Button) findViewById(R.id.buttonConverter);
        btnActTwo.setOnClickListener(this);

 
 		setContentView(R.layout.main);
        //получаем индентификатор ImageView с Splash картинкой
        splash = (ImageView) findViewById(R.id.splashscreen);
        Message msg = new Message();
        msg.what = STOPSPLASH;
        splashHandler.sendMessageDelayed(msg, SPLASHTIME);
 		
		 lv1=(ListView)findViewById(R.id.lister); // Получим идентификатор ListView
		 lv1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr)); //устанавливаем массив в ListView
		 lv1.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
		 lv1.setOnItemClickListener(new OnItemClickListener() {
			 public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                 //Позиция элемента, по которому щелкнули
				String itemname = new Integer(position).toString();

			 	Intent intent = new Intent();
				intent.setClass(WebsterActivity.this, ViewActivity.class);
					Bundle b = new Bundle();
					b.putString("defStrID", itemname); //defStrID содержит строку, которую отправим через itemname в другое Activity
					intent.putExtras(b);
				startActivity(intent);
				 }
		 });
 	}

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonConverter:
                Intent intent = new Intent(this, AddNewPlant.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}