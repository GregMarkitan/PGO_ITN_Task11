import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ReservationService service = new ReservationService(new LoyaltyDiscountPolicy());

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n1. Show students");
			System.out.println("2. Show equipment");
			System.out.println("3. Create reservation");
			System.out.println("4. Return equipment");
			System.out.println("5. Report");
			System.out.println("0. Exit");

			System.out.print("Choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {

			case 1 -> service.getStudents().forEach(System.out::println);

			case 2 -> service.getEquipmentList().forEach(e -> {
			System.out.println(e.getId() + " | " +
			e.getName() + " | " +
			e.getType() + " | price: " +
			e.calculateDailyPrice() + " | available: " +
			e.isAvailable());
			});

			case 3 -> {
			System.out.print("Student ID: ");
			String sid = sc.nextLine();
			System.out.print("Equipment ID: ");
			String eid = sc.nextLine();
			System.out.print("Days: ");
			int days = Integer.parseInt(sc.nextLine());

			service.createReservation(sid, eid, days);
			}

			case 4 -> {
			System.out.print("Reservation ID: ");
			String rid = sc.nextLine();
			service.returnEquipment(rid);
			}

			case 5 -> service.printReport();

			case 0 -> {
			System.out.println("Goobye!");
			return;
			}

			default -> System.out.println("Invalid choice");
			}
		}
	}
}
