package com.a2;

import java.io.*;
import java.util.*;

/**
 * Ride class implementing queue management, history tracking, cycle running and data import/export
 */
public class Ride implements RideInterface {
    private String rideName;                  // Ride name
    private int capacity;                      // Capacity
    private Employee operator;                 // Operator
    private Queue<Visitor> waitingQueue;       // Waiting queue
    private LinkedList<Visitor> rideHistory;   // Ride history
    private int maxRider;                      // Max riders per cycle
    private int numOfCycles;                   // Number of cycles run

    // Default constructor
    public Ride() {
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 1;
        this.numOfCycles = 0;
    }

    // Parameterized constructor
    public Ride(String rideName, int capacity, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    // Add visitor to waiting queue
    @Override
    public void addVisitorToQueue(Visitor v) {
        waitingQueue.add(v);
        System.out.println(v.getName() + " added to queue.");
    }

    // Remove visitor from queue
    @Override
    public void removeVisitorFromQueue(Visitor v) {
        if (waitingQueue.remove(v)) {
            System.out.println(v.getName() + " removed from queue.");
        } else {
            System.out.println(v.getName() + " not found in queue.");
        }
    }

    // Print waiting queue
    @Override
    public void printQueue() {
        System.out.println("=== Waiting Queue ===");
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (Visitor v : waitingQueue) {
            System.out.println("Name: " + v.getName() + ", Age: " + v.getAge() + ", TicketId: " + v.getTicketId());
        }
    }

    // Add visitor to ride history
    @Override
    public void addVisitorToHistory(Visitor v) {
        rideHistory.add(v);
        System.out.println(v.getName() + " added to ride history.");
    }

    // Check if visitor is in history
    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        return rideHistory.contains(v);
    }

    // Get number of visitors in history
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    // Print ride history using iterator
    @Override
    public void printRideHistory() {
        System.out.println("=== com.a2.Ride History ===");
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in history.");
            return;
        }
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            System.out.println("Name: " + v.getName() + ", Age: " + v.getAge() + ", TicketId: " + v.getTicketId());
        }
    }

    // Run one cycle, move visitors from queue to history
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Cannot run: No operator assigned.");
            return;
        }
        if (waitingQueue.isEmpty()) {
            System.out.println("Cannot run: Queue is empty.");
            return;
        }
        int count = Math.min(maxRider, waitingQueue.size());
        System.out.println("Running cycle " + (numOfCycles + 1) + ", taking " + count + " visitors.");
        for (int i = 0; i < count; i++) {
            Visitor v = waitingQueue.poll();
            rideHistory.add(v);
        }
        numOfCycles++;
    }

    // Sort ride history using comparator
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("com.a2.Ride history sorted.");
    }

    // Export ride history to CSV file
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor v : rideHistory) {
                writer.write(v.getName() + "," + v.getAge() + "," + v.getGender() + "," + v.getTicketId() + "," + v.getTicketType());
                writer.newLine();
            }
            System.out.println("com.a2.Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting: " + e.getMessage());
        }
    }

    // Import ride history from CSV file
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    Visitor v = new Visitor(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3], parts[4]);
                    rideHistory.add(v);
                }
            }
            System.out.println("Imported " + rideHistory.size() + " visitors from " + filename);
        } catch (IOException e) {
            System.out.println("Error importing: " + e.getMessage());
        }
    }
}
