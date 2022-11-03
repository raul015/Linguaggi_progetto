package LFCLibrary; /**
 *
 * @author : Giuseppe Mirra
 *
 */

import java.io.IOException;


import LFCLibrary.TypeConversion.Functions.dataStructureCol;
import LFCLibrary.TypeConversion.Functions.dataStructureModifyCell;
import LFCLibrary.TypeConversion.Functions.dataStructureRow;
import LFCLibrary.TypeConversion.converterExcelToType;
import LFCLibrary.TypeConversion.excelToCsv;
import LFCLibrary.TypeConversion.excelToJson;
import LFCLibrary.TypeConversion.excelToText;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;




/* flusso del codice
 * 1: leggere il tipo di conversione per entrare nel case switch
 * 2: leggere il file excel in input
 * 3: cercare righe e colonne da eliminare all'interno del vettore dei dati
 * 4: cercare righe e colonne da modificare
 * 5: creare file in uscita con i nomi personalizzati
 * 6: dare il file in uscita
 */


public class mainConverter {

    String excelInPath = "C:\\Users\\mirra\\Desktop\\LinguaggiProgetto\\testConversion.xlsx";

    public static void main(String[] args) throws IOException {

        /* path input and output file */
        /* Windos path */

        String excelFilePath = "C:\\Users\\mirra\\Desktop\\LinguaggiProgetto\\testConversion.xlsx";
        String fileOutputPath = "C:\\Users\\mirra\\Desktop\\LinguaggiProgetto\\Prova1";

        /* Apple path */
//        String excelFilePath = "/Volumes/T7/IntelliJ/LFC/testConversion.xlsx";
//        String fileOutputPath = "/Volumes/T7/IntelliJ/LFC/";

        ArrayList<String> pathOutputFileArray = new ArrayList<>();
        //pathOutputFileArray.add(fileOutputPath);

        /* type conversion */
        String CSV  = "CSV";
        String Json = "JSON";
        String text = "TEXT";

        ArrayList<String> typeConversionArray = new ArrayList<>();
        typeConversionArray.add(CSV);
        typeConversionArray.add(Json);
        typeConversionArray.add(text);
        typeConversionArray.add("CSS");

      /* new sheet name from user (From metalanguage) */
        HashMap<Integer,String> nameSheetModifying = new HashMap<>();
        nameSheetModifying.put(1, "Foglio1");
        nameSheetModifying.put(2, "Foglio2");
        nameSheetModifying.put(3, "Foglio3");
        nameSheetModifying.put(4, "Foglio4");

        /* rows delete user Key = sheet number, value: delete row index */
        Vector<dataStructureRow> deleteRowsUser = new Vector<>();

        //deleteRowsUser.add(new dataStructureRow(1,3));
        //deleteRowsUser.add(new dataStructureRow(1,4));

        /* cols delete user Key = sheet number, value: delete cols index */
        Vector<dataStructureCol> deleteColsUser = new Vector<>();
        //deleteColsUser.add(new dataStructureCol(1,2));
        //deleteColsUser.add(new dataStructureCol(1,3));

        /* vector for modifying cell field */
        Vector<dataStructureModifyCell> modifyCells = new Vector<>();
        modifyCells.add(new dataStructureModifyCell(2,2,4,100));
//        modifyCells.add(new dataStructureModifyCell(1,2,1,"cambio"));
//        modifyCells.add(new dataStructureModifyCell(1,2,2,"Testcambio"));
//        modifyCells.add(new dataStructureModifyCell(1,2,3,50));
//        modifyCells.add(new dataStructureModifyCell(1,2,4,50));
        
        


//        converterExcelToType cT = new converterExcelToType(excelFilePath, pathOutputFileArray, typeConversionArray, nameSheetModifying,
//                deleteRowsUser, deleteColsUser, modifyCells);
//        cT.converter();
//        converterExcelToType cT1 = new converterExcelToType(excelFilePath, pathOutputFileArray, Json, nameSheetModifying,
//                deleteRowsUser, deleteColsUser, modifyCells);
//        cT1.converter();
//        converterExcelToType cT2 = new converterExcelToType(excelFilePath, pathOutputFileArray, text, nameSheetModifying,
//                deleteRowsUser, deleteColsUser,modifyCells);
//        cT2.converter();



    }
}
