package com.company;

import java.util.ArrayList;

public class creature {
    public String Name;
    public int Food;
    public int Age;
    public int TimesReproduced;
    public Integer Score;
    public int AttackPower;
    public int TreeLocation;
    public double FindFoodProbability;
    public double ReproduceProbability;

    public creature(String Name, int Food, int AttackPower, double FindFoodProbability, double ReproduceProbability){
        this.Name = Name;
        this.Food = Food;
        this.Age = 0;
        this.TimesReproduced = 0;
        this.Score = 0;
        this.AttackPower = AttackPower;
        this.TreeLocation = -1;
        this.FindFoodProbability = FindFoodProbability;
        this.ReproduceProbability = ReproduceProbability;
    }

    public void changeFood(int FoodChange) {
        // Change the amount of food the creature has
        this.Food += FoodChange;
    }

    public void changeAge() {
        // Change the age of the creature
        this.Age += 1;
        this.Score = TimesReproduced * Age;
    }

    public void changeTimesReproduced() {
        // Change the amount of times the creature has reproduced
        this.TimesReproduced += 1;
        this.Score = TimesReproduced * Age;
    }

    public Integer getScore(){
        // Get the score of the creature
        return Score;
    }

    public ArrayList<creature> die(ArrayList<creature> Leaderboard) {
        // Die
        System.out.println(Name + " has died. They had a score of " + Score + ", lived for " + Age + " turns, and reproduced " + TimesReproduced + " times.");
        if (Leaderboard.size() == 0) {
            Leaderboard.add(this);
        }
        for (int i = 0; i < Leaderboard.size(); i++) {
            if (Leaderboard.get(i).Score < this.Score) {
                // Insert the creature into the leaderboard
                Leaderboard.add(this);
                break;
            }
        }
        return Leaderboard;
    }

    public creature mate(creature creature, int NameIndex) {
        // Mate with another creature
        int food = (int) ((Math.random() * (5 - 1)) + 1);
        int attackPower = (int) ((this.AttackPower + creature.AttackPower + (int) ((Math.random() * (5 - 0)) - 2)) / 2);
        double FindFoodProbiblity = (this.FindFoodProbability + creature.FindFoodProbability + Math.random()) / 3;
        double ReproduceProbability = (this.ReproduceProbability + creature.ReproduceProbability + Math.random()) / 3;
        // could add the ability to get a random name from name.txt
        String Name = "Creature" + NameIndex;
        return new creature(Name, food, attackPower, FindFoodProbiblity, ReproduceProbability);
    }
}
