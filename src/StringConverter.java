public class StringConverter {
	/**
	 * This static method convert the received text from normal characters to their 
	 * Unicode value
	 * @param text: String of normal characters
	 * @return Unicode String
	 */
	public static String textToUniCode(String text) {
		StringBuilder str = new StringBuilder(text);
		String uniCode = "";
		for (int i = 0; i < str.length(); i++) {
			uniCode += "\\u" + Integer.toHexString(str.charAt(i) | 0x100000).substring(1);
		}
		return uniCode;
	}

	/**
	 * This static method convert the received text from Unicode value to their
	 * characters representation
	 * @param uniCode: Text of Unicode values
	 * @param isHex: Determine if the Unicode values are in hex, or decimal
	 * @return Characters String
	 */
	public static String uniCodeToText(String uniCode, boolean isHex) {
		String str = uniCode.trim();
		str = str.replace("\\", "");
		String[] arr = str.split("u");
		String text = "";
		for (int i = 1; i < arr.length; i++) {
			int hexVal;
			if(isHex)
				hexVal = Integer.parseInt(arr[i], 16);
			else
				hexVal = Integer.parseInt(arr[i]);
			text += (char) hexVal;
		}
		return text;
	}
	
	/**
	 * As the by default the Unicode values are in Hex representation, this static method
	 * overloads the uniCodeToText, to set the isHex to true by default.
	 * @param uniCode: Text of Unicode values
	 * @return Characters String
	 */
	public static String uniCodeToText(String uniCode) {
		return StringConverter.uniCodeToText(uniCode, true);
	}
}
