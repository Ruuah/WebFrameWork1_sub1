
public class SharedTextEditor {
	private SharedText sText;

	public void open(SharedText sText) {
		this.sText = sText;
		System.out.println(this.toString() + " opened " + sText.toString());
	}

	public void read() {
		int i = 0;
		char ch;
		try {
			System.out.print("content>> ");
			while ((ch = sText.getCharAt(i++)) != 0)
				System.out.print(ch);
			System.out.println();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();
		}
	}

	public void write(String buf, int cursor) {
		try {
			for (int i = cursor; i < buf.length(); i++)
				sText.setCharAt(i, buf.charAt(i));
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();
		}
	}

}
