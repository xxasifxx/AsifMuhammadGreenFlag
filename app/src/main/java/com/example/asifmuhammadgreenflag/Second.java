package com.example.asifmuhammadgreenflag;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Second extends AppCompatActivity {
    String TAG = "Second Page";
    Button btnSecond;
    ImageButton btnback;
    TextView invalidemail;
    TextView invalidpass;
    TextView invalidrpass;
    TextInputEditText inputEmail;
    TextInputEditText inputPass;
    TextInputEditText inputrPass;
    TextInputLayout email;
    TextInputLayout pass;
    TextInputLayout rpass;
    Drawable red;
    Drawable green;
    Drawable white;
    Drawable redblack;
    static String KEY = "KEY";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Log.d(TAG, "onCreate");
        inputEmail = findViewById(R.id.editEmail);
        inputPass = findViewById(R.id.editPass);
        inputrPass = findViewById(R.id.editrPass);
        btnSecond = findViewById(R.id.secondbtn);
        btnSecond.setEnabled(false);
        btnback = findViewById(R.id.imageButton);
        email = findViewById(R.id.emaillayout);
        pass = findViewById(R.id.passlayout);
        rpass = findViewById(R.id.rpasslayout);
        invalidemail = findViewById(R.id.invalidemail);
        invalidemail.setVisibility(View.INVISIBLE);
        invalidpass = findViewById(R.id.invalidpass);
        invalidpass.setVisibility(View.INVISIBLE);
        invalidrpass = findViewById(R.id.notmatch);
        invalidrpass.setVisibility(View.INVISIBLE);
        red = getDrawable(R.drawable.redborder);
        white = getDrawable(R.drawable.whiteborder);
        green = getDrawable(R.drawable.greenborder);
        redblack = getDrawable(R.drawable.redblack);
        invalidemail.setBackground(redblack);
        invalidpass.setBackground(redblack);
        invalidrpass.setBackground(redblack);
        inputEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(inputEmail.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
                    email.setBackground(green);
                    invalidemail.setVisibility(View.INVISIBLE);
                }
                else{
                    email.setBackground(red);
                    invalidemail.setVisibility(View.VISIBLE);
                }
                if(email.getBackground() == green && pass.getBackground() == green && rpass.getBackground() == green){
                    btnSecond.setEnabled(true);
                    btnSecond.setClickable(true);
                }
                if((email.getBackground() != green || pass.getBackground() != green || rpass.getBackground() != green)){
                    btnSecond.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(inputPass.getText().toString().trim().matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
                    pass.setBackground(green);
                    invalidpass.setVisibility(View.INVISIBLE);}
                else {
                    pass.setBackground(red);
                    invalidpass.setVisibility(View.VISIBLE);
                }
                if(email.getBackground() == green && pass.getBackground() == green && rpass.getBackground() == green){
                    btnSecond.setEnabled(true);
                    btnSecond.setClickable(true);
                }
                if((email.getBackground() != green || pass.getBackground() != green || rpass.getBackground() != green)){
                    btnSecond.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        inputrPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(inputrPass.getText().toString().trim().matches(inputPass.getText().toString().trim())) {
                    rpass.setBackground(green);
                    invalidrpass.setVisibility(View.INVISIBLE);}
                else if(inputrPass.getText().toString().trim().isEmpty())
                    invalidrpass.setVisibility(View.INVISIBLE);
                else {
                    rpass.setBackground(red);
                    invalidrpass.setVisibility(View.VISIBLE);
                }
                if(email.getBackground() == green && pass.getBackground() == green && rpass.getBackground() == green){
                    btnSecond.setEnabled(true);
                    btnSecond.setClickable(true);
                }
                if((email.getBackground() != green || pass.getBackground() != green || rpass.getBackground() != green)){
                    btnSecond.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btnSecond.setOnClickListener(view -> {
            CharSequence moveToThird = inputEmail.getText();
            Intent intent = new Intent();
            intent.setClass(Second.this,Third.class);
            intent.putExtra(KEY, moveToThird);
            startActivity(intent);
        });
        btnback.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(Second.this,First.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
