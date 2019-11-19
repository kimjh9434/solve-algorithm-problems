import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q1 10845 큐

		// 2018-08-01-수

		// 문제
		// 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

		// 명령은 총 여섯 가지이다.

		// push X: 정수 X를 큐에 넣는 연산이다.
		// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// size: 큐에 들어있는 정수의 개수를 출력한다.
		// empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
		// front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

		// 입력
		// 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩
		// 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는
		// 없다.

		// 출력
		// 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

		// 필요한 단계들
		// 1. 명령의 개수 N을 입력받는다.
		// 2. N번 반복한다.
		//  2.1. 명령을 입력받는다.
		//  2.2. 명령의 유형[push, pop, size, empty, front, back]에 따라 처리한다.

		// 다양한 방법으로 스택을 구현할 수 있지만, 맨 처음이므로, 그냥 젤 단순하게 배열록 구현해보겠다.

		Scanner scan = new Scanner(System.in);

		int N;
		IntArrayQueue q = new IntArrayQueue();
		String command;
		int num;
		int i;

		// 알고리즘 수행
		// 1. 명령의 개수 N을 입력받는다.
		N = scan.nextInt();
		command = scan.nextLine();

		// 2. N번 반복한다.
		for (i = 0; i < N; i++) {
			// 2.1. 명령을 입력받는다.
			command = scan.nextLine();

			// 2.2. 명령의 유형[push, pop, size, empty, front, back]에 따라 처리한다.
			if (command.contains("push")) {
				// push X: 정수 X를 큐에 넣는 연산이다.
				num = Integer.parseInt(command.substring(5, command.length()));
				q.enqueue(num);
			} 
			else if (command.contains("pop")) {
				// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				System.out.println(q.dequeue());
			} 
			else if (command.contains("size")) {
				// size: 큐에 들어있는 정수의 개수를 출력한다.
				System.out.println(q.size());
			} 
			// empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
			else if (command.contains("empty")) {
				if (q.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
			else if (command.contains("front")) {
				// front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				System.out.println(q.front());
			} 
			// back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			else {
				System.out.println(q.rear());
			}
		}
	}
}

// 기본적으로는 배열로 구현한 원형큐
class IntArrayQueue {
	private int[] queue = new int[10000];
	private int front = 0; // front가 있는 자리는 사용하지 않고 항상 빈자리로 둠
	private int rear = 0; 

	// enqueue : 정수 num을 큐에 넣는 연산이다.
	public void enqueue(int num) {
		if(!this.isFull() ){
			rear = (rear+1) % queue.length;
			queue[rear] = num;
		}else{
			System.out.println("큐가 포화상태입니다");
		}
	}

	// dequeue : 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int dequeue() {
		int ret;
		if (!this.isEmpty()) { 
			front = (front+1) % queue.length;
			ret = queue[front];
		} else {
//			System.out.println("큐가 공백상태입니다");
			ret = -1;
		}
		return ret;
	}

	public int size() {
		return ((rear - front) % queue.length);
	}

	public boolean isEmpty() {
		return (front == rear);
	}
	
	public boolean isFull() {
		return ((rear+1)%queue.length == front);
	}

	// front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int front() {
		int ret;
		if (!this.isEmpty()) {
			ret = queue[(front+1) % queue.length];
		} else {
			ret = -1;
		}
		return ret;
	}
	
	// rear: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int rear() {
		int ret;
		if (!this.isEmpty()) { 
			ret = queue[rear];
		} else {
			ret = -1;
		}
		return ret;
	}
}