package Hotel;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class reportManager {
	public static <T> void writeToReport(String fileName, List<T> list) {
		String FilePath = fileName + ".txt";
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FilePath)));
			for (int i = 0; i < list.size(); i++) {
				o.writeObject(list.get(i));
			}
			o.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
