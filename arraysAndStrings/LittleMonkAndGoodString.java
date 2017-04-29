import java.util.Scanner;
class LittleMonkAndGoodString{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String test=in.nextLine();
        int current=0;
        int highest=0;
        for(int i=0;i<test.length();i++){
            if(isVowel(test.charAt(i))){
                current++;
            }else{
                current=0;
            }
            if(highest<current){
                highest=current;
            }
        }
        System.out.println(highest);
    }
    static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    } 
}