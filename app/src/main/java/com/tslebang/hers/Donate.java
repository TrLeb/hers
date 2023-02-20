package com.tslebang.hers;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.location.LocationRequest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Donate extends AppCompatActivity {
    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    LocationRequest mLocationRequest;
    private int REQUEST_CODE = 11;
    SupportMapFragment mapFragment;
    EditText mFullName,mItemName,mDescription,mPhone;
    Button mSubmitBtn;
    FirebaseAuth fAuth;
    FirebaseDatabase firebaseDatabase;
    String userID;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
    }
}