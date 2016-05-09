package com.example.alisaunzakova.reg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button logButton;
    private Button regButton;
    private Button resButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawUI();
        listeners();
    }

    private void drawUI() {
        logButton = (Button)findViewById(R.id.logButton);
        regButton = (Button)findViewById(R.id.regButton);
        resButton = (Button)findViewById(R.id.resButton);
    }

    private void listeners() {
        logButton.setOnClickListener(this);
        regButton.setOnClickListener(this);
        resButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case(R.id.logButton):
                startActivity(new Intent(this, logActivity.class));
                break;
            case(R.id.regButton):
                startActivity(new Intent(this, regActivity.class));
                break;
            case(R.id.resButton):
                finish();
                break;
        }
    }
}
