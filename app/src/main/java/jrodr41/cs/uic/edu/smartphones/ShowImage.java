/*
Jose E. Rodriguez
CS 478 Spring 2019
Project 2
University of Illinois at Chicago

This activity displays the full image of the
smart phone which the user short clicked on.

When image is clicked on, take user to the
phone's official webpage.
*/
package jrodr41.cs.uic.edu.smartphones;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ShowImage extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        // Get image id
        Intent mIntent = getIntent();
        int imageID = mIntent.getIntExtra("ImageID", 0);
        final String website = mIntent.getStringExtra("Website");

        // Set image using image id from Main Activity
        imageView = (ImageView) findViewById(R.id.full_image);
        imageView.setImageResource(imageID);

        // When image is clicked, go to smartphone's website
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokeBrowser(website);
            }
        });
    }


    // Open web browser to smartphone's website
    private void invokeBrowser(String website){
        Intent browserIntent = new Intent();
        browserIntent.setAction(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(website));
        startActivity(browserIntent);
    }
}
