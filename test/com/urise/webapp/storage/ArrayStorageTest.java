package com.urise.webapp.storage;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

//    @Test
//    public void getAll() throws Exception {
//        Resume[] resumeExpected = storage.getAll();
//        Resume[] resumeActual = new Resume[]{resume1, resume2, resume3};
//        Assert.assertArrayEquals(resumeExpected, resumeActual);
//    }
}