import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class step1 {
    static Character numberCheck(int number,char command){
        if(number<0){
            if(command=='L'){
                return 'R';
            }else{
                return 'L';
            }
        }
        return command;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        StringBuilder sb=new StringBuilder();
        Deque<Character> deque=new LinkedList<>();

        String word=st.nextToken();
        int number=Integer.parseInt(st.nextToken());
        char command=st.nextToken().toUpperCase().charAt(0);

        command=numberCheck(number,command);
        number=Math.abs(number);

        for(int i=0;i<word.length();i++)
            deque.add(word.charAt(i));

        if(command=='L'){
            for(int count=0;count<number;count++){
                deque.addLast(deque.pollFirst());
            }
        }else{
            for(int count=0;count<number;count++){
                deque.addFirst(deque.pollLast());
            }
        }
        for(Character ch:deque)
            sb.append(ch);

        System.out.println(sb);
    }
}
