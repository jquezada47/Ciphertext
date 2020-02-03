import java.util.Arrays;
import java.util.Random;
public class Jorge_QuezadaA1 {
	public static void main(String[] args) {
		Random random = new Random();
		int rand = random.nextInt(16777215);
		String randBinary = Integer.toBinaryString(rand);
		System.out.println("24-Bit Key: " + randBinary);
		System.out.println();
		
		
		String[] BYTES = new String[6];
		char[] BYTESascii = new char[6];
		String message="";
		String messageASCII="";
		for(int i = 0; i<6;i++) {
			int randomByte = random.nextInt(74)+48;
			char a = (char) randomByte;
			String randomByteBinary = Integer.toBinaryString(randomByte);
			BYTES[i] = makeSizeByte(randomByteBinary);
			BYTESascii[i] = a;
			message+=""+makeSizeByte(randomByteBinary);
			messageASCII+=""+a;
		}
		System.out.println("Original Message Divided into BYTES: " + Arrays.toString(BYTES));
		System.out.println("Original Message : " +message);
		System.out.println("Original Message ASCII: " +messageASCII);
		System.out.println();
		
		
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<message.length();i++) {
			sb.append((message.charAt(i) ^ randBinary.charAt(i % randBinary.length())));
		}
		String ciphertext = sb.toString();
		System.out.println("Ciphertext: " + ciphertext);
		String[] ciphertextBYTES = new String[6];
		String[] ciphertextASCII = new String[6];
		String cipherMessageASCII="";
		int countcipher=0;
		for(int i =8; i<=ciphertext.length();i+=8) {
			ciphertextBYTES[countcipher] = ciphertext.substring(i-8,i);
			countcipher++;
		}
		for(int i = 0; i<6;i++) {
			int decryptedInt = Integer.parseInt(ciphertextBYTES[i],2);
			char a = (char) decryptedInt;
			ciphertextASCII[i] = ""+a;
			cipherMessageASCII+=a;
		}
		System.out.println("Ciphertext to ASCII: " +cipherMessageASCII );
		System.out.println();
		
		
		StringBuilder sb2 = new StringBuilder();
		for(int i =0;i<message.length();i++) {
			sb2.append((ciphertext.charAt(i) ^ randBinary.charAt(i % randBinary.length())));
		}
		String decrypted = sb2.toString();
		System.out.println("Decrypted message: " +decrypted);
		String[] decryptedBYTES = new String[6];
		String[] decryptedASCII = new String[6];
		String decryptedMessageASCII = "";
		int count =0;
		for(int i =8; i<=decrypted.length();i+=8) {
			decryptedBYTES[count] = decrypted.substring(i-8,i);
			count++;
		}
		for(int i = 0; i<6;i++) {
			int decryptedInt = Integer.parseInt(decryptedBYTES[i],2);
			char a = (char) decryptedInt;
			decryptedASCII[i] = ""+a;
			decryptedMessageASCII+=a;
		}
		System.out.println("Decrypted to ASCII: " + decryptedMessageASCII);
		
	}
	public static String makeSizeByte(String s) {
		if(s.length()==8) {
			return s;
		}
		else {
			return makeSizeByte("0"+s);
		}
	}
}

