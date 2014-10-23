
public class pjEuler {

	public static int highly_divisible_triangle_number(int numFactors) {
		int num = 1;
		int increment = 1;
		while (true) {
			increment++;
			num += increment;
			int count = 0;
			for (int i = 1; i < num; i++) {
				if (num % i == 0) {
					count++;
				}
				if (count > numFactors) {
					return num;
				}
			}

		}
	}

	public static int longest_chain() {
		int number = 1000000;
		 
		int sequenceLength = 0;
		int startingNumber = 0;
		long sequence;
		//DYNAMIC PROGRAMMING! (we can call it the cache)
		int[] cache = new int[number + 1];
		for (int i = 0; i < cache.length; i++) {
		    cache[i] = -1;
		}
		cache[1] = 1;
		 
		for (int i = 2; i <= number; i++) {
		    sequence = i;
		    int k = 0;
		    while (sequence != 1 && sequence >= i) {
		        k++;
		        if ((sequence % 2) == 0) {
		            sequence = sequence / 2;
		        } else {
		            sequence = sequence * 3 + 1;
		        }
		    }
		    //Store result in cache
		    cache[i] = k + cache[(int) sequence];
		 
		    //Check if sequence is the best solution
		    if (cache[i] > sequenceLength) {
		        sequenceLength = cache[i];
		        startingNumber = i;
		    }
		}
		return startingNumber;
	}

	public static void main(String[] args) {
		//System.out.println(highly_divisible_triangle_number(500));
		System.out.println(longest_chain());
	}
}
