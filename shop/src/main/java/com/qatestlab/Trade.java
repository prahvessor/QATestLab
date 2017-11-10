package com.qatestlab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Trade {

    // скидка
    private double markup;

    // прибыль
    private double profit;

    // себестоимость
    private double primeCost;

    // сумма продаж
    private double salesAmount;

    public void doTrade(Beverage beverage) {

        tradeMonth(beverage);
    }

    public void tradeMonth(Beverage beverage) {
        System.out.println("Начало месяца");

        for (int day = 0; day < 30; day++) {
            tradeDay(beverage, day);
        }

        System.out.println("Конец месяца");
        System.out.println();
        System.out.printf("Прибыль: %.2f\n", salesAmount - primeCost);
        System.out.printf("Средства на дозакупку товара: %.2f\n", primeCost);
        System.out.println();

        for (Liquid liquid: beverage.getLiquids()) {
            //System.out.println(alc.toString());
            System.out.println(liquid.getName() + ": продано " + liquid.getSaled() + ", дозакуплено: " + liquid.getPurchased() +".");
        }
    }

    public void tradeDay(Beverage beverage, int day) {


        final int BEGIN_DAY = 8; //рабочий день с 8
        final int END_DAY = 21; // и до 21

        System.out.println("\tНачало " + (day + 1) + "-го дня");

        // ------
        for (int hour = BEGIN_DAY; hour < END_DAY; hour++) {

            tradeHour(beverage, day, hour);
        }

        System.out.println("\tКонец " + (day + 1) + "-го дня");

        // дозакупка в конце дня
        afterPurchase(beverage);
    }

    public void tradeHour(Beverage beverage, int day, int hour) {

        final int ZERO = 0; // Начальное значение диапазона - "от"
        final int ONE = 1; // Начальное значение диапазона - "от"
        final int TEN = 10; // Конечное значение диапазона - "до"

        int customer = getRandom(ONE, TEN + 1); // количество покупателей в час 1-10

        for (int i = 0; i < customer; i++) {

            int numberOfPurchases = getRandom(ZERO, beverage.getLiquids().size()+1); // количество покупок покупателя

            System.out.println("\t\t" + hour + " часов " + (i + 1)+ "-й покупатель: " );

            // список случайных товаров
            List<Liquid> listOfPurchases = new ArrayList<>(getRandomList(numberOfPurchases, beverage.getLiquids()));

            for (Liquid liquid: listOfPurchases) {

                // случайное количество товаров
                int numberOfItems = getRandom(ZERO, TEN);

                // рассчет скидки
                markup = getMarkup(day, hour, numberOfItems);

                // если количество штук меньше чем есть в наличии, то забирает все что осталось
                if (liquid.getAvailability() < numberOfItems) {
                    numberOfItems = liquid.getAvailability();
                }

                System.out.println("\t\t\t" + liquid.getName() + ": " + liquid.getAvailability() + " в наличии; " + " " + numberOfItems + " штук; " + markup + " наценка");

                if (liquid.getAvailability() > 0) {

                    salesAmount += liquid.getPurchasePrice() * numberOfItems * markup;
                    primeCost += liquid.getPurchasePrice() * numberOfItems;

                    liquid.setSaled(liquid.getSaled() + numberOfItems);
                    liquid.setAvailability(liquid.getAvailability() - numberOfItems);
                }
            }
        }
    }

    public void afterPurchase(Beverage beverage) {
        for (Liquid liquid: beverage.getLiquids()) {
            if (liquid.getAvailability() < 10) {
//                System.out.println(liquid.getName() + " " + liquid.getAvailability());
                liquid.setPurchased(liquid.getPurchased() + 150);
                liquid.setAvailability(liquid.getAvailability() + 150);
            }
        }
    }

    public double getMarkup(int i, int hour, int numberOfItems) {
        double markup = ((i % 7) < 5) ? 1.1: 1.15;

        if (hour > 17) {
            markup = 1.08;
        }
        if (numberOfItems > 1) {
            markup = 1.07;
        }
        return markup;
    }
    public int getRandom(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max);

    }

    public ArrayList<Liquid> getRandomList(final int amount, final List<Liquid> list) {

        ArrayList<Liquid> returnList = new ArrayList<>(list);
        Collections.shuffle(returnList);
        if (returnList.size() > amount) {
            // тут отрезаем не нужную часть
            returnList.subList(amount, returnList.size()).clear();}

            return returnList;
    }

    public double getPrimeCost() {
        return primeCost;
    }

    public double getSalesAmount() {
        return salesAmount;
    }
}
