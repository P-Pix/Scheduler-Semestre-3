import constraints.*;
import solvers.*;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class InteractiveScheduling {
    public static void main(String[] args) {
        System.out.println("Welcome to the interactive scheduling program!");
        System.out.println("Please enter the number of Activity:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Please enter the name of Activity " + (i + 1) + ":");
            String name = sc.next();
            sc.nextLine();
            System.out.println("Please enter the duration of Activity " + (i + 1) + ":");
            int duration = sc.nextInt();
            activities[i] = new Activity(name, duration);
        }
        Set<Activity> activitySet = new HashSet<Activity>();
        for (int i = 0; i < n; i++) {
            activitySet.add(activities[i]);
        }
        /// minimale date
        System.out.println("Please enter the minimum date:");
        Scanner sc2 = new Scanner(System.in);
        int minDate = sc2.nextInt();
        /// maximale date
        System.out.println("Please enter the maximum date:");
        Scanner sc3 = new Scanner(System.in);
        int maxDate = sc3.nextInt();
        // Create the Random Schedule
        RandomScheduler randomScheduler = new RandomScheduler(new Random());
        Map<Activity, Integer> map = randomScheduler.generateOneSchedule(activitySet, minDate, maxDate);
        // Print the schedule
        System.out.println("The random schedule is:");
        for (Map.Entry<Activity, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey().getDescription() + " " + entry.getValue());
        }
        sc.close();
        sc2.close();
        sc3.close();
    }
}