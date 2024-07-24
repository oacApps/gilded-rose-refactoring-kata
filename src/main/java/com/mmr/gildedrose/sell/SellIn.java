package com.mmr.gildedrose.sell;

import com.mmr.gildedrose.Item;
import com.mmr.gildedrose.quality.ItemEnum;

public class SellIn {
    private static final int DEFAULT_DECREASE = 1;
    private static final int NO_DECREASE = 0;

    public static void updateSellIn(Item item) {
        item.setSellIn(item.getSellIn() - decreaseSellIn(item));
    }

    private static int decreaseSellIn(Item item) {
        return ItemEnum.SULFURAS.getItemName().equals(item.getName()) ? NO_DECREASE : DEFAULT_DECREASE;
    }
}
