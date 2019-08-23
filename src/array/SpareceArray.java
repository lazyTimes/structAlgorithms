package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏数组
 * 1. 需要将二维数组转为稀疏数组存储
 * 2. 稀疏数组进行保存（文件读写）
 * 3. 读取文件恢复稀疏数组（文件读写）
 * 4. 将稀疏数组转回二维数组
 * @author zhaoxudong
 * @title: SpareceArray
 * @projectName structAlgorithms
 * @description: 稀疏数组
 * @date 2019/8/19 14:54
 */
public class SpareceArray {

    /**
     * 使用稀疏数组
     * @param args 数组
     */
    public static void main(String[] args) {
        int[][] twoArrayConvertSparecArray = twoArrayConvertSparecArray();

        // 稀疏数组如何转为二维住
        SparecArrayConverttwoArray(twoArrayConvertSparecArray);
    }

    /**
     * 稀疏数组转为二维数组
     */
    private static void SparecArrayConverttwoArray(int[][] array) {
        // 1. 根据第一行数据还原出二维数组的行与列
        int[][] result = new int[array[0][0]][array[0][1]];

        for (int i = 1; i < array.length; i++) {
            result[array[i][0]][array[i][1]] = array[i][2];
        }

        printArray(array);
        printArray(result);
    }

    /**
     * 稀疏数组转为二维数组的办法
     * 1. 创建二维数组，并且加入数据
     * 2.
     */
    private static int[][] twoArrayConvertSparecArray() {
        // 将二维数组转为稀疏数组 初始化为 11 11
        int[][] array = new int[8][8];
        List list = new ArrayList();
        // 在二维数组放两个子
        array[4][5] = 2;
        array[3][7] = 11;
        array[2][3] = 11;
        printArray(array);
        // 计算有几个有效数据
        // 存储有几个有效数据
        int sumCount = 0;
        sumCount = calcuArrSize(array, sumCount);
        // 创建稀疏数组
        int[][] spareceArray = new int[sumCount+1][3];

        // 第一行为 个数 棋盘的行 棋盘的列
        spareceArray[0][0] = array.length;
        spareceArray[0][1] = array[0].length;
        spareceArray[0][2] = sumCount;

        // 稀疏数组存储数据
        //count 用于记录是第几个非0数据
        int noZeroCount = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] != 0) {
                    noZeroCount++;
                    // 存储第几行 第几列 值为多少
                    spareceArray[noZeroCount][0] = i;
                    spareceArray[noZeroCount][1] = j;
                    spareceArray[noZeroCount][2] = array[i][j];

                }
            }
        }
        return spareceArray;
    }

    /**
     * 计算有效数据的个数
     * @param array 原有的数组
     * @param sumCount 计算个数
     */
    private static int calcuArrSize(int[][] array, int sumCount) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] != 0) {
                    sumCount++;
                }
            }
        }
        return sumCount;
    }

    /**
     * 打印数组的快捷方法
     * @param array 数组
     */
    private static void printArray(int[][] array) {
        System.err.println("-----------------我是分割线-----------------");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t" );
            }
            System.out.println();
        }
        System.err.println("-----------------我是分割线-----------------");

    }
}
