package com.adonaiitsolutions.kcl.ui.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.adonaiitsolutions.kcl.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    TextView name,email,blood,id,addar,number,nomname,nomadhar,nomdob;
    ImageView profileimg;
    String value;
    
    String url="https://www.kscia.in/Php/getuser.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.pname);
        number=findViewById(R.id.pnumber);
        profileimg=findViewById(R.id.profile_image);
        blood=findViewById(R.id.pblood);
        id=findViewById(R.id.id);
        email=findViewById(R.id.pemail);
        addar=findViewById(R.id.paddar);
        nomname=findViewById(R.id.nomname);
        nomadhar=findViewById(R.id.nomadhar);
        nomdob=findViewById(R.id.nomdob);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getString("key");

        }


        getdata(value);
    }

    public void getdata(String id1){

        RequestQueue queue = Volley.newRequestQueue(this);


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try{
                        JSONArray jsonArray = new JSONArray(response);
                        JSONObject jsonObject = jsonArray.getJSONObject(0);

                        String firstName = jsonObject.getString("fname");
                        String email1 = jsonObject.getString("email");
                        String img = jsonObject.getString("profile_img");
                        String cid = jsonObject.getString("id");
                        String blood1 = jsonObject.getString("blood_group");
                        String number1 = jsonObject.getString("telephone");
                        String adhar1 = jsonObject.getString("adhar_card");
                        String nomname1=jsonObject.getString("nomname");
                        String nomdob1=jsonObject.getString("nomdob");
                        String nomadh1=jsonObject.getString("nomadh");

                        String imgurl="https://www.kscoa.in/Php/"+img;

                        name.setText(firstName);
                        email.setText(email1);
                        id.setText(cid);
                        blood.setText(blood1);
                        number.setText(number1);
                        addar.setText(adhar1);
                        nomname.setText(nomname1);
                        nomadhar.setText(nomadh1);
                        nomdob.setText(nomdob1);

                        Glide
                                .with(this)
                                .load(imgurl)
                                .centerCrop()
                                .into(profileimg);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Log.d("TAG", "onResponse: "+ response);
                }, error -> {

        }){
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String>parms= new HashMap<>();
                parms.put("email",value);
                return parms;
            }
        };

        queue.add(stringRequest);


    }
}