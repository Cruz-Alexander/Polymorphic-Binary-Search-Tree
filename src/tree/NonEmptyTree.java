Here's the code without line numbers:

```java
package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * - A key
 * - A value (that the key maps to)
 * - A reference to a left Tree that contains key:value pairs such that the
 *   keys in the left Tree are less than the key stored in this tree node.
 * - A reference to a right Tree that contains key:value pairs such that the
 *   keys in the right Tree are greater than the key stored in this tree node.
 */
public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {
    /* Provide whatever instance variables you need */
    private final K key;
    private final V value;
    private final Tree<K, V> left;
    private final Tree<K, V> right;

    /**
     * Only constructor we need.
     *
     * @param key
     * @param value
     * @param left
     * @param right
     */
    public NonEmptyTree(K key, V value, Tree<K, V> left, Tree<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public V search(K key) {
        int compareResult = key.compareTo(this.key);
        if (compareResult == 0) {
            return value;
        } else if (compareResult < 0) {
            return left.search(key);
        } else {
            return right.search(key);
        }
    }

    @Override
    public NonEmptyTree<K, V> insert(K key, V value) {
        int compareResult = key.compareTo(this.key);
        if (compareResult == 0) {
            return new NonEmptyTree<K, V>(key, value, left, right);
        } else if (compareResult < 0) {
            Tree<K, V> newLeft = left.insert(key, value);
            return new NonEmptyTree<K, V>(this.key, this.value, newLeft, right);
        } else {
            Tree<K, V> newRight = right.insert(key, value);
            return new NonEmptyTree<K, V>(this.key, this.value, left, newRight);
        }
    }

    @Override
    public Tree<K, V> delete(K key) {
        int compareResult = key.compareTo(this.key);
        if (compareResult == 0) {
            if (left instanceof EmptyTree) {
                return right;
            } else if (right instanceof EmptyTree) {
                return left;
            } else {
                try {
                    K minKey = right.min();
                    V minValue = right.search(minKey);
                    Tree<K, V> newRight = right.delete(minKey);
                    return new NonEmptyTree<K, V>(minKey, minValue, left, newRight);
                } catch (TreeIsEmptyException e) {
                    // Handle the exception if the right tree is empty
                    return left;
                }
            }
        } else if (compareResult < 0) {
            Tree<K, V> newLeft = left.delete(key);
            return new NonEmptyTree<K, V>(this.key, this.value, newLeft, right);
        } else {
            Tree<K, V> newRight = right.delete(key);
            return new NonEmptyTree<K, V>(this.key, this.value, left, newRight);
        }
    }

    @Override
    public K max() throws TreeIsEmptyException {
        if (right instanceof EmptyTree) {
            return key;
        } else {
            return right.max();
        }
    }

    @Override
    public K min() throws TreeIsEmptyException {
        if (left instanceof EmptyTree) {
            return key;
        } else {
            return left.min();
        }
    }

    @Override
    public int size() {
        return 1 + left.size() + right.size();
    }

    @Override
    public void addKeysToCollection(Collection<K> c) {
        left.addKeysToCollection(c);
        c.add(key);
        right.addKeysToCollection(c);
    }

    @Override
    public Tree<K, V> subTree(K fromKey, K toKey) {
        if (key.compareTo(fromKey) < 0) {
            return right.subTree(fromKey, toKey);
        } else if (key.compareTo(toKey) > 0) {
            return left.subTree(fromKey, toKey);
        } else {
            Tree<K, V> newLeft = left.subTree(fromKey, toKey);
            Tree<K, V> newRight = right.subTree(fromKey, toKey);
            return new NonEmptyTree<K, V>(key, value, newLeft, newRight);
        }
    }

    @Override
    public int height() {
        int leftHeight = left.height();
        int rightHeight = right.height();
        return 1 + Math.max(leftHeight, rightHeight);
    }

    @Override
    public void inorderTraversal(TraversalTask<K, V> p) {
        left.inorder

Traversal(p);
        p.performTask(key, value);
        right.inorderTraversal(p);
    }

    @Override
    public void rightRootLeftTraversal(TraversalTask<K, V> p) {
        right.rightRootLeftTraversal(p);
        p.performTask(key, value);
        left.rightRootLeftTraversal(p);
    }
}
