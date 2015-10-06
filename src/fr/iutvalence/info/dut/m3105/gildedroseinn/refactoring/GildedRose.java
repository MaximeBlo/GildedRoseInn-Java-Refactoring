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
			int currentItemQuality = items.get(i).getQuality();
			if ((!"Aged Brie".equals(items.get(i).getName()))
					&& !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
			{
				if (currentItemQuality > MIN_QUALITY)
				{
					if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
					{
						items.get(i).setQuality(currentItemQuality - 1);
					}
				}
			}
			else
			{
				if (currentItemQuality < MAX_QUALITY)
				{
					items.get(i).setQuality(currentItemQuality + 1);

					if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
					{
						if (items.get(i).getSellIn() < 11)
						{
							if (currentItemQuality < MAX_QUALITY)
							{
								items.get(i).setQuality(currentItemQuality + 1);
							}
						}

						if (items.get(i).getSellIn() < 6)
						{
							if (currentItemQuality < MAX_QUALITY)
							{
								items.get(i).setQuality(currentItemQuality + 1);
							}
						}
					}
				}
			}

			if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
			{
				items.get(i).setSellIn(items.get(i).getSellIn() - 1);
			}

			if (items.get(i).getSellIn() < 0)
			{
				if (!"Aged Brie".equals(items.get(i).getName()))
				{
					if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
					{
						if (currentItemQuality > MIN_QUALITY)
						{
							if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
							{
								items.get(i).setQuality(currentItemQuality - 1);
							}
						}
					}
					else
					{
						items.get(i).setQuality(currentItemQuality - currentItemQuality);
					}
				}
				else
				{
					if (currentItemQuality < MAX_QUALITY)
					{
						items.get(i).setQuality(currentItemQuality + 1);
					}
				}
			}
		}
	}

}