package com.example.jack.adamant;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private Toolbar mRegisterToolbar;

    private TextInputLayout mEmail;
    private TextInputLayout mPassword;
    private TextInputLayout mCofirmPassworr;
    private Button mContinueButton;

    private ProgressDialog mRegProgress;

    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mDatabase;

    private RelativeLayout mRelativeLayout;
    private PopupWindow mPopupWindow;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        setSupportActionBar(mRegisterToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("New Wallet");

        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = Objects.requireNonNull(mEmail.getEditText()).getText().toString();
                String password = Objects.requireNonNull(mPassword.getEditText()).getText().toString();
                String con_password = Objects.requireNonNull(mCofirmPassworr.getEditText()).getText().toString();
                showPopUpImage();
                String pin_code = "";
                if(     !TextUtils.isEmpty(mail) &&
                        !TextUtils.isEmpty(password) &&
                        !TextUtils.isEmpty(con_password) &&
                        !TextUtils.isEmpty(pin_code) &&
                        password.equals(con_password)) {

                    registerUser(mail, con_password, pin_code);

                } else {
                    Toast.makeText(RegisterActivity.this, "Please, fill all fields correctly!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void showPopUpImage() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(RegisterActivity.this);
        @SuppressLint("InflateParams")
        View myView = getLayoutInflater().inflate(R.layout.pin_window_popup, null);
        mBuilder.setView(myView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    public void registerUser(String email, String password, String pin_code){

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void init(){
        mEmail = findViewById(R.id.reg_email);
        mPassword = findViewById(R.id.reg_password);
        mCofirmPassworr = findViewById(R.id.reg_confirm_password);
        mContinueButton = findViewById(R.id.reg_continue);
        mRegisterToolbar = findViewById(R.id.register_toolbar);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        //mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());

    }

}
