package com.urise.webapp.model;

import java.time.LocalDate;

public class Organization {

    private String name;

    private LocalDate workTime;

    private String position;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getWorkTime() {
        return workTime;
    }

    public void setWorkTime(LocalDate workTime) {
        this.workTime = workTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
