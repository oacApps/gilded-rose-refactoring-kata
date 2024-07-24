package com.mmr.gildedrose.sell;

import com.mmr.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SellInTest {

    @Test
    void testUpdateSellIn() {
        SellIn sellIn = new SellIn();
        Item item = new Item("Any", 2, 0);
        sellIn.updateSellIn(item);
        assertEquals(1, item.getSellIn());
    }

    @Test
    void testUpdateSellInMaxQuality() {
        SellIn sellIn = new SellIn();
        Item item = new Item("Any", 2, 50);
        sellIn.updateSellIn(item);
        assertEquals(1, item.getSellIn());
    }

    @Test
    void testUpdateSellInSellIn() {
        SellIn sellIn = new SellIn();
        Item item = new Item("Any", 2, 0);
        sellIn.updateSellIn(item);
        assertEquals(1, item.getSellIn());
        assertEquals(0, item.getQuality());
    }

    @Test
    void testUpdateSellInSellInNegative() {
        SellIn sellIn = new SellIn();
        Item item = new Item("Any", 0, 0);
        sellIn.updateSellIn(item);
        assertEquals(-1, item.getSellIn());
        assertEquals(0, item.getQuality());
    }

    @Test
    void testUpdateSellInMaxQualitySellInNegative() {
        SellIn sellIn = new SellIn();
        Item item = new Item("Any", 0, 50);
        sellIn.updateSellIn(item);
        assertEquals(-1, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

    @Test
    void testUpdateSellInMaxQualitySellIn() {
        SellIn sellIn = new SellIn();
        Item item = new Item("Any", 2, 50);
        sellIn.updateSellIn(item);
        assertEquals(1, item.getSellIn());
        assertEquals(50, item.getQuality());
    }

}