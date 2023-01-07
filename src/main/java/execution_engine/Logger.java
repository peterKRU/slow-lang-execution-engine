package execution_engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logger {
	
	private List<String> log;
	private TextExporter logExporter;
	
	public Logger() {
		
		this.log = new ArrayList<String>();
		this.logExporter = new LogExporter();
	}
	
	public void log(String text) {
		
		log.add(text);
	}
	
	public void exportLog(String fileName) throws IOException {
		
		String lines = "";
		
		for(String line : log) {
			
			lines += line + " ";
		}
		
		logExporter.export(lines, fileName);
	}
}
