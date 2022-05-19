public class Calculator {

	public static int add(String input) {
		if (input.equals("")) {
			return 0;
		} else {
			String delimiter = ",";
			if (input.matches("//(.*)\n(.*)")) {
				delimiter = Character.toString(input.charAt(2));
				input = input.substring(4);
			}
			String numList[] = input.split(delimiter + "|\n");
			int total = 0;
			String negNumbers = "";

			for (String number : numList) {
				if (Integer.parseInt(number) < 0) {
					if (negNumbers.equals(""))
						negNumbers = number;
					else
						negNumbers += ("," + number);
				}
				total += Integer.parseInt(number);
			}

			if (!negNumbers.equals("")) {
				throw new IllegalArgumentException("negatives not allowed : "+ negNumbers);
			}
			return total;
		}
	}
	public static void main(String[] args) {
		// Empty String
		System.out.println("Empty String : "+Calculator.add(""));

		// One Number
		System.out.println("One Number : "+Calculator.add("1"));

		// Two Numbers
		System.out.println("Two Numbers : "+Calculator.add("1,2"));

		// Three Numbers
		System.out.println("Three Numbers : "+Calculator.add("3,5,6"));

		// New Line
		System.out.println("New Line : "+Calculator.add("6\n7,8"));
		
		// Other Delimiter
		System.out.println("Other Delimiter : "+Calculator.add("//;\n1;2"));
		
		// One Negative Number
		try {
			System.out.println("One Negative Number : "+Calculator.add("-9,10"));
		}catch (IllegalArgumentException e){
			System.out.println("One Negative Number : "+e.getMessage());
		}
		
		// Multiple Negative Number
		try {
			Calculator.add("11,-12,13,-14");
		}catch (IllegalArgumentException e){
			System.out.println("Multiple Negative Number : "+e.getMessage());
		}

	}

}
