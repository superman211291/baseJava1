package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (checkResume1(r.getUuid())) {
            int index = -getIndex(r.getUuid()) - 1;
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = r;
            size++;
            System.out.println(r.getUuid() + " сохранен!");
        }
    }

    @Override
    public void delete(String uuid) {
        if (!checkResume1(uuid)) {
            int index = getIndex(uuid);
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            size--;
            System.out.println(uuid + " удален!");
        }

    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
