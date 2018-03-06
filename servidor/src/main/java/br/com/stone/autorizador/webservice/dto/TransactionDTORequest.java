/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.webservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import br.com.stone.autorizador.transaction.enums.TransactionType;

/**
 * Solicitacao de transacao
 * 
 * @author Feveriro/2018: Saulo Santos
 *         <DD>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionDTORequest", propOrder = {
   "cardNumber",
   "merchantId",
   "amount",
   "password",
   "transactionType",
   "parcelNumber"
})
public class TransactionDTORequest implements Serializable
{

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = -6117721815699813266L;

   private String cardNumber;
   private Long merchantId;
   private BigDecimal amount;
   private String password;
   private TransactionType transactionType;
   private Integer parcelNumber;

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
    * (Ver Javadoc da super classe)
    * 
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((amount == null) ? 0 : amount.hashCode());
      result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
      result = prime * result + ((merchantId == null) ? 0 : merchantId.hashCode());
      result = prime * result + ((parcelNumber == null) ? 0 : parcelNumber.hashCode());
      result = prime * result + ((password == null) ? 0 : password.hashCode());
      result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
      return result;
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      TransactionDTORequest other = (TransactionDTORequest) obj;
      if (amount == null)
      {
         if (other.amount != null)
            return false;
      }
      else if (!amount.equals(other.amount))
         return false;
      if (cardNumber == null)
      {
         if (other.cardNumber != null)
            return false;
      }
      else if (!cardNumber.equals(other.cardNumber))
         return false;
      if (merchantId == null)
      {
         if (other.merchantId != null)
            return false;
      }
      else if (!merchantId.equals(other.merchantId))
         return false;
      if (parcelNumber == null)
      {
         if (other.parcelNumber != null)
            return false;
      }
      else if (!parcelNumber.equals(other.parcelNumber))
         return false;
      if (password == null)
      {
         if (other.password != null)
            return false;
      }
      else if (!password.equals(other.password))
         return false;
      if (transactionType != other.transactionType)
         return false;
      return true;
   }

}
