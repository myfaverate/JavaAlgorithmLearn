package edu.tyut.leetcode;

public class ZConvert {
    public static String convert(String s, int numRows) {
        int n = s.length(); // n为字符串长度
        int t = 2*numRows-2; // 周期
        if(numRows==1||numRows>=n) return s; // 排除两种情况
        int col = (n + t - 1) / t * (numRows - 1);
        char[][] matrix = new char[numRows][col];
        // (n + t - 1) / t * (numRows - 1)
        // (n/t)*(numRow-1)+1
        // ABCDE 4
        for(int i=0,x=0,y=0;i<n;i++){
            matrix[x][y]=s.charAt(i);
            if((i%t)/col<1){ // i mod t<r-1
                x++;
            }else{
                x--;
                y++;
            }
        }
        var builder = "";
        for(int i=0;i<numRows;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    builder+=matrix[i][j];
                }
            }
        }
        return builder;
    }

    public static String convertOptimize(String s, int numRows) {
        // 直接构建
        var builder = new StringBuilder();
        int n = s.length(); // 字符串长度
        int t = 2*numRows-2; // 周期
        if(numRows==1||numRows>=n) return s; // 排除两种情况
        for (int i = 0; i < numRows; i++) {
            /*
                PAYPALISHIRING
                P   A   H   N
                A P L S I I G
                Y   I   R

                P     I    N
                A   L S  I G
                Y A   H R
                P     I
             */
            // 枚举每个周期的起始下标
            for (int j = 0; j < n - i; j+=t) {
                builder.append(s.charAt(j+i));
                // 上升层P S I
                if (i>0 && i< numRows - 1 && j + t - i < n){
                    builder.append(s.charAt(j + t - i));
                }
            }
        }
        return  builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertOptimize("PAYPALISHIRING", 4));
        // PAHNAPLSIIGYIR
        // PAHNAPLSIIGYIR
    }
}
