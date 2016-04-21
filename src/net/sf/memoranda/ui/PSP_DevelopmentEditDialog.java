package net.sf.memoranda.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.math.NumberUtils;

import net.sf.memoranda.psp.DevRowObject;
import net.sf.memoranda.util.Configuration;
import net.sf.memoranda.util.Util;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class PSP_DevelopmentEditDialog extends JFrame implements Serializable {

 private static final long serialVersionUID = -4064987826608820142L;
 private static JPanel contentPane;
 private static JTextField editTaskTextField;
 private static JTextField editDescriptionTextField;
 private static JTextField editStartDateTextField;
 private static JTextField editEstDateTextField;
 private static JTextField editEstTimeTextField;
 private static JComboBox < String > jcbStatus;

 private DevRowObject myDevRow;
 private static JComboBox < String > jcbPriority;
 private static JComboBox < String > jcbPercent;

 public PSP_DevelopmentEditDialog() {
  this(new DevRowObject());
 }

 public PSP_DevelopmentEditDialog(DevRowObject myDevRow) {
  this.myDevRow = myDevRow;
  jbInit();
 }

 private void jbInit() {
  setLook();
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  setBounds(100, 100, 605, 468);
  contentPane = new JPanel();
  contentPane.setBackground(Color.WHITE);
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);

  JLabel lblCreateNewTask = new JLabel("EDIT TASK");
  lblCreateNewTask.setToolTipText("Edit task");
  lblCreateNewTask.setFont(new Font("Tahoma", Font.BOLD, 15));

  JLabel lblTaskName = new JLabel("Edit task:");
  lblTaskName.setToolTipText("Edit task");
  lblTaskName.setHorizontalAlignment(SwingConstants.RIGHT);

  JLabel lblTaskDescription = new JLabel("Edit Description:");
  lblTaskDescription.setToolTipText("Edit description");
  lblTaskDescription.setHorizontalAlignment(SwingConstants.RIGHT);

  JLabel lblStartDate = new JLabel("Start Date:");
  lblStartDate.setToolTipText("Start date in mm/dd/yy format");
  lblStartDate.setHorizontalAlignment(SwingConstants.RIGHT);

  JLabel lblEstimatedTime = new JLabel("Estimated Time:");
  lblEstimatedTime.setToolTipText("Estimated time");
  lblEstimatedTime.setHorizontalAlignment(SwingConstants.RIGHT);

  JLabel lblPriority = new JLabel("Edit Priority:");
  lblPriority.setToolTipText("Edit priority");
  lblPriority.setHorizontalAlignment(SwingConstants.RIGHT);

  JLabel lblEditStatus = new JLabel("Edit Status:");
  lblEditStatus.setToolTipText("Edit status");
  lblEditStatus.setHorizontalAlignment(SwingConstants.RIGHT);

  // eidt dialog populates value from existing row
  editTaskTextField = new JTextField();
  editTaskTextField.setToolTipText("Task to be edited");
  editTaskTextField.setText(this.myDevRow.getTaskName());
  editTaskTextField.setColumns(10);

  editDescriptionTextField = new JTextField();
  editDescriptionTextField.setToolTipText("Description to be edited");
  editDescriptionTextField.setText(this.myDevRow.getDescription());
  editDescriptionTextField.setColumns(10);

  editStartDateTextField = new JTextField();
  editStartDateTextField.setToolTipText("Enter start date in mm/dd/yy format");
  editStartDateTextField.setText(myDevRow.getStartDate() != null ? getDateTime(myDevRow.getStartDate(), 0) : "");
  editStartDateTextField.setColumns(10);

  JLabel lblEndDate_1 = new JLabel("Est End date:");
  lblEndDate_1.setToolTipText("Estimated end date (mm/dd/yy format)");
  lblEndDate_1.setHorizontalAlignment(SwingConstants.RIGHT);

  editEstDateTextField = new JTextField();
  editEstDateTextField.setToolTipText("Enter estimated end date in mm/dd/yy format");
  editEstDateTextField.setText(myDevRow.getEstDate() != null ? getDateTime(myDevRow.getEstDate(), 0) : "");
  editEstDateTextField.setColumns(10);

  editEstTimeTextField = new JTextField();
  editEstTimeTextField.setToolTipText("Enter how long you think it will take to finish");
  editEstTimeTextField.setText(this.myDevRow.getEstimate() + "");
  editEstTimeTextField.setColumns(10);

  JLabel lblEditComplete = new JLabel("% Complete:");
  lblEditComplete.setToolTipText("Percentage task completed");
  lblEditComplete.setHorizontalAlignment(SwingConstants.RIGHT);

  JButton btnOk = new JButton("OK");
  btnOk.setToolTipText("Press OK to edit the task");
  btnOk.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
    createEditDevRow();
   }
  });

  JButton btnCancel = new JButton("Cancel");
  btnCancel.setToolTipText("Press Cancel to exit");
  btnCancel.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    dispose();
   }
  });

  jcbStatus = new JComboBox < String > ();
  jcbStatus.setToolTipText("Choose status from dropdown");
  jcbStatus.setBackground(Color.WHITE);
  jcbStatus.addItem("OPEN");
  jcbStatus.addItem("COMPLETE");
  jcbStatus.setSelectedIndex(getComboIndex(myDevRow.getStatus(), jcbStatus));

  jcbPriority = new JComboBox < String > ();
  jcbPriority.setToolTipText("Choose priority level from dropdown");
  jcbPriority.setBackground(Color.WHITE);
  jcbPriority.addItem("LOW");
  jcbPriority.addItem("MEDIUM");
  jcbPriority.addItem("HIGH");
  jcbPriority.setSelectedIndex(myDevRow.getPriority());

  jcbPercent = new JComboBox < String > ();
  jcbPercent.setToolTipText("Choose percentage from dropdown");
  jcbPercent.addItem("25.0");
  jcbPercent.addItem("50.0");
  jcbPercent.addItem("75.0");
  jcbPercent.addItem("100.0");
  jcbPercent.setSelectedIndex(getComboIndex(myDevRow.getPercentComplete() + "", jcbPercent));

  jcbPercent.setBackground(Color.WHITE);

  GroupLayout gl_contentPane = new GroupLayout(contentPane);
  gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
   .addGroup(gl_contentPane.createSequentialGroup().addGap(25).addGroup(gl_contentPane
     .createParallelGroup(Alignment.LEADING)
     .addGroup(gl_contentPane.createSequentialGroup()
      .addComponent(lblTaskName, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
      .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(editTaskTextField,
       GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
     .addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
       .createParallelGroup(Alignment.LEADING).addComponent(lblTaskDescription,
        GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
       .addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
       .addComponent(lblEditComplete, GroupLayout.PREFERRED_SIZE, 120,
        GroupLayout.PREFERRED_SIZE))
      .addGap(18)
      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
       .addComponent(editDescriptionTextField, GroupLayout.DEFAULT_SIZE, 366,
        Short.MAX_VALUE)
       .addGroup(gl_contentPane.createSequentialGroup()
        .addGroup(gl_contentPane
         .createParallelGroup(Alignment.LEADING).addGroup(
          gl_contentPane.createSequentialGroup()
          .addComponent(editStartDateTextField,
           GroupLayout.PREFERRED_SIZE, 85,
           GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED,
           GroupLayout.DEFAULT_SIZE,
           Short.MAX_VALUE))
         .addGroup(gl_contentPane.createSequentialGroup()
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPane
           .createParallelGroup(Alignment.LEADING)
           .addComponent(jcbPercent,
            GroupLayout.PREFERRED_SIZE, 85,
            GroupLayout.PREFERRED_SIZE)
           .addComponent(editEstTimeTextField,
            GroupLayout.PREFERRED_SIZE, 85,
            GroupLayout.PREFERRED_SIZE)
           .addComponent(btnOk, GroupLayout.PREFERRED_SIZE,
            85, GroupLayout.PREFERRED_SIZE))
          .addGap(45)))
        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
         .addGroup(gl_contentPane.createSequentialGroup().addGap(44)
          .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 85,
           GroupLayout.PREFERRED_SIZE))
         .addGroup(gl_contentPane.createSequentialGroup()
          .addGroup(gl_contentPane
           .createParallelGroup(Alignment.TRAILING)
           .addGroup(gl_contentPane.createSequentialGroup()
            .addPreferredGap(
             ComponentPlacement.RELATED)
            .addComponent(lblEditStatus,
             GroupLayout.PREFERRED_SIZE, 120,
             GroupLayout.PREFERRED_SIZE))
           .addGroup(gl_contentPane
            .createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_contentPane
             .createSequentialGroup()
             .addPreferredGap(
              ComponentPlacement.RELATED)
             .addComponent(lblPriority,
              GroupLayout.DEFAULT_SIZE,
              120, Short.MAX_VALUE))
            .addGroup(Alignment.LEADING,
             gl_contentPane
             .createSequentialGroup()
             .addGap(12)
             .addComponent(
              lblEndDate_1,
              GroupLayout.PREFERRED_SIZE,
              120,
              GroupLayout.PREFERRED_SIZE))))
          .addGap(18)
          .addGroup(gl_contentPane
           .createParallelGroup(Alignment.LEADING, false)
           .addComponent(jcbStatus,
            GroupLayout.PREFERRED_SIZE, 88,
            GroupLayout.PREFERRED_SIZE)
           .addGroup(gl_contentPane.createSequentialGroup()
            .addComponent(editEstDateTextField,
             GroupLayout.PREFERRED_SIZE, 85,
             GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(
             ComponentPlacement.RELATED,
             GroupLayout.DEFAULT_SIZE,
             Short.MAX_VALUE))
           .addComponent(jcbPriority,
            GroupLayout.PREFERRED_SIZE, 88,
            GroupLayout.PREFERRED_SIZE)))))))
     .addComponent(lblEstimatedTime, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
    .addGap(153))
   .addGroup(gl_contentPane.createSequentialGroup().addGap(237).addComponent(lblCreateNewTask)
    .addContainerGap(359, Short.MAX_VALUE)));
  gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
   .createSequentialGroup().addContainerGap().addComponent(lblCreateNewTask).addGap(27)
   .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    .addComponent(lblTaskName, GroupLayout.PREFERRED_SIZE, 25,
     GroupLayout.PREFERRED_SIZE)
    .addComponent(editTaskTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
   .addPreferredGap(ComponentPlacement.UNRELATED)
   .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
     .createSequentialGroup()
     .addComponent(lblTaskDescription, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
     .addGap(91)
     .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
      .addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
      .addComponent(editEstDateTextField, GroupLayout.PREFERRED_SIZE, 25,
       GroupLayout.PREFERRED_SIZE)
      .addComponent(lblEndDate_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
      .addComponent(editStartDateTextField, GroupLayout.PREFERRED_SIZE, 25,
       GroupLayout.PREFERRED_SIZE)))
    .addComponent(editDescriptionTextField, GroupLayout.PREFERRED_SIZE, 75,
     GroupLayout.PREFERRED_SIZE))
   .addGap(34)
   .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
     .addComponent(lblEstimatedTime, GroupLayout.PREFERRED_SIZE, 25,
      GroupLayout.PREFERRED_SIZE)
     .addComponent(editEstTimeTextField, GroupLayout.PREFERRED_SIZE, 25,
      GroupLayout.PREFERRED_SIZE))
    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
     .addComponent(jcbPriority, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
     .addComponent(lblPriority, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
   .addGap(27)
   .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
     .addComponent(lblEditComplete, GroupLayout.PREFERRED_SIZE, 25,
      GroupLayout.PREFERRED_SIZE)
     .addComponent(jcbPercent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
    .addGroup(
     gl_contentPane.createParallelGroup(Alignment.BASELINE)
     .addComponent(jcbStatus, GroupLayout.PREFERRED_SIZE, 25,
      GroupLayout.PREFERRED_SIZE)
     .addComponent(lblEditStatus, GroupLayout.PREFERRED_SIZE, 25,
      GroupLayout.PREFERRED_SIZE)))
   .addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE).addGroup(gl_contentPane
    .createParallelGroup(Alignment.BASELINE).addComponent(btnCancel).addComponent(btnOk))
   .addGap(26)));
  contentPane.setLayout(gl_contentPane);
 }

 protected static int getComboIndex(String strItem, JComboBox < String > jcbCombo) {
  int indexAt = -1;

  if (!strItem.equals(null)) {
   for (int i = 0; i < jcbCombo.getItemCount(); i++) {
    if (strItem.equalsIgnoreCase(jcbCombo.getItemAt(i))) {
     indexAt = i;
     break;
    }
   }
  }
  return indexAt;
 }

 private void createEditDevRow() {
  if (!editTaskTextField.getText().trim().isEmpty()) {
   myDevRow.setPriority(jcbPriority.getSelectedIndex());
   myDevRow.setTaskName(editTaskTextField.getText().trim());
   if (!editStartDateTextField.getText().isEmpty()) {
    myDevRow.setStartDate(editStartDateTextField.getText());
   }
   if (!editEstDateTextField.getText().isEmpty()) {
    myDevRow.setEstDate(editEstDateTextField.getText());
   }
   if (NumberUtils.isNumber(editEstTimeTextField.getText())) {
    myDevRow.setEstimate(Integer.parseInt(editEstTimeTextField.getText().trim()));
   }
   myDevRow.setDescription(editDescriptionTextField.getText());
   myDevRow.setStatus(jcbStatus.getSelectedItem() + "");

   if (jcbPercent.getSelectedIndex() != -1) {
    myDevRow.setPercentComplete(Float.parseFloat(jcbPercent.getSelectedItem() + ""));
   }
   dispose();

   PSP_DevelopmentTable.editRow(myDevRow);
  } else {
   editTaskTextField.requestFocus();
  }
 }

 protected static String getDateTime(Date d, int code) {
  DateFormat df = null;
  switch (code) {
   case 0:
    df = DateFormat.getDateInstance(DateFormat.SHORT);
    break;
   case 1:
    df = DateFormat.getTimeInstance(DateFormat.SHORT);
    break;
   default:
    Util.debug("Never should have gotten here");
  }

  Util.debug("In here: " + d.toString());

  return (df.format(d));
 }

 private static void setLook() {
  try {
   if (Configuration.get("LOOK_AND_FEEL").equals("system")) {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
   } else if (Configuration.get("LOOK_AND_FEEL").equals("default")) {
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
   } else if (Configuration.get("LOOK_AND_FEEL").toString().length() > 0) {
    UIManager.setLookAndFeel(Configuration.get("LOOK_AND_FEEL").toString());
   }
  } catch (Exception e) {
   new ExceptionDialog(e, "Error when initializing a pluggable look-and-feel. Default LF will be used.",
    "Make sure that specified look-and-feel library classes are on the CLASSPATH.");
  }
 }
}