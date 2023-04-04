public class BinarySearchTree {
    private TreeNode root;

    /**
     * Inserts a new node with the given value into the BST.
     * @param value the value to insert
     */
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    /**
     * Searches for a node with the given value in the BST.
     * @param value the value to search for
     * @return true if the value is found, false otherwise
     */
    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }

    /**
     * Removes a node with the given value from the BST.
     * @param value the value to remove
     */
    public void remove(int value) {
        root = removeRecursive(root, value);
    }

    private TreeNode removeRecursive(TreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }
            // Case 2: only one child
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            // Case 3: two children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = removeRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = removeRecursive(current.left, value);
            return current;
        }
        current.right = removeRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(TreeNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    /**
     * Prints the BST in order (ascending).
     */
    public void printInOrder() {
        printInOrderRecursive(root);
        System.out.println();
    }

    private void printInOrderRecursive(TreeNode current) {
        if (current != null) {
            printInOrderRecursive(current.left);
            System.out.print(current.value + " ");
            printInOrderRecursive(current.right);
        }
    }

    /**
     * A node in the BST.
     */
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
