package com.example;

public class MedicalInvestigation{

    /**
     * Class defines the Medical Investigation
     * input: MRI Scan, BP Measurement bp, Patient patient
     */

    private MRIScan scan;
    private BPMeasurement bp;
    private Patient patient;

    public MedicalInvestigation(MRIScan scan, BPMeasurement bp, Patient patient) {
        this.scan = scan;
        this.bp = bp;
        this.patient = patient;
    }

    public MRIScan getScan() {
        return scan;
    }

    public void setScan(MRIScan scan) {
        this.scan = scan;
    }

    public BPMeasurement getBp() {
        return bp;
    }

    public void setBp(BPMeasurement bp) {
        this.bp = bp;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String toString(){
        return scan.toString() + bp.toString();
    }
}
