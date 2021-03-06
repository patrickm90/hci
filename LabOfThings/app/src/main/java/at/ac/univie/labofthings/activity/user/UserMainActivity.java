package at.ac.univie.labofthings.activity.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import at.ac.univie.labofthings.R;
import at.ac.univie.labofthings.backend.preset.PresetQuery;

public class UserMainActivity extends AppCompatActivity {

    PresetQuery presets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_main);
        setTitle("Lab");
        presets=new PresetQuery();
        Button frequency1= (Button)findViewById(R.id.frequencyButton1);
        Button frequency2= (Button)findViewById(R.id.frequencyButton2);
        Button frequency3= (Button)findViewById(R.id.frequencyButton3);
        Button showAllButton= (Button)findViewById(R.id.showAllButton);
        Button searchButton=(Button)findViewById(R.id.doSearchButton);

        frequency1.setText(presets.getPresetList().get(1).Name);
        frequency2.setText(presets.getPresetList().get(2).Name);
        frequency3.setText(presets.getPresetList().get(3).Name);


        frequency1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(UserMainActivity.this, DisplayPreset.class);
                intent.putExtra("preset", presets.getPresetList().get(1).Name);
                startActivity(intent);
            }
        });
        frequency2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(UserMainActivity.this, DisplayPreset.class);
                intent.putExtra("preset", presets.getPresetList().get(2).Name);
                startActivity(intent);
            }
        });
        frequency3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(UserMainActivity.this, DisplayPreset.class);
                intent.putExtra("preset", presets.getPresetList().get(3).Name);
                startActivity(intent);
            }
        });

        showAllButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(UserMainActivity.this,TotalPresetList.class);
                startActivity(intent);
            }
        });


        searchButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent intent = new Intent(UserMainActivity.this,DisplayPreset.class);
                intent.putExtra("preset", presets.getPresetList().get((int)((Math.random()) * 3 + 1)).Name);
                startActivity(intent);
            }
        });
    }
}
