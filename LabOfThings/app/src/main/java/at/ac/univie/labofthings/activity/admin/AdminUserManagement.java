package at.ac.univie.labofthings.activity.admin;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import at.ac.univie.labofthings.R;
import at.ac.univie.labofthings.backend.session.User;
import at.ac.univie.labofthings.backend.session.UserQuery;

public class AdminUserManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_management);

        showUsers();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AdminUserCreation.class);
                startActivity(intent);
            }
        });
    }
    protected void showUsers()
    {
        TableLayout userTable = (TableLayout) findViewById(R.id.tbl_userTable);

        TableRow headerRow = new TableRow(this);

        TextView userNameHeader = new TextView(this);
        userNameHeader.setTypeface(null, Typeface.BOLD);
        userNameHeader.setGravity(Gravity.CENTER_HORIZONTAL);
        userNameHeader.setText("Username");

        TextView isAdminHeader = new TextView(this);
        isAdminHeader.setTypeface(null, Typeface.BOLD);
        isAdminHeader.setGravity(Gravity.CENTER_HORIZONTAL);
        isAdminHeader.setText("Admin");

        TextView isMonitoringHeader = new TextView(this);
        isMonitoringHeader.setTypeface(null, Typeface.BOLD);
        isMonitoringHeader.setGravity(Gravity.CENTER_HORIZONTAL);
        isMonitoringHeader.setText("Monitoring");

        TextView isUserHeader = new TextView(this);
        isUserHeader.setText("User");
        isUserHeader.setTypeface(null, Typeface.BOLD);
        isUserHeader.setGravity(Gravity.CENTER_HORIZONTAL);

        headerRow.addView(userNameHeader);
        headerRow.addView(isAdminHeader);
        headerRow.addView(isMonitoringHeader);
        headerRow.addView(isUserHeader);

        userTable.addView(headerRow);

        TableRow spaceTblRow = new TableRow(this);
        spaceTblRow.setPadding(0,50,0,0);

        userTable.addView(spaceTblRow);

        for(User user : UserQuery.getUserList())
        {
            TableRow row = new TableRow(this);
            TextView userNameTextView = new TextView(this);
            userNameTextView.setText(user.getUserName());

            CheckBox isAdmin = new CheckBox(this);
            CheckBox isMonitoring = new CheckBox(this);
            CheckBox isUser = new CheckBox(this);

            if(user.getUserType() == User.UserType.Admin)
            {
                isAdmin.setChecked(true);
            }
            if(user.getUserType() == User.UserType.Monitor)
            {
                isMonitoring.setChecked(true);
            }
            if(user.getUserType() == User.UserType.User)
            {
                isUser.setChecked(true);
            }
            row.addView(userNameTextView);
            row.addView(isAdmin);
            row.addView(isMonitoring);
            row.addView(isUser);

            userTable.addView(row);
        }

    }
    public void btn_save_onClick(View v)
    {
        Toast.makeText(getApplicationContext(), "Permission successfully saved!", Toast.LENGTH_LONG).show();
    }
}
