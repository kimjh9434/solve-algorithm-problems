import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		// Q6 1874 스택 수열

		// 2018-07-28-토

		// 문제
		// 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
		// 이 때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
		// 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
		// 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
		// 이를 계산하는 프로그램을 작성하라.

		// 입력
		// 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
		// 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
		// 물론 같은 정수가 두 번 나오는 일은 없다.

		// 출력
		// 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
		// push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

		
		// 필요한 단계들
		// 1. 자연수 n을 입력받는다.
		// 2. n번 반복한다.
		//  2.1. 수열을 이루는 1이상 n이하의 정수 num을 입력받는다.
		//  2.2. num의 숫자에 따라서 적절하게 처리한다.
		//   2.2.1. num이 스택에 넣어야하는 숫자보다 작은 경우,
		//    2.2.1.1. 스택에서 숫자를 뺀다(-). 이때 이 숫자가 num이면 pass, 아니면 fall
		//   2.2.2. num이 스택에 넣어야하는 숫자보다 큰 경우,
		//    2.2.2.1. 스택에 넣어야하는 숫자가 num보다 작은동안, 스택에 넣는다(+).
		//   2.2.3. num이 스택에 넣어야하는 숫자와 같은 경우,
		//    2.2.3.1. 스택에 숫자 num을 넣고(+) 뺀다(-).
		// 3. 결과를 출력한다.
		
		
		// 다양한 방법으로 스택을 구현할 수 있지만, 이번에도 그냥 젤 단순하게 배열록 구현해보겠다.

		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n, num, stackNum, tmpNum;
		ArrayStack s = new ArrayStack();
		String[] plus_minus = new String[200000];
		int arrayIndex=0;
		int i;
		boolean isOK = true;

		// 알고리즘 수행
		// 1. 자연수 n을 입력받는다.
		n = Integer.parseInt( br.readLine() );
		stackNum = 1;
		
		// 2. n번 반복한다.
		for (i = 0; i < n; i++) {
			// 2.1. 수열을 이루는 1이상 n이하의 정수 num을 입력받는다.
			num = Integer.parseInt( br.readLine() );

			// 2.2. num의 숫자에 따라서 적절하게 처리한다.
			
			// 2.2.1. num이 스택에 넣어야하는 숫자보다 작은 경우,
			if(num < stackNum){
				// 2.2.1.1. 스택에서 숫자를 뺀다(-). 이때 이 숫자가 num이면 pass, 아니면 fall
				tmpNum = s.pop();
				plus_minus[arrayIndex++]="-";
				
				if(tmpNum != num){
					isOK = false;
				}
			}
			// 2.2.2. num이 스택에 넣어야하는 숫자보다 큰 경우,
			else if(num > stackNum){
				// 2.2.2.1. 스택에 넣어야하는 숫자가 num보다 작은동안, 스택에 넣는다(+).
				while(stackNum < num){
					s.push(stackNum);
					plus_minus[arrayIndex++]="+";
					stackNum++;
				}
			}
			
			// 2.2.3. num이 스택에 넣어야하는 숫자와 같은 경우,
			if(num == stackNum){
				// 2.2.3.1. 스택에 숫자 num을 넣고(+) 뺀다(-).
				s.push(stackNum);
				plus_minus[arrayIndex++]="+";
				stackNum++;
				tmpNum = s.pop(); // 이 경우, tmpNum는 사실 필요없다.
				plus_minus[arrayIndex++]="-";
			}
		}
		
		// 3. 결과를 출력한다.
		if(isOK){
			for (i = 0; i < 2*n; i++) {
				bw.write(plus_minus[i]+"\n");
			}
		}else{
			bw.write("NO\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}

class ArrayStack{
	private int[] stack = new int[100000];
	private int top = -1;
	
	public void push(int num){
		stack[++top] = num;
	}
	
	public int pop(){
		int ret;
		if (!this.empty()) { // top != -1
			ret = stack[top--];
		} else {
			ret = -1;
		}
		return ret;
	}
	
	public int size(){
		return (top + 1);
	}
	
	public boolean empty(){
		return (top == -1);
	}
	
	public int top(){
		int ret;
		if (!this.empty()) { // top != -1
			ret = stack[top];
		} else {
			ret = -1;
		}
		return ret;
	}
}