package com.urise.webapp.model;

import java.util.Map;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private static final String DEFAULT_FULL_NAME = "DEFAULT";

    private final String uuid;

    private final String fullName;

    private Map<ContactsType,String> contacts;

    private Map<SectionType,ContentSection> section;

    public Resume(String uuid, String fullName,
                  Map<ContactsType, String> contacts,
                  Map<SectionType, ContentSection> section) {
        this(uuid, fullName);
        this.contacts = contacts;
        this.section = section;
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public Resume(String uuid) {
        this(uuid,DEFAULT_FULL_NAME);
    }

    public String getFullName() {
        return fullName;
    }

    public String getUuid() {
        return uuid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return fullName.equals(resume.getFullName()) &&
                uuid.equals(resume.uuid)  &&
                contacts.equals(resume.contacts) &&
                section.equals(resume.section);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return fullName + "\n" +
                ContactsType.PHONE.getTitle() + " " + contacts.get(ContactsType.PHONE).toString() + "\n" +
                ContactsType.SKYPE.getTitle() + " " + contacts.get(ContactsType.SKYPE).toString() + "\n" +
                ContactsType.EMAIL.getTitle() + " " + contacts.get(ContactsType.EMAIL).toString() + "\n" +
                ContactsType.LINK.getTitle() + " " + contacts.get(ContactsType.LINK).toString() + "\n" +
                "----------------------------------------------------------------------------------" + "\n" +
                SectionType.OBJECTIVE.getTitle() + " " + section.get(SectionType.OBJECTIVE)
                ;
    }

}
