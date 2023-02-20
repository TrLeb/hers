package com.tslebang.hers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class Dashboard extends AppCompatActivity {
    TextView nameTv;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    FirebaseAuth aUTH;
    ImageView donateIV, requestIV, callIV, qnaIV, sosIV, locationIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        nameTv = findViewById(R.id.name);
        donateIV = findViewById(R.id.donateIV);
        requestIV = findViewById(R.id.requestIV);
        callIV = findViewById(R.id.callIV);
        locationIV = findViewById(R.id.clinicsIV);
        qnaIV = findViewById(R.id.qnaIV);
        sosIV = findViewById(R.id.sosIV);

        aUTH = FirebaseAuth.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        Query query = databaseReference.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds: snapshot.getChildren()){
                    String name = ""+ ds.child("name").getValue();

                    nameTv.setText(name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void checkUserStatus(){

        FirebaseUser user = aUTH.getCurrentUser();
        if (aUTH !=null){

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