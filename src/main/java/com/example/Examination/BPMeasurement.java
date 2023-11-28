package com.example.Examination;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BPMeasurement extends Examination {

    /**
     * Class defines the BP examination and inherits from Examination
     */

    private int systolic;
    private int diastolic;
    private BPTerm term;

    public BPMeasurement(int systolic, int diastolic, LocalDate date, BPTerm term) {
        super(date);
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.term = term;
    }

    public BPMeasurement(int systolic, int diastolic, BPTerm term) {
        super(LocalDate.now());
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.term = term;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }


    public BPTerm getTerm() {
        return term;
    }

    public void setTerm(BPTerm term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "BP: " + term.toString() + ", " + getDate().format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
    }

    /**
     * displayText() differs to toString() as this is used for the GUI
     */
    public String displayText(){
        return "Blood Pressure " + systolic + " over " + diastolic;
    }
}
