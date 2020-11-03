package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";


    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();


        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void save() throws Exception {
        Resume resume = storage.get(UUID_2);

        Assert.assertEquals(resume, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_2);

        storage.get(UUID_2);

    }

    @Test
    public void clear() {
        storage.clear();

        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume resume = storage.get(UUID_1);
        storage.update(storage.get(UUID_1));

        Assert.assertEquals(resume.hashCode(), storage.get(UUID_1).hashCode());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(UUID_1, storage.get(UUID_1).getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
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

        @Test
        public void getAll () throws Exception {
            Storage expected;
            if (storage instanceof SortedArrayStorage) {
                expected = new SortedArrayStorage();
            } else {
                expected = new ArrayStorage();
            }

            expected.save(new Resume(UUID_1));
            expected.save(new Resume(UUID_2));
            expected.save(new Resume(UUID_3));

            Assert.assertArrayEquals(expected.getAll(), storage.getAll());
        }
    }