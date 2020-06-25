package com.hasanmehedi.bioflocapplication;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.hasanmehedi.bioflocapplication.R;

import com.hasanmehedi.bioflocapplication.AppConfig;

import com.hasanmehedi.bioflocapplication.AppController;

import com.hasanmehedi.bioflocapplication.SQLiteHandler;

import com.hasanmehedi.bioflocapplication.SessionManager;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();
    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputEmail;
    private EditText inputPassword;

    SharedPreferences Preferences;
    CheckBox remember;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        remember =(CheckBox) findViewById(R.id.rememberMe);

        btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        Preferences = getSharedPreferences("checkbox", Context.MODE_PRIVATE);
        String checkbox=   Preferences.getString("remember","");

        if(checkbox.equals("true")){
            // Launch login activity
            Intent intent = new Intent(LoginActivity.this,
                    MainActivity.class);
            startActivity(intent);
            finish();
        }
//        else  if(checkbox.equals("false")){
//            Toast.makeText(LoginActivity.this,
//                    "Please Login Again !",
//                    Toast.LENGTH_LONG).show();
//          //
//        }


        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                    Preferences=getSharedPreferences("checkbox", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= Preferences.edit();
                            editor.putString("remember","true");
                            editor.apply();
                }else if(!compoundButton.isChecked())
                {
                    Preferences=getSharedPreferences("checkbox", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= Preferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                }
            }
        });



    //    String loginStatus= sharedPreferences.getString(getResources().getString(R.string.prefLoginState),"");










        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    // login user
                    checkLogin(email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }
            }

        });

        // Link to Register Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    /**
     * function to verify login details in mysql db
     * */
    private void checkLogin(final String email, final String password)
    {

        final ProgressDialog progressDialog =new ProgressDialog(LoginActivity.this);

        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Logging in ...");
        progressDialog.show();
        String url="http://www.hasanmehedi.com/Biofloc/login.php";

        StringRequest request =new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("Login Success"))
                        {
                            progressDialog.dismiss();
                           Toast.makeText(LoginActivity.this,
                                    "Successfully Login !",
                                    Toast.LENGTH_LONG).show();

//                           SharedPreferences.Editor editor= Preferences.edit();
//                           if(remember.isChecked())
//                           {
//                               editor.putString(getResources().getString(R.string.prefLoginState),"loggedin");
//
//                           }else{
//                               editor.putString(getResources().getString(R.string.prefLoginState),"loggedout");
//
//                           }
//                           editor.apply();

                            // Launch login activity
                            Intent intent = new Intent(LoginActivity.this,
                                    MainActivity.class);
                            startActivity(intent);
                            finish();



                        }else{
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this,
                                    response,
                                    Toast.LENGTH_LONG).show();


                        }
                    }
                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error)
            {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this,error.toString(),
                        Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                HashMap<String,String> param =new HashMap<>();
                param.put("email",email);
                param.put("password",password);
                return param;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(3000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Mysingleton.getInstance(LoginActivity.this).addToRequestQueue(request);

    }

}