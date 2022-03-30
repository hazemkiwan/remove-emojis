import java.util.Scanner;

public class RemoveEmojis {

	public static void removeEmojisFromString(String str) {
		EmojiManager emojiManager = new EmojiManager(str);
		System.out.println("---------------------------------");
		System.out.println("-I- Received the following text: ");
		System.out.println(str);
		emojiManager.removeEmojis();
		System.out.println("-I- Text after removing Emojis: ");
		System.out.println(emojiManager);
		System.out.println("---------------------------------");
	}

	public static void main(String[] args) {
		// Running an example:
		System.out.println("-I- This simple app, recieves a text with emojis, as input");
		System.out.println("and prints, prints the string without emojis.");
		System.out.println("-I- Example: ");
		String str = "An 😀awesome 😃string 😄with a few 😉emojis!";
		removeEmojisFromString(str);
		if (args.length > 0) {
			str = args[0];
		} else {
			System.out.println("-W- No arguments found.");
			System.out.println("-I- Please enter the text you want: ");
			Scanner scan;
			try {
				scan = new Scanner(System.in);
				str = scan.nextLine();
			} catch (Exception e) {
				System.out.println("-E- Something went wrong: " + e.toString());
				System.out.println("-W- Will keep the example text");
			}
		}
		removeEmojisFromString(str);
		System.out.println("Thanks for using Hazem app ^_^");
	}

}
