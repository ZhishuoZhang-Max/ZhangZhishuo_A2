package com.a2;

/**
 * Main class demonstrating the theme park ride management system
 */
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    // Part3: Test queue add, remove and print
    public void partThree() {
        System.out.println("\n========== Part 3 ==========");
        Employee operator = new Employee("John", 30, "Male", "E001", "Operator");
        Ride ride = new Ride("Roller Coaster", 20, operator, 5);

        Visitor v1 = new Visitor("Alice", 25, "Female", "T001", "VIP");
        Visitor v2 = new Visitor("Bob", 22, "Male", "T002", "Regular");
        Visitor v3 = new Visitor("Charlie", 28, "Male", "T003", "VIP");
        Visitor v4 = new Visitor("Diana", 20, "Female", "T004", "Regular");
        Visitor v5 = new Visitor("Eve", 24, "Female", "T005", "VIP");

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        ride.removeVisitorFromQueue(v2);
        ride.printQueue();
    }

    // Part4A: Test history add, check and print
    public void partFourA() {
        System.out.println("\n========== Part 4A ==========");
        Employee operator = new Employee("John", 30, "Male", "E001", "Operator");
        Ride ride = new Ride("Ferris Wheel", 30, operator, 5);

        Visitor v1 = new Visitor("Alice", 25, "Female", "T001", "VIP");
        Visitor v2 = new Visitor("Bob", 22, "Male", "T002", "Regular");
        Visitor v3 = new Visitor("Charlie", 28, "Male", "T003", "VIP");
        Visitor v4 = new Visitor("Diana", 20, "Female", "T004", "Regular");
        Visitor v5 = new Visitor("Eve", 24, "Female", "T005", "VIP");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("Check if Alice is in history: " + ride.checkVisitorFromHistory(v1));
        System.out.println("Number of visitors in history: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }

    // Part4B: Test history sorting
    public void partFourB() {
        System.out.println("\n========== Part 4B ==========");
        Employee operator = new Employee("John", 30, "Male", "E001", "Operator");
        Ride ride = new Ride("Bumper Cars", 15, operator, 5);

        Visitor v1 = new Visitor("Zack", 30, "Male", "T001", "VIP");
        Visitor v2 = new Visitor("Amy", 22, "Female", "T002", "Regular");
        Visitor v3 = new Visitor("Mike", 25, "Male", "T003", "VIP");
        Visitor v4 = new Visitor("Lisa", 25, "Female", "T004", "Regular");
        Visitor v5 = new Visitor("Tom", 18, "Male", "T005", "VIP");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("Before sorting:");
        ride.printRideHistory();

        ride.sortRideHistory();

        System.out.println("After sorting:");
        ride.printRideHistory();
    }

    // Part5: Test run cycle
    public void partFive() {
        System.out.println("\n========== Part 5 ==========");
        Employee operator = new Employee("John", 30, "Male", "E001", "Operator");
        Ride ride = new Ride("Swing com.a2.Ride", 20, operator, 4);

        for (int i = 1; i <= 10; i++) {
            ride.addVisitorToQueue(new Visitor("com.a2.Visitor" + i, 20 + i, "Male", "T00" + i, "Regular"));
        }

        System.out.println("\nQueue before running:");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("\nQueue after running:");
        ride.printQueue();

        System.out.println("\ncom.a2.Ride history:");
        ride.printRideHistory();
    }

    // Part6: Test export history to CSV
    public void partSix() {
        System.out.println("\n========== Part 6 ==========");
        Employee operator = new Employee("John", 30, "Male", "E001", "Operator");
        Ride ride = new Ride("Water Slide", 25, operator, 5);

        ride.addVisitorToHistory(new Visitor("Alice", 25, "Female", "T001", "VIP"));
        ride.addVisitorToHistory(new Visitor("Bob", 22, "Male", "T002", "Regular"));
        ride.addVisitorToHistory(new Visitor("Charlie", 28, "Male", "T003", "VIP"));
        ride.addVisitorToHistory(new Visitor("Diana", 20, "Female", "T004", "Regular"));
        ride.addVisitorToHistory(new Visitor("Eve", 24, "Female", "T005", "VIP"));

        ride.exportRideHistory("rideHistory.csv");
    }

    // Part7: Test import history from CSV
    public void partSeven() {
        System.out.println("\n========== Part 7 ==========");
        Employee operator = new Employee("John", 30, "Male", "E001", "Operator");
        Ride ride = new Ride("Drop Tower", 20, operator, 5);

        ride.importRideHistory("rideHistory.csv");
        System.out.println("Total visitors imported: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }
}
