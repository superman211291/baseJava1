package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 4;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;


    public void save(Resume r) {
        if (checkResume1(r.getUuid())) {
            int index = -getIndex(r.getUuid()) - 1;
            shiftElement(index);
            storage[index] = r;
            size++;
            System.out.println(r.getUuid() + " сохранен!");
        }
    }

    public void delete(String uuid) {
        if (!checkNotExist(uuid)) {
            int index = getIndex(uuid);
            backspaceElement(index);
            storage[size - 1] = null;
            size--;
            System.out.println(uuid + " удален!");
        }

    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        if (!checkNotExist(r.getUuid())) {
            storage[getIndex(r.getUuid())] = r;
        }
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            return  null;
        }
        return storage[index];

    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected boolean checkResume1(String uuid) {
        return checkNotExist(uuid) && checkMemory(uuid);
    }

    protected boolean checkNotExist(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            System.out.println(uuid + " Данный элемент присутсвует в базе!");
            return false;
        }
        System.out.println(uuid + " Отсутствует в базе!");
        return true;
    }

    protected boolean checkMemory(String uuid) {
        if (size == storage.length) {
            System.out.println(uuid + "Нет свободной памяти!");
            return false;
        }
        return true;
    }

    protected abstract void shiftElement(int index);

    protected abstract void backspaceElement(int index);

    protected abstract int getIndex(String uuid);

}


