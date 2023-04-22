package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class world {
    public int NumberOfTrees = 0;
    public int NumberOfCreatures = 0;
    public int TotalTime = 0;
    public static int NameIndex = 0;
    public Boolean log = false;
    public ArrayList<creature> Leaderboard = new ArrayList<creature>();
    private ArrayList<creature> ListOfCreatures = new ArrayList<creature>();
    private ArrayList<tree> ListOfTrees = new ArrayList<tree>();
    private ArrayList<creature> ListOfMatingCreatures = new ArrayList<creature>();
    private ArrayList<creature> ListOfCreaturesLookingForFood = new ArrayList<creature>();
    private ArrayList<creature> CreaturesAtTree = new ArrayList<creature>();


    public world(int NumberOfTrees, int NumberOfCreatures, Boolean log) {
        this.NumberOfTrees = NumberOfTrees;
        this.NumberOfCreatures = NumberOfCreatures;
        this.log = log;
        for (int i = 0; i < NumberOfTrees; i++) {
            ListOfTrees.add(createRandomTree());
        }
        for (int i = 0; i < NumberOfCreatures; i++) {
            ListOfCreatures.add(createRandomCreature());
            if (log == true) {
                System.out.println(ListOfCreatures.get(i).Name + " has been created");
                System.out.println("Total Creatures: " + ListOfCreatures.size());
            }
            
        }
        TotalTime = 0;
        Leaderboard = new ArrayList<creature>();
        ListOfMatingCreatures = new ArrayList<creature>();
        ListOfCreaturesLookingForFood = new ArrayList<creature>();
    }

    public static creature createRandomCreature() {
        // Create a creature with random stats
        int food = (int) ((Math.random() * (5 - 0)) + 1);
        int attackPower = (int) ((Math.random() * (5 - 0)) + 1);
        double FindFoodProbiblity = Math.random();
        double ReproduceProbability = Math.random();
        // could add the ability to get a random name from name.txt
        String Name = "Creature" + NameIndex;
        NameIndex += 1;
        return new creature(Name, food, attackPower, FindFoodProbiblity, ReproduceProbability);
    }

    public void createCustomCreature(String Name, int food, int attackPower, double FindFoodProbiblity, double ReproduceProbability) {
        ListOfCreatures.add(new creature(Name, food, attackPower, FindFoodProbiblity, ReproduceProbability));
    }

    private static tree createRandomTree() {
        // Create a tree with random stats
        int stat1 = (int) ((Math.random() * (5 - 0)) + 1);
        int stat2 = (int) ((Math.random() * (5 - 0)) + 1);
        int stat3 = (int) ((Math.random() * (5 - 0)) + 1);
        int stat4 = (int) ((Math.random() * (5 - 0)) + 1);
        int stat5 = (int) ((Math.random() * (5 - 0)) + 1);
        return new tree (stat1, stat2, stat3, stat4, stat5);
    }

    public void ageTime(int time) {
        System.out.println("Running");
        if (log == true) {
            System.out.println("Total Creatures: " + this.ListOfCreatures.size());
        }
        for (int i = 0; i < time; i++) {
            if (log == true) {
                System.out.println("Time: " + this.TotalTime);
            }
            this.TotalTime += 1;
            if (log == true) {
                System.out.println("Living Creatures: " + ListOfCreatures.size());
            }
            for (int j = 0; j < ListOfCreatures.size(); j++) {
                if (log == true) {
                    System.out.println(ListOfCreatures.get(j).Name + " has " + ListOfCreatures.get(j).Food + " food");
                }
                ListOfCreatures.get(j).changeAge();
                if (ListOfCreatures.get(j).Food == 1) {
                    ListOfCreaturesLookingForFood.add(ListOfCreatures.get(j));
                    ListOfCreatures.get(j).TreeLocation = (int) ((Math.random() * (ListOfTrees.size())));
                } else if (ListOfCreatures.get(j).FindFoodProbability >= Math.random()) {
                    ListOfCreaturesLookingForFood.add(ListOfCreatures.get(j));
                    ListOfCreatures.get(j).TreeLocation = (int) ((Math.random() * (ListOfTrees.size())));
                }
                ListOfCreatures.get(j).Food -= 1;
                if (ListOfCreatures.get(j).ReproduceProbability >= Math.random()) {
                    ListOfMatingCreatures.add(ListOfCreatures.get(j));
                }
            }
            this.mateCreatures();
            for (int j = 0; j < ListOfTrees.size(); j++) {
                CreaturesAtTree = new ArrayList<creature>();
                for (int k = 0; k < ListOfCreaturesLookingForFood.size(); k++) {
                    if (ListOfCreaturesLookingForFood.get(k).TreeLocation == j) {
                        CreaturesAtTree.add(ListOfCreaturesLookingForFood.get(k));
                    }
                }
                if (CreaturesAtTree.size() > 1) {
                    this.BattleCreatures(CreaturesAtTree, ListOfTrees.get(j));
                } else if (CreaturesAtTree.size() == 1) {
                    int foodFound = ListOfTrees.get(j).spawnFood();
                    if (log == true) {
                        System.out.println(CreaturesAtTree.get(0).Name + " found " + foodFound + " food");
                    }
                    CreaturesAtTree.get(0).Food += foodFound;
                    CreaturesAtTree.get(0).TreeLocation = -1;
                }
            }
            ListOfCreaturesLookingForFood = new ArrayList<creature>();
            ListOfMatingCreatures = new ArrayList<creature>();
        }
    }

    private void BattleCreatures(ArrayList<creature> creaturesAtTree2, tree tree2) {
        // Battle creatures
        if (log == true) {
            System.out.println("Battle between " + creaturesAtTree2.size() + " creatures");
        }
        
        while (creaturesAtTree2.size() >= 2) {
            int Creature1 = (int) ((Math.random() * (creaturesAtTree2.size() - 0)));
            int Creature2 = (int) ((Math.random() * (creaturesAtTree2.size() - 0)));
            if (Creature1 != Creature2) {
                if (creaturesAtTree2.get(Creature1).AttackPower >= creaturesAtTree2.get(Creature2).AttackPower) {
                    creaturesAtTree2.get(Creature2).die(Leaderboard);
                    for (int i = 0; i < ListOfCreatures.size(); i++) {
                        if (ListOfCreatures.get(i).Name == creaturesAtTree2.get(Creature2).Name) {
                            ListOfCreatures.remove(i);
                        }
                    }
                    creaturesAtTree2.remove(Creature2);
                } else {
                    creaturesAtTree2.get(Creature1).die(Leaderboard);
                    for (int i = 0; i < ListOfCreatures.size(); i++) {
                        if (ListOfCreatures.get(i).Name == creaturesAtTree2.get(Creature1).Name) {
                            ListOfCreatures.remove(i);
                        }
                    }
                    creaturesAtTree2.remove(Creature1);
                }
            }
        }
        int foodFound = tree2.spawnFood();
        if (log == true) {
            System.out.println("Creature " + creaturesAtTree2.get(0).Name + " found " + foodFound + " food");
        }
        creaturesAtTree2.get(0).changeFood(foodFound);
        creaturesAtTree2.get(0).TreeLocation = -1;
    }

    private void mateCreatures() {
        // Mate creatures
        if (log == true) {
            System.out.println("Mating Creatures: " + ListOfMatingCreatures.size());
        }
        while (ListOfMatingCreatures.size() >= 2) {
            if (log == true) {
                System.out.println("Mating Creatures: " + ListOfMatingCreatures.size());
            }
            int Creature1 = (int) ((Math.random() * (ListOfMatingCreatures.size() - 0)) + 0);
            int Creature2 = (int) ((Math.random() * (ListOfMatingCreatures.size() - 0)) + 0);
            if (log == true) {
                System.out.println("Creature1: " + Creature1 + " Creature2: " + Creature2);
            }
            if (Creature1 != Creature2) {
                creature Creature3 = ListOfMatingCreatures.get(Creature1).mate(ListOfMatingCreatures.get(Creature2), NameIndex);
                if (log == true) {
                    System.out.println("Creature1: " + Creature1 + " Creature2: " + Creature2);
                }
                ListOfCreatures.add(Creature3);
                ListOfMatingCreatures.get(Creature1).changeTimesReproduced();
                ListOfMatingCreatures.get(Creature2).changeTimesReproduced();
                NameIndex += 1;
                if (Creature2 > Creature1) {
                    ListOfMatingCreatures.remove(Creature2);
                    ListOfMatingCreatures.remove(Creature1);
                } else {
                    ListOfMatingCreatures.remove(Creature1);
                    ListOfMatingCreatures.remove(Creature2);
                }
            }
        }
        if (log == true) {
            System.out.println("Number of creatures that failed to mate: " + ListOfMatingCreatures.size());
        }
    }

    public void printTopCreatures(int amount) {
        Collections.sort(Leaderboard, ((o1, o2) -> o1.getScore().compareTo(o2.getScore())));
        amount = Math.min(amount, Leaderboard.size());
        // amount = amount * -1;
        for (int i = 1; i < amount + 1; i++) {
            int j = Leaderboard.size() - i;
            System.out.println("Name: " + Leaderboard.get(j).Name + "\nScore: " + Leaderboard.get(j).getScore() + "\nAge: " + Leaderboard.get(j).Age + "\nTimes Reproduced: " + Leaderboard.get(j).TimesReproduced + "\nAttack Power: " + Leaderboard.get(j).AttackPower + "\nFind Food Probability: " + Leaderboard.get(j).FindFoodProbability + "\nReproduce Probability: " + Leaderboard.get(j).ReproduceProbability + "\n");
        }
    }
}
