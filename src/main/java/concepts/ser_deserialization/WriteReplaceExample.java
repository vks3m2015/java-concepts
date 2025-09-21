package concepts.ser_deserialization;

import java.io.*;

// Original class with a simple message
class OriginalObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;

    public OriginalObject(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    // The writeReplace method that returns a proxy object
    private Object writeReplace() throws ObjectStreamException {
        System.out.println("writeReplace() invoked: Replacing OriginalObject with ProxyObject.");
        return new ProxyObject(this.message.toUpperCase()); // Return a proxy with an uppercase message
    }
}

// Proxy class that will actually be serialized
class ProxyObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String processedMessage;

    public ProxyObject(String processedMessage) {
        this.processedMessage = processedMessage;
    }

    public String getProcessedMessage() {
        return processedMessage;
    }
}

public class WriteReplaceExample {
    public static void main(String[] args) {
        try {
            // Create an instance of OriginalObject
            OriginalObject original = new OriginalObject("Hello World");
            System.out.println("Original object message: " + original.getMessage());

            // Serialize the OriginalObject
            FileOutputStream fos = new FileOutputStream("object.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(original);
            oos.close();
            fos.close();
            System.out.println("OriginalObject serialized successfully (as ProxyObject).");

            // Deserialize the object
            FileInputStream fis = new FileInputStream("object.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object deserializedObject = ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Object deserialized successfully.");

            // Check the type and content of the deserialized object
            if (deserializedObject instanceof ProxyObject) {
                ProxyObject proxy = (ProxyObject) deserializedObject;
                System.out.println("Deserialized object is a ProxyObject.");
                System.out.println("Deserialized message: " + proxy.getProcessedMessage());
            } else {
                System.out.println("Deserialized object is not a ProxyObject.");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}