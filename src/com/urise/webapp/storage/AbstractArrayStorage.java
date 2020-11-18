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
            int index = getIndex(uuid);
            if (index < 0) {
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
    protected Resume getResume(int index, String uuid) {
        return storage[index];
    }

    @Override
    protected void saveResume(int index, Resume r) {
        storage[shiftElement(index)] = r;
        size++;
    }

    @Override
    protected void updateResume(int index, Resume r) {
        storage[index] = r;
    }

    @Override
    protected void deleteResume(int index, String uuid) {
        backspaceElement(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract int shiftElement(int index);

    protected abstract void backspaceElement(int index);

}


