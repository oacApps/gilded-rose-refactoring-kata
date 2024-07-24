package com.mmr.gildedrose.quality;

import com.mmr.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BackstagePassTest {

    @Test
    void testUpdateQuality() {
        BackstagePass backstagePass = new BackstagePass();
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 15, 20);
        backstagePass.updateQuality(item);
        assertEquals(21, item.getQuality());
    }

    @Test
    void testUpdateQualitySellIn() {
        BackstagePass backstagePass = new BackstagePass();
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 15, 20);
        backstagePass.updateQuality(item);
        assertEquals(21, item.getQuality());
        assertEquals(15, item.getSellIn());
    }

    @Test
    void testUpdateQualitySellInLessThanTen() {
        BackstagePass backstagePass = new BackstagePass();
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 10, 20);
        backstagePass.updateQuality(item);
        assertEquals(22, item.getQuality());
        assertEquals(10, item.getSellIn());
    }

    @Test
    void testUpdateQualitySellInLessThanFive() {
        BackstagePass backstagePass = new BackstagePass();
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 5, 20);
        backstagePass.updateQuality(item);
        assertEquals(23, item.getQuality());
        assertEquals(5, item.getSellIn());
    }

    @Test
    void testUpdateQualitySellInNegative() {
        BackstagePass backstagePass = new BackstagePass();
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 0, 20);
        backstagePass.updateQuality(item);
        assertEquals(0, item.getQuality());
        assertEquals(0, item.getSellIn());
    }

    @Test
    void testUpdateQualityMaxQuality() {
        BackstagePass backstagePass = new BackstagePass();
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 15, 50);
        backstagePass.updateQuality(item);
        assertEquals(50, item.getQuality());
    }

    @Test
    void testUpdateQualityMaxQualitySellInLessThanTen() {
        BackstagePass backstagePass = new BackstagePass();
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 10, 50);
        backstagePass.updateQuality(item);
        assertEquals(50, item.getQuality());
        assertEquals(10, item.getSellIn());
    }

}