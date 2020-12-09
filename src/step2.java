import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class step2 {
    static void cube_display(char[][] cube){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                sb.append(cube[i][j]+" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st=new StringTokenizer(input.readLine());
        char cube[][]={{'R','R','W'},
                       {'G','C','W'},
                       {'G','B','B'}};
        cube_display(cube);
    }
}
