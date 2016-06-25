package com.iacsoftware.training.serverinteract;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    String fileName = "someFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

    }

    public void writeToFile(View view)
    {
       EditText input = (EditText) findViewById(R.id.editTextFileInput);

        String valueToWrite =  input.getText().toString();

        try {
            FileOutputStream fos = openFileOutput(fileName, MODE_APPEND);
            fos.write(valueToWrite.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("status", "File not found");
        }
        catch(IOException io)
        {
            Log.e("status", "Some issues writing to the file");
        }
    }

    public void readFromFile(View view) {
        StringBuilder valuesFromFile = new StringBuilder("");
        TextView output = (TextView) findViewById(R.id.textViewFile);
output.setMovementMethod(new ScrollingMovementMethod());
        try {
            FileInputStream fis = openFileInput(fileName);
            int readValue;
            while ((readValue = fis.read())!= -1)
            {
valuesFromFile.append(((Character)((char)readValue)).toString());
            }

output.setText(valuesFromFile);

        } catch (FileNotFoundException e) {
            Log.e("status", "File not found");
            Toast.makeText(FileActivity.this, "No File currently exists", Toast.LENGTH_SHORT).show();
        } catch (IOException io)
        {
            Log.e("status", "Some issues while reading from the file");
        }
    }

}
