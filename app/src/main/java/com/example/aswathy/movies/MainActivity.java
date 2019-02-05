package com.example.aswathy.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    Button b,b1;
   // String r1,r2,r3,r4,r5,r6,r7,r8;
    String s1,s2,s3,s4,s5,s6,s7,s8;

    dbhelper databasehelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.mn);
        ed2=(EditText)findViewById(R.id.ma);
        ed3=(EditText)findViewById(R.id.mas);
        ed4=(EditText)findViewById(R.id.ry);
        ed5=(EditText)findViewById(R.id.dtr);
        ed6=(EditText)findViewById(R.id.pcr);
        ed7=(EditText)findViewById(R.id.cm);
        ed8=(EditText)findViewById(R.id.tc);
        b=(Button)findViewById(R.id.reg);
        b1=(Button)findViewById(R.id.srch);

        databasehelper=new dbhelper(this);
        databasehelper.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),moviesearchActivity.class);
                startActivity(i);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1 = ed1.getText().toString();
                s2 = ed2.getText().toString();
                s3 = ed3.getText().toString();
                s4 = ed4.getText().toString();
                s5 = ed5.getText().toString();
                s6 = ed6.getText().toString();
                s7 = ed7.getText().toString();
                s8 = ed8.getText().toString();
                Log.d("moviename", s1);
                Log.d("movieactor", s2);
                Log.d("movieactress", s3);
                Log.d("releaseyear", s4);
                Log.d("director", s5);
                Log.d("producer", s6);
                Log.d("cameraman", s7);
                Log.d("totalcollection", s8);



                boolean status = databasehelper.insertdata(s1, s2, s3, s4, s5, s6, s7, s8);
                if (status == true) {
                    Toast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
