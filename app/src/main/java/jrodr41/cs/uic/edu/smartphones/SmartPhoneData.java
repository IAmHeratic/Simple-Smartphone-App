/*
Jose E. Rodriguez
CS 478 Spring 2019
Project 2
University of Illinois at Chicago

This class contains all the data about the smartphones.
*/
package jrodr41.cs.uic.edu.smartphones;

import java.util.ArrayList;

public class SmartPhoneData {

    private ArrayList<Smartphone> listOfPhones;

    // Constructor
    public SmartPhoneData(){
        listOfPhones = new ArrayList<>();
        insertPhones(listOfPhones);
    }


    // This method populates the list with the phones
    // to be displayed in the list view.
    private void insertPhones(ArrayList<Smartphone> list){

        list.add(new Smartphone(R.drawable.samsung_galaxy_s10, "Samsung Galaxy S10" , "6.1 inches, $1000",
                "https://www.samsung.com/us/mobile/galaxy-s10/buy/", "Android 9", "8 GB", "Octa-core chipset",
                "3,400mAh"));

        list.add(new Smartphone(R.drawable.samsung_galaxy_s9, "Samsung Galaxy S9" , "5.8 inches, $619.99",
                "https://www.samsung.com/us/smartphones/galaxy-s9/buy/v2/s/Device/", "Android 8", "4 GB",
                "Snapdragon 845 / Exynos 9810", "3,000mAh"));

        list.add(new Smartphone(R.drawable.samsung_galaxy_s8, "Samsung Galaxy S8" , "5.8 inches, $499",
                "https://www.samsung.com/us/explore/galaxy-s8/buy/", "Android 7", "4 GB",
                "Octa-core Qualcomm Snapdragon 835 chip", "3000mAh battery"));

        list.add(new Smartphone(R.drawable.iphone_xr, "iPhone XR" , "6.1 inches, $749",
                "https://www.apple.com/shop/buy-iphone/iphone-xr", "iOS 12", "3 GB",
                "Apple A12 Bionic (7 nm)", "2942 mAh battery"));

        list.add(new Smartphone(R.drawable.iphone8, "iPhone 8" , "4.7 inches, $599",
                "https://www.apple.com/shop/buy-iphone/iphone-8", "iOS 11", "2 GB",
                "Hexa-core (2x Monsoon + 4x Mistral)", "1821 mAh battery (6.96 Wh)"));

        list.add(new Smartphone(R.drawable.google_pixel3_xl, "Google Pixel 3 XL" , "5.5 inches, $799",
                "https://store.google.com/us/product/pixel_3?hl=en-US", "Android 9", "4 GB",
                "Octa-core (4x2.5 GHz Kryo 385 Gold & 4x1.6 GHz Kryo 385 Silver)", "3430 mAh battery"));

        list.add(new Smartphone(R.drawable.google_pixel2, "Google Pixel 2" , "5 inches, $649",
                "https://store.google.com/gb/product/pixel_2", "Android 8", "4 GB",
                "Octa-core (4x2.35 GHz Kryo & 4x1.9 GHz Kryo)", "2700 mAh battery"));
    }


    // Returns list of smart phones
    public ArrayList<Smartphone> getSmartphones(){ return this.listOfPhones; }
}
