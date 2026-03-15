import java.util.*;
class Fancy {
    List<Long> numbers ;
    long multiplier = 1;
    long adder = 0;
    int MOD = 1000000007;

    public Fancy(){
        numbers = new ArrayList<>();
    }

    public void append (int val) {
        long num = (val - adder + MOD) % MOD;
        num = (num*solveInverse(multiplier, MOD-2)) %MOD;
        numbers.add(num);

    }

    public void addAll(int inc){
        adder = (adder +inc)% MOD;

    }

    public void multAll(int m ) {
        multiplier = (multiplier * m) %MOD;
        adder = (adder * m) % MOD;

    }

    public int getIndex(int idx){
        if(idx >= number.size())
        return-1;
        long result = (numbers.get(idx) * multiplier + adder) % MOD;
        return (int) result;
    }

    private long solveInverse(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    
}