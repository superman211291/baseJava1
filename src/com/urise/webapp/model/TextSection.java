package com.urise.webapp.model;

public class TextSection implements ContentSection {

    private String textField;

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    @Override
    public String toString() {
        return textField ;
    }
}
