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
    public void delete(String uuid) {
        super.delete(uuid);
    }

    @Override
    public Resume[] getAll() {
//        Resume[] newResume = new Resume[listResume.size()];
//        for (int i = 0; i < listResume.size(); i++) {
//            newResume[i] = listResume.get(i);
//        }
//        return newResume;
        Resume[] resumes = new Resume[listResume.size()];
        return listResume.toArray(resumes);
    }

    @Override
    public int size() {
        return listResume.size();
    }


    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < listResume.size(); i++) {
            if (uuid.equals(listResume.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume getResume(int index) {
        return listResume.get(index);
    }

    @Override
    protected void saveResume(int index, Resume r) {
        listResume.add(r);
    }

    @Override
    protected void updateResume(int index, Resume r) {
        listResume.set(index, r);
    }

    @Override
    protected void deleteResume(int index) {
        listResume.remove(index);
    }


}
