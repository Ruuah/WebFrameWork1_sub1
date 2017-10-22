
class Main {
	private final static int CASE = 1; 
	
	public static void main(String[] args) {
		switch (CASE) {
		case 0:
			// Test unique instance
			SharedTextEditor editor = new SharedTextEditor();
			SharedText t1 = SharedText.getInstance();
			editor.open(t1);
			editor.write("abcdefghijklmnopqrstuvwxyz", 0);
			editor.read();
			
			SharedText t2 = SharedText.getInstance();
			editor.open(t2);
			editor.read();
			
			break;
		case 1:
			// Test Mutual exclusion
			new EditSharedTextThread("abcdefghijklmnopqrstuvwxyz").start();
			new EditSharedTextThread("ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ").start();
			
			break;
		default:
		}
	}

}

class EditSharedTextThread extends Thread {
	private String buf;

	public EditSharedTextThread(String buf) {
		this.buf = buf;
	}

	@Override
	public void run() {
		SharedTextEditor editor = new SharedTextEditor();
		SharedText sText = SharedText.getInstance();
		synchronized (System.out) { //Mutex System output
			editor.open(sText);
			editor.write(buf, 0);
			editor.read();	
		}
	}

}


