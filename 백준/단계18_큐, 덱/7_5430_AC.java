import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// Q7	5430	AC

		// 2018-08-11-토

		// 이런 썅.. 시간초과... 분명 어디서 무한루프를 돌고 있는 걸텐데...
		// 설령 아니더라도 전체 정수의 숫자가 10만개라서 너무 많이 도냐고 그런걸 수도 있다.
		
		// 결국 연결리스트를 써야하는 것인가...
		// 생각해보면, 끽해야 방향만 있고, 맨 처음꺼만 제거하면 되는 거라서 훨~~씬 더 효율적이긴 하겠다.
		// 원형 연결리스트를 구현해야겠다.
		
		// 알고리즘 - 2차 시도
		// 1. 전체 테스트 케이스의 개수 T를 입력받는다.
		// 2. T번 반복한다.
		//  2.0. 초기화를 진행한다.
		//  2.1. 수행할 함수들 p를 입력받는다.
		//  2.2. 배열에 들어있는 수의 개수 n을 입력받는다.
		//  2.3. 수행할 함수들 p에서 D함수의 개수를 센다.
		//  2.4. D함수의 개수가 N보다 작거나 같은지 확인한다.
		//   2.4.1. 그렇다면,
		//    2.4.1.1. n개의, 배열에 들어있는 수들을 연결리스트에 추가한다.
		//    2.4.1.2. p의 함수들의 개수만큼 반복한다.
		//     2.4.1.2.1. 이번 함수가 D일 경우,
		//      2.4.1.2.1.1. 현재 시작지점에 위치한 노드를 지운다. 
		//                 [기타 노드 설정을 통해 현재 원형 연결리스트에서 제거]
		//                 [현재 시작지점의 노드도 다음 방향의 노드로 변경]
		//     2.4.1.2.2. 아닐경우, [=R일 경우]
		//      2.4.1.2.2.1. 방향을 반대로 설정한다.
		//                 [+반대 방향에서 가장 가까운 노드를 시작지점으로 잡는다.]
		//    2.4.1.3. 현재 시작지점으로부터, 현재 방향대로, 현재 원형 연결리스트에 있는 숫자들을 출력한다.
		//   2.4.2. 아니라면,
		//    2.4.2.1. 볼것도 없이 error인 경우로 error를 출력한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		CircularLinkedList list = new CircularLinkedList();
		
		int T;
		String p;
		int N;
		
		String tmpStr;
		int i, j;
		int D_Count;
		
		// 1. 전체 테스트 케이스의 개수 T를 입력받는다.
		T = Integer.parseInt(br.readLine());
		
		// 2. T번 반복한다.
		for(i=0;i<T;i++){
			//  2.0. 초기화를 진행한다.
			list.reset();
			D_Count = 0;
			
			//  2.1. 수행할 함수들 p를 입력받는다.
			p = br.readLine();
			
			//  2.2. 배열에 들어있는 수의 개수 n을 입력받는다.
			N = Integer.parseInt(br.readLine());
			
			//  2.3. n개의, 배열에 들어있는 수들을 입력받는다.
			tmpStr = br.readLine();
			
			// CF. 여기서 에초에, p의 D의 개수가 N보다 클 경우, 바로 error로 보낼 수 있다.
			//  2.3. 수행할 함수들 p에서 D함수의 개수를 센다.
			for(j=0;D_Count<=N && j<p.length();j++){
				if(p.charAt(j) == 'D'){
					D_Count++;
				}
			}
			//  2.4. D함수의 개수가 N보다 작거나 같은지 확인한다.
			//   2.4.1. 그렇다면,
			if(D_Count<=N){
				//    2.4.1.1. n개의, 배열에 들어있는 수들을 연결리스트에 추가한다.
				
				
				tmpStr = tmpStr.substring(1, tmpStr.length()-1);
				st = new StringTokenizer(tmpStr,",");
				while (st.hasMoreTokens()) {
					list.add_rear(Integer.parseInt(st.nextToken()));
				}
				
				//    2.4.1.2. p의 함수들의 개수만큼 반복한다.
				for(j=0;j<p.length();j++){
					//     2.4.1.2.1. 이번 함수가 D일 경우,
					if(p.charAt(j) == 'D'){
						//     2.4.1.2.1.1. 현재 시작지점에 위치한 노드를 지운다. 
						//                 [기타 노드 설정을 통해 현재 원형 연결리스트에서 제거]
						//                 [현재 시작지점의 노드도 다음 방향의 노드로 변경]
						list.delete_front();
					}
					//     2.4.1.2.2. 아닐경우, [=R일 경우]
					else{
						//      2.4.1.2.2.1. 방향을 반대로 설정한다.
						//		                 [+반대 방향에서 가장 가까운 노드를 시작지점으로 잡는다.]
						list.goReverse();
					}
				}
				
				//    2.4.1.3. 현재 시작지점으로부터, 현재 방향대로, 현재 원형 연결리스트에 있는 숫자들을 출력한다.
				System.out.println(list.getListNumbers());
//				bw.write(list.getListNumbers()+"\n");
			}
			//   2.4.2. 아니라면,
			else{
				//    2.4.2.1. 볼것도 없이 error인 경우로 error를 출력한다.
				System.out.println("error");
//				bw.write("error\n");
			}
		}
		
		bw.flush();
		bw.close();

	}
}


class Node{
	private int num;
	private Node prev;
	private Node next;
	
	Node(){
		num = 0;
		prev = this;
		next = this;
	}
	Node(int num){
		this.num = num;
		prev = this;
		next = this;
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

// 기본적으로는 이중 연결리스트로 구현한 원형 연결리스트
class CircularLinkedList {
	private Node startNode; // 시작지점
	private boolean goRight;// 진행방향
	private int length;
	
	CircularLinkedList(){
		startNode = null;
		goRight = true;
		length = 0;
	}
	
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public int size() {
		return length;
	}
	
	// 원형 연결리스트의 뒤에 요소를 추가한다.
	public void add_rear(int item) {
		Node n = new Node(item);
		if(!isEmpty()){
			n.setNext(startNode);
			n.setPrev(startNode.prev());
			startNode.prev().setNext(n);
			startNode.setPrev(n);
		}else{
			startNode = n;
		}
		length++;
	}

	// 원형 연결리스트의 앞의 요소를 제거한다.
	public void delete_front() {
		if(!isEmpty()){
			if(length != 1){
				startNode.next().setPrev(startNode.prev());
				startNode.prev().setNext(startNode.next());
				if(goRight){
					startNode = startNode.next();
				}else{
					startNode = startNode.prev();
				}
			}else{
				startNode = null;
			}
			length--;
		}
	}
	
	// 원형 연결리스트의 방향을 반대방향으로 전환한뒤, 한칸 움직인다.
	public void goReverse(){
		if(!isEmpty()){
			if(goRight){
				goRight=false;
			}else{
				goRight=true;
			}
			if(goRight){
				startNode=startNode.next();
			}else{
				startNode=startNode.prev();
			}
		}
	}
	
	public StringBuilder getListNumbers(){
		StringBuilder sb = new StringBuilder("[");
		Node n;
		if(!isEmpty()){
			sb.append(startNode.getNum());

			if(goRight){
				n = startNode.next();
				while(n!=startNode){
					sb.append(","+n.getNum());
					n = n.next();
				}
			}else{
				n = startNode.prev();
				while(n!=startNode){
					sb.append(","+n.getNum());
					n = n.prev();
				}
			}
		}
		sb.append("]");
		
		return sb;
	}
	
	public void reset(){
		startNode = null;
		goRight = true;
		length = 0;
	}
}