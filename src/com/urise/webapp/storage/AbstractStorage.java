package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR = new Comparator<Resume>() {
        @Override
        public int compare(Resume o1, Resume o2) {
            int ind = o1.getUuid().compareTo(o2.getUuid());
            if (ind == 0 && (o1.getFullName() != null && o2.getFullName() != null)) {
                ind = o1.getFullName().compareTo(o2.getFullName());
            }

            return ind;
        }
    };


    @Override
    public void update(Resume r) {
        Object index = getIndex(r.getUuid());
        if (checkIndex(index)) {
            updateResume(index, r);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        String uuid = r.getUuid();
        Object index = getIndex(uuid);
        if (!checkIndex(index)) {
            saveResume(index, r);
            System.out.println(uuid + " сохранен!");
        } else {
            throw new ExistStorageException(uuid);
        }

    }

    @Override
    public Resume get(String uuid) {
        Object index = getIndex(uuid);
        if (checkIndex(index)) {
            return getResume(index);
        }

        throw new NotExistStorageException(uuid);
    }

    @Override
    public void delete(String uuid) {
        Object index = getIndex(uuid);
        if (checkIndex(index)) {
            deleteResume(index);
            System.out.println(uuid + " удален!");
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumes = getAll();
        resumes.sort(RESUME_COMPARATOR);
        return resumes;
    }

    protected abstract Object getIndex(String uuid);

    protected abstract boolean checkIndex(Object index);

    protected abstract Resume getResume(Object index);

    protected abstract void saveResume(Object index, Resume r);

    protected abstract void updateResume(Object index, Resume r);

    protected abstract void deleteResume(Object index);

    protected abstract List<Resume> getAll();


}
