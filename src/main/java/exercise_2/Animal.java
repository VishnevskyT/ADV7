package exercise_2;

import java.io.Serializable;
import java.util.Objects;

/**
 * @вихідні умови:
 * Завдання 2
 * Необхідно здійснити десеріалізацію з файлу попереднього проекту (Animal) та вивести на екран вміст.
 *
 * @додаткові умови:
 * Задание
 * Создайте класс Animal
 * Опишите в нем 3 различных поля, создайте конструктор, методы.
 * Создайте файл и выполните сериализацию объекта Animal.
 *
 * @author Vishnevsky
 * @version 1.0 beta
 * @since Jan 2023
 */

public class Animal implements Serializable {

    private String type;
    private int age;
    private String name;

    public Animal() {
    }

    public Animal(String type, int age, String name) {
        this.type = type;
        this.age = age;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(type, animal.type) && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, age, name);
    }
}
