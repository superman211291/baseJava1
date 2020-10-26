package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {

    }

    @Override
    public void update(Resume r) {
        if (size > 0) {

        } else {
            System.out.println("Отсутствуют элементы в базе!");
        }
    }

    @Override
    public void save(Resume r) {
        if (size > 0) {
            int index = Arrays.binarySearch(storage, 0, size, r);
            int num;
            if (index < 0) {
                if (size < storage.length) {
                    num = -index - 1;
                    System.arraycopy(storage, num, storage, num + 1, size - num);
                    storage[num] = r;
                    size++;
                } else {
                    System.out.println(r.getUuid() + "Нет свободной памяти!");
                }
            } else {
                System.out.println(r.getUuid() +" Данный элемент присутсвует в базе!");
            }
        } else {
            storage[0] = r;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = Arrays.binarySearch(storage, 0, size, new Resume().setUuid(uuid));
        if (index >= 0) {
            if (size - 1 - index >= 0) {
                System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            }
            Arrays.fill(storage, size-1, size, null);
            size--;
        } else {
            System.out.println(uuid + " Отсутствует в базе!");
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
