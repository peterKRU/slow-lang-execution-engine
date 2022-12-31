package execution_engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PseudoHeap {

	public static void printHeap(Map<Integer, Integer> heap) {
		
		Set<Integer> keySet = heap.keySet();
		keySet.forEach(element -> System.out.println("key: " + element + " value: " + heap.get(element)));
	}
	
	public static List<String> exportHeapContent(Map<Integer, Integer> heap) {
		
		List<String> heapContent = new ArrayList<String>();
		Set<Integer> keySet = heap.keySet();
		keySet.forEach(element -> heapContent.add(new String("id:" + element + ";"  + "value:" + heap.get(element) + ";")));
		
		return heapContent;
	}	
	
}
