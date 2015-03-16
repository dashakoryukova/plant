package com.webster;

import android.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.view.View.OnClickListener;

import com.webster.model.Plant;

/**
 * Created by Bublik on 10.03.2015.
 */
public class AddNewPlant  extends Activity implements OnClickListener {
private static int count=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnewplant);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addPlant:
                 EditText nameEditText = (EditText)findViewById(R.id.plantsName);
               String name=nameEditText.getText().toString();
                EditText descEditText = (EditText)findViewById(R.id.plantsDescription);
                String desc=descEditText.getText().toString();
               Plant plant = new Plant(count+"");
                plant.setName(name);
                plant.setDescription(desc);
                System.out.println(plant.getId()+" "+plant.getName()+" "+plant.getDescription());
                count++;
                Intent intent = new Intent(this, WebsterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


}
