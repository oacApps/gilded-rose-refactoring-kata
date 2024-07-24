package com.mmr.gildedrose;

import com.mmr.gildedrose.quality.QualityFactory;
import com.mmr.gildedrose.sell.SellIn;

import java.util.List;

class GildedRose {

    private QualityFactory qualityFactory;
    private SellIn sellIn;

    public GildedRose(QualityFactory qualityFactory, SellIn sellIn) {
        this.qualityFactory = qualityFactory;
        this.sellIn = sellIn;
    }

    public void updateQuality(List<Item> items) {
        for (Item item : items) {
            qualityFactory.getQuality(item.getName()).updateQuality(item);
            sellIn.updateSellIn(item);
        }
    }

}
