package step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class step3 {
    static HashMap<Integer,String[]> map=new HashMap<>();
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

    private static char[][][] cubeMove(char commandAdd, char[][][] cube) {

    }

    private static char[][][] cubeMove(String commandAdd, char[][][] cube) {

    }

    public static void main(String[] args) throws Exception {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            char cube[][][] = new char[3][3][6];
            cubeHashmap();
            cube = cubeInit(cube);
            cubeDisplay(cube);

            while (true) {
                System.out.println("<Cube> 명령어를 입력하세요. ");
                String commandList = input.readLine().toUpperCase();
                for (int idx = 0; idx < commandList.length(); idx++) {
                    char command = commandList.charAt(idx);
                    if (idx + 1 != commandList.length() && commandList.charAt(idx + 1) == '\'') {
                        String commandAdd = String.valueOf(command);
                        commandAdd += commandList.charAt(idx + 1);
                        cube = cubeMove(commandAdd, cube);
                        System.out.println(command);
                        idx++;
                    } else {
                        cubeMove(command, cube);
                        System.out.println(command);
                    }
                    cubeDisplay(cube);
                }
            }

        }
}
