package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected final Storage storage;
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final Resume resume1 = new Resume(UUID_1);
    protected static final Resume resume2 = new Resume(UUID_2);
    protected static final Resume resume3 = new Resume(UUID_3);


    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();

        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }
    @Test
    public void save() throws Exception {
        Resume resume = new Resume("dummy");

        storage.save(resume);

        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    @Test
    public void delete() {

        try {
            storage.delete(UUID_2);
        } catch (StorageException ex) {
            System.out.println(ex.getMessage());
            Assert.fail();
        }

    }

    @Test
    public void clear() {
        storage.clear();

        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_1);
        storage.update(resume);
        Assert.assertSame(resume, storage.get(resume.getUuid()));

    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(resume1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(new Resume(UUID_1));
    }



}