public class CameraKit extends Equipment {
	private int lensCount;
	private boolean hasTripod;

	public CameraKit(String id, String name, double basePrice, int lensCount, boolean hasTripod) {
		super(id, name, basePrice);
		this.lensCount = lensCount;
		this.hasTripod = hasTripod;
	}