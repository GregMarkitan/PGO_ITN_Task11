public class LaptopSet extends Equipment {
	private int ramGb;
	private boolean hasDockingStation;
	
	public LaptopSet(Sting id, String name, double basePrice, int ramGb, boolean hasDockingStation) {
		super(id, name, basePrice);
		this.ramGb = ramGb;
		this.hasDockingStation = hasDockingStation;
	}
	
	@Override 
	public double calculateDailyPrice() {
		double price = getBaseDailyPrice();
		if (hasDockingStation) price += 15;
		if (ramGb >= 32) price += 25;
		return price;
	}

	@Override
	public String getDetails() {
		return "RAM GB: " + ramGb + " | " + " Dock: " + hasDocking;
}