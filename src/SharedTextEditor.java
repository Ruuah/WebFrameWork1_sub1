
public class SharedTextEditor {
	private SharedText sText;

	public void open(SharedText sText) {
		this.sText = sText;
		System.out.println(this.toString() + " opened " + sText.toString());
	}

	public void read() {
		System.out.println("content>> " + sText.getContent());
	}

	public void write(String buf) {
		sText.setContent(buf);
	}

}
