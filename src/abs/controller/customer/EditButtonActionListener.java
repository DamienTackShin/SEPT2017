package abs.controller.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abs.view.dialog.customer.EditInformationDialog;
import abs.view.gui.MainCustomerFrame;

public class EditButtonActionListener implements ActionListener {

	private MainCustomerFrame mainCustomerFrame;
	
	public EditButtonActionListener(MainCustomerFrame mainCustomerFrame) {
		this.mainCustomerFrame = mainCustomerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new EditInformationDialog(mainCustomerFrame);
	}

}
