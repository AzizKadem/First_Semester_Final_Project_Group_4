package controller;

import exceptions.MachineNotFoundException;
import model.*;


public class MachineCtrl {
	public MachineCtrl() {
		
	}
	
	/**
	 * Search machine by id
	 * @param id The id the machine is searched by
	 * @return found machine
	 * @throws MachineNotFoundException 
	 */
	public Machine searchMachine(int id) throws MachineNotFoundException {
		return MachineCont.getInstance().searchMachine(id);
	}
}
