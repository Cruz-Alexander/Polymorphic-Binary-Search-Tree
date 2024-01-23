Here's the code without line numbers:

```java
package tree;
import java.util.*;

/**
 * This task places key/values in two arrays in the order
 * in which the key/values are seen during the traversal. If no keys/values
 * are found the ArrayList will be empty (constructor creates two
 * empty ArrayLists).
 *
 * @param <K>
 * @param <V>
 */
public class PlaceKeysValuesInArrayLists<K, V> implements TraversalTask<K, V> {

    private ArrayList<K> keys;
    private ArrayList<V> values;

    public PlaceKeysValuesInArrayLists() {
        keys = new ArrayList<K>();
        values = new ArrayList<V>();
    }

    public ArrayList<K> getKeys() {
        return keys;
    }

    public ArrayList<V> getValues() {
        return values;
    }

    @Override
    public void performTask(K key, V value) {
        keys.add(key);
        values.add(value);
    }

}
