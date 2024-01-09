package programmers.level0;
// 글자 이어 붙여 문자열 만들기

public class Page3_06 {
  public static void main(String[] args) {
    String my_string = "cvsgiorszzzmrpaqpe";
    int[] index_list = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < index_list.length; i++) {
      sb.append(my_string.charAt(index_list[i]));
    }
    System.out.println(sb);
  }
}
