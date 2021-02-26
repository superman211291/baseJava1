package com.urise.webapp.model;

import java.time.LocalDate;

public class Organization {

    private String name;

    private LocalDate workTimeFrom;

    private LocalDate workTimeTo;

    private String objective;

    private String description;

    private String wTT;

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
        this.workTimeTo = to;

        if (to.isEqual(LocalDate.now()))
        wTT = "Сейчас";
        else{
            wTT = to.toString();
        }

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

    public void setDescription(String description) {
        this.description = description;

    }

    @Override
    public String toString() {

        String descr = description;
        if (description == null){
            descr = "";
        }


        return  name + '\n' +
                workTimeFrom.toString() + " - " + wTT + "   " + objective + '\n' +
                descr + '\n';
    }
}
