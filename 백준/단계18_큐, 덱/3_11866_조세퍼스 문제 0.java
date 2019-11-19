import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
		
public class Main {
	public static void main(String[] args) throws IOException {
		
		// 2018-08-06-월  
		// Q3	11866	조세퍼스 문제 0
		// N과 M이 주어지면 (N,M)-조세퍼스 순열을 구하는 프로그램을 작성하시오.
		
		// 입력 : 첫째 줄에 N과 M이 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ M ≤ N ≤ 1,000)
		
		// 출력 : 예제와 같이 조세퍼스 순열을 출력한다.
		// EX) 7 3 => <3, 6, 2, 7, 5, 1, 4>
		
		
		// 기본 알고리즘.
		// 이전 프린터 큐를 기준으로 봤을 때, 1~N의 값을 큐에 넣고, 매번 하나씩 빼서 다시 큐에 넣으면서
		// M번째 숫자를 출력하는 방식은 너무 비효율적이고 오래 걸리는 것 같다.
		
		// 간단하게 ArrayList를 통해서, M번째 숫자를 빼내는 방식으로 구현해야 겠다.
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int N, M;
		String inputStr;
		int spaceIndex;
		int i,j,num;
		inputStr = br.readLine();
		spaceIndex = inputStr.indexOf(' ');
		StringBuilder result = new StringBuilder("");
		
		N = Integer.parseInt(inputStr.substring(0, spaceIndex));
		M = Integer.parseInt(inputStr.substring(spaceIndex+1, inputStr.length()));
		
//		System.out.println(N+","+M);
		
		for(i=1;i<=N;i++){
			numbers.add(i);
		}
		
		result.append("<");
		i=1;
		j=-1;
		while(i<N){
			if(j+M < numbers.size()){
				j = j + M;
			}else{
				j = (j + M) % numbers.size();
			}
			
			num = numbers.get(j);
			result.append(num + ", ");
			i++;
			
			numbers.remove(j);
			if(j!=0){
				j--;
			}else{
				j=numbers.size()-1;
			}
		}
		
		if(j+M < numbers.size()){
			j = j + M;
		}else{
			j = (j + M) % numbers.size();
		}
		num = numbers.get(j);
		result.append(num + ">");
		
		bw.write(result +"\n");
	
		bw.flush();
		bw.close();

		
	}
}