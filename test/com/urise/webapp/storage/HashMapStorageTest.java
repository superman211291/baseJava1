package com.urise.webapp.storage;

import static org.junit.Assert.*;

public class HashMapStorageTest extends MapStorageTest {

    public HashMapStorageTest() {
        super(new HashMapStorage());
    }
}