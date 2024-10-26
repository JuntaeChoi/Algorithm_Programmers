import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            card[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            dp[i]=card[i];
            for(int j=1;j<i;j++){
                dp[i]=Integer.max(dp[i],dp[j]+card[i-j]);
            }
        }
        System.out.println(dp[N]);
    }
}