package com.example.keyvaluebackupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView emailTV = findViewById(R.id.welcome_tv);
        String email = PrefUtils.getEmail(this);
        String emailFromBackUp = PrefUtils.getEmailFromBackup(this);
        emailTV.setText(String.format("Email: %s\nBackup mail: %s", email, emailFromBackUp));
    }
}