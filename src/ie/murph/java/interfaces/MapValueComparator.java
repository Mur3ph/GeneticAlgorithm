package ie.murph.java.interfaces;

import java.util.Comparator;
import java.util.Map;

public class MapValueComparator implements Comparator<String> 
{
	Map<String, Integer> m_baseLocaleMap;
	public MapValueComparator(Map<String, Integer> baseMapPassedIn)
	{
		m_baseLocaleMap = baseMapPassedIn;
	}
	
	@Override
	public int compare(String comparableData1, String comparableData2) 
	{
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
