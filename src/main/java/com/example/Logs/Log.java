package com.example.Logs;

import com.example.Examination.MedicalInvestigation;
import com.example.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Log extends GeneralLog {

    /**
     * Class defines the Medical Log
     * Two HashMaps of Patients and Medical Investigations is made to avoid repetition.
     */

    private HashMap<Patient, MedicalInvestigation> patients;
    private HashMap<MedicalInvestigation, Patient> exams;
    private static int count = 0;

    public Log() {
        this.patients = new HashMap<Patient, MedicalInvestigation>();
        this.exams = new HashMap<MedicalInvestigation, Patient>();
    }

    /**
     * Method allows any patient to be added to the log. Since a patient is always updated with
     * a new medical examination, this method updates the two hashmaps.
     */
    public void addToLog(Patient p){
        for(MedicalInvestigation mI : p.getMedInvestigation()){
            patients.put(p,mI);
            exams.put(mI, p);
            count++;
        }
    }

    public void viewLog(){
        viewPatients();
        viewExams();
    }

    /**
     * Method creates a GUI to view all patient details.
     * See User Story 1.
     */
    public void viewPatients(){

        // Create a simple window to display the output
        JFrame frame = new JFrame("Patients");
        frame.setSize(1200,600);

        // Create a display Panel with a 4 column gridlayout
        JPanel displayPanel = new JPanel();
        displayPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        GridLayout experimentLayout = new GridLayout(exams.keySet().size(),4,0,20);
        displayPanel.setLayout(experimentLayout);

        // Create a label for each patient and their medical investigation
        for(Patient p : patients.keySet()){
            for(MedicalInvestigation mI : p.getMedInvestigation())
            {
                //Adding the Patient Image
                JLabel displayLabelPatientImage = new JLabel();
                URL imageURL = null;
                try{imageURL = new URL(p.getPictureURL());}
                catch (MalformedURLException e){
                    System.out.println(e.getMessage());}
                ImageIcon thisImageIcon = new ImageIcon(imageURL);
                displayLabelPatientImage.setIcon(thisImageIcon);

                // Adding the patient details
                JLabel displayLabelPatient = new JLabel(p.displayText());

                // Adding the medical investigation image
                JLabel displayLabelMRIImage = new JLabel();
                URL imageURL2 = null;
                try{imageURL2 = new URL(mI.getScan().getImageURL());}
                catch (MalformedURLException e){
                    System.out.println(e.getMessage());}
                ImageIcon thisImageIcon2 = new ImageIcon(imageURL2);
                displayLabelMRIImage.setIcon(thisImageIcon2);

                // Adding the medical investigation (BP) results
                JLabel displayBP = new JLabel("<html>" + mI.getBp().displayText() +
                        "<br> Date: " + mI.getBp().getDate().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")) + "</html>");

                //Defining border parameters for better visibility
                displayLabelPatientImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                displayLabelPatient.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                displayLabelMRIImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                displayBP.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                //Adding labels to displayPanel
                displayPanel.add(displayLabelPatientImage);
                displayPanel.add(displayLabelPatient);
                displayPanel.add(displayLabelMRIImage);
                displayPanel.add(displayBP);
            }
        }
        frame.setContentPane(displayPanel);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {// Ends program if close window is clicked
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });


    }

    /**
     * Method prints all examinations in a user-friendly manner into the console
     * View User Story 2.
     */
    public void viewExams(){
        for(MedicalInvestigation mI : exams.keySet()){
            Patient p = mI.getPatient();
            String consoleText = "Patient " + p.getName() +
                    ": " + mI.getScan().toString() + mI.getBp().toString();
            System.out.println(consoleText);
        }
    }

    public MedicalInvestigation getMedicalInvestigation(Patient p){
        return patients.get(p);
    }

    public void getExam(Patient p){

    }

    public HashMap<Patient, MedicalInvestigation> getPatients() {
        return patients;
    }

    public void setPatients(HashMap<Patient, MedicalInvestigation> patients) {
        this.patients = patients;
    }

    public HashMap<MedicalInvestigation, Patient> getExams() {
        return exams;
    }

    public void setExams(HashMap<MedicalInvestigation, Patient> exams) {
        this.exams = exams;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Log.count = count;
    }
}
