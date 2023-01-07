package execution_engine;

import java.util.ArrayList;
import java.util.List;

public class Logger {
	
	private List<String> log;
	
	public Logger() {
		
		this.log = new ArrayList<String>();
	}
	
	public void log(String text) {
		
		log.add(text);
	}
	
}
