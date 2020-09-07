
/**
 * To check password strength
 * 
 * @author jgued
 * @version 1.0
 *
 */
public class Check {
	private static String pass;
	private static String text;
	private static String prev;
	private static String after;
	public static String ans;
	private static char letter;
	private static int block;
	private static int Bcount;
	private static int count;

	/**
	 * creates a password to check
	 * 
	 * @param pass The password
	 */
	public static void check(String inp) {
		pass = inp;
		block = strength(pass);
		ans = look(block);

	}

	/**
	 * 
	 * @param input
	 * @return Bcount
	 */
	static int strength(String input) {
		Bcount = 0;
		for (int i = 0; i < input.length() - 1; i++) {
			letter = input.charAt(i);
			count = counts(input, letter);
			if (Bcount < count)
				Bcount = count;
		}
		return Bcount;

	}

	public static int counts(String str, char letter) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == letter) {
				if (i > 0 && str.charAt(i - 1) == letter)
					count++;
				else if (i < str.length() - 1 && str.charAt(i + 1) == letter)
					count++;
			}
		}
		return count;
	}

	private static String look(int quality) {
		text = "";
		if (quality >= 3) {
			int away = quality - 2;
			text = ("The largest block in the password is " + quality + " This password" + '\n'
					+ " can be made stronger by reducing this block by " + away);
		} else {
			text = ("The largest block in the password is " + quality + " This is a decent password.");
		}
		return text;

	}

	public static String getAns() {
		return ans;
	}

	public static void setAns(String ans) {
		Check.ans = ans;
	}

}
