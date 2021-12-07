package model;

import java.util.ArrayList;

public final class MachineCont {
	private static MachineCont instance;
	private ArrayList<Machine> machines;
	
	private MachineCont() {
		machines = new ArrayList<>();
	}
	
	public static MachineCont getInstance() {
		if (instance == null) {
			instance = new MachineCont();
		}
		return instance;
	}
	
	public Machine searchMachine(int ID) {
		boolean found = false;
		Machine retVal = null;
		int index = 0;
		while(!found) {
			if(machines.get(index).getID() == ID) {
				retVal = machines.get(index);
				found = true;
			}
			index++;
		}
		return retVal;
	}
	
	public void addMachine(Machine m) {
		machines.add(m);
	}
}
