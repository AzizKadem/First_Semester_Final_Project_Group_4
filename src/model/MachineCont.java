package model;

import java.util.ArrayList;

import exceptions.MachineNotFoundException;

public final class MachineCont {
	private static MachineCont instance;
	private ArrayList<Machine> machines;
	
	private MachineCont() {
		machines = new ArrayList<>();
	}
	
	/**
	 * Get instance of the machine container
	 * @return The instance
	 */
	public static MachineCont getInstance() {
		if (instance == null) {
			instance = new MachineCont();
		}
		return instance;
	}
	
	/**
	 * Search machine by the id
	 * @param ID The id the machine is searched by
	 * @return True if the machine was found
	 * @throws MachineNotFoundException 
	 */
	public Machine searchMachine(int ID) throws MachineNotFoundException {
		boolean found = false;
		Machine retVal = null;
		int index = 0;
		
		while (index < machines.size() && !found) {
			if (machines.get(index).getID() == ID) {
				retVal = machines.get(index);
				found = true;
			}
			index++;
		}
		
		if(retVal == null) {
			throw new MachineNotFoundException();
		}
		
		return retVal;
	}
	
	/**
	 * Add a machine to the container
	 * @param m A machine to be added
	 */
	public void addMachine(Machine m) {
		machines.add(m);
	}
}
