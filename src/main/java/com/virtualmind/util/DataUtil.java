//<BEGIN DEFECT TESTE INTEGRADO> PVC FASE 2 - FABRICA ACCENTURE - 20/11/2008 

package com.virtualmind.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
	private static final String PATTERN_DATA = "yyyy-MM-dd hh:mm:ss";
	private static SimpleDateFormat sdf;
	
	static {
		 sdf = new SimpleDateFormat(PATTERN_DATA);
	}
	
	public Date parseData(Long timeInMilliSeconds){
		Date date = new Date();
		date.setTime(timeInMilliSeconds);
		return date;		
	}
	
	
	public Date parseDataBanco(String dataString) throws ParseException{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date data = fmt.parse(dataString);
		
		//Date data = new Date(fmt.parse(dataString).toString()); 		
       //String data_c = n_data.getText();   
      //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");   
	//Date data = formatter.parse(data_c);  

	     return data;	
    }
	
	public Date parseDataBancoDb2(String dataString) throws ParseException{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date data = fmt.parse(dataString);
		
		//Date data = new Date(fmt.parse(dataString).toString()); 		
       //String data_c = n_data.getText();   
      //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");   
	//Date data = formatter.parse(data_c);  

	     return data;	
    }
	
	 

	public String parseString(Long timeInMilliSeconds){
		Date date = new Date();
		date.setTime(timeInMilliSeconds);
		return sdf.format(date);		
	}
	
	
	
	
}
//<END DEFECT TESTE INTEGRADO> PVC FASE 2 - FABRICA ACCENTURE - 20/11/2008 

