import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;

public class FormaTest1 {

    @Before//veiksmai pries kiekvien testa
    public void setup(){
        Forma.setup();//surandawebdriveri
    }

    //@Test
    //@Order(1)
    //public void searchByKeywordTest(){
    //    Forma.insert("Zoro1", "nuotykiu", "geras aktorius", "garsus rezisierius", 100);

    //}
    @Test
    @Order(1)
    public void getResults(){
        //pirmas parametres expected, antras - actual
        Forma.insert("", "nuotykiu", "geras aktorius", "garsus rezisierius", 100);
        Assert.assertEquals("Duomenų įvedimo klaida", Forma.getResults());
    }

    @After
    public void close(){
        Forma.close();
    }

}
