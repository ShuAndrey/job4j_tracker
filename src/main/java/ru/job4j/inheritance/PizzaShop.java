package ru.job4j.inheritance;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        PizzaExtraCheese extraCheese = new PizzaExtraCheese();
        PizzaExtraCheeseExtraTomato extraCheeseExtraTomato = new PizzaExtraCheeseExtraTomato();
        System.out.println(pizza.name());
        System.out.println(extraCheese.name());
        System.out.println(extraCheeseExtraTomato.name());
    }
}