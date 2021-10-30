
public class KangrooJump {

	static String kangaroo(int x1, int v1, int x2, int v2) {
		String res = "NO";
			if(x1>x2) {
				if(v1>v2) {
					res = "NO";
				}else {
					while(x1!=x2) {
						x1 += v1;
						x2 += v2;
					}
					res = "YES";
				}
			}else if(x2>x1) {
					if(v2>v1) {
						res = "NO";
					}else {
						while(x1!=x2) {
							x1 += v1;
							x2 += v2;
						}
						res = "YES";
					}
			}else
				res="YES";
		return res;
    }
	
	public static void main(String[] args) {
//		System.out.println(kangaroo(23, 9867, 9814, 5861));
		System.out.println(kangaroo(63, 8, 94, 3));
	}

}



//-------00----04-------------------------------------
//-------x1----x2-------------------------------------
// 1st iter : x1=3,  x2=6
// 2nd iter : x1=6,  x2=8
// 3rd iter : x1=9,  x2=10
// 4th iter : x1=12, x2=12
