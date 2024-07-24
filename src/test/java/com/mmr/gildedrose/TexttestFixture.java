package com.mmr.gildedrose;

import com.mmr.gildedrose.quality.QualityFactory;
import com.mmr.gildedrose.sell.SellIn;

import java.util.Arrays;
import java.util.List;

public class TexttestFixture {

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        List<Item> items = Arrays.asList(
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)
        );
        QualityFactory qualityFactory = new QualityFactory();
        SellIn sellIn = new SellIn();
        GildedRose app = new GildedRose(qualityFactory, sellIn);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality(items);
        }
    }
}