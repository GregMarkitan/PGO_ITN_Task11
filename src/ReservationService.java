public class ReservationService {
    private final DiscountPolicy discountPolicy;

    public ReservationService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Reservation createReservation(String studentId, String equipmentId, int days) {
        // validate data, find the student, find the equipment, create the reservation
        throw new UnsupportedOperationException("to be implemented");
    }

    public void returnEquipment(String reservationId) {
        // change reservation status, unlock equipment, add loyalty points
    }
}