public class MorseTree {
    public TreeNode<String> tree;

    public MorseTree() {
        tree = new TreeNode<>("");
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

    // public String toMorse(String input) {
    //     for (char c: input.toCharArray()) {
            
    //     }
    // } 

    // O(logn)
    public String toPlain(String input) {
        String out = "";
        TreeNode<String> ptr = tree;
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
