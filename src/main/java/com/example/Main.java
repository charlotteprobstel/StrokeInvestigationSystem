package com.example;

import com.example.Examination.BPMeasurement;
import com.example.Examination.BPTerm;
import com.example.Examination.MRIScan;
import com.example.Examination.MedicalInvestigation;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Message to the examiner:
        /**
         * I took my own approach to the task by adding the flexibility for a patient to have multiple medical examinations
         **/

        //Creating Patient Daphne, their MRIScan, their BPMeasurement.
        Patient daphne = new Patient("Daphne Von Oram", "https://martinh.netfirms.com/BIOE60010/DaphneVonOram.jpg", 62);
        MRIScan daphneScan = new MRIScan("https://martinh.netfirms.com/BIOE60010/mri1.jpg", LocalDate.of(2023,9,14), 2);
        BPMeasurement daphneBP = new BPMeasurement(130, 70, LocalDate.of(23,9,15), BPTerm.ST);
        MedicalInvestigation daphneMI = new MedicalInvestigation(daphneScan, daphneBP,daphne);
        daphne.addMedicalInvestigation(daphneMI);

        //Creating Patient Sebastian, their MRIScan, their BPMeasurement.
        Patient sebastian = new Patient("Sebastian Compton", "https://martinh.netfirms.com/BIOE60010/SebastianCompton.jpg", 31);
        MRIScan sebastianScan = new MRIScan("https://martinh.netfirms.com/BIOE60010/mri2.jpg", LocalDate.of(2023,11,19), 4);
        BPMeasurement sebastianBP = new BPMeasurement(150, 80, LocalDate.of(23,11,20),BPTerm.VST);
        MedicalInvestigation sebastianMI = new MedicalInvestigation(sebastianScan, sebastianBP,sebastian);
        sebastian.addMedicalInvestigation(sebastianMI);

        //Adding Patients to the Log of all Patients and all Medical Examinations
        Log log = new Log();
        log.addToLog(daphne);
        log.addToLog(sebastian);

        //The same patient is added with a different medical examination
        MRIScan daphneScan2 = new MRIScan("https://martinh.netfirms.com/BIOE60010/mri1.jpg", LocalDate.of(2024,7,1), 6);
        BPMeasurement daphneBP2 = new BPMeasurement(90, 70, LocalDate.of(23,5,11),BPTerm.VST);
        MedicalInvestigation daphneMI2 = new MedicalInvestigation(daphneScan2, daphneBP2,daphne);
        daphne.addMedicalInvestigation(daphneMI2);
        log.addToLog(daphne);

        //View the examinations in the console
        log.viewExams();
        //View the examinations in the frame
        log.viewPatients();




    }
}