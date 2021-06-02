import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;

public class FormaTest4 {

    @Before//veiksmai pries kiekvien testa
    public void setup(){
        Forma2.setup();//surandawebdriveri
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
        Forma2.insert(499, "", "nuotykiu", "geras aktorius", "garsus rezisierius", 100);
        Assert.assertEquals("Blogai įvesti duomenys redaguojant įrašą", Forma2.getResults());
    }

    @After
    public void close(){
        Forma2.close();
    }

}
