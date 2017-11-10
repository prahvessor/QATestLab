package com.qatestlab.alcoholic;

import com.qatestlab.Liquid;

public class Alcoholic extends Liquid{
    private aType type;
    private double strength;

    public Alcoholic() {
    }

    public Alcoholic(String nextLine) {

        final String WORDS_SEPARATOR = ";";
        String[] words = nextLine.split(WORDS_SEPARATOR);

        super.setName(words[0]);
        super.setPurchasePrice(Double.parseDouble(words[1]));

        switch (words[2]) {
            case "VINE":
                this.type = aType.VINE;
                break;
            case "STRONG":
                this.type = aType.STRONG;
                break;
            case "BEER":
                this.type = aType.BEER;
                break;
            case "LIQUOR":
                this.type = aType.LIQUOR;
                break;
        }

        super.setVolume(Double.parseDouble(words[3]));
        this.strength = Double.parseDouble(words[4]);
        super.setAvailability(Integer.parseInt(words[5]));
    }

    @Override
    public String toString() {
        return "" + super.getName() + ";" + super.getPurchasePrice() + ";" + type + ";" + super.getVolume() + ";" + strength + ";" + super.getAvailability();
    }


    //   ---- getters&setters

    public int getSaled() {
        return super.getSaled();
    }

    public void setSaled(int saled) {
        super.setSaled(saled);
    }

    public int getPurchased() {
        return super.getPurchased();
    }

    public void setPurchased(int purchased) {
        super.setPurchased(purchased);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public double getPurchasePrice() {
        return super.getPurchasePrice();
    }

    public void setPurchasePrice(double purchasePrice) {
        super.setPurchasePrice(purchasePrice);
    }

    public aType getType() {
        return type;
    }

    public void setType(aType type) {
        this.type = type;
    }

    public double getVolume() {
        return super.getVolume();
    }

    public void setVolume(double volume) {
        super.setVolume(volume);
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public int getAvailability() {
        return super.getAvailability();
    }

    public void setAvailability(int availability) {
        super.setAvailability(availability);
    }
}





//-----------------------------------------



//
//package com.qatestlab.alcoholic;
//
//        import com.qatestlab.Liquid;
//
//public class Alcoholic extends Liquid{
//    private String name;
//    private double purchasePrice;
//    private aType type;
//    private double volume;
//    private double strength;
//    private int availability;
//
//    private int saled;
//    private int purchased;
//
//    public Alcoholic() {
//    }
//
//    public Alcoholic(String nextLine) {
//
//        final String WORDS_SEPARATOR = ";";
//        String[] words = nextLine.split(WORDS_SEPARATOR);
//
//        this.name = words[0];
//        this.purchasePrice = Double.parseDouble(words[1]);
//
//        switch (words[2]) {
//            case "VINE":
//                this.type = aType.VINE;
//                break;
//            case "STRONG":
//                this.type = aType.STRONG;
//                break;
//            case "BEER":
//                this.type = aType.BEER;
//                break;
//            case "LIQUOR":
//                this.type = aType.LIQUOR;
//                break;
//        }
//
//        this.volume = Double.parseDouble(words[3]);
//        this.strength = Double.parseDouble(words[4]);
//        this.availability = Integer.parseInt(words[5]);
//    }
//
//    //   ---- getters&setters
//
//    public int getSaled() {
//        return saled;
//    }
//
//    public void setSaled(int saled) {
//        this.saled = saled;
//    }
//
//    public int getPurchased() {
//        return purchased;
//    }
//
//    public void setPurchased(int purchased) {
//        this.purchased = purchased;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPurchasePrice() {
//        return purchasePrice;
//    }
//
//    public void setPurchasePrice(double purchasePrice) {
//        this.purchasePrice = purchasePrice;
//    }
//
//    public aType getType() {
//        return type;
//    }
//
//    public void setType(aType type) {
//        this.type = type;
//    }
//
//    public double getVolume() {
//        return volume;
//    }
//
//    public void setVolume(double volume) {
//        this.volume = volume;
//    }
//
//    public double getStrength() {
//        return strength;
//    }
//
//    public void setStrength(double strength) {
//        this.strength = strength;
//    }
//
//    public int getAvailability() {
//        return availability;
//    }
//
//    public void setAvailability(int availability) {
//        this.availability = availability;
//    }
//}