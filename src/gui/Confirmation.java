package gui;

public class Confirmation {
	private boolean created;
	private static Confirmation INSTANCE;
	
	private Confirmation() {
		created = false;
	}
	
	public static Confirmation getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new Confirmation();
		}
		return INSTANCE;
	}
	
	public void setCreated(boolean x) {
		created = x;
	}
	
	public boolean isCreated() {
		return created;
	}

}
