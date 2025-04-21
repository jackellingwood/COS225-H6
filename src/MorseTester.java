import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTester {

    public static MorseTree fromFile(String path) {
        MorseTree mt = new MorseTree();
        TreeNode<String> t;
        try (Scanner s = new Scanner(new File(path))) {
            String letterOfNode;
            
            while (s.hasNextLine()) {
                t = mt.tree;
                letterOfNode = s.next();
                while (s.hasNext()) {
                    String c = s.next();
                    if (c.equals(".")) {
                        if (t.getLeft() != null) {
                            t = t.getLeft();
                        } else {
                            t.insertLeft(letterOfNode);
                            break;
                        }
                    } else if (c.equals("-")) {
                        if (t.getRight() != null) {
                            t = t.getRight();
                        } else {
                            t.insertRight(letterOfNode);
                            break;
                        }
                    }
                }
                s.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return mt;
    }


    public static void main(String[] args) {
        MorseTree tree = fromFile("morse.txt");

        System.out.println(tree.preorder());
    }
}
