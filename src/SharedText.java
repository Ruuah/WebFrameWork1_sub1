
public class SharedText {
	private static SharedText object;
	private String content;

	private SharedText() {
		content = "";
	}

	public synchronized static SharedText getInstance() {
		if (object == null) //Call constructor if 'object' is null
			object = new SharedText();

		return object;
	}

	public String getContent() {
		synchronized (content) {
			return content;
		}
	}

	public void setContent(String content) {
		synchronized (this.content) {
			if (Main.DEBUG)
				System.out.println("setContent Locked!");
				
			this.content = content;

			if (Main.DEBUG)
				System.out.println("setContent Unlocked!");
		}
	}

}
