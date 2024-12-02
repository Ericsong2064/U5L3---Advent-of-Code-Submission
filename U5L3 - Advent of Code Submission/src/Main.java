import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/file");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i<fileData.size();i++){
            list1.add(Integer.parseInt(fileData.get(i).substring(0,fileData.get(i).indexOf(" "))));
            list2.add(Integer.parseInt(fileData.get(i).substring(fileData.get(i).indexOf(" ")+3)));
        }
        System.out.println(list1);
        System.out.println(list2);
        int min=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int index=0;
        int index2=0;
        int difference =0;
        int l=0;
        int p=0;
        int sum =0;
        System.out.println(list1.size());
        System.out.println(list2.size());
        for(int j=0; j<list1.size()-1;j++) {
            for (int e = 0; e < list1.size()-1; e++) {
                if (list1.get(e) < min) {
                    min = list1.get(e);
                    index=e;
                }
                if(list2.get(e)<min2){
                    min2=list2.get(e);
                    index2=e;
                }
            }
            list1.remove(index);
            list2.remove(index2);
            list1.add(l,min);
            l++;
            list1.add(p,min2);
            p++;
            min2=Integer.MAX_VALUE;
            min=Integer.MAX_VALUE;
        }
        System.out.println(list1);
        System.out.println(list2);
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}