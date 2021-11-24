package com.example.testlike;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView fruitView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<CharSequence> adapterFruit = ArrayAdapter.createFromResource(this, R.array.fruitsArray, android.R.layout.simple_list_item_1);
        fruitView.setAdapter(adapterFruit);

        fruitView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String message = getString(R.string.toastMessage) + adapterFruit.getItem(position);
               Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
           }
        });
    }
}