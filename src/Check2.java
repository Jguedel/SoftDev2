
/**
 * To check password strength
 * 
 * @author jgued
 * @version 1.0
 *
 */
public class Check2 {
	private static String holder;
	private static String holder2;
	private static String pass;
	private static String text;
	public static String ans;
	private static int block;

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
	 * @param input   The password
	 * @param holder  First look at password
	 * @param holder2 Second look at password
	 * @return block Number of char in a row
	 */
	private static int strength(String input) {
		String prev = "";
		holder = "";
		holder2 = "";
		block = 0;
		// COMPARING ARRAY
		for (int i = 0; i < input.length() - 1; i++) {
			holder = input.substring(i, i + 1);
			holder2 = input.substring(i + 1, i + 2);
			if (i > 1)
				prev = input.substring(i - 1, i);
			if (holder.equals(holder2)) {
				block += 1;
			} else if (holder.equals(prev)) {
				block += 1;
			}
		}
		holder = input.substring(input.length() - 2, input.length() - 1);
		holder2 = input.substring(input.length() - 1, input.length());
		System.out.print(holder + " holder1 ");
		System.out.println(holder2 + " holder2");
		if (holder.equals(holder2))
			block++;
		System.out.println(block);
		return block;
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
		Check2.ans = ans;
	}

}
