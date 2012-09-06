package com.tcm.functionPackage;

import com.tcm.mainPanels.loginFrameNew;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author saad
 */
public class QueryTableModel extends AbstractTableModel {

    Vector cache;
    int ColCount;
    String[] headers;
    public static Connection connection = loginFrameNew.connection;

    public QueryTableModel() {
        cache = new Vector();
        loadData();
    }

    @Override
    public String getColumnName(int i) {
        return headers[i];
    }

    @Override
    public int getColumnCount() {
        return ColCount;
    }

    @Override
    public int getRowCount() {
        return cache.size();

    }

    @Override
    public Object getValueAt(int row, int col) {
        return ((String[]) cache.elementAt(row))[col];
    }

    private void loadData() {
        cache = new Vector();
        try {
            String prepTodayLogins = "select users.employeeName,timetable.start,timetable.stop from timetable,users where timetable.start < date_format(date_add(CURRENT_TIMESTAMP(), interval 1 day),'%Y%m%d000000') AND timetable.stop >= date_format(CURRENT_TIMESTAMP(),'%Y%m%d000000') and timetable.keyid=users.keyid";
            PreparedStatement preparedStatementTL = null;
            preparedStatementTL = (PreparedStatement) connection.prepareStatement(prepTodayLogins);
            ResultSet rsResult = null;
            if (connection.isValid(2000)) {
                rsResult = preparedStatementTL.executeQuery();
            }
            ResultSetMetaData meta = rsResult.getMetaData();
            ColCount = meta.getColumnCount();

            headers = new String[ColCount];
            for (int h = 1; h <= ColCount; h++) {
                headers[h - 1] = meta.getColumnName(h);
            }

            while (rsResult.next()) {
                String[] record = new String[ColCount];
                for (int i = 0; i < ColCount; i++) {
                    // need to add someway to take start and stop values then substract
                    // have two methods in hand
                    // toDate from loginFrameNew
                    // 
                    record[i] = rsResult.getString(i + 1);
                }
                cache.addElement(record);
            }
            fireTableChanged(null);
        } catch (Exception e) {
            System.err.println("Database still can't be loaded");
        }

    }
}
