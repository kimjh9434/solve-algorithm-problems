import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Q8 1181 단어 정렬 : 2018-07-24-화
		// 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
		// 길이가 짧은 것부터 & 길이가 같으면 사전 순으로

		// 입력 : 첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로
		// 이루어진
		// 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
		// 출력 : 조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.

		// 필요한 단계들
		// 1. N을 입력받는다.
		// 2. N번 반복한다.
		// 2.1. 문자열을 입력받고,
		// 2.2. 해당 문자열의 길이에 해당하는 배열에 넣는다.
		// 3. 각 문자열의 길이에 따른 배열을 각각 정렬시킨다.
		// 4. 각 문자열 길이에 따른 배열을 순서대로 출력시킨다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N; // 입력받는 단어의 개수
		String word;// 입력받은 단어

		Dictionary dict = new Dictionary();
		int i, j; // 반복제어변수

		// 1. N을 문자열로 입력받는다.
		N = Integer.parseInt(br.readLine());

		// 2. N번 반복한다.
		for (i = 0; i < N; i++) {
			// 2.1. 문자열을 입력받고,
			word = br.readLine();
			// System.out.println(word);

			// 2.2. 해당 문자열의 길이에 해당하는 배열에 넣는다.
			if (dict.wordArrays[word.length() - 1] == null) {
				dict.wordArrays[word.length() - 1] = new WordArray();
			}
			
			// 이때 중복되는 문자열은 제거한다.
			if(!dict.wordArrays[word.length() - 1].words.contains(word)){
				dict.wordArrays[word.length() - 1].words.add(word);
			}
		}

		// 3. 각 문자열의 길이에 따른 배열을 각각 정렬시킨다.
		for (i = 0; i < 50; i++) {
			if (dict.wordArrays[i] != null)
				Collections.sort(dict.wordArrays[i].words);
		}

		// 4. 각 문자열 길이에 따른 배열을 순서대로 출력시킨다.
		for (i = 0; i < 50; i++) {
			if (dict.wordArrays[i] != null) {
				for (j = 0; j < dict.wordArrays[i].words.size(); j++) {
					bw.write(dict.wordArrays[i].words.get(j) + "\n");
				}
			}
		}

		bw.flush();
		bw.close();
	}
}

class Dictionary {
	WordArray[] wordArrays = new WordArray[50];
}

class WordArray {
	ArrayList<String> words = new ArrayList<String>();
}
