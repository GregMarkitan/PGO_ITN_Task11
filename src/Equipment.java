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
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getBaseDailyPrice() {
		return baseDailyPrice;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String getType() {
		return this.getClass().getSimpleName();
	}

	public abstract double calculateDailyPrice();
	public abstract String getDetails();

	@Override
	public String getDisplayText() {
		return id + " | " + name;
	}
}