package dypro;

/**
 * Created by mapte on 2/11/15.
 */
public class LCS {

    private String longestCommonSubsequence(String first, String second) {
        if(first == null || second == null) {
            return null;
        }
        if(first.isEmpty() || second.isEmpty()) {
            return "";
        }
        if(first.charAt(first.length() - 1) == second.charAt(second.length() - 1)) {
            return longestCommonSubsequence(first.substring(0, first.length()-1), second.substring(0, second.length()-1)) + first.charAt(first.length() - 1);

        } else {
            String lcs1 = longestCommonSubsequence(first.substring(0, first.length()-1), second);
            String lcs2 = longestCommonSubsequence(first, second.substring(0, second.length()-1));
            return lcs1.length() > lcs2.length() ? lcs1 : lcs2;
        }
    }
    
    private String lcsIter(String first, String second) {
    	String[][] lcss = new String[first.length() + 1][second.length() + 1];
    	for(int i = 0; i <= first.length(); i++) {
    		for(int j = 0; j <= second.length(); j++) {
    			if(i == 0 || j == 0) {
    				lcss[i][j] = "";
    			}
    		}
    	}
    	for(int i = 1; i <= first.length(); i++) {
    		for(int j = 1; j <= second.length(); j++) {
    			if(first.charAt(i - 1) == second.charAt(j - 1)) {
    				lcss[i][j] = lcss[i-1][j-1] + first.charAt(i-1);
    			} else if(lcss[i-1][j].length() > lcss[i][j-1].length()) {
    				lcss[i][j] = lcss[i-1][j];
    			} else {
    				lcss[i][j] = lcss[i][j-1];
    			}
    		}
    	}
    	return lcss[first.length()][second.length()];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String first = "ABCHGOQWDP";
        String second = "RBHHHMMOWDSTPU";
        System.out.println("lengths of two strings: " + first.length() + " and " + second.length());
        System.out.println("LCS of "+first+" and " + second + " is: "+ lcs.longestCommonSubsequence(first, second));
        System.out.println("LCS iter of "+first+" and " + second + " is: "+ lcs.lcsIter(first, second));

    }
}
