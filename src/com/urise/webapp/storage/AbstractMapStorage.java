package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapStorage extends AbstractStorage {

    protected final Map<Object, Resume> mapResumes = new HashMap<>();

    @Override
    public int size() {
        return mapResumes.size();
    }

    @Override
    public List<Resume> getAll() {
        return Arrays.asList(mapResumes.values().toArray(new Resume[0]).clone());
    }

    @Override
    public void clear() {
        mapResumes.clear();
    }

}
