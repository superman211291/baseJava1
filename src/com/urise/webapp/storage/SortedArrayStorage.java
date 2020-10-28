package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (checkResume1(r.getUuid())) {
            index = -getIndex(r.getUuid()) - 1;
            System.arraycopy(storage, index, storage, index + 1, size - index);
            super.save(r);
        }
    }

    @Override
    public void delete(String uuid) {
        if (!checkResume1(uuid)) {
            index = getIndex(uuid);
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            super.delete(uuid);
        }

    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
