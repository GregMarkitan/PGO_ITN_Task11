public class ReservationService {
	private List<Student> students = new ArrayList<>();
	private List<Equipment> equipmentList = new ArrayList<>();
	private List<Reservatin> reservations = new ArrayList<>();

	private final DiscountPolicy discountPolicy;

	public ReservationService(DiscountPolicy discountPolicy) {
		this.discountPolicy = discountPolicy;
		initData();
	}

	private void initData() { 
		students.add(new Student("S001", "Anna Kowalska", "12c", "120"));
		students.add(new Student("S002", "Marek Nowak", "12c", "40"));
		students.add(new Student("S003", "Julia Zielinska", "13a", "0"));

		equipmentList.add(new LaptopSet("E001", "Lenovo ThinkPad Lab", 80, 32, true));
		equipmentList.add(new LaptopSet("E002", "Dell XPS Demo", 100, 16, false));
		equipmentList.add(new CameraKit("E003", "Sony Content Kit", 90, 3, true));
		equipmentList.add(new CameraKit("E004", "Canon Interview Kit", 70, 1, true));
	}

	public List<Student> getStudents() {
		return students;
	}

	public List<Equipment> getEquipment() {
		return equipmentList;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public Reservation createReservation(String studentId, String equipmentId, int days) {
        // validate data, find the student, find the equipment, create the reservation
        	if (days < 1 || days > 14) {
			System.out.println("Error, invalid number of days");
			return null;
		}
		
		Student student = findStudent(studentId);
		Equipment eq = findEquipment(equipmentId);
		
		if (student == null) {
			System.out.println("Error, student not found.")
			return null;
		}

		if (eq == null) {
			System.out.println("Error, equipment not found.")
			return null;
		}
	
		if (!eq.isAvaialable()){
			System.out.println("Eroor, equipment not available.")
			return null;
		}
	}

	public void returnEquipment(String reservationId) {
        // change reservation status, unlock equipment, add loyalty points
	}
}