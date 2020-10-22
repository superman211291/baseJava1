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
        int resumeExist = chekResumeExist(resume.getUuid());
        if (resumeExist != -1) {
            storage[resumeExist] = resume;
        } else {
            printResumeNotExist();
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (chekResumeExist(r.getUuid()) != -1) {
            printResumeExist();
        } else if (chekStorageOverflow()) {
            printStorageOverflow();
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int resumeExist = chekResumeExist(uuid);
        if (resumeExist != -1) {
            return storage[resumeExist];
        } else {
            printResumeNotExist();
        }
        return null;
    }

    public void delete(String uuid) {
        int resumeExist = chekResumeExist(uuid);
        if (resumeExist != -1) {
            relocateStorage(resumeExist);
            size--;
        } else {
            printResumeNotExist();
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

//    private int chekResumeExist(Resume resume) {
//        for (int i = 0; i < size; i++) {
//            if (storage[i].getUuid().equals(resume.getUuid())) {
//                return i;
//            }
//        }
//        return -1;
//    }

    private int chekResumeExist(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    private boolean chekStorageOverflow() {
        if (size == storage.length) {
            printStorageOverflow();
            return true;
        }
        return false;
    }

    private void relocateStorage(int numElement) {
        storage[numElement] = storage[size - 1];
    }

    private void printStorageOverflow() {
        System.err.println("Отсутствует место для сохранения!");
    }

    private void printResumeExist() {
        System.err.println("Такое резюме уже есть!");
    }

    private void printResumeNotExist() {
        System.err.println("Такого резюме нет!");
    }

}
