import java.util.*;
class TernarySearch{
    public static long ternarySearch(long start, long end){
        long mid1 = (long)((end-start)/3f)+start;
        long mid2 = (long)((end-start)*(2f/3))+start;
        if(fun(end)<fun(end-1)){
            return end;
        }
        if(fun(start)<fun(start+1)){
            return start;
        }
        if((fun(mid1) < fun(mid1-1) && fun(mid1) < fun(mid1+1))){
            return mid1;
        }else if((fun(mid2) < fun(mid2-1) && fun(mid2) < fun(mid2+1))){
            return mid2;
        }else{
            long lowest = lowest(fun(start), fun(mid1), fun(mid2), fun(end));
            if(lowest == fun(start)){
                return ternarySearch(start, mid1);
            }else if(lowest == fun(end)){
                return ternarySearch(mid2, end);
            }else if(lowest == fun(mid1)){
                if(lowest(fun(mid2), fun(start)) == fun(start)){
                    return ternarySearch(start, mid1);
                }else{
                    return ternarySearch(mid1, mid2);
                }
            }else{
                if(lowest(fun(mid1), fun(end)) == fun(mid1)){
                    return ternarySearch(mid1, mid2);
                }else{
                    return ternarySearch(mid2, end);
                }
            }
        }
    }

    public static long lowest(long... arr){
        long lowest = arr[0];
        for(long i:arr){
            if(i<lowest){
                lowest = i;
            }
        }
        return lowest;
    }

    public static long fun(long a){
        long total =  2*a*a - 12*a + 7;
        return total;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i =0;i<T;i++) {
            int a= in.nextInt();
            int b=in.nextInt();
            System.out.println(fun(ternarySearch(a, b)));
        }
    }
}