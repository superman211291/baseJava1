package com.urise.webapp.storage;

public class HashMapStorage extends MapStorage {
    @Override
    protected Integer getIndex(String fullName) {
        return fullName.hashCode();
    }

}
