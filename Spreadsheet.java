import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheet {

    private final Map<String, String> cellValues = new HashMap<>(); 
    private final Pattern formulaPattern = Pattern.compile("=([A-Z][0-9]+(?:\\+[A-Z][0-9]+)*)");

    
    public void setCellValue(String cellId, Object value) {
        cellValues.put(cellId, value.toString());
    }

   
    public int getCellValue(String cellId) {
        if (!cellValues.containsKey(cellId)) {
            throw new IllegalArgumentException("Cell " + cellId + " is not set.");
        }

        String rawValue = cellValues.get(cellId);

        
        if (!rawValue.startsWith("=")) {
            return Integer.parseInt(rawValue);
        }

        // Case 2: Formula evaluation
        return evaluateFormula(rawValue);
    }

    
    private int evaluateFormula(String formula) {
        Matcher matcher = formulaPattern.matcher(formula);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid formula: " + formula);
        }

        String[] tokens = formula.substring(1).split("\\+"); 
        int sum = 0;

        for (String token : tokens) {
            sum += getCellValue(token); // recursive evaluation
        }
        return sum;
    }

    // Test in main
    public static void main(String[] args) {
        Spreadsheet sheet = new Spreadsheet();

        sheet.setCellValue("A1", 10);
        sheet.setCellValue("A2", 14);
        System.out.println("A1 -> " + sheet.getCellValue("A1")); 
 	System.out.println("A2 -> " + sheet.getCellValue("A2"));

        sheet.setCellValue("A3", "=A1+A2");
        System.out.println("A3 -> " + sheet.getCellValue("A3"));

        sheet.setCellValue("A4", "=A1+A2+A3");
        System.out.println("A4 -> " + sheet.getCellValue("A4")); 
    }
}
