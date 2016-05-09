package com.example.alisaunzakova.reg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private TextView userNameTextView;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        userNameTextView = (TextView) findViewById(R.id.nameTextView);
        exitButton = (Button) findViewById(R.id.logOutButton);

        String userName = getIntent().getStringExtra(getResources().getString(R.string.name));
        userNameTextView.setText(userName);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
