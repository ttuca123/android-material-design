package com.home.progressbar;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    private ProgressBar circularBar;
    private ProgressBar linearBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circularBar = findViewById(R.id.circularBar);

        linearBar = findViewById(R.id.linearBar);

        linearBar.setProgress(0);

        linearBar.setMax(100);

        circularBar.setVisibility(View.GONE);

        AssyncCircular assinc = new AssyncCircular();

        assinc.execute();
    }

    public class AssyncCircular extends AsyncTask<Void, Integer, Void>{


        @Override
        protected void onPreExecute() {
            circularBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            int i=0;

            do{

                try {
                    Thread.sleep(300);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;

            }while(i<100);

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            linearBar.setProgress(values[0]);
            linearBar.setSecondaryProgress(values[0]+15);
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            circularBar.setVisibility(View.GONE);

        }
    }
}
