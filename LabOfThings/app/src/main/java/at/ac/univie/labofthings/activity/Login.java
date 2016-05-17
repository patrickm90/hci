package at.ac.univie.labofthings.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import at.ac.univie.labofthings.R;
import at.ac.univie.labofthings.activity.admin.AdminMainActivity;
import at.ac.univie.labofthings.activity.monitor.MonitorMainActivity;
import at.ac.univie.labofthings.activity.user.UserMainActivity;
import at.ac.univie.labofthings.backend.session.User;
import at.ac.univie.labofthings.backend.session.UserQuery;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        final Button button = (Button) findViewById(R.id.loginButton);
        final TextView pw=(TextView)findViewById(R.id.password);
        final TextView username=(TextView)findViewById(R.id.username);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Password Check

                String pwStr = pw.getText().toString();
                String usernameStr = username.getText().toString();

                User user=UserQuery.Login(usernameStr,pwStr);

                if(user==null){
                    Toast.makeText(getApplicationContext(),"password or username is false",Toast.LENGTH_LONG).show();
                }
                else if(user.getUserType()== User.UserType.Admin){
                    Toast.makeText(getApplicationContext(),"logged as Admin",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this,AdminMainActivity.class);

                    startActivity(intent);
                }
                else if(user.getUserType()== User.UserType.User){
                    Toast.makeText(getApplicationContext(),"logged as User",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this,UserMainActivity.class);
                    //Achtung UserMainActivity spinnt noch @martinTask
                    startActivity(intent);
                }
                else if(user.getUserType()== User.UserType.Monitor){
                    Toast.makeText(getApplicationContext(),"logged as Monitor",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this,MonitorMainActivity.class);

                    startActivity(intent);
                }

            }
        });

    }
}
