package com.example.alisaunzakova.reg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class logActivity extends AppCompatActivity {

    private EditText logEdText;
    private EditText passEdText;

    private Button logButton;
    private Button cancelButton;

    private SharedPreferences password;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        drawUI();
        listeners();

        password = getSharedPreferences(getString(R.string.passwordDataAccess), MODE_PRIVATE);
        login = getSharedPreferences(getString(R.string.loginDataAccess), MODE_PRIVATE);
    }

    private void listeners() {
        logButton.setOnClickListener(logButtonListener);
        cancelButton.setOnClickListener(cancelButtonListener);
    }

    private void drawUI() {
        logEdText = (EditText) findViewById(R.id.logEdText);
        passEdText = (EditText) findViewById(R.id.passEdText);
        logButton = (Button) findViewById(R.id.logButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
    }

    View.OnClickListener logButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String textLog = logEdText.getText().toString();
            String textPass = passEdText.getText().toString();

            if (checkLogAndPass(textLog, textPass)){
                String pass = password.getString(textLog, "");
                String name = login.getString(textLog, "");

                updateAllEditText();
                Intent intent = new Intent(logActivity.this, WelcomeActivity.class);
                intent.putExtra(getResources().getString(R.string.name), name);
                startActivity(intent);
            }
        }
    };

    View.OnClickListener cancelButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private  boolean checkLogAndPass(String log, String pass) {
        if (!login.contains(log)) {
            Toast.makeText(logActivity.this, "Login not found", Toast.LENGTH_LONG).show();
            updateAllEditText();
            return false;
        }
        if (!(login.getString(log, "").equals(pass))) {
            Toast.makeText(logActivity.this, "Failed Password", Toast.LENGTH_LONG).show();
            updateAllEditText();
            return false;
        }
        return true;
    }

    private void updateAllEditText() {
        logEdText.setText("");
        passEdText.setText("");
    }
}
