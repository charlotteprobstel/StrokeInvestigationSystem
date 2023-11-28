package com.example;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String name;
    private String pictureURL;
    private int age;
    private List<MedicalInvestigation> medInvestigation;

    public Patient(String name, String pictureURL, int age) {
        this.name = name;
        this.pictureURL = pictureURL;
        this.age = age;
        this.medInvestigation = new ArrayList<>();
    }

    public void addMedicalInvestigation(MedicalInvestigation mI){
        medInvestigation.add(mI);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<MedicalInvestigation> getMedInvestigation() {
        return medInvestigation;
    }

    public void setMedInvestigation(List<MedicalInvestigation> medInvestigation) {
        this.medInvestigation = medInvestigation;
    }

    public String displayText() {
        return "<html>Name: " + name + ",<br> Age: " + age + "</html>";
    }
}
