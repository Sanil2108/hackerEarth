import java.util.*;
class Solution{
    public static void KMP(char[] pattern, char[] text){
        int[] patternArr=new int[pattern.length];
        int i=1;
        int j=0;
        for(;i<pattern.length;){
            if(pattern[i]==pattern[j]){
                patternArr[i]=j+1;
                i++;
                j++;
            }else{
                if(j!=0){
                    j=patternArr[j-1];
                }else{
                    i++;
                }
            }
        }

        // for(int k=0;k<patternArr.length;k++){
        //     System.out.print(patternArr[k]+"\t");
        // }
        // System.out.println();

        int occurences=0;
        i=j=0;
        for(;i<text.length;){
            if(pattern[j]==text[i]){
                if(j==pattern.length-1){
                    // System.out.println("occurence found at "+(i-pattern.length));
                    i++;
                    occurences++;
                    continue;
                }
                i++;
                j++;
            }else{
                if(j!=0){
                    j=patternArr[j-1];
                }else{
                    i++;
                }
            }
        }

        System.out.println(occurences);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String pattern=in.next();
        String text=in.next();
        KMP(pattern.toCharArray(), text.toCharArray());
    }
}