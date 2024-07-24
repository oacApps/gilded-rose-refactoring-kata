package com.mmr.gildedrose.quality;

import com.mmr.gildedrose.Item;

public class Conjured implements QualityControl{

    private static final int QUALITY_DROP_CONJURED = QUALITY_DROP_DEFAULT * 2;


    @Override
    public void updateQuality(Item item) {
        item.setQuality(item.getQuality() - qualityDrop(item));
    }

    private int qualityDrop(Item item) {
        return item.getQuality() - QUALITY_DROP_CONJURED > 0
            ? QUALITY_DROP_CONJURED
            : item.getQuality();

    }
}
