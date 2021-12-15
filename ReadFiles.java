import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ReadFiles Class = Reads CSV files
 *
 * @author maro.oroh
 * @version Java 17.0.1
 * @since 2021-11-28
 */

public class ReadFiles 
{
    public static int numberOfRows;
    public static int rowNumber = 0;
    public static int columnNumber = 0;
    public String fileName;
    public int count1 = 0;
    public int count = 0;
    String[][] arr;
    String date[];

    public  void exists(File x)
    {
        Scanner kb = new Scanner (System.in);
        //System.out.print("Enter the file name >> ");
        fileName = x.getName();
        File f = new File( fileName);
        if(f.exists())
        {
            System.out.println("File exists.");
        }
        else{
            System.out.println("Can't find file, check path bro/sis");
        }    
    }
    public int Rows(){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String input;
            
            while((input = bufferedReader.readLine()) != null)
            {
                count++;
            }   
            System.out.println("Count : "+count);
            //this.count1 = count;
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFiles.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(ReadFiles.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            try {
                bufferedReader.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(ReadFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //count1 = count;
        arr = new String[count][7];
        return count;
    }
   
  
    public void convertCSV() {
        int i = 0, j = 0;
        try {
            Scanner sc = new Scanner(new FileReader(fileName));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line,",");
                j = 0;
                while(st.hasMoreTokens()) {
                        arr[i][j] = st.nextToken();
                        j++;
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found");
        }
    }
    
   
    
    
    public void PrintArray() {
        //to access elements of 2d array we use nested loops with i and j
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                if(i==0)    //this will print the first row i.e. header of the table
                    System.out.print(arr[i][j]+"\t\t");   //header row with two tab will print
                else if(j==1 && arr[i][1].length()<6) //this is used for name column to make it evenly spaced
                    System.out.print(arr[i][j]+"\t");   //here we use two tab space to do so
                else if(j==2) //to make last column at particular space we put this condition
                    System.out.print(arr[i][j]+"\t"); //here we use two tab space
                else //for rest of column we use this section
                    System.out.print(arr[i][j]+"\t");   //here we use one tab space
            }
            System.out.println();   //this is for next line
        }
    }
    
    public String[][] getArray() {
       return arr;
    }
   
    
    
}
