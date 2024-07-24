package com.mmr.gildedrose.quality;

import com.mmr.gildedrose.Item;

public class Default implements QualityControl{
    @Override
    public void updateQuality(Item item) {
        item.setQuality(item.getQuality() - qualityDrop(item));
    }

    private int qualityDrop(Item item) {
        int defaultQualityDrop = qualityDropDefault(item);

        return item.getQuality() - defaultQualityDrop >= 0
            ? defaultQualityDrop
            : item.getQuality();
    }

    private int qualityDropDefault(Item item) {
        return item.getSellIn() < 0
            ? QUALITY_DROP_DEFAULT * 2
            : QUALITY_DROP_DEFAULT;
    }
}
