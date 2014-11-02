package com.example.junyang.yhack_hireme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class JobSeekerProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_profile);

        TextView nameTextView = (TextView) findViewById(R.id.textView_name);
        TextView industryTextView = (TextView) findViewById(R.id.textView_industry);
        TextView experienceTextView = (TextView) findViewById(R.id.textView_experience);
        TextView linkedinTextView = (TextView) findViewById(R.id.textView_url);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nameTextView.setText(extras.getString("NAME"));
            industryTextView.setText(extras.getString("INDUSTRY"));
            experienceTextView.setText(extras.getString("EXPERIENCE"));
            linkedinTextView.setText(extras.getString("LINKEDIN_URL"));
        }

        Button logoutButton = (Button)findViewById(R.id.button_logout_job_seeker);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomUser.logOut();
                Intent intent = new Intent(JobSeekerProfileActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.job_seeker_profile, menu);
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
