package com.example.junyang.yhack_hireme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context activity_content = this;
        Button jobSeekerButton = (Button)findViewById(R.id.job_seeker_button);
        jobSeekerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToJobSeekerRegister = new Intent(activity_content, JobSeekerRegisterActivity.class);
                startActivity(goToJobSeekerRegister);
            }
        });

        final Button recruiterButton = (Button)findViewById(R.id.recruiter_button);
        recruiterButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {
               Intent goToRecruiterRegister = new Intent(activity_content, RecruiterRegisterActivity.class);
               startActivity(goToRecruiterRegister);
           }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
}
