/*
Jose E. Rodriguez
CS 478 Spring 2019
Project 2
University of Illinois at Chicago

Custom adapter used to display information about
each smartphone in the list view.
 */
package jrodr41.cs.uic.edu.smartphones;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneAdapter extends ArrayAdapter<Smartphone> {

    private Context context;
    private ArrayList<Smartphone> smartphoneList = new ArrayList<>();

    // Constructor
    public SmartphoneAdapter(Context context, int resource, ArrayList<Smartphone> list){
        super(context, resource, list);
        this.context = context;
        this.smartphoneList = list;
    }


    // Must override getView() method
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        Smartphone currentSP = smartphoneList.get(position);

        // Get the picture of the smartphone
        ImageView image = (ImageView)listItem.findViewById(R.id.imageView_smartphone);
        image.setImageResource(currentSP.getThumbnail_id());
        image.setTag(currentSP.getThumbnail_id());

        // Set brand name of phone
        TextView topDetails = (TextView) listItem.findViewById(R.id.textView_top);
        topDetails.setText(currentSP.getBrandAndModel());
        topDetails.setTag(currentSP.getWebsite());

        // Set screen size and price range of phone
        TextView bottomDetails = (TextView) listItem.findViewById(R.id.textView_bottom);
        bottomDetails.setText(currentSP.getScreenSizeAndPrice());
        bottomDetails.setTag(R.id.os,currentSP.getOS());
        bottomDetails.setTag(R.id.ram,currentSP.getRAM());
        bottomDetails.setTag(R.id.cpu,currentSP.getCPU());
        bottomDetails.setTag(R.id.battery,currentSP.getBattery());

        return listItem;
    }
}
