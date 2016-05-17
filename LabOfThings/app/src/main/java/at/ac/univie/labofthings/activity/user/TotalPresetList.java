package at.ac.univie.labofthings.activity.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

import at.ac.univie.labofthings.R;
import at.ac.univie.labofthings.backend.preset.Preset;
import at.ac.univie.labofthings.backend.preset.PresetQuery;

public class TotalPresetList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_preset_list);
        final PresetQuery presets=new PresetQuery();
        List<Preset>list= presets.getPresetList();

        //ListView listView=(ListView)findViewById(R.id.listPresetView);
        LinearLayout linLayout=(LinearLayout)findViewById(R.id.linLayoutForScroll);


        for(final Preset p: list) {
            final Button bx=new Button(this);
            bx.setText(p.Name);

            bx.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent intent = new Intent(TotalPresetList.this,DisplayPreset.class);
                    String str=p.Name;
                    intent.putExtra("preset", bx.getText());
                    startActivity(intent);
                }
            });


            linLayout.addView(bx);
        //listView.addView(bx);
        }

    }
}
