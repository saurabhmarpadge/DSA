package algorithms.bits;

public class NextPowerOf2 {
    public static int nextPowerOf2(int num){
        if(num==0){
            return 1;
        }
        if(num>0&&(num&(num-1))==0){
            return num;
        }
        while((num&(num-1))!=0){
            num =num&(num-1);
        }
        return num<<1;
    }
}
