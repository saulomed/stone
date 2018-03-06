/*
* Criação : 14 de fev de 2018
*/
package br.com.stone.autorizador.webservice.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Objeto de consulta de transações
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaTransacoesSolicitacao", propOrder = {
   "referenceDate"
})
public class ConsultaTransacoesSolicitacao implements Serializable
{

   private static final long serialVersionUID = -3889582613311542720L;

   @XmlElement(required = true)
   @XmlSchemaType(name = "date")
   private XMLGregorianCalendar referenceDate;

   /**
   * Recupera o valor do atributo referenceDate
   * @return o referenceDate
   */
   public XMLGregorianCalendar getReferenceDate()
   {
      return referenceDate;
   }

   /**
   * Atribui o novo valor de referenceDate
   * @param referenceDate referenceDate que será atribuído
   */
   public void setReferenceDate(XMLGregorianCalendar referenceDate)
   {
      this.referenceDate = referenceDate;
   }

}
