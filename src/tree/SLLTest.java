package tree;

import java.util.*;

public class SLLTest {

    static Scanner Scan = new Scanner(System.in);

    public static void main(String[] args) {
        int t;
        String s1, s2;
        String[] array1, array2;
                
        System.out.print("Enter t: ");
        t = Scan.nextInt();
        Scan.nextLine();
        System.out.print("Enter s1: ");
        s1 = Scan.nextLine();
        System.out.print("Enter s2: ");
        s2 = Scan.nextLine();
        
        array1 = s1.split(" ");
        array2 = s2.split(" ");
        
        if (t == 1) {
            SLL<Integer> slist1 = new SLL<Integer>();
            SLL<Integer> slist2 = new SLL<Integer>();

            System.out.println("First Linked List Contents: ");
            for (int i = 0; i < array1.length; i++) {
                String w = array1[i];
                slist1.insertDesc(Integer.valueOf(w));
                System.out.println(slist1.toString());
            }

            System.out.println("Second Linked List Contents: ");
            for (int i = 0; i < array2.length; i++) {
                String w = array2[i];
                slist2.insertDesc(Integer.valueOf(w));
                System.out.println(slist2.toString());
            }
        }
    }
}
