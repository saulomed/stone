
package br.com.stone.autorizador.transaction.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.stone.autorizador.transaction.wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TransactionRequestResponse_QNAME = new QName("http://webservice.autorizador.stone.com.br/", "transactionRequestResponse");
    private final static QName _TransactionRequest_QNAME = new QName("http://webservice.autorizador.stone.com.br/", "transactionRequest");
    private final static QName _IOException_QNAME = new QName("http://webservice.autorizador.stone.com.br/", "IOException");
    private final static QName _ConsultaTransacoesResponse_QNAME = new QName("http://webservice.autorizador.stone.com.br/", "consultaTransacoesResponse");
    private final static QName _ConsultaTransacoes_QNAME = new QName("http://webservice.autorizador.stone.com.br/", "consultaTransacoes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.stone.autorizador.transaction.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaTransacoes }
     * 
     */
    public ConsultaTransacoes createConsultaTransacoes() {
        return new ConsultaTransacoes();
    }

    /**
     * Create an instance of {@link TransactionRequestResponse }
     * 
     */
    public TransactionRequestResponse createTransactionRequestResponse() {
        return new TransactionRequestResponse();
    }

    /**
     * Create an instance of {@link TransactionRequest }
     * 
     */
    public TransactionRequest createTransactionRequest() {
        return new TransactionRequest();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link ConsultaTransacoesResponse }
     * 
     */
    public ConsultaTransacoesResponse createConsultaTransacoesResponse() {
        return new ConsultaTransacoesResponse();
    }

    /**
     * Create an instance of {@link ConsultaTransacoesResposta }
     * 
     */
    public ConsultaTransacoesResposta createConsultaTransacoesResposta() {
        return new ConsultaTransacoesResposta();
    }

    /**
     * Create an instance of {@link TransactionResponse }
     * 
     */
    public TransactionResponse createTransactionResponse() {
        return new TransactionResponse();
    }

    /**
     * Create an instance of {@link TransacationViewDTO }
     * 
     */
    public TransacationViewDTO createTransacationViewDTO() {
        return new TransacationViewDTO();
    }

    /**
     * Create an instance of {@link ConsultaTransacoesSolicitacao }
     * 
     */
    public ConsultaTransacoesSolicitacao createConsultaTransacoesSolicitacao() {
        return new ConsultaTransacoesSolicitacao();
    }

    /**
     * Create an instance of {@link TransactionDTORequest }
     * 
     */
    public TransactionDTORequest createTransactionDTORequest() {
        return new TransactionDTORequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.autorizador.stone.com.br/", name = "transactionRequestResponse")
    public JAXBElement<TransactionRequestResponse> createTransactionRequestResponse(TransactionRequestResponse value) {
        return new JAXBElement<TransactionRequestResponse>(_TransactionRequestResponse_QNAME, TransactionRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.autorizador.stone.com.br/", name = "transactionRequest")
    public JAXBElement<TransactionRequest> createTransactionRequest(TransactionRequest value) {
        return new JAXBElement<TransactionRequest>(_TransactionRequest_QNAME, TransactionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.autorizador.stone.com.br/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaTransacoesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.autorizador.stone.com.br/", name = "consultaTransacoesResponse")
    public JAXBElement<ConsultaTransacoesResponse> createConsultaTransacoesResponse(ConsultaTransacoesResponse value) {
        return new JAXBElement<ConsultaTransacoesResponse>(_ConsultaTransacoesResponse_QNAME, ConsultaTransacoesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaTransacoes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.autorizador.stone.com.br/", name = "consultaTransacoes")
    public JAXBElement<ConsultaTransacoes> createConsultaTransacoes(ConsultaTransacoes value) {
        return new JAXBElement<ConsultaTransacoes>(_ConsultaTransacoes_QNAME, ConsultaTransacoes.class, null, value);
    }

}
