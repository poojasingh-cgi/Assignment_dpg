package com.gildedrose;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";


    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item); //Method to update Item quality.
            handleSellIn(item); //Method to deal with sellin value of Item.
        }
    }

    private void updateItemQuality(Item item) {
        if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES)) {
            if (item.quality > 0) {
                degradeQuality(item);
            }
        } else {
            increaseQuality(item);
            handleQuality(item);
        }
    }

    private void handleSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
        handleExpiredItems(item);
    }

    private void handleQuality(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES)) {
            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
    }

    private void handleExpiredItems(Item item) {
        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality > 0) {
                    degradeQuality(item);
                } else {
                    item.quality = 0;
                }
            } else {
                increaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void degradeQuality(Item item) {
        if (!item.name.equals(SULFURAS)) {
            decreaseQuality(item);
        }
        if (item.name.equals(CONJURED)) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }
}


