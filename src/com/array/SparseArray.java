package com.array;

public class SparseArray {
    public static void main(String[] args) {
        //创建原始二维数组 0表示没有子，1表示黑子，2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;

        System.out.println("原始二维数组:");
        for(int [] row : chessArr1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        /**
         * 将二维数组转成稀疏数组
         * 1.得到非零数据
         */
        int sum = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                 if(chessArr1[i][j] != 0){
                     sum++;
                 }
            }
        }
        System.out.println("sum = " + sum);

        //2.创建对象的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组,将非0的值存放在稀疏数组sparseArr中
        int count = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2]= chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("稀疏数组：");
        for(int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",
                    sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }


        /**
         * 将稀疏数组恢复成二维数组
         * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
         * 2.再读取稀疏数组后几行的数据，并赋给二维数组即可
         */

    }
}
