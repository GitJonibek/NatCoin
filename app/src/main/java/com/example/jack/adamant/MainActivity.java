package com.example.jack.adamant;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.jack.adamant.fragment.BuyCoinFragment;
import com.example.jack.adamant.fragment.HomeFragment;
import com.example.jack.adamant.fragment.PaymentFragment;
import com.example.jack.adamant.fragment.SellCoinFragment;
import com.example.jack.adamant.fragment.SettingsFragment;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.roughike.bottombar.OnTabSelectListener;
import com.roughike.bottombar.BottomBar;
import java.util.Objects;



public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private BottomBar bottomBar;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);

        bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.bottomBarItemBuyCoin:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, new BuyCoinFragment()).commit();
                        break;
                    case R.id.bottomBarItemSellCoin:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, new SellCoinFragment()).commit();
                        break;
                    case R.id.bottomBarItemPayment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, new HomeFragment()).commit();
                        break;
                    case R.id.bottomBarItemDetails:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, new PaymentFragment()).commit();
                        break;
                    case R.id.bottomBarItemSettings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, new SettingsFragment()).commit();
                        break;
                }
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() == null){
            sendToStart();
        }/*else{
            //mUserRef.child("online").setValue(true);
        }*/
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void sendToStart() {
        Intent startActivity = new Intent(MainActivity.this, StartActivity.class);
        startActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(startActivity);
        finish();
    }

}
