package com.company;

// import scanner
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Boolean log = false;
        // Create scanner
        Scanner scanner = new Scanner(System.in);
        // Ask the user if they would like to log the simulation
        System.out.println("Would you like to log the simulation? This will print most important actions. Otherwise only deaths will be logged. (y/n)");
        String logSim = scanner.next();
        // If the user wants to log the simulation
        if (logSim.equals("y")) {
            // Set the log variable to true
            log = true;
        }
        // If the user does not want to log the simulation
        else {
            // Set the log variable to false
            log = false;
        }
        // Ask the user for the amount of random trees they would like created
        System.out.println("How many trees would you like to create?");
        int trees = scanner.nextInt();
        // Ask the user for the amount of random creatures they would like created
        System.out.println("How many randomly generated creatures would you like to create? (Custom creatures will be created afterwards)");
        int creatures = scanner.nextInt();
        // Create the world
        world World1 = new world(trees, creatures, log);
        // Ask the user if they would like to create custom creatures
        System.out.println("Would you like to create custom creatures? (y/n)");
        String customCreatures = scanner.next();
        // If the user wants to create custom creatures
        if (customCreatures.equals("y")) {
            // Ask the user how many custom creatures they would like to create
            System.out.println("How many custom creatures would you like to create?");
            int customCreaturesAmount = scanner.nextInt();
            for (int i = 0; i < customCreaturesAmount; i++) {
                // Ask the user for the name of the creature, the amount of food it starts with, the amount of attack power it has, the probability of finding food, and the probability of reproducing
                System.out.println("What would you like to name the creature?");
                String Name = scanner.next();
                System.out.println("How much food would you like the creature to start with? Suggested to be within 0-5");
                int food = scanner.nextInt();
                System.out.println("How much attack power would you like the creature to have? Suggested to be within 0-5");
                int attackPower = scanner.nextInt();
                System.out.println("What would you like the probability of finding food to be? Must be between 0 and 1 or it will either always find food or never find food");
                double findFoodProbability = scanner.nextDouble();
                System.out.println("What would you like the probability of reproducing to be? Must be between 0 and 1 or it will either always reproduce or never reproduce");
                double reproduceProbability = scanner.nextDouble();
                // Create the creature
                World1.createCustomCreature(Name, food, attackPower, findFoodProbability, reproduceProbability);
            }
        }
        // Ask the user for the amount of time they would like to run the simulation for
        System.out.println("How much time would you like to run the simulation for?");
        int time = scanner.nextInt();
        while (true) {
            // Run the simulation
            World1.ageTime(time);
            // Ask the user if they would like to see the leaderboard or continue the simulation
            System.out.println("Would you like to see the leaderboard or continue the simulation? (l/c)");
            String leaderboardOrContinue = scanner.next();
            if (leaderboardOrContinue.equals("l")) {
                // Print the leaderboard after asking the user how many creatures they would like to see
                System.out.println("How many creatures would you like to see?");
                int leaderboardAmount = scanner.nextInt();
                World1.printTopCreatures(leaderboardAmount);
                // Ask the user if they would like to continue the simulation
                System.out.println("Would you like to continue the simulation? (y/n)");
                String continueSimulation = scanner.next();
                if (continueSimulation.equals("y")) {
                    // Ask the user how much time they would like to run the simulation for
                    System.out.println("How much time would you like to run the simulation for?");
                    time = scanner.nextInt();
                } else {
                    // If the user does not want to continue the simulation, break the loop
                    break;
                }
            } else if (leaderboardOrContinue.equals("c")) {
                // Ask the user how much time they would like to run the simulation for
                System.out.println("How much time would you like to run the simulation for?");
                time = scanner.nextInt();
            } else {
                // If the user enters an invalid input, ask them again
                System.out.println("Invalid input, please try again");
            }
        }
        // Close the Scanner
        scanner.close();

        // Tell the user the simulation has ended
        System.out.println("Simulation has ended");
        System.out.println("Thank you for using the simulation, Goodbye!");
    }
}