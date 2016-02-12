package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;

import net.sf.memoranda.util.Local;
import javax.swing.JTextPane;
import java.awt.Label;

public class AddResourceButtonHelpDialog extends JDialog{	
	JPanel resButtonHelpdialogTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel resButtonHelpheader = new JLabel();
    ButtonGroup resButtonHelpbuttonGroup1 = new ButtonGroup();
    private GridBagLayout resButtonHelpgbl_areaPanel = new GridBagLayout();
    JPanel areaPanel = new JPanel(resButtonHelpgbl_areaPanel);
    JPanel resButtonHelpbuttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 15));
    JButton okB = new JButton();
    public boolean OK = true;
    private final JTextPane resourceButtons = new JTextPane();
    private final JPanel panel = new JPanel();
    private final JLabel newResource = new JLabel("New Resource");
    private final JLabel removeResource = new JLabel("Remove Resource");
    private final JLabel refreshResource = new JLabel("Refresh");
    private final JLabel undoResource = new JLabel("Undo");

    public AddResourceButtonHelpDialog(Frame frame, String title) {
        super(frame, title, true);
        resButtonHelpgbl_areaPanel.rowWeights = new double[]{1.0, 1.0};
        resButtonHelpgbl_areaPanel.columnWeights = new double[]{1.0, 1.0};
        try {
            jbInit();
            pack();
        }
        catch (Exception ex) {
            new ExceptionDialog(ex);
            ex.printStackTrace();
        }
    }
	 
    void jbInit() throws Exception {
		this.setResizable(false);
		resButtonHelpdialogTitlePanel.setBackground(Color.WHITE);
		resButtonHelpdialogTitlePanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		resButtonHelpheader.setFont(new java.awt.Font("Dialog", 0, 20));
		resButtonHelpheader.setForeground(new Color(0, 0, 124));
		resButtonHelpheader.setText(Local.getString("Resource Button Help"));
		resButtonHelpheader.setIcon(new ImageIcon(net.sf.memoranda.ui.AddResourceDialog.class.getResource(
            "resources/icons/help.png")));
		resButtonHelpdialogTitlePanel.add(resButtonHelpheader);
        this.getContentPane().add(resButtonHelpdialogTitlePanel, BorderLayout.NORTH);
        this.getContentPane().add(areaPanel, BorderLayout.CENTER);
        
        GridBagConstraints gbc_resourceButtons = new GridBagConstraints();
        gbc_resourceButtons.insets = new Insets(0, 0, 5, 0);
        gbc_resourceButtons.fill = GridBagConstraints.BOTH;
        gbc_resourceButtons.gridx = 1;
        gbc_resourceButtons.gridy = 0;
        resourceButtons.setText("New Resource button: allows you to add a new resource.\n"
        		+ "You can either type the file path or browse for the file path.\n" +
        		"You can also choose to copy the file to memoranda to save it for a later use.\n" +
        		"If you choose Internet Shortcut, make sure to type the URL or paste the URL from your browser.\n"
        		+ "                                 \n" + "Remove Resource button: when clicked, a selected resource is instantly removed.\n"
        		+ "                  \n" + "Refresh Resource button:"
        				+ " if you're not seeing your resource, use the refresh resource button.\n"
        		+ "           \n" + "Undo button: the last resource that is added is removed.\n");
        resourceButtons.setEditable(false);
        areaPanel.add(resourceButtons, gbc_resourceButtons);
        
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 1;
        areaPanel.add(panel, gbc_panel);
        
        newResource.setIcon(new ImageIcon(net.sf.memoranda.ui.AddResourceDialog.class.getResource(
                "resources/icons/addresource.png")));
        removeResource.setIcon(new ImageIcon(net.sf.memoranda.ui.AddResourceDialog.class.getResource(
                "resources/icons/removeresource.png")));
        refreshResource.setIcon(new ImageIcon(net.sf.memoranda.ui.AddResourceDialog.class.getResource(
                "resources/icons/refreshres.png")));
        undoResource.setIcon(new ImageIcon(net.sf.memoranda.ui.AddResourceDialog.class.getResource(
                "resources/icons/events_undo.png")));
        panel.add(newResource);
        
        panel.add(removeResource);
        
        panel.add(refreshResource);
        
        panel.add(undoResource);
        
        okB.setEnabled(true);
        okB.setMaximumSize(new Dimension(100, 26));
        okB.setMinimumSize(new Dimension(100, 26));
        okB.setPreferredSize(new Dimension(100, 26));
        okB.setText(Local.getString("Ok"));
        okB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okB_actionPerformed(e);
            }
        });
        this.getRootPane().setDefaultButton(okB);

        resButtonHelpbuttonsPanel.add(okB);
		enableFields();
        this.getContentPane().add(resButtonHelpbuttonsPanel, BorderLayout.SOUTH);
    }
	 
    void okB_actionPerformed(ActionEvent e) {
        OK = true;
        this.dispose();
    }
	 
    void cancelB_actionPerformed(ActionEvent e) {
        this.dispose();
    }
    
	void enableFields() {
	}
}
