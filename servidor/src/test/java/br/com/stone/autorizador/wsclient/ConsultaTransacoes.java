
package br.com.stone.autorizador.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultaTransacoes complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaTransacoes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://webservice.autorizador.stone.com.br/}ConsultaTransacoesSolicitacao" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaTransacoes", propOrder = {
    "arg0"
})
public class ConsultaTransacoes {

    protected ConsultaTransacoesSolicitacao arg0;

    /**
     * Obtém o valor da propriedade arg0.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaTransacoesSolicitacao }
     *     
     */
    public ConsultaTransacoesSolicitacao getArg0() {
        return arg0;
    }

    /**
     * Define o valor da propriedade arg0.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaTransacoesSolicitacao }
     *     
     */
    public void setArg0(ConsultaTransacoesSolicitacao value) {
        this.arg0 = value;
    }

}
