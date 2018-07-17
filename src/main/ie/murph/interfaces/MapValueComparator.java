package main.ie.murph.interfaces;

import java.util.Comparator;
import java.util.Map;

public class MapValueComparator implements Comparator<String> 
{
	private Map<String, Integer> m_baseLocaleMap;
	public MapValueComparator(Map<String, Integer> baseMapDataPassedIn)
	{
		m_baseLocaleMap = baseMapDataPassedIn;
	}
	
	@Override
	public int compare(String comparableData1, String comparableData2) 
	{
		//Arranging the data in order from the Map value instead of the Maps key as is by default
		if(m_baseLocaleMap.get(comparableData1) >= m_baseLocaleMap.get(comparableData2))
		{
			return -1;
		}
		else
		{
			return 1; 
		} // return 0 would merge keys
	}
}
