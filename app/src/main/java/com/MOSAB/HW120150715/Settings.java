package com.MOSAB.HW120150715;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final EditText Name= findViewById(R.id.Name);
        final EditText Intersts = findViewById(R.id.edit1);
        final EditText Gender= findViewById(R.id.edit2);
        final EditText BOD= findViewById(R.id.Edit3);

        Button update = findViewById(R.id.Update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Settings.this, MainActivity.class);
                intent.putExtra("Name",Name.getText().toString());
                intent.putExtra("Intersts",Intersts.getText().toString());
                intent.putExtra("Gender",Gender.getText().toString());
                intent.putExtra("BOD",BOD.getText().toString());
                startActivity(intent);
            }
        });


    }
}
