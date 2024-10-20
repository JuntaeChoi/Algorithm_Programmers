import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double r1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double r2 = Double.parseDouble(st.nextToken());

            double distance = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));

            if(x1==x2&&y1==y2&&r1==r2){
                sb.append("-1\n");
            }
            else if((distance>(r1+r2))||distance<Math.abs(r1-r2)){
                sb.append("0\n");
            }
            else if(distance==(r1+r2)||Math.abs(r1-r2)==distance){
                sb.append("1\n");
            }
            else{
                sb.append("2\n");
            }
        }
        System.out.println(sb);
    }
}