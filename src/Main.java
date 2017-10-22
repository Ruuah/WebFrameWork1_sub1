
class Main {
	public static void main(String[] args) {
		// Test Mutual exclusion2
		new WriteSharedTextThread().start();
		new ReadSharedTextThread().start();
	}
}

class WriteSharedTextThread extends Thread {

	@Override
	public void run() {
		SharedTextEditor editor = new SharedTextEditor();
		SharedText sText = SharedText.getInstance();
		editor.open(sText);
		
		for (int i = 0; i < 10; i++) {
			String buf = "";
			for (int j = 0; j < 10; j++)
				buf += i;
			editor.write(buf, 0);		
		}
	}
}

class ReadSharedTextThread extends Thread {

	@Override
	public void run() {
		SharedTextEditor editor = new SharedTextEditor();
		SharedText sText = SharedText.getInstance();
		editor.open(sText);
		
		for (int i = 0; i < 10; i++)
			editor.read();
	}
}

