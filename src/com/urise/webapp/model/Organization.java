package com.urise.webapp.model;

import java.time.LocalDate;

public class Organization {

    private String name;

    private LocalDate workTimeFrom;

    private LocalDate workTimeTo;

    private String objective;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getWorkTimeFrom() {
        return workTimeFrom;
    }

    public LocalDate getWorkTimeTo() {
        return workTimeTo;
    }

    public void setWorkTime(LocalDate from, LocalDate to) {

        this.workTimeFrom = from;

        if (to.isEqual(LocalDate.now()))
        this.workTimeTo = null;

    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {this.description = description; }

    @Override
    public String toString() {
        String wTT;
        if (workTimeTo == null){
            wTT = "Сейчас";
        } else{
            wTT = workTimeFrom.toString();
        }
        return  name + '\n' +
                workTimeFrom.toString() + "-" + ", workTimeTo=" + wTT + "   " + objective + '\n' +
                description + '\n';
    }
}
