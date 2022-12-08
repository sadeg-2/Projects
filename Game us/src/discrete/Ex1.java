//package discrete;
//
//import org.apache.commons.compress.utils.Sets;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//
//public class Ex1 {
//    public static void mdain(String[] args) {
////        int[] array = {2,5,9,6,9,3,8,7,1,10,13,9,15,12,14,4};
////        int c = 0;
////        int hare = 0;
////        int tortoise = 0;
////        do {
////            hare = array[array[hare]];
////            tortoise = array[tortoise];
////            c++;
////        } while (tortoise != hare);
////        tortoise = 0;
////        while (tortoise != hare){
////
////            tortoise = array[tortoise];
////            hare = array[hare];
////            c++;
////        }
////        System.out.println(hare + " " + tortoise);
////        System.out.println(c);
//        Set<Integer> t = new HashSet<>(Sets.newHashSet(1,2,3,5));
//        t.retainAll(Sets.newHashSet(1,2));
//
//        System.out.println(t);
//    }
//
//    public static void main(String[] args) {
//        Set<String> a = new HashSet<>();
//        Set<String> b = new HashSet<>();
//        try {
//            FileInputStream ex1 = new FileInputStream(new File("C:\\Users\\pc\\Desktop\\file\\x1.xlsx"));
//            Workbook workbook = new XSSFWorkbook(ex1);
//            Sheet sheet1 = workbook.getSheetAt(0);
//            for(Row x : sheet1){
//                for(Cell c : x){
//                    addElement(a,c);
//                }
//            }
//            FileInputStream ex2 = new FileInputStream(new File("C:\\Users\\pc\\Desktop\\file\\x2.xlsx"));
//            Workbook workbook2 = new XSSFWorkbook(ex2);
//            Sheet sheet2 = workbook2.getSheetAt(0);
//            for(Row x : sheet2){
//                for(Cell c : x){
//                    addElement(b,c);
//                }
//            }
////            Iterator<Row> iterator2 = sheet2.iterator();
////            Iterator<Row> iterator = sheet1.iterator();
////            while (iterator.hasNext()) {
////                Row currentRow = iterator.next();
////                Iterator<Cell> cellIterator = currentRow.iterator();
////                while (cellIterator.hasNext()) {
////                    Cell currentCell = cellIterator.next();
////                    addElement(a, currentCell);
////                }
////            }
////            while (iterator2.hasNext()) {
////                Row currentRow2 = iterator2.next();
////                Iterator<Cell> cellIterator2 = currentRow2.iterator();
////                while (cellIterator2.hasNext()) {
////                    Cell currentCell2 = cellIterator2.next();
////                    addElement(b,currentCell2);
////                }
////            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        Set<String> unions = new HashSet<>(a);
//        unions.addAll(b);
//        System.out.println(unions);
//
//
//    }
//
//    private static void addElement(Set<String> a, Cell currentCell) {
//        switch (currentCell.getCellType()) {
//            case STRING:
//                a.add(currentCell.getStringCellValue());
//                break;
//            case NUMERIC:
//                a.add(currentCell.getStringCellValue() + "--");
//                break;
//            case BOOLEAN:
//                a.add(currentCell.getStringCellValue() + "-");
//            default:
//                System.out.println("Error");
//        }
//    }
//}
