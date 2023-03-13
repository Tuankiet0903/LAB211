import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Manager {
    
    private final Scanner sc = new Scanner(System.in);

    public int menu(){
        int choice;
        do{
            System.out.println("1. Count word in file");
            System.out.println("2. Find file by word");
            System.out.println("3. Exit");
            choice=Integer.parseInt(sc.nextLine());
        }
        while(choice<1&&choice>4);
        return choice;
    }

    public int countWordInFile(String fileSource, String word){
        FileReader fr = null;
        try {
            fr = new FileReader(fileSource);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0 ;
            while (line != null){
                String[] parts = line.split(" ");
                for (String w : parts){
                    if(w.equalsIgnoreCase(word)){
                        count ++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            try{
                fr.close();
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return 0;   
    }


    public void getFileNameConstainsWordInDirectory(String source, String word){
        File folder = new File(source);
        File[]  listOfFiles = folder.listFiles();

        for (File file : listOfFiles){
            if (file.isFile()){
                if (countWordInFile(file.getAbsolutePath(),word) != 0){
                    System.out.println("file name "+file.getName());
                }
            }   
        }
    }

    public void display(){
        String path;
        String word;
        int choice = menu();
        switch (choice) {
        case 1:
            System.out.print("Enter Path: ");
                    path = sc.nextLine();
                    System.out.print("Enter Word: ");
                    word = sc.nextLine();
                    int count = countWordInFile(path, word);
                    System.out.println("Count: " + count);
                    break;	
                case 2:
                    System.out.print("Enter Path: ");
                    path = sc.nextLine();
                    System.out.print("Enter Word: ");
                    word = sc.nextLine();
                    getFileNameConstainsWordInDirectory(path, word);
                    break;
            case 3:
                return;
        }
    }
}
