package com.mmr.gildedrose.quality;

import com.mmr.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DefaultTest {

    @Test
    void testUpdateQuality() {
        Default defaultItem = new Default();
        Item item = new Item(ItemEnum.DEFAULT.getItemName(), 2, 0);
        defaultItem.updateQuality(item);
        assertEquals(0, item.getQuality());
    }

    @Test
    void testUpdateQualityMaxQuality() {
        Default defaultItem = new Default();
        Item item = new Item(ItemEnum.DEFAULT.getItemName(), 2, 50);
        defaultItem.updateQuality(item);
        assertEquals(49, item.getQuality());
    }

    @Test
    void testUpdateQualitySellIn() {
        Default defaultItem = new Default();
        Item item = new Item(ItemEnum.DEFAULT.getItemName(), 2, 0);
        defaultItem.updateQuality(item);
        assertEquals(0, item.getQuality());
        assertEquals(2, item.getSellIn());
    }

    @Test
    void testUpdateQualitySellInNegative() {
        Default defaultItem = new Default();
        Item item = new Item(ItemEnum.DEFAULT.getItemName(), 0, 0);
        defaultItem.updateQuality(item);
        assertEquals(0, item.getQuality());
        assertEquals(0, item.getSellIn());
    }

    @Test
    void testUpdateQualityMaxQualitySellInNegative() {
        Default defaultItem = new Default();
        Item item = new Item(ItemEnum.DEFAULT.getItemName(), 0, 50);
        defaultItem.updateQuality(item);
        assertEquals(49, item.getQuality());
        assertEquals(0, item.getSellIn());
    }

    @Test
    void testUpdateQualityMaxQualitySellIn() {
        Default defaultItem = new Default();
        Item item = new Item(ItemEnum.DEFAULT.getItemName(), 2, 50);
        defaultItem.updateQuality(item);
        assertEquals(49, item.getQuality());
        assertEquals(2, item.getSellIn());
    }

}