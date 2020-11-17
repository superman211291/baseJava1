package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public class MapStorageTest extends AbstractStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Test
    public void getAll() {
        Resume[] resumeExpected = storage.getAll();
        Resume[] resumeActual = new Resume[]{resume1, resume2, resume3};
        Assert.assertEquals(3,storage.size());
        int countEquals = 0;
        for (Resume resume : resumeExpected) {
            for (Resume value : resumeActual) {
                if (resume.equals(value)) {
                    countEquals++;
                    return;
                }
            }

        }
        Assert.assertEquals(resumeActual.length,countEquals);
    }
}