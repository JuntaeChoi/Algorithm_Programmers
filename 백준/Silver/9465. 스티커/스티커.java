import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            int stickers[][] = new int[2][n + 1];
            int dp[][] = new int[2][n + 1];
            StringTokenizer stickerBundle1 = new StringTokenizer(br.readLine(), " ");
            StringTokenizer stickerBundle2 = new StringTokenizer(br.readLine(), " ");

            for (int i = 1; i <= n; i++) {
                stickers[0][i] = Integer.parseInt(stickerBundle1.nextToken());
                stickers[1][i] = Integer.parseInt(stickerBundle2.nextToken());
            }
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
            }
            sb.append(Math.max(dp[0][n], dp[1][n]));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}