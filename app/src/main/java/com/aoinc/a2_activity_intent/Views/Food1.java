package com.aoinc.a2_activity_intent.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aoinc.a2_activity_intent.Models.FoodMenuItem;
import com.aoinc.a2_activity_intent.R;

import javax.xml.transform.Result;

public class Food1 extends AppCompatActivity {

    private ImageView photo_image;
    private TextView title_text;
    private TextView price_text;
    //    private TextView amount_text;
    private TextView special_edit;
    private Button add_button;

    //    private NumberPicker numPicker;

    public static final String DATA_TAG = "foodItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food1);

        photo_image = findViewById(R.id.food_imageview);
        title_text = findViewById(R.id.title_textview);
        price_text = findViewById(R.id.price_textview);
//        amount_text = findViewById(R.id.amount_textview);
        special_edit = findViewById(R.id.special_edittext);
        add_button = findViewById(R.id.addtoorder_button);

//        System.out.println(R.drawable.zucchini_pasta);

//        numPicker = findViewById(R.id.numberPicker);
//        numPicker.setMinValue(1);
//        numPicker.setMinValue(5);
//        numPicker.setValue(1);

//        numPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//
//            }
//        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float price = Float.parseFloat(price_text.getText().toString().substring(2));
//                float price = 6.65f;
//                int amount = Integer.parseInt(amount_text.getText().toString().substring(2));

                FoodMenuItem foodItem = new FoodMenuItem(R.drawable.zucchini_pasta, title_text.getText().toString(),
                        price, 1, special_edit.getText().toString());

                Intent intent = new Intent();
                intent.putExtra(DATA_TAG, foodItem);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
