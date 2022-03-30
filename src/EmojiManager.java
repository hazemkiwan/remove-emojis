
public class EmojiManager {
	private String str;
	// The following are the ranges for emojis string:
	// https://stackoverflow.com/questions/24840667/what-is-the-regex-to-extract-all-the-emojis-from-a-string
	// \uD83C \uDF00-\uDFFF
	// \uD83D \uDC00-\uDDFF

	public EmojiManager(String str) {
		this.str = str;
	}

	private boolean withinRange(int uniVal) {
		// if (hexVal == 0xD83C || (hexVal >= 0xDF00 && hexVal <= 0xDFFF))
		if (uniVal == 55356 || (uniVal >= 57088 && uniVal <= 57343))
			return true;
		// if (hexVal == 0xD83D || (hexVal >= 0xDC00 && hexVal <= 0xDDFF))
		if (uniVal ==  55357|| (uniVal >= 56320 && uniVal <= 563831))
			return true;
		return false;
	}

	private void removeEmojis(String strUniCode) {
		String str = strUniCode.split(" ")[0];
		str = str.replace("\\", "");
		String[] arr = str.split("u");
		String text = "";
		for (int i = 1; i < arr.length; i++) {
			int uniVal = Integer.parseInt(arr[i], 16);
			if (!this.withinRange(uniVal)) {
				text += "\\u" + uniVal;
			}
		}
		this.str = text;
	}

	public void removeEmojis() {
		String strUniCode = StringConverter.textToUniCode(this.str);
		this.removeEmojis(strUniCode);
		this.str = StringConverter.uniCodeToText(this.str, false);
	}

	public void displayString() {
		System.out.println("The text is: ");
		System.out.println(this.str);
		System.out.println("-------------------------------------");
	}

}
