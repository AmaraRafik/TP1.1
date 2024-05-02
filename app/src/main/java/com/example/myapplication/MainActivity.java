package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);

        TextView labelFirstName = new TextView(this);
        labelFirstName.setText("Prénom");
        layout.addView(labelFirstName);

        EditText firstName = new EditText(this);
        layout.addView(firstName);

        TextView labelLastName = new TextView(this);
        labelLastName.setText("Nom");
        layout.addView(labelLastName);

        EditText lastName = new EditText(this);
        layout.addView(lastName);

        TextView labelAge = new TextView(this);
        labelAge.setText("Âge");
        layout.addView(labelAge);

        EditText age = new EditText(this);
        age.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        layout.addView(age);

        TextView labelSkill = new TextView(this);
        labelSkill.setText("Domaine de compétences");
        layout.addView(labelSkill);

        EditText skill = new EditText(this);
        layout.addView(skill);

        TextView labelPhone = new TextView(this);
        labelPhone.setText("Numéro de téléphone");
        layout.addView(labelPhone);

        EditText phone = new EditText(this);
        phone.setInputType(android.text.InputType.TYPE_CLASS_PHONE);
        layout.addView(phone);

        Button submitButton = new Button(this);
        submitButton.setText("Valider");
        submitButton.setBackgroundColor(Color.rgb(1,56,53));
        layout.addView(submitButton);

        setContentView(layout);
    }
}
