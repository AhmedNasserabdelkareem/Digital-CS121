import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;

public class Readingfile {
	
	JFileChooser c = new JFileChooser();
	StringBuilder x =  new StringBuilder();
	public BufferedReader br = null;
	public FileInputStream fr = null;
	
	public SinglyLinkedList  getno () throws Exception{
		if (c.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			java.io.File file = c.getSelectedFile();
			try {
				fr = new FileInputStream(file);
				br = new BufferedReader(new InputStreamReader(fr));
				String sCurrentLine;
				SinglyLinkedList m = new SinglyLinkedList();

				while ((sCurrentLine = br.readLine()) != null) {
					m.add(sCurrentLine);
				}
				return m;

			} catch (Exception e) {
				throw null;

			} finally {

				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} catch (Exception e) {
					throw null;
				}
			}
			
			
		}else{
			return null;
		}
		
		
	}

}
