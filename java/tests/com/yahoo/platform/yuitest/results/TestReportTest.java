/*
 * YUI Test
 * Author: Nicholas C. Zakas <nzakas@yahoo-inc.com>
 * Copyright (c) 2009, Yahoo! Inc. All rights reserved.
 * Code licensed under the BSD License:
 *     http://developer.yahoo.net/yui/license.txt
 */

package com.yahoo.platform.yuitest.results;

import java.io.File;
import java.io.InputStreamReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.InputSource;

/**
 *
 * @author nzakas
 */
public class TestReportTest {

    public TestReportTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private void checkReport(TestReport report){
        //duration="729" passed="48" failed="0" ignored="0" total="48
        assertEquals("All Mock Tests", report.getName());
        assertEquals(729, report.getDuration());
        assertEquals(48, report.getPassed());
        assertEquals(0, report.getFailed());
        assertEquals(0, report.getIgnored());

        assertEquals(1, report.getTestSuites().length);
        assertEquals(3, report.getTestSuites()[0].getTestCases().length);

        assertEquals("Arguments Tests", report.getTestSuites()[0].getTestCases()[1].getName());
    }

    /**
     * Test of load method, of class TestReport.
     */
    @Test
    public void testLoad_InputStream() throws Exception {
        TestReport report = TestReport.load(TestReportTest.class.getResourceAsStream("results.xml"));
        checkReport(report);
    }

    /**
     * Test of load method, of class TestReport.
     */
    @Test
    public void testLoad_Reader() throws Exception {
        TestReport report = TestReport.load(new InputStreamReader(TestReportTest.class.getResourceAsStream("results.xml")));
        checkReport(report);

    }

    /**
     * Test of load method, of class TestReport.
     */
    @Test
    public void testLoad_InputSource() throws Exception {
        TestReport report = TestReport.load(new InputSource(TestReportTest.class.getResource("results.xml").getFile()));
        checkReport(report);

    }

}