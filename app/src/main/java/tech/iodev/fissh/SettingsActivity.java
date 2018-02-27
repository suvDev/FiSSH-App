package tech.iodev.fissh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {


    EditText computerIP;
    EditText password;
    EditText nickname;
    int ID; // Computer ID


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        computerIP  = (EditText) findViewById(R.id.txtComputerIp);
        password =  (EditText) findViewById(R.id.txtPassword);
        nickname = (EditText) findViewById(R.id.txtNickname);

        computerIP.setText(getIntent().getStringExtra("computer_ip"));
        password.setText(getIntent().getStringExtra("password"));
        nickname.setText(getIntent().getStringExtra("nickname"));

        ID = getIntent().getIntExtra("id", -1);

        computerIP.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if(computerIP.getText().toString().equals(""))
                {
                    computerIP.setError("Please input the ip of your computer");
                }

            }
        });

        computerIP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(computerIP.getText().toString().equals(""))
                {
                    computerIP.setError("Please input the ip of your computer");
                }

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(computerIP.getText().toString().equals(""))
                {
                    computerIP.setError("Please input the ip of your computer");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(computerIP.getText().toString().equals(""))
                {
                    computerIP.setError("Please input the ip of your computer");
                }

            }
        });
    }

    public void save_settings(View sender)
    {
        if(computerIP.getText().toString().equals(""))
        {

            computerIP.setError("Please input the ip of your computer");

        }
        else
        {
            Intent result = new Intent();
            result.putExtra("computer_ip", computerIP.getText().toString());
            result.putExtra("password", password.getText().toString());
            result.putExtra("nickname", nickname.getText().toString());

            if (ID != -1) result.putExtra("id", ID);

            setResult(RESULT_OK, result);
            finish();
        }
    }

}
