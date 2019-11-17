package com.example.finalexam07590534;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper db;
            EditText _edit_id , _edit_pass;
            Button _btn_login,_btn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _edit_id=(EditText)findViewById(R.id.username_edit_text);
        _edit_pass=(EditText)findViewById(R.id.password_edit_text);
        _btn_login=(Button)findViewById(R.id.login_button);
        _btn_reg=(Button)findViewById(R.id.register_button);
        _btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Userid = _edit_id.getText().toString();
                String Password = _edit_pass.getText().toString();
                Boolean checkLog = db.checklogin(Userid,Password);
                if (checkLog== true){
                    Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                }
                else  {
                    Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_SHORT).show();
                }
            }
        });
        _btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
    }

}

