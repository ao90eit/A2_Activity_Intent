package com.aoinc.a2_activity_intent.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aoinc.a2_activity_intent.Models.FoodMenuItem;
import com.aoinc.a2_activity_intent.R;

import javax.xml.transform.Result;

public class MenuFoodItem1 extends AppCompatActivity {

    private float basePrice = 6.65f;

    private ImageView photo_image;
    private TextView title_text;
    private TextView price_text;
    private EditText amount_edit;
    private TextView special_edit;
    private Button add_button;

    public static final String DATA_TAG = "foodItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food1);

        photo_image = findViewById(R.id.food_imageview);
        title_text = findViewById(R.id.title_textview);
        price_text = findViewById(R.id.price_textview);
        amount_edit = findViewById(R.id.amount_edittext);
        special_edit = findViewById(R.id.special_edittext);
        add_button = findViewById(R.id.addtoorder_button);

        price_text.setText("$ " + String.valueOf(basePrice));

        amount_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    int amount = Integer.parseInt(s.toString());
                    float newprice = amount * basePrice;
                    // TODO: figure out how to get string format to work for decimal places without crashing...
                    price_text.setText("$ " + String.valueOf(newprice));
                }
                catch (final NumberFormatException e) { }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amount = 1;
                try {
                    amount = Integer.parseInt(amount_edit.getText().toString());
                }
                catch (final NumberFormatException e) { }

                float price = basePrice * amount;

                FoodMenuItem foodItem = new FoodMenuItem(R.drawable.zucchini_pasta, title_text.getText().toString(),
                        price, amount, special_edit.getText().toString());

                Intent intent = new Intent();
                intent.putExtra(DATA_TAG, foodItem);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
