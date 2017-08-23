package com.orbismobile.segmentedcontroldemo;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rgSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rgSelection = (RadioGroup) findViewById(R.id.rgSelection);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = rgSelection.indexOfChild(findViewById(rgSelection.getCheckedRadioButtonId()));
                Snackbar.make(view, "index: " + index, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        rgSelection.setOnCheckedChangeListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        RadioButton selected = (RadioButton) radioGroup.findViewById(i);
        Toast.makeText(this, "selected: " + selected.getText(), Toast.LENGTH_SHORT).show();
    }
}
