import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kata {
	public static void main(String[] args) {
//		List<Integer> test new ArrayList<>();
//		test.


//		int n = 26;
//		int sum = 0;
////		int sum2 = 0;
////		for (int i = 1; i < 27; i++) {
////			if(i != 15 && i != 21) {
////				sum += i;
////			}
////		}
//		System.out.println(sum);
//		System.out.println(15 * 21);
//
//		List<long[]> out = new ArrayList<>();
//
//
//		for (int i = 1; i <= n; i++) {
//			sum += i;
//		}
//
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				if (i != j && i * j == sum - i - j) {
//					out.add(new long[]{i, j});
//				}
//			}
//		}
//
//
//		for (long[] item : removNb(26)) {
//			System.out.println(Arrays.toString(item));
//		}
//		System.out.println("---------");

//		for (long[] item : removNb(1000003)) {
//			System.out.println(Arrays.toString(item));
//		}

	}


	public static List<long[]> removNb(long n) {
		long sum = 0;
		long nn = n;
		List<long[]> out = new ArrayList<>();
		for (long i = 1; i <= n; i++) {
			sum += i;
		}

//		for (long i = 1; i <= n; i++) {
//			for (long j = i; j <= nn; j++) {
//				System.out.println(i + " : " + j + " : " + sum);
//				if (i * j == sum - i - j) {
//					out.add(new long[]{i, j});
//					out.add(new long[]{j, i});
//				}
//			}
//		}

		for (int i = 1; i <= n; i++) {
			System.out.println(sum % i + " : " + (sum / i) * i + " : " + (sum - (sum / i) - i));
			if (sum % i == 0 && (sum / i) * i == sum - (sum / i) - i) {
				out.add(new long[]{i, sum / i});
			}
		}

		return out;
	}




}
