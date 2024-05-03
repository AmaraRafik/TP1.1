package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {
    TextView labelFirstName, labelLastName, labelAge, labelSkill, labelPhone;
    Button okButton, backButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        labelFirstName = findViewById(R.id.labelFirstName);
        labelLastName = findViewById(R.id.labelLastName);
        labelAge = findViewById(R.id.labelAge);
        labelSkill = findViewById(R.id.labelSkill);
        labelPhone = findViewById(R.id.labelPhone);


        okButton = findViewById(R.id.okButton);
        backButton = findViewById(R.id.backButton);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String firstName = extras.getString("firstName");
            String lastName = extras.getString("lastName");
            String age = extras.getString("age");
            String skill = extras.getString("skill");
            String phone = extras.getString("phone");

            // Set text with the received data
            labelFirstName.setText(getString(R.string.labelFirstName) + " : " + firstName);
            labelLastName.setText(getString(R.string.labelLastName) + " : " + lastName);
            labelAge.setText(getString(R.string.labelAge) + " : " + age);
            labelSkill.setText(getString(R.string.labelSkill)+ " : "  + skill);
            labelPhone.setText(getString(R.string.labelPhone)+ " : "  + phone);
        }

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                if (extras != null) {
                    String phone = extras.getString("phone");
                    intent.putExtra("phone", phone);
                }
                startActivity(intent);
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
