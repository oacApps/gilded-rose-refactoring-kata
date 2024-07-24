package com.mmr.gildedrose.quality;

public enum ItemEnum {

    BACKSTAGE_PASS ("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS ("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE ("Aged Brie"),
    CONJURED ("Conjured Mana Cake"),
    DEFAULT ("Default");

    private String itemName;

    ItemEnum(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
