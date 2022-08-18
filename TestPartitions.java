import java.io.*; // for IOException

public class TestPartitions {
	static int ran = 93;

	public static void main(String[] args) throws IOException {
		int[] number = new int[50];
		int[] numberSave = new int[50];
		System.out.println("           Left to Right");
		for (int n = 10; n <= 20; n += 10) {
			fillRandom(number, n);
			for (int i = 0; i < n; i++) {
				numberSave[i] = number[i];
			}
			System.out.print("Original array.     ");
			printArray(numberSave, n);
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {
					number[i] = numberSave[i];
				}
				System.out.print("   pivot: ");
				if (number[j] < 10)
					System.out.print(" ");
				System.out.print(number[j] + "        ");
				ArraySorts.partitionLeftToRight(number, 0, n - 1, j);
				printArray(number, n);
			}
			System.out.println();

		}
		System.out.println();
		System.out.println("           Outside In");
		for (int n = 10; n <= 20; n += 10) {
			fillRandom(number, n);
			for (int i = 0; i < n; i++) {
				numberSave[i] = number[i];
			}
			System.out.print("Original array.     ");
			printArray(numberSave, n);
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {
					number[i] = numberSave[i];
				}
				System.out.print("   pivot: ");
				if (number[j] < 10)
					System.out.print(" ");
				System.out.print(number[j] + "        ");
				ArraySorts.partitionOutsideIn(number, 0, n - 1, j);
				printArray(number, n);

			}
			System.out.println();

		}

		System.out.println();
		System.out.println("           2 pivot");
		for (int n = 10; n <= 20; n += 10) {
			fillRandom(number, n);
			for (int i = 0; i < n; i++) {
				numberSave[i] = number[i];
			}
			System.out.print("Original array.       ");
			printArray(numberSave, n);
			for (int j = n / 2 + 1; j < n / 2 + 4; j++) {
				for (int k = n / 2; k > n / 2 - 4; k--) {
					for (int i = 0; i < n; i++) {
						number[i] = numberSave[i];
					}
					if (number[j] > number[k]) {
						int temp = number[j];
						number[j] = number[k];
						number[k] = temp;
					}
					System.out.print("   pivots: ");
					if (number[j] < 10)
						System.out.print(" ");
					System.out.print(number[j] + " ");
					if (number[k] < 10)
						System.out.print(" ");
					System.out.print(number[k] + "      ");
					ArraySorts.partition2Pivot(number, 0, n - 1, j, k);
					printArray(number, n);
				}
			}
			System.out.println();
		}
	}

	public static void fillRandom(int a[], int n) {
		for (int i = 0; i < n; i++) {
			ran = (ran * 101 + 103) % 1000003;
			a[i] = ran / 20000;
		}
	}

	public static void printArray(int a[], int n) {
		for (int i = 0; i < n; i++) {
			if (a[i] < 10)
				System.out.print(" ");
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}

/*
 
           Left to Right
Original array.      0 47 43 38 39 15  4 38 21 42 
   pivot:  0         0 47 43 38 39 15  4 38 21 42 
   pivot: 47        42  0 43 38 39 15  4 38 21 47 
   pivot: 43        42  0 38 39 15  4 38 21 43 47 
   pivot: 38        21  0 15  4 38 43 47 38 39 42 
   pivot: 39        21 38  0 15  4 38 39 47 43 42 
   pivot: 15         4  0 15 38 39 47 43 38 21 42 
   pivot:  4         0  4 43 38 39 15 47 38 21 42 
   pivot: 38        21 15  4  0 38 47 43 38 39 42 
   pivot: 21         0 15  4 21 39 47 43 38 38 42 
   pivot: 42         0 38 39 15  4 38 21 42 43 47 

Original array.     38 44 34 43 38 16  0 25 42  3 33  6 13  7 20 14 19 25 40  7 
   pivot: 38         7 34 16  0 25  3 33  6 13  7 20 14 19 25 38 38 42 44 40 43 
   pivot: 44         7 38 34 43 38 16  0 25 42  3 33  6 13  7 20 14 19 25 40 44 
   pivot: 34         7 16  0 25  3 33  6 13  7 20 14 19 25 34 38 44 38 43 40 42 
   pivot: 43         7 34 38 38 16  0 25 42  3 33  6 13  7 20 14 19 25 40 43 44 
   pivot: 38         7 34 16  0 25  3 33  6 13  7 20 14 19 25 38 38 42 44 40 43 
   pivot: 16         7  0  3  6 13  7 14 16 42 34 33 43 38 38 20 44 19 25 40 25 
   pivot:  0         0 44 34 43 38 16 38 25 42  3 33  6 13  7 20 14 19 25 40  7 
   pivot: 25         7 16  0  3  6 13  7 20 14 19 25 38 44 34 38 42 43 25 40 33 
   pivot: 42         7 34 38 16  0 25 38  3 33  6 13  7 20 14 19 25 40 42 44 43 
   pivot:  3         0  3 34 43 38 16 44 25 42 38 33  6 13  7 20 14 19 25 40  7 
   pivot: 33         7 16  0 25  3  6 13  7 20 14 19 25 33 43 42 38 38 44 40 34 
   pivot:  6         3  0  6 43 38 16 44 25 42 34 33 38 13  7 20 14 19 25 40  7 
   pivot: 13         7  0  3  6  7 13 44 25 42 34 33 43 38 38 20 14 19 25 40 16 
   pivot:  7         6  0  3  7 38 16 44 25 42 34 33 43 13 38 20 14 19 25 40  7 
   pivot: 20         7 16  0  3  6 13  7 14 19 20 33 38 44 34 38 25 42 25 40 43 
   pivot: 14         7  0  3  6 13  7 14 25 42 34 33 43 38 16 20 38 19 25 40 44 
   pivot: 19         7 16  0  3  6 13  7 14 19 43 33 38 44 34 20 25 38 25 40 42 
   pivot: 25         7 16  0  3  6 13  7 20 14 19 25 38 44 34 25 42 43 38 40 33 
   pivot: 40         7 34 38 16  0 25  3 33  6 13  7 20 14 19 25 38 40 42 44 43 
   pivot:  7         6  0  3  7 38 16 44 25 42 34 33 43 13  7 20 14 19 25 40 38 


           Outside In
Original array.      0 49 33  2  9  7 40 33 13 11 
   pivot:  0         0 49 33  2  9  7 40 33 13 11 
   pivot: 49        11  0 33  2  9  7 40 33 13 49 
   pivot: 33        33 11  0  2  9  7 13 33 40 49 
   pivot:  2         0  2 33 49  9  7 40 33 13 11 
   pivot:  9         2  7  0  9 33 49 40 33 13 11 
   pivot:  7         2  0  7 33  9 49 40 33 13 11 
   pivot: 40        13 11 33  2  9  7  0 33 40 49 
   pivot: 33         0 11 33  2  9  7 13 33 40 49 
   pivot: 13         7 11  0  2  9 13 40 33 33 49 
   pivot: 11         9  0  7  2 11 33 40 33 13 49 

Original array.     27 22 11 12 11 22 10 43  2  8 32 18 44 13 20 35 20 15 13  3 
   pivot: 27        20 22 11 12 11 22 10  3  2  8 13 18 15 13 20 27 35 44 32 43 
   pivot: 22        20  3 11 12 11 22 10 13  2  8 15 18 20 13 22 35 44 32 43 27 
   pivot: 11        10  3  8  2 11 11 22 43 12 27 32 18 44 13 20 35 20 15 13 22 
   pivot: 12        10  3 11  8 11  2 12 43 22 27 32 18 44 13 20 35 20 15 13 22 
   pivot: 11        10  3 11  8  2 11 22 43 27 12 32 18 44 13 20 35 20 15 13 22 
   pivot: 22        20 22 11 12 11  3 10 13  2  8 15 18 20 13 22 35 44 32 43 27 
   pivot: 10         2  3  8 10 11 22 27 43 12 11 32 18 44 13 20 35 20 15 13 22 
   pivot: 43        13 22 11 12 11 22 10 27  2  8 32 18  3 13 20 35 20 15 43 44 
   pivot:  2         2 22 11 12 11 22 10 43 27  8 32 18 44 13 20 35 20 15 13  3 
   pivot:  8         2  3  8 12 11 22 10 43 11 27 32 18 44 13 20 35 20 15 13 22 
   pivot: 32        20 22 11 12 11 22 10  3  2  8 27 18 13 13 20 15 32 35 44 43 
   pivot: 18        13  3 11 12 11 13 10 15  2  8 18 27 44 32 20 35 20 43 22 22 
   pivot: 44         3 22 11 12 11 22 10 43  2  8 32 18 27 13 20 35 20 15 13 44 
   pivot: 13         2  3 11 12 11  8 10 13 43 22 32 18 44 27 20 35 20 15 13 22 
   pivot: 20        18  3 11 12 11 13 10 15  2  8 13 20 44 32 27 35 20 43 22 22 
   pivot: 35        15 22 11 12 11 22 10  3  2  8 32 18 13 13 20 27 20 35 44 43 
   pivot: 20        18  3 11 12 11 13 10 15  2  8 13 20 44 32 20 35 27 43 22 22 
   pivot: 15         8  3 11 12 11 13 10 13  2 15 32 18 44 43 20 35 20 27 22 22 
   pivot: 13         2  3 11 12 11  8 10 13 43 22 32 18 44 13 20 35 20 15 27 22 
   pivot:  3         2  3 11 12 11 22 10 43 22  8 32 18 44 13 20 35 20 15 13 27 


           2 pivot
Original array.       40 35 31  6  5 35 28 21  7  3 
   pivots: 28 35      21  6  5  3  7 28 31 35 35 40 
   pivots:  5 28       3  5 21  6  7 28 35 31 35 40 
   pivots:  6 28       5  3  6  7 21 28 35 31 35 40 
   pivots: 28 31      21  7  3  6  5 28 31 35 35 40 
   pivots: 21 35       7  6  5  3 21 35 28 31 35 40 
   pivots:  5 21       3  5  7  6 21 28 40 31 35 35 
   pivots:  6 21       3  5  6  7 21 28 40 31 35 35 
   pivots: 21 31       5  7  3  6 21 28 31 35 35 40 
   pivots:  7 35       3  6  5  7 31 35 28 21 35 40 
   pivots:  5  7       3  5  6  7 35 28 21 40 35 31 
   pivots:  6  7       3  5  6  7 35 28 21 40 35 31 
   pivots:  7 31       5  3  6  7 21 28 31 40 35 35 

Original array.       45 10 41  3 15  5 11 39 25 35  0 46 18 17  5 29 38 16 25  3 
   pivots:  0 46       0 10 41  3 15  5 11 39 25 35  3 45 18 17  5 29 38 16 25 46 
   pivots: 35 46      25 10  3 15  5 11 25  3  0 18 17  5 29 16 35 39 38 41 45 46 
   pivots: 25 46      16 10  3 15  5 11  3  0 18 17  5 25 41 35 39 29 38 45 25 46 
   pivots: 39 46      25 10  3 15  5 11  3 25 35  0 18 17  5 29 38 16 39 45 41 46 
   pivots:  0 18       0 10 16  3 15  5 11  5 17  3 18 45 35 25 29 38 39 25 41 46 
   pivots: 18 35      17 10  3 15  5 11 16  3  0  5 18 29 25 25 35 38 46 39 41 45 
   pivots: 18 25      17 10  3 15  5 11 16  3  5  0 18 25 25 46 29 38 35 39 41 45 
   pivots: 18 39       5 10  3 15  5 11  3  0 16 17 18 25 38 35 25 29 39 46 41 45 
   pivots:  0 17       0 10 16  3 15  5 11  5  3 17 46 18 45 25 29 38 39 25 41 35 
   pivots: 17 35       5 10  3 15  5 11 16  3  0 17 25 29 18 25 35 38 46 39 41 45 
   pivots: 17 25       0 10  3 15  5 11 16  3  5 17 25 18 25 46 29 38 35 39 41 45 
   pivots: 17 39       5 10  3 15  5 11  3  0 16 17 25 25 18 38 35 29 39 46 41 45 

*/
