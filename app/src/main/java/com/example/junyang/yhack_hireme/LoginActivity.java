package com.example.junyang.yhack_hireme;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class LoginActivity extends Activity {

    EditText usernameEditText;
    EditText passwordEditText;
    EditText passwordAgainEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Context activity_context = this;
        Button loginButton = (Button)findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLoginDialog();
            }
        });

        Button signUpButton = (Button) findViewById(R.id.button_new_user);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSignUpDialog();
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

    private void callLoginDialog()
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
                //TODO: loging and decide if recruiter or job seeker
            }
        });
    }

    private void callSignUpDialog()
    {
        Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.activity_signup_popup);
        Button signup = (Button) myDialog.findViewById(R.id.button_sign_up);

        usernameEditText = (EditText) myDialog.findViewById(R.id.editText_sign_up_email);
        passwordEditText = (EditText) myDialog.findViewById(R.id.editText_sign_up_password);
        passwordAgainEditText = (EditText) myDialog.findViewById(R.id.editText_sign_up_confirm_password);
        myDialog.show();

        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //IF sign up success, go to registerclass
                signUp();
            }
        });
    }

    private void signUp() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String passwordAgain = passwordAgainEditText.getText().toString().trim();

        boolean validationError = false;
        StringBuilder validationErrorMessage = new StringBuilder(getString(R.string.error_intro));
        if (username.length() == 0) {
            validationError = true;
            validationErrorMessage.append(getString(R.string.error_blank_username));
        }
        if (password.length() == 0) {
            if (validationError) {
                validationErrorMessage.append(getString(R.string.error_join));
            }
            validationError = true;
            validationErrorMessage.append(getString(R.string.error_blank_password));
        }
        if (!password.equals(passwordAgain)) {
            if (validationError) {
                validationErrorMessage.append(getString(R.string.error_join));
            }
            validationError = true;
            validationErrorMessage.append(getString(R.string.error_mismatched_passwords));
        }
        validationErrorMessage.append(getString(R.string.error_end));

        if (validationError) {
            Toast.makeText(LoginActivity.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // start progress dialog
        final ProgressDialog ringProgressDialog = ProgressDialog.show(LoginActivity.this, "Please wait ...", "Signing up ...", true);

        // Set up a new Parse user
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        // Call the Parse signup method
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                // Dismiss the dialog
                if (e != null) {
                    // Show the error message
                    Toast.makeText(LoginActivity.this, e.getMessage(),
                            Toast.LENGTH_LONG).show();
                } else {
                    // Start an intent for the dispatch activity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}
