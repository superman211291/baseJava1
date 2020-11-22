package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class HashMapStorage extends MapStorage {
    @Override
    protected String getIndex(Resume r) {
        return r.getClass().toString();
    }

}
