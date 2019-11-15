import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Q9 2941  크로아티아알파벳

		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		int len = word.length();
		char ch;
		char preCh = '!';
		char prepreCh = '!';
		int alpha_num = 0;
		int keep = 0;
		String chars = "cdlnsz";
		
		for (int i = 0; i < len; i++) {
			ch = word.charAt(i);
//			System.out.println("i=" + i + " : alpha_num=" + alpha_num + " , keep=" + keep + " | "
//					+ "prepreCh='" + prepreCh + "', preCh='" + preCh + "' , ch='" + ch + "'");
			

			switch (ch) {
			case 'c':
				keep++;
				break;
			case 'd':
				keep++;
				break;
			case 'l':
				keep++;
				break;
			case 'n':
				keep++;
				break;
			case 's':
				keep++;
				break;
			case 'z':
				keep++;
				break;
			default:
				break;
			}
			
			if(keep==3){
				// dz* [* = c, d, l, n, s, z]
				alpha_num += 2;
				keep=1;
			} else 	if (keep == 2) {
				// 1. dz= or dz*
				// 2. dz
				// 3. cc, cd, cl, cn, cs. cz
				//    dc, dd, dl, dn, ds, dz
				//    lc, ld, ll, ln, ls, lz
				//    nc, nd, nl, nn, ns, nz
				//    sc, sd, sl, sn, ss, sz 
				//    zc, zd, zl, zn, zs, zz
				
				// 1. dz= or dz*
				if ((prepreCh == 'd') && (preCh == 'z')) {
					if (ch == '=') {
						alpha_num += 1;
					} else {
						alpha_num += 3;
					}
					keep = 0;
				} 
				// 2. dz
				else if ((preCh == 'd') && (ch == 'z')) {
					// pass
				}
				// 3. cc, cd, cl, cn, cs. cz
				//    dc, dd, dl, dn, ds, dz
				//    lc, ld, ll, ln, ls, lz
				//    nc, nd, nl, nn, ns, nz
				//    sc, sd, sl, sn, ss, sz 
				//    zc, zd, zl, zn, zs, zz
				else if (chars.contains(Character.toString(preCh)) 
						&& chars.contains(Character.toString(ch))) {
					alpha_num += 1;
					keep = 1;
				}else{
					// pass
				}
			} else if (keep == 1) { 
				// 1. c=, c-, d-, lj, nj, s=, z=
				// 2. c*, d*, l*, n*, s*, z*
				// 3. c, d, l, n, s, z
				
				// 1. c=, c-, d-, lj, nj, s=, z=
				// 2. c*, d*, l*, n*, s*, z*
				if (preCh == 'c'){
					if(ch == '=' || ch == '-'){
						alpha_num += 1;
					}else{
						alpha_num += 2;
					}
					keep = 0;
				}else if (preCh == 'd'){
					if(ch == '-'){
						alpha_num += 1;
					}else{
						alpha_num += 2;
					}
					keep = 0;
				}else if (preCh == 'l'){
					if(ch == 'j'){
						alpha_num += 1;
					}else{
						alpha_num += 2;
					}
					keep = 0;
				}else if (preCh == 'n'){
					if(ch == 'j'){
						alpha_num += 1;
					}else{
						alpha_num += 2;
					}
					keep = 0;
				}else if (preCh == 's'){
					if(ch == '='){
						alpha_num += 1;
					}else{
						alpha_num += 2;
					}
					keep = 0;
				}else if (preCh == 'z'){
					if(ch == '='){
						alpha_num += 1;
					}else{
						alpha_num += 2;
					}
					keep = 0;
				}
				
				// 3. c, d, l, n, s, z
				else{
					// pass
				}
			} else { // k == 0 인 경우. [c, d, l, n, s, z를 제외한 나머지]
				alpha_num += 1;
			}
//			System.out.println("i=" + i + " : alpha_num=" + alpha_num + " , keep=" + keep + " | "
//					+ "prepreCh='" + prepreCh + "', preCh='" + preCh + "' , ch='" + ch + "'");
//			System.out.println("=========================================");
			prepreCh = preCh;
			preCh = ch;
		}
		alpha_num += keep;

		System.out.println(alpha_num);

		scan.close();
	}
}