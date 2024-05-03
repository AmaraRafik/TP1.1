package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;
import android.content.res.Resources;
import android.content.res.Configuration;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    EditText firstName, lastName, age, skill, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        age = findViewById(R.id.age);
        skill = findViewById(R.id.skill);
        phone = findViewById(R.id.phone);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogTheme);
        builder.setTitle(getString(R.string.boxConfirmationTitle));
        builder.setMessage(getString(R.string.boxConfirmationText));

        builder.setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeEditTextBackgroundColor(getResources().getColor(R.color.confirmationGreen));
                launchNextActivity();
            }
        });

        builder.setNegativeButton(getString(R.string.undo), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeEditTextBackgroundColor(getResources().getColor(R.color.errorRed));
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void launchNextActivity() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("firstName", firstName.getText().toString());
        intent.putExtra("lastName", lastName.getText().toString());
        intent.putExtra("age", age.getText().toString());
        intent.putExtra("skill", skill.getText().toString());
        intent.putExtra("phone", phone.getText().toString());

        startActivity(intent);
    }

    @SuppressLint("UnsafeIntentLaunch")
    public void onChangeLanguage(View view) {
        String languageCode = view.getId() == R.id.flag_france ? "fr" : "en";
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        finish();
        startActivity(getIntent());
    }

    private void changeEditTextBackgroundColor(int color) {
        firstName.setBackgroundColor(color);
        lastName.setBackgroundColor(color);
        age.setBackgroundColor(color);
        skill.setBackgroundColor(color);
        phone.setBackgroundColor(color);
    }
}

