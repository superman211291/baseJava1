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
        Resume[] resumeExpected = storage.getAll();
        Resume[] resumeActual = new Resume[]{resume1, resume2, resume3};
        Assert.assertArrayEquals(resumeExpected, resumeActual);
    }
}