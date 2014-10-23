import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class icpc {

	public static void main(String args[]) {
		if (args.length < 1) {
			System.exit(0);
		}
		String fileName = args[0];
		File file = new File(fileName);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int count;
		
		int c = 0;
		while (scanner.hasNext()) {
			c++;
			count = 0;
			String[] line = scanner.nextLine().split(" ");
			int lowerBound = Integer.parseInt(line[0]);
			int upperBound = Integer.parseInt(line[1]);
			if (lowerBound == 0 && upperBound == 0) {
				break;
			}
			lowerBound--;
			upperBound--;
			int topLevel = 2;
			for (int i = 3; i < upperBound; i += topLevel) {
				topLevel++;
				if ( Math.sqrt(i + 1) % 1 == 0 ) {
					count++;
				}
			}
			topLevel = 2;
			for (int j = 3; j <= lowerBound; j += topLevel) {
				if ( Math.sqrt(j + 1) % 1 == 0) {
					count--;
				}
			}
			System.out.println("Case " + c + ": " + count);
		}
		scanner.close();

	}
}
