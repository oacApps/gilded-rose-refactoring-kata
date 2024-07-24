package com.mmr.gildedrose.quality;

import com.mmr.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConjuredTest {

    @Test
    void testUpdateQuality() {
        Conjured conjured = new Conjured();
        Item item = new Item(ItemEnum.CONJURED.getItemName(), 2, 0);
        conjured.updateQuality(item);
        assertEquals(0, item.getQuality());
    }

    @Test
    void testUpdateQualityMaxQuality() {
        Conjured conjured = new Conjured();
        Item item = new Item(ItemEnum.CONJURED.getItemName(), 2, 50);
        conjured.updateQuality(item);
        assertEquals(48, item.getQuality());
    }

    @Test
    void testUpdateQualitySellIn() {
        Conjured conjured = new Conjured();
        Item item = new Item(ItemEnum.CONJURED.getItemName(), 2, 0);
        conjured.updateQuality(item);
        assertEquals(0, item.getQuality());
        assertEquals(2, item.getSellIn());
    }

    @Test
    void testUpdateQualitySellInNegative() {
        Conjured conjured = new Conjured();
        Item item = new Item(ItemEnum.CONJURED.getItemName(), 0, 0);
        conjured.updateQuality(item);
        assertEquals(0, item.getQuality());
        assertEquals(0, item.getSellIn());
    }

    @Test
    void testUpdateQualityMaxQualitySellInNegative() {
        Conjured conjured = new Conjured();
        Item item = new Item(ItemEnum.CONJURED.getItemName(), 0, 50);
        conjured.updateQuality(item);
        assertEquals(48, item.getQuality());
        assertEquals(0, item.getSellIn());
    }

    @Test
    void testUpdateQualityMaxQualitySellIn() {
        Conjured conjured = new Conjured();
        Item item = new Item(ItemEnum.CONJURED.getItemName(), 2, 50);
        conjured.updateQuality(item);
        assertEquals(48, item.getQuality());
        assertEquals(2, item.getSellIn());
    }

}