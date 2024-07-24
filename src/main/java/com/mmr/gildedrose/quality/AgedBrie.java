package com.mmr.gildedrose.quality;

import com.mmr.gildedrose.Item;

import static java.lang.Integer.min;

public class AgedBrie implements QualityControl {
    @Override
    public void updateQuality(Item item) {
        item.setQuality(min(item.getQuality() + QUALITY_HIKE_DEFAULT, MAX_QUALITY));
    }
}
