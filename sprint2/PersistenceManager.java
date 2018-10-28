package sprint2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistenceManager {
	public PersistenceManager() {
		
	}
	
	public static boolean save(SiteManager sm, File file) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file"));
			oos.writeObject(sm);
			oos.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static SiteManager read(File file) {
		SiteManager sm = new SiteManager();
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			sm = (SiteManager) ois.readObject();
			ois.close();
			fis.close();
			return sm;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
