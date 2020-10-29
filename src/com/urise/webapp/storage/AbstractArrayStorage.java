package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 4;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;


    public void save(Resume r) {
        String uuid = r.getUuid();
        int index = getIndex(uuid);
        if (checkMemory(uuid) && index < 0) {
            storage[shiftElement(index)] = r;
            size++;
            System.out.println(r.getUuid() + " сохранен!");
        } else {
            printExist(uuid);
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            backspaceElement(index);
            storage[size - 1] = null;
            size--;
            System.out.println(uuid + " удален!");
        } else {
            printNotExist(uuid);
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
        } else {
            printNotExist(r.getUuid());
        }
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            printNotExist(uuid);
        }
        return null;

    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected boolean checkMemory(String uuid) {
        if (size == storage.length) {
            System.out.println(uuid + "Нет свободной памяти!");
            return false;
        }
        return true;
    }

    private void printNotExist(String uuid){
        System.out.println(uuid + " отсутствует в базе!");
    }
    private void printExist(String uuid){
        System.out.println(uuid + " присутствует в базе!");
    }



    protected abstract int shiftElement(int index);

    protected abstract void backspaceElement(int index);

    protected abstract int getIndex(String uuid);

}


