package com.company;

// Importing ArrayList
import java.util.ArrayList;

public class Main {
    {
        trees = 10;
        creatures = 10;
        
    }
}

public class world {
    public int NumberOfTrees;
    public int NumberOfCreatures;
    public int TotalTime;
    public ArrayList Leaderboard;
    private ArrayList ListOfCreatures;
    private ArrayList ListOfTrees;
    private ArrayList ListOfMatingCreatures;
    private ArrayList ListOfCreaturesLookingForFood;


    public world(int NumberOfTrees, int NumberOfCreatures) {
        this.NumberOfTrees = NumberOfTrees;
        this.NumberOfCreatures = 10;
        TotalTime = 0;
        Leaderboard = new ArrayList();
        ListOfCreatures = new ArrayList();
        ListOfTrees = new ArrayList();
        ListOfMatingCreatures = new ArrayList();
        ListOfCreaturesLookingForFood = new ArrayList();
    }
    
    public createCustomCreature() {
        // Create a creature with custom stats

    }

    public createRandomCreature() {
        // Create a creature with random stats
    }

    public createCustomTree() {
        // Create a tree with custom stats
    }

    public createRandomTree() {
        // Create a tree with random stats
    }

    public appendToLeaderboard() {
        // Append a creature score to the leaderboard
    }

    public appendToMatingCreatures() {
        // Append a creature to the mating creatures list
    }

    public appendToCreaturesLookingForFood() {
        // Append a creature to the creatures looking for food list
    }

    private ageTime() {
        // Age the time by 1
    }

    private mateCreatures() {
        // Mate creatures
    }
}

public class creature {
    public string Name;
    public int Food;
    public int Age;
    public int TimesReproduced;
    public int score;
    public int AttackPower;
    public int TreeLocation;
    public boolean AttemptingToMate;
    public boolean LookingForFood;
    private double FindFoodProbability;
    private double ReproduceProbability;

    public creature(string Name, int Food, int AttackPower, double FindFoodProbability, double ReproduceProbability){
        this.Name = Name;
        this.Food = Food;
        this.Age = 0;
        this.TimesReproduced = 0;
        this.score = 0;
        this.AttackPower = AttackPower;
        this.TreeLocation = -1;
        this.AttemptingToMate = false;
        this.LookingForFood = false;
        this.FindFoodProbability = FindFoodProbability;
        this.ReproduceProbability = ReproduceProbability;
    }

    public changeName() {
        // Change the name of the creature
    }

    public changeFood() {
        // Change the amount of food the creature has
    }

    public changeAge() {
        // Change the age of the creature
    }

    public changeTimesReproduced() {
        // Change the amount of times the creature has reproduced
    }

    public findFood() {
        // Find food
    }

    public findMate() {
        // Find a mate
    }

    public die() {
        // Die
    }

    private rollFindFood() {
        // Roll to find food
    }

    private rollFindMate() {
        // Roll to look for a mate
    }
}

public class tree {
    public int Sum;
    public int ChanceOfOne;
    public int ChanceOfTwo;
    public int ChanceOfThree;
    public int ChanceOfFour;
    public int ChanceOfFive;
    private double ChanceOfOneProbability;
    private double ChanceOfTwoProbability;
    private double ChanceOfThreeProbability;
    private double ChanceOfFourProbability;
    private double ChanceOfFiveProbability;

    public tree(int ChanceOfOne, int ChanceOfTwo, int ChanceOfThree, int ChanceOfFour, int ChanceOfFive) {
        this.Sum = sum(ChanceOfOne, ChanceOfTwo, ChanceOfThree, ChanceOfFour, ChanceOfFive);
        this.ChanceOfOne = ChanceOfOne;
        this.ChanceOfTwo = ChanceOfTwo;
        this.ChanceOfThree = ChanceOfThree;
        this.ChanceOfFour = ChanceOfFour;
        this.ChanceOfFive = ChanceOfFive;
        this.ChanceOfOneProbability = ChanceOfOne / Sum;
        this.ChanceOfTwoProbability = ChanceOfTwo / Sum;
        this.ChanceOfThreeProbability = ChanceOfThree / Sum;
        this.ChanceOfFourProbability = ChanceOfFour / Sum;
        this.ChanceOfFiveProbability = ChanceOfFive / Sum;
    }

    public spawnFood() {
        // Spawn food
    }

    public changeChanceOfOne() {
        // Change the chance of one food spawning
    }

    public changeChanceOfTwo() {
        // Change the chance of two food spawning
    }

    public changeChanceOfThree() {
        // Change the chance of three food spawning
    }

    public changeChanceOfFour() {
        // Change the chance of four food spawning
    }

    public changeChanceOfFive() {
        // Change the chance of five food spawning
    }

    public printSum() {
        // Print the sum of the chances
    }

    public printTrueProbabilities() {
        // Print the true probabilities of the chances
    }

    public die() {
        // Die
    }

    private changeSum() {
        // Change the sum of the chances
    }

    private updateTrueProbabilities() {
        // Update the true probabilities of the chances
    }
}