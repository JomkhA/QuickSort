
// for IOException
import java.io.IOException;

public class TestBuildHeaps {
	static int ran = 93;

	public static void main(String[] args) throws IOException {
		int[] number = new int[50];
		System.out.println("           Top Down");
		for (int n = 1; n <= 30; n++) {
			fillRandom(number, n);
			System.out.print("Original array.     ");
			printArray(number, n);
			System.out.print("heap:               ");
			for (int i = 1; i < n; i++) {
				ArraySorts.trickleUp(number, i);
			}
			printArray(number, n);
			System.out.println();
		}
		System.out.println();
		System.out.println("           Bottom Up");
		for (int n = 1; n <= 30; n++) {
			fillRandom(number, n);
			System.out.print("Original array.     ");
			printArray(number, n);
			System.out.print("heap:               ");
			for (int i = (n - 1) / 2; i >= 0; i--)
				ArraySorts.trickleDown(number, i, n - 1);
			printArray(number, n);
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

/*   My output

           Top Down
Original array.      0 
heap:                0 

Original array.     47 43 
heap:               47 43 

Original array.     38 39 15 
heap:               39 38 15 

Original array.      4 38 21 42 
heap:               42 38 21  4 

Original array.     38 44 34 43 38 
heap:               44 43 34 38 38 

Original array.     16  0 25 42  3 33 
heap:               42 25 33  0  3 16 

Original array.      6 13  7 20 14 19 25 
heap:               25 14 20  6 13  7 19 

Original array.     40  7  0 49 33  2  9  7 
heap:               49 40  9  7 33  0  2  7 

Original array.     40 33 13 11 27 22 11 12 11 
heap:               40 33 22 12 27 13 11 11 11 

Original array.     22 10 43  2  8 32 18 44 13 20 
heap:               44 43 32 13 20 22 18  2 10  8 

Original array.     35 20 15 13  3 40 35 31  6  5 35 
heap:               40 35 35 20 31 15 35 13  6  3  5 

Original array.     28 21  7  3 45 10 41  3 15  5 11 39 
heap:               45 28 41 15 21 39 10  3  3  5 11  7 

Original array.     25 35  0 46 18 17  5 29 38 16 25  3  3 
heap:               46 38 17 35 25  3  5 25 29 16 18  0  3 

Original array.     49 31 37 20 39 33 41 46  1 35  8 17  8  7 
heap:               49 46 41 39 35 33 37 20  1 31  8 17  8  7 

Original array.     11 44 37  5 16 11 22  2 18  4  3  9 11  2  4 
heap:               44 18 37 16 11 11 22  2  5  4  3  9 11  2  4 

Original array.     32 32 41 12 49 28 12  4 17 15 37 33  5 43 48  3 
heap:               49 41 48 17 37 32 43  4 12 15 32 28  5 12 33  3 

Original array.     30 35 12 20  4 30 38 15 20 41 35 39 30  5 46 13 42 
heap:               46 42 41 38 35 35 39 20 20  4 30 12 30  5 30 13 15 

Original array.     42 26 18 41 17 44 49 30  5 27  8 33 21 46  8 45 21 11 
heap:               49 45 46 41 27 33 44 30 11 17  8 18 21 42  8 26 21  5 

Original array.     30 16 34 43 47 45  7 43 18 13 49 21 38  3  3 27 16 11 30 
heap:               49 47 45 43 43 38  7 27 30 13 34 21 30  3  3 16 16 11 18 

Original array.     27 19 15 32 12 10 29 30 34  5  4 26  7 34 29 21  9  6 48  6 
heap:               48 34 34 32 12 26 29 21 30  6  4 10  7 15 29 19  9  6 27  5 

Original array.     11 19 11  5 44 43 36 41 30 44  9 35 39 43 43 21 47 40 38 49  2 
heap:               49 47 43 44 44 39 43 30 40 41  9 11 35 36 43  5 21 19 38 11  2 

Original array.     32 43 29 43  8 37  0 25  2 29 31  3  7  1 24  4 40 10  0 41  2 33 
heap:               43 43 37 40 41 29 24 32 10 31 33  3  7  0  1  4 25  2  0  8  2 29 

Original array.      9 25 31  0  9 16 19 43 40  3  3 19 42 15 31 14 18 49 14 12 45 20  2 
heap:               49 45 42 40 43 25 31 18 31 12 20 16 19 15 19  0 14  9 14  3  9  3  2 

Original array.      6 23 48 15  5 23 25 47 20 18 49  4 28 26 35 21  4 30 34  5  5 29 13 41 
heap:               49 48 41 34 47 35 28 20 30  5 29 25 23 23 26  6  4 15 21  5  5 18 13  4 

Original array.     26 28 27 45 47  0 21 19 44 33 29 47 38 15 39 44 37  1  3 31 33 49 38  1 40 
heap:               49 47 47 44 45 40 39 44 26 33 38 38 27 15 21 19 37  1  3 28 31 29 33  0  1 

Original array.     40 48 48 18 15 45  2 41 27  1 41 16 22 34  6 21 28  9  1 21 42 11 13 22  7 29 
heap:               48 42 48 40 41 45 34 28 27 41 15 22 29  2  6 18 21  9  1  1 21 11 13 16  7 22 

Original array.     24 22 33 34 11 15 47 23 49 33  7 23 31 13 49 47 17 12 39 46 47 28  2 26 16 17  1 
heap:               49 47 49 47 47 31 34 33 39 46 28 26 23 13 24 22 17 12 23 11 33  7  2 15 16 17  1 

Original array.     20 23  9 18 33 27 46 42 32 27  2 11 21 27 47 18  8 25 16  8 25 22 23  3 47 38 15 38 
heap:               47 42 47 32 27 46 38 18 25 25 23 21 38 33 27 18  8 23 16  8 20  2 22  3  9 11 15 27 

Original array.     41 31 44  6 24 15 11 40  7 30 39 16 20 34 11 43 29 33 26 24 25  2 34 45 28 30 17  8 11 
heap:               45 43 44 40 39 41 34 31 33 25 34 28 30 11 11  6 29  7 26 24 24  2 30 15 20 16 17  8 11 

Original array.     25 27 35 26 20 12 25 48 45 43 47 20 34 49  3 45 29 46 11 40 43 39  8 20  7 45 24 24 10 10 
heap:               49 47 48 46 45 45 34 35 45 43 43 20 27 25 10 25 29 26 11 20 40 39  8 12  7 20 24 24 10  3 


           Bottom Up
Original array.      4 
heap:                4 

Original array.      9 47 
heap:               47  9 

Original array.      5  5  8 
heap:                8  5  5 

Original array.      1 18 34 46 
heap:               46 18 34  1 

Original array.     48 39 32 33 26 
heap:               48 39 32 33 26 

Original array.     15 48 48 19 17 46 
heap:               48 19 48 15 17 46 

Original array.     47 22 32 37 21 39 29 
heap:               47 37 39 22 21 32 29 

Original array.     29 22 19 31 44  0  7 34 
heap:               44 34 19 31 22  0  7 29 

Original array.     31 26 16  6 16  0 41 39 43 
heap:               43 39 41 31 16  0 16 26  6 

Original array.     31 35 25  8 29 14 39 19 11 49 
heap:               49 35 39 19 31 14 25  8 11 29 

Original array.     24  4 41 13  9  4  8 45  2  4 16 
heap:               45 24 41 13 16  4  8  4  2  4  9 

Original array.     32 40 40 37 13 47 27 16 22 14 43 43 
heap:               47 43 43 37 40 40 27 16 22 14 13 32 

Original array.     19 42 34 36 22 39 29 24  7 41  3 20 20 
heap:               42 41 39 36 22 34 29 24  7 19  3 20 20 

Original array.     44 32 26 43 37 28 37  2 40 40 46 42  6  2 
heap:               46 44 42 43 40 28 37  2 40 32 37 26  6  2 

Original array.      2 38  6  0  4  3 46 21 18  0  2 20  5  4  4 
heap:               46 38 20 21  4  5  6  0 18  0  2  3  2  4  4 

Original array.     42  5 31 44 32  1 18 39 12 31 29 22 16 22 26 29 
heap:               44 42 31 39 32 22 26 29 12 31 29  1 16 22 18  5 

Original array.     17 13 28 11 21 23 37 49 42  5 39 19 30  3 32 28 30 
heap:               49 42 37 30 39 30 32 28 13  5 21 19 23  3 28 17 11 

Original array.     41 28 49 31 40 30 10  9 37 14 12 18 42 48 32 18 10 12 
heap:               49 40 48 37 28 42 41 18 31 14 12 18 30 10 32  9 10 12 

Original array.     19  2 26 34 21 11  2 30 10 35 17 26  5  5 47 14 43 43 21 
heap:               47 43 26 43 35 19 26 34 21 21 17 11  5  5  2 14 30 10  2 

Original array.     48 46  3 24 22 38  0 44  6 37  5 44 44 38 42 25 24 15 20 19 
heap:               48 46 44 44 37 44 42 25 20 22  5 38  3 38  0 24 24 15  6 19 

Original array.     16  1 16 13 38 41 34  1 18 35  0  7  2 36 37  1 21 36 41 24 27 
heap:               41 38 41 36 35 16 37 21 18 27  0  7  2 36 34  1  1 13  1 24 16 

Original array.     29  8 34 21 43 47 21 38  8 16 48 32 20 18 27 36 43 18  3 18  8 13 
heap:               48 43 47 38 43 34 27 36 18 18 13 32 20 18 21 29 21  8  3 16  8  8 

Original array.     30 36 43 12 38 40 34  6 35 19 37 36  7 40 26 44 25 39  3 45 48  1 19 
heap:               48 45 43 44 38 40 40 25 39 36 37 36  7 34 26  6 12 35  3 30 19  1 19 

Original array.     11 24 49  4 16 40 13 38 45 44 22 42 23 49 44 37 30 42 11 47 26 14 20 16 
heap:               49 47 49 45 44 42 44 38 42 26 22 40 23 13 11 37 30  4 11 16 24 14 20 16 

Original array.     10 42 14 47 15 28 44 20 20 14 43 44 25 10 15 16 33 22 35 24 24 30 21 24 47 
heap:               47 43 47 42 30 44 44 33 35 24 21 28 25 10 15 16 20 22 20 14 24 15 10 24 14 

Original array.     29 47  9 30 20  1 32  2  7  0 26 13 11 42 17  4 27 36 20 48  9 45 11 29 17 41 
heap:               48 47 42 36 45 41 32 27 30 20 29 29 11  9 17  4  2  7 20  0  9 26 11 13 17  1 

Original array.     13 34 31 14 32 42  2 14  4 16  7 14 40 15 48 19 35  1 11 10 46 35 45 41 17 37 29 
heap:               48 46 42 35 45 41 31 19 11 32 35 17 40 15  2 14 14  1  4 10 16 34  7 14 13 37 29 

Original array.     43 18 17 10 42  9 32 35 41  3 16  9 23 11 47 12 23 41 31 24 44 48 15 12 46 20 49 45 
heap:               49 48 47 41 44 46 45 35 41 24 42 17 23 43 32 12 23 10 31 18  3 16 15 12  9 20  9 11 

Original array.     46  7 43 17  7 35 48 26 15 19 10 43  8 26 18 10 23  5 26 17 11 30 22  5 38  4 39 30 15 
heap:               48 30 46 26 22 43 43 23 26 19 10 38 39 30 18 10 17  5 15 17 11  7  7  5 35  4  8 26 15 

Original array.     28 29 23 25 49 27 35 27 22 13 17 20 33  5 28  4 16 30 34 34 38 45  2 47 46 40 39  3 11 48 
heap:               49 45 48 34 38 47 35 27 30 34 29 46 40 11 28  4 16 25 22 28 13 17  2 20 27 33 39  3  5 23 

*/