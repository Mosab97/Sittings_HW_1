package com.MOSAB.HW120150715;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView ;
    private static final int PICK_TIME =100;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SETTINGS = findViewById(R.id.SETTINGS);


        TextView Name = findViewById(R.id.Name);
        TextView Intrests = findViewById(R.id.Intrests);
        TextView Gdnder = findViewById(R.id.gender);
        TextView BOD = findViewById(R.id.DOB);


        Intent intent = getIntent();
        if(intent != null) {
            if (intent.hasExtra("Name")) {
                String name = intent.getStringExtra("Name");
                Name.setText(name);
            }
            if (intent.hasExtra("Intersts")) {
                String inters = intent.getStringExtra("Intersts");
                Intrests.setText(inters);
            }

            if (intent.hasExtra("Gender")) {
                String gender = intent.getStringExtra("Gender");
                Gdnder.setText(gender);
            }



            if (intent.hasExtra("DOB")) {
                String dob= intent.getStringExtra("DOB");
                BOD.setText(dob);
            }

        }


        Button choosePhoto = findViewById(R.id.choosePhoto);
        choosePhoto .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallary = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallary,PICK_TIME);
            }
        });



        SETTINGS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("setting");
                startActivity(i);
            }



        });

    }

    public void goToFaceBook (View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/moahir97"));
        startActivity(intent);
    }

    public void goToInstagram (View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/omar_suliman1998/"));
        startActivity(intent);
    }
    public void goToGmail (View view){







                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("plain/text");
                //To
                i.putExtra(Intent.EXTRA_EMAIL,new String[]{"hmosab754@gmail.com","Abbass@homtail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"hello");
                i.putExtra(Intent.EXTRA_TEXT,"hello, how are you?");

                if(i.resolveActivity(getPackageManager()) != null){
                    startActivity(i);
                }



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode ==RESULT_OK && requestCode ==PICK_TIME){
            imageUri =data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}
