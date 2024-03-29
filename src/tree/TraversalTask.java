Here's the code without line numbers:

```java
package tree;

/**
 * When we perform a traversal of a tree, we call the
 * performTask method to process each key, value pair in
 * the tree. Classes implementing this interface allow
 * us to collect keys, print values, etc.
 * @author cmsc132
 *
 * @param <K>
 * @param <V>
 */
public interface TraversalTask<K, V> {
    public void performTask(K key, V value);
}
