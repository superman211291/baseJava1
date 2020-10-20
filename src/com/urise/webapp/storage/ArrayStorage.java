package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        size = 0;
    }

    public void save(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                System.out.println("Такое резюме уже есть!");
                return;
            }
        }

        storage[size] = r;
        size++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                for (int j = i; j < size; j++) {
                    storage[j] = storage[j + 1];
                }
                size--;
                return;
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
 /*       com.urise.webapp.model.Resume[] resume = new com.urise.webapp.model.Resume[count_resume];
        for (int i = 0; i < resume.length ; i++) {
            resume[i]=storage[i];
        }
        return resume;*/
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
