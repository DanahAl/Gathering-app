package com.example.gatheringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddChalet extends AppCompatActivity {
DataBaseHelper db ;
    EditText EditName , EditPhone;
    Button AddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chalet);


        EditName = (EditText) findViewById(R.id.EditName);
        EditPhone = (EditText) findViewById(R.id.EditPhone);
        AddButton = (Button)  findViewById(R.id.AddButton);

        db = new DataBaseHelper(this);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String name = EditName.getText().toString();
               int Price =Integer.parseInt (EditPhone.getText().toString());


                Chalet chalet = new Chalet(name , Price);
                db.addChalet(chalet);
                Toast.makeText(AddChalet.this , "Chalet added", Toast.LENGTH_SHORT).show();

            }
        });

    }
}