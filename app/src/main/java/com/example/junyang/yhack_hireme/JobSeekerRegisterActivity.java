package com.example.junyang.yhack_hireme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class JobSeekerRegisterActivity extends Activity {

    EditText nameEditText;
    EditText urlEditText;
    Spinner spinner_industry;
    Spinner spinner_experience;
    Context activity_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_register);

        activity_context = this;

        spinner_industry = (Spinner) findViewById(R.id.spinner_industry);
        ArrayAdapter<CharSequence> adapter_industry = ArrayAdapter.createFromResource(this,
                R.array.industry_array, android.R.layout.simple_spinner_item);
        adapter_industry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_industry.setAdapter(adapter_industry);

        spinner_experience = (Spinner) findViewById(R.id.spinner_experience);
        ArrayAdapter<CharSequence> adapter_experience = ArrayAdapter.createFromResource(this,
                R.array.experience_array, android.R.layout.simple_spinner_item);
        adapter_experience.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_experience.setAdapter(adapter_experience);

        nameEditText = (EditText)findViewById(R.id.editText_name);
        urlEditText = (EditText)findViewById(R.id.editText_linkedin);

        Button finishButton = (Button)findViewById(R.id.button_finish_register_job_seeker);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent goToJobSeekerProfile = new Intent(activity_context, JobSeekerProfileActivity.class);
//                goToJobSeekerProfile.putExtra("NAME", nameEditText.getText().toString());
//                goToJobSeekerProfile.putExtra("INDUSTRY", spinner_industry.getSelectedItem().toString());
//                goToJobSeekerProfile.putExtra("EXPERIENCE", spinner_experience.getSelectedItem().toString());
//                goToJobSeekerProfile.putExtra("LINKEDIN_URL", urlEditText.getText().toString());
//                startActivity(goToJobSeekerProfile);
                postJobSeekerInfo();
            }
        });
    }

    private void postJobSeekerInfo() {
        // 1
        JobSeekerInfo newSeeker = new JobSeekerInfo();
        // TODO: cache current user
        newSeeker.setUsername(CustomUser.getCurrentUser().getString("username"));
        newSeeker.setName(nameEditText.getText().toString());
        newSeeker.setIndustry(spinner_industry.getSelectedItem().toString());
        newSeeker.setExperience(Integer.valueOf(spinner_experience.getSelectedItem().toString()));
        newSeeker.setLinkInLink(urlEditText.getText().toString());

        // 2
        ParseACL acl = new ParseACL();
        acl.setPublicReadAccess(true);
        newSeeker.setACL(acl);

        // 3
        newSeeker.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Intent goToJobSeekerProfile = new Intent(activity_context, JobSeekerProfileActivity.class);
                goToJobSeekerProfile.putExtra("NAME", nameEditText.getText().toString());
                goToJobSeekerProfile.putExtra("INDUSTRY", spinner_industry.getSelectedItem().toString());
                goToJobSeekerProfile.putExtra("EXPERIENCE", spinner_experience.getSelectedItem().toString());
                goToJobSeekerProfile.putExtra("LINKEDIN_URL", urlEditText.getText().toString());
                startActivity(goToJobSeekerProfile);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.job_seeker_register, menu);
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
