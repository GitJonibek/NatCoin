package com.example.jack.adamant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button mRegBtn;
    private Button mLogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mRegBtn = findViewById(R.id.register_button);
        mLogBtn = findViewById(R.id.login_button);

        mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regActivity = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(regActivity);
            }
        });
        mLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logActivity = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(logActivity);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
