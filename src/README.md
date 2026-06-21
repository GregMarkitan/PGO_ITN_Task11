# Equipment Reservation System
## Project Description

This project is a console-based Java application created for managing equipment reservations in a university.

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
- RAM size
- Docking station availability

Main methods:
- calculateDailyPrice()
- getDetails()

### CameraKit

Represents a camera equipment set.

Additional fields:
- Number of lenses
- Tripod availability

Overrides the daily price calculation according to the business rules.

### Reservation

Represents a reservation made by a student.

Stores:
- Reservation ID
- Student object
- Equipment object
- Number of rental days
- Reservation status

Calculates the total reservation cost using a discount policy.

### ReservationService

Contains the business logic of the application.

Responsibilities:
- Creating reservations
- Returning equipment
- Finding students and equipment
- Managing reservation status
- Generating reports

### LoyaltyDiscountPolicy

Implements the discount calculation rules.

Students with at least 100 loyalty points receive a 10% discount.

### ReservationStatus (Enum)

Represents the reservation state.

Possible values:
- ACTIVE
- RETURNED
- CANCELLED

---
