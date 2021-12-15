import java.util.Date;

import java.util.Scanner;

import java.text.DateFormat;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Calculations Class = Performs calculations on .CSV files
 *
 * @author maro.oroh
 * @version Java 17.0.1
 * @since 2021-11-28
 */

public class Calculations extends ReadFiles{
    
    Date[] date;
    float[ ] [ ] data;
    float[ ] [ ] datac;
    float[ ] [ ] datac2;
    float [] difference;
    float m, n, o, p;
    String q, r;
    
    
    
    public void createDateArray(){
        int j = 0;

        Scanner input = new Scanner(System.in);

        date = new Date[count];

        try {

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            for (int i = 1; i<count; i++){
                Date conv = df.parse(arr[i][j]);
                date[i] = conv;
                
            }

        }

        catch(ParseException e){

            e.printStackTrace();

        }

        //return date;

    }
    
    public void createDataArray(){
        
        
        data = new float[count][7];
        datac = new float[count][6];
        datac2 = new float[count][6];
        
        
        for (int i = 1; i<count; i++){
            
            for (int j = 1; j<7; j++){
                data[i][j] = Float.parseFloat(arr[i][j]);
            }

        }
        
        for (int i = 1; i<count; i++){
            
            for (int j = 1; j<6; j++){
                datac[i][j] = Float.parseFloat(arr[i][j]);
            }

        }
        for (int i = 1; i<count; i++){
            
            for (int j = 1; j<6; j++){
                datac2[i][j] = Float.parseFloat(arr[i][j]);
            }

        }
    }
    
    
    
    public void printDArray(){
        for(int i= 1; i<date.length; i++){
            System.out.print(date[i]  + ",  ");
        }
        System.out.println();
        
        for (int i = 1; i<count; i++){
            
            for (int j = 1; j<6; j++){
                System.out.print(data[i][j] + ", ");
             
            }
        }
        System.out.println();
    }
    
    public String calcMethod(){
        int i = 1;
        
        float x = data[1][1];
        int j = 1;
        //calculating highest opening value
        for (i = 1; i<count; i++){
            if(x<data[i][j]){
                x = data[i][j];
            }
        }
        m = x;
        System.out.println("Highest opening value is "+ x);
        
        
        x = data[1][4];
        j = 4;
        //calculating highest closing value
        for (i = 1; i<count; i++){
            if(x<data[i][j]){
                x = data[i][j];
            }
        }
        n = x;
        System.out.println("Highest closing value is "+ x);
        
        
        x = data[1][1];
        j = 1;
        //calculating lowest opening value
        for (i = 1; i<count; i++){
            if(x>data[i][j]){
                x = data[i][j];
            }
        }
        o = x;
        System.out.println("Lowest opening value is "+ x);
        
        
        x = data[1][4];
        j = 4;
        //calculating lowest closing value
        for (i = 1; i<count; i++){
            if(x>data[i][j]){
                x = data[i][j];
            }
        }
        p = x;
        System.out.println("Lowest closing value is "+ x);
        
        
        //dispaying the dates of the top 10 highest closing value
        System.out.println("Dates with highest closing value are:");
        Date[] top = new Date[10];
        x = 0;
        j = 4;
        int y = 0;
        int z = 0;
        for(int index = 0; index<10; index++){
            x = 0;
            for (i = 1; i<count; i++){
                if(x<datac[i][j]){
                    x = datac[i][j];
                    y = i;
                    z = j;
                }
            }
            datac[y][z] = -1 * datac[y][z];
            top[index] = date[y];
            System.out.println(top[index]);
        }
        q = Arrays.toString(top);
        
        
        //dispaying the dates of the top 10 lowest closing value
        System.out.println("Dates with lowest closing value are:");
        Date[] low = new Date[10];
        j = 4;
        y = 0;
        z = 0;
        for(int index = 0; index<10; index++){
            x = 100;
            for (i = 1; i<count; i++){
                if(x>datac2[i][j]){
                    x = datac2[i][j];
                    y = i;
                    z = j;
                }
            }
            datac2[y][z] = 100 * datac2[y][z];
            low[index] = date[y];
            System.out.println(low[index]);
        }
        r = Arrays.toString(low);
        
        
        difference = new float[count];
        
        for(i = 1; i<(count); i++){
            difference[i] = data[i][1] - data[i][4];
        }
        
        
        
        try (PrintWriter writer = new PrintWriter("DIFF.csv")) {
            StringBuilder sb = new StringBuilder();
            for(y = 0; y<7; y++){
                sb.append((arr[0][y]));
                sb.append(",");
            }
            sb.append("Difference");
            sb.append('\n');
            for (i=1; i<count; i++){
                sb.append(date[i]);
                for(y = 0; y<7; y++){
                    sb.append(data[i][y]);
                    sb.append(",");
                }
                sb.append(difference[i]);
                sb.append('\n');
            }
            writer.write(sb.toString());

            System.out.println("New difference column added to DIFF.csv");
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        
        
        
        return "Highest opening value is "+ m + " Highest closing value is "  + n + " Lowest opening value is " + o + "\nLowest closing value is " + p + "\nDates with highest closing value are; " +q + "\nDates with lowest closing value are:" + r;
    }
    
}