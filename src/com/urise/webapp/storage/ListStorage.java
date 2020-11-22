package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> listResume = new ArrayList<>();


    @Override
    public void clear() {
        listResume.clear();
    }

    @Override
    public List<Resume> getAll() {
        return  listResume.subList(0,size());
    }

    @Override
    public int size() {
        return listResume.size();
    }


    @Override
    protected Integer getIndex(String uuid) {
        for (int i = 0; i < listResume.size(); i++) {
            if (uuid.equals(listResume.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean checkIndex(Object index) {
        Integer ind = (Integer) index;
        return ind >= 0;
    }

    @Override
    protected Resume getResume(Object index) {
        return listResume.get((Integer) index);
    }

    @Override
    protected void saveResume(Object index, Resume r) {
        listResume.add(r);
    }

    @Override
    protected void updateResume(Object index, Resume r) {
        listResume.set((Integer) index, r);
    }

    @Override
    protected void deleteResume(Object index) {
        int ind = (Integer) index;
        listResume.remove(ind);
    }


}
