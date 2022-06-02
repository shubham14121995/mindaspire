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
				throw new IllegalArgumentException("Negatives not allowed: "+ negNumbers);
			}
			return total;
		}
	}
}