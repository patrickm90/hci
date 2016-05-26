package at.ac.univie.labofthings.activity.monitor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View.OnClickListener;
import java.util.List;
import at.ac.univie.labofthings.R;
import at.ac.univie.labofthings.backend.interaction.InteractionObject;
import at.ac.univie.labofthings.backend.preset.PresetQuery;

import static at.ac.univie.labofthings.R.layout.activity_monitor_main;

public class MonitorMainActivity extends AppCompatActivity {
    List<InteractionObject> firstPreset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Montior View");
        super.onCreate(savedInstanceState);
        setContentView(activity_monitor_main);

        TableLayout frameAlert = (TableLayout) findViewById(R.id.frameAlert);

        firstPreset = PresetQuery.getPresetList().get(0).getObjects();
        //save the preset in the MonitorRAndomDataHolder (ugly name...)
        MonitorRandomDataHolder.setAllSensors(firstPreset);

        for (InteractionObject currentObject :  firstPreset){

            //generate the "alert" section
            InteractionObject.DamageState actDamage = currentObject.checkForPossibleDamage();
            if (actDamage != InteractionObject.DamageState.None) {

                TableRow row = new TableRow(this);
                TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);

                row.setLayoutParams(lp);
                TextView objectName = new TextView(this);

                objectName.setGravity(Gravity.CENTER_VERTICAL);
                //objectName.setGravity(Gravity.CENTER_HORIZONTAL);

                objectName.setText(currentObject.getName());
                TextView damageState = new TextView(this);
                damageState.setText(actDamage.toString());
                ImageView damageStateImg = new ImageView((this));
                damageStateImg.setImageResource(R.mipmap.trafficred);

                if (actDamage == InteractionObject.DamageState.Partial){
                    damageStateImg.setImageResource(R.mipmap.trafficyellow);
                }

               // row.setBackgroundResource(R.drawable.monitorbgtable);
                row.setGravity(Gravity.CENTER);
                row.addView(objectName);

                row.addView(damageStateImg);

                try {
                    frameAlert.addView(row);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //button pressed cat1 = Light
        Button cat1 = (Button) findViewById(R.id.cat1Button);

        //button pressed cat2 = Triggered
        Button cat2 = (Button) findViewById(R.id.cat2Button);

        //button pressed cat3 = display
        Button cat3 = (Button) findViewById(R.id.cat3Button);

        //button pressed cat4 = mechanic
        Button cat4 = (Button) findViewById(R.id.cat4Button);

        //click listener for category 1/light
        if (cat1 != null) {
            cat1.setOnClickListener(new OnClickListener() {
                //get all Light-InteractionObjects


                @Override
                public void onClick(View v) {
                    MonitorRandomDataHolder.setCategory(InteractionObject.TypOfCategory.Light);

                    System.out.println("Light pressed");
                    Intent intent = new Intent(getActivity(), MonitorShowCategory.class);
                    startActivity(intent);
                }
            });
        }

        //click listener for category 2/triggered
        if (cat2 != null) {
            cat2.setOnClickListener(new OnClickListener() {
                //get all Light-InteractionObjects


                @Override
                public void onClick(View v) {
                    MonitorRandomDataHolder.setCategory(InteractionObject.TypOfCategory.Triggered);
                    System.out.println("triggered pressed");
                    Intent intent = new Intent(getActivity(), MonitorShowCategory.class);
                    startActivity(intent);
                }
            });
        }

        //click listener for category 3/display
        if (cat3 != null) {
            cat3.setOnClickListener(new OnClickListener() {
                //get all Light-InteractionObjects


                @Override
                public void onClick(View v) {
                    MonitorRandomDataHolder.setCategory(InteractionObject.TypOfCategory.Display);

                    System.out.println("display pressed");
                    Intent intent = new Intent(getActivity(), MonitorShowCategory.class);
                    startActivity(intent);
                }
            });
        }

        //click listener for category 4/mechanic
        if (cat4 != null) {
            cat4.setOnClickListener(new OnClickListener() {
                //get all Light-InteractionObjects


                @Override
                public void onClick(View v) {
                    MonitorRandomDataHolder.setCategory(InteractionObject.TypOfCategory.Mechanic);

                    System.out.println("mechanic pressed");
                    Intent intent = new Intent(getActivity(), MonitorShowCategory.class);
                    startActivity(intent);
                }
            });
        }
    }

    public Context getActivity() {
        return this;
    }
}
