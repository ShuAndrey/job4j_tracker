package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Поехали!");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров " + count);
    }

    @Override
    public int refuel(int fuel) {
        int price = 70;
        return price * fuel;
    }
}
