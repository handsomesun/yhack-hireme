package com.example.junyang.yhack_hireme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



public class JobSeekerRegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_register);

        Spinner spinner_industry = (Spinner) findViewById(R.id.spinner_industry);
        ArrayAdapter<CharSequence> adapter_industry = ArrayAdapter.createFromResource(this,
                R.array.industry_array, android.R.layout.simple_spinner_item);
        adapter_industry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_industry.setAdapter(adapter_industry);

        Spinner spinner_experience = (Spinner) findViewById(R.id.spinner_experience);
        ArrayAdapter<CharSequence> adapter_experience = ArrayAdapter.createFromResource(this,
                R.array.experience_array, android.R.layout.simple_spinner_item);
        adapter_experience.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_experience.setAdapter(adapter_experience);
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
