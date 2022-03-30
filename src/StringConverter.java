
public class StringConverter {

	public static String textToUniCode(String text) {
		StringBuilder str = new StringBuilder(text);
		String uniCode = "";
		for (int i = 0; i < str.length(); i++) {
			uniCode += "\\u" + Integer.toHexString(str.charAt(i) | 0x100000).substring(1);
		}
		return uniCode;
	}

	public static String uniCodeToText(String uniCode, boolean isHex) {
		String str = uniCode.split(" ")[0];
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
	
	public static String uniCodeToText(String uniCode) {
		return StringConverter.uniCodeToText(uniCode, true);
	}
}
