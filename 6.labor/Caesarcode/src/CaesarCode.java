
public class CaesarCode {
	public static String caesarCode(String input, char offset)
	{
		String t="";
		input=input.toUpperCase();
		offset=Character.toUpperCase(offset);
		int diff=(int)offset-(int)'A';
		int len=input.length();
		for(int x=0; x<len; x++) 
		{
			char c = (char)(input.charAt(x) + diff);
			if (c > 'Z')
				t += (char)(input.charAt(x) - (26-diff));
			else
				t += (char)(input.charAt(x) + diff);
		}
		return t;
	}
	
}
