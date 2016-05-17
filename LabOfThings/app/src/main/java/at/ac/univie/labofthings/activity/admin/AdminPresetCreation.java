package at.ac.univie.labofthings.activity.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import at.ac.univie.labofthings.R;

public class AdminPresetCreation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_preset_creation);

        BuildTable();
    }
    protected void BuildTable()
    {
        TableLayout presetTable = (TableLayout)findViewById(R.id.tbl_presetTable);
        ListView list_sensors = (ListView) findViewById(R.id.list_sensors);
        

        TableRow presetNameRow = new TableRow(this);
        TextView presetNameLabel = new TextView(this);
        presetNameLabel.setText("Name");
        EditText presetNameText = new EditText(this);

        presetNameRow.addView(presetNameLabel);
        presetNameRow.addView(presetNameText);

        presetTable.addView(presetNameRow);





    }
}
