//package DataStructure;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//
//public class test {
//    public static void main(String[] args) throws IOException {
//        FileInputStream ex1 = new FileInputStream(new File("C:\\Users\\pc\\Desktop\\file\\x1.xlsx"));
//
//        Workbook workbook1 = new XSSFWorkbook(ex1);
//        Sheet sheet1 = workbook1.getSheetAt(0);
//        Iterator<Row> iterator1 = sheet1.rowIterator();
//        while (iterator1.hasNext()){
//            Row row = iterator1.next();
//            Iterator<Cell> cellIterator = row.cellIterator();
//            while (cellIterator.hasNext()){
//                Cell cell = cellIterator.next();
//                System.out.println(cell.getStringCellValue());
//            }
//        }
//
//    }
//    public static void maind(String[] args) {
//        int input = 10;
//        String[] inputB = new String[(int) Math.pow(2, input)];
//        for (int i = 0; i < inputB.length; i++) {
//            String x = Integer.toBinaryString(i);
//            inputB[i] = getZeroes(input - x.length())+x ;
//        }
////        for (int i = 0; i < inputB.length; i++) {
////            int[] numbers = new int[input];
////            int result = 1;
////            for (int j = 0; j < inputB[i].length(); j++) {
////                numbers[j] = Integer.parseInt(inputB[i].charAt(j)+"");
////            }
////            for (int j = 0; j < numbers.length; j++) {
////                result &=numbers[j];
////                System.out.print(numbers[j] + " ");
////            }
////            System.out.print(result);
////            System.out.println();
////
////        }
//        System.out.println("here");
//        for (int i = 0; i < inputB.length; i++) {
//            int[] numbers = new int[input];
//            for (int j = 0; j < inputB[i].length(); j++) {
//                numbers[j] = Integer.parseInt(inputB[i].charAt(j)+"");
//            }
//            Arrays.toString(numbers);
//            Set<Character> x = new HashSet<>();
//            for (int j = 0; j < numbers.length; j++) {
//                if (numbers[j]!=0)
//                    x.add((char)('a' + input-j-1));
//            }
//            System.out.println(x);
//        }
//    }
//
//    public static String getZeroes(int k) {
//        String c = "";
//        for (int i = 0; i < k; i++) {
//            c += "0";
//        }
//        return c;
//    }
//}
