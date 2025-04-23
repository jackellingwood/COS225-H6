import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTester {

    public static MorseTree fromFile(String path) {
        MorseTree mt = new MorseTree();
        TreeNode<Character> ptr;
        try (Scanner s = new Scanner(new File(path))) {
            Character letterOfNode;
            
            // go line by line, first letter is always the letter to add, then assemble the tree accordingly with the rest of the line.
            while (s.hasNextLine()) {
                ptr = mt.tree; // reset pointer to start
                letterOfNode = s.next().charAt(0);
                while (s.hasNext()) {
                    String c = s.next();
                    if (c.equals(".")) {
                        if (ptr.getLeft() != null) {
                            ptr = ptr.getLeft();
                        } else {
                            ptr.insertLeft(letterOfNode);
                            break;
                        }
                    } else if (c.equals("-")) {
                        if (ptr.getRight() != null) {
                            ptr = ptr.getRight();
                        } else {
                            ptr.insertRight(letterOfNode);
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
