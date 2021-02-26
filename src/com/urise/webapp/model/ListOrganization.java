package com.urise.webapp.model;

import java.util.ArrayList;

public class ListOrganization implements ContentSection {

    private ArrayList<Organization> organizations;

    public ArrayList<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(ArrayList<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return organizations.toString();
    }
}
