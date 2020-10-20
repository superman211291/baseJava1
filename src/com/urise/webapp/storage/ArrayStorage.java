package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void update(Resume resume) {
        int resumeExist = chekResumeExist(resume);
        if (resumeExist != -1) {
            storage[resumeExist] = resume;
        }
    }

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {
        if (chekResumeExist(r) == -1 || !chekStorageOverflow()) {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int resumeExist = chekResumeExist(uuid);
        if (resumeExist != -1) {
            return storage[resumeExist];
        }
        return null;
    }

    public void delete(String uuid) {
        int resumeExist = chekResumeExist(uuid);
        if (resumeExist != -1) {
            relocateStorage(resumeExist);
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int chekResumeExist(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                System.err.println("Такое резюме уже есть!");
                return i;
            }
        }
        System.err.println("Такое резюме отсутствует!");
        return -1;
    }

    private int chekResumeExist(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                System.err.println("Такое резюме уже есть!");
                return i;
            }
        }
        System.err.println("Такое резюме отсутствует!");
        return -1;
    }

    private boolean chekStorageOverflow() {
        if (size == storage.length) {
            System.err.println("Отсутствует место для сохранения!");
            return true;
        }
        return false;
    }

    private void relocateStorage(int numElement) {
        for (int j = numElement; j < size; j++) {
            storage[j] = storage[j + 1];
        }
    }
}
