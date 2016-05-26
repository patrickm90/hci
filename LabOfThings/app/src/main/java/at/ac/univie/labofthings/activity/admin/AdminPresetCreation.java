package at.ac.univie.labofthings.activity.admin;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

import at.ac.univie.labofthings.R;
import at.ac.univie.labofthings.backend.interaction.InteractionObject;
import at.ac.univie.labofthings.backend.preset.PresetQuery;

public class AdminPresetCreation extends AppCompatActivity {
    private static int count = 0;
    private String presetName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_preset_creation);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSensor();
            }
        });

        if(this.getIntent().getBooleanExtra("Edit", false))
        {
            int sensorCount = this.getIntent().getIntExtra("SensorCount", 0);
            presetName = this.getIntent().getStringExtra("PresetName");

            for(int i = 0; i < sensorCount; i++)
                addSensor();
        }


        BuildTable();
    }
    protected void BuildTable()
    {
        TableLayout presetTable = (TableLayout)findViewById(R.id.tbl_presetTable);

        TableRow presetNameRow = new TableRow(this);
        TextView presetNameLabel = new TextView(this);
        presetNameLabel.setText("Name of the Preset:");
        EditText presetNameText = new EditText(this);
        if(!presetName.equals(""))
            presetNameText.setText(presetName);


        presetNameRow.addView(presetNameLabel);
        presetNameRow.addView(presetNameText);

        presetTable.addView(presetNameRow);
    }
    protected void addSensor()
    {
        if(count > 100)
            count = 0;

        InteractionObject interactionObject = PresetQuery.generateRandomInterActionObject(count);
        count++;

        TableLayout sensorTable = (TableLayout)findViewById(R.id.tbl_sensorTable);
        TableRow sensorRow = new TableRow(this);
        TextView sensorNameLabel = new TextView(this);
        sensorNameLabel.setText(interactionObject.getClass().getSimpleName().substring(0,4) + " " + count);

        SeekBar slider = new SeekBar(this);
        slider.setProgress(new Random().nextInt(100));

        Button btnEdit = new Button(this);
        btnEdit.setText("Details");
        btnEdit.setEnabled(false);
        btnEdit.setWidth(50);
        btnEdit.setMaxWidth(50);

        sensorRow.addView(sensorNameLabel);
        sensorRow.addView(slider);
        sensorRow.addView(btnEdit);

        sensorTable.addView(sensorRow);


    }
    protected void btn_save_onClick(View v)
    {
        finish();
    }

}
