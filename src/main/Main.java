package main;

import bag.*;
import surprise.*;
import surprise.give.*;
import bag.factory.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static surprise.GatherSurprises.gather;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String[] typesOfSharing = {"ApplauseRandom", "ApplauseLIFO", "ApplauseFIFO", "HugRandom", "HugLIFO", "HugFIFO",
                "SingRandom", "SingLIFO", "SingFIFO"};

        System.out.println("Insert type of sharing:\n\t" + "\"1\". ApplauseRandom\n\t" + "\"2\". ApplauseLIFO\n\t" +
                "\"3\". ApplauseFIFO\n\t" + "\"4\". HugRandom\n\t" + "\"5\". HugLIFO\n\t" + "\"6\". HugFIFO\n\t" +
                "\"7\". SingRandom\n\t" + "\"8\". SingLIFO\n\t" + "\"9\". SingLIFO\n");

        int option = sc.nextInt();

        System.out.println("Insert wait time (seconds).\n");

        int waitTime = sc.nextInt();

        AbstractGiveSurprises surprises;
        Factory factory = Factory.getInstance();
        switch (option) {
            case 1:
                surprises = new GiveSurpriseAndApplause("RANDOM", waitTime);
                break;
            case 2:
                surprises = new GiveSurpriseAndApplause("LIFO", waitTime);
                break;
            case 3:
                surprises = new GiveSurpriseAndApplause("FIFO", waitTime);
                break;
            case 4:
                surprises = new GiveSurpriseAndHug("RANDOM", waitTime);
                break;
            case 5:
                surprises = new GiveSurpriseAndHug("LIFO", waitTime);
                break;
            case 6:
                surprises = new GiveSurpriseAndHug("FIFO", waitTime);
                break;
            case 7:
                surprises = new GiveSurpriseAndSing("RANDOM", waitTime);
                break;
            case 8:
                surprises = new GiveSurpriseAndSing("LIFO", waitTime);
                break;
            case 9:
                surprises = new GiveSurpriseAndSing("FIFO", waitTime);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }

        System.out.println(surprises);
        System.out.println("A new list of type " + typesOfSharing[option-1] + " has been created.\n");
        File file = new File("input_file.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line;

        while ((line = bufferedReader.readLine()) != null){
            switch (line){
                case "put":
                    System.out.println("Select type of object do you want to insert?\n\t" + "1. \"A new surprise\"\n\t"
                            + "2. \"A bag of surprise\"\n\t ");
                    String addOption = bufferedReader.readLine();
                    if(addOption.equals("1")){
                        ISurprise surprise = gather();
                        surprises.put(surprise);
                    }
                    else if(addOption.equals("2")){
                        System.out.println("Enter type of bag:\n");
                        String type = bufferedReader.readLine();
                        System.out.println(type + "\n");
                        IBag bag = factory.makeBag(type);
                        System.out.println("Enter the number of surprise to be put in the bag:\n");
                        String input = bufferedReader.readLine();
                        int noSurprises = Integer.parseInt(input);
                        System.out.println(noSurprises +"\n");
                        ISurprise[] iSurprises = gather(noSurprises);
                        for(ISurprise s: iSurprises){
                            bag.put(s);
                        }
                        // Highlight the surprises in the bag you add
                        System.out.println("The bag you added is:\n");
                        System.out.println(bag + "\n");
                        surprises.put(bag);
                        // Highlight the way that surprises from the created bag were added to your bag of surprises
                        System.out.println("Your current bag is " + surprises + "\n");
                    }
                    break;
                case "give":
                    System.out.println("A surprise is given to a child!\n");
                    surprises.give();
                    break;
                case "giveAll":
                    System.out.println("Party! All surprises are given!\n");
                    surprises.giveAll();
                    break;
                case "empty":
                    System.out.println("Bag of surprise is: " + (surprises.isEmpty() ? "empty\n" : "not empty\n"));
                    break;
            }
        }
    }
}
