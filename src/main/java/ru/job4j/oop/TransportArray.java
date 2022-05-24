package ru.job4j.oop;

public class TransportArray {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle airplane2 = new Airplane();
        Vehicle train = new Train();
        Vehicle train2 = new Train();
        Vehicle bus = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle[] vehicles = new Vehicle[]{airplane, train, bus, airplane2, train2, bus2};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
