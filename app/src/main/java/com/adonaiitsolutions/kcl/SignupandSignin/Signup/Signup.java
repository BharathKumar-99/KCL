package com.adonaiitsolutions.kcl.SignupandSignin.Signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.adonaiitsolutions.kcl.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Signup extends AppCompatActivity {
    String Name,Fathername,Dob,Blood,Phone,Email,Addar,NetworkName,Doorno,StreetName,Pin,Village,Taluk,
            NomineeName,NomineeAddar,NomineeRelation,NomineeDob,State,District,Pic;
    TextView name,father_name,dob,blood,phone,email,adhar,networkname,doorno,streetname,pin,village,
            taluk,nomineename,nomineeaddar,nomineerelation,nomineedob;
    Spinner state,district;
    Button pic,submit;
    int code;
    final Calendar myCalendar = Calendar.getInstance();
Boolean validated=false;
    SignupViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name =  findViewById(R.id.name);
        father_name =  findViewById(R.id.fathername);
        dob =  findViewById(R.id.dob);
        blood =  findViewById(R.id.bloodgroup);
        phone =  findViewById(R.id.phonenumber);
        email =  findViewById(R.id.email);
        adhar =  findViewById(R.id.adharnum);
        networkname =  findViewById(R.id.networkname);
        doorno =  findViewById(R.id.doorno);
        streetname =  findViewById(R.id.streetname);
        pin =  findViewById(R.id.pin);
        village =  findViewById(R.id.village);
        state =  findViewById(R.id.state);
        district =  findViewById(R.id.District);
        taluk =  findViewById(R.id.taluk);
        nomineename =  findViewById(R.id.nname);
        nomineeaddar =  findViewById(R.id.naddar);
        nomineerelation =  findViewById(R.id.nrelation);
        nomineedob =  findViewById(R.id.ndob);
        pic =  findViewById(R.id.photo);
        submit =  findViewById(R.id.submit);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             State=adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // Spinner Drop down elements
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.india_states));

        state.setAdapter(adapter);


        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                District=adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // Spinner Drop down elements
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.karnataka_district));

        district.setAdapter(adapter1);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(code);
            }

        };

        dob.setOnClickListener(v->{
            new DatePickerDialog(Signup.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            code=1;
        });
        nomineedob.setOnClickListener(v->{
            new DatePickerDialog(Signup.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            code=2;
        });

        submit.setOnClickListener(v -> {
            Name = name.getText().toString();
            Fathername = father_name.getText().toString();
            Dob = dob.getText().toString();
            Blood = blood.getText().toString();
            Phone = phone.getText().toString();
            Email = email.getText().toString();
            Addar = adhar.getText().toString();
            NetworkName = networkname.getText().toString();
            Doorno = doorno.getText().toString();
            StreetName = streetname.getText().toString();
            Pin = pin.getText().toString();
            Village = village.getText().toString();
            Taluk = taluk.getText().toString();
            NomineeName = nomineename.getText().toString();
            NomineeAddar = nomineeaddar.getText().toString();
            NomineeRelation = nomineerelation.getText().toString();
            NomineeDob = nomineedob.getText().toString();
            Pic = "Path";


            validator();
            if(validated){
            viewModel=new ViewModelProvider(this).get(SignupViewModel.class);



           String result= viewModel.postData(Name,Fathername,Dob,Blood,Phone,Email,Addar,NetworkName,Doorno,StreetName,Pin,
                    Village,Taluk,NomineeName,NomineeAddar,NomineeRelation,NomineeDob,State,District,Pic);

                Toast.makeText(Signup.this, result, Toast.LENGTH_SHORT).show();

                name.setText(null);
                father_name.setText(null);
                dob.setText(null);
                blood.setText(null);
                phone.setText(null);
                email.setText(null);
                adhar.setText(null);
                networkname.setText(null);
                doorno.setText(null);
                streetname.setText(null);
                pin.setText(null);
                taluk.setText(null);
                nomineename.setText(null);
                nomineeaddar.setText(null);
                nomineerelation.setText(null);
                nomineedob.setText(null);
            }

            });
    }

    private void updateLabel(int code) {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        if (code == 1) {
            dob.setText(sdf.format(myCalendar.getTime()));
            code=0;
        }if (code == 2){
            nomineedob.setText(sdf.format(myCalendar.getTime()));
            code=0;
    }

    }




    public Boolean validator(){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(Name.length()==0)
        {
            name.requestFocus();
            name.setError("FIELD CANNOT BE EMPTY");validated=false;
        }
        else if(!Name.matches("[a-zA-Z ]+"))
        {
            name.requestFocus();
            name.setError("ENTER ONLY ALPHABETICAL CHARACTER");validated=false;
        }
        //name
       else if(Fathername.length()==0)
        {
            father_name.requestFocus();
            father_name.setError("FIELD CANNOT BE EMPTY");validated=false;
        }
        else if(!Fathername.matches("[a-zA-Z ]+"))
        {
            father_name.requestFocus();
            father_name.setError("ENTER ONLY ALPHABETICAL CHARACTER");validated=false;
        }
       else if(Phone.length()==0)
        {
            phone.requestFocus();
            phone.setError("FIELD CANNOT BE EMPTY");validated=false;
        }
        else if(!(Phone.length() ==10))
        {
            phone.requestFocus();
            phone.setError("InValid Number");validated=false;
        }//phone
       else if(Addar.length()==0)
        {
            adhar.requestFocus();
            adhar.setError("FIELD CANNOT BE EMPTY");validated=false;
        }
        else if(!(Addar.length() ==12))
        {
            adhar.requestFocus();
            adhar.setError("Invalid");validated=false;
        }

        else if (!Email.matches(emailPattern))
        {
            email.setError("Invalid Email");
            validated=false;
        }
        else
            return validated=true;
        return validated;
    }
}