/*
Jose E. Rodriguez
CS 478 Spring 2019
Project 2
University of Illinois at Chicago

This activity displays a list of smartphones.
Each item in the list contains a thumbnail image
of the phone as well as some information next to
the image.
*/
package jrodr41.cs.uic.edu.smartphones;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private SmartphoneAdapter SM_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Adapter
        lv = (ListView) findViewById(R.id.smartphones_list);

        // instantiate list of smart phones
        SmartPhoneData data =  new SmartPhoneData();

        // Give list to adapter and add adapter to listview
        SM_Adapter = new SmartphoneAdapter(this,0, data.getSmartphones());
        lv.setAdapter(SM_Adapter);


        // When user short clicks on item, start new activity
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showImageActivity(view);
			}
		});

        registerForContextMenu(lv);
    }


    // Start activity which shows image that was short clicked on
    private void showImageActivity(View view){

        // Get image id and website
        int imageID = Integer.parseInt(view.findViewById(R.id.imageView_smartphone).getTag().toString());
        String website = view.findViewById(R.id.textView_top).getTag().toString();

        // Start activity, passing image id and website
        Intent intent = new Intent(MainActivity.this, ShowImage.class);
        Bundle mBundle = new Bundle();
        intent.putExtra("ImageID", imageID);
        intent.putExtra("Website", website);
        startActivity(intent);
    }


    // When user long clicks, a context menu is brought up
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_context_menu,menu);
    }


    // Handle when user clicks on context menu item
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        View view = info.targetView;
        switch(item.getItemId()){
            case R.id.view_specs:
                // TODO: Activity which shows specs
                displaySpecs(view);
                return true;
            case R.id.view_image:
                showImageActivity(view);
                return true;
            case R.id.view_web:
                String website = view.findViewById(R.id.textView_top).getTag().toString();
                invokeBrowser(website);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    // Start activity which shows phone's specs
    private void displaySpecs(View view){
        // Get specs to display
        String os = view.findViewById(R.id.textView_bottom).getTag(R.id.os).toString();
        String ram = view.findViewById(R.id.textView_bottom).getTag(R.id.ram).toString();
        String cpu = view.findViewById(R.id.textView_bottom).getTag(R.id.cpu).toString();
        String battery = view.findViewById(R.id.textView_bottom).getTag(R.id.battery).toString();

        // Set data in intent and start activity
        Intent specsIntent = new Intent(MainActivity.this, DisplaySpecs.class);
        specsIntent.putExtra("OS",os);
        specsIntent.putExtra("RAM",ram);
        specsIntent.putExtra("CPU",cpu);
        specsIntent.putExtra("Battery",battery);
        startActivity(specsIntent);
    }


    // Open web browser to smartphone's website
    private void invokeBrowser(String website){
        Intent browserIntent = new Intent();
        browserIntent.setAction(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(website));
        startActivity(browserIntent);
    }
}
