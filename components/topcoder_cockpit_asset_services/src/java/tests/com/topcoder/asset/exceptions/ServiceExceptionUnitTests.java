/*
 * Copyright (C) 2013 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.asset.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

/**
 * <p>
 * Unit tests for {@link ServiceException} class.
 * </p>
 *
 * @author sparemax
 * @version 1.0
 */
public class ServiceExceptionUnitTests {
    /**
     * <p>
     * Represents a detail message.
     * </p>
     */
    private static final String DETAIL_MESSAGE = "detail";

    /**
     * <p>
     * Represents an error cause.
     * </p>
     */
    private static final Throwable CAUSE = new Exception("UnitTests");

    /**
     * <p>
     * Adapter for earlier versions of JUnit.
     * </p>
     *
     * @return a test suite.
     */
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(ServiceExceptionUnitTests.class);
    }

    /**
     * <p>
     * <code>ServiceException</code> should be subclass of <code>AssetException</code>.
     * </p>
     */
    @Test
    public void testInheritance() {
        assertTrue("ServiceException should be subclass of AssetException.",
            ServiceException.class.getSuperclass() == AssetException.class);
    }

    /**
     * <p>
     * Tests accuracy of <code>ServiceException(String)</code> constructor.<br>
     * Instance should be correctly created.
     * </p>
     */
    @Test
    public void testCtor1() {
        ServiceException exception = new ServiceException(DETAIL_MESSAGE);

        // Verify the detail error message
        assertEquals("Detailed error message should be correct.", DETAIL_MESSAGE, exception.getMessage());
        // Verify the error cause
        assertNull("Error cause should be null.", exception.getCause());
    }

    /**
     * <p>
     * Tests accuracy of <code>ServiceException(String, Throwable)</code>
     * constructor.<br>
     * Instance should be correctly created.
     * </p>
     */
    @Test
    public void testCtor2() {
        ServiceException exception = new ServiceException(DETAIL_MESSAGE, CAUSE);

        // Verify the detail error message
        assertEquals("Detailed error message should be correct.", DETAIL_MESSAGE, exception.getMessage());
        // Verify the error cause
        assertSame("Error cause should be correct.", CAUSE, exception.getCause());
    }
}
