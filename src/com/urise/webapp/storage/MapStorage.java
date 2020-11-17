package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> mapResumes = new HashMap<>();

    @Override
    protected int getIndex(String uuid) {
        String[] uuids = new String[size()];
        mapResumes.keySet().toArray(uuids);
        for (String uuid1 : uuids) {
            if (uuid1.equals(uuid)) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return mapResumes.get(uuid);
    }

    @Override
    protected void saveResume(int index, Resume r) {
        mapResumes.put(r.getUuid(), r);
    }

    @Override
    protected void updateResume(int index, Resume r) {
        mapResumes.replace(r.getUuid(), r);
    }

    @Override
    protected void deleteResume(int index, String uuid) {
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
