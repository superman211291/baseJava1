package com.urise.webapp.model;

public enum ContactsType {

    PHONE("Телефон"),
    EMAIL("Почта"),
    SKYPE("Скайп"),
    LINK("Ссылки");

    private String title;

    ContactsType(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
