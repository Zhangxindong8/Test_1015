//水仙花数（三位整数如果它的各位数字的立方之和等于这个三位数）
public class Test4 {
    public static void main(String[] args) {
        int i;
        for( i = 100;i < 1000;i++){
            int g = i % 10;
            int s = i/10 % 10;
            int b = i % 100;
            if(i == g*g*g+s*s*s+b*b*b){
                System.out.println();
            }
        }
    }
}
