package com.urise.webapp.model;

public enum ContactsType {

    PHONE("Телефон"),
    EMAIL("Почта"),
    SKYPE("Скайп"),
    LINK();

    private String title;



    ContactsType(String title){
        this.title = title;
    }

    ContactsType(){
    }

    public String getTitle() {
        return title;
    }
}
