import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q1 2750 수 정렬하기
		// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

		// 방법 2. 기본적인 정렬 알고리즘을 적용하기
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[]  arr = new int[1000];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		
		// 정렬하기
		Quick_Sort(arr, 0, N-1);

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}

		scan.close();
	}
	
	//정수. 퀵정렬
	static void Quick_Sort(int[] array, int left, int right)
	{
		int pivotIndex;
		int pivotNewIndex;

		if (left < right) {
			// 피벗 값 고르기. => 보편적으로 세 값(좌측 끝, 중앙, 우측 끝) 중 중위값을 이용하여 분할한다.
			pivotIndex = Median(left, (left + right) / 2, right);

			pivotNewIndex = Partition(array, left, right, pivotIndex);//pivotNewIndex을 기준으로 분할
			Quick_Sort(array, left, pivotNewIndex - 1);  //left ~ pivotNewIndex-1 정렬
			Quick_Sort(array, pivotNewIndex + 1, right); //pivotNewIndex+1 ~ right 정렬
		}
	}

	// 퀵소트 파티션 분할 함수
	static int Partition(int[] array, int left, int right, int pivotIndex)
	{
		int pivotValue = array[pivotIndex];
		int temp;
		int storeIndex = left;

		// 피벗 값을 끝으로 옮겨 놓는다.
		temp = array[pivotIndex];
		array[pivotIndex] = array[right];
		array[right]=temp;

		for(int i = left ; i<right ; i++){
			if (array[i] <= pivotValue) {
				temp = array[storeIndex];
				array[storeIndex] = array[i]; 
				array[i] = temp;
				storeIndex = storeIndex + 1;
			}
		}
		// 피벗을 두 리스트 사이에 위치시킨다.
		temp = array[right];
		array[right] = array[storeIndex];
		array[storeIndex] = temp; 
		
		return storeIndex;
	}

	//중위값 찾는 함수
	static int Median(int a, int b, int c)
	{
		int ret;
		if (a > b) {
			if (b > c)          ret = b;
			else if (a > c)     ret = c;
			else                ret = a;
		}
		else {
			if (a > c)          ret = a;
			else if (b > c)     ret = c;
			else                ret = b;
		}
		return ret;
	}
}