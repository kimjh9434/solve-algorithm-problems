import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
		
public class Main {
	public static void main(String[] args) throws IOException {
		
		//5차 시도. 그게 아니었다. 이번에도 런타임 에러가 떠서 예제를 다양하게 입력해보니,
		// (k-1)%length 에서 EX) -1%10 일때, 9가 되는 것이 아니라 그대로 -1의 값인걸 몰랐다...
		// 그냥 다시 BufferedReader로 돌아와야겠다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		ArrayList<ArrayList<Document>> lists = new ArrayList<ArrayList<Document>>();
		ArrayList<Document> list;
		
		int T, M; // N은 StringTokenizer로 받으니까 필요가 없어짐 
		int i, j, k;
		int inputNum;
		int order;
		Document doc;
		String inputLine;
		int spaceIndex;
		int targetPrioirty=0;
		StringTokenizer st;
		boolean isFirst;
		int lastIndex;
		boolean isOverpass;
		
		int ii, jj, minIndex; // 정렬용

		// 1. test case의 개수 T를 입력받는다.
		T = Integer.parseInt(br.readLine());

		// 2. T번 반복한다. 
		for (i = 0; i < T; i++) {
			// 2.1. N, M을 입력받는다.
			inputLine = br.readLine();
			spaceIndex = inputLine.indexOf(' ');
			// N = Integer.parseInt(inputLine.substring(0, spaceIndex));
			M = Integer.parseInt(inputLine.substring(spaceIndex + 1, inputLine.length()));

			// 2.2. N번 반복한다. [lists를 채운다]
			// 2.2.1. 각 문서의 중요도들을 입력받는다.
			st = new StringTokenizer(br.readLine());
			j=0;
			while (st.hasMoreTokens()) {
				inputNum = Integer.parseInt(st.nextToken());

				//   2.2.2. 각 문서의 중요도와 순서 정보를 가진 문서 객체를 만든다.
				doc = new Document(j, inputNum);
				
				//   2.2.3. 이 문서의 중요도가 처음나오는 문서의 중요도라면,	
				isFirst = true;
				for(k=0;k<lists.size();k++){
					if(lists.get(k).get(0).priority == doc.priority){
						isFirst = false;
						break;
					}
				}
				
				if(isFirst){
					//    2.2.3.1. 해당 문서의 중요도의 ArrayList를 새로 하나 만들고,
					list = new ArrayList<Document>();
					
					//    2.2.3.2. 새로 만든  ArrayList에 이 문서를 넣은 후,
					list.add(doc);
					
					//    2.2.3.3. 이 list를 lists에 넣는다.
					lists.add(list);
				}
				//   2.2.4. 해당 중요도 ArrayList가 존재한다면,
				else{
					//    2.2.4.1. 기존의 ArrayList에 이 문서를 넣는다.			
					lists.get(k).add(doc);
				}
				
				// CF. 목표로 하는 M번째 문서의 우선순위가 몇인지 확인한다.
				if(j == M){
					targetPrioirty = doc.priority;
				}
				j++;
			}
			
			
			//  2.3. ArrayList들을  중요도순으로 내림차순 정렬한다. -- 일단은 선택정렬을 이용함.
			for (ii = 0; ii<lists.size() - 1; ii++)
			{
				// 정렬되기 전 배열의 제일 작은 수를 찾는다.
				minIndex = ii;
				for (jj = ii + 1; jj<lists.size(); jj++)
				{
					if (lists.get(jj).get(0).priority > lists.get(minIndex).get(0).priority) {
						minIndex = jj;
					}
				}
				if (ii != minIndex)// 정렬되기 전 배열에서 제일 작은수를, 정렬되기 전 배열의 맨 앞의 수와 자리를 바꾼다.
				{
					list = lists.get(ii);
					lists.set(ii, lists.get(minIndex));
					lists.set(minIndex, list);
				}
			}
			
			//  2.4. 찾고자 하는 M번째 문서가 몇번째로 인쇄되는지를 구한다.
			j=0;
			order = 0;
			lastIndex = -1;
			
			//   2.4.1. 찾고자 하는 M번째 문서의 우선순위를 포함하는 list가 나올때까지 반복한다.
			while(targetPrioirty != lists.get(j).get(0).priority){
				//    2.4.1.1. 이 list가 찾고자 하는 M번째 문서의 우선순위를 포함하는 list가 아니라면,
				//     2.4.1.1.1. 이 list에서 맨 마지막으로 인쇄된 문서의 order 및 index를 구한다.
				if(lists.get(j).size() == 1){
					lastIndex = lists.get(j).get(0).index;
					order += 1;
				}else{
					k=0;
					isOverpass = false;
					while(!isOverpass && k < lists.get(j).size()){
						if(lists.get(j).get(k).index > lastIndex){
							isOverpass = true;
							break;
						}
						k++;
					}
					if(!isOverpass || k==0){
						lastIndex = lists.get(j).get(lists.get(j).size()-1).index;
					}else{
						lastIndex = lists.get(j).get(k-1).index;
					}
					order += lists.get(j).size();
				}
				j++;
			}
			
			//   2.4.2. 해당 list에서 찾고자 하는 M번째 문서가 몇번째로 나오는지를 구한다.
			list = lists.get(j);
			
			if(list.size() == 1){
				lastIndex = list.get(0).index;
				order += 1;
			}else{
				k=0;
				isOverpass = false;
				while(!isOverpass && k < list.size()){
					if(list.get(k).index > lastIndex){
						isOverpass = true;
						break;
					}
					k++;
				}
				if(!isOverpass){
					k=0;
				}
				
				order+=1;
				while(list.get(k).index != M){
					k = (k+1)%list.size();
					order++;
				}
			}
			
			
			//  2.5. 결과를 출력한다.
			bw.write(order + "\n");

			//  2.6. 초기화한다.
			lists.clear();
		}
		bw.flush();
		bw.close();

		
	}
}

class Document{
	int index;
	int priority;

	Document(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
}