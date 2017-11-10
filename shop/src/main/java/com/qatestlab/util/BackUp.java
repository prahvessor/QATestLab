package com.qatestlab.util;

import com.qatestlab.Beverage;
import com.qatestlab.alcoholic.Alcoholic;
import com.qatestlab.nonalcoholic.NonAlcoholic;

import java.io.FileWriter;
import java.io.IOException;

public class BackUp {
    public void makeBackUp(Beverage beverage, String alcohol, String nonAlcohol) {

        // бэкап алкогольных напитков в файл бд
        try(FileWriter writerTipples = new FileWriter(alcohol, false))
        {

            for (Alcoholic alc: beverage.getTipple()) {
                writerTipples.write(alc.toString() + "\n");
            }

            writerTipples.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        // бэкап безалкогольных напитков в файл бд
        try(FileWriter writerDrinks = new FileWriter(nonAlcohol, false))
        {

            for (NonAlcoholic nonAlc: beverage.getDrink()) {
                writerDrinks.write(nonAlc.toString() + "\n");
            }

            writerDrinks.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }
}
