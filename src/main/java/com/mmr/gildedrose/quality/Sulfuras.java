package com.mmr.gildedrose.quality;

import com.mmr.gildedrose.Item;

public class Sulfuras implements QualityControl{


    /* Do Nothing as "Sulfuras", being a legendary item, never has to be sold or decreases in Quality*/
    @Override
    public void updateQuality(Item item) {

    }
}
