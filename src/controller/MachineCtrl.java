package controller;

import model.*;


public class MachineCtrl {
	public MachineCtrl() {
		
	}
	
	/**
	 * Search machine by id
	 * @param id The id the machine is searched by
	 * @return found machine
	 */
	public Machine searchMachine(int id) {
		return MachineCont.getInstance().searchMachine(id);
	}
}
