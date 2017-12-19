package application.controller;

public class SubstitutionEncoder {
	public static char[] substitutionAlphabet = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f',
			'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };

	public String encodeMessage(String originalMessage) {
		String encodedMessage = "";
		char[] charArray = originalMessage.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int keyCode = (int) charArray[i];
			boolean isUpperCase = false;
			if (keyCode > 64 && keyCode < 91) {
				keyCode -= 65;
				isUpperCase = true;
			} else if (keyCode > 96 && keyCode < 123) {
				keyCode -= 97;
				isUpperCase = false;
			} else {
				encodedMessage = encodedMessage + charArray[i];
				continue;
			}
			char encodedChar = substitutionAlphabet[keyCode];
			if (isUpperCase) {
				encodedChar = Character.toUpperCase(encodedChar);
			}
			encodedMessage = encodedMessage + encodedChar;
		}
		return encodedMessage;
	}

	public String decodeMessage(String originalMessage) {
		String decodedMessage = "";
		char[] charArray = originalMessage.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int decodedCharValue = -1;
			boolean isUpperCase = Character.isUpperCase(charArray[i]);
			charArray[i] = Character.toLowerCase(charArray[i]);
			for (int j = 0; j < substitutionAlphabet.length; j++) {
				if (charArray[i] == substitutionAlphabet[j]) {
					decodedCharValue = j;
					break;
				}
			}
			if (decodedCharValue == -1) {
				decodedMessage = decodedMessage + charArray[i];
				continue;
			}
			decodedCharValue += 65;
			if (!isUpperCase) {
				decodedCharValue += 32;
			}

			decodedMessage = decodedMessage + (char) decodedCharValue;
		}
		return decodedMessage;
	}
}