grammar grammatica;

options{
language = Java;
k = 1;
}

@lexer::header{
	package Grammatica.myCompiler;
}

@lexer::members{

}

@header{
package Grammatica.myCompiler;

// Inserire le import per vostruttore (vedere @members )

	//SE SI VUOLE UTILIZZARE IL FILE ParserLauncher
	
import Grammatica.myCompiler.util.*;
import Grammatica.myCompiler.GrammaticaHandler;
import java.io.IOException;
import java.io.StringReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import LFCLibrary.TypeConversion.*;



}

@members{

// ************************************ inizio Analizzatore semantico

GrammaticaHandler h;


// ****************************************** Parte scanner e parser 
	public grammaticaParser(FileReader fileIn, converterExcelToType cET) throws  IOException{
				this(new CommonTokenStream(
								new grammaticaLexer(
										new ANTLRReaderStream(fileIn))));
		
				h = new GrammaticaHandler(input, cET);
			}
			
public GrammaticaHandler getHandler() {
    return h;
  }
  
			
			
public List<String> getErrorList () {
    return h.getErrorList();
  }
	public void displayRecognitionError(String[] tokenNames,
                                       RecognitionException e) {
		String hdr = " * " + getErrorHeader(e);
		String msg = " - " + getErrorMessage(e, tokenNames);
		  
		h.handleError(tokenNames, e, hdr, msg);
  }





//**


}


// INIZIO GRAMMATICA , language = assioma
language 
	: 
	 STARTDOC wsc body wsc  ENDDOC 
	;
	

	body	:	
		(i= inpath{h.setInputPath(i);})
		wsc
		(o = outpath{h.setOuputPath(o);})?
		wsc
		(cT = conversion { h.setConversionType(cT);} )
		wsc
	
		(nS = namesheet { h.setSheetName(nS);})?
	
		wsc
		(d = delete{h.printDelete(d);})?
	
		wsc
		(cM = modifyingcell{h.modifyingCellMeth(cM);})?
	
		;

wsc	:	
	(WS | COMMENT| scanerror)* 
	;

/*
wsc 	:	
	(WS | COMMENT)*  
	;
*/


inpath returns[Token p]
	:	

	 STARTINPATH (x=path {p=x;}) ENDINPATH   wsc 

	;
	
path	returns [Token p]
	:	
	
	wsc BAOPEN (x = STRINGA {p = $x;})  BACLOSE  wsc 
	
	;
	
	
// se nel file input viene messo il token DI outpath allora almeno un path di uscita deve essere inserito altrimenti errore.

outpath	 returns[ArrayList<Token> p]

@init { p = new ArrayList<Token>();}
	:	
	
	STARTOUTPATH (x=path { p.add(x);})+ ENDOUTPATH  
	
	;
	
conversion returns [ArrayList<Token> cT]
	:	
	
	STARTCONVERSION wsc ( cType = type{ cT = cType;}) wsc ENDCONVERSION
	
	;
	
namesheet returns [Map<Token, Token> nS]
	:	
	
	STARTNAMESHEET ( nameS = sheet { nS = nameS;}) wsc ENDNAMESHEET
	
	;
	
sheet	returns [Map<Token,Token> nS]

@init { nS = new HashMap<Token, Token>();}
	:	
	
	(wsc BAOPEN SHEETINDEX COLON ( index = (INT|STRINGA) ){System.out.println("tipo : "+ index.getType());} COMMA NEWNAMESHEET  COLON 
	( nameSheet = STRINGA {nS.put(index, nameSheet);} )  BACLOSE wsc)+
	
	;


type returns [ArrayList<Token> cType]

@init { cType = new ArrayList<Token>();}
	:		
	(BAOPEN) (s1 = STRINGA {cType.add(s1);}) (BACLOSE) wsc 
	( (BAOPEN)  (s2 = STRINGA {cType.add(s2);} ) ( BACLOSE))? wsc
	((BAOPEN) (s3= STRINGA {cType.add(s3);}) (BACLOSE))?  
	
	;



	


	/*
type returns [ArrayList<Token> cType]

@init { cType = new ArrayList<Token>();}
	:	
	
	((bo_1 = BAOPEN ) (s1 = STRINGA) (bc_1 = BACLOSE)){
		
	if($bo_1  != null|| $bc_1 != null){
	
		if( ($bo_1.getText().equals("<")) &&  $bc_1.getText().equals(">")){
			cType.add(s1);
		} 
		else{
			if($bo_1 == null) h.printError($bo_1);
			else if($bc_1 == null)h.printError($bc_1);
				
		System.out.println("errore");
		}
	}
	else System.out.println("errore in apertura e chisura");
		
	 } wsc 
	
	(( (bo_2 = BAOPEN )  (s2 = STRINGA ) (bc_2= BACLOSE))? ) { 
	
	if($bo_2  != null|| $bc_2 != null){
	
		if( ($bo_2.getText().equals("<")) &&  $bc_2.getText().equals(">")){
			cType.add(s2);
		} 
		else{
			if($bo_2 == null) h.printError($bo_2);
			else if($bc_2 == null)h.printError($bc_2);
				
		System.out.println("errore");
		}
	}
	else System.out.println("errore in apertura e chisura");
	
	
	} wsc
	((bo_3 =BAOPEN | ) (s3= STRINGA ) (bc_3 = BACLOSE))? {
	
	if($bo_3  != null|| $bc_3 != null){
	
		if( ($bo_3.getText().equals("<")) &&  $bc_3.getText().equals(">")){
			cType.add(s3);
		} 
		else{
			if($bo_3 == null) h.printError($bo_3);
			else if($bc_3 == null)h.printError($bc_3);
				
		System.out.println("errore");
		}
	}
	else System.out.println("errore in apertura e chisura");
	} 
	
	
	
	;

*/

/*
delete returns [ArrayList<Delete<Token,Token>> con]

@init{con = new ArrayList<>();}
	:
	STARTDELETE wsc  (r = row )? wsc (c = col)? wsc ENDDELETE
	{con.addAll(r);con.addAll(c);h.fusionDelete(r,c);}
	;
	
*/

delete returns [ArrayList<Delete<Token,Token>> con]

@init{con = new ArrayList<>();}
	:
	
	STARTDELETE wsc  (r = row )? wsc (c = col)? wsc ENDDELETE
	{
	if(r!= null && c!=null)
		h.fusionDelete(r,c);
	else if(c==null && r!=null){
	ArrayList<Delete<Token,Token>> c1 = new ArrayList<Delete<Token,Token>>();
	h.fusionDelete(r,c1);
	}
	else if (c!=null && r==null) {
	ArrayList<Delete<Token,Token>> r1 = new ArrayList<Delete<Token,Token>>();
	h.fusionDelete(r1,c);
	}
	else if (c==null && r==null){
	ArrayList<Delete<Token,Token>> r1 = new ArrayList<Delete<Token,Token>>();
	ArrayList<Delete<Token,Token>> c1 = new ArrayList<Delete<Token,Token>>();
	h.fusionDelete(r1,c1);
	
	}
	
	
	}
	
	;
	
/*
row	returns [ArrayList<Delete<Token,Token>> r]
	:	
	
	STARTROW (dr= todelete{r=dr;}) ENDROW
	
	;
	
col	returns [ArrayList<Delete<Token,Token>> c]
	:
	
	STARTCOL (dc = todelete{c=dc;}) ENDCOL
	
	;
	
todelete returns [ArrayList<Delete<Token,Token>> d]

@init{d = new ArrayList<>();}
	:	
	
	(wsc BAOPEN SHEETINDEX COLON (index = (INT | STRINGA)) COMMA INDEXDELETE COLON 
	(del = INT{Delete p= new Delete(index,del); d.add(p);})
	 BACLOSE wsc )+ 
	 
	;
	
	*/
