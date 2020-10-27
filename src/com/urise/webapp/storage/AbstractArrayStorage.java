package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = checkResume(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
        }
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = checkResume(uuid);
        if (index < 0) {
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int checkResume(String uuid) {
        if (size > 0) {
            int index = getIndex(uuid);
            if (index < 0) {
                if (size < storage.length) {
                    System.out.println(uuid + " Отсутствует в базе!");
                    return -index - 1;
                } else {
                    System.out.println(uuid + "Нет свободной памяти!");
                    return index;
                }
            } else {
                System.out.println(uuid + " Данный элемент присутсвует в базе!");
                return index;
            }
        }
        return 0;
    }

    protected abstract int getIndex(String uuid);

}

