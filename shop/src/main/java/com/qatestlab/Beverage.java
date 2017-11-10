package com.qatestlab;

import com.qatestlab.alcoholic.Alcoholic;
import com.qatestlab.nonalcoholic.NonAlcoholic;

import java.util.ArrayList;
import java.util.List;

public class Beverage {

    private List<Alcoholic> tipple = new ArrayList<>();
    private List<NonAlcoholic> drink = new ArrayList<>();

    // Общий список
    private List<Liquid> liquids = new ArrayList<>();

    public Beverage(List<String> listOfTipple, List<String> listOfDrinks) {

        int i = 0;
        for (String nextLine: listOfTipple) {
            tipple.add(i++, (new Alcoholic(nextLine)));
        }
        int j = 0;
        for (String nextLine: listOfDrinks) {
            drink.add(j++, (new NonAlcoholic(nextLine)));
        }

        liquids.addAll(tipple);
        liquids.addAll(drink);

//        for (Liquid nextLine: liquids) {
//            System.out.println(nextLine.getName());
//        }
    }

    public List<Alcoholic> getTipple() {
        return tipple;
    }

    public List<NonAlcoholic> getDrink() {
        return drink;
    }

    public List<Liquid> getLiquids() {
        return liquids;
    }
}
