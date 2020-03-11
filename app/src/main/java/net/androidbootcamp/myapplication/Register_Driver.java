package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import androidx.appcompat.app.AppCompatActivity;

public class Register_Driver extends AppCompatActivity {
    EditText dri_first_name, dri_street_address, dri_license, dri_password, dri_id, dri_city, dri_username, dri_zip_code, dri_state;
    Button submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__vendor);

          Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("got-it-driver-app") // should correspond to APP_ID env variable
                .clientKey(null)  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://got-it-driver-app.herokuapp.com/parse/").build());


        //-------------------------------
        // Driver Registration Input
        //-------------------------------
        dri_first_name = findViewById(R.id.dri_first_name);
        dri_street_address = findViewById(R.id.dri_street_address);
        dri_city = findViewById(R.id.dri_city);
        dri_zip_code = findViewById(R.id.dri_zip_code);
        dri_state = findViewById(R.id.dri_state);
        dri_license = findViewById(R.id.dri_id);
        dri_username = findViewById(R.id.dri_username);
        dri_password = findViewById(R.id.dri_password);

        //-----------------------------------
        //submit Driver registry info
        //------------------------------------
        submit_button = findViewById(R.id.submit4_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String DriverName = dri_first_name.getText().toString();
                final String DriverAddress = dri_street_address.getText().toString();
                final String DriverCity = dri_city.getText().toString();
                final String DriverZip = dri_zip_code.getText().toString();
                final String DriverState = dri_state.getText().toString();
                final String DriverUser = dri_username.getText().toString();
                final String DriverPassword = dri_password.getText().toString();
                //final String DriverID = dri_id.getText().toString();

                if (DriverName.isEmpty() || DriverAddress.isEmpty() || DriverCity.isEmpty() ||
                        DriverZip.isEmpty() || DriverState.isEmpty()) {
                    Toast.makeText(Register_Driver.this, "Complete the registration fields.", Toast.LENGTH_SHORT).show();
                } else {

                    ParseObject newDriver = new ParseObject("Driver");
                    newDriver.put("dri_first_name", DriverName);
                    newDriver.put("dri_streetaddress",DriverAddress);
                    newDriver.put("dri_city", DriverCity);

                    newDriver.put("dri_zipcode", "444");
//                    newDriver.put("dri_id", Integer.parseInt(DriverID));
                    //newDriver.put("dri_id", "2223");

                    newDriver.put("dri_state", DriverState);
//                    newStore.put("ven_account_num", Integer.parseInt(accountNumberResult));

                    newDriver.put("dri_username", DriverUser);
                    newDriver.put("dri_password", DriverPassword);
                    newDriver.put("dri_license", "333");
                    newDriver.put("dri_status", true);
                    newDriver.put("dri_insurance", "insurance");
                    newDriver.put("dri_license_plate", "234");
                    newDriver.put("dri_vehicle_year", 203);
                    newDriver.put("dri_dob", 203);
                    newDriver.put("dri_vehicle_model", 203);
                    newDriver.put("dri_last_name", "ldldd");
                    newDriver.put("dri_phone", 224334432);
                    newDriver.put("dri_ssn", 3435234);
                    newDriver.put("dri_vehicle_make", ",ale");
                    newDriver.put("dri_stripe_id", "3435234");
                    newDriver.put("dri_w4", "3435234");


                    newDriver.saveInBackground(new SaveCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(Register_Driver.this, "Driver Created.", Toast.LENGTH_SHORT).show();
                                Intent c = new Intent(Register_Driver.this, Login.class);
                                startActivity(c);
                            } else {
                                // Error occurred
                                Toast.makeText(Register_Driver.this, e.getMessage(), Toast.LENGTH_LONG);
                            }
                        }
                    });
                }
            }
        });
    }
}
