package com.urise.webapp.model;

import java.util.ArrayList;

public class ListTextSection implements ContentSection {

    private ArrayList<String> textSections = new ArrayList<>();

    public ArrayList<String> getTextSections() {
        return textSections;
    }

    public void setTextSections(ArrayList<String> textSections) {
        for (int i = 0; i < textSections.size(); i++) {
            textSections.set(i, "- " + textSections.get(i) + "\n");
        }
        this.textSections = textSections;
    }

    @Override
    public String toString() {

        return textSections.toString();
    }
}
