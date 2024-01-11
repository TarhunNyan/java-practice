package multhiThreading.util.format;

import java.util.Collection;
import java.util.List;
import java.util.Timer;

public class CollectionFormat {
	
	static public String collectionToString(
			Collection<? extends Object> collection, String start, String end,
			String prefix, String postfix
	) {
		StringBuilder stringBuilder = new StringBuilder( );
		stringBuilder.append(start);
		collection.stream( )
		          .map(el -> List.of(prefix, el.toString( ), postfix))
		          .flatMap(Collection::stream)
		          .forEach(stringBuilder::append);
		stringBuilder.append(end);
		return stringBuilder.toString( );
	}
}
