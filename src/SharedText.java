
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

	public char getCharAt(int i) {
		if (i >= content.length() || i < 0)
			return 0;
		return content.charAt(i);
	}

	public void setCharAt(int i, char ch) {
		if (i < content.length()) {
			char[] str = content.toCharArray();
			str[i] = ch;
			content = String.valueOf(str);
		} else {
			String space = "";
			int spaceSize = i - content.length();
			while (spaceSize-- != 0)
				space += " ";
			content += space + ch;
		}
	}

}

