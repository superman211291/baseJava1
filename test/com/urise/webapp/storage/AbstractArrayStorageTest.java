package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
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