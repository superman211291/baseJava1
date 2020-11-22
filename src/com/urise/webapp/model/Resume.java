package com.urise.webapp.model;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private static final String DEFAULT_FULL_NAME = "DEFAULT";

    private final String uuid;

    private String fullName;

    public Resume(String uuid, String fullName) {
        this(uuid);
        this.fullName = fullName;
    }

    public Resume(String uuid) {
        this.uuid = uuid;
        this.fullName = DEFAULT_FULL_NAME;
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

        return fullName.equals(resume.getFullName()) && uuid.equals(resume.uuid) ;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

}
