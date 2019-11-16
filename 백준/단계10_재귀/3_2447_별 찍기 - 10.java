import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		// 2018-09-12-수

		// 3	2447	별찍기 - 10

		// 문제
		// 예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.

		// 입력
		// 첫째 줄에 N이 주어진다. N은 항상 3의 제곱꼴인 수이다. (1, 3, 9, 27, ...) (N=3^k, 0<=k<8)
		// CF. 3^0 = 1 <= N =3^k <= 3^7 = 2187

		// 출력
		// 첫째 줄부터 N번째 줄까지 별을 출력한다.

		// 풀이구상
		// 음... 이것도 그냥 쪼갠다.
		// 대충 SIZE가 3이상이면, 9등분을 하고, 아니면 넘어간다.
		// 길이가 1인 경우는... 걍 예외처리 해야겠다.
		
		// 9등분을 할때, 1,2,3,4,6,7,8,9일때는 SIZE/3의 값으로 채우고,
		// 정중앙인 5는 ' '으로 채운다.


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// N을 입력받는다. [3^0 = 1 <= N =3^k <= 3^7 = 2187]
		int N = Integer.parseInt(br.readLine());
//		int length = (int) Math.pow(3, N);
		
		char[][] stars = new char[N][N];
        
        for(int i=0;i<N;i++) {
	        for(int j=0;j<N;j++) {
	        	stars[i][j]=' ';
	        }
	    }
		
		if(N!=1){
			solve(stars, N, 0, 0);
			
			StringBuilder sb;
			int i, j;
			for(i=0;i<N;i++){
				sb = new StringBuilder();
				for(j=0;j<N;j++){
					sb.append(stars[i][j]);
				}
				bw.write(sb.toString()+"\n");
			}
		}else{
			bw.write("*\n");
		}

		bw.flush();
		bw.close();
	}
	
	public static void solve(char[][] stars, int N, int x, int y){
		
		if(N!=3){
			int n = N/3;
			solve(stars, n, x    , y);     solve(stars, n, x+n  , y);     solve(stars, n, x+2*n, y);
			solve(stars, n, x    , y+n);                                  solve(stars, n, x+2*n, y+n);  
			solve(stars, n, x    , y+2*n); solve(stars, n, x+n  , y+2*n); solve(stars, n, x+2*n, y+2*n);
		}else{
			stars[x][y]   = '*'; stars[x+1][y]   = '*'; stars[x+2][y]   = '*';
			stars[x][y+1] = '*'; stars[x+1][y+1] = ' '; stars[x+2][y+1] = '*';
			stars[x][y+2] = '*'; stars[x+1][y+2] = '*'; stars[x+2][y+2] = '*';
		}
	}
}