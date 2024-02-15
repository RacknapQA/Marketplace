package testMaven;

public class RemoveAllDuplicates {
	   public static void main(String[] args) {
	       String str = "yadavi singh";
	       String result = removeDuplicates(str);
	       System.out.println("String after removing duplicate characters: " + result);
	   }
	 
	   public static String removeDuplicates(String str) {
	       StringBuilder sb = new StringBuilder();
	 
	       for (char c : str.toCharArray()) {
	    	   //System.out.println(String.valueOf(c));
	           int index = sb.indexOf(String.valueOf(c));;
	           if (index == -1) {
	               // Character not found, append it
	               sb.append(c);
	               
	           } else {
	               // Character found, remove it
	               sb.deleteCharAt(index);
	           }
	       }
	       return sb.toString();
	   }
	}
