package at.ac.univie.labofthings.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import at.ac.univie.labofthings.R;

public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Credits");
        setContentView(R.layout.activity_credits);
    }
}
