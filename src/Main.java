
public class Main {

	public static void main(String[] args) {
//		String s = "An 😀awesome 😃string 😄with a few 😉emojis!";
		String s = "מחרוזת 😀מדהימה 😄עם כמה 😉אימוג'ים!";
//		String s = "An 😀awesome 😃يوجد 😄with a few 😉بعض الوجوه!";
		EmojiManager em = new EmojiManager(s);
		em.displayString();
		em.removeEmojis();
		em.displayString();
	}

}
