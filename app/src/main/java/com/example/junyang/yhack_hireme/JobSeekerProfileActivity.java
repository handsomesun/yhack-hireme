package com.example.junyang.yhack_hireme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;


public class JobSeekerProfileActivity extends Activity {

    LocationManager locationmanager;
    Context activity_context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_profile);

        activity_context = this;

        TextView nameTextView = (TextView) findViewById(R.id.textView_name);
        TextView industryTextView = (TextView) findViewById(R.id.textView_industry);
        TextView experienceTextView = (TextView) findViewById(R.id.textView_experience);
        TextView linkedinTextView = (TextView) findViewById(R.id.textView_url);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nameTextView.setText(extras.getString("NAME"));
            industryTextView.setText(extras.getString("INDUSTRY"));
            experienceTextView.setText(String.valueOf(extras.getInt("EXPERIENCE")));
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

        Button postButton = (Button)findViewById(R.id.button_post);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = CustomUser.getCurrentUser().getString("username");

                // get the name
                ParseQuery<ParseObject> query = ParseQuery.getQuery("JobSeekerInfo");
                query.whereEqualTo("username", username);
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> scoreList, ParseException e) {
                        if (e == null) {
                            Log.d("score", "Retrieved " + scoreList.size() + " scores");
                            // 1
                            Post post = new Post();
                            Location currentLocation = getLocation();
                            if (currentLocation == null) {
                                Toast.makeText(activity_context, "No location..", Toast.LENGTH_LONG).show();
                                return;
                            }
                            post.setLocation(new ParseGeoPoint(currentLocation.getLatitude(), currentLocation.getLongitude()));
                            post.setUsername(scoreList.get(0).getString("username"));
                            post.setName(scoreList.get(0).getString("name"));
                            post.setExpiration("TODO");

                            // 2
                            ParseACL acl = new ParseACL();
                            acl.setPublicReadAccess(true);
                            post.setACL(acl);

                            // 3
                            post.saveInBackground(new SaveCallback() {
                                public void done(ParseException e) {
                                    Toast.makeText(activity_context,"Posted!",Toast.LENGTH_LONG).show();
                                }
                            });
                        } else {
                            Log.d("score", "Error: " + e.getMessage());
                        }
                    }
                });
            }
        });
    }

    private Location getLocation() {
        locationmanager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Criteria cri=new Criteria();
        String provider=locationmanager.getBestProvider(cri,false);

        if(provider!=null & !provider.equals(""))
        {
            Location location=locationmanager.getLastKnownLocation(provider);
            //locationmanager.requestLocationUpdates(provider,2000,1,activity_context);
            if(location!=null)
            {
                return location;
            }
            else{
                Toast.makeText(getApplicationContext(), "location not found", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Provider is null",Toast.LENGTH_LONG).show();
        }
        return null;
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
