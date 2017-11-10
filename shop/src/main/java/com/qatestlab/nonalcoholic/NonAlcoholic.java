package com.qatestlab.nonalcoholic;

import com.qatestlab.Liquid;

public class NonAlcoholic extends Liquid{
    private naType type;
    private String composition;

    public NonAlcoholic() {
    }

    public NonAlcoholic(String nextLine) {

        final String WORDS_SEPARATOR = ";";
        String[] words = nextLine.split(WORDS_SEPARATOR);

        super.setName(words[0]);
        super.setPurchasePrice(Double.parseDouble(words[1]));

        switch (words[2]) {
            case "MINERAL":
                this.type = naType.MINERAL;
                break;
            case "JUICE":
                this.type = naType.JUICE;
                break;
            case "OTHERDRINKS":
                this.type = naType.OTHERDRINKS;
                break;
        }

        super.setVolume(Double.parseDouble(words[3]));
        this.composition = words[4];
        super.setAvailability(Integer.parseInt(words[5]));
    }

    @Override
    public String toString() {
        return "" + super.getName() + ";" + super.getPurchasePrice() + ";" + type + ";" + super.getVolume() + ";" + composition + ";" + super.getAvailability();
    }
    // getters and setters

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

    public naType getType() {
        return type;
    }

    public void setType(naType type) {
        this.type = type;
    }

    public double getVolume() {
        return super.getVolume();
    }

    public void setVolume(double volume) {
        super.setVolume(volume);
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public int getAvailability() {
        return super.getAvailability();
    }

    public void setAvailability(int availability) {
        super.setAvailability(availability);
    }

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
}
