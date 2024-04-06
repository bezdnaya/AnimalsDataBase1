package org.example;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileWriter;

import static org.example.Main.iScanner;

public abstract class Animals {
    static int i = 1;
    int id;
    String type;
    String Name;
    Date BirthDate;
    String Commands;


    public Animals(int id, String Name, Date BirthDate, String Commands){
        this.id = id;
        this.Name = Name;
        this.BirthDate = BirthDate;
        this.Commands = Commands;
        i++;

    }
    public static Animals newAnimal (int i) throws ParseException {
        System.out.println("Input which animal do you want to add");
        String type = iScanner.nextLine().toLowerCase();
        System.out.println("Input animal's name");
        String name = iScanner.nextLine();
        System.out.println("Input it's birthday like 2020-01-01");
        String BirthDate1 = iScanner.nextLine();;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date BirthDate = dateFormat.parse(BirthDate1);
        System.out.println("Input what commands does it execute");
        String Commands = iScanner.nextLine();
        Animals result;
        result = new Cat();
        switch (type){
            case "dog": Dog result = new Dog(i, name, BirthDate, Commands);
                break;
            case "hamster": Hamster result = new Hamster(i, name, BirthDate, Commands);
                break;
            case "horse": Horse result = new Horse(i, name, BirthDate, Commands);
                break;
            case "camel": Camel result = new Camel(i, name, BirthDate, Commands);
                break;
            case "donkey": Donkey result = new Donkey(i, name, BirthDate, Commands);
                break;
            case "cat": Cat result = new Cat(i, name, BirthDate, Commands);
                break;
            default:
                System.out.println("Sorry! You can't add this kind of animal");
                break;
        }
        return result;

    }

    public static void Writer (Animals animal) throws IOException {
        try {
            BufferedWriter writer= new BufferedWriter(new FileWriter("Animal registry", true));
            writer.write(animal.toString());
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return this.type + " " + this.id+ " " + this.Name + " " + dateFormat.format(this.BirthDate) + " "+ this.Commands;}

}


