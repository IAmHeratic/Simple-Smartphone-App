/*
Jose E. Rodriguez
CS 478 Spring 2019
Project 2
University of Illinois at Chicago

This class contains information about each smartphone
that is being displayed in the list.
 */
package jrodr41.cs.uic.edu.smartphones;

public class Smartphone {

    private int thumbnail_id;       // thumbnail id of drawable
    private String brand_model;     // brand and model of phone
    private String screensize_price;// screen size and price range of phone
    private String phone_website;   // website of the phone
    private String operating_sys;   // Operating System of device
    private String ram;             // Amount of RAM device has
    private String cpu;             // Device CPU
    private String battery;         // Device battery

    // Constructor
    public Smartphone(int thumbnail_id, String brand_model, String screensize_price,
                      String website, String operating_sys, String ram, String cpu, String battery){
        this.thumbnail_id = thumbnail_id;
        this.brand_model = brand_model;
        this.screensize_price = screensize_price;
        this.phone_website = website;
        this.operating_sys = operating_sys;
        this.ram = ram;
        this.cpu = cpu;
        this.battery = battery;
    }


    // Getter methods
    public int getThumbnail_id(){ return this.thumbnail_id; }
    public String getBrandAndModel(){ return this.brand_model; }
    public String getScreenSizeAndPrice(){ return this.screensize_price; }
    public String getWebsite(){ return this.phone_website; }
    public String getOS(){ return this.operating_sys; }
    public String getRAM(){ return this.ram; }
    public String getCPU(){ return this.cpu; }
    public String getBattery(){ return this.battery; }
}
