public class LaptopSet extends Equipment {
	private int ramGb;
	private boolean hasDockingStation;
	
	public LaptopSet(Sting id, String name, double basePrice, int ramGb, boolean hasDockingStation) {
		super(id, name, basePrice);
		this.ramGb = ramGb;
		this.hasDockingStation = hasDockingStation;
	}
}