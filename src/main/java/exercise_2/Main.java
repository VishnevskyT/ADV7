package exercise_2;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal("Cat", 5, "Juice");
        File file = new File("C:\\Users\\LapTopUSA\\IdeaProjects\\ADV7\\src\\main\\java\\exercise_2\\Animal.txt");

        System.out.println("Вихідний екземпляр класу до серіалізації: " + animal);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            outputStream.writeObject(animal);

            animal = (Animal) inputStream.readObject();

            System.out.println("Екземпляр класу після десеріалізації: " + animal);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
