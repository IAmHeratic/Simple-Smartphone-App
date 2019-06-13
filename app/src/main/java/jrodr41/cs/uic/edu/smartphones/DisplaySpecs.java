/*
Jose E. Rodriguez
CS 478 Spring 2019
Project 2
University of Illinois at Chicago

This activity displays the specs of
the smart phone.
*/
package jrodr41.cs.uic.edu.smartphones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplaySpecs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_specs);

        TextView title = (TextView) findViewById(R.id.specs_title);
        TextView os = (TextView) findViewById(R.id.operating_sys);
        TextView ram = (TextView) findViewById(R.id.ram);
        TextView cpu = (TextView) findViewById(R.id.cpu);
        TextView battery = (TextView) findViewById(R.id.battery);

        Intent mIntent = getIntent();

        title.setText("Specs:");
        os.setText("Operating System: " + mIntent.getStringExtra("OS"));
        ram.setText("RAM: " + mIntent.getStringExtra("RAM"));
        cpu.setText("CPU: " + mIntent.getStringExtra("CPU"));
        battery.setText("Battery: " + mIntent.getStringExtra("Battery"));
    }
}
