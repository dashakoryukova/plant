package com.webster;

import android.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import com.webster.model.Plant;

/**
 * Created by Bublik on 10.03.2015.
 */
public class AddNewPlant  extends Activity{
private static int count=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnewplant);
        Button addPlant = (Button) findViewById(R.id.addPlant);
        addPlant.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameEditText = (EditText)findViewById(R.id.plantsName);
                String name=nameEditText.getText().toString();
                EditText descEditText = (EditText)findViewById(R.id.plantsDescription);
                String desc=descEditText.getText().toString();
                Plant plant = new Plant(count+"");
                plant.setName(name);
                plant.setDescription(desc);
                System.out.println(plant.getId()+" "+plant.getName()+" "+plant.getDescription());
                count++;
                Intent intent = new Intent(getApplicationContext(), WebsterActivity.class);
                startActivity(intent);
            }
        });
    }
   /* @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addPlant:

                break;
            default:
                break;
        }*/

}
