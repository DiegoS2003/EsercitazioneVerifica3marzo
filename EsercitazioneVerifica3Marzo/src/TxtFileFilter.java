
import java.io.File;
import javax.swing.filechooser.FileFilter;

public class TxtFileFilter extends FileFilter {
	
	public boolean accept(File f) {
		if(f.isDirectory()) {
			return true;
		}
		String fileName= f.getName().toLowerCase();
		return fileName.endsWith("txt");
	}

	public String getDescription() {
		return "File di testo";
	}
}