package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> mapResumes = new HashMap<>();

    @Override
    protected Object getIndex(String uuid) {
        String[] uuids = new String[size()];
        mapResumes.keySet().toArray(uuids);
        for (String uuid1 : uuids) {
            if (uuid1.equals(uuid)) {
                return uuid;
            }
        }
        return null;
    }

    @Override
    protected boolean chekIndex(Object index) {
        return index!=null;
    }

    @Override
    protected Resume getResume(Object index, String uuid) {
        return mapResumes.get(uuid);
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
    public Resume[] getAll() {
        return mapResumes.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return mapResumes.size();
    }
}
