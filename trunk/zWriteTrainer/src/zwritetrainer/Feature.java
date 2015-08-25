/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zwritetrainer;

import java.io.*;

/**
 *
 * @author Zelic
 */
public class Feature {

    public static double[] importFeatureType01(String path) {
        double[] result = new double[41];
        try {
            FileInputStream file = new FileInputStream(path);
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            String[] temp = line.split(" ");
            for (int i=0;i<temp.length;i++){
                result[i]=Double.valueOf(temp[i]);
            }
        } catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
