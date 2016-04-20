package net.sf.memoranda.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.memoranda.psp.DevRowObject;
import net.sf.memoranda.util.Configuration;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PSP_DevelopmentTaskDescription extends JFrame {

	static final long serialVersionUID = 2118032659774440714L;
	JPanel contentPane;
	JTextField txtTextPopulatedFrom;
	DevRowObject myDevRow;

	public PSP_DevelopmentTaskDescription(DevRowObject devRow) {
		this.myDevRow = devRow;
		jbInit();
	}

	void jbInit() {
		setLook();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 347);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtTextPopulatedFrom = new JTextField();
		txtTextPopulatedFrom.setEnabled(false);
		txtTextPopulatedFrom.setText(myDevRow.getDescription());
		txtTextPopulatedFrom.setBounds(55, 60, 376, 186);
		contentPane.add(txtTextPopulatedFrom);
		txtTextPopulatedFrom.setColumns(10);

		JLabel lblTaskDescription = new JLabel("TASK DESCRIPTION");
		lblTaskDescription.setBounds(176, 20, 131, 27);
		contentPane.add(lblTaskDescription);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button_clicked();
			}
		});
		btnOk.setBounds(195, 262, 97, 25);
		contentPane.add(btnOk);
	}

	void button_clicked() {
		if (myDevRow.getDescription().trim().equalsIgnoreCase(txtTextPopulatedFrom.getText().trim())) {
			PSP_DevelopmentTable.editDescription(txtTextPopulatedFrom.getText().trim());
		}
		dispose();
	}

	static void setLook() {
		try {
			if (Configuration.get("LOOK_AND_FEEL").equals("system"))
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			else if (Configuration.get("LOOK_AND_FEEL").equals("default"))
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			else if (Configuration.get("LOOK_AND_FEEL").toString().length() > 0)
				UIManager.setLookAndFeel(Configuration.get("LOOK_AND_FEEL").toString());
		} catch (Exception e) {
			new ExceptionDialog(e, "Error when initializing a pluggable look-and-feel. Default LF will be used.",
					"Make sure that specified look-and-feel library classes are on the CLASSPATH.");
		}
	}
}
