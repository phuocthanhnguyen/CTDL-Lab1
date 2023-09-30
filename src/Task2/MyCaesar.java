package Task2;

public class MyCaesar {

	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	public char encryptChar(char c) {
		if (c >= 65 && c <= 90) {
			return ALPHABET[(c + n) % 26];
		} else {
			return (char) ('0' + c);
		}
	}

	public String encrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += encryptChar(input.charAt(i));
		}
		return result;
	}

	public char decryptChar(char c) {
		if (c >= 65 && c <= 90) {
			return ALPHABET[(c - n) % 26];
		} else {
			return (char) ('0' - c);
		}
	}

	public String decrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += decryptChar(input.charAt(i));
		}
		return result;
	}

	public static void main(String[] args) {
		MyCaesar c1 = new MyCaesar(4);
		System.out.println(c1.encryptChar('P'));
		System.out.println(c1.encrypt("PHUOC"));
		System.out.println(c1.decryptChar('G'));
		System.out.println(c1.decrypt("GYLFT"));

	}

}
