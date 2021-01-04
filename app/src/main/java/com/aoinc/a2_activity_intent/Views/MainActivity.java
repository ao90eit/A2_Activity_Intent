package com.aoinc.a2_activity_intent.Views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aoinc.a2_activity_intent.R;
import com.aoinc.a2_activity_intent.Models.FoodMenuItem;

public class MainActivity extends AppCompatActivity {

    private ImageView foodItem1_image;
    private TextView foodTitle1_text;
    private TextView foodPrice1_text;
    private TextView special1_text;

    // menu food item image
    private ImageView menuItem1_image;
    private final int REQUEST_CODE = 1337;

    private Button completeOrder_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuItem1_image = findViewById(R.id.menuitem1_image);
        menuItem1_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Food1.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        foodItem1_image = findViewById(R.id.food1_image);
        foodTitle1_text = findViewById(R.id.foodtitle1_textview);
        foodPrice1_text = findViewById(R.id.foodprice1_textview);
        special1_text = findViewById(R.id.special1_textview);

        completeOrder_button = findViewById(R.id.completeorder_button);
        completeOrder_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodItem1_image.setImageResource(android.R.color.transparent);
                foodTitle1_text.setText(null);
                foodPrice1_text.setText(null);
                special1_text.setText(null);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            FoodMenuItem foodMenuItem = (FoodMenuItem) data.getSerializableExtra(Food1.DATA_TAG);

            foodItem1_image.setImageResource(foodMenuItem.getImageResourceID());
            foodTitle1_text.setText(foodMenuItem.getFoodName());
            foodPrice1_text.setText(String.valueOf(foodMenuItem.getFoodPrice()));
            special1_text.setText(foodMenuItem.getSpecialInstructions());
        }
    }
}