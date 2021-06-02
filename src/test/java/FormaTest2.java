import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;

public class FormaTest2 {

    @Before//veiksmai pries kiekvien testa
    public void setup(){
        Forma1.setup();//surandawebdriveri
    }


    @Test
    @Order(1)
    public void getResults(){
        //pirmas parametres expected, antras - actual
        Forma1.insert(738);
        Assert.assertEquals("Įrašas ištrintas sėkmingai", Forma1.getResults());
    }

    @After
    public void close(){
        Forma1.close();
    }

}
