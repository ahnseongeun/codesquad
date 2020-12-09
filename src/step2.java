import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * > U  가장 윗줄을 왼쪽으로 한 칸 밀기 RRW -> RWR
 * > U' 가장 윗줄을 오른쪽으로 한 칸 밀기 RRW -> WRR
 * > R  가장 오른쪽 줄을 위로 한 칸 밀기 WWB -> WBW
 * > R' 가장 오른쪽 줄을 아래로 한 칸 밀기 WWB -> BWW
 * > L  가장 왼쪽 줄을 아래로 한 칸 밀기 RGG -> GRG (L의 경우 R과 방향이 반대임을 주의한다.)
 * > L' 가장 왼쪽 줄을 위로 한 칸 밀기 RGG -> GGR
 * > B  가장 아랫줄을 오른쪽으로 한 칸 밀기 GBB -> BGB (B의 경우도 U와 방향이 반대임을 주의한다.)
 * > B' 가장 아랫줄을 왼쪽으로 한 칸 밀기 GBB -> BBG
 * > Q  Bye~를 출력하고 프로그램을 종료한다.
 */

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

    static void cube_move(char command,char[][] cube){
        if(command=='U'){
            //top_left_onePush(cube);
        }else if(command=='R'){
            //right_up_onePush
        }else if(command=='L'){
            //left_down_onePush
        }else if(command=='B'){
            //bottom_right_onePush
        }else{
            System.out.println("Bye~");
            System.exit(0);
        }
    }

    static void cube_move(String command,char[][] cube){
        if(command.equals("U'")){
            //top_right_onePush(cube);
        }else if(command.equals("R'")){
            //right_down_onePush
        }else if(command.equals("L'")){
            //left_up_onePush
        }else{
            //bottom_left_onePush
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        char cube[][]={{'R','R','W'},
                       {'G','C','W'},
                       {'G','B','B'}};

        cube_display(cube);
        System.out.println("<Cube> 명령어를 입력하세요. ");

        String commandList=input.readLine().toUpperCase();
        for(int idx=0;idx<commandList.length();idx++){
            char command=commandList.charAt(idx);
            if(commandList.charAt(idx+1)=='\'') {
                String commandAdd = String.valueOf(command);
                commandAdd+= commandList.charAt(idx + 1);
                cube_move(commandAdd,cube);
                idx++;
            }else{
                cube_move(command,cube);
            }
            cube_display(cube);
        }

    }
}
