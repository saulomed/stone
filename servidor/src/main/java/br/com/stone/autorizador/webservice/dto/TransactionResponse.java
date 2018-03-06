/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.webservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlType;
import br.com.stone.autorizador.transaction.enums.TransactionType;

/**
 * Resposta de Solicitacao de transacao
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@XmlType(name = "TransactionResponse", propOrder = {
   "cardNumber",
   "merchantId",
   "amount",
   "password",
   "transactionType",
   "parcelNumber",
   "reponseCode"
})
public class TransactionResponse implements Serializable
{

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = 1974221175352522568L;
   private String cardNumber;
   private Long merchantId;
   private BigDecimal amount;
   private String password;
   private TransactionType transactionType;
   private Integer parcelNumber;
   private int reponseCode;

   /**
    * Recupera o valor do atributo cardNumber
    * 
    * @return o cardNumber
    */
   public String getCardNumber()
   {
      return cardNumber;
   }

   /**
    * Atribui o novo valor de cardNumber
    * 
    * @param cardNumber cardNumber que será atribuído
    */
   public void setCardNumber(String cardNumber)
   {
      this.cardNumber = cardNumber;
   }

   /**
    * Recupera o valor do atributo merchantId
    * 
    * @return o merchantId
    */
   public Long getMerchantId()
   {
      return merchantId;
   }

   /**
    * Atribui o novo valor de merchantId
    * 
    * @param merchantId merchantId que será atribuído
    */
   public void setMerchantId(Long merchantId)
   {
      this.merchantId = merchantId;
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
    * Recupera o valor do atributo password
    * 
    * @return o password
    */
   public String getPassword()
   {
      return password;
   }

   /**
    * Atribui o novo valor de password
    * 
    * @param password password que será atribuído
    */
   public void setPassword(String password)
   {
      this.password = password;
   }

   /**
    * Recupera o valor do atributo transactionType
    * 
    * @return o transactionType
    */
   public TransactionType getTransactionType()
   {
      return transactionType;
   }

   /**
    * Atribui o novo valor de transactionType
    * 
    * @param transactionType transactionType que será atribuído
    */
   public void setTransactionType(TransactionType transactionType)
   {
      this.transactionType = transactionType;
   }

   /**
    * Recupera o valor do atributo parcelNumber
    * 
    * @return o parcelNumber
    */
   public Integer getParcelNumber()
   {
      return parcelNumber;
   }

   /**
    * Atribui o novo valor de parcelNumber
    * 
    * @param parcelNumber parcelNumber que será atribuído
    */
   public void setParcelNumber(Integer parcelNumber)
   {
      this.parcelNumber = parcelNumber;
   }

   /**
    * Recupera o valor do atributo reponseCode
    * 
    * @return o reponseCode
    */
   public int getReponseCode()
   {
      return reponseCode;
   }

   /**
    * Atribui o novo valor de reponseCode
    * 
    * @param reponseCode reponseCode que será atribuído
    */
   public void setReponseCode(int reponseCode)
   {
      this.reponseCode = reponseCode;
   }
}
