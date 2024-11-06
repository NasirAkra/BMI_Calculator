package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText edtHeightFt,edtWeight,edtHeightIn;
        Button btnCalculate,restart;
        LinearLayout llMain=findViewById(R.id.llmain);
        edtWeight=findViewById(R.id.edtWeight);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        txtResult=findViewById(R.id.txtResult);
        btnCalculate=findViewById(R.id.btnCalculate);
        restart=findViewById(R.id.restart);





        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v)
            {
            int wt= Integer.parseInt( edtWeight.getText().toString());
            int in= Integer.parseInt(  edtHeightIn.getText().toString());
            int ft=Integer.parseInt(edtHeightFt.getText().toString());

            int totalIn=ft*12+in;
            double totalCm=totalIn*2.53;
            double totalM=totalCm/100;
            double bmi=wt/(totalM*totalM);
            if(bmi>25)
            {
                txtResult.setText("You are overweight");
                llMain.setBackgroundColor(getColor(R.color.uw));
                Toast.makeText(MainActivity.this, "GOOD", Toast.LENGTH_SHORT).show();

            } else if (bmi<18)
            {
                txtResult.setText("You are underweight");
                llMain.setBackgroundColor(getColor(R.color.H));
                Toast.makeText(MainActivity.this, "GOOD", Toast.LENGTH_SHORT).show();
            }
            else
            {
                txtResult.setText("You are Healthy!");
                llMain.setBackgroundColor(getColor(R.color.OW));
                Toast.makeText(MainActivity.this, "GOOD", Toast.LENGTH_SHORT).show();
            }


            }
        });
      restart.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              clearDisplay();
          }

          @SuppressLint("SetTextI18n")
          private void clearDisplay() {
              txtResult.setText("Result");
              edtHeightFt.setText(" ");
              edtHeightIn.setText(" ");
              edtWeight.setText(" ");



          }
      });






    }
}
