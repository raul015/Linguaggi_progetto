// $ANTLR 3.5.1 C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g 2022-11-01 11:26:28

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





import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class grammaticaParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BACLOSE", "BAOPEN", "COL", "COLON", 
		"COMMA", "COMMENT", "ENDCOL", "ENDCONVERSION", "ENDDELETE", "ENDDOC", 
		"ENDINPATH", "ENDMODIFYINGCELL", "ENDNAMESHEET", "ENDOUTPATH", "ENDROW", 
		"INDEXDELETE", "INT", "NEWNAMESHEET", "NEWVALUE", "ROW", "SCAN_ERROR", 
		"SHEETINDEX", "STARTCOL", "STARTCONVERSION", "STARTDELETE", "STARTDOC", 
		"STARTINPATH", "STARTMODIFYINGCELL", "STARTNAMESHEET", "STARTOUTPATH", 
		"STARTROW", "STRINGA", "WS"
	};
	public static final int EOF=-1;
	public static final int BACLOSE=4;
	public static final int BAOPEN=5;
	public static final int COL=6;
	public static final int COLON=7;
	public static final int COMMA=8;
	public static final int COMMENT=9;
	public static final int ENDCOL=10;
	public static final int ENDCONVERSION=11;
	public static final int ENDDELETE=12;
	public static final int ENDDOC=13;
	public static final int ENDINPATH=14;
	public static final int ENDMODIFYINGCELL=15;
	public static final int ENDNAMESHEET=16;
	public static final int ENDOUTPATH=17;
	public static final int ENDROW=18;
	public static final int INDEXDELETE=19;
	public static final int INT=20;
	public static final int NEWNAMESHEET=21;
	public static final int NEWVALUE=22;
	public static final int ROW=23;
	public static final int SCAN_ERROR=24;
	public static final int SHEETINDEX=25;
	public static final int STARTCOL=26;
	public static final int STARTCONVERSION=27;
	public static final int STARTDELETE=28;
	public static final int STARTDOC=29;
	public static final int STARTINPATH=30;
	public static final int STARTMODIFYINGCELL=31;
	public static final int STARTNAMESHEET=32;
	public static final int STARTOUTPATH=33;
	public static final int STARTROW=34;
	public static final int STRINGA=35;
	public static final int WS=36;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public grammaticaParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public grammaticaParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return grammaticaParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g"; }



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





	// $ANTLR start "language"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:80:1: language : STARTDOC wsc body wsc ENDDOC ;
	public final void language() throws RecognitionException {
		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:81:2: ( STARTDOC wsc body wsc ENDDOC )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:82:3: STARTDOC wsc body wsc ENDDOC
			{
			match(input,STARTDOC,FOLLOW_STARTDOC_in_language62); 
			pushFollow(FOLLOW_wsc_in_language64);
			wsc();
			state._fsp--;

			pushFollow(FOLLOW_body_in_language66);
			body();
			state._fsp--;

			pushFollow(FOLLOW_wsc_in_language68);
			wsc();
			state._fsp--;

			match(input,ENDDOC,FOLLOW_ENDDOC_in_language71); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "language"



	// $ANTLR start "body"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:86:2: body : (i= inpath ) wsc (o= outpath )? wsc (cT= conversion ) wsc (nS= namesheet )? wsc (d= delete )? wsc (cM= modifyingcell )? ;
	public final void body() throws RecognitionException {
		Token i =null;
		ArrayList<Token> o =null;
		ArrayList<Token> cT =null;
		Map<Token, Token> nS =null;
		ArrayList<Delete<Token,Token>> d =null;
		ArrayList<cellModifyingClass<Token,Token,Token,Token>> cM =null;

		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:86:7: ( (i= inpath ) wsc (o= outpath )? wsc (cT= conversion ) wsc (nS= namesheet )? wsc (d= delete )? wsc (cM= modifyingcell )? )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:87:3: (i= inpath ) wsc (o= outpath )? wsc (cT= conversion ) wsc (nS= namesheet )? wsc (d= delete )? wsc (cM= modifyingcell )?
			{
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:87:3: (i= inpath )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:87:4: i= inpath
			{
			pushFollow(FOLLOW_inpath_in_body92);
			i=inpath();
			state._fsp--;

			h.setInputPath(i);
			}

			pushFollow(FOLLOW_wsc_in_body98);
			wsc();
			state._fsp--;

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:89:3: (o= outpath )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==STARTOUTPATH) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:89:4: o= outpath
					{
					pushFollow(FOLLOW_outpath_in_body107);
					o=outpath();
					state._fsp--;

					h.setOuputPath(o);
					}
					break;

			}

			pushFollow(FOLLOW_wsc_in_body114);
			wsc();
			state._fsp--;

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:91:3: (cT= conversion )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:91:4: cT= conversion
			{
			pushFollow(FOLLOW_conversion_in_body123);
			cT=conversion();
			state._fsp--;

			 h.setConversionType(cT);
			}

			pushFollow(FOLLOW_wsc_in_body131);
			wsc();
			state._fsp--;

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:94:3: (nS= namesheet )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==STARTNAMESHEET) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:94:4: nS= namesheet
					{
					pushFollow(FOLLOW_namesheet_in_body142);
					nS=namesheet();
					state._fsp--;

					 h.setSheetName(nS);
					}
					break;

			}

			pushFollow(FOLLOW_wsc_in_body152);
			wsc();
			state._fsp--;

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:97:3: (d= delete )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==STARTDELETE) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:97:4: d= delete
					{
					pushFollow(FOLLOW_delete_in_body161);
					d=delete();
					state._fsp--;

					h.printDelete(d);
					}
					break;

			}

			pushFollow(FOLLOW_wsc_in_body170);
			wsc();
			state._fsp--;

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:100:3: (cM= modifyingcell )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==STARTMODIFYINGCELL) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:100:4: cM= modifyingcell
					{
					pushFollow(FOLLOW_modifyingcell_in_body179);
					cM=modifyingcell();
					state._fsp--;

					h.modifyingCellMeth(cM);
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "body"



	// $ANTLR start "wsc"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:104:1: wsc : ( WS | COMMENT | scanerror )* ;
	public final void wsc() throws RecognitionException {
		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:104:5: ( ( WS | COMMENT | scanerror )* )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:105:2: ( WS | COMMENT | scanerror )*
			{
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:105:2: ( WS | COMMENT | scanerror )*
			loop5:
			while (true) {
				int alt5=4;
				switch ( input.LA(1) ) {
				case WS:
					{
					alt5=1;
					}
					break;
				case COMMENT:
					{
					alt5=2;
					}
					break;
				case SCAN_ERROR:
					{
					alt5=3;
					}
					break;
				}
				switch (alt5) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:105:3: WS
					{
					match(input,WS,FOLLOW_WS_in_wsc198); 
					}
					break;
				case 2 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:105:8: COMMENT
					{
					match(input,COMMENT,FOLLOW_COMMENT_in_wsc202); 
					}
					break;
				case 3 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:105:17: scanerror
					{
					pushFollow(FOLLOW_scanerror_in_wsc205);
					scanerror();
					state._fsp--;

					}
					break;

				default :
					break loop5;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "wsc"



	// $ANTLR start "inpath"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:115:1: inpath returns [Token p] : STARTINPATH (x= path ) ENDINPATH wsc ;
	public final Token inpath() throws RecognitionException {
		Token p = null;


		Token x =null;

		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:116:2: ( STARTINPATH (x= path ) ENDINPATH wsc )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:118:3: STARTINPATH (x= path ) ENDINPATH wsc
			{
			match(input,STARTINPATH,FOLLOW_STARTINPATH_in_inpath230); 
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:118:15: (x= path )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:118:16: x= path
			{
			pushFollow(FOLLOW_path_in_inpath235);
			x=path();
			state._fsp--;

			p=x;
			}

			match(input,ENDINPATH,FOLLOW_ENDINPATH_in_inpath240); 
			pushFollow(FOLLOW_wsc_in_inpath244);
			wsc();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return p;
	}
	// $ANTLR end "inpath"



	// $ANTLR start "path"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:122:1: path returns [Token p] : wsc BAOPEN (x= STRINGA ) BACLOSE wsc ;
	public final Token path() throws RecognitionException {
		Token p = null;


		Token x=null;

		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:123:2: ( wsc BAOPEN (x= STRINGA ) BACLOSE wsc )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:125:2: wsc BAOPEN (x= STRINGA ) BACLOSE wsc
			{
			pushFollow(FOLLOW_wsc_in_path266);
			wsc();
			state._fsp--;

			match(input,BAOPEN,FOLLOW_BAOPEN_in_path268); 
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:125:13: (x= STRINGA )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:125:14: x= STRINGA
			{
			x=(Token)match(input,STRINGA,FOLLOW_STRINGA_in_path275); 
			p = x;
			}

			match(input,BACLOSE,FOLLOW_BACLOSE_in_path281); 
			pushFollow(FOLLOW_wsc_in_path284);
			wsc();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return p;
	}
	// $ANTLR end "path"



	// $ANTLR start "outpath"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:132:1: outpath returns [ArrayList<Token> p] : STARTOUTPATH (x= path )+ ENDOUTPATH ;
	public final ArrayList<Token> outpath() throws RecognitionException {
		ArrayList<Token> p = null;


		Token x =null;

		 p = new ArrayList<Token>();
		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:135:2: ( STARTOUTPATH (x= path )+ ENDOUTPATH )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:137:2: STARTOUTPATH (x= path )+ ENDOUTPATH
			{
			match(input,STARTOUTPATH,FOLLOW_STARTOUTPATH_in_outpath317); 
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:137:15: (x= path )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==BAOPEN||LA6_0==COMMENT||LA6_0==SCAN_ERROR||LA6_0==WS) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:137:16: x= path
					{
					pushFollow(FOLLOW_path_in_outpath322);
					x=path();
					state._fsp--;

					 p.add(x);
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match(input,ENDOUTPATH,FOLLOW_ENDOUTPATH_in_outpath328); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return p;
	}
	// $ANTLR end "outpath"



	// $ANTLR start "conversion"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:141:1: conversion returns [ArrayList<Token> cT] : STARTCONVERSION wsc (cType= type ) wsc ENDCONVERSION ;
	public final ArrayList<Token> conversion() throws RecognitionException {
		ArrayList<Token> cT = null;


		ArrayList<Token> cType =null;

		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:142:2: ( STARTCONVERSION wsc (cType= type ) wsc ENDCONVERSION )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:144:2: STARTCONVERSION wsc (cType= type ) wsc ENDCONVERSION
			{
			match(input,STARTCONVERSION,FOLLOW_STARTCONVERSION_in_conversion352); 
			pushFollow(FOLLOW_wsc_in_conversion354);
			wsc();
			state._fsp--;

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:144:22: (cType= type )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:144:24: cType= type
			{
			pushFollow(FOLLOW_type_in_conversion362);
			cType=type();
			state._fsp--;

			 cT = cType;
			}

			pushFollow(FOLLOW_wsc_in_conversion366);
			wsc();
			state._fsp--;

			match(input,ENDCONVERSION,FOLLOW_ENDCONVERSION_in_conversion368); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cT;
	}
	// $ANTLR end "conversion"



	// $ANTLR start "namesheet"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:148:1: namesheet returns [Map<Token, Token> nS] : STARTNAMESHEET (nameS= sheet ) wsc ENDNAMESHEET ;
	public final Map<Token, Token> namesheet() throws RecognitionException {
		Map<Token, Token> nS = null;


		Map<Token,Token> nameS =null;

		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:149:2: ( STARTNAMESHEET (nameS= sheet ) wsc ENDNAMESHEET )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:151:2: STARTNAMESHEET (nameS= sheet ) wsc ENDNAMESHEET
			{
			match(input,STARTNAMESHEET,FOLLOW_STARTNAMESHEET_in_namesheet390); 
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:151:17: (nameS= sheet )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:151:19: nameS= sheet
			{
			pushFollow(FOLLOW_sheet_in_namesheet398);
			nameS=sheet();
			state._fsp--;

			 nS = nameS;
			}

			pushFollow(FOLLOW_wsc_in_namesheet403);
			wsc();
			state._fsp--;

			match(input,ENDNAMESHEET,FOLLOW_ENDNAMESHEET_in_namesheet405); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return nS;
	}
	// $ANTLR end "namesheet"



	// $ANTLR start "sheet"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:155:1: sheet returns [Map<Token,Token> nS] : ( wsc BAOPEN SHEETINDEX COLON (index= ( INT | STRINGA ) ) COMMA NEWNAMESHEET COLON (nameSheet= STRINGA ) BACLOSE wsc )+ ;
	public final Map<Token,Token> sheet() throws RecognitionException {
		Map<Token,Token> nS = null;


		Token index=null;
		Token nameSheet=null;

		 nS = new HashMap<Token, Token>();
		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:158:2: ( ( wsc BAOPEN SHEETINDEX COLON (index= ( INT | STRINGA ) ) COMMA NEWNAMESHEET COLON (nameSheet= STRINGA ) BACLOSE wsc )+ )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:160:2: ( wsc BAOPEN SHEETINDEX COLON (index= ( INT | STRINGA ) ) COMMA NEWNAMESHEET COLON (nameSheet= STRINGA ) BACLOSE wsc )+
			{
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:160:2: ( wsc BAOPEN SHEETINDEX COLON (index= ( INT | STRINGA ) ) COMMA NEWNAMESHEET COLON (nameSheet= STRINGA ) BACLOSE wsc )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				switch ( input.LA(1) ) {
				case WS:
					{
					alt7=1;
					}
					break;
				case COMMENT:
					{
					alt7=1;
					}
					break;
				case SCAN_ERROR:
					{
					alt7=1;
					}
					break;
				case BAOPEN:
					{
					alt7=1;
					}
					break;
				}
				switch (alt7) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:160:3: wsc BAOPEN SHEETINDEX COLON (index= ( INT | STRINGA ) ) COMMA NEWNAMESHEET COLON (nameSheet= STRINGA ) BACLOSE wsc
					{
					pushFollow(FOLLOW_wsc_in_sheet434);
					wsc();
					state._fsp--;

					match(input,BAOPEN,FOLLOW_BAOPEN_in_sheet436); 
					match(input,SHEETINDEX,FOLLOW_SHEETINDEX_in_sheet438); 
					match(input,COLON,FOLLOW_COLON_in_sheet440); 
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:160:31: (index= ( INT | STRINGA ) )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:160:33: index= ( INT | STRINGA )
					{
					index=input.LT(1);
					if ( input.LA(1)==INT||input.LA(1)==STRINGA ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}

					System.out.println("tipo : "+ index.getType());
					match(input,COMMA,FOLLOW_COMMA_in_sheet457); 
					match(input,NEWNAMESHEET,FOLLOW_NEWNAMESHEET_in_sheet459); 
					match(input,COLON,FOLLOW_COLON_in_sheet462); 
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:161:2: (nameSheet= STRINGA )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:161:4: nameSheet= STRINGA
					{
					nameSheet=(Token)match(input,STRINGA,FOLLOW_STRINGA_in_sheet472); 
					nS.put(index, nameSheet);
					}

					match(input,BACLOSE,FOLLOW_BACLOSE_in_sheet479); 
					pushFollow(FOLLOW_wsc_in_sheet481);
					wsc();
					state._fsp--;

					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return nS;
	}
	// $ANTLR end "sheet"



	// $ANTLR start "type"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:166:1: type returns [ArrayList<Token> cType] : ( BAOPEN ) (s1= STRINGA ) ( BACLOSE ) wsc ( ( BAOPEN ) (s2= STRINGA ) ( BACLOSE ) )? wsc ( ( BAOPEN ) (s3= STRINGA ) ( BACLOSE ) )? ;
	public final ArrayList<Token> type() throws RecognitionException {
		ArrayList<Token> cType = null;


		Token s1=null;
		Token s2=null;
		Token s3=null;

		 cType = new ArrayList<Token>();
		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:169:2: ( ( BAOPEN ) (s1= STRINGA ) ( BACLOSE ) wsc ( ( BAOPEN ) (s2= STRINGA ) ( BACLOSE ) )? wsc ( ( BAOPEN ) (s3= STRINGA ) ( BACLOSE ) )? )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:170:2: ( BAOPEN ) (s1= STRINGA ) ( BACLOSE ) wsc ( ( BAOPEN ) (s2= STRINGA ) ( BACLOSE ) )? wsc ( ( BAOPEN ) (s3= STRINGA ) ( BACLOSE ) )?
			{
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:170:2: ( BAOPEN )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:170:3: BAOPEN
			{
			match(input,BAOPEN,FOLLOW_BAOPEN_in_type511); 
			}

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:170:11: (s1= STRINGA )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:170:12: s1= STRINGA
			{
			s1=(Token)match(input,STRINGA,FOLLOW_STRINGA_in_type519); 
			cType.add(s1);
			}

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:170:43: ( BACLOSE )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:170:44: BACLOSE
			{
			match(input,BACLOSE,FOLLOW_BACLOSE_in_type525); 
			}

			pushFollow(FOLLOW_wsc_in_type528);
			wsc();
			state._fsp--;

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:171:2: ( ( BAOPEN ) (s2= STRINGA ) ( BACLOSE ) )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==BAOPEN) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:171:4: ( BAOPEN ) (s2= STRINGA ) ( BACLOSE )
					{
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:171:4: ( BAOPEN )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:171:5: BAOPEN
					{
					match(input,BAOPEN,FOLLOW_BAOPEN_in_type535); 
					}

					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:171:14: (s2= STRINGA )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:171:15: s2= STRINGA
					{
					s2=(Token)match(input,STRINGA,FOLLOW_STRINGA_in_type544); 
					cType.add(s2);
					}

					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:171:47: ( BACLOSE )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:171:49: BACLOSE
					{
					match(input,BACLOSE,FOLLOW_BACLOSE_in_type552); 
					}

					}
					break;

			}

			pushFollow(FOLLOW_wsc_in_type557);
			wsc();
			state._fsp--;

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:172:2: ( ( BAOPEN ) (s3= STRINGA ) ( BACLOSE ) )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==BAOPEN) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:172:3: ( BAOPEN ) (s3= STRINGA ) ( BACLOSE )
					{
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:172:3: ( BAOPEN )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:172:4: BAOPEN
					{
					match(input,BAOPEN,FOLLOW_BAOPEN_in_type562); 
					}

					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:172:12: (s3= STRINGA )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:172:13: s3= STRINGA
					{
					s3=(Token)match(input,STRINGA,FOLLOW_STRINGA_in_type569); 
					cType.add(s3);
					}

					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:172:43: ( BACLOSE )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:172:44: BACLOSE
					{
					match(input,BACLOSE,FOLLOW_BACLOSE_in_type575); 
					}

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cType;
	}
	// $ANTLR end "type"



	// $ANTLR start "delete"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:257:1: delete returns [ArrayList<Delete<Token,Token>> con] : STARTDELETE wsc (r= row )? wsc (c= col )? wsc ENDDELETE ;
	public final ArrayList<Delete<Token,Token>> delete() throws RecognitionException {
		ArrayList<Delete<Token,Token>> con = null;


		ArrayList<Delete<Token,Token>> r =null;
		ArrayList<Delete<Token,Token>> c =null;

		con = new ArrayList<>();
		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:260:2: ( STARTDELETE wsc (r= row )? wsc (c= col )? wsc ENDDELETE )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:262:2: STARTDELETE wsc (r= row )? wsc (c= col )? wsc ENDDELETE
			{
			match(input,STARTDELETE,FOLLOW_STARTDELETE_in_delete618); 
			pushFollow(FOLLOW_wsc_in_delete620);
			wsc();
			state._fsp--;

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:262:19: (r= row )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==STARTROW) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:262:20: r= row
					{
					pushFollow(FOLLOW_row_in_delete628);
					r=row();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_wsc_in_delete633);
			wsc();
			state._fsp--;

			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:262:35: (c= col )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==STARTCOL) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:262:36: c= col
					{
					pushFollow(FOLLOW_col_in_delete640);
					c=col();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_wsc_in_delete644);
			wsc();
			state._fsp--;

			match(input,ENDDELETE,FOLLOW_ENDDELETE_in_delete646); 

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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return con;
	}
	// $ANTLR end "delete"



	// $ANTLR start "row"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:313:1: row returns [ArrayList<Delete<Token,Token>> r] : STARTROW (dr= todelete ) ENDROW ;
	public final ArrayList<Delete<Token,Token>> row() throws RecognitionException {
		ArrayList<Delete<Token,Token>> r = null;


		ArrayList<Delete<Token,Token>> dr =null;

		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:314:2: ( STARTROW (dr= todelete ) ENDROW )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:316:2: STARTROW (dr= todelete ) ENDROW
			{
			match(input,STARTROW,FOLLOW_STARTROW_in_row673); 
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:316:11: (dr= todelete )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:316:12: dr= todelete
			{
			pushFollow(FOLLOW_todelete_in_row679);
			dr=todelete();
			state._fsp--;

			r=dr;
			}

			match(input,ENDROW,FOLLOW_ENDROW_in_row683); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return r;
	}
	// $ANTLR end "row"



	// $ANTLR start "col"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:320:1: col returns [ArrayList<Delete<Token,Token>> c] : STARTCOL (dc= todelete ) ENDCOL ;
	public final ArrayList<Delete<Token,Token>> col() throws RecognitionException {
		ArrayList<Delete<Token,Token>> c = null;


		ArrayList<Delete<Token,Token>> dc =null;

		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:321:2: ( STARTCOL (dc= todelete ) ENDCOL )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:323:2: STARTCOL (dc= todelete ) ENDCOL
			{
			match(input,STARTCOL,FOLLOW_STARTCOL_in_col704); 
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:323:11: (dc= todelete )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:323:12: dc= todelete
			{
			pushFollow(FOLLOW_todelete_in_col711);
			dc=todelete();
			state._fsp--;

			c=dc;
			}

			match(input,ENDCOL,FOLLOW_ENDCOL_in_col715); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return c;
	}
	// $ANTLR end "col"



	// $ANTLR start "todelete"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:327:1: todelete returns [ArrayList<Delete<Token,Token>> d] : ( wsc BAOPEN SHEETINDEX COLON (index= ( INT | STRINGA ) ) COMMA INDEXDELETE COLON (del= INT ) BACLOSE wsc )+ ;
	public final ArrayList<Delete<Token,Token>> todelete() throws RecognitionException {
		ArrayList<Delete<Token,Token>> d = null;


		Token index=null;
		Token del=null;

		d = new ArrayList<>();
		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:330:2: ( ( wsc BAOPEN SHEETINDEX COLON (index= ( INT | STRINGA ) ) COMMA INDEXDELETE COLON (del= INT ) BACLOSE wsc )+ )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:332:2: ( wsc BAOPEN SHEETINDEX COLON (index= ( INT | STRINGA ) ) COMMA INDEXDELETE COLON (del= INT ) BACLOSE wsc )+
			{
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:332:2: ( wsc BAOPEN SHEETINDEX COLON (index= ( INT | STRINGA ) ) COMMA INDEXDELETE COLON (del= INT ) BACLOSE wsc )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==BAOPEN||LA12_0==COMMENT||LA12_0==SCAN_ERROR||LA12_0==WS) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:332:3: wsc BAOPEN SHEETINDEX COLON (index= ( INT | STRINGA ) ) COMMA INDEXDELETE COLON (del= INT ) BACLOSE wsc
					{
					pushFollow(FOLLOW_wsc_in_todelete743);
					wsc();
					state._fsp--;

					match(input,BAOPEN,FOLLOW_BAOPEN_in_todelete745); 
					match(input,SHEETINDEX,FOLLOW_SHEETINDEX_in_todelete747); 
					match(input,COLON,FOLLOW_COLON_in_todelete749); 
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:332:31: (index= ( INT | STRINGA ) )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:332:32: index= ( INT | STRINGA )
					{
					index=input.LT(1);
					if ( input.LA(1)==INT||input.LA(1)==STRINGA ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}

					match(input,COMMA,FOLLOW_COMMA_in_todelete765); 
					match(input,INDEXDELETE,FOLLOW_INDEXDELETE_in_todelete767); 
					match(input,COLON,FOLLOW_COLON_in_todelete769); 
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:333:2: (del= INT )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:333:3: del= INT
					{
					del=(Token)match(input,INT,FOLLOW_INT_in_todelete778); 
					Delete p= new Delete(index,del); d.add(p);
					}

					match(input,BACLOSE,FOLLOW_BACLOSE_in_todelete784); 
					pushFollow(FOLLOW_wsc_in_todelete786);
					wsc();
					state._fsp--;

					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return d;
	}
	// $ANTLR end "todelete"



	// $ANTLR start "modifyingcell"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:340:1: modifyingcell returns [ArrayList<cellModifyingClass<Token,Token,Token,Token>> aCM] : STARTMODIFYINGCELL (aCMM= modcell ) ENDMODIFYINGCELL ;
	public final ArrayList<cellModifyingClass<Token,Token,Token,Token>> modifyingcell() throws RecognitionException {
		ArrayList<cellModifyingClass<Token,Token,Token,Token>> aCM = null;


		ArrayList<cellModifyingClass<Token,Token,Token,Token>> aCMM =null;

		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:341:2: ( STARTMODIFYINGCELL (aCMM= modcell ) ENDMODIFYINGCELL )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:343:2: STARTMODIFYINGCELL (aCMM= modcell ) ENDMODIFYINGCELL
			{
			match(input,STARTMODIFYINGCELL,FOLLOW_STARTMODIFYINGCELL_in_modifyingcell816); 
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:343:21: (aCMM= modcell )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:343:22: aCMM= modcell
			{
			pushFollow(FOLLOW_modcell_in_modifyingcell823);
			aCMM=modcell();
			state._fsp--;

			aCM = aCMM;
			}

			match(input,ENDMODIFYINGCELL,FOLLOW_ENDMODIFYINGCELL_in_modifyingcell827); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return aCM;
	}
	// $ANTLR end "modifyingcell"



	// $ANTLR start "modcell"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:347:1: modcell returns [ArrayList<cellModifyingClass<Token,Token,Token,Token>> aCM] : ( wsc BAOPEN SHEETINDEX COLON (ind= ( INT | STRINGA ) ) COMMA ROW COLON (rw= ( INT | STRINGA ) ) COMMA COL COLON (cl= ( INT | STRINGA ) ) COMMA NEWVALUE COLON (vle= ( INT | STRINGA ) ) BACLOSE wsc )+ ;
	public final ArrayList<cellModifyingClass<Token,Token,Token,Token>> modcell() throws RecognitionException {
		ArrayList<cellModifyingClass<Token,Token,Token,Token>> aCM = null;


		Token ind=null;
		Token rw=null;
		Token cl=null;
		Token vle=null;

		aCM = new ArrayList<>();
		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:350:2: ( ( wsc BAOPEN SHEETINDEX COLON (ind= ( INT | STRINGA ) ) COMMA ROW COLON (rw= ( INT | STRINGA ) ) COMMA COL COLON (cl= ( INT | STRINGA ) ) COMMA NEWVALUE COLON (vle= ( INT | STRINGA ) ) BACLOSE wsc )+ )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:352:2: ( wsc BAOPEN SHEETINDEX COLON (ind= ( INT | STRINGA ) ) COMMA ROW COLON (rw= ( INT | STRINGA ) ) COMMA COL COLON (cl= ( INT | STRINGA ) ) COMMA NEWVALUE COLON (vle= ( INT | STRINGA ) ) BACLOSE wsc )+
			{
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:352:2: ( wsc BAOPEN SHEETINDEX COLON (ind= ( INT | STRINGA ) ) COMMA ROW COLON (rw= ( INT | STRINGA ) ) COMMA COL COLON (cl= ( INT | STRINGA ) ) COMMA NEWVALUE COLON (vle= ( INT | STRINGA ) ) BACLOSE wsc )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==BAOPEN||LA13_0==COMMENT||LA13_0==SCAN_ERROR||LA13_0==WS) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:352:3: wsc BAOPEN SHEETINDEX COLON (ind= ( INT | STRINGA ) ) COMMA ROW COLON (rw= ( INT | STRINGA ) ) COMMA COL COLON (cl= ( INT | STRINGA ) ) COMMA NEWVALUE COLON (vle= ( INT | STRINGA ) ) BACLOSE wsc
					{
					pushFollow(FOLLOW_wsc_in_modcell855);
					wsc();
					state._fsp--;

					match(input,BAOPEN,FOLLOW_BAOPEN_in_modcell857); 
					match(input,SHEETINDEX,FOLLOW_SHEETINDEX_in_modcell859); 
					match(input,COLON,FOLLOW_COLON_in_modcell861); 
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:352:31: (ind= ( INT | STRINGA ) )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:352:32: ind= ( INT | STRINGA )
					{
					ind=input.LT(1);
					if ( input.LA(1)==INT||input.LA(1)==STRINGA ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}

					match(input,COMMA,FOLLOW_COMMA_in_modcell877); 
					match(input,ROW,FOLLOW_ROW_in_modcell881); 
					match(input,COLON,FOLLOW_COLON_in_modcell883); 
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:353:12: (rw= ( INT | STRINGA ) )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:353:13: rw= ( INT | STRINGA )
					{
					rw=input.LT(1);
					if ( input.LA(1)==INT||input.LA(1)==STRINGA ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}

					match(input,COMMA,FOLLOW_COMMA_in_modcell899); 
					match(input,COL,FOLLOW_COL_in_modcell901); 
					match(input,COLON,FOLLOW_COLON_in_modcell903); 
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:353:51: (cl= ( INT | STRINGA ) )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:353:53: cl= ( INT | STRINGA )
					{
					cl=input.LT(1);
					if ( input.LA(1)==INT||input.LA(1)==STRINGA ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}

					match(input,COMMA,FOLLOW_COMMA_in_modcell920); 
					match(input,NEWVALUE,FOLLOW_NEWVALUE_in_modcell924); 
					match(input,COLON,FOLLOW_COLON_in_modcell926); 
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:354:17: (vle= ( INT | STRINGA ) )
					// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:354:19: vle= ( INT | STRINGA )
					{
					vle=input.LT(1);
					if ( input.LA(1)==INT||input.LA(1)==STRINGA ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					cellModifyingClass ce = new cellModifyingClass(ind,rw,cl,vle); aCM.add(ce);
					}

					match(input,BACLOSE,FOLLOW_BACLOSE_in_modcell950); 
					pushFollow(FOLLOW_wsc_in_modcell952);
					wsc();
					state._fsp--;

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return aCM;
	}
	// $ANTLR end "modcell"



	// $ANTLR start "scanerror"
	// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:359:1: scanerror : sc= SCAN_ERROR ;
	public final void scanerror() throws RecognitionException {
		Token sc=null;

		try {
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:361:2: (sc= SCAN_ERROR )
			// C:\\Users\\user\\Desktop\\Università\\Linguaggi_Progetto_17_10\\Linguaggi_Progetto_17_10\\src\\main\\java\\Grammatica\\myCompiler\\grammatica.g:362:2: sc= SCAN_ERROR
			{
			sc=(Token)match(input,SCAN_ERROR,FOLLOW_SCAN_ERROR_in_scanerror980); 
			h.printError(sc);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "scanerror"

	// Delegated rules



	public static final BitSet FOLLOW_STARTDOC_in_language62 = new BitSet(new long[]{0x0000001041000200L});
	public static final BitSet FOLLOW_wsc_in_language64 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_body_in_language66 = new BitSet(new long[]{0x0000001001002200L});
	public static final BitSet FOLLOW_wsc_in_language68 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ENDDOC_in_language71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inpath_in_body92 = new BitSet(new long[]{0x0000001209000200L});
	public static final BitSet FOLLOW_wsc_in_body98 = new BitSet(new long[]{0x0000001209000200L});
	public static final BitSet FOLLOW_outpath_in_body107 = new BitSet(new long[]{0x0000001009000200L});
	public static final BitSet FOLLOW_wsc_in_body114 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_conversion_in_body123 = new BitSet(new long[]{0x0000001191000200L});
	public static final BitSet FOLLOW_wsc_in_body131 = new BitSet(new long[]{0x0000001191000200L});
	public static final BitSet FOLLOW_namesheet_in_body142 = new BitSet(new long[]{0x0000001091000200L});
	public static final BitSet FOLLOW_wsc_in_body152 = new BitSet(new long[]{0x0000001091000200L});
	public static final BitSet FOLLOW_delete_in_body161 = new BitSet(new long[]{0x0000001081000200L});
	public static final BitSet FOLLOW_wsc_in_body170 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_modifyingcell_in_body179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WS_in_wsc198 = new BitSet(new long[]{0x0000001001000202L});
	public static final BitSet FOLLOW_COMMENT_in_wsc202 = new BitSet(new long[]{0x0000001001000202L});
	public static final BitSet FOLLOW_scanerror_in_wsc205 = new BitSet(new long[]{0x0000001001000202L});
	public static final BitSet FOLLOW_STARTINPATH_in_inpath230 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_path_in_inpath235 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ENDINPATH_in_inpath240 = new BitSet(new long[]{0x0000001001000200L});
	public static final BitSet FOLLOW_wsc_in_inpath244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_wsc_in_path266 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BAOPEN_in_path268 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_STRINGA_in_path275 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BACLOSE_in_path281 = new BitSet(new long[]{0x0000001001000200L});
	public static final BitSet FOLLOW_wsc_in_path284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STARTOUTPATH_in_outpath317 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_path_in_outpath322 = new BitSet(new long[]{0x0000001001020220L});
	public static final BitSet FOLLOW_ENDOUTPATH_in_outpath328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STARTCONVERSION_in_conversion352 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_wsc_in_conversion354 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_type_in_conversion362 = new BitSet(new long[]{0x0000001001000A00L});
	public static final BitSet FOLLOW_wsc_in_conversion366 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ENDCONVERSION_in_conversion368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STARTNAMESHEET_in_namesheet390 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_sheet_in_namesheet398 = new BitSet(new long[]{0x0000001001010200L});
	public static final BitSet FOLLOW_wsc_in_namesheet403 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDNAMESHEET_in_namesheet405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_wsc_in_sheet434 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BAOPEN_in_sheet436 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SHEETINDEX_in_sheet438 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_sheet440 = new BitSet(new long[]{0x0000000800100000L});
	public static final BitSet FOLLOW_set_in_sheet448 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COMMA_in_sheet457 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_NEWNAMESHEET_in_sheet459 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_sheet462 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_STRINGA_in_sheet472 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BACLOSE_in_sheet479 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_wsc_in_sheet481 = new BitSet(new long[]{0x0000001001000222L});
	public static final BitSet FOLLOW_BAOPEN_in_type511 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_STRINGA_in_type519 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BACLOSE_in_type525 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_wsc_in_type528 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_BAOPEN_in_type535 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_STRINGA_in_type544 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BACLOSE_in_type552 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_wsc_in_type557 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_BAOPEN_in_type562 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_STRINGA_in_type569 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BACLOSE_in_type575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STARTDELETE_in_delete618 = new BitSet(new long[]{0x0000001405001200L});
	public static final BitSet FOLLOW_wsc_in_delete620 = new BitSet(new long[]{0x0000001405001200L});
	public static final BitSet FOLLOW_row_in_delete628 = new BitSet(new long[]{0x0000001005001200L});
	public static final BitSet FOLLOW_wsc_in_delete633 = new BitSet(new long[]{0x0000001005001200L});
	public static final BitSet FOLLOW_col_in_delete640 = new BitSet(new long[]{0x0000001001001200L});
	public static final BitSet FOLLOW_wsc_in_delete644 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_ENDDELETE_in_delete646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STARTROW_in_row673 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_todelete_in_row679 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ENDROW_in_row683 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STARTCOL_in_col704 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_todelete_in_col711 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ENDCOL_in_col715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_wsc_in_todelete743 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BAOPEN_in_todelete745 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SHEETINDEX_in_todelete747 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_todelete749 = new BitSet(new long[]{0x0000000800100000L});
	public static final BitSet FOLLOW_set_in_todelete756 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COMMA_in_todelete765 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_INDEXDELETE_in_todelete767 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_todelete769 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_INT_in_todelete778 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BACLOSE_in_todelete784 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_wsc_in_todelete786 = new BitSet(new long[]{0x0000001001000222L});
	public static final BitSet FOLLOW_STARTMODIFYINGCELL_in_modifyingcell816 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_modcell_in_modifyingcell823 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ENDMODIFYINGCELL_in_modifyingcell827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_wsc_in_modcell855 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BAOPEN_in_modcell857 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_SHEETINDEX_in_modcell859 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_modcell861 = new BitSet(new long[]{0x0000000800100000L});
	public static final BitSet FOLLOW_set_in_modcell868 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COMMA_in_modcell877 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ROW_in_modcell881 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_modcell883 = new BitSet(new long[]{0x0000000800100000L});
	public static final BitSet FOLLOW_set_in_modcell890 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COMMA_in_modcell899 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_COL_in_modcell901 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_modcell903 = new BitSet(new long[]{0x0000000800100000L});
	public static final BitSet FOLLOW_set_in_modcell911 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_COMMA_in_modcell920 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_NEWVALUE_in_modcell924 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_modcell926 = new BitSet(new long[]{0x0000000800100000L});
	public static final BitSet FOLLOW_set_in_modcell934 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BACLOSE_in_modcell950 = new BitSet(new long[]{0x0000001001000220L});
	public static final BitSet FOLLOW_wsc_in_modcell952 = new BitSet(new long[]{0x0000001001000222L});
	public static final BitSet FOLLOW_SCAN_ERROR_in_scanerror980 = new BitSet(new long[]{0x0000000000000002L});
}
