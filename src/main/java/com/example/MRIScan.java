package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MRIScan extends Examination{

    /**
     * Class defines the MRI examination and inherits from Examination
     */

    private String imageURL;
    private double magneticFieldStrength;

    public MRIScan(String imageURL, LocalDate date, double magneticFieldStrength) {
        super(date);
        this.imageURL = imageURL;
        this.magneticFieldStrength = magneticFieldStrength;
    }

    public MRIScan(String imageURL, double magneticFieldStrength) {
        super(LocalDate.now());
        this.imageURL = imageURL;
        this.magneticFieldStrength = magneticFieldStrength;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public double getMagneticFieldStrength() {
        return magneticFieldStrength;
    }

    public void setMagneticFieldStrength(double magneticFieldStrength) {
        this.magneticFieldStrength = magneticFieldStrength;
    }

    @Override
    public String toString() {
        return "MRI: " + magneticFieldStrength + " Tesla, " + getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ": ";
    }
}
