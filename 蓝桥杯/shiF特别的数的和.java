package 蓝桥杯;

public class shiF特别的数的和 {
    public static void main(String[] args) {
        int n = add(40);
        System.out.println(n);
    }

    public static int add(int n){
        int sum = 0;
        for(int i=1;i<=n;i++){
            String s = String.valueOf(i);
            if(s.indexOf('1')!=-1 ||s.indexOf('2')!=-1 ||s.indexOf('9')!=-1 ||s.indexOf('0')!=-1){
                sum+=i;
            }
        }
        return sum;
    }
}
