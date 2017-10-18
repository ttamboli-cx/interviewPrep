package dp;

public class textJustification {
	public static void main(String[] args) {
		//String words[] = {"Tushar", "Roy", "likes", "to", "code"};
		//String opt = justify(words, 10);
		String words1[] = {"Tushar","likes","to","write","code","at", "free", "time"};
		String opt = justify(words1, 12);
		System.out.println(opt);
	}
	
	public static String justify(String words[], int width) {
		int[][] cost = new int[words.length][words.length];
		for(int i = 0; i < words.length; i++) {
			cost[i][i] = width-words[i].length();
			for(int j = i+1; j < words.length; j++) {
				cost[i][j] = cost[i][j-1] - words[j].length()-1;
			}
		}
		for(int i = 0; i < words.length; i++) {
			for(int j = i; j < words.length; j++) {
				if(cost[i][j] < 0)
					cost[i][j] = Integer.MAX_VALUE;
				else
					cost[i][j] = (int) Math.pow(cost[i][j], 2);
			}
		}
		
		int[] minCost = new int[words.length];
		int[] result = new int[words.length];
		
		for(int i = words.length-1; i >= 0; i--) {
			minCost[i] = cost[i][words.length-1];
			result[i] = words.length;
			for(int j = words.length-1; j >i; j--) {
				if(cost[i][j-1] == Integer.MAX_VALUE)
					continue;
				if(minCost[i] > minCost[j] + cost[i][j-1]) {
					minCost[i] = minCost[j] + cost[i][j-1];
					result[i] = j;
				}
			}
		}
		
		int i = 0;
		int j;
		System.out.println("Minimum cost is " + minCost[0]);
		
		StringBuilder sb = new StringBuilder();
		do {
			j = result[i];
			for(int k = i; k < j; k++) {
				sb.append(words[k] + " ");
			}
			sb.append("\n");
			i = j;
		}while(j < words.length);
		
		return sb.toString();
	}	
}