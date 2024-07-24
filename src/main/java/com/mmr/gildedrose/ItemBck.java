package com.mmr.gildedrose;

public class ItemBck {

    public String name;

    public int sellIn;

    public int quality;

    public ItemBck(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}