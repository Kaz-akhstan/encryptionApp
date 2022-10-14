import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String s, k;
        int[] e;
        Scanner sc = new Scanner(System.in);
        model m = new model();
        if(sc.nextLine().equals("1"))
        {
            System.out.println("Enter Message: ");
            m.readMessageFromInput(sc.nextLine());
            System.out.println("Enter Key: ");
             m.readKeyFromInput(sc.nextLine());
            System.out.println("Encrypting Message");
            m.encryptMessage(m.MESSAGE, m.KEY);
            System.out.println("Encrypted Message: " + Arrays.toString(m.CRYPT));
            m.decryptMessage(m.CRYPT, m.KEY);
            System.out.println(m.MESSAGE);
            System.out.println("Output to File: ");
            m.outputToFile(sc.nextLine(), m.CRYPT);
        }
        if(sc.nextLine().equals("2"))
        {
            m.readMessageFromEncryptedFile("text.txt");
            m.readKeyFromInput(sc.nextLine());
            m.decryptMessage(m.CRYPT, m.KEY);
            System.out.println(m.MESSAGE);
        }
        /*
        if(sc.nextLine().equals("2"))
        {
            System.out.println("Enter Message: ");
            e = m.readMessageFromEncryptedFile(sc.nextLine());
            System.out.println("Enter Key: ");
            k = m.readKeyFromInput(sc.nextLine());
            System.out.println("Encrypting Message");
            s = m.decryptMessage(e, k);
            System.out.println(s);
        }
        if(sc.nextLine().equals("3"))
        {
            System.out.println("Enter Message: ");
            s = m.readMessageFromFile(sc.nextLine());
            System.out.println("Enter Key: ");
            k = m.readKeyFromInput(sc.nextLine());
            System.out.println("Encrypting Message");
            e = m.encryptMessage(s, k);
            System.out.println(s);
        }
         */
    }
}
