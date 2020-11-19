package com.urise.webapp.storage;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int shiftElement(int index) {
        return size;
    }

    @Override
    protected void backspaceElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected Object getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }


}
