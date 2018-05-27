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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class bill extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
