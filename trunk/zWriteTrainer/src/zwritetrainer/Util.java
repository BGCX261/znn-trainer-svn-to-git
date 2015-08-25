/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zwritetrainer;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
        

/**
 *
 * @author Zelic
 */
public class Util {

    public static double[] DoubleBinaryTargetArray(int position, int size) {
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = 0;
        }
        result[position] = 1;
        return result;
    }

    public static double[] DoubleBipolarTargetArray(int position, int size) {
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = -1;
        }
        result[position] = 1;
        return result;
    }
    
    public static double[] flattenIntMatrix(int[][] ImageMatrix){
        int h = ImageMatrix.length;
        int w = ImageMatrix[0].length;
        double[] result = new double[w*h];
        for (int i=0;i<h;i++){
            for (int j=0;j<w;j++){
                result[i*w+j]=ImageMatrix[i][j];
            }
        }
        return result;
    }
    
    public static double[] convertIntArray(int[] input){
        double[] result= new double[input.length];
        for (int i=0;i<input.length;i++){
            result[i]=(double)input[i];
        }
        return result;
    }
    
    public static double[] normalizeArray(double[] input){
        int l = input.length;
        double[] result = new double[l];
        for (int i=0;i<l;i++){
            if (input[i]>=1){
                result[i]=1;
            } else {
                result[i]=0;
            }
        }
        return result;
    }
    
    public static HashMap<String, double[][]>  importTrainingData(String filename) throws IOException {
        DataInputStream inputStream = null;
        HashMap<String, double[][]> result = new HashMap<String, double[][]>();
        int numInput = 0;
        int numOutput = 0;
        int numExample = 0;
        try {
            inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
            numInput = inputStream.readInt();
            numOutput = inputStream.readInt();
            numExample = inputStream.readInt();
            
            double[][] input = new double[numExample][numInput];
            double[][] output = new double[numExample][numOutput];

            for (int e = 0; e < numExample; e++) {
                for (int i = 0; i < numInput; i++) {
                    input[e][i] = inputStream.readDouble();
                }
                for (int i = 0; i < numOutput; i++) {
                    output[e][i] = inputStream.readDouble();
                }
                
            }
            result.put("input", input);
            result.put("output", output);
            
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return result;
    }
    
}
