package com.example.temperatureconvertor;

import androidx.annotation.StringDef;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText et;
    ToggleButton tb;
    Double a;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=(EditText) findViewById(R.id.editText);
        b1=(Button) findViewById(R.id.button);
        tb=(ToggleButton) findViewById(R.id.toggleButton);
        result=(TextView) findViewById(R.id.txtresult );
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et.getText().toString().isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Please enter the temperature", Toast.LENGTH_SHORT).show();
                }

                else if(tb.isChecked())
                {
                    a=Double.parseDouble(String.valueOf(et.getText()));
                    Double b=a*9/5+32;
                    Double k=a+273;
                    BigDecimal s=new BigDecimal(b).setScale(3, RoundingMode.HALF_EVEN);
                    String r=String.valueOf(s);
                    String k1=String.valueOf(k);
                    result.setText(r+"°F \n"+k1+"K");
                }

                else
                {
                    a=Double.parseDouble(String.valueOf(et.getText()));
                    Double b=a-32;
                    Double c=b*5/9;
                    BigDecimal s=new BigDecimal(c).setScale(3, RoundingMode.HALF_EVEN);
                    BigDecimal k=new BigDecimal(c+273.15).setScale(3, RoundingMode.HALF_EVEN);
                    String r=String.valueOf(s);
                    String k1=String.valueOf(k);
                    result.setText(r+"°C \n"+k1+"K");
                }
            }
        });
    }
}