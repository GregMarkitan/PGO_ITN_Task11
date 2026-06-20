public class ReservationService {
	private List<Student> students = new ArrayList<>();
	private List<Equipment> equipmentList = new ArrayList<>();
	private List<Reservatin> reservations = new ArrayList<>();

	private final DiscountPolicy discountPolicy;
	private int reservationCounter = 1;

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
		
		String id = "R" + String.format("%03d", reservationCounter++);
		Reservation r = new Reservation(id, student, eq, days);

		eq.setAvailable(false);
		reservations.add(r);
		double cost = r.calculateTotalCost(discountPolicy);

		System.out.println("Reservation created: " + id);
		System.out.println("Cost: " + cost);

		return r;
	
	}

	private Student findStudent(String id) {
		return students.stream()filter(s -> s.getId().equals(id)).findFirst().orElse(null);
	}

	private Equipment findEquipment(String id) {
		return equipmentList.stream()filter(e -> e.getId().equals(id)).findFirst().orElse(null);
	}

	private Reservation findReservation(String id) {
		return reservations.stream()filter(r -> r.getId().equals(id)).findFirst().orElse(null);
	}

	public void returnEquipment(String reservationId) {
        // change reservation status, unlock equipment, add loyalty points

		Reservation r = findReservation(reservationId);
		if (r == null) {
			System.out.println("Error, there is no such reservation in the system");
			return;
		}

		if (r.getStatus() != ReservationStatus.ACTIVE) {
			System.out.println("Error, this is not an active reservation");
			return;
		}
		
		r.setStatus(ReservationStatus.RETURNED);
		Equipment eq = r.getEquipment();
		eq.setAvailable(true);
	
		double cost = r.calculateTotalCost(discountPolicy);
		int points = (int) (cost/10);
		r.getStudent().addPoints(points)

		System.out.println("Equipment returned.");
		System.out.println("Student got " + points + " loyalty points.");
	}
}