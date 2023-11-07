import org.apache.commons.lang.StringUtils;


public class ModifyString {

	public static void main(String[] args) {
		
		String input = "INVOICE IN AP EXCEPTIONS";
		
		//System.out.println(StringUtils.capitalise(s));
		
		
		
        String result = "";
        char firstChar = input.charAt(0);
        result = result + Character.toUpperCase(firstChar);
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(i - 1);
            if (previousChar == ' ') {
                result = result + Character.toUpperCase(currentChar);
            } else {
                result = result + Character.toLowerCase(currentChar);
            }
        }
        
        System.out.println(result);

	}

}
