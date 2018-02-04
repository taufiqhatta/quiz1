package com.example.taufiqismail.quiz1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mlineLearn, mlineQuiz, mlineAbout, mlineEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mlineLearn = (LinearLayout) findViewById(R.id.lineLearn);
        mlineQuiz = (LinearLayout) findViewById(R.id.linePractice);
        mlineAbout = (LinearLayout) findViewById(R.id.lineAbout);
        mlineEmail = (LinearLayout) findViewById(R.id.lineContact);
        //menyambungkan MAINACTIVITY.JAVA dengan ID pada layout(xml)

        mlineLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, learnActivity.class)
            }
        });
        //memindahkan class mainactivity ke learnactivity

        mlineQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PracticeActivity.class);
                startActivity(i)
            }
        });


        mlineAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(i);
            }
        });


        mlineEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = "mtaufiqhatta@gmail.com";
                String subject = "nanya dong";
                String message = "Gua mau nanya";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "kirim email dengan"));

            }
        });//membuat pesan Email


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Anda yakin ingin keluar ?");
        builder.setPositiveButton("ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog quit = builder.create();
        quit.show();

    }
}
