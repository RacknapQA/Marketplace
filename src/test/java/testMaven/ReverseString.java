package testMaven;

public class ReverseString {
	static String name="Applea";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReverseString rs= new ReverseString();

		//rs.removeDup();
		//rs.reverseString();
		rs.reverseString2();
	}
	public void removeDup() {
		
		String S1="jaiprakash";
		String S2="";
		char ch;
		
		for (int i=0; i <S1.length();i++) {
			
			ch=S1.charAt(i);

			if (S2.indexOf(ch)== -1)
			{		
				S2=S2+ch;	
			}	
		}
			System.out.println(S2);
		}
	

	public void reverseString() {
		String S1="Yudhvir Kaul";
		  String S2="";
		  char ch;
		  for (int i=S1.length()-1;i>=0;i--) {
			  
			 ch=S1.charAt(i);
			 S2=S2+ch;

		  }
		  System.out.print(S2);  
			}
		 
	
public void reverseString2() {
	String s1="Yudhvir Kaul";
	  String[] s2=s1.split(" ");

	  
	  for (int i=s2.length-1;i>=0;i--) {
		System.out.print(s2[i]+" ")  ;

	  }
 
		}
	 
}
