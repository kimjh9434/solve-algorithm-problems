import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q5 10866 덱

		// 2018-08-10-금

		// 문제
		// 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

		// 명령은 총 여덟 가지이다.

		// push_front X: 정수 X를 덱의 앞에 넣는다.
		// push_back X: 정수 X를 덱의 뒤에 넣는다.
		// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을
		// 출력한다.
		// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을
		// 출력한다.
		// size: 덱에 들어있는 정수의 개수를 출력한다.
		// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
		// front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

		// 입력
		// 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘쨰 줄부터 N개의 줄에는 명령이 하나씩
		// 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
		// 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

		// 출력
		// 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

		// 필요한 단계들
		// 1. 명령의 개수 N을 입력받는다.
		// 2. N번 반복한다.
		// 2.1. 명령을 입력받는다.
		// 2.2. 명령의 유형[push_front, push_back, pop_front, pop_back, size, empty,
		// front, back]에 따라 처리한다.

		// 다양한 방법으로 스택을 구현할 수 있지만, 맨 처음이므로, 그냥 젤 단순하게 배열록 구현해보겠다.

		Scanner scan = new Scanner(System.in);

		int N;
		MyDeque d = new MyDeque();
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

			// 2.2. 명령의 유형[push_front, push_back, pop_front, pop_back, size, empty,
			// front, back]에 따라 처리한다.
			if (command.contains("push_front")) {
				num = Integer.parseInt(command.substring(11, command.length()));
				d.add_front(num);
			} else if (command.contains("push_back")) {
				num = Integer.parseInt(command.substring(10, command.length()));
				d.add_rear(num);
			} else if (command.contains("pop_front")) {
				System.out.println(d.delete_front());
			} else if (command.contains("pop_back")) {
				System.out.println(d.delete_rear());
			} else if (command.contains("size")) {
				System.out.println(d.size());
			} else if (command.contains("empty")) {
				if (d.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (command.contains("front")) {
				System.out.println(d.get_front());
			}
			else {
				System.out.println(d.get_rear());
			}
		}
	}
}

class Node{
	private int num;
	private Node prev;
	private Node next;
	
	Node(){
		num = 0;
		prev = null;
		next = null;
	}
	Node(int num){
		this.num = num;
		prev = null;
		next = null;
	}
	Node(int num, Node prev, Node next){
		this.num = num;
		this.prev = prev;
		this.next = next;
	}
	Node(Node n){
		this.num = n.num;
		this.prev = n.prev;
		this.next = n.next;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Node prev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node next() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

// 기본적으로는 이중 연결리스트로 구현한 원형덱
class MyDeque {
	private Node front; // front가 있는 자리는 사용하지 않고 항상 빈자리로 둠
	private Node rear;
	private int length;
	
	MyDeque(){
		front = null;
		rear = null;
		length = 0;
	}
	
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public int size() {
		return length;
	}
	
	// add_front(item) ::= 덱의 앞에 요소를 추가한다.
	public void add_front(int item) {
		Node n = new Node(item);
		if(!isEmpty()){
			front.setPrev(n);
			n.setNext(front);
			front = n;
		}else{
			front = n;
			rear = n;
		}
		length++;
	}
	
	// add_rear(item) ::= 덱의 뒤에 요소를 추가한다.
	public void add_rear(int item) {
		Node n = new Node(item);
		if(!isEmpty()){
			rear.setNext(n);
			n.setPrev(rear);
			rear = n;
		}else{
			front = n;
			rear = n;
		}
		length++;
	}

	// delete_front() ::= 덱의 앞에 있는 요소를 반환한 다음 삭제한다. 
	public int delete_front() {
		int ret = -1;
		if(!isEmpty()){
			ret = front.getNum();
			if(length != 1){
				front = front.next();
				front.setPrev(null);
			}else{
				front = null;
				rear = null;
			}
			length--;
		}
		return ret;
	}
	
	// delete_rear() ::= 덱의 뒤에 있는 요소를 반환한 다음 삭제한다.
	public int delete_rear() {
		int ret = -1;
		if(!isEmpty()){
			ret = rear.getNum();
			if(length != 1){
				rear = rear.prev();
				rear.setNext(null);
			}else{
				front = null;
				rear = null;
			}
			length--;
		}
		return ret;
	}
	
	// get_front() ::= 덱의 앞에서 삭제하지 않고 앞에 있는 요소를 반환한다.
	public int get_front(){
		int ret = -1;
		if(!isEmpty()){
			ret = front.getNum();
		}
		return ret;
	}
	
	// get_rear() ::= 덱의 뒤에서 삭제하지 않고 뒤에 있는 요소를 반환한다.
	public int get_rear(){
		int ret = -1;
		if(!isEmpty()){
			ret = rear.getNum();
		}
		return ret;
	}
}