package com.qatestlab.util;

import com.qatestlab.Beverage;
import com.qatestlab.Liquid;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class Reporter {

    public void makeReport(Beverage beverage, double primeCost, double salesAmount) {

        final String PATTERN = "#0.00";

        String formattedProfit = new DecimalFormat(PATTERN).format(salesAmount - primeCost);
        final String profit = "Прибыль: " + formattedProfit + "\n";

        String formattedCost = new DecimalFormat(PATTERN).format(primeCost);
        final String cost = "Средства на дозакупку товара: " + formattedCost + "\n\n";

        try(FileWriter writer = new FileWriter("src\\main\\java\\com\\qatestlab\\resources\\report.txt", false))
        {
            writer.write(profit);
            writer.write(cost);

            for (Liquid liquid: beverage.getLiquids()) {
                writer.write("" + liquid.getName() + ": продано " + liquid.getSaled() + ", дозакуплено: " + liquid.getPurchased() +".\n");
            }

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}

