/*
* Criação : 28 de jan de 2018
*/
package br.com.stone.autorizador.infra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.Before;
import br.com.stone.autorizador.card.dto.CardDTO;
import br.com.stone.autorizador.card.enums.CardBrand;
import br.com.stone.autorizador.card.enums.CardType;
import br.com.stone.autorizador.merchant.dto.MerchantDTO;

public class AbstractTest
{

   private Context context;

   @Before
   public void inicializaTeste() throws Exception
   {
      Properties p = new Properties();
      p.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.core.LocalInitialContextFactory");
      p.put("openejb.deployments.classpath.ear", "true");
      // p.put("openejb.jndiname.format", "{ejbName}/{interfaceClass}");
      // p.put("openejb.descriptors.output", "true");
      // p.put("openejb.validation.output.level", "verbose");
      // p.put("openejb.webservices.enabled", "true");

      p.put("StoneDS", "new://Resource?type=DataSource");
      p.put("StoneDS.JdbcDriver", "org.hsqldb.jdbcDriver");
      p.put("StoneDS.JdbcUrl", "jdbc:hsqldb:mem:stonetest");
      p.put("openejb.embedded.remotable", "true");


      // p.put("subidorLogUnmanagedDS", "new://Resource?type=DataSource");
      // p.put("subidorLogUnmanagedDS.JdbcDriver", "org.hsqldb.jdbcDriver");
      // p.put("subidorLogUnmanagedDS.JdbcUrl", "jdbc:hsqldb:mem:appdb");
      // p.put("subidorLogUnmanagedDS.JtaManaged", "false");

      setContext(new InitialContext(p));

      // DataSource dataSource = (DataSource) context.lookup("java:/openejb/Resource/avenueCodeDS");
      // System.out.println("*************************LISTA DE EJBS******************");
      // NamingEnumeration<Binding> list = context.listBindings("java:openejb/");
      // while (list.hasMore())
      // {
      // Binding item = list.next();
      // System.out.println(item.getClassName() + " :: " + "java:openejb/" + item.getName());
      // }

   }

   public Context getContext()
   {
      return context;
   }

   public void setContext(Context context)
   {
      this.context = context;
   }

   /**
    * Metodo responsável por criar um cartão padrão para utilização nos testes
    * 
    * @return
    * @throws ParseException
    */
   protected CardDTO createCardDefault() throws ParseException
   {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      CardDTO card = new CardDTO();
      card.setHolderName("SAULO SANTOS");
      card.setNumber("12345678912345");
      card.setExpirationDate(sdf.parse("30/12/2018"));
      card.setCardBrand(CardBrand.VISA);
      card.setPassword("123987");
      card.setType(CardType.MAGNETIC);
      card.setHasPassword(true);
      return card;
   }

   /**
    * Metodo responsável por criar um cartão padrão para utilização nos testes
    * 
    * @return
    * @throws ParseException
    */
   protected CardDTO createCardTransactionFault() throws ParseException
   {
      CardDTO card = createCardDefault();
      card.setNumber("12345678912346");
      return card;
   }

   /**
    * Metodo responsável por criar um cartão padrão para utilização nos testes
    * 
    * @return
    * @throws ParseException
    */
   protected CardDTO createCardNoBalance() throws ParseException
   {
      CardDTO card = createCardDefault();
      card.setNumber("12345678912347");

      return card;
   }

   protected MerchantDTO createMechantDefault()
   {
      MerchantDTO dto = new MerchantDTO();
      dto.setName("ESTABELECIMENTO TESTE");
      return dto;
   }

}