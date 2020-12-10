package step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class step3 {
    static char temp[]=new char[3];
    static char temp2[]=new char[3];
    static char temp3[]=new char[3];
    static HashMap<Integer,String[]> map=new HashMap<>();
    static long start = System.currentTimeMillis();
    private static char[][][] cubeInit(char[][][] cube) {
        for(int k=0;k<6;k++){
            cube=cubeDataInsert(cube,k);
        }
        return cube;
    }

    private static char[][][] cubeDataInsert(char[][][] cube,int k) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                cube[i][j][k]=map.get(k)[0].charAt(0);
            }
        }
        return cube;
    }

    private static void cubeHashmap() {
        map.put(0,new String[]{"B","UP"}); //0일때는 B-UP
        map.put(1,new String[]{"O","Front"}); //1일때는 O-Front
        map.put(2,new String[]{"W","left"}); //2일때는 W-left
        map.put(3,new String[]{"G","back"}); //3일때는 G-back
        map.put(4,new String[]{"Y","right"}); //4일때는 Y-right
        map.put(5,new String[]{"R","bottom"}); //5일때는 R-bottom
    }

    private static void cubeDisplay(char[][][] cube) {
        StringBuilder sb=new StringBuilder();
        for(int k=0;k<6;k++){
            sb.append(map.get(k)[1]+"\n");
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    sb.append(cube[i][j][k]+" ");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static char[][][] cubeMove(char command, char[][][] cube, int count) {
        if(command=='U'){
            top_left_onePush(cube);
        }else if(command=='F'){
            front_right_onePush(cube);
        }else if(command=='R'){
            right_up_onePush(cube);
        }else if(command=='L'){
            left_down_onePush(cube);
        }else if(command=='B'){
            back_left_onePush(cube);
        }else if(command=='D'){
            bottom_right_onePush(cube);
        }else{
            long end = System.currentTimeMillis();
            System.out.println("사용자가 종료를 요청 했습니다.");
            System.out.println("경과시간: "+((end-start)/1000)+"s");
            System.out.println("조작 갯수:"+ (count));
            System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
            System.exit(0);
        }
        return cube;
    }

    private static char[][][] cubeMove(String commandAdd, char[][][] cube) {

        if(commandAdd=="U'"){
            top_right_onePush(cube);
        }else if(commandAdd=="F'"){
            front_left_onePush(cube);
        }else if(commandAdd=="R'"){
            right_down_onePush(cube);
        }else if(commandAdd=="L'"){
            left_up_onePush(cube);
        }else if(commandAdd=="B'"){
            back_right_onePush(cube);
        }else {
            bottom_left_onePush(cube);
        }
        return cube;
    }

    private static void bottom_left_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[2][i][2];
            cube[2][i][2]= cube[2][i][1];
            temp2[i] = cube[2][i][3];
            cube[2][i][3]= temp[i];
            temp3[i] = cube[2][i][4];
            cube[2][i][4]= temp2[i];
            cube[2][i][1]=temp3[i];
        }
    }

    private static void back_right_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[0][i][4];
            cube[0][i][4]= cube[0][i][0];
            temp2[i] = cube[0][i][5];
            cube[0][i][5]= temp[i];
            temp3[i] = cube[0][i][2];
            cube[0][i][2]= temp2[i];
            cube[0][i][0]=temp3[i];
        }
    }

    private static void left_up_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[i][0][0];
            cube[i][0][0]= cube[i][0][1];
            temp2[i] = cube[i][0][3];
            cube[i][0][3]= temp[i];
            temp3[i] = cube[i][0][5];
            cube[i][0][5]= temp2[i];
            cube[i][0][1]=temp3[i];
        }
    }

    private static void right_down_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[i][2][5];
            cube[i][2][5]= cube[i][2][1];
            temp2[i] = cube[i][2][3];
            cube[i][2][3]= temp[i];
            temp3[i] = cube[i][2][0];
            cube[i][2][0]= temp2[i];
            cube[i][2][1]=temp3[i];
        }
    }

    private static void front_left_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[2][i][2];
            cube[2][i][2]= cube[2][i][0];
            temp2[i] = cube[2][i][5];
            cube[2][i][5]= temp[i];
            temp3[i] = cube[2][i][4];
            cube[2][i][4]= temp2[i];
            cube[2][i][0]=temp3[i];
        }
    }

    private static void top_right_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[0][i][4];
            cube[0][i][4]= cube[0][i][1];
            temp2[i] = cube[0][i][3];
            cube[0][i][3]= temp[i];
            temp3[i] = cube[0][i][2];
            cube[0][i][2]= temp2[i];
            cube[0][i][1]=temp3[i];
        }
    }

    private static void bottom_right_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[2][i][4];
            cube[2][i][4]= cube[2][i][1];
            temp2[i] = cube[2][i][3];
            cube[2][i][3]= temp[i];
            temp3[i] = cube[2][i][2];
            cube[2][i][2]= temp2[i];
            cube[2][i][1]=temp3[i];
        }
    }

    private static void back_left_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[0][i][2];
            cube[0][i][2]= cube[0][i][0];
            temp2[i] = cube[0][i][5];
            cube[0][i][5]= temp[i];
            temp3[i] = cube[0][i][4];
            cube[0][i][4]= temp2[i];
            cube[0][i][0]=temp3[i];
        }
    }

    private static void left_down_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[i][0][5];
            cube[i][0][5]= cube[i][0][1];
            temp2[i] = cube[i][0][3];
            cube[i][0][3]= temp[i];
            temp3[i] = cube[i][0][0];
            cube[i][0][0]= temp2[i];
            cube[i][0][1]=temp3[i];
        }
    }

    private static void right_up_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[i][2][0];
            cube[i][2][0]= cube[i][2][1];
            temp2[i] = cube[i][2][3];
            cube[i][2][3]= temp[i];
            temp3[i] = cube[i][2][5];
            cube[i][2][5]= temp2[i];
            cube[i][2][1]=temp3[i];
        }
    }

    private static void front_right_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[2][i][4];
            cube[2][i][4]= cube[2][i][0];
            temp2[i] = cube[2][i][5];
            cube[2][i][5]= temp[i];
            temp3[i] = cube[2][i][2];
            cube[2][i][2]= temp2[i];
            cube[2][i][0]=temp3[i];
        }
    }

    private static void top_left_onePush(char[][][] cube) {
        for(int i=0;i<3;i++) {
            temp[i] = cube[0][i][2];
            cube[0][i][2]= cube[0][i][1];
            temp2[i] = cube[0][i][3];
            cube[0][i][3]= temp[i];
            temp3[i] = cube[0][i][4];
            cube[0][i][4]= temp2[i];
            cube[0][i][1]=temp3[i];
        }
    }

    private static void cubeExit(int count){
        System.out.println("큐브가 제자리로 돌아왔습니다.");
        long end = System.currentTimeMillis();
        System.out.println("경과시간: "+((end-start)/1000)+"s");
        System.out.println("조작 갯수:"+ (count));
        System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
        System.exit(0);
    }

    private static int cubeCommandRunner(String commandList, char[][][] cube,int count,char[][][] cubeEqual) {
        for (int idx = 0; idx < commandList.length(); idx++) {
            char command = commandList.charAt(idx);
            if (idx + 1 != commandList.length() && commandList.charAt(idx + 1) == '\'') {
                String commandAdd = String.valueOf(command);
                commandAdd += commandList.charAt(idx + 1);
                cube = cubeMove(commandAdd, cube);
                System.out.println(command);
                count++;
                idx++;
            } else {
                cubeMove(command, cube, count);
                count++;
                System.out.println(command);
            }
            cubeDisplay(cube);
        }
        if(Arrays.deepEquals(cube,cubeEqual)) {
            cubeExit(count);
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            char cube[][][] = new char[3][3][6];
            char cubeEqual[][][] = new char[3][3][6];
            cubeHashmap();
            cube = cubeInit(cube);
            cubeEqual = cubeInit(cubeEqual);
            cubeDisplay(cube);
            int count=0;
            while (true) {
                System.out.println("<Cube> 명령어를 입력하세요. ");
                String commandList = input.readLine().toUpperCase();
                count=cubeCommandRunner(commandList,cube,count,cubeEqual);
            }

        }
}
