package at.ac.univie.labofthings.activity.admin;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_preset_management);

        BuildPresetTable();
    }
    protected void BuildPresetTable()
    {
        TableLayout presetTable = (TableLayout)findViewById(R.id.tbl_presetTable);

        TableRow tableHeaderRow = new TableRow(this);

        TextView presetName = new TextView(this);
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
            btn_edit.setText("Edit");
            presetRow.addView(btn_edit);

            presetTable.addView(presetRow);
        }
    }
}
