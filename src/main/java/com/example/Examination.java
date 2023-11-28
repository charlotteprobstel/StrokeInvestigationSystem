package com.example;

import java.time.LocalDate;

public class Examination{

    /**
     * Class is a superclass
     */

    protected LocalDate date;
    public Examination(LocalDate local) {
        this.date = local;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
