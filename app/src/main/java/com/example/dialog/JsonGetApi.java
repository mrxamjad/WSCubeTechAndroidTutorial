package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonGetApi extends AppCompatActivity {
    String title;

    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_get_api);



        String urls="https://jsonplaceholder.typicode.com/users";
        String url="https://jsonplaceholder.typicode.com/todos/1";



        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);
//
//        //response of an JSONObject
//
//        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    title = response.getString("title");
//                    Log.d("mrx", "onResponse: " + title);
//                    Toast.makeText(getApplicationContext(),"This is executing", Toast.LENGTH_SHORT).show();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("errors","there is some error");
//                Toast.makeText(getApplicationContext(),"This is error throwing", Toast.LENGTH_SHORT).show();
//            }
//        });
//        requestQueue.add(jsonObjectRequest);
        ArrayList <String> arrTitle=new ArrayList<>();


        //response of an JSONArray
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, urls, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i=0; i<response.length();i++)
                    {
                        JSONObject obj=response.getJSONObject(i);


                        int id=obj.getInt("id");
                        String name=obj.getString("name");
                        Toast.makeText(getApplicationContext(),"This is okay", Toast.LENGTH_SHORT).show();

//                        arrTitle.add(title);
                        Log.d("array", "onResponse: "+obj.toString());
                        Log.d("id", "id: "+id);
                        Log.d("id", "Title: "+name);
                    }
//
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("errors","there is some error");
                Toast.makeText(getApplicationContext(),"This is error throwing", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);







    }
}