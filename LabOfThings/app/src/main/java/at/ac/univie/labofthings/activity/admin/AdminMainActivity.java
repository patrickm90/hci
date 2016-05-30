package at.ac.univie.labofthings.activity.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import at.ac.univie.labofthings.R;

public class AdminMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        setTitle("Admin Dashboard");

        final Button btn_preset_admin_choice = (Button) findViewById(R.id.btn_preset_admin_choice);
        final Button btn_user_admin_choice = (Button) findViewById(R.id.btn_user_admin_choice);

        //Event for the preset Management
        btn_preset_admin_choice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent presetManagementIntent = new Intent(getBaseContext(), AdminPresetManagement.class);
                startActivity(presetManagementIntent);

            }
        });
        //Event for the user Management
        btn_user_admin_choice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent userManagementIntent = new Intent(getBaseContext(), AdminUserManagement.class);
                startActivity(userManagementIntent);
            }
        });

    }
}
