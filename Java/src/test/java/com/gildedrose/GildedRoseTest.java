package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class GildedRoseTest {
    Item[] items;
    private GildedRose gildedRose;

    /*
     * Initializing items and GildedRose class*/
    @BeforeEach
    void setUp() {
        items = new Item[]{new Item(GildedRose.AGED_BRIE, 10, 10),
            new Item(GildedRose.SULFURAS, 15, 11),
            new Item(GildedRose.CONJURED, 12, 13),
            new Item(GildedRose.BACKSTAGE_PASSES, 3, 11),
            new Item("Notebook", 12, 13)};
        gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
    }

    /*
     * Test case: testing item name.
     */
    @Test
    public void testUpdateQualityName() {
        assertEquals("Aged Brie", gildedRose.items[0].name);
    }

    /*
     * Test case: testing toString method item class.
     */
    @Test
    public void testUpdateQualityNameItem() {
        assertEquals("Aged Brie, 9, 11", gildedRose.items[0].toString());
    }

    /*
     * Test case: sellin value decreases for item aged brie.
     * Test input for sellin Value of item aged brie: 10
     * Expected result : 9 */

    @Test
    public void testUpdateQualitySellIn() {
        assertEquals(9, gildedRose.items[0].sellIn);
    }

    /*
     * Test case: Item aged brie increases in Quality as its SellIn value approaches.
     * Test input for quality of item aged brie: 10
     * Expected result : 11 */
    @Test
    public void testUpdateQuality() {
        assertEquals(11, gildedRose.items[0].quality);
    }

    /*
     * Test case: Item salfuras quality never get decreases.
     * Test input for quality of item sulfras: 11
     * Expected result: 11*/
    @Test
    public void testUpdateQualitySulfras() {
        assertEquals(11, gildedRose.items[1].quality);
        assertNotEquals(10, gildedRose.items[1].quality);

    }

    /*
     * Test case: Item Conjured degrade in Quality twice.
     * Test input for quality of item conjured: 13
     * Expected result: 11*/
    @Test
    public void testUpdateQualityConjured() {
        assertEquals(11, gildedRose.items[2].quality);
    }

    /*
     * Test case: The Quality of an item is never more than 50*/
    @Test
    public void testUpdateQualityAllItems() {
        Item[] newItems = new Item[]{new Item(GildedRose.AGED_BRIE, 10, 50),
            new Item(GildedRose.SULFURAS, 15, 50),
            new Item(GildedRose.CONJURED, 12, 50),
            new Item(GildedRose.BACKSTAGE_PASSES, 0, 50)};
        GildedRose gildedRose1 = new GildedRose(newItems);
        gildedRose1.updateQuality();

        assertEquals(50, gildedRose1.items[0].quality);
        assertEquals(50, gildedRose1.items[1].quality);
        assertEquals(48, gildedRose1.items[2].quality);
        assertEquals(50, gildedRose1.items[3].quality);
    }

    /*
     * Test case: Normal Item degrade in Quality once.
     * Test input for quality of Normal item: 11
     * Expected result: 10*/
    @Test
    public void testUpdateQualityNormalItem() {
        assertEquals(12, gildedRose.items[4].quality);
    }
}
