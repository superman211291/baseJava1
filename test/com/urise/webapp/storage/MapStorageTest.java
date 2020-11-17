package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class MapStorageTest extends AbstractStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Test
    public void getAll() {
        HashSet<Resume> resumeExpected = new HashSet<>(Arrays.asList(storage.getAll()));
        HashSet<Resume> resumeActual = new HashSet<>(Arrays.asList(resume1,  resume2, resume3));
        Assert.assertEquals(3,storage.size());
        Assert.assertEquals( resumeExpected,resumeActual);
//        if(!resumeExpected.retainAll(resumeActual)){
//            Assert.fail();
//        }
//        int countEquals = 0;
//        for (Resume resume : resumeExpected) {
//            for (Resume value : resumeActual) {
//                if (resume.equals(value)) {
//                    countEquals++;
//                    return;
//                }
//            }
//
//        }
//        Assert.assertEquals(resumeActual.length,countEquals);
    }
}