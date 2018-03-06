/*
* Criação : 14 de fev de 2018
*/
package br.com.stone.autorizador.webservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import br.com.stone.autorizador.transaction.entity.Transaction;
import br.com.stone.autorizador.transaction.enums.TransactionType;

/**
 * Objeto de transporte para a apresentacao em tela da entidade {@link Transaction}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransacationViewDTO", propOrder = {
   "usn",
   "amount",
   "type",
   "card",
   "holderNameCard",
   "number",
   "merchant",
   "referenceDate"
})
public class TransacationViewDTO implements Serializable
{

   private static final long serialVersionUID = 6303201646514682998L;

   private Long usn;
   /** Montante da transação */
   private BigDecimal amount;
   /** tipo da transacao */
   private TransactionType type;
   /** numero do cartao */
   private String card;
   /** Nome do Cliente */
   private String holderNameCard;
   /** numero de parcelas */
   private Integer number;
   /** nome do estabelecimento comercial */
   private String merchant;
   /** Data de Referencia da transacao */
   @XmlElement(required = true)
   @XmlSchemaType(name = "date")
   private XMLGregorianCalendar referenceDate;

   /**
    * Recupera o valor do atributo usn
    * 
    * @return o usn
    */
   public Long getUsn()
   {
      return usn;
   }

   /**
    * Atribui o novo valor de usn
    * 
    * @param usn usn que será atribuído
    */
   public void setUsn(Long usn)
   {
      this.usn = usn;
   }

   /**
    * Recupera o valor do atributo amount
    * 
    * @return o amount
    */
   public BigDecimal getAmount()
   {
      return amount;
   }

   /**
    * Atribui o novo valor de amount
    * 
    * @param amount amount que será atribuído
    */
   public void setAmount(BigDecimal amount)
   {
      this.amount = amount;
   }

   /**
    * Recupera o valor do atributo type
    * 
    * @return o type
    */
   public TransactionType getType()
   {
      return type;
   }

   /**
    * Atribui o novo valor de type
    * 
    * @param type type que será atribuído
    */
   public void setType(TransactionType type)
   {
      this.type = type;
   }

   /**
    * Recupera o valor do atributo card
    * 
    * @return o card
    */
   public String getCard()
   {
      return card;
   }

   /**
    * Atribui o novo valor de card
    * 
    * @param card card que será atribuído
    */
   public void setCard(String card)
   {
      this.card = card;
   }

   /**
    * Recupera o valor do atributo holderNameCard
    * 
    * @return o holderNameCard
    */
   public String getHolderNameCard()
   {
      return holderNameCard;
   }

   /**
    * Atribui o novo valor de holderNameCard
    * 
    * @param holderNameCard holderNameCard que será atribuído
    */
   public void setHolderNameCard(String holderNameCard)
   {
      this.holderNameCard = holderNameCard;
   }

   /**
    * Recupera o valor do atributo number
    * 
    * @return o number
    */
   public Integer getNumber()
   {
      return number;
   }

   /**
    * Atribui o novo valor de number
    * 
    * @param number number que será atribuído
    */
   public void setNumber(Integer number)
   {
      this.number = number;
   }

   /**
    * Recupera o valor do atributo merchant
    * 
    * @return o merchant
    */
   public String getMerchant()
   {
      return merchant;
   }

   /**
    * Atribui o novo valor de merchant
    * 
    * @param merchant merchant que será atribuído
    */
   public void setMerchant(String merchant)
   {
      this.merchant = merchant;
   }

   /**
    * Recupera o valor do atributo referenceDate
    * 
    * @return o referenceDate
    */
   public XMLGregorianCalendar getReferenceDate()
   {
      return referenceDate;
   }

   /**
    * Atribui o novo valor de referenceDate
    * 
    * @param referenceDate referenceDate que será atribuído
    */
   public void setReferenceDate(XMLGregorianCalendar referenceDate)
   {
      this.referenceDate = referenceDate;
   }

}
