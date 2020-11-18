package com.urise.webapp.storage;

public class ListStorageTest extends AbstractStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }

//    @Test
//    public void getAll() {
//
//        Resume[] resumeExpected = storage.getAll();
//        Resume[] resumeActual = new Resume[]{resume1, resume2, resume3};
//        Assert.assertArrayEquals(resumeExpected, resumeActual);
//    }
}