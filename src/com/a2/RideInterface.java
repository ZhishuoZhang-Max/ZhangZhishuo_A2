package com.a2;

/**
 * Ride interface defining queue management and history operations
 */
public interface RideInterface {
    void addVisitorToQueue(Visitor v);      // Add visitor to waiting queue
    void removeVisitorFromQueue(Visitor v); // Remove visitor from queue
    void printQueue();                      // Print waiting queue
    void addVisitorToHistory(Visitor v);    // Add visitor to ride history
    boolean checkVisitorFromHistory(Visitor v); // Check if visitor is in history
    int numberOfVisitors();                 // Get number of visitors in history
    void printRideHistory();                // Print ride history
    void runOneCycle();                     // Run one cycle
}
