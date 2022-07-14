package edu.tyut.TopCoder;

public class A0Paper {
    public String canBuild(int[] A){
        String[] result = {"Possible","Impossible"};
        if(A[0]>0) return result[0];
        int len = A.length;
        for (int i = len-1; i > 0; i--) {
            while ((A[i]!=0&&A[i]!=1)&&(A[i]/2!=1||A[i]/2==1)){
                A[i-1]++;
                break;
            }
        }
        if(A[0]>0) return result[0];
        else return result[1];
    }
}
