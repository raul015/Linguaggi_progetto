grammar grammatica;

options{
language = Java;
k = 1;
}

@lexer::header{
	package myCompiler;
}

@lexer::members{

}

@header{
package myCompiler;

// Inserire le import per vostruttore (vedere @members )

	//SE SI VUOLE UTILIZZARE IL FILE ParserLauncher
	
import myCompiler.util.*;
import myCompiler.GrammaticaHandler;
import java.io.IOException;
import java.io.StringReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;



}

@members{

// ************************************ inizio Analizzatore semantico

GrammaticaHandler h;


// ****************************************** Parte scanner e parser 
public grammaticaParser(FileReader fileIn) throws  IOException{
			this(new CommonTokenStream(
							new grammaticaLexer(
									new ANTLRReaderStream(fileIn))));
	
			h = new GrammaticaHandler(input);
		}
	public grammaticaParser(String docIn) throws IOException {		
			this(new CommonTokenStream(
							new grammaticaLexer(
								new ANTLRReaderStream(
											new StringReader (docIn))))); 
			h = new GrammaticaHandler (input);
		}
		


//**
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
	( cT = conversion { h.setConversionType(cT);} )?
	wsc
	
	( nS = namesheet { h.setSheetName(nS);})?
	
	wsc
	(d = delete{h.printDelete(d);})?
	
	wsc
	( cM = modifyingcell{h.modifyingCellMeth(cM);})?
	
	;
	
wsc	:	
	(WS | COMMENT)* 
	;
	
// Il value me lo ritorna path
inpath returns[Token p]
	:	

	 STARTINPATH (x=path {p=x;}) ENDINPATH   wsc 
	 // dovrei fare un altro assegnamento, perch? ? path che mi restituisce
	 // il vero valore
	;
	
path	returns [Token p]
	:	
	wsc BAOPEN (x = STRINGA {p = $x;})  BACLOSE  wsc 
	;
	
	
// se nel file input viene messo il token DI outpath allora almeno un path di uscita deve essere inserito altrimenti errore.
outpath	 returns[ArrayList<Token> p]
@init { p = new ArrayList<Token>();}
	:	
	STARTOUTPATH (x=path {p.add(x);})+ ENDOUTPATH  
	;
conversion returns [ArrayList<Token> cT]
	:	
	STARTCONVERSION wsc ( cType = type{ cT = cType; System.out.println("sono in conversione");})  wsc ENDCONVERSION
	;
	
namesheet returns [Map<Token, Token> nS]
	:	
	STARTNAMESHEET ( nameS = sheet { nS = nameS;}) wsc ENDNAMESHEET
	;
	
sheet	returns [Map<Token,Token> nS]
@init { nS = new HashMap<Token, Token>();}
	:	
	(wsc BAOPEN SHEETINDEX COLON ( index = INT) COMMA NEWNAMESHEET  COLON ( nameSheet = STRINGA {nS.put(index, nameSheet);} )  BACLOSE wsc)+
	;
	
type returns [ArrayList<Token> cType]
@init { cType = new ArrayList<Token>();}

	:	
		BAOPEN (s1 = STRINGA { cType.add(s1);})   BACLOSE wsc (BAOPEN  (s2 = STRINGA {cType.add(s2);} ) BACLOSE)? wsc (BAOPEN (s3= STRINGA {cType.add(s3);}) BACLOSE)? 
	;
	
	
delete returns [ArrayList<Delete<Token,Token>> con]
@init{con = new ArrayList<>();}
	:
	STARTDELETE wsc  (r = row )? wsc (c = col)? wsc ENDDELETE{con.addAll(r);con.addAll(c);h.fusionDelete(r,c);}
	;
	
	
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
	(wsc BAOPEN SHEETINDEX COLON (index = INT) COMMA INDEXDELETE COLON (del = INT{Delete p= new Delete(index,del); d.add(p);}) BACLOSE wsc )+ 
	;
	
modifyingcell returns [ArrayList<cellModifyingClass<Token,Token,Token,Token>> aCM]
	:	
	STARTMODIFYINGCELL (aCMM = modcell{aCM = aCMM;}) ENDMODIFYINGCELL
	;

modcell	returns [ArrayList<cellModifyingClass<Token,Token,Token,Token>> aCM]
@init {aCM = new ArrayList<>();}	
	:
	(wsc BAOPEN SHEETINDEX COLON (ind = INT) COMMA ROW COLON (rw = INT) COMMA COL COLON ( cl = INT) COMMA NEWVALUE COLON ( vle = (INT | STRINGA) {cellModifyingClass ce = new cellModifyingClass(ind,rw,cl,vle); aCM.add(ce);}) BACLOSE wsc )+ 	
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
    '%*' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
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
