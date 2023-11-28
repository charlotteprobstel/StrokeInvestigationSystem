package com.example.Logs;

import com.example.Examination.MedicalInvestigation;
import com.example.Patient;

public abstract class GeneralLog {

    public abstract void viewLog();
    public abstract void viewPatients();
    public abstract void viewExams();
    public abstract void addToLog(Patient p);

}
