package com.example.smartrack.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smartrack.R;

public class AddItem extends AppCompatActivity {

    EditText itemName, itemSerialNumber, itemVertexId, itemValue, itemWeight;
    Button btnAddItem;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemName=(EditText) findViewById(R.id.editTextItemName);
        itemSerialNumber=(EditText) findViewById(R.id.editTextItemSerialNumber);
        itemVertexId=(EditText) findViewById(R.id.editTextVertexIdNumber);
        itemValue=(EditText) findViewById(R.id.editTextValueNumber);
        itemWeight=(EditText) findViewById(R.id.editTextWeightNumber);
        btnAddItem = findViewById(R.id.addItemButton);

        Intent i=getIntent();
        int vertexId = i.getIntExtra("vertexId",1);
        itemVertexId.setText(vertexId);

    }
}