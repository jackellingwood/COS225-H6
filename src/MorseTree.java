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
    //     char[] charArr = new char[input.length()];
    //     input.getChars(0, input.length(), charArr, 0);
    //     for (char c: charArr) {
            
    //     }
    // } 
}
