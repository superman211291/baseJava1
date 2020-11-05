package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }
    @Test
    public void getAll() throws Exception {
        Storage expected = new ArrayStorage();

        expected.save(new Resume(UUID_1));
        expected.save(new Resume(UUID_2));
        expected.save(new Resume(UUID_3));

        Resume[] resumeExpected = expected.getAll();
        Resume[] resumeActual = storage.getAll();

        Assert.assertArrayEquals(resumeExpected,resumeActual );
    }
}