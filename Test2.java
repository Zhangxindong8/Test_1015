//1000以内的完数(一个数等于他所有因子之和)
public class Test2 {
    public static void main(String[] args) {
        int i,j;
        for(i = 0;i <= 1000;i++){
            int sum = 0;
            for(j = 1;j <= i/2;j++){
                if(i % j == 0){
                    sum +=j;
                }
            }
            if(sum == i){
                System.out.println(i+" ");
            }
        }
    }
}
