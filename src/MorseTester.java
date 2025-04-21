public class MorseTester {
    public static void main(String[] args) {
        TreeNode<String> testTree = new TreeNode<>("b");
        testTree.insertLeft("a");
        testTree.insertRight("c");

        System.out.println(testTree.preorder(testTree));
        System.out.println(testTree.inorder(testTree));
        System.out.println(testTree.postorder(testTree));
    }
}
