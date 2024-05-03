package com.example.traintimetables;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
public class MainActivity extends AppCompatActivity {

    private EditText departureCity;
    private EditText arrivalCity;
    private Button searchButton;
    private ListView trainScheduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        departureCity = findViewById(R.id.departureCity);
        arrivalCity = findViewById(R.id.arrivalCity);
        searchButton = findViewById(R.id.searchButton);
        trainScheduleList = findViewById(R.id.trainScheduleList);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTrains();
            }
        });
    }

    private void searchTrains() {
        String departure = departureCity.getText().toString();
        String arrival = arrivalCity.getText().toString();

        String[] trainTimes = {"06:00 AM", "08:00 PM","10:00 AM", "12:00 PM", "02:00 PM", "04:00 PM","06:00 PM"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, trainTimes);
        trainScheduleList.setAdapter(adapter);

        Toast.makeText(this, "Recherche de trains de " + departure + " à " + arrival, Toast.LENGTH_SHORT).show();
    }


}
