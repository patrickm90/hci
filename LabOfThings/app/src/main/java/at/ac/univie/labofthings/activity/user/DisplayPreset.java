package at.ac.univie.labofthings.activity.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

import at.ac.univie.labofthings.R;
import at.ac.univie.labofthings.backend.interaction.InteractionObject;
import at.ac.univie.labofthings.backend.preset.PresetQuery;

public class DisplayPreset extends AppCompatActivity {

    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_display_preset);
        setTitle("Lab show preset");
        Intent i=getIntent();
        String presetName = i.getStringExtra("preset");
       int sensorCount= (int)((Math.random()) * 6 + 1);
            for(int j = 0; j < sensorCount; j++){
                addSensor(presetName);
             }

    }


    protected void BuildTable()
    {
        TableLayout presetTable = (TableLayout)findViewById(R.id.tbl_presetTable);

        TableRow presetNameRow = new TableRow(this);
        TextView presetNameLabel = new TextView(this);
        presetNameLabel.setText("Name of the Preset:");
        EditText presetNameText = new EditText(this);
       /* if(!presetName.equals(""))
            presetNameText.setText(presetName);*/


        presetNameRow.addView(presetNameLabel);
        presetNameRow.addView(presetNameText);

        presetTable.addView(presetNameRow);
    }


    protected void addSensor(String presetName)
    {

        TextView tv=(TextView)findViewById(R.id.displayPresetName);
        tv.setText(presetName);

        InteractionObject interactionObject = PresetQuery.generateRandomInterActionObject(count);
        count++;

        TableLayout sensorTable = (TableLayout)findViewById(R.id.tbl_sensorTable);
        TableRow sensorRow = new TableRow(this);


        TextView sensorNameLabel = new TextView(this);
        sensorNameLabel.setText(interactionObject.getClass().getSimpleName() + " " + count);

        SeekBar slider = new SeekBar(this);
        slider.setProgress(new Random().nextInt(100));

        sensorRow.addView(sensorNameLabel);
        sensorRow.addView(slider);

        sensorTable.addView(sensorRow);
    }
}
