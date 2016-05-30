package at.ac.univie.labofthings.activity.admin;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import at.ac.univie.labofthings.R;
import at.ac.univie.labofthings.backend.preset.Preset;
import at.ac.univie.labofthings.backend.preset.PresetQuery;

public class AdminPresetManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Preset Management");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_preset_management);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //Register handler to create a new preset...
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AdminPresetCreation.class);
                intent.putExtra("Edit", false);
                startActivity(intent);
            }
        });

        BuildPresetTable();
    }

    /**
     * Table for each preset in the given context
     */
    protected void BuildPresetTable()
    {
        TableLayout presetTable = (TableLayout)findViewById(R.id.tbl_presetTable);

        TableRow tableHeaderRow = new TableRow(this);

        final TextView presetName = new TextView(this);
        presetName.setTypeface(null, Typeface.BOLD);
        presetName.setGravity(Gravity.CENTER_HORIZONTAL);
        presetName.setText("Preset Name");
        tableHeaderRow.addView(presetName);

        TextView sensorsCount = new TextView(this);
        sensorsCount.setTypeface(null, Typeface.BOLD);
        sensorsCount.setGravity(Gravity.CENTER_HORIZONTAL);
        sensorsCount.setText("Sensor Count");
        tableHeaderRow.addView(sensorsCount);

        TextView editText = new TextView(this);
        editText.setTypeface(null, Typeface.BOLD);
        editText.setGravity(Gravity.CENTER_HORIZONTAL);
        editText.setText("Edit");
        tableHeaderRow.addView(editText);

        presetTable.addView(tableHeaderRow);

        TableRow spaceRow = new TableRow(this);
        spaceRow.setPadding(0,100,0,0);

        tableHeaderRow.addView(spaceRow);

        //List each each preset...
        for(Preset preset : PresetQuery.getPresetList())
        {
            TableRow presetRow = new TableRow(this);

            TextView presetText = new TextView(this);
            presetText.setText(preset.Name);
            presetRow.addView(presetText);

            TextView objectCount = new TextView(this);

            objectCount.setText(Integer.toString(preset.getObjects().size()));
            presetRow.addView(objectCount);

            Button btn_edit = new Button(this);

            final String finalPresetName = preset.Name;
            final int finalSensorCount = preset.getObjects().size();
            btn_edit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent AdminPresetCreation = new Intent(getBaseContext(), AdminPresetCreation.class);
                    AdminPresetCreation.putExtra("Edit", true);
                    AdminPresetCreation.putExtra("PresetName", finalPresetName);
                    AdminPresetCreation.putExtra("SensorCount", finalSensorCount);

                    startActivity(AdminPresetCreation);
                }
            });
            btn_edit.setText("Edit");
            presetRow.addView(btn_edit);

            presetTable.addView(presetRow);
        }
    }
}
