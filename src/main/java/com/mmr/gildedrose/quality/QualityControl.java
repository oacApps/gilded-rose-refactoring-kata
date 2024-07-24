package com.mmr.gildedrose.quality;

import com.mmr.gildedrose.Item;

public interface QualityControl {

    int MAX_QUALITY = 50;
    int QUALITY_HIKE_DEFAULT = 1;
    int QUALITY_DROP_DEFAULT = 1;

    void updateQuality(Item item);
}
