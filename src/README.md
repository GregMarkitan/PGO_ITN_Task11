# Equipment Reservation System
## Project Description

This project is a console-based Java application created for managing equipment reservations in a university.

---

## Features

The application provides the following functionalities from its "UI Menu":

1. Displaying the list of students.
2. Displaying the list of equipment and their availability.
3. Allows creating new reservations.
4. Allows returning of borrowed equipment.
5. Displaying the currently active reservations.
6. Creating a report and displaying the following information:
   - Completed reservations
   - Total revenue
   - Student with the highest number of loyalty points
7. Exiting the program.

---

## Classes

### Main

Starts the application and provides a console menu for user input.

### Student

Represents a student borrowing equipment.

Main fields:
- id
- fullName
- groupName
- loyaltyPoints

Main methods:
- getId()
- getFullName()
- getLoyaltyPoints()
- addPoints(int points)

### Equipment (Abstract Class)

Base class for all equipment types.

Main fields:
- id
- name
- baseDailyPrice
- available

Main methods:
- calculateDailyPrice()
- getDetails()
- getType()
- isAvailable()
- setAvailable(boolean available)
- getDisplayText()

### LaptopSet

Represents a laptop type equipment set.

Additional fields:
- ramGb
- hasDockingStation

Main methods:
- calculateDailyPrice()
- getDetails()

### CameraKit

Represents a camera type equipment set.

Additional fields:
- lensCount
- hasTripod

Main methods:
- calculateDailyPrice()
- getDetails()

### Reservation

Represents a reservation for a specific equipment made by a specific student.

Main fields:
- id
- student
- equipment
- days
- status

Main methods:
- calculateTotalCost(DiscountPolicy policy)
- getDisplayText()
- getStatus()
- setStatus(ReservationStatus status)
- getStudent()
- getEquipment()

### ReservationService

Contains the business logic of the application.

Responsibilities:
- Creating reservations
- Returning equipment
- Finding a student, equipment or reservation.
- Managing reservation status
- Generating reports

Main methods:
- createReservation(String studentId, String equipmentId, int days)
- returnEquipment(String reservationId)
- printReport()
- findStudent(String id)
- findEquipment(String id)
- findReservation(String id)
- getStudents()
- getEquipmentList()
- getReservations()

### LoyaltyDiscountPolicy

Implements the discount policy for reservations, uses loyalty points.

Main methods:
- applyDiscount(Student student, double price)

### ReservationStatus (Enum)

Represents the reservation state.

Possible values:
- ACTIVE
- RETURNED
- CANCELLED

---

## Interfaces

### Displayable

Provides a common way of displaying objects in a readable format.

Main method:
String getDisplayText();

Implemented by:
- Equipment
- Reservation

### DiscountPolicy

Provides logic for applying reservation discounts.

Main method:
- double applyDiscount(Student student, double price);

Implemented by:
- LoyaltyDiscountPolicy

---

## Polymorphism Situation Example

- Polymorphism is best seen and understood through the "calculateDailyPrice()" method in this task.
- All equipment objects are stored in a single collection "List<Equipment> equipmentList;" by the application.
- Both "LaptopSet" and "CameraKit" (equipment objects) inherit from "Equipment", and both override "calculateDailyPrice" since the pricing depends on different factors for different equipment types in the logic provided.
- Therefore, when the program executes "equipmnt.calculateDailyPrice();" jaca can automatically call the correct implementation based on the object type.
- "LaptopSet" daily price will be calculated using ramGb and hasDockingStation fields.
- "CameraKit" daily price will be calculated using lensCount and hasTripod fields.
- This allows the handling of all equipment objects uniformly throught the "Equipment" supercall while still executing specific sub class code.

---
