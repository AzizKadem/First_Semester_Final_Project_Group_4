package controller;

import model.*;


public class MachineCtrl {
	public MachineCtrl() {
		
	}
	
	public Machine searchMachine(int id) {
		return MachineCont.getInstance().searchMachine(id);
	}
}
