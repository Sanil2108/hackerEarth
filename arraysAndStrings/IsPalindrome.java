import java.util.Scanner;
class isPalindrome{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        in.nextLine();
        for(int i=0;i<T;i++){
            String test=in.nextLine();
            boolean isPalindrome=true;
            for(int j=0;j<test.length()/2;j++){
                if(test.charAt(j)!=test.charAt(test.length()-j-1)){
                    isPalindrome=false;
                    break;
                }
            }
            if(isPalindrome){
                if(test.length()%2==0){
                    System.out.println("YES EVEN");
                }else{
                    System.out.println("YES ODD");
                }
            }else{
                System.out.println("NO");
            }
        }
    }
}