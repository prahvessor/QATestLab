package com.qatestlab;

import com.qatestlab.util.BackUp;
import com.qatestlab.util.FileOperator;
import com.qatestlab.util.Reporter;

public class App {
    public static void main( String[] args )    {

        final String ALCOHOL_LIST = "src\\main\\java\\com\\qatestlab\\resources\\alcoholic.csv";
        final String NONALCOHOL_LIST = "src\\main\\java\\com\\qatestlab\\resources\\nonalcoholic.csv";

        System.out.println("Program started\n");

        // создаем списки товаров из файла бд
        FileOperator alcoholFile = new FileOperator(ALCOHOL_LIST);
        FileOperator nonAlcoholFile = new FileOperator(NONALCOHOL_LIST);

        // создаем списки объектов и общий список
        Beverage beverage = new Beverage(alcoholFile.getListOfLines(), nonAlcoholFile.getListOfLines());

        // запускаем цикл торговли
        Trade trade = new Trade();
        trade.doTrade(beverage);

        // создание отчета
        Reporter reporter = new Reporter();
        reporter.makeReport(beverage, trade.getPrimeCost(), trade.getSalesAmount());

        // back-up
        BackUp backUp = new BackUp();
        backUp.makeBackUp(beverage, ALCOHOL_LIST, NONALCOHOL_LIST);

        System.out.println("\nExecution completed");
    }
}
