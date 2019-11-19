import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		// Q3	9012	괄호

		// 2018-07-30-월

		// 문제
		// 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는
		// 문자열이다. 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
		// 여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.

		// 입력
		// 입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다. 입력의 첫 번째 줄에는 입력 데이터의 수를
		// 나타내는 정수 T가 주어진다. 각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 하나의 괄호 문자열의 길이는
		// 2 이상 50 이하이다.

		// 출력
		// 출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한
		// 줄에 하나씩 차례대로 출력해야 한다.

		// 필요한 단계들
		// 1. 테스트 데이터의 개수 자연수 T을 입력받는다.
		// 2. T번 반복한다.
		//  2.1. 괄호 문자열 VPS를 입력받는다.
		//  2.2. 괄호 문자열 VPS의 길이만큼 반복한다.
		//    2.2.1. i번째 문자가 '('인 경우,
		//     2.2.1.1. 스택에 넣는다.
		//    2.2.2. i번째 문자가 ')'인 경우,
		//     2.2.2.1. 스택에서 뺀 값이 '('인지 확인한다. 틀리면 VPS가 아니다.
		//  2.3. 스택에 남아있는 값이 있으면, VPS가 아니다.
		//  2.4. 결과를 출력한다.

		// 다양한 방법으로 스택을 구현할 수 있지만, 이번에도 그냥 젤 단순하게 배열록 구현해보겠다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T;
		ArrayStack s = new ArrayStack();
		String VPS;
		int i, j;
		boolean isVPS;

		// 알고리즘 수행
		// 1. 테스트 데이터의 개수 자연수 T을 입력받는다.
		T = Integer.parseInt(br.readLine());
		// 2. T번 반복한다.
		for (i = 0; i < T; i++) {
			isVPS = true;

			// 2.1. 괄호 문자열 VPS를 입력받는다.
			VPS = br.readLine();
			
			// 2.2. 괄호 문자열 VPS의 길이만큼 반복한다.
			for (j = 0; j < VPS.length(); j++) {
//				System.out.println(VPS.charAt(j) + ", "+s.top());
				// 2.2.1. i번째 문자가 '('인 경우,
				if (VPS.charAt(j) == '(') {
					// 2.2.1.1. 스택에 넣는다.
					s.push('(');
				}
				// 2.2.2. i번째 문자가 ')'인 경우,
				else {
					// 2.2.2.1. 스택에서 뺀 값이 '('인지 확인한다. 틀리면 VPS가 아니다.
					if (s.pop() != '(') {
						isVPS = false;
						break;
					}
				}
			}
			
			// 2.3. 스택에 남아있는 값이 있으면, VPS가 아니다.
			if(!s.empty()){
				isVPS = false;
			}
			
			// 2.4. 결과를 출력한다.
			if (isVPS) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
			s.reset();
		}
		bw.flush();
		bw.close();

	}
}

class ArrayStack {
	private char[] stack = new char[50];
	private int top = -1;
	
	public void reset() {
		top = -1;
	}

	public void push(char ch) {
		stack[++top] = ch;
	}

	public char pop() {
		char ret;
		if (!this.empty()) { // top != -1
			ret = stack[top--];
		} else {
			ret = '-';
		}
		return ret;
	}

	public int size() {
		return (top + 1);
	}

	public boolean empty() {
		return (top == -1);
	}

	public char top() {
		char ret;
		if (!this.empty()) { // top != -1
			ret = stack[top];
		} else {
			ret = '-';
		}
		return ret;
	}
}