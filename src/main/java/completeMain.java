import Grammatica.myCompiler.grammaticaParser;
import LFCLibrary.TypeConversion.converterExcelToType;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class completeMain {

    public static void main(String[] args) throws IOException, RecognitionException {
        /* Apple */
        String fileName = "./resources/input.file";

        System.out.println ("Parsing con ANTLR");

        converterExcelToType cET = new converterExcelToType();


        FileReader fileIn = new FileReader(fileName);

        grammaticaParser parser = new grammaticaParser(fileIn, cET);
        parser.language();

        /*
        System.out.println("STAMPO DAL completeMain");
        System.out.println(cET.pathInputFile);
        System.out.println(cET.pathOutputFile);
        System.out.println(cET.deleteColsUser);
        System.out.println(cET.deleteColsUser);
        System.out.println(cET.nameSheetModifying);
        System.out.println(cET.modifyCells);
        System.out.println(cET.conversionTypeArray);
        */


        
        //cET.converter();


        System.out.println("FINE DEL PARSER");
        System.out.println("lista degli errori : ");
        
        int index = 0;
        
        if(  cET.errorList  != null ) {
        
        	for (Token var : cET.errorList) 
        	{ 
        	
        		System.err.println("ERROR Token Type num:  [" + index + "] , [row, col] : [" + var.getLine()+ "," + var.getCharPositionInLine() + "],  "
        				+ "Contenuto del Token: 	" + var.getText());
        		index++;

        	}
        	
        }
        
        else if (parser.getErrorList().size() != 0) {
        	int i = 0;
			System.out.println ("*******************");
			for (String msg : parser.getErrorList())
				System.err.println (++i + " - " + msg);
        	
        }
        else {
        	System.out.println("Non sono presenti caratteri sconosciuti all'interno della grammatica");
            cET.converter(); // ho provato a metterlo qua ... Sembra avere più senso in questa posizine
        }
        
        
   }

}
