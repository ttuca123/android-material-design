package com.home.snackbartoast;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View relativeLayout = findViewById(R.id.actMain);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snackbar = Snackbar.make( view, "Item  excluido",Snackbar.LENGTH_LONG);

                snackbar.setAction("Fechar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });

                View snackView  = snackbar.getView();
                snackView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark, null));

                TextView snackActionView = snackView.findViewById(android.support.design.R.id.snackbar_action);
                snackActionView.setTextColor(getResources().getColor(android.R.color.white));
                snackbar.show();
            }
        });


    }
}
