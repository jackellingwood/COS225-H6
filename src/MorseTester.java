import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTester {

    public static MorseTree fromFile(String path) {
        MorseTree mt = new MorseTree();
        TreeNode<Character> t;
        try (Scanner s = new Scanner(new File(path))) {
            Character letterOfNode;
            
            // go line by line, first letter is always the letter to add, then assemble the tree accordingly with the rest of the line.
            while (s.hasNextLine()) {
                t = mt.tree; // reset pointer to start
                letterOfNode = s.next().charAt(0);
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
            System.err.println("File Not Found");
        }

        return mt;
    }


    public static void main(String[] args) {
        MorseTree tree = fromFile("editedmorse.txt");

        System.out.println(tree.preorder());
        System.out.println(tree.postorder());

        String testString = "The quick fox.";
        System.out.println("Original  : " + testString);
        testString = tree.toMorse(testString);
        System.out.println("Morse     : " + testString);
        testString = tree.toPlain(testString);
        System.out.println("Plaintext : " + testString);
    }
}
