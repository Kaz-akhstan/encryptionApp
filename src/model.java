import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class model {
    String KEY, MESSAGE;
    int[] CRYPT;

    public void readMessageFromFile(String filename)
    {
        String message = "";
        try {
            Scanner reader = new Scanner(new File(filename));       //Kanske fungerar bättre
            while (reader.hasNext())
            {
                message += reader.nextLine() + "\n";
                System.out.println(message);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MESSAGE = message;
    }

    public void readMessageFromInput(String messageInput)
    {
        MESSAGE = messageInput;
    }

    public void readMessageFromEncryptedFile(String filename)
    {
        ArrayList<Integer>readMessage = new ArrayList<>();
        DataInputStream dis;
        try {
            dis = new DataInputStream(new FileInputStream(filename));
            while (dis.available()>0)
            {
                readMessage.add(dis.readInt());
            }
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] encryptedMessage = new int[readMessage.size()];
        for (int i = 0; i < readMessage.size(); i++) {
            encryptedMessage[i] += readMessage.get(i);
        }
        CRYPT = encryptedMessage;
    }

    public void readKeyFromFile(String keyFile)
    {
        int key = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(keyFile));
            key = br.read();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        KEY = String.valueOf(key);
    }

    public void readKeyFromInput(String keyInput)
    {
        KEY = keyInput;
    }

    public void encryptMessage(String message, String key)
    {
        if(message.length() > key.length())
        {
            while (message.length() > key.length())
            {
                key += key;
            }
        }
        System.out.println("Long Key: " + key);
        int[] encryptedMsg = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            encryptedMsg[i] += message.charAt(i) ^ key.charAt(i);
        }
        CRYPT = encryptedMsg;
    }

    public void decryptMessage(int[] encryptedMessage, String key)
    {
        String message = "";
        char[] decryptedMessage = new char[encryptedMessage.length];
        if(encryptedMessage.length > key.length())
        {
            while (encryptedMessage.length > key.length())
            {
                key += key;
            }
        }
        for (int i = 0; i < encryptedMessage.length; i++) {
            decryptedMessage[i] += (char) encryptedMessage[i] ^ key.charAt(i);
            message += decryptedMessage[i];
        }
        MESSAGE = message;
    }

    public void outputToFile(String filename, int[] encryptedMessage)
    {
        DataOutputStream dos;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
            for (int i = 0; i < encryptedMessage.length; i++) {
                dos.writeInt(encryptedMessage[i]);
            }
            dos.flush();
            dos.close();
            System.out.println("Message Encrypted and Stored Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
