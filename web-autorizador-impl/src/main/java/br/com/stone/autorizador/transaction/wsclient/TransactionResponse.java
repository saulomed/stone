
package br.com.stone.autorizador.transaction.wsclient;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TransactionResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TransactionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionType" type="{http://webservice.autorizador.stone.com.br/}transactionType" minOccurs="0"/>
 *         &lt;element name="parcelNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="reponseCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionResponse", propOrder = {
    "cardNumber",
    "merchantId",
    "amount",
    "password",
    "transactionType",
    "parcelNumber",
    "reponseCode"
})
public class TransactionResponse {

    protected String cardNumber;
    protected Long merchantId;
    protected BigDecimal amount;
    protected String password;
    @XmlSchemaType(name = "string")
    protected TransactionType transactionType;
    protected Integer parcelNumber;
    protected int reponseCode;

    /**
     * Obtém o valor da propriedade cardNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Define o valor da propriedade cardNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Obtém o valor da propriedade merchantId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * Define o valor da propriedade merchantId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMerchantId(Long value) {
        this.merchantId = value;
    }

    /**
     * Obtém o valor da propriedade amount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Define o valor da propriedade amount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Obtém o valor da propriedade password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define o valor da propriedade password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtém o valor da propriedade transactionType.
     * 
     * @return
     *     possible object is
     *     {@link TransactionType }
     *     
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Define o valor da propriedade transactionType.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *     
     */
    public void setTransactionType(TransactionType value) {
        this.transactionType = value;
    }

    /**
     * Obtém o valor da propriedade parcelNumber.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getParcelNumber() {
        return parcelNumber;
    }

    /**
     * Define o valor da propriedade parcelNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setParcelNumber(Integer value) {
        this.parcelNumber = value;
    }

    /**
     * Obtém o valor da propriedade reponseCode.
     * 
     */
    public int getReponseCode() {
        return reponseCode;
    }

    /**
     * Define o valor da propriedade reponseCode.
     * 
     */
    public void setReponseCode(int value) {
        this.reponseCode = value;
    }

}
