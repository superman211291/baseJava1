package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> mapResumes = new HashMap<>();

    @Override
    protected String getIndex(String uuid) {
        return uuid;
    }

    @Override
    protected boolean checkIndex(Object index) {
        return mapResumes.containsKey(index);
    }

    @Override
    protected Resume getResume(Object index) {
        return mapResumes.get(index.toString());
    }

    @Override
    protected void saveResume(Object index, Resume r) {
        mapResumes.put(r.getUuid(), r);
    }

    @Override
    protected void updateResume(Object index, Resume r) {
        mapResumes.replace(r.getUuid(), r);
    }

    @Override
    protected void deleteResume(Object index, String uuid) {
        mapResumes.remove(uuid);
    }

    @Override
    public void clear() {
        mapResumes.clear();
    }

    @Override
    public List<Resume> getAll() {
        return Arrays.asList(mapResumes.values().toArray(new Resume[0]).clone());
    }

    @Override
    public int size() {
        return mapResumes.size();
    }
}
