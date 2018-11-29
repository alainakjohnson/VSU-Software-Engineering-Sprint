package sprint2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class PersistenceManagerTest {

	@Test
	@DisplayName ("test save method")
	void save() {
		SiteManager sm = new SiteManager();
		File file = new File("test.dat");
		boolean actual = PersistenceManager.save(sm, file);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test read method")
	void read() {
		SiteManager sm = new SiteManager();
		File file = new File("test.dat");
		PersistenceManager.save(sm, file);
		SiteManager expected = new SiteManager();
		ObjectInputStream ois;
		try {
			FileInputStream fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			expected = (SiteManager) ois.readObject();
		} catch (IOException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		SiteManager actual  = PersistenceManager.read(file);
		assertEquals(expected, actual);
	}
	
}
