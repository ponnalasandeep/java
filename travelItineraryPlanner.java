import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class ItineraryDay {
 private ArrayList<String> activities;
 public ItineraryDay() {
 this.activities = new ArrayList<>();
 }
 public void addActivity(String activity) {
 activities.add(activity);
 }
 public void displayDay(int dayNumber) {
 System.out.println("Day " + dayNumber + " Itinerary:");
 for (int i = 0; i < activities.size(); i++) {
 System.out.println((i + 1) + ". " + activities.get(i));
 }
 }
}
class TravelItinerary {
 private Map<Integer, ItineraryDay> itineraryDays;
 public TravelItinerary() {
 this.itineraryDays = new HashMap<>();
 }
 public void addDay(int dayNumber) {
 ItineraryDay day = new ItineraryDay();
 itineraryDays.put(dayNumber, day);
 }
 public void addActivity(int dayNumber, String activity) {
 if (itineraryDays.containsKey(dayNumber)) {
 itineraryDays.get(dayNumber).addActivity(activity);
 } else {
 System.out.println("Invalid day number. Please add the day first.");
 }
 }
 public void displayItinerary() {
 System.out.println("Travel Itinerary:");
 for (Map.Entry<Integer, ItineraryDay> entry : itineraryDays.entrySet()) {
 entry.getValue().displayDay(entry.getKey());
 }
 }
}
class TravelItineraryPlanner {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 TravelItinerary itinerary = new TravelItinerary();
 // Get the number of days for the trip
 System.out.print("Enter the number of days for your trip: ");
 int numberOfDays = scanner.nextInt();
 // Create days in the itinerary
 for (int i = 1; i <= numberOfDays; i++) {
 itinerary.addDay(i);
 }
 // Populate the itinerary with activities
 for (int dayNumber = 1; dayNumber <= numberOfDays; dayNumber++) {
 System.out.println("Enter activities for Day " + dayNumber + " (Type 'end' to finish):");
 String activity;
 do {
 System.out.print("Activity: ");
 activity = scanner.next();
 if (!activity.equalsIgnoreCase("end")) {
 itinerary.addActivity(dayNumber, activity);
 }
 } while (!activity.equalsIgnoreCase("end"));
 }
 // Display the final itinerary
 itinerary.displayItinerary();
 }
}
