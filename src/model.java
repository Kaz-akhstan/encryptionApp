import java.io.*;
import java.util.ArrayList;

public class model {
    String filename;
    String messageInput;
    String message;
    String keyFile;
    String keyInput;
    String key;
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

    public String readKeyFromFile(String keyFile)
    {
        String key = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(keyFile));
            key = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }

    public String readKeyFromInput(String keyInput)
    {
        return keyInput;
    }

    public String readKeyFromEncryptedFile(String keyFile)
    {
        return null; // FIXME: 2022-09-29
    }

    public String encryptMessage(String message, String key)
    {
        String encrypted = "";
        ArrayList<Integer>intList = new ArrayList<>();
        for (int i = 0; i < message.length(); i++) {
            encrypted += message.charAt(i)^'P';
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
            dos = new DataOutputStream(new FileOutputStream(filename));
            dos.writeBytes(encryptedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
