package com.mmr.gildedrose.quality;


import com.mmr.gildedrose.Item;

import static java.lang.Math.min;

public class BackstagePass implements QualityControl{

    private static final int QUALITY_HIKE_ZERO = 0;
    private static final int QUALITY_HIKE = 1;
    private static final int QUALITY_HIKE_DOUBLE = 2;

    private static final int DAYS_ELEVEN = 11;
    private static final int DAYS_FIVE = 5;


    @Override
    public void updateQuality(Item item) {
        item.setQuality(newQuality(item));
    }

    private int newQuality(Item item) {
        return item.getSellIn() > 0
            ? min(item.getQuality() + qualityHike(item), MAX_QUALITY)
            : 0;
    }

    private int qualityHike(Item item) {
        return QUALITY_HIKE_DEFAULT + qualityHikeExtra(item);
    }

    private int qualityHikeExtra(Item item) {
        if (isConcertWithinSixAndTenDays(item)) {
            return QUALITY_HIKE;
        } else if (isConcertInFiveOrLessDays(item)) {
            return QUALITY_HIKE_DOUBLE;
        }
        return QUALITY_HIKE_ZERO;
    }

    private boolean isConcertInFiveOrLessDays(Item item) {
        return item.getSellIn() <= DAYS_FIVE;
    }

    private boolean isConcertWithinSixAndTenDays(Item item) {
        return item.getSellIn() > DAYS_FIVE && item.getSellIn() < DAYS_ELEVEN;
    }
}
