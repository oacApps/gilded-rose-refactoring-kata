package com.mmr.gildedrose.quality;

import com.mmr.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgedBrieTest {

    @Test
    void testUpdateQuality() {
        AgedBrie agedBrie = new AgedBrie();
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 2, 0);
        agedBrie.updateQuality(item);
        assertEquals(1, item.getQuality());
    }

    @Test
    void testUpdateQualityMaxQuality() {
        AgedBrie agedBrie = new AgedBrie();
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 2, 50);
        agedBrie.updateQuality(item);
        assertEquals(50, item.getQuality());
    }

    @Test
    void testUpdateQualitySellIn() {
        AgedBrie agedBrie = new AgedBrie();
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 2, 0);
        agedBrie.updateQuality(item);
        assertEquals(1, item.getQuality());
        assertEquals(2, item.getSellIn());
    }

    @Test
    void testUpdateQualitySellInNegative() {
        AgedBrie agedBrie = new AgedBrie();
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 0, 0);
        agedBrie.updateQuality(item);
        assertEquals(1, item.getQuality());
        assertEquals(0, item.getSellIn());
    }

    @Test
    void testUpdateQualityMaxQualitySellInNegative() {
        AgedBrie agedBrie = new AgedBrie();
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 0, 50);
        agedBrie.updateQuality(item);
        assertEquals(50, item.getQuality());
        assertEquals(0, item.getSellIn());
    }

    @Test
    void testUpdateQualityMaxQualitySellIn() {
        AgedBrie agedBrie = new AgedBrie();
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 2, 50);
        agedBrie.updateQuality(item);
        assertEquals(50, item.getQuality());
        assertEquals(2, item.getSellIn());
    }

    @Test
    void testUpdateQualityMaxQualitySellInNegative2() {
        AgedBrie agedBrie = new AgedBrie();
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 0, 50);
        agedBrie.updateQuality(item);
        assertEquals(50, item.getQuality());
        assertEquals(0, item.getSellIn());
    }

}