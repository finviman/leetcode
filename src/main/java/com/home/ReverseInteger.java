package leetcode.easy;

/**
 * Created by liyang on 24/9/2017.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int ori = 103;
        int reversed = reverseInt(ori);
        System.out.println("----"+reversed);
//        System.out.println(getBits(ori));
    }

    private static int reverseInt(int ori) {
        if (ori < 10) {
            return  ori;
        }else{
            int inter = reverseInt(ori / 10);
            System.out.println(inter);
            return ori%10*((int)Math.pow(10,getBits(inter)))+inter;
        }
    }

    private static int getBits(int a) {
        int bits =1;
        while (a > 10) {
            a=a/10;
            bits++;
        }
        return bits;
    }


}
