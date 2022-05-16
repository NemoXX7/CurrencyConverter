package com.st10120712.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declarations
    Spinner sp1, sp2;
    EditText ed1;
    Button b1;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting UI elements to variables
        ed1 = findViewById(R.id.txtAmount);
        sp1 = findViewById(R.id.spFrom);
        sp2 = findViewById(R.id.spTo);
        b1 = findViewById(R.id.btn1);
        output = findViewById(R.id.output);

        //Populate the Spinner options with string arrays
        String[] from = {"USD", "ZAR"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad1);

        String[] to = {"ZAR", "USD"};
        ArrayAdapter ad2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, to);
        sp2.setAdapter(ad2);

        //Button onClick event
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double print;
                double amount = Double.parseDouble(ed1.getText().toString());

               //Validation
                if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "ZAR")
                {
                    print = amount * 14.62;
                    output.setText(print.toString());
                }
                else if(sp1.getSelectedItem().toString() == "ZAR" && sp2.getSelectedItem().toString() == "USD")
                {
                    print = amount * 0.068;
                    output.setText(print.toString());
                }

                //Error handling
                else if(sp1.getSelectedItem().toString() == "ZAR" && sp2.getSelectedItem().toString() == "ZAR")
                {
                    output.setText("");
                    //Displays as a Toast message pop-up
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
                else if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString() == "USD")
                {
                    output.setText("");
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}