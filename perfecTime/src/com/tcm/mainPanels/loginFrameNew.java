/* 
 * loginFrameNew.java
 * Created on Oct 23, 2011, 1:41:13 AM
 */
package com.tcm.mainPanels;

import com.tcm.functionPackage.QueryTableModel;
import com.tcm.functionPackage.ConvertToDate;
import com.tcm.functionPackage.HashMD5;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Timestamp;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/*@author saad*/

public class loginFrameNew extends javax.swing.JFrame {
    //%C978099848187?
    //%C978193844177?
    //%C346114944171?

    String driverString = prop.getProperty("dbdriver");
    String jdbcUrl = prop.getProperty("dburl");
    public static Connection connection;
    public static Properties prop = new Properties();
    SwingWorker worker, ciButtonWorker, coButtonWorker, tlWorker;
    int userCountTotal = 0;
    int c, count=10;
//  int countDown;
    Timer timer;
    private String authKey, authName, authRate, authAddr;
    Timestamp timeDiffrCI;
    private JButton ciButton, coButton, dButton, stButton;
    private JScrollPane stScroll;
    private JTable stTable;
    private JTextField tipField;
    private JPanel ClockPanel, StatPanel;
    private static final long delayTimer = 1500;
    /* Creates new form loginFrameNew */

