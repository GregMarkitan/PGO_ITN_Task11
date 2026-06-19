public abstract class Equipment implements Displayable {
	private String id;
	private String name;
	private double baseDailyPrice;
	private boolean available = true;
	
	public Equipment(String id, String name, double baseDailyPrice) {
		this.id = id;
		this.name = name;
		this.baseDailyPrice = baseDailyPrice;
	}

	public abstract double calculateDailyPrice();
	public abstract String getDetails();
}