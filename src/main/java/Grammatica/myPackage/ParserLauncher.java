package Grammatica.myPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import LFCLibrary.TypeConversion.converterExcelToType;
import org.antlr.runtime.RecognitionException;

import Grammatica.myCompiler.grammaticaParser;

public class ParserLauncher {
	public static void main (String[] args) throws FileNotFoundException, IOException, RecognitionException {

		/* Windows */
		//String fileName = ".\\resources\\input.file";


		/* Apple */
		String fileName = "./resources/input.file";

		System.out.println ("Parsing con ANTLR");

		converterExcelToType cET = new converterExcelToType();

		FileReader fileIn = new FileReader(fileName);
		
		grammaticaParser parser = new grammaticaParser(fileIn, cET);
		parser.language();
		System.out.println("FINE DEL PARSER");
		

			
	}
}
