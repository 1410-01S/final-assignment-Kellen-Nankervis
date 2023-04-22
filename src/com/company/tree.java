package com.company;

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
        this.Sum = ChanceOfOne + ChanceOfTwo + ChanceOfThree + ChanceOfFour + ChanceOfFive;
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

    public int spawnFood() {
        // Spawn food
        double chance = Math.random();
        if (chance < ChanceOfOneProbability) {
            return 1;
        } else if (chance < ChanceOfOneProbability + ChanceOfTwoProbability) {
            return 2;
        } else if (chance < ChanceOfOneProbability + ChanceOfTwoProbability + ChanceOfThreeProbability) {
            return 3;
        } else if (chance < ChanceOfOneProbability + ChanceOfTwoProbability + ChanceOfThreeProbability + ChanceOfFourProbability) {
            return 4;
        } else {
            return 5;
        }
    }

    public void changeChanceOfOne(int ChanceOfOne) {
        // Change the chance of one food spawning
        this.ChanceOfOne = ChanceOfOne;
        changeSum();
        updateTrueProbabilities();
    }

    public void changeChanceOfTwo(int ChanceOfTwo) {
        // Change the chance of two food spawning
        this.ChanceOfTwo = ChanceOfTwo;
        changeSum();
        updateTrueProbabilities();
    }

    public void changeChanceOfThree(int ChanceOfThree) {
        // Change the chance of three food spawning
        this.ChanceOfThree = ChanceOfThree;
        changeSum();
        updateTrueProbabilities();
    }

    public void changeChanceOfFour(int ChanceOfFour) {
        // Change the chance of four food spawning
        this.ChanceOfFour = ChanceOfFour;
        changeSum();
        updateTrueProbabilities();
    }

    public void changeChanceOfFive(int ChanceOfFive) {
        // Change the chance of five food spawning
        this.ChanceOfFive = ChanceOfFive;
        changeSum();
        updateTrueProbabilities();
    }

    public void printSum() {
        // Print the sum of the chances
        System.out.println("Sum: " + Sum);
    }

    public void printTrueProbabilities() {
        // Print the true probabilities of the chances
        System.out.println("Chance of one: " + ChanceOfOneProbability);
        System.out.println("Chance of two: " + ChanceOfTwoProbability);
        System.out.println("Chance of three: " + ChanceOfThreeProbability);
        System.out.println("Chance of four: " + ChanceOfFourProbability);
        System.out.println("Chance of five: " + ChanceOfFiveProbability);
    }

    private void changeSum() {
        // Change the sum of the chances
        this.Sum =  ChanceOfOne + ChanceOfTwo + ChanceOfThree + ChanceOfFour + ChanceOfFive;
    }

    private void updateTrueProbabilities() {
        // Update the true probabilities of the chances
        this.ChanceOfOneProbability = ChanceOfOne / Sum;
        this.ChanceOfTwoProbability = ChanceOfTwo / Sum;
        this.ChanceOfThreeProbability = ChanceOfThree / Sum;
        this.ChanceOfFourProbability = ChanceOfFour / Sum;
        this.ChanceOfFiveProbability = ChanceOfFive / Sum;
    }
}
