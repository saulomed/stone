/*
* Criação : 3 de mar de 2018
*/
package br.com.stone.autorizador.transaction;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Objeto de manipulacao de tela
 * 
 * @author Março/2018: Saulo Santos
 *         <DD>
 */
public class TransactionView implements Serializable
{

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = 3475108287452330598L;

   private String cardNumber;
   private Long merchantId;
   private BigDecimal amount;
   private String password;
   private Integer transactionType;
   private Integer parcelNumber;
   /**
   * Recupera o valor do atributo cardNumber
   * @return o cardNumber
   */
   public String getCardNumber()
   {
      return cardNumber;
   }
   /**
   * Atribui o novo valor de cardNumber
   * @param cardNumber cardNumber que será atribuído
   */
   public void setCardNumber(String cardNumber)
   {
      this.cardNumber = cardNumber;
   }
   /**
   * Recupera o valor do atributo merchantId
   * @return o merchantId
   */
   public Long getMerchantId()
   {
      return merchantId;
   }
   /**
   * Atribui o novo valor de merchantId
   * @param merchantId merchantId que será atribuído
   */
   public void setMerchantId(Long merchantId)
   {
      this.merchantId = merchantId;
   }
   /**
   * Recupera o valor do atributo amount
   * @return o amount
   */
   public BigDecimal getAmount()
   {
      return amount;
   }
   /**
   * Atribui o novo valor de amount
   * @param amount amount que será atribuído
   */
   public void setAmount(BigDecimal amount)
   {
      this.amount = amount;
   }
   /**
   * Recupera o valor do atributo password
   * @return o password
   */
   public String getPassword()
   {
      return password;
   }
   /**
   * Atribui o novo valor de password
   * @param password password que será atribuído
   */
   public void setPassword(String password)
   {
      this.password = password;
   }
   /**
   * Recupera o valor do atributo transactionType
   * @return o transactionType
   */
   public Integer getTransactionType()
   {
      return transactionType;
   }
   /**
   * Atribui o novo valor de transactionType
   * @param transactionType transactionType que será atribuído
   */
   public void setTransactionType(Integer transactionType)
   {
      this.transactionType = transactionType;
   }
   /**
   * Recupera o valor do atributo parcelNumber
   * @return o parcelNumber
   */
   public Integer getParcelNumber()
   {
      return parcelNumber;
   }
   /**
   * Atribui o novo valor de parcelNumber
   * @param parcelNumber parcelNumber que será atribuído
   */
   public void setParcelNumber(Integer parcelNumber)
   {
      this.parcelNumber = parcelNumber;
   }

}