row	returns [ArrayList<Delete<Token,Token>> r]
	:	
	
	STARTROW (dr= todelete{r=dr;}) ENDROW
	
	;
	
col	returns [ArrayList<Delete<Token,Token>> c]
	:
	
	STARTCOL (dc = todelete{c=dc;}) ENDCOL
	
	;
	
todelete returns [ArrayList<Delete<Token,Token>> d]

@init{d = new ArrayList<>();}
	:	
	
	(wsc BAOPEN SHEETINDEX COLON (index = (INT | STRINGA)) COMMA INDEXDELETE COLON 
	(del = INT{Delete p= new Delete(index,del); d.add(p);})
	 BACLOSE wsc )+ 
	 
	;
	

	
modifyingcell returns [ArrayList<cellModifyingClass<Token,Token,Token,Token>> aCM]
	:	
	
	STARTMODIFYINGCELL (aCMM = modcell{aCM = aCMM;}) ENDMODIFYINGCELL
	
	;

modcell	returns [ArrayList<cellModifyingClass<Token,Token,Token,Token>> aCM]

@init {aCM = new ArrayList<>();}	
	:
	
	(wsc BAOPEN SHEETINDEX COLON (ind = (INT | STRINGA)) COMMA 
	ROW COLON (rw = (INT | STRINGA)) COMMA COL COLON ( cl = (INT | STRINGA)) COMMA 
	NEWVALUE COLON ( vle = (INT | STRINGA)
	 {cellModifyingClass ce = new cellModifyingClass(ind,rw,cl,vle); aCM.add(ce);})
	  BACLOSE wsc )+ 	
	  
	;
scanerror //returns [ArrayList<Token> scr]
//@init {scr = new ArrayList<>();}	
	:	 
	sc = SCAN_ERROR {h.printError($sc);}
	;
	
ENDDOC	:
	'#ENDDOCUMENT'	
	;
STARTDOC 	:
	'#STARTDOCUMENT'	
	;
	
STARTINPATH:	'#STARTINPATH'
	;
	
ENDINPATH:	'#ENDINPATH'
;

STARTOUTPATH:	'#STARTOUTPATH'
	;
	
ENDOUTPATH:	'#ENDOUTPATH'
;

STARTCONVERSION:	
	'#STARTTYPECONVERSION'
	;
	
ENDCONVERSION:	
	'#ENDTYPECONVERSION'
;

STARTNAMESHEET:	
	'#STARTNAMESHEET'
	;
	
ENDNAMESHEET:	
	'#ENDNAMESHEET'
;


STARTDELETE
	:	
	'#STARTDELETE'
	;
ENDDELETE
	:	
	'#ENDDELETE'
	;

STARTMODIFYINGCELL
	:	
	'#STARTMODIFYINGCELL'
	;
ENDMODIFYINGCELL
	:	
	'#ENDMODIFYINGCELL'
	;
STARTROW:	
	'#STARTROW'
	;
ENDROW	:	
	'#ENDROW'
	;

STARTCOL:	
	'#STARTCOL'
	;
ENDCOL	:	
	'#ENDCOL'
	;
SHEETINDEX
	:
	'sheetIndex'	
	;
NEWNAMESHEET
	:
	'nameSheet'	
	;
INDEXDELETE
	:	
	'indexDelete'
	;
COLON	:
	':'	
	;
COL	:
	'col'	
	;
ROW	:
	'row'
	;
NEWVALUE:
	'value'	
	;

	

STRINGA	:	
	'"' ( options {greedy=false;} : . )* '"'
	;
COMMENT
    :   
    '*%' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '%*' ( options {greedy=false;} : . )* '*%'
    ;
    

 WS :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        )
    ;
 BAOPEN	:	
 	'<'
 	;
 BACLOSE:	
 	'>'
 	;
 COMMA 	:	
 	','
 	;
 INT 	:	
 	('0'..'9')+
 	;

SCAN_ERROR  : . ;
