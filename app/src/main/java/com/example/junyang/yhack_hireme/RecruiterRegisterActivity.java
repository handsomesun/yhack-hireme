package com.example.junyang.yhack_hireme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RecruiterRegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiter_register);

        final Context activity_context = this;
        final EditText nameEditText = (EditText)findViewById(R.id.editText_name_recruiter);
        final EditText companyNameEditText = (EditText)findViewById(R.id.editText_company_name);
        final EditText descriptionEditText = (EditText) findViewById(R.id.editText_des_recruiter);

        Button finishButton = (Button) findViewById(R.id.button_finish_recruiter);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRegisterMain = new Intent(activity_context, RecruiterMainActivity.class);
                goToRegisterMain.putExtra("RECRUITER_NAME", nameEditText.getText().toString());
                goToRegisterMain.putExtra("RECRUITER_COMPANY_NAME", companyNameEditText.getText().toString());
                goToRegisterMain.putExtra("RECRUITEE_DESCRIPTION", descriptionEditText.getText().toString());
                startActivity(goToRegisterMain);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.recruiter_register, menu);
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
