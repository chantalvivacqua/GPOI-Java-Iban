import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class testIBAN {
    private IBAN iban;

    @Before
    public void init(){
        iban = new IBAN();
    }

    @Test
    public void testverificaibanValido(){
        iban.setIban("IT39S0300203280758493646878");
        assertTrue(iban.verificaIban());
    }

    @Test
    public void testverificaibanNonValido(){
        iban.setIban("IT39S0300203280758493646874");
        assertFalse(iban.verificaIban());  
      }

      
    @Test
    public void testverificalunghezzaibanNonValida(){
        iban.setIban("IT39S03002032807555558493646874");
        assertFalse(iban.verificaIban());  
      }

      
    @Test
    public void testverificaibanVuoto(){
        iban.setIban("");
      assertThrows(NullPointerException.class, () -> {
        iban.verificaIban();
      });

    }
}