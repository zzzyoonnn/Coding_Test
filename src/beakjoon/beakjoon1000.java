package beakjoon;

import java.io.*;
import java.util.*;

public class beakjoon1000 {
  public static void main(String[] args) throws IOException{
    int a, b;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
        
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
        
    System.out.println(a + b);
  }
}
