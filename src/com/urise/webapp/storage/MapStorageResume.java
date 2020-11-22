package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapStorageResume extends MapStorage {

    @Override
    protected Object getIndex(String uuid) {
        return mapResumes.get(uuid);
    }

    @Override
    protected boolean checkIndex(Object index) {
        Resume r = (Resume)index;
        return mapResumes.containsValue(r);
    }

    @Override
    protected Resume getResume(Object index) {
        Resume r = (Resume)index;
        return mapResumes.get(r.getUuid());
    }

    @Override
    protected void saveResume(Object index, Resume r) {
        mapResumes.put(r.getUuid(),r);
    }

    @Override
    protected void updateResume(Object index, Resume r) {
        Resume r1 = (Resume)index;
        mapResumes.replace(r1.getUuid(),r);
    }

    @Override
    protected void deleteResume(Object index) {
        Resume r1 = (Resume)index;
        mapResumes.remove(r1.getUuid());
    }
}
