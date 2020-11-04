package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    protected final Storage storage;
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    private final Resume resume1 = new Resume(UUID_1);
    private final Resume resume2 = new Resume(UUID_2);
    private final Resume resume3 = new Resume(UUID_3);

    public AbstractArrayStorageTest(Storage storage) {
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
        storage.delete(UUID_2);
        try {
            storage.get(UUID_2);
            Assert.fail();
        } catch (NotExistStorageException ex) {
            System.out.println(ex.getMessage());
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

    @Test(expected = StorageException.class)
    public void storageOverflow() throws Exception {
        int MAX_ELEMENT = AbstractArrayStorage.STORAGE_LIMIT;
        try {
            for (int i = storage.size(); i < MAX_ELEMENT; i++) {
                storage.save(new Resume());
            }
//            storage.save(new Resume());
        } catch (StorageException ex) {
            Assert.fail("Переполнение произошло раньше!");
        }
        storage.save(new Resume());
    }

}