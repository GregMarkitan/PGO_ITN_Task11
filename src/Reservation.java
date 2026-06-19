public class Reservation implements Displayable {
	private String id;
	private Student student;
	private Equipment equipment;
	private int days;
	private ReservationStatus status;

	public Reservation(String id, Student student, Equipment equipment, int days) {
		this.id = id;
		this.student = student;
		this.equipment = equipment;
		this.days = days;
		this.status = ReservationStatus.ACTIVE;
	}
    

	public double calculateTotalCost(DiscountPolicy discountPolicy) {
        double priceBeforeDiscount = equipment.calculateDailyPrice() * days;
        return discountPolicy.applyDiscount(student, priceBeforeDiscount);
	}
}