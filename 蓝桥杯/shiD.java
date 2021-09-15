package 蓝桥杯;

import java.util.HashSet;

public class shiD {
    public static void main(String[] args) {
        HashSet<int[]> hs = new HashSet<>();
        for(int x=1;x<2019;x++){
            for(int y=1;y<2019;y++){
                for(int z=1;z<2019;z++){
                    if(x+y+z==2019){
                        if((String.valueOf(x).indexOf('2')==-1) && (String.valueOf(x).indexOf('4')==-1)
                        &&(String.valueOf(y).indexOf('2')==-1)&&(String.valueOf(y).indexOf('4')==-1)&&
                                (String.valueOf(z).indexOf('2')==-1)&&(String.valueOf(z).indexOf('4')==-1)&&(x!=y&&x!=z&&z!=y)){
                            hs.add(new int[]{x,y,z});
                        }
                    }
                }
            }
        }
        System.out.println(hs.size()/6);
    }
}
