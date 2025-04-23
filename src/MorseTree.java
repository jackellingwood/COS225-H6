public class MorseTree {
    public TreeNode<Character> tree;

    public MorseTree() {
        tree = new TreeNode<>('\0'); // '\0' is Character's null
    }

    public String preorder() {
        return tree.preorder(tree);
    }

    public String inorder() {
        return tree.inorder(tree);
    }

    public String postorder() {
        return tree.postorder(tree);
    }

    // O(nlogn * input len) for each char
    public String toMorse(String input) {
        input = input.toLowerCase();
        String out = "";
        TreeNode<Character> ptr;
        for (char c: input.toCharArray()) {
            ptr = tree;
            if (ptr.isIn(c)) { // check if char is in tree at all, if not, skip
                while (!ptr.getElement().equals(c)) { // check whether char is in left or right subtrees
                    if (ptr.getLeft().isIn(c)) {
                        ptr = ptr.getLeft();
                        out += ". ";
                    } else {
                        ptr = ptr.getRight();
                        out += "- ";
                    }
                }
                out += "| ";
            }
        }

        return out;
    } 

    // O(logn * input len)
    public String toPlain(String input) {
        String out = "";
        TreeNode<Character> ptr = tree;
        for (char c: input.toCharArray()) {
            switch (c) {
                case '.':
                    ptr = ptr.getLeft();
                    break;
                case '-':
                    ptr = ptr.getRight();
                    break;
                case '|':
                    out += ptr.getElement();
                    ptr = tree; //reset pointer
                    break;
                default:
                    break;
            }
        }

        return out;
    }
}
