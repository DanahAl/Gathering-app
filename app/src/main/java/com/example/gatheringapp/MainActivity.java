package com.example.gatheringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView chaletList;
    Button AddButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chaletList =(ListView) findViewById(R.id.chaletList);
        AddButton = (Button) findViewById(R.id.AddButton);

        ArrayList<Chalet> chalets = new ArrayList<>();
        chalets.add(new Chalet("chaletN1" , 1 , "The first chalet",
                "Riyadh , Alolya" , 500
        ));

        chalets.add(new Chalet("chaletN12" , 2 , "The sec chalet",
                "Riyadh , alhazm" , 440
        ));


        chalets.add(new Chalet("chaletN12" , 2 , "The sec chalet",
                "Riyadh , alhazm" , 440
        ));

        chalets.add(new Chalet("chaletN12" , 2 , "The sec chalet",
                "Riyadh , alhazm" , 440
        ));

        chalets.add(new Chalet("chaletN12" , 2 , "The sec chalet",
                "Riyadh , alhazm" , 440
        ));


        chalets.add(new Chalet("chaletN12" , 2 , "The sec chalet",
                "Riyadh , alhazm" , 440
        ));


        ChaletAdaptor chaletAdaptor = new ChaletAdaptor(this , R.layout.item_chalet , chalets);
        chaletList.setAdapter(chaletAdaptor);


        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AddChalet.class);

                startActivity(intent);
            }
        });
    }
}