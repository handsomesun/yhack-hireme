package com.example.junyang.yhack_hireme;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Context activity_context = this;
        Button jobSeekerLogin = (Button)findViewById(R.id.button_login_job_seeker);
        jobSeekerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLoginDialog(false);
            }
        });
        Button recruiterLogin = (Button)findViewById(R.id.button_login_recruiter);
        recruiterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLoginDialog(true);
            }
        });

        Button signUpButton = (Button) findViewById(R.id.button_new_user);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRegister = new Intent(activity_context, MainActivity.class);
                startActivity(goToRegister);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.longin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void callLoginDialog(final boolean isRecruiter)
    {
        Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.activity_login_popup);
        Button login = (Button) myDialog.findViewById(R.id.button_login);

        EditText emailaddr = (EditText) myDialog.findViewById(R.id.editText_login_username);
        EditText password = (EditText) myDialog.findViewById(R.id.editText_login_password);
        myDialog.show();

        login.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                //your login calculation goes here
                if (isRecruiter) {

                } else {

                }
            }
        });


    }
}
