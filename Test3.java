import javax.sound.sampled.SourceDataLine;

//满足1！+2！+·+n！<=9999的最大整数n
public class Test3 {
    public static void main(String[] args) {
        int num = 1;
        int n = 1;
        while(true){
            if(num<9999){
                n++;
                num+=factorial(n);
            }
            break;
        }
        System.out.println(n);
    }
    public static long factorial(int i){
        if (i == 1) {
            return 1;
        }
        return i*factorial(i-1);
    }
}
