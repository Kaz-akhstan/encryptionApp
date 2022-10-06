import javax.swing.*;
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

    public int[] encryptMessage(String message, String key)
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
        return encryptedMsg;
    }

    public String decryptMessage(int[] encryptedMessage, String key)
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
        return message;
    }

    public void outputToFile(String filename, int[] encryptedMessage)
    {
        JFileChooser j = new JFileChooser();
        j.showSaveDialog(null);
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
