package TestDinero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarteraTest {

    @Test
    void testAlCrearCuentaElSaldoEsCero(){
        Cuenta c = new Cuenta();
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testAlIngresar100EnCuentaVaciaElSaldoEs100(){
        Cuenta c = new Cuenta();
        c.ingresar(100);
        assertEquals(100, c.getSaldo());
    }

    @Test
    void testAlIngresar3000EnCuentaVaciaElSaldoEs3000(){
        Cuenta c = new Cuenta();
        c.ingresar(3000);
        assertEquals(3000, c.getSaldo());
    }

    @Test
    void testAlIngresar3000EnCuentaCon100ElSaldoEs3100(){
        //Arrange
        Cuenta c = new Cuenta();
        c.ingresar(100);
        //Act
        c.ingresar(3000);
        //Assert
        assertEquals(3100, c.getSaldo());
    }

    @Test
    void testAlIngresarNegativoSaldoSigueSiendo0(){
        Cuenta c = new Cuenta();
        c.ingresar(-100);
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testAlIngresarDecimalesSumen(){
        Cuenta c = new Cuenta();
        c.ingresar(100.45);
        assertEquals(100.45, c.getSaldo());
    }

    @Test
    void testAlIngresar6000EnCuentaVaciaSaldoEs6000(){
        Cuenta c = new Cuenta();
        c.ingresar(6000.0);
        assertEquals(6000.0, c.getSaldo());
    }

    @Test
    void testAlIngresar6000y1CentEnCuentaVaciaSaldoEs0(){
        Cuenta c = new Cuenta();
        c.ingresar(6000.01);
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testAlTransferir100DeUnaCuentaCon500AUnaCon50SeRestaYSumaRespectivamente(){
        //Arrange
        Cuenta c1 = new Cuenta();
        c1.ingresar(500);
        Cuenta c2 = new Cuenta();
        c2.ingresar(50);
        //Act
        c1.transferir(c2, 100);
        //Assert
        assertEquals(400, c1.getSaldo());
        assertEquals(150, c2.getSaldo());
    }

    @Test
    void testNoSePuedenTransferirCantidadesNegativas(){
        //Arrange
        Cuenta c1 = new Cuenta();
        c1.ingresar(500);
        Cuenta c2 = new Cuenta();
        c2.ingresar(50);
        //Act
        c1.transferir(c2, -100);
        //Assert
        assertEquals(500, c1.getSaldo());
        assertEquals(50, c2.getSaldo());
    }

    @Test
    void testCantidadMaximaTransferencia3000(){
        //Arrange
        Cuenta c1 = new Cuenta();
        c1.ingresar(3500);
        Cuenta c2 = new Cuenta();
        c2.ingresar(50);
        //Act
        c1.transferir(c2, 3000);
        //Assert
        assertEquals(500, c1.getSaldo());
        assertEquals(3050, c2.getSaldo());
    }

    @Test
    void testAlTransferirMasDe3000ElSaldoNoCambia(){
        //Arrange
        Cuenta c1 = new Cuenta();
        c1.ingresar(3500);
        Cuenta c2 = new Cuenta();
        c2.ingresar(50);
        //Act
        c1.transferir(c2, 3000.01);
        //Assert
        assertEquals(3500, c1.getSaldo());
        assertEquals(50, c2.getSaldo());
    }
}
