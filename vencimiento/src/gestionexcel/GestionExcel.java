
package gestionexcel;
import Modelo.ModeloExcel;
import formularios.principal2;
import Controlador.ControladorExcel;

/**
 *
 * @author Angelito
 */
public class GestionExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ModeloExcel modeloE = new ModeloExcel();
        principal2 vistaE = new principal2();
        ControladorExcel contraControladorExcel = new ControladorExcel(vistaE, modeloE);
        vistaE.setVisible(true);
        vistaE.setLocationRelativeTo(null);
    }
    
}
