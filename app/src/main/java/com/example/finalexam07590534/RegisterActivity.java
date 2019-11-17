package com.example.finalexam07590534;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
EditText _edit_name,_edit_user_id,_edit_password;
Button _btn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        _edit_name=(EditText)findViewById(R.id.full_name_edit_text);
        _edit_user_id=(EditText)findViewById(R.id.username_edit_text);
        _edit_password=(EditText)findViewById(R.id.password_edit_text);
        _btn_reg=(Button)findViewById(R.id.register_button);
        _btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String fullname = _edit_name.getText().toString();
            String Userid = _edit_user_id.getText().toString();
            String Password = _edit_password.getText().toString();
            if(fullname.equals("")||Userid.equals("")||Password.equals("")){
                Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_SHORT).show();

            }
            else{
                        Boolean insert = db.insert(fullname,Userid,Password);
                        if(insert==true){
                            Toast.makeText(getApplicationContext(),"Register successfully",Toast.LENGTH_SHORT).show();


                }
            }
            }
        });
        }
        }





