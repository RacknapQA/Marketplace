package testMaven;

public class Reverse {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		  String S1 = "jaiprakashkaul";
		  
		  for (int i=0;i<S1.length();i++) {
			  char ch=S1.charAt(i);
			  //System.out.print(S1.lastIndexOf(ch));
			  if (S1.indexOf(ch) == S1.lastIndexOf(ch)) {
	               System.out.print(ch);
	            }
		  }
		System.out.println("");

}
}
