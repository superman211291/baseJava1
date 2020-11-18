package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {


    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            updateResume(index, r);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        String uuid = r.getUuid();
            int index = getIndex(uuid);
            if (index < 0) {
                saveResume(index, r);
                System.out.println(uuid + " сохранен!");
            } else {
                throw new ExistStorageException(uuid);
            }

    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return getResume(index,uuid);
        }

        throw new NotExistStorageException(uuid);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            deleteResume(index,uuid);
            System.out.println(uuid + " удален!");
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract int getIndex(String uuid);

    protected abstract Resume getResume(int index,String uuid);

    protected abstract void saveResume(int index, Resume r);

    protected abstract void updateResume(int index, Resume r);

    protected abstract void deleteResume(int index, String uuid);


}
