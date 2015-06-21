package com.example.macy.smarthome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Macy on 6/21/15.
 */
public class AIAuth extends Activity{
    EditText username, password;
    Button login;
    TextView auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aiauth);

        getVals();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Toast.makeText(AIAuth.this, "Logged in, Successfully!", Toast.LENGTH_SHORT).show();
                    auth.setText("Login Successful");

                    Intent openMain = new Intent("com.example.macy.smarthome.MainActivity");
                    startActivity(openMain);
                }else {
                    Toast.makeText(AIAuth.this, "Login Failed, Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getVals() {
        username = (EditText) findViewById(R.id.etUN);
        password = (EditText) findViewById(R.id.etPW);
        login = (Button) findViewById(R.id.bLogin);
        auth = (TextView) findViewById(R.id.tvAuth);
    }
}
