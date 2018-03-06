/*
* Criação : 17 de fev de 2018
*/

package br.com.stone.autorizador.webservice;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Classe utilitaria de auxilio para conversao de valores
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public abstract class ConvertUtil
{

   /**
    * Converte o XMLGregorianCalendar em Date
    * 
    * @param gC
    * @return
    */
   public static Date convertGregorianCalendarToDate(XMLGregorianCalendar gC)
   {
      return gC.toGregorianCalendar().getTime();
   }

   /**
    * Converte Date para XMLGregorianCalendar
    * 
    * @param date
    * @return
    */
   public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date)
   {
      GregorianCalendar gCalendar = new GregorianCalendar();
      gCalendar.setTime(date);
      XMLGregorianCalendar xmlCalendar = null;
      try
      {
         xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
      }
      catch (DatatypeConfigurationException ex)
      {
         Logger.getLogger(ConvertUtil.class.getName()).log(Level.SEVERE, null, ex);
      }
      return xmlCalendar;
   }

}
