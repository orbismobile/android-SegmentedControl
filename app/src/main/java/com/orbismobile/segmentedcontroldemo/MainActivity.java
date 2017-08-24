package com.orbismobile.segmentedcontroldemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.orbismobile.segmentedcontrol.SegmentedControl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SegmentedControl.OnSegmentClickListener {
    private List<Object> segmentEntities;
    private SegmentedControl scGeneral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        scGeneral = (SegmentedControl) findViewById(R.id.scGeneral);

        segmentEntities = new ArrayList<>();
        segmentEntities.add(new UserSegmentEntity(1, "Carlos", false, "carlos"));
        segmentEntities.add(new UserSegmentEntity(2, "Carlos2", false, "carlos2"));
        segmentEntities.add(new UserSegmentEntity(3, "Carlos3", false, "carlos3"));
        segmentEntities.add(new UserSegmentEntity(4, "Carlos4", false, "carlos4"));
        segmentEntities.add(new UserSegmentEntity(5, "Carlos5", false, "carlos5"));

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
    public void onSegmentClick(View view, int position) {
        if(view.getId() == R.id.scGeneral){
            Toast.makeText(this, "id: " +((UserSegmentEntity)segmentEntities.get(position)).getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
