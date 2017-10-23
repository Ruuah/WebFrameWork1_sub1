
class Main {
	// set 'true' if want see debugging statements
	final static boolean DEBUG = false;
	// set CASE num for switch statement in main
	private final static int CASE = 2;

	public static void main(String[] args) {
		switch (CASE) {
		case 0:
			// Test unique instance
			SharedTextEditor editor = new SharedTextEditor();
			SharedText t1 = SharedText.getInstance();
			editor.open(t1);
			editor.write("abcdefghijklmnopqrstuvwxyz");
			editor.read();
			
			SharedText t2 = SharedText.getInstance();
			editor.open(t2);
			editor.read();

			break;
		case 1:
			// Test Mutual exclusion 'Create'
			new EditSharedTextThread().start();
			new EditSharedTextThread().start();

			break;
		case 2:
			// Test Mutual exclusion 'Write'
			new WriteSharedTextThread().start();
			new ReadSharedTextThread().start();

		default:
		}
	}

}

class EditSharedTextThread extends Thread {

	@Override
	public void run() {
		SharedTextEditor editor = new SharedTextEditor();
		SharedText sText = SharedText.getInstance();
		editor.open(sText);
	}

}

class WriteSharedTextThread extends Thread {

	@Override
	public void run() {
		SharedTextEditor editor = new SharedTextEditor();
		SharedText sText = SharedText.getInstance();
		editor.open(sText);
		editor.write("abcdefghijklmnopqrstuvwxyz");
	}

}

class ReadSharedTextThread extends Thread {

	@Override
	public void run() {
		SharedTextEditor editor = new SharedTextEditor();
		SharedText sText = SharedText.getInstance();
		editor.open(sText);
		editor.read();
	}

}