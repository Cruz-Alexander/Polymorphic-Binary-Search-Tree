package tree;

/**
 * This is a checked exception, used internally by SearchTree nodes, to signal that a tree
 * has no minimum or maximum element.
 */
public class TreeIsEmptyException extends Exception {
    public TreeIsEmptyException() {
        super("The tree is empty.");
    }
}
