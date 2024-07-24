package com.mmr.gildedrose;

import com.mmr.gildedrose.quality.QualityFactory;
import com.mmr.gildedrose.sell.SellIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class GildedRoseTest extends TestData{

    @Mock
    private QualityFactory qualityFactory;

    @Mock
    private SellIn sellIn;

    @InjectMocks
    private GildedRose gildedRose;

    @BeforeEach
    void setUp() {
        gildedRose = new GildedRose(qualityFactory, sellIn);
    }

    @Test
    void testSuccess() {;
        List<Item> items = itemList();
        gildedRose.updateQuality(items);

        // Default
        assertEquals(19, items.get(0).getQuality());
        assertEquals(9, items.get(0).getSellIn());

        // Aged Brie
        assertEquals(1, items.get(1).getQuality());
        assertEquals(1, items.get(1).getSellIn());

        // Default
        assertEquals(6, items.get(2).getQuality());
        assertEquals(4, items.get(2).getSellIn());

        // Sulfuras
        assertEquals(80, items.get(3).getQuality());
        assertEquals(0, items.get(3).getSellIn());

        // Sulfuras
        assertEquals(80, items.get(4).getQuality());
        assertEquals(-1, items.get(4).getSellIn());

        // Backstage passes
        assertEquals(21, items.get(5).getQuality());
        assertEquals(14, items.get(5).getSellIn());

        // Backstage passes
        assertEquals(50, items.get(6).getQuality());
        assertEquals(9, items.get(6).getSellIn());

        // Backstage passes
        assertEquals(50, items.get(7).getQuality());
        assertEquals(4, items.get(7).getSellIn());

        // Conjured
        assertEquals(4, items.get(8).getQuality());
        assertEquals(2, items.get(8).getSellIn());
    }

}