package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapStorage extends AbstractMapStorage {

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

}
