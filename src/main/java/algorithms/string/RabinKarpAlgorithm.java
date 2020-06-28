package algorithms.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RabinKarpAlgorithm {
    public static long M = 1000000007l;

    public static void main(String[] args) {
        RabinKarpAlgorithm rabinKarpAlgorithm = new RabinKarpAlgorithm();
        List<Integer> result = rabinKarpAlgorithm.patternMatch("abbabbvvabcabb","abb");
        System.out.println(Arrays.toString(result.toArray()));
    }


    public List<Integer> patternMatch(String txt, String pattern){
        int k = pattern.length();
        long[] power = getPowerTable(k);
        long patternHashVal = getHashValue(pattern,power);
        long textHashVal = getHashValue(txt.substring(0,k),power);
        List<Integer> result = new ArrayList<>();
        if(textHashVal==patternHashVal){
            result.add(0);
        }
        for(int idx=1;idx<=txt.length()-k;idx++){
            long prev = (txt.charAt(idx-1)%M * power[k-1]%M)%M;
            long next = txt.charAt(idx+k-1);
            textHashVal = ((textHashVal%M) - (prev%M) + M)%M;
            textHashVal = (textHashVal%M + next)%M;
            textHashVal = (textHashVal%M * power[0]%M)%M;
            if(textHashVal==patternHashVal){
                result.add(idx);
            }
        }
        return result;
    }


    private long getHashValue(String pattern, long[] power) {
        long hashValue = 0;
        int pIdx = pattern.length()-1;
        for(int idx=0;idx<pattern.length();idx++){
            hashValue = (hashValue%M + ((long)pattern.charAt(idx)%M * power[pIdx--]%M)%M)%M;
        }
        return hashValue;
    }

    public long[] getPowerTable(int size){
        long[] power = new long[size];
        power[0]=131l;
        for(int idx=1;idx<size;idx++){
            power[idx] = (power[idx-1]%M * 131l)%M;
        }
        return power;
    }
}
