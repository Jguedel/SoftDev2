package Scramble;

/**
 * 
 * @author jgued
 * @version 1.0
 *
 */
public class Scram {
	public static String ans;
	public static String result = "";

	/**
	 * 
	 * @param input Inputed string
	 */
	public static void scram(String input) {
		ans = check(input);
		if (ans.equals("")) {
			ans = permute(input, 0, input.length() - 1);
		}
	}

	/**
	 * 
	 * @param str Inputed string
	 * @param start Place looking
	 * @param end Ending
	 * @return result
	 */
	private static String permute(String str, int start, int end) {
		if (start == end) {
			if(str != null) {
			result += (str + " ");
			}
		}
		else {
			for (int i = start; i <= end; i++) {
				str = swap(str, start, i);
				permute(str, start + 1, end);
				str = swap(str, start, i);
			}
		}
		System.out.println(result);
		return result;
	}
	
	/**
	 * 
	 * @param z
	 * @param i
	 * @param w
	 * @return
	 */
	public static String swap(String z, int i, int w) 
    { 
        char temp; 
        char[] charArray = z.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[w]; 
        charArray[w] = temp; 
        return String.valueOf(charArray); 
    } 

	/**
	 * 
	 * @param input Inputed string
	 * @return ans
	 */
	private static String check(String input) {
		ans = "";
		if (input.contains("1") || input.contains("2") || input.contains("3") || input.contains("4")
				|| input.contains("5") || input.contains("6") || input.contains("7") || input.contains("8")
				|| input.contains("9")) {
			ans = "Error: non-alphabetical character";
		}
		if (input.length() >= 7) {
			ans = "Error: to many characters";
		}
		return ans;

	}
	
	public static String getAns() {
		return ans;
	}

	public static void setAns(String ans) {
		Scram.ans = ans;
	}

}
