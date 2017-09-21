package gcd;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

public class GCD {
    
    public static void main(String[] args) {
        int t = gcdEucledian(1989, 867);
        System.out.println("GCD-Eucledian:\ngcd of 1989, 867: " + t);
        t = gcdEucledian(24, 16);
        System.out.println("gcd of 24, 16: " + t);
        t = gcdPrimeFactors(1989, 867);
        System.out.println("\nGCD-PrimeFactors:\ngcd of 1989, 867: " + t);
        t = gcdPrimeFactors(24, 16);
        System.out.println("gcd of 24, 16: " + t);
    }
    
    public static int gcdPrimeFactors(int a, int b){
        int[] tmp1 = new int[10];
        int[] tmp2 = new int[10];
        int[] res = new int[10];
        int count = 0;
        int tempcount = 0;
        for(int j = 2; j <= a; j++){
            if(a % j == 0){
                tmp1[count++] = j;
                a = a / j;
                j = 1;
            }
        }
        count = 0;
        for(int j = 2; j <= b; j++){
            if(b % j == 0){
                tmp2[count++] = j;
                b = b / j;
                j = 1;
            }
        }
        count = 0;
        
        for (int i = 0; i < tmp1.length; i++) {
            if(tmp1[i] == 0)
                break;
            for (int j = 0; j < tmp2.length; j++) {
                if(tmp1[i] == tmp2[j]){
                    boolean isInRes = false;
                    for (int k = tempcount; k < res.length; k++){
                        if(tmp1[i] == res[k]){
                            isInRes = true;
                            break;
                        }
                    }
                    
                    if(!isInRes){
                        res[count] = tmp1[i];
                        count++;
                    }
                    break;
                }
            }
        }
        
        int result = 1;
        for (int i = 0; i < res.length; i++)
            if(res[i] != 0)
                result *= res[i];
        
        return result;
    }
    
    public static int gcdEucledian(int a, int b){
        if(b == 0)
            return a;
        
        return gcdEucledian(b, a%b);
    }
}
