package at.ac.univie.labofthings.activity.monitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import at.ac.univie.labofthings.R;
import at.ac.univie.labofthings.backend.interaction.InteractionObject;

public class MonitorShowCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_show_category);
        InteractionObject.TypOfCategory category = MonitorRandomDataHolder.getCategory();
        List<InteractionObject> allSensors = MonitorRandomDataHolder.getAllSensors();

        //getObjectsByCat

    }

    //filter the input list and returns a list containing only of the desired category
    private List<InteractionObject> getObjectsByCat(List<InteractionObject> fullList, InteractionObject.TypOfCategory category) throws Exception {
        List<InteractionObject> newList = null;
        for (InteractionObject currentObject :  fullList){
            if ((currentObject.getCatgory() != null)&&(currentObject.getCatgory() == category)){
                newList.add(currentObject);
            }
        }
        return newList;
    }

    private void generateTable(List<InteractionObject> allObjects){
        TableLayout frameSensors = (TableLayout) findViewById(R.id.frameSensors);

        for (InteractionObject currentObject :  allObjects){
            InteractionObject.DamageState actDamage = currentObject.checkForPossibleDamage();
            //generate the "all sensors table"
            //generate table header
            TableRow tableHeading = new TableRow(this);
            TableRow.LayoutParams thLp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);

            tableHeading.setLayoutParams(thLp);
            TextView thObjectName = new TextView(this);
            thObjectName.setText(R.string.monitorThName);
            TextView thDamageState = new TextView(this);
            thDamageState.setText(R.string.monitorThDamageState);
            TextView thDescription = new TextView(this);
            thDescription.setText(R.string.monitorThDescription);
            TextView thOnOffState = new TextView(this);
            thOnOffState.setText(R.string.monitorThOnoffState);
            TextView thCategory = new TextView(this);
            try {
                thCategory.setText(currentObject.getCatgory().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }


            tableHeading.addView(thObjectName);
            tableHeading.addView(thDamageState);
            tableHeading.addView(thDescription);
            tableHeading.addView(thOnOffState);
            tableHeading.addView(thCategory);
            try {
                frameSensors.addView(tableHeading);
            } catch (Exception e) {
                e.printStackTrace();
            }


            //generate content of "all sensor table"
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            TextView objectName = new TextView(this);
            objectName.setText(currentObject.getName());
            TextView damageState = new TextView(this);
            damageState.setText(actDamage.toString());
            TextView description = new TextView(this);
            description.setText(currentObject.getDescription());
            TextView onOffState = new TextView(this);
            onOffState.setText(currentObject.getOnOffState().toString());
            TextView category = new TextView(this);
            try {
                category.setText(currentObject.getCatgory().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }


            row.addView(objectName);
            row.addView(damageState);
            row.addView(description);
            row.addView(onOffState);
            row.addView(category);
            try {
                frameSensors.addView(row);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




}
