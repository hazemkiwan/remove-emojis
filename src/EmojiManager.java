/**
 * The following are the ranges for emojis Unicode values:
 * The ranges are taken from:
 * https://stackoverflow.com/questions/24840667/what-is-the-regex-to-extract-all-the-emojis-from-a-string
 * \uD83C \uDF00-\uDFFF
 * \uD83D \uDC00-\uDDFF
 */

public class EmojiManager {
	private String str;

	public EmojiManager(String str) {
		this.str = str;
	}

	/**
	 * This method checks wither the Unicode value received is an Emoji value or not
	 * @param uniVal: A decimal Unicode value
	 * @return true if in the emoji range, and false if not
	 */
	private boolean withinRange(int uniVal) {
		// Checks if values are in Hex:
		// if (hexVal == 0xD83C || (hexVal >= 0xDF00 && hexVal <= 0xDFFF))
		// if (hexVal == 0xD83D || (hexVal >= 0xDC00 && hexVal <= 0xDDFF))
		if (uniVal == 55356 || uniVal ==  55357 || 
				(uniVal >= 57088 && uniVal <= 57343) ||
				(uniVal >= 56320 && uniVal <= 563831))
			return true;
		return false;
	}

	/**
	 * This method take the String in Unicode representation
	 * and removes all the values in the Emoji ranges
	 * @param strUniCode: Unicode String
	 */
	private void removeEmojis(String strUniCode) {
		String str = strUniCode.trim();
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

	/**
	 * The public method to remove the Emojis from the class member String
	 * @return The String without emojis.
	 */
	public String removeEmojis() {
		String strUniCode = StringConverter.textToUniCode(this.str);
		this.removeEmojis(strUniCode);
		this.str = StringConverter.uniCodeToText(this.str, false);
		return this.str;
	}

	@Override
	public String toString() {
		return this.str;
	}

}
