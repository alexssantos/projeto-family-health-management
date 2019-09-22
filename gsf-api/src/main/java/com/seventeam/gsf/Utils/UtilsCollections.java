package com.seventeam.gsf.Utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class UtilsCollections {
	
	
	/*In function Out Predicate
	Sample to Use:
	myList.stream()
      .filter(distinctByKey(
        p -> p.getName() + p.getPrice()     // This is a 'Funcion'
       ))
      .collect(Collectors.toList()));
      
     //https://stackoverflow.com/questions/42817884/java-8-how-to-get-distinct-list-on-more-than-one-property
	*/
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
	{
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();  // not repeated items
		Predicate<T> predicateExpressionWithGeneric =
				t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
		
		return predicateExpressionWithGeneric;
	}
}
