class Solution {
    //Important : Check and DRY run the prime number method (Uses Sieve Method). 
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> res=new ArrayList<>();
        //using sieve method. (very optimized method for prime numbers).
        boolean prime[]=new boolean[n+1];
        Arrays.fill(prime,true);
        if(n>=0 || n>=1){
            prime[0]=false;
            prime[1]=false;
        }

        for(int i=2;i*i<=n;i++){
            if(prime[i]){
                //mark all the multiple of i'th index as false;
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=false;
                }
            }
        }

        int sum=0;
        for(int i=2;i<=n;i++){
            if(prime[i]){
                //check for the sum if exceeds.
                if(sum+i>s){
                    break;
                }
                sum=sum+i;
                res.add(i);
            }
            
        }

        return res;
    }
}