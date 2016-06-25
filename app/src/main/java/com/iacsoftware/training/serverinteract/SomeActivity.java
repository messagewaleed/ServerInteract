package com.iacsoftware.training.serverinteract;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class SomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some);

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                100,
                100
        );

        for(int var = 0; var < 4; var++)
        {
            Button bt = new Button(this);
            bt.setText("New Dynamic Button");
            bt.setLayoutParams(params);
            layout.addView(bt);
        }

    }
}
