import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static public void main(String args[]) {
		// Q4	15552	빠른 A+B
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		try {
			int T;
			String inputLine;
			int spaceIndex;
			int A, B;
			int sum;
			int i;
			
			T = Integer.parseInt(br.readLine());
			for(i=0;i<T;i++){
				inputLine = br.readLine();
				spaceIndex = inputLine.indexOf(' ');
				A = Integer.parseInt(inputLine.substring(0, spaceIndex));
				B = Integer.parseInt(inputLine.substring(spaceIndex+1, inputLine.length()));
				
				sum = A + B;
				bw.write(sum + "\n");
			}
			bw.flush();
			bw.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