    public loginFrameNew() {
        //%C978099848187?
        //%C978193844177?
        //%C346114944171?
        //FillTable model = new FillTable();
        initComponents();
    }
    /*This method is called from within the constructor to initialize the form.*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        staticPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        loggerArea = new javax.swing.JTextArea();
        actionLogLabel = new javax.swing.JLabel();
        timeF = new javax.swing.JTextField();
        prStats = new javax.swing.JButton();
        LoginPanel = new javax.swing.JPanel();
        swipeCardLabel = new javax.swing.JLabel();
        cardField = new javax.swing.JPasswordField();
        Container container = getContentPane();
        container.add(ClockPanel = new PanelActivator(Color.white, 400, 510, 380, 40));
        container.add(StatPanel = new PanelActivator(Color.white, 348, 510, 10 , 40));
        ClockPanel.setVisible(false);
        StatPanel.setVisible(false);
        okSubmit = new javax.swing.JButton();
        clearPass = new javax.swing.JButton();
        forgotCard = new javax.swing.JButton();
        exitApp = new javax.swing.JButton();
        actionProgress = new javax.swing.JProgressBar();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("mainFrame"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        staticPanel.setBackground(java.awt.Color.white);
        staticPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.gray));
        staticPanel.setAlignmentX(1.0F);
        staticPanel.setAlignmentY(1.0F);
        staticPanel.setPreferredSize(new java.awt.Dimension(348, 500));

        loggerArea.setBackground(java.awt.Color.white);
        loggerArea.setColumns(20);
        loggerArea.setEditable(false);
        loggerArea.setFont(new java.awt.Font("TlwgTypewriter", 0, 14));
        loggerArea.setLineWrap(true);
        loggerArea.setRows(5);
        loggerArea.setWrapStyleWord(true);
        loggerArea.setBorder(new javax.swing.border.MatteBorder(null));
        loggerArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loggerArea.setDoubleBuffered(true);
        loggerArea.setDragEnabled(true);
        loggerArea.setFocusable(false);
        jScrollPane1.setViewportView(loggerArea);

        actionLogLabel.setFont(new java.awt.Font("Arial", 0, 14));
        actionLogLabel.setText("Action Log");
        actionLogLabel.setFocusable(false);

        timeF.setEditable(false);
        timeF.setFont(new java.awt.Font("Arial", 1, 48));
        timeF.setForeground(java.awt.Color.gray);
        timeF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timeF.setText("timeField");
        timeF.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        timeF.setFocusable(false);
        Timer t = new Timer(1000,new Listener());
        t.start();

        prStats.setText("Show Today's PayRoll Stats");
        prStats.setFocusPainted(false);
        prStats.setFocusable(false);
        prStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prStatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout staticPanelLayout = new javax.swing.GroupLayout(staticPanel);
        staticPanel.setLayout(staticPanelLayout);
        staticPanelLayout.setHorizontalGroup(
            staticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staticPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timeF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, staticPanelLayout.createSequentialGroup()
                        .addComponent(actionLogLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(prStats)))
                .addContainerGap())
        );
        staticPanelLayout.setVerticalGroup(
            staticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staticPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actionLogLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prStats))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(timeF, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        getContentPane().add(staticPanel);
        staticPanel.setBounds(10, 40, 348, 510);

        LoginPanel.setBackground(java.awt.Color.white);
        LoginPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.gray));
        LoginPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        swipeCardLabel.setFont(new java.awt.Font("Arial", 0, 14));
        swipeCardLabel.setText("Swipe Card");
        swipeCardLabel.setFocusable(false);

        cardField.setBackground(java.awt.Color.white);
        cardField.setFont(new java.awt.Font("Trebuchet MS", 1, 48));
        cardField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cardField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cardField.setDoubleBuffered(true);

        ciButton = new javax.swing.JButton();
        coButton = new javax.swing.JButton();
        dButton = new javax.swing.JButton();
        stButton = new javax.swing.JButton();
        tipField = new javax.swing.JTextField();
        //stTable = new javax.swing.JTable(myModel());
        stTable = new javax.swing.JTable(new QueryTableModel());
        stScroll = new javax.swing.JScrollPane(stTable);
        tipField.setFont(new java.awt.Font("Arial", 0, 88));
        tipField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        okSubmit.setText("Go");
        okSubmit.setFocusable(false);
        ciButton.setText("Clock In");
        coButton.setText("Clock Out");
        dButton.setText("Done");
        stButton.setText("Close");
        stButton.setFocusable(false);
        StatPanel.setFocusable(false);
        stTable.setFocusable(false);
        stScroll.setFocusable(false);
        dButton.setFocusable(true);
        ciButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciButtonActionPerformed(evt);
            }
        });
        coButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coButtonActionPerformed(evt);
            }
        });
        dButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dButtonActionPerformed(evt);
            }
        });
        stButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stButtonActionPerformed(evt);
            }
        });
        ClockPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.gray));
        ClockPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        javax.swing.GroupLayout ClockPanelLayout = new javax.swing.GroupLayout(ClockPanel);
        ClockPanel.setLayout(ClockPanelLayout);
        ClockPanelLayout.setHorizontalGroup(
            ClockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClockPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(ClockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dButton, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(tipField, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(coButton, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(ciButton, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
        ClockPanelLayout.setVerticalGroup(
            ClockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClockPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGap(38, 38, 38)
                .addComponent(ciButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(tipField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(coButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(dButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        // -----------------------statpanel-start---------------------------------------------
        javax.swing.GroupLayout StatPanelLayout = new javax.swing.GroupLayout(StatPanel);
        StatPanel.setLayout(StatPanelLayout);
        StatPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StatPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.gray));
        StatPanelLayout.setHorizontalGroup(
            StatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(stScroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                .addContainerGap())
        );
        StatPanelLayout.setVerticalGroup(
            StatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(stButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        // -----------------------statpanel-end-----------------------------------------------
        okSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okSubmitActionPerformed(evt);
            }
        });

        clearPass.setText("Clear");
        clearPass.setFocusable(false);
        clearPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearPassActionPerformed(evt);
            }
        });

        forgotCard.setText("Oops! I forgot my Card...");
        forgotCard.setFocusPainted(false);
        forgotCard.setFocusable(false);

        exitApp.setText("Exit");
        exitApp.setFocusable(false);
        exitApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitAppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(swipeCardLabel)
                .addContainerGap(312, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitApp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(forgotCard, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(clearPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(okSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(cardField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(swipeCardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cardField)
                .addGap(18, 18, 18)
                .addComponent(okSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(clearPass, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(forgotCard, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitApp, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        getContentPane().add(LoginPanel);
        LoginPanel.setBounds(380, 40, 400, 510);

        actionProgress.setBackground(java.awt.Color.white);
        actionProgress.setFont(new java.awt.Font("Trebuchet MS", 0, 15));
        actionProgress.setBorder(new javax.swing.border.MatteBorder(null));
        actionProgress.setDoubleBuffered(true);
        actionProgress.setFocusable(false);
        actionProgress.setString("PROGRESS");
        actionProgress.setStringPainted(true);
        getContentPane().add(actionProgress);
        actionProgress.setBounds(10, 10, 770, 25);

        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tcm/mediaDir/Dreamy_World.png"))); // NOI18N
        getContentPane().add(bgLabel);
        bgLabel.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class Listener implements ActionListener {

        @Override
        //%C978099848187?
        //%C978193844177?
        //%C346114944171?
        public void actionPerformed(ActionEvent e) {
            Calendar rightNow = Calendar.getInstance();
            int day = rightNow.get(Calendar.DAY_OF_WEEK);
            int hour = rightNow.get(Calendar.HOUR);
            int min = rightNow.get(Calendar.MINUTE);
            int ampm = rightNow.get(Calendar.AM_PM);
            if (hour == 0) {
                hour = 12;
            }
            String amPM = null, dow = null;
            if (day == 1) {
                dow = "Sun";
            } else if (day == 2) {
                dow = "Mon";
            } else if (day == 3) {
                dow = "Tue";
            } else if (day == 4) {
                dow = "Wed";
            } else if (day == 5) {
                dow = "Thu";
            } else if (day == 6) {
                dow = "Fri";
            } else if (day == 7) {
                dow = "Sat";
            }
            if (ampm == 0) {
                amPM = "AM";
            } else if (ampm == 1) {
                amPM = "PM";
            }
            //String.format("%02d", x)
            timeF.setText(dow + " " + String.format("%02d", hour) + ":" + String.format("%02d", min) + " " + amPM);
        }
    }
    //%C978099848187?
    //%C978193844177?
    //%C346114944171?

    public class PanelActivator extends JPanel {
        //public String title;

        public PanelActivator(Color color, int width, int height, int xlocation, int ylocation) {
            setSize(width, height);
            setLocation(xlocation, ylocation);
            setLayout(null);
            setBackground(color);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            
        }
    }
    //%C978099848187?
    //%C978193844177?
    //%C346114944171?

    private void ciButtonActionPerformed(java.awt.event.ActionEvent evt) {
        actionProgress.setIndeterminate(true);
        ciButton.setEnabled(false);
        dButton.setEnabled(false);
        ciButtonWorker = new SwingWorker<Void, String>() {

            Calendar calendar = Calendar.getInstance();
            Timestamp ourJavaTimestampObject = new Timestamp(calendar.getTime().getTime());
            String sqlLoginInsertStatement = "INSERT INTO timetable (start,keyid) VALUES (?,?)";
            PreparedStatement preparedStatementci = null;

            @Override
            protected Void doInBackground() throws SQLException, InterruptedException {
                preparedStatementci = (PreparedStatement) connection.prepareStatement(sqlLoginInsertStatement);
                preparedStatementci.setTimestamp(1, ourJavaTimestampObject);
                preparedStatementci.setString(2, authKey);
                if (connection.isValid(2000)) {
                    preparedStatementci.executeUpdate();
                }
                preparedStatementci.close();
                Thread.sleep(delayTimer);
                return null;
            }

            @Override
            protected void done() {
                Date dateCI = ConvertToDate.toDate(ourJavaTimestampObject);
                loggerArea.append("Clocked in\n" + dateCI + "\n");
                dButton.setEnabled(true);
                dButton.setText("Auto close in " + count);
                //Counter.start();
                TimerClass tc = new TimerClass(count);
                timer = new Timer(1000, tc);
                timer.start();
                actionProgress.setIndeterminate(false);
            }
        };
        ciButtonWorker.execute();
    }
    //%C978099848187?
    //%C978193844177?
    //%C346114944171?
    
    // time action
    // need to add timer function to default close button on clockpanel.
    // noticed that at first run, the close button in clockpanel would not fire
    // this is due to the timer.stop() function.
    // could also check for if coButton or ciButton actions have been invoked
    // if returns true then fire timer.close() else do show hide panel functions.
    public class TimerClass implements ActionListener {
        int counter;
    TimerClass(int counter) {
        this.counter = counter;
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            counter--;
            if (counter >= 1) {
               dButton.setText("Auto close in " + counter); 
            } else {
                timer.stop();
                dButton.setText("Done....");
                Toolkit.getDefaultToolkit().beep();
                ClockPanel.setVisible(false);
                LoginPanel.setVisible(true);
                loggerArea.setText(null);
                validate();
                repaint();
            }
        }
    
    }
    
    // method to take two java util date objects and return difference
    public String dateDIFF(Date tStart, Date tEnd) {
        long shiftDuration = tStart.getTime() - tEnd.getTime();
        String retDIFF = getElapsedTimeHoursMinutesSecondsString(shiftDuration);
        return retDIFF;
    }
    
    // method to return time from milliseconds util date
    // elapsed time in hours/minutes/seconds
    // @return String
    public String getElapsedTimeHoursMinutesSecondsString(long elapsedTime) {
        String format = String.format("%%0%dd", 2);
        elapsedTime = elapsedTime / 1000;
        String seconds = String.format(format, elapsedTime % 60);
        String minutes = String.format(format, (elapsedTime % 3600) / 60);
        String hours = String.format(format, elapsedTime / 3600);
        String time = hours + ":" + minutes + ":" + seconds;
        return time;
    }


    private void coButtonActionPerformed(java.awt.event.ActionEvent evt) {
        actionProgress.setIndeterminate(true);
        coButton.setEnabled(false);
        tipField.setEnabled(false);
        dButton.setEnabled(false);
        coButtonWorker = new SwingWorker<Void, String>() {

            String midVal;
            String reportedTip = tipField.getText();
            Calendar calendar = Calendar.getInstance();
            Timestamp ourJavaTimestampObject = new Timestamp(calendar.getTime().getTime());
            String sqlSelectMaxTimeId = "select timeid,start from timetable where keyid=" + authKey + " order by timeid desc limit 1";
            PreparedStatement preparedStatementmt = null;
            PreparedStatement preparedStatementco = null;

            @Override
            protected Void doInBackground() throws SQLException, InterruptedException {
                preparedStatementmt = (PreparedStatement) connection.prepareStatement(sqlSelectMaxTimeId);
                if (connection.isValid(2000)) {
                    ResultSet maxTID = preparedStatementmt.executeQuery();
                    while (maxTID.next()) {
                        midVal = maxTID.getString("timeid");
                        timeDiffrCI = maxTID.getTimestamp("start");
                    }
                    String sqlLogoutInsertStatement = "update timetable set stop='" + ourJavaTimestampObject + "' , tipMade='" + reportedTip + "' where keyid=" + authKey + " and timeid=" + midVal;
                    preparedStatementco = (PreparedStatement) connection.prepareStatement(sqlLogoutInsertStatement);
                    //preparedStatementco.setTimestamp(1, ourJavaTimestampObject);
                    if (connection.isValid(2000)) {
                        preparedStatementco.executeUpdate();
                    }
                    preparedStatementco.close();
                    Thread.sleep(delayTimer);
                }
                return null;
            }

            @Override
            protected void done() {
                Date dateCIR = ConvertToDate.toDate(timeDiffrCI);
                Date dateCO = ConvertToDate.toDate(ourJavaTimestampObject);
                loggerArea.append("Your shift summary:\n");
                loggerArea.append("Clocked In:\n" + dateCIR + "\n");
                loggerArea.append("Clocked Out:\n" + dateCO + "\n");
                loggerArea.append("Total worked: " + dateDIFF(dateCO, dateCIR) + "\n");
                loggerArea.append("---------------------------------------\n");
                tipField.selectAll();
                tipField.setText("");
                resetFocus();
                dButton.setEnabled(true);
                dButton.setText("Auto close in " + count);
                TimerClass tc = new TimerClass(count);
                timer = new Timer(1000, tc);
                timer.start();
                actionProgress.setIndeterminate(false);
            }
        };
        coButtonWorker.execute();
    }
    //%C978099848187?
    //%C978193844177?
    //%C346114944171?

    private void dButtonActionPerformed(java.awt.event.ActionEvent evt) {
        timer.stop();
        ClockPanel.setVisible(false);
        LoginPanel.setVisible(true);
        loggerArea.setText(null);
        validate();
        repaint();
    }
    private void exitAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitAppActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitAppActionPerformed

    private void clearPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearPassActionPerformed
        cardField.setText("");
        resetFocus();
    }//GEN-LAST:event_clearPassActionPerformed
    //%C978099848187?
    //%C978193844177?
    //%C346114944171?
    private void okSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okSubmitActionPerformed
        //actionProgress.setValue(0);
        //actionProgress.setMaximum(userCountTotal);
        okSubmit.setEnabled(false);
        clearPass.setEnabled(false);
        forgotCard.setEnabled(false);
        actionProgress.setIndeterminate(true);
        loggerArea.setText(null);
        dButton.setText("Close");
        loggerArea.append("Response: ");
        final String gotPassword = cardField.getText();
        worker = new SwingWorker<Void, String>() {

            private boolean pipeOK = false;

            @Override
            protected Void doInBackground() throws Exception {
                try {
                    String input = HashMD5.MD5(gotPassword);
                    if (mayIEnter(input)) {
                        pipeOK = true;
                    } else {
                        pipeOK = false;
                    }
                    Thread.sleep(delayTimer);
                } catch (InterruptedException e) {
                    //return "Interrupted";
                    loggerArea.append("I was just interrupted \n\n");
                    loggerArea.append("Here is some useful output:\n");
                    loggerArea.append(e.toString() + "\n");
                }
                return null;
            }

            @Override
            protected void done() {
                // what to do when done
                // action performed if method true
                cardField.selectAll();
                resetFocus();
                if (pipeOK == true) {
                    loggerArea.append("Login Sucessful\n");
                    loggerArea.append("Welcome back..\n");
                    loggerArea.append("Employee Name: " + authName + "\n");
                    loggerArea.append("Pay Rate: $" + authRate + "/hr\n");
                    loggerArea.append("Address:" + authAddr + "\n\n");
                    loggerArea.append("If you feel that above information is incorrect in any way then please contact your store manager.\n");
                    //%C346114944171?
                    LoginPanel.setVisible(false);
                    ClockPanel.setVisible(true);
                    try {
                        if (clockinOrClockout() == true) {
                            ciButton.setVisible(false);
                            tipField.setVisible(true);
                            coButton.setVisible(true);
                            tipField.setEnabled(true);
                            coButton.setEnabled(true);
                        } else {
                            coButton.setVisible(false);
                            tipField.setVisible(false);
                            ciButton.setVisible(true);
                            ciButton.setEnabled(true);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(loginFrameNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    validate();
                    repaint();
                } else if (pipeOK == false) {
                    loggerArea.append("Login Failure\n");
                }
                cardField.setText("");
                actionProgress.setIndeterminate(false);
                okSubmit.setEnabled(true);
                clearPass.setEnabled(true);
                forgotCard.setEnabled(true);
                loggerArea.append("---------------------------------------\n");
                authName = null;
                authRate = null;
                authAddr = null;
            }
        };
        //.execute();
        worker.execute();
    }//GEN-LAST:event_okSubmitActionPerformed

    private void prStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prStatsActionPerformed
        staticPanel.setVisible(false);
        StatPanel.setVisible(true);
        revalidate();
        repaint();
    }//GEN-LAST:event_prStatsActionPerformed
    
    private void stButtonActionPerformed(java.awt.event.ActionEvent evt) {
        staticPanel.setVisible(true);
        StatPanel.setVisible(false);
        revalidate();
        repaint();
    }
    
    /*
     * String prepTodayLogins = "select users.employeeName,timetable.start,timetable.stop from timetable,users where timetable.start < date_format(date_add(CURRENT_TIMESTAMP(), interval 1 day),'%Y%m%d000000') AND timetable.stop >= date_format(CURRENT_TIMESTAMP(),'%Y%m%d000000') and timetable.keyid=users.keyid";
                PreparedStatement preparedStatementTL = null;

                        preparedStatementTL = (PreparedStatement) connection.prepareStatement(prepTodayLogins);
                        if (connection.isValid(2000)) {
                            rsResult = preparedStatementTL.executeQuery();
                            meta = rsResult.getMetaData();
                            colCount = meta.getColumnCount();
                        }
     * 
     */
    
    
    /*Checks the passed-in array against the correct password. After this method returns, you should invoke eraseArray on the passed-in array.*/
    //%C978099848187?
    //%C978193844177?
    //%C346114944171?
    private boolean clockinOrClockout() throws SQLException {
        String sqlCountSelectStatement = "select stop from timetable where keyid=" + authKey + " order by timeid desc limit 1";
        PreparedStatement preparedStatementwo = null;
        Boolean clockOut = null;
        try {
            preparedStatementwo = connection.prepareStatement(sqlCountSelectStatement);
            if (connection.isValid(2000)) {
                ResultSet countVal = preparedStatementwo.executeQuery();
                while (countVal.next()) {
                    if (countVal.getTimestamp(1) == null) {
                        clockOut = true;
                    } else {
                        clockOut = false;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginFrameNew.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clockOut;
    }

    private boolean mayIEnter(String input) throws SQLException {
        boolean yupYup = false;
        String prepSTGetUserList = "SELECT * FROM users";
        String prepSTCountRows = "SELECT COUNT(*) FROM users";
        PreparedStatement preparedStatementCR = null;
        ResultSet grabUserCount = null, grabUserList = null;
        PreparedStatement preparedStatementGUL = null;
        try {
            preparedStatementGUL = connection.prepareStatement(prepSTGetUserList);
            preparedStatementCR = connection.prepareStatement(prepSTCountRows);
            if (connection.isValid(2000)) {
                grabUserCount = preparedStatementCR.executeQuery();
                while (grabUserCount.next()) {
                    userCountTotal = grabUserCount.getInt(1);
                }
            }
            if (connection.isValid(2000)) {
                grabUserList = preparedStatementGUL.executeQuery();
                String[] correctPasswordJ = new String[userCountTotal];
                String[] correctPasswordN = new String[userCountTotal];
                String[] correctPasswordR = new String[userCountTotal];
                String[] correctPasswordA = new String[userCountTotal];
                String[] correctPasswordK = new String[userCountTotal];
                List rowValuesjCard = new ArrayList();
                List rowValuesName = new ArrayList();
                List rowValuesRate = new ArrayList();
                List rowValuesAddr = new ArrayList();
                List rowValuesKey = new ArrayList();
                while (grabUserList.next()) {
                    rowValuesjCard.add(grabUserList.getString("jCard"));
                    rowValuesName.add(grabUserList.getString("employeeName"));
                    rowValuesRate.add(grabUserList.getString("payrate"));
                    rowValuesAddr.add(grabUserList.getString("street"));
                    rowValuesKey.add(grabUserList.getString("keyid"));
                }
                // putting this back into an array
                correctPasswordJ = (String[]) rowValuesjCard.toArray(new String[rowValuesjCard.size()]);
                correctPasswordN = (String[]) rowValuesName.toArray(new String[rowValuesName.size()]);
                correctPasswordR = (String[]) rowValuesRate.toArray(new String[rowValuesRate.size()]);
                correctPasswordA = (String[]) rowValuesAddr.toArray(new String[rowValuesAddr.size()]);
                correctPasswordK = (String[]) rowValuesKey.toArray(new String[rowValuesKey.size()]);
                for (c = 0; c < userCountTotal; c++) {
                    if (input == null ? (correctPasswordJ[c]) == null : input.equals(correctPasswordJ[c])) {
                        authKey = correctPasswordK[c];
                        authName = correctPasswordN[c];
                        authRate = correctPasswordR[c];
                        authAddr = correctPasswordA[c];
                        return true;
                    }
                }
                //Zero out the password.
                Arrays.fill(correctPasswordJ, '0');
                Arrays.fill(correctPasswordN, '0');
                Arrays.fill(correctPasswordR, '0');
                Arrays.fill(correctPasswordA, '0');
                Arrays.fill(correctPasswordK, '0');
            }
        } finally {
            preparedStatementGUL.close();
            preparedStatementCR.close();
            grabUserCount.close();
            grabUserList.close();
        }
        return yupYup;
    }
    //Must be called from the event dispatch thread.

    protected void resetFocus() {
        cardField.requestFocusInWindow();
    }
    /*@param args the command line arguments*/
    //%C978099848187?
    //%C978193844177?
    //%C346114944171?

    public void init() {
        try {
            Class.forName(driverString);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginFrameNew.class.getName()).log(Level.SEVERE, null, ex);
            loggerArea.append(ex.toString() + "\n");
        }
        try {
            connection = (Connection) DriverManager.getConnection(jdbcUrl, prop.getProperty("dbuser"), prop.getProperty("dbpass"));
        } catch (SQLException ex) {
            Logger.getLogger(loginFrameNew.class.getName()).log(Level.SEVERE, null, ex);
            loggerArea.append(ex.toString() + "\n");
        }
    }
    //%C978099848187?
    //%C978193844177?
    //%C346114944171?

    public static void main(String args[]) throws Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        String userHome = System.getProperty("user.home");
        try {
            //load a properties file
            prop.load(new FileInputStream(userHome + "/tcm-config.properties"));
        } catch (IOException ex) {
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginFrameNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginFrameNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginFrameNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginFrameNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                loginFrameNew window = new loginFrameNew();
                window.init();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setVisible(true);
                //new LoginPanelNew().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JLabel actionLogLabel;
    private javax.swing.JProgressBar actionProgress;
    private javax.swing.JLabel bgLabel;
    private javax.swing.JPasswordField cardField;
    private javax.swing.JButton clearPass;
    private javax.swing.JButton exitApp;
    private javax.swing.JButton forgotCard;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea loggerArea;
    private javax.swing.JButton okSubmit;
    private javax.swing.JButton prStats;
    private javax.swing.JPanel staticPanel;
    private javax.swing.JLabel swipeCardLabel;
    private javax.swing.JTextField timeF;
    // End of variables declaration//GEN-END:variables
}