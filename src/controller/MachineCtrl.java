package controller;

import model.*;


public class MachineCtrl {
	
	private MachineCont machineContainer;
	
	public MachineCtrl() {
		
	}
	
	public Machine searchMachine(int id) {
		return machineContainer.getInstance().searchMachine(id);
	}
}
