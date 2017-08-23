package com.orbismobile.segmentedcontroldemo;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.orbismobile.segmentedcontrol.SegmentEntity;
import com.orbismobile.segmentedcontrol.SegmentedControl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, SegmentedControl.OnSegmentClickListener {

    SegmentedControl scGeneral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        scGeneral = (SegmentedControl) findViewById(R.id.scGeneral);

        List<SegmentEntity> segmentEntities = new ArrayList<>();
        segmentEntities.add(new SegmentEntity("Carlos", false));
        segmentEntities.add(new SegmentEntity("Carlos2", false));
        segmentEntities.add(new SegmentEntity("Carlos3", false));
        segmentEntities.add(new SegmentEntity("Carlos4", false));
        segmentEntities.add(new SegmentEntity("Carlos5", false));

        scGeneral.addList(segmentEntities);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "selected: " + scGeneral.getSegmentSelectedIndex(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        scGeneral.setOnSegmentClickListener(this);
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

    @Override
    public void onSegmentClick(View view, int position) {
        Toast.makeText(this, "position: " +position, Toast.LENGTH_SHORT).show();
    }
}
