package com.mmr.gildedrose;

import com.mmr.gildedrose.quality.ItemEnum;
import com.mmr.gildedrose.quality.QualityFactory;
import com.mmr.gildedrose.sell.SellIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GRTest {

    QualityFactory qualityFactory;
    SellIn sellIn;

    @BeforeEach
    void setUp() {
        qualityFactory = new QualityFactory();
        sellIn = new SellIn();
    }


    @Test
    void standardItem_quality_decreases_sellin_decreases_each_day() {
        int startingSellin = 5;
        int startingQuality = 7;
        final Item standardItem = new Item(ItemEnum.DEFAULT.getItemName(), startingSellin, startingQuality);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(standardItem));

        assertThat(standardItem.sellIn).isEqualTo(startingSellin - 1);
        assertThat(standardItem.quality).isEqualTo(startingQuality - 1);
    }

    @Test
    void multiple_items_degrade_each_day() {

        Item firstItem = new Item(ItemEnum.DEFAULT.getItemName()+"1", 5, 4);
        Item secondItem = new Item(ItemEnum.DEFAULT.getItemName()+"2", 3, 2);

        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(firstItem, secondItem));

        assertThat(firstItem.sellIn).isEqualTo(4);
        assertThat(firstItem.quality).isEqualTo(3);
        assertThat(secondItem.sellIn).isEqualTo(2);
        assertThat(secondItem.quality).isEqualTo(1);
    }

    @Test
    void item_quality_degrades_twice_as_fast_past_sellin_date() {
        Item item = new Item(ItemEnum.DEFAULT.getItemName(), -1, 4);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(2);
    }

    @Test
    void item_quality_degrades_by_one_with_1_day_left() {
        Item item = new Item(ItemEnum.DEFAULT.getItemName(), 1, 4);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(3);
    }

    @Test
    void item_quality_degrades_down_to_0() {
        Item item = new Item(ItemEnum.DEFAULT.getItemName(), 4, 1);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isZero();
    }

    @Test
    void item_quality_is_never_negative() {
        Item item = new Item(ItemEnum.DEFAULT.getItemName(), 4, 0);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isZero();
    }

    @Test
    void aged_items_increase_in_quality_over_time() {
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 5, 6);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    void aged_item_quality_49_increases_up_to_50() {
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 5, 49);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void quality_of_an_item_is_never_greater_than_50() {
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 5, 50);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void aged_item_quality_50_past_sellin_date_does_not_increase() {
        Item item = new Item(ItemEnum.AGED_BRIE.getItemName(), 0, 50);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void legendary_items_never_have_to_be_sold() {
        Item item = new Item(ItemEnum.SULFURAS.getItemName(), -1, 80);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.sellIn).isEqualTo(-1);
    }

    @Test
    void legendary_items_never_decrease_in_quality() {
        Item item = new Item(ItemEnum.SULFURAS.getItemName(), -1, 80);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(80);
    }

    @Test
    void backstage_passes_increase_in_quality_as_sellIn_date_approaches() {
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 15, 20);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(21);
    }

    @Test
    void backstage_passes_increase_in_quality_by_1_when_there_are_10_days_or_less() {
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 11, 48);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));
        assertThat(item.quality).isEqualTo(49);
    }

    @Test
    void backstage_passes_increase_in_quality_by_2_when_there_are_10_days_or_less() {
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 10, 20);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(22);
    }

    @Test
    void backstage_passes_quality_49_increase_up_to_50_when_there_are_10_days_or_less() {
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 10, 49);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void backstage_passes_increase_in_quality_by_2_when_there_are_6_days_or_less() {
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 6, 46);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(48);
    }

    @Test
    void backstage_passes_increase_in_quality_by_3_when_there_are_5_days_or_less() {
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 5, 20);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(23);
    }

    @Test
    void backstage_passes_quality_47_increase_up_to_50_when_there_are_5_days_or_less() {
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 5, 47);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void backstage_passes_quality_49_increase_up_to_50_when_there_are_5_days_or_less() {
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 5, 49);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void backstage_passes_quality_is_0_after_concert() {
        Item item = new Item(ItemEnum.BACKSTAGE_PASS.getItemName(), 0, 20);
        GildedRose subject = new GildedRose(qualityFactory, sellIn);

        subject.updateQuality(Arrays.asList(item));

        assertThat(item.quality).isZero();
    }
}