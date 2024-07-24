package com.mmr.gildedrose.quality;

import java.util.HashMap;
import java.util.Map;

public class QualityFactory {

    private static final Map<String, QualityControl> QUALITY_MAP = new HashMap<>();

    static {
        QUALITY_MAP.put(ItemEnum.AGED_BRIE.getItemName(), new AgedBrie());
        QUALITY_MAP.put(ItemEnum.SULFURAS.getItemName(), new Sulfuras());
        QUALITY_MAP.put(ItemEnum.BACKSTAGE_PASS.getItemName(), new BackstagePass());
        QUALITY_MAP.put(ItemEnum.CONJURED.getItemName(), new Conjured());
    }

    public static QualityControl getQuality(String itemName) {
        return QUALITY_MAP.getOrDefault(itemName, new Default());
    }
}
