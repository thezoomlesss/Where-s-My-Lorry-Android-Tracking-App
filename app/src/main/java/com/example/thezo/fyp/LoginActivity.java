package com.example.thezo.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends AppCompatActivity {

    // The elements present in this activity
    private EditText company_edit, vehicle_edit, pass_edit;
    private Button login_button;

    public String Title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        company_edit = findViewById(R.id.idCompany);
        vehicle_edit = findViewById(R.id.idVehicle);
        pass_edit = findViewById(R.id.idPass);
        login_button = findViewById(R.id.idLogin);

        // On click -> Check if the fields are empty then route to the next activity
        // TODO Check login with DB
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !company_edit.getText().toString().isEmpty() && !vehicle_edit.getText().toString().isEmpty() && !pass_edit.getText().toString().isEmpty()){
                    Intent intent = new Intent (LoginActivity.this, MainScreen.class);
                    startActivity(intent);
                    finish();
                    //Toast.makeText(LoginActivity.this, "Not Empty "+ company_edit.getText().toString() + " "+ vehicle_edit.getText().toString() + " "+ pass_edit.getText().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Empty " + company_edit.getText().toString() + " "+ vehicle_edit.getText().toString() + " "+ pass_edit.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.google.com";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                Toast.makeText(LoginActivity.this, "Connection made", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError) {
                    Toast.makeText(LoginActivity.this, "Error timeout!", Toast.LENGTH_SHORT).show();

                }else if( error instanceof NoConnectionError) {
                    Toast.makeText(LoginActivity.this, "Error no connection!", Toast.LENGTH_SHORT).show();

                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(LoginActivity.this, "Error auth!", Toast.LENGTH_SHORT).show();

                } else if (error instanceof ServerError) {
                    Toast.makeText(LoginActivity.this, "Error ServerError!", Toast.LENGTH_SHORT).show();

                } else if (error instanceof NetworkError) {
                    Toast.makeText(LoginActivity.this, "Error Network!", Toast.LENGTH_SHORT).show();

                } else if (error instanceof ParseError) {
                    Toast.makeText(LoginActivity.this, "Error Parse!", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(LoginActivity.this, "IDK FAM!", Toast.LENGTH_SHORT).show();

                }


            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}