package Java_HA7;

public class umliegendeFelder
{
	int[] posVonZahl;
	int[] temp = new int[4]; // int[] temp= (links,rechts,oben,unten)
	int[][] feld;

	public umliegendeFelder(int[] pos, int[][] feld)
	{
		this.posVonZahl = pos;
		this.feld = feld;
	}

	public int[] getFelder()
	{
		getLinkesFeld();
		getRechtesFeld();
		getOberesFeld();
		getUnteresFeld();
		return temp;
	}

	/**
	 * Gets the number that is on the left side of the position
	 */
	public void getLinkesFeld()
	{
		try
		{
			temp[0] = feld[posVonZahl[0]][posVonZahl[1] - 1];
		} catch (Exception e)
		{
			temp[0] = -1;
		}
	}

	/**
	 * Gets the number that is on the right side of the position
	 */
	public void getRechtesFeld()
	{
		try
		{
			temp[1] = feld[posVonZahl[0]][posVonZahl[1] + 1];
		} catch (Exception e)
		{
			temp[1] = -1;
		}
	}

	/**
	 * Gets the number that is above of the position
	 */
	public void getOberesFeld()
	{
		try
		{
			temp[2] = feld[posVonZahl[0] - 1][posVonZahl[1]];
		} catch (Exception e)
		{
			temp[2] = -1;
		}
	}

	/**
	 * Gets the number that is under the position
	 */
	public void getUnteresFeld()
	{
		try
		{
			temp[3] = feld[posVonZahl[0] + 1][posVonZahl[1]];
		} catch (Exception e)
		{
			temp[3] = -1;
		}
	}

}
