package com.example.alisaunzakova.reg;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class regActivity extends AppCompatActivity {

    private EditText logEdText;
    private EditText passEdText;
    private EditText nameEdText;

    private Button signButton;
    private Button cancelButton;

    private SharedPreferences password;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        drawUI();
        listeners();

        password = getSharedPreferences(getString(R.string.passwordDataAccess), MODE_PRIVATE);
        login = getSharedPreferences(getString(R.string.loginDataAccess), MODE_PRIVATE);
    }

    private void listeners() {
        signButton.setOnClickListener(signButtonListener);
        cancelButton.setOnClickListener(cancelButtonListener);
    }

    private void drawUI() {
        logEdText = (EditText) findViewById(R.id.LogEdText);
        passEdText = (EditText) findViewById(R.id.passEdText);
        nameEdText = (EditText) findViewById(R.id.nameEdText);

        signButton = (Button) findViewById(R.id.signButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
    }

    View.OnClickListener signButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String log = logEdText.getText().toString();
            String name = nameEdText.getText().toString();
            String pass = passEdText.getText().toString();



                SharedPreferences.Editor editorPass = password.edit();
                SharedPreferences.Editor editorLogin = login.edit();

                editorPass.putString(log, pass);
                editorLogin.putString(log, name);

                editorPass.apply();
                editorLogin.apply();

                Toast.makeText(regActivity.this, "Registration completed", Toast.LENGTH_LONG).show();
                finish();
            }
    };


    View.OnClickListener cancelButtonListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}