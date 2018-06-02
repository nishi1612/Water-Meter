package com.example.application.watermeter;

import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class bill extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        textView = (TextView) findViewById(R.id.text);

        ValueEventListener valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String str = dataSnapshot.getValue(String.class);
                //textView.setText(str);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        PdfDocument document = new PdfDocument();

        PdfDocument.PageInfo pageInfo;
        pageInfo = new PdfDocument.PageInfo.Builder(100,100, 1).create();
        PdfDocument.Page page = document.startPage(pageInfo);
        document.finishPage(page);
        document.close();
    }
}

//                            if(date.equals("1")){
//                                date = "01";
//                            }else if(date.equals("2")){
//                                date = "02";
//                            }else if(date.equals("3")){
//                                date = "03";
//                            }else if(date.equals("4")){
//                                date = "04";
//                            }else if(date.equals("5")){
//                                date = "05";
//                            }else if(date.equals("6")){
//                                date = "06";
//                            }else if(date.equals("7")){
//                                date = "07";
//                            }else if(date.equals("8")){
//                                date = "08";
//                            }else if(date.equals("9")){
//                                date = "09";
//                            }
//
//                            if(month.equals("January")){
//                                month = "01";
//                            }else if(month.equals("February")){
//                                if(date.equals("29") || date.equals("30") || date.equals("31")){
//                                    Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                                    return ;
//                                }
//                                month = "02";
//                            }else if(month.equals("March")){
//                                month = "03";
//                            }else if(month.equals("April")){
//                                if(date.equals("31")){
//                                    Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                                    return ;
//                                }
//                                month = "04";
//                            }else if(month.equals("May")){
//                                month = "05";
//                            }else if(month.equals("June")){
//                                if(date.equals("31")){
//                                    Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                                    return ;
//                                }
//                                month = "06";
//                            }else if(month.equals("July")){
//                                month = "07";
//                            }else if(month.equals("August")){
//                                month = "08";
//                            }else if(month.equals("September")){
//                                if(date.equals("31")){
//                                    Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                                    return ;
//                                }
//                                month = "09";
//                            }else if(month.equals("October")){
//                                month = "10";
//                            }else if(month.equals("November")){
//                                if(date.equals("31")){
//                                    Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                                    return ;
//                                }
//                                month = "11";
//                            }else if(month.equals("December")) {
//                                month = "12";
//                            }
//
//                            final String initial_date = date + month + user_signup_year.getSelectedItem().toString();
//
//
//                            Calendar calendar = Calendar.getInstance();
//
//                            int thisYear = calendar.get(Calendar.YEAR);
//                            int thisMonth = calendar.get(Calendar.MONTH);
//                            int thisDate = calendar.get(Calendar.DAY_OF_MONTH);
//
//                            int given_date = user_signup_date.getSelectedItemPosition() + 1;
//                            int given_month = user_signup_month.getSelectedItemPosition();
//                            int given_year = user_signup_year.getSelectedItemPosition() + 2017;
//
//                            //Toast.makeText(getApplicationContext(),thisYear + " " + given_year,Toast.LENGTH_LONG).show();
//
//                            if(given_year == thisYear){
//                                if(given_month > thisMonth){
//                                    Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                                    return ;
//                                }else if(given_month == thisMonth){
//                                    if(given_date > thisDate){
//                                        Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                                        return ;
//                                    }
//                                }
//                            }