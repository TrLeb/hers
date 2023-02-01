package com.tslebang.hers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Dashboard extends AppCompatActivity {
    TextView nameTv;
    FirebaseAuth aUTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        nameTv = findViewById(R.id.name);

        aUTH = FirebaseAuth.getInstance();
    }
    private void checkUserStatus(){

        FirebaseUser user = aUTH.getCurrentUser();
        if (aUTH !=null){
            assert user != null;
            nameTv.setText(user.getDisplayName());
        }else {
            Toast.makeText(this, "No user", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        checkUserStatus();
        super.onStart();
    }
}