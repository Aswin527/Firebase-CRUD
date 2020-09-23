package com.example.firebasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.contentcapture.ContentCaptureContext;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txtData;
    Button btnSubmit;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = findViewById(R.id.txtData);
        btnSubmit = findViewById(R.id.btnSubmit);
        myRef = FirebaseDatabase.getInstance().getReference("data");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }

    private void addData(){
        String data = txtData.getText().toString().trim();
        if (!TextUtils.isEmpty(data)){
                String id = myRef.push().getKey();
                 AddData add = new AddData(id, data);
                 myRef.child(id).setValue(data);
                 Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Please enter something !!",Toast.LENGTH_SHORT).show();
        }
    }
}