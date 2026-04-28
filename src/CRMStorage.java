import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CRMStorage {
    public static void save(String fileName, CRMState state) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(state);
            System.out.println("CRM state saved to file: " + fileName);
        } catch (IOException ex) {
            System.out.println("IOException is caught while saving CRM state: " + ex.getMessage());
        }
    }

    public static CRMState load(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (CRMState) in.readObject();
        } catch (Exception ex) {
            System.out.println("CRMStorage: Failed to load CRM data file: " + ex.getMessage());
            return null;
        }
    }

    public static boolean delete(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            return false;
        }
        // if and only if the file or directory is successfully deleted; false
        // otherwise.
        return file.delete();
    }
}
