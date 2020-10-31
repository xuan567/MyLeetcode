package 蓝桥杯;

public class shiC {
    public static void main(String[] args) {
        long[] data = new long[20190325];
        data[1]=data[2]=data[3]=1;
        for(int i=4;i<=20190324;i++) {
            data[i] = (data[i-1]+data[i-2]+data[i-3])%10000;
        }
        System.out.println(data[20190324]);
    }
}
