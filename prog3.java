import java.io.*;
import java.util.*;

 /*--------------------------------------------------
    Author: Tum Jomkhanthiphol
    Class: COMP282 (M & W, 2:00 - 3:15 pm)
    Assignment #3
    Date handed in: 
    Programming assignment #3, Sorting Algorithms
   --------------------------------------------------*/

// Used to return the two pivots in the 2-pivot partition
class Pair {
  public int left, right;
  public Pair(int left, int right) {
    this.left = left;
    this.right = right;
  }
}

// Class to hold all the sorts and their associated methods
class ArraySorts {
  public static String myName() {
    return "Tum Jomkhanthiphol";
  }

  public static void insertionSort(int a[], int n) {
    for (int i = 1; i < n; i++) {
      int val = a[i];
      int j = i - 1;
      while (j >= 0 && a[j] > val) {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = val;
    }
  }

  public static void QS_OutsideIn_randomPivot(int a[], int n, int cutoff) {
    QS_OutsideIn_randomPivot(a, 0, n - 1, cutoff);
    insertionSort(a, n);
  }

  private static void QS_OutsideIn_randomPivot(int a[], int lf, int rt, int cutoff) {
    if (lf >= rt)
      return;
    int pivot;
    while ((rt - lf + 1) >= cutoff) {
      pivot = lf + (int) (Math.random() * (rt - lf + 1));
      pivot = partitionOutsideIn(a, lf, rt, pivot);
      if ((pivot - lf) < (rt - pivot)) {
        QS_OutsideIn_randomPivot(a, lf, pivot - 1, cutoff);
        lf = pivot + 1;
      } 
      else {
        QS_OutsideIn_randomPivot(a, pivot + 1, rt, cutoff);
        rt = pivot - 1;
      }
    }
  }

  public static void QS_LeftToRight_randomPivot(int a[], int n, int cutoff) {
    QS_LeftToRight_randomPivot(a, 0, n - 1, cutoff);
    insertionSort(a, n);
  }

  private static void QS_LeftToRight_randomPivot(int a[], int lf, int rt, int cutoff) {
    if (lf >= rt)
      return;
    int pivot;
    while ((rt - lf + 1) >= cutoff) {
      pivot = lf + (int) (Math.random() * (rt - lf + 1));
      pivot = partitionLeftToRight(a, lf, rt, pivot);
      if ((pivot - lf) < (rt - pivot)) {
        QS_LeftToRight_randomPivot(a, lf, pivot - 1, cutoff);
        lf = pivot + 1;
      } 
      else {
        QS_LeftToRight_randomPivot(a, pivot + 1, rt, cutoff);
        rt = pivot - 1;
      }
    }
  }

  public static void QuickSort_2Pivot_BothRandom(int a[], int n, int cutoff) {
    QuickSort_2Pivot_BothRandom(a, 0, n - 1, cutoff);
    insertionSort(a, n);
  }

  private static void QuickSort_2Pivot_BothRandom(int a[], int lf, int rt, int cutoff) {
    if (lf >= rt)
      return;
    Pair pivot = new Pair(0, 0);

    while ((rt - lf + 1) >= cutoff) {
      pivot.left = lf + (int) (Math.random() * (rt - lf + 1));
      pivot.right = lf + (int) (Math.random() * (rt - lf + 1));

      // swap left and right pivot if left value is bigger
      if (a[pivot.left] > a[pivot.right]) {
        int tempPivot = pivot.left;
        pivot.left = pivot.right;
        pivot.right = tempPivot;
      }

      pivot = partition2Pivot(a, lf, rt, pivot.left, pivot.right);
      
      if ((pivot.left - lf) < (rt - pivot.right)) {
        QuickSort_2Pivot_BothRandom(a, lf, pivot.left - 1, cutoff);
        lf = pivot.left + 1;
      } 
      if ((pivot.left - lf) == (rt - pivot.right)) {
        QuickSort_2Pivot_BothRandom(a, pivot.left + 1, pivot.right - 1, cutoff);
        lf = pivot.left + 1;
        rt = pivot.right - 1;
      }
      else {
        QuickSort_2Pivot_BothRandom(a, pivot.right + 1, rt, cutoff);
        rt = pivot.right - 1;
      }
    }
  }

  public static void QS_OutsideIn_lfPivot(int a[], int n, int cutoff) {
    QS_OutsideIn_lfPivot(a, 0, n - 1, cutoff);
    insertionSort(a, n);
  }

  private static void QS_OutsideIn_lfPivot(int a[], int lf, int rt, int cutoff) {
    if (lf >= rt)
      return;
    int pivot;
    while ((rt - lf + 1) >= cutoff) {
      pivot = lf + (int) (Math.random() * (rt - lf + 1));
      pivot = partitionOutsideIn(a, lf, rt, pivot);
      if ((pivot - lf) < (rt - pivot)) {
        QS_OutsideIn_lfPivot(a, lf, pivot - 1, cutoff);
        lf = pivot + 1;
      } 
      else {
        QS_OutsideIn_lfPivot(a, pivot + 1, rt, cutoff);
        rt = pivot - 1;
      }
    }
  }

  public static void QS_LeftToRight_lfPivot(int a[], int n, int cutoff) {
    QS_LeftToRight_lfPivot(a, 0, n - 1, cutoff);
    insertionSort(a, n);
  }

  private static void QS_LeftToRight_lfPivot(int a[], int lf, int rt, int cutoff) {
    if (lf >= rt)
      return;
    int pivot;
    while ((rt - lf + 1) >= cutoff) {
      pivot = lf + (int) (Math.random() * (rt - lf + 1));
      pivot = partitionLeftToRight(a, lf, rt, pivot);
      if ((pivot - lf) < (rt - pivot)) {
        QS_LeftToRight_lfPivot(a, lf, pivot - 1, cutoff);
        lf = pivot + 1;
      } 
      else {
        QS_LeftToRight_lfPivot(a, pivot + 1, rt, cutoff);
        rt = pivot - 1;
      }
    }
  }

  public static void AlmostQS_OutsideIn_randomPivot(int a[], int n, int cutoff) {
    QS_OutsideIn_randomPivot(a, 0, n - 1, cutoff);
  }

  public static void AlmostQS_LeftToRight_randomPivot(int a[], int n, int cutoff) {
    QS_LeftToRight_randomPivot(a, 0, n - 1, cutoff);
  }

  public static void AlmostQuickSort_2Pivot_BothRandom(int a[], int n, int cutoff) {
    QuickSort_2Pivot_BothRandom(a, 0, n - 1, cutoff);
  }

  public static int partitionOutsideIn(int a[], int lf, int rt, int pivot) {
    int pivotValue = a[pivot];
    int firstIndex = lf;
    int lastIndex = rt;

    // swap pivot and firstIndex
    a[pivot] = a[firstIndex];
    a[firstIndex] = pivotValue;

    lf = lf + 1;

    while (lf < rt) {
      while ((a[lf] <= pivotValue) && (lf < rt)) {
        lf++;
      }

      while ((a[rt] >= pivotValue) && (lf < rt)) {
        rt--;
      }

      if (lf < rt) {
        // swap values of the left & right pointers
        int temp = a[lf];
        a[lf] = a[rt];
        a[rt] = temp;
      }
    }

    // swap pivot and rt
    if (a[rt] < a[firstIndex]) {
      int temp = a[firstIndex];
      a[firstIndex] = a[rt];
      a[rt] = temp;
    }
    else {
      rt = rt - 1;
      int temp = a[firstIndex];
      a[firstIndex] = a[rt];
      a[rt] = temp;
    }

    return rt;
  }

  public static int partitionLeftToRight(int a[], int lf, int rt, int pivot) {
    int pivotValue = a[pivot];
    int firstIndex = lf;

    // swap pivot and firstIndex
    a[pivot] = a[firstIndex];
    a[firstIndex] = pivotValue;

    int lastSmall = lf;
    int firstUn = lf + 1;

    while (firstUn < rt) {
      firstUn++;
      if (a[firstUn] < pivotValue) {
        lastSmall++;
        int save = a[firstUn];
        a[firstUn] = a[lastSmall];
        a[lastSmall] = save;
      }
    }

    // swap firstIndex and lastSmall
    int save = a[lastSmall];
    a[lastSmall] = a[firstIndex];
    a[firstIndex] = save;

    return lastSmall;
  }

  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static Pair partition2Pivot(int a[], int lf, int rt, int pivotl, int pivotr) {
    int lfPivotVal = a[pivotl];
    int rtPivotVal = a[pivotr];

    // swap pivotl with firstIndex, then pivotr with lastIndex
    a[pivotl] = a[lf];
    a[lf] = lfPivotVal;

    a[pivotr] = a[rt];
    a[rt] = rtPivotVal;

    int lastSmall = lf + 1;
    int firstUn = lf + 1;
    int firstBig = rt - 1;

    while (firstUn <= firstBig) {
      if (a[firstUn] < lfPivotVal) {
        swap(a, firstUn, lastSmall);
        lastSmall++;
      }

      else if (a[firstUn] >= rtPivotVal) {
        while (a[firstBig] > rtPivotVal && firstUn < firstBig) {
          firstBig--;
        }

        swap(a, firstUn, firstBig);
        firstBig--;

        if (a[firstUn] < lfPivotVal) {
          swap(a, firstUn, lastSmall);
          lastSmall++;
        }
      }
      firstUn++;
    }

    lastSmall--;
    firstBig++;

    // swap positions of left pivot & lastSmall and right pivot & firstBig
    swap(a, lf, lastSmall);
    swap(a, rt, firstBig);

    Pair pair = new Pair(lastSmall, firstBig);
    return pair; 
  }

  public static void HeapSortBottomUp(int a[], int n) {
    int lfLeaf, rtLeaf, parent, temp;

    // 2 special cases (if array size is 0 1 or 2)
    if (n == 0 || n == 1)
      return;

    if (n == 2) {
      if (a[1] > a[0]) {
        temp = a[1];
        a[1] = a[0];
        a[0] = temp;
      }
      return;
    }

    // check if n is an even or odd number to determine how to start off
    if (n % 2 == 0) {
      lfLeaf = n;
      parent = n / 2;
      if (a[lfLeaf] > a[parent]) {
        temp = a[lfLeaf];
        a[lfLeaf] = a[parent];
        a[parent] = temp;
        n--;
      }
    }

    for (int i = n - 1; i > 0; i -= 2) {
      lfLeaf = a[i - 1];
      rtLeaf = a[i];
      trickleDown(a, lfLeaf, rtLeaf);
    }
  }

  public static void HeapSortTopDown(int a[], int n) {
    // build heap
    for (int i = n / 2 - 1; i >= 0; i--)
      createHeap(a, n, i);

    // sort
    for (int i = n - 1; i >= 0; i--) {
      // swaps first & last element
      int temp = a[0];
      a[0] = a[i];
      a[i] = temp;
  
      // heapifies root 
      createHeap(a, i, 0);
    }
  }

  public static void trickleDown(int a[], int lf, int rt) {
    int i, temp;
    int parent = lf / 2;

    if (a[lf] < a[parent] && a[rt] < a[parent])
      return;

    if (a[lf] > a[rt])
      i = lf;
    else
      i = rt;

    temp = a[parent];
    a[parent] = a[i];
    a[i] = temp;

    if ((i * 2 + 1 == a.length - 1) && a.length % 2 == 0) {
      int k = i * 2 + 1; 
      if (a[k] > a[i]) {
        temp = a[k];
        a[k] = a[i];
        a[i] = temp;
      }
    }

    else if (i * 2 + 1 <= a.length - 1) {
      trickleDown(a, i * 2 + 1, i * 2 + 2);
    }
  }

  public static void trickleUp(int a[], int rt) {
    int i;
    if (rt % 2 == 0)
      i = rt / 2 - 1;
    else
      i = rt / 2;

    int temp = a[i];
    a[i] = a[rt];
    a[rt] = temp;
  }

  public static void createHeap(int a[], int n, int i) {
    // to find largest between root, left, and right
    int largest = i;
    int lf = 2 * i + 1;
    int rt = 2 * i + 2;

    if (lf < n && a[lf] > a[largest])
      largest = lf;

    if (rt < n && a[rt] > a[largest])
      largest = rt;

    // in case root is not largest + recursion
    if (largest != i) {
      trickleUp(a, largest);
      createHeap(a, n, largest);
    }
  }
}