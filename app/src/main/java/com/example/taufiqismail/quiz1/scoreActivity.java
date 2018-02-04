package com.example.taufiqismail.quiz1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;





import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scoreActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_score);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Score");

            mtvHasilAkhir = (TextView) findViewById(R.id.tvSkorAkhir);
            mbtnMenu = (Button) findViewById(R.id.btnHome);

            setSkor();

            mbtnMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(scoreActivity.this, MainActivity.class);
                    startActivity(i);
                }
            });

        }

        private void setSkor() {
            String skorPilGan = getIntent().getStringExtra("skorAkhir");
            mtvHasilAkhir.setText("SKOR : "+skorPilGan);
        }
    }


