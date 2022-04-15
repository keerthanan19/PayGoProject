package com.assignment.paygoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.assignment.paygoproject.database.DBUtils;
import com.assignment.paygoproject.network.HandleApiResponse;
import com.assignment.paygoproject.object.Data;

import java.util.List;

public class SplashActivity extends AppCompatActivity {

    Context mContext;

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mContext = SplashActivity.this;

        progressBar = (ProgressBar) findViewById(R.id.progress_circular);
        textView = (TextView) findViewById(R.id.textView);
        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        getAllChild();
    }

    void getAllChild(){
        DBUtils.deleteAllData(mContext);
        HandleApiResponse handleApiResponse = new HandleApiResponse(this,"http://dev2.paygo.lk/");
        handleApiResponse.getAllData( new HandleApiResponse.CallBackDataDelegate() {
            @Override
            public void onResponseSuccess(List<Data> dataList) {
                Log.e("getAllChild", "result "+dataList.size());
                int count = 0;
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
/*
                for (Data data : dataList){
                    count ++;
                    DBUtils.insert_data(data,mContext);

                    if(count == dataList.size()){
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    }
                }
*/
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

}