package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public List<Resume> getAll() {
        return Arrays.asList(storage);
    }


    private boolean checkMemory(String uuid) {
        if (size == storage.length) {
            throw new StorageException(uuid, uuid + "Нет свободной памяти!");
        }
        return true;
    }


    @Override
    protected Resume getResume(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected void saveResume(Object index, Resume r) {
        String uuid = r.getUuid();
        if (checkMemory(uuid)) {
            Integer ind = (Integer) index;
            storage[shiftElement(ind)] = r;
            size++;
        }


    }

    @Override
    protected void updateResume(Object index, Resume r) {
        storage[(Integer) index] = r;

    }

    @Override
    protected void deleteResume(Object index) {
        backspaceElement((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected boolean checkIndex(Object index) {
        if (index != null) {
            Integer ind = (Integer) index;
            return ind >= 0;

        }
        return false;
    }

    protected abstract int shiftElement(int index);

    protected abstract void backspaceElement(int index);

}


