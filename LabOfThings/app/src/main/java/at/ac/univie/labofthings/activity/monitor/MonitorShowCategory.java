package at.ac.univie.labofthings.activity.monitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;
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
        //set the title
        this.setTitle("Category: "+ MonitorRandomDataHolder.getCategory());

        //get all Objects of the given category
        try {
            List<InteractionObject> objects = getObjectsByCat(allSensors, category);

            //generate the table
            if (objects != null) {
                generateTable(objects);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //filter the input list and returns a list containing only of the desired category
    private List<InteractionObject> getObjectsByCat(List<InteractionObject> fullList, InteractionObject.TypOfCategory category) throws Exception {
        List<InteractionObject> newList =  new ArrayList<InteractionObject>();
        for (InteractionObject currentObject :  fullList){
            if ((currentObject != null)&&(currentObject.getCatgory() == category)){
                newList.add(currentObject);
            }
        }
        return newList;
    }


    //generates the table that shows all sensors of the given category
    private void generateTable(List<InteractionObject> allObjects){
        //get the Table layout for inserting the rows
        TableLayout frameSensors = (TableLayout) findViewById(R.id.frameSensors);

        //loops through all sensors and adds them to the table
        for (InteractionObject currentObject :  allObjects){
            InteractionObject.DamageState actDamage = currentObject.checkForPossibleDamage();

            //generates the actual row
            TableRow row = new TableRow(this);

            //name of the sensor
            TextView objectName = new TextView(this);
            objectName.setText(currentObject.getName());

            //get damage state and choose image to display
            ImageView damageStateImg = new ImageView((this));

            if (actDamage == InteractionObject.DamageState.None){
                damageStateImg.setImageResource(R.mipmap.trafficgreen);
            }

            if (actDamage == InteractionObject.DamageState.Partial){
                damageStateImg.setImageResource(R.mipmap.trafficyellow);
            }
            if (actDamage == InteractionObject.DamageState.Totally){
                damageStateImg.setImageResource(R.mipmap.trafficred);
            }

            //description of sensor
            TextView description = new TextView(this);
            description.setText(currentObject.getDescription());

            //get the on/off state of the senser e.g sensor is switched on or off
            TextView onOffState = new TextView(this);
            onOffState.setText(currentObject.getOnOffState().toString());

            //add the views to the row every view represents an own (table) cell
            row.addView(objectName);
            row.addView(damageStateImg);
            row.addView(description);
            row.addView(onOffState);

            //rows are aligned vertically
            row.setGravity(Gravity.CENTER_VERTICAL);

            //row.setBackgroundResource(R.drawable.monitorbgtable);
            try {
                frameSensors.addView(row);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
