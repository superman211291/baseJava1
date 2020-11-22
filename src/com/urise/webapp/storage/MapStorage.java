package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    protected final Map<Object, Resume> mapResumes = new HashMap<>();


    @Override
    protected Object getIndex(String uuid) {
        return uuid;
    }

    @Override
    protected boolean checkIndex(Object index) {
        return mapResumes.containsKey(index);
    }

    @Override
    protected Resume getResume(Object index) {
        return mapResumes.get(index);
    }

    @Override
    protected void saveResume(Object index, Resume r) {
        mapResumes.put(index, r);
    }

    @Override
    protected void updateResume(Object index, Resume r) {
        mapResumes.replace(index, r);
    }

    @Override
    protected void deleteResume(Object index) {
        mapResumes.remove(index);
    }

    @Override
    public void clear() {
        mapResumes.clear();
    }


    public List<Resume> getAll() {
        return Arrays.asList(mapResumes.values().toArray(new Resume[0]).clone());
    }

    @Override
    public int size() {
        return mapResumes.size();
    }
}
