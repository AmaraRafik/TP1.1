package com.example.agenda;

import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private List<String> events = new ArrayList<>();
    private RecyclerView recyclerView;
    private EventAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EventAdapter(events);
        recyclerView.setAdapter(adapter);

        FloatingActionButton addButton = findViewById(R.id.addEventButton);
        addButton.setOnClickListener(view -> showDatePickerDialog());
    }

    private void showDatePickerDialog() {
        // Obtient la date courante comme date initiale du sélecteur
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Crée et affiche un DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, monthOfYear, dayOfMonth) -> {
            String date = String.format(Locale.getDefault(), "%d-%02d-%02d", year1, monthOfYear + 1, dayOfMonth);
            addEvent(date);
        }, year, month, day);

        datePickerDialog.show();
    }

    private void addEvent(String date) {
        // Ajoute l'événement avec la date sélectionnée
        String newEvent = "Event on " + date;
        events.add(newEvent);
        adapter.notifyItemInserted(events.size() - 1);
    }
}
