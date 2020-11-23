package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public abstract class AbstractMapStorage extends AbstractStorage {

    protected final Map<Object, Resume> mapResumes = new HashMap<>();

    @Override
    public int size() {
        return mapResumes.size();
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<>(mapResumes.values());
    }

    @Override
    public void clear() {
        mapResumes.clear();
    }

}
