package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Test
    public void getAll() throws Exception {
        Storage expected = new SortedArrayStorage();

        expected.save(new Resume(UUID_1));
        expected.save(new Resume(UUID_2));
        expected.save(new Resume(UUID_3));

        Assert.assertArrayEquals(expected.getAll(), storage.getAll());
    }
}