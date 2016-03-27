public class LPS {
    String lps(String input) {
        int[][] memo = new int[input.length()][input.length()];
        for(int i=0; i<input.length(); i++) {
            memo[i][i] = 1;
        }

        for(int length=2; length <= input.length(); length++) {
            for(int i=0; i< input.length() - length + 1; i++) {
                int j = i + length - 1;
                if((input.charAt(i) == input.charAt(j)) && (length == 2)) {
                    memo[i][j] = 2;
                } else if(input.charAt(i) == input.charAt(j)) {
                    memo[i][j] = 2 + memo[i+1][j-1];
                } else {
                    memo[i][j] = Math.max(memo[i+1][j], memo[i][j-1]);
                }
            }
        }

        int count = memo[0][input.length()-1];
        char[] result = new char[count];
        int i = 0, j = input.length() -1;
        int l = 0, r = count -1;
        while(count > 0) {
            if(memo[i][j] == memo[i+1][j]) {
                i++;
            } else if(memo[i][j] == memo[i][j-1]) {
                j--;
            } else if(memo[i][j] == 2 + memo[i+1][j-1] && ((i+1) <= (j-1))) {
                result[l++] = result[r--] = input.charAt(j);
                i++;
                j--;
                count -= 2;
            } else if(memo[i][j] == 2 && j == i+1) {
                result[l++] = result[r--] = input.charAt(j);
                i++;
                j--;
                count -= 2;
            } else if(memo[i][j] == 1 && i == j) {
                result[l] = input.charAt(j);
                count--;
            }
        }
        return new String(result);
    }
    public static void main(String[] args) {
        LPS lps = new LPS();
        System.out.println(lps.lps("abdasdasdasdasdcba"));
    }
}
