package com.example.gatheringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddChalet extends AppCompatActivity {
DataBaseHelper db ;
    EditText EditName , EditPrice , EditDec , EditAddress;
    Button AddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chalet);


        EditName = (EditText) findViewById(R.id.EditName);
        EditPrice = (EditText) findViewById(R.id.EditPrice);
        EditAddress = (EditText)  findViewById(R.id.EditAddress);
        EditDec = (EditText)  findViewById(R.id.EditDec);

        AddButton = (Button)  findViewById(R.id.AddButton);

        db = new DataBaseHelper(this);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String name = EditName.getText().toString();
               int Price =Integer.parseInt (EditPrice.getText().toString());
               String address = EditAddress.getText().toString();
               String description = EditDec.getText().toString();


                Chalet chalet = new Chalet(name , -1   ,description, address , Price);
             boolean added =   db.addChalet(chalet);
                Toast.makeText(AddChalet.this , "Chalet added " + added, Toast.LENGTH_SHORT).show();

            }
        });

    }
}