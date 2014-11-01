package com.example.junyang.yhack_hireme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
