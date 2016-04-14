package net.sf.memoranda.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.memoranda.psp.DevRowObject;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PSP_DevelopmentTaskDescription extends JFrame {

	private static final long serialVersionUID = 2118032659774440714L;
	private JPanel contentPane;
	protected JTextField txtTextPopulatedFrom;
	private String description = "";
	private DevRowObject myDevRow;
	
	public PSP_DevelopmentTaskDescription(DevRowObject devRow) {
		this.myDevRow = devRow;
		jbInit();
	}
	
	private void jbInit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTextPopulatedFrom = new JTextField();
		txtTextPopulatedFrom.setText(myDevRow.getDescription());
		txtTextPopulatedFrom.setBounds(55, 60, 376, 186);
		contentPane.add(txtTextPopulatedFrom);
		txtTextPopulatedFrom.setColumns(10);
		
		JLabel lblTaskDescription = new JLabel("TASK DESCRIPTION");
		lblTaskDescription.setBounds(176, 20, 131, 27);
		contentPane.add(lblTaskDescription);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				button_clicked ();
			}
			
		});
		btnOk.setBounds(195, 262, 97, 25);
		contentPane.add(btnOk);
	}
	
	private void button_clicked () {
		if (myDevRow.getDescription().trim().equalsIgnoreCase(
				txtTextPopulatedFrom.getText().trim())) {
			PSP_DevelopmentTable.editDescription (txtTextPopulatedFrom.getText().trim());
		}
		dispose();
	}
}
