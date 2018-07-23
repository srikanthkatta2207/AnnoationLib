package com.srik.lib.utils;

import org.junit.Test;
import static com.srik.lib.utils.Util.isEmpty;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class UtilTest {

    @Test
    public void shouldReturnTrueForEmptyObjects() {

        Object[] object = null;

        assertFalse(isEmpty(object));
    }

    @Test
    public void shouldNotReturnTrueForNonEmptyObjects() {

        Object[] object = {"test1"};

        assertFalse(isEmpty(object));
    }

    @Test
    public void shouldReturnTrueForNullObjects() {

        Object object = null;

        assertTrue(isEmpty(object));
    }

}