public class MorseTree {
    public TreeNode<Character> tree;

    public MorseTree() {
        tree = new TreeNode<>('\0');
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

    // O(nlogn)
    public String toMorse(String input) {
        input = input.toLowerCase();
        String out = "";
        TreeNode<Character> ptr;
        for (char c: input.toCharArray()) {
            ptr = tree;
            if (ptr.isIn(c)) { // check if char is in tree at all, if not, skip
                while (!ptr.getElement().equals(c)) {
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

    // O(logn)
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
