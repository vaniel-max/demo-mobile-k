package com.example.demomobilv4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class AddActivity extends AppCompatActivity {

    TextInputLayout inputCodigo, inputValor, inputDescripcion;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        inputValor = findViewById(R.id.tiValorLO);
        inputDescripcion = findViewById(R.id.tiDescripcionLO);
        addButton = findViewById(R.id.addButtonLO);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addParametro(inputValor.getEditText().getText().toString().trim(),
                                  inputDescripcion.getEditText().getText().toString().trim()
                );
            }
        });
    }
}