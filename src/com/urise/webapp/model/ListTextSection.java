package com.urise.webapp.model;

import java.util.ArrayList;

public class ListTextSection implements ContentSection {

    private ArrayList<String> textSections = new ArrayList<>();

    public ArrayList<String> getTextSections() {
        return textSections;
    }

    public void setTextSections(ArrayList<String> textSections) {
        this.textSections = textSections;
    }
}
