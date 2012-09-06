package com.tcm.functionPackage;

import java.util.Date;

/**
 *
 * @author saad
 */
// class to take a timestamp as input and return java utility date object.
public class ConvertToDate {
    public static Date toDate(java.sql.Timestamp timestamp) {
        long milliseconds = timestamp.getTime() + (timestamp.getNanos() / 1000000);
        return new Date(milliseconds);
    }
}