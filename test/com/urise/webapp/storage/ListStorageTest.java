package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public class ListStorageTest extends AbstractStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Test
    public void getAll() {

        Resume[] resumeExpected = storage.getAll();
        Resume[] resumeActual = new Resume[]{resume1, resume2, resume3};
        Assert.assertArrayEquals(resumeExpected, resumeActual);
    }
}