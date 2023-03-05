
import java.io.BufferedReader;	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Manager {

    //khoảng cách là 1 kí tự đặc biệt
    public static String formatOneSpaceSpecial(String line, String character) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = line.split("\\s*\\" + character + "\\s*");
     // nối mỗi từ và khoảng cách đặc biệt của ký tự là một khoảng trắng
        for (String oneWord : strings) {
            stringBuffer.append(oneWord + " " + character);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim().substring(0, stringBuffer.length() - 3);
    }

    //chỉ có một khoảng cách giữa các từ và tất cả các ký tự chữ thường
    public static String formatOneSpace(String line) {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpaceSpecial(line, ".");		
        line = formatOneSpaceSpecial(line, ",");
        line = formatOneSpaceSpecial(line, ":");
        line = formatOneSpaceSpecial(line, "\"");
        return line.trim();
    }

    //chỉ một dấu cách sau dấu phẩy (,), dấu chấm (.) và dấu hai chấm (:).
    public static String formatSpecialCharacters(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
      //kiểm tra từ đầu đến cuối trước .,:; sau đó xóa
        for (int i = 0; i < stringBuffer.length() - 1; i++) {
            if (stringBuffer.charAt(i) == ' '
                    && stringBuffer.charAt(i + 1) == '.'
                    || stringBuffer.charAt(i + 1) == ','
                    || stringBuffer.charAt(i + 1) == ':') {
                stringBuffer.deleteCharAt(i);
            }
        }
        return stringBuffer.toString().trim();
    }

 // Ký tự đầu tiên của từ sau dấu chấm là chữ hoa và các từ khác là chữ thường.
    public static String afterDotUpperCase(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        int lengthLine = stringBuffer.length();
     // kiểm tra từ đầu đến cuối. sau đó viết hoa
        for (int i = 0; i < lengthLine - 2; i++) {
            if (stringBuffer.charAt(i) == '.') {
                char afterDot = stringBuffer.charAt(i + 2);
                stringBuffer.setCharAt(i + 2, Character.toUpperCase(afterDot));
            }
        }
        return stringBuffer.toString().trim();
    }

 // không có khoảng trắng trước và sau câu hoặc cụm từ trong dấu ngoặc kép (“”).
    static int countQuetes = 0;

    public static String noSpaceQuotes(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 0) {
                stringBuffer.deleteCharAt(i + 1);
                countQuetes++;
            } else if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 1
                    && i != 0) {
                stringBuffer.deleteCharAt(i - 1);
                countQuetes++;
            }
        }
        return stringBuffer.toString().trim();
    }

 // ký tự đầu tiên của từ trong dòng đầu tiên là chữ hoa
    public static String firstUpercase(String line) {
        line = line.substring(3);
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                stringBuffer.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return stringBuffer.toString().trim();
    }

 // phải có dấu chấm ở cuối văn bản.
    public static String lastAddDot(String line) {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }

  //không có dòng trống giữa các dòng
    public static boolean isLineEmpty(String line) {
        if (line.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

  //đếm dòng
    public static int countLine() {
        int countLine = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("D:\\input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("D:\\output.txt", true)));
            String line;
         // ghi cho đến hết file
            while ((line = br.readLine()) != null) {
            	//kiểm tra dòng trống
                if (isLineEmpty(line)) {
                    continue;
                }
    countLine++;
            }
                br.close();
            pw.close();

            

        } catch (FileNotFoundException ex) {
            System.err.println("Can't found.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return countLine;
    }
}