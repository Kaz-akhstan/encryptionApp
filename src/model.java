import java.io.*;
import java.util.ArrayList;

public class model {
    String filename;
    String messageInput;
    String message;
    String keyFile;
    String keyInput;
    int key;
    String encryptedMessage;

    public String readMessageFromFile(String filename)
    {
        String message = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            message = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    public String readMessageFromInput(String messageInput)
    {
        return messageInput;
    }

    public String readMessageFromEncryptedFile(String filename)
    {
        return null; // FIXME: 2022-09-29
    }

    public int readKeyFromFile(String keyFile)
    {
        int key = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(keyFile));
            key = br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }

    public String readKeyFromInput(String keyInput)
    {
        return keyInput;
    }

    public int readKeyFromEncryptedFile(String keyFile)
    {
        return 0; // FIXME: 2022-09-29
    }

    public String encryptMessage(String message, String key)
    {
        if(message.length() > key.length())
        {
            while (message.length() > key.length())
            {
                key += key;
            }
            System.out.println(key);
        }
        System.out.println(key);
        String encrypted = "";
        int[] encryptedMsg = new int[message.length()]; //String föredetta
        for (int i = 0; i < message.length(); i++) {
            encryptedMsg[i] += message.charAt(i) ^ key.charAt(i);
            encrypted += encryptedMsg[i];
            System.out.println(encrypted);
        }
        return encrypted;
    }

    public String decryptMessage(String encryptedMessage)
    {
        return null;
    }

    public void outputToFile(String filename, String encryptedMessage)
    {
        DataOutputStream dos;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
            dos.write(encryptedMessage.getBytes()); //Försök använda dos.writeInt(encryptedMessage); Fixa en int lista
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
