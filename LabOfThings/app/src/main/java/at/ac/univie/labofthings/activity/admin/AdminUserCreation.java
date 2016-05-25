package at.ac.univie.labofthings.activity.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import at.ac.univie.labofthings.R;

public class AdminUserCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_creation);

        buildUserTable();

    }
    protected void buildUserTable()
    {
        TableLayout userTable = (TableLayout) findViewById(R.id.tbl_userTable);

        TableRow nameRow = new TableRow(this);
        TextView label_UserName = new TextView(this);
        label_UserName.setText("Username:");
        EditText txt_UserName = new EditText(this);

        nameRow.addView(label_UserName);
        nameRow.addView(txt_UserName);

        TableRow passwordRow = new TableRow(this);
        TextView label_Password = new TextView(this);
        label_Password.setText("Password:");
        EditText txt_Password = new EditText(this);

        passwordRow.addView(label_Password);
        passwordRow.addView(txt_Password);

        TableRow spaceRow = new TableRow(this);
        spaceRow.setPadding(0,50,0,0);

        TableRow adminRow = new TableRow(this);
        TextView label_admin = new TextView(this);
        label_admin.setText("Admin:");
        CheckBox checkbox_admin = new CheckBox(this);
        adminRow.addView(label_admin);
        adminRow.addView(checkbox_admin);

        TableRow monitorRow = new TableRow(this);
        TextView label_monitor = new TextView(this);
        label_monitor.setText("Monitor:");
        CheckBox checkbox_monitor = new CheckBox(this);
        monitorRow.addView(label_monitor);
        monitorRow.addView(checkbox_monitor);

        TableRow userRow = new TableRow(this);
        TextView label_user = new TextView(this);
        label_user.setText("User:");
        CheckBox checkbox_user = new CheckBox(this);
        userRow.addView(label_user);
        userRow.addView(checkbox_user);

        TableRow buttonSpaceRow = new TableRow(this);
        buttonSpaceRow.setPadding(0,50,0,0);


        userTable.addView(nameRow);

        userTable.addView(passwordRow);

        userTable.addView(spaceRow);

        userTable.addView(adminRow);

        userTable.addView(monitorRow);

        userTable.addView(userRow);

        userTable.addView(buttonSpaceRow);

    }
    public void btn_save_onClick(View v)
    {
        finish();
    }
}
