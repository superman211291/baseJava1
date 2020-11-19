package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume r) {
        String uuid = r.getUuid();
        if (checkMemory(uuid)) {
            Object index = getIndex(uuid);
            if (!chekIndex(index)) {
                saveResume(index, r);
                System.out.println(uuid + " сохранен!");
            } else {
                throw new ExistStorageException(uuid);
            }
        }
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }


    private boolean checkMemory(String uuid) {
        if (size == storage.length) {
            throw new StorageException(uuid, uuid + "Нет свободной памяти!");
        }
        return true;
    }


    @Override
    protected Resume getResume(Object index, String uuid) {
        if (chekIndex(index)) {
            return storage[(Integer) index];
        }
        return null;
    }

    @Override
    protected void saveResume(Object index, Resume r) {
            Integer ind = (Integer) index;
            storage[shiftElement(ind)] = r;
            size++;

    }

    @Override
    protected void updateResume(Object index, Resume r) {
        if (chekIndex(index)) {
            storage[(Integer) index] = r;
        }
    }

    @Override
    protected void deleteResume(Object index, String uuid) {
        if (chekIndex(index)) {
            backspaceElement((Integer) index);
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected boolean chekIndex(Object index) {
        if (index != null) {
            Integer ind = (Integer) index;
            return ind >= 0;

        }
        return false;
    }

    protected abstract int shiftElement(int index);

    protected abstract void backspaceElement(int index);

}


