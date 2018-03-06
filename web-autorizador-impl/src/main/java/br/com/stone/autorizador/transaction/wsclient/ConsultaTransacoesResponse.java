
package br.com.stone.autorizador.transaction.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultaTransacoesResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaTransacoesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://webservice.autorizador.stone.com.br/}ConsultaTransacoesResposta" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaTransacoesResponse", propOrder = {
    "_return"
})
public class ConsultaTransacoesResponse {

    @XmlElement(name = "return")
    protected ConsultaTransacoesResposta _return;

    /**
     * Obtém o valor da propriedade return.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaTransacoesResposta }
     *     
     */
    public ConsultaTransacoesResposta getReturn() {
        return _return;
    }

    /**
     * Define o valor da propriedade return.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaTransacoesResposta }
     *     
     */
    public void setReturn(ConsultaTransacoesResposta value) {
        this._return = value;
    }

}
