package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	public static final int MIN_QUALITY = 0;
	public static final int MAX_QUALITY = 50;
	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateItemInStore();
	}
	/**The method make some modification on items in the store. 
	 * 
	 */
	public static void updateItemInStore()
	{
		for (int i = 0; i < items.size(); i++)
		{
			Item currentItem = items.get(i);
			if ((!"Aged Brie".equals(currentItem.getName()))
					&& !"Backstage passes to a TAFKAL80ETC concert".equals(currentItem.getName()))
			{
				lowQualityItem(currentItem);
			}
			else
			{
				if (currentItem.getQuality() < MAX_QUALITY)
				{
					currentItem.setQuality(currentItem.getQuality() + 1);

					if ("Backstage passes to a TAFKAL80ETC concert".equals(currentItem.getName()))
					{
						if (currentItem.getSellIn() < 11)
						{
							if (currentItem.getQuality() < MAX_QUALITY)
							{
								currentItem.setQuality(currentItem.getQuality() + 1);
							}
						}

						if (currentItem.getSellIn() < 6)
						{
							if (currentItem.getQuality() < MAX_QUALITY)
							{
								currentItem.setQuality(currentItem.getQuality() + 1);
							}
						}
					}
				}
			}

			if (!"Sulfuras, Hand of Ragnaros".equals(currentItem.getName()))
			{
				currentItem.setSellIn(currentItem.getSellIn() - 1);
			}

			if (currentItem.getSellIn() < 0)
			{
				if (!"Aged Brie".equals(currentItem.getName()))
				{
					if (!"Backstage passes to a TAFKAL80ETC concert".equals(currentItem.getName()))
					{
						lowQualityItem(currentItem);
					}
					else
					{
						currentItem.setQuality(currentItem.getQuality() - currentItem.getQuality());
					}
				}
				else
				{
					if (currentItem.getQuality() < MAX_QUALITY)
					{
						currentItem.setQuality(currentItem.getQuality() + 1);
					}
				}
			}
		}
	}
	private static void lowQualityItem(Item currentItem) {
		if (currentItem.getQuality() > MIN_QUALITY)
		{
			if (!"Sulfuras, Hand of Ragnaros".equals(currentItem.getName()))
			{
				currentItem.setQuality(currentItem.getQuality() - 1);
			}
		}
	}

}