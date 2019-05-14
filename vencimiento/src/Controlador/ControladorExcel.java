
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import formularios.principal2;
import Modelo.ModeloExcel;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Angelito
 */
public class ControladorExcel implements ActionListener{
    ModeloExcel modeloE = new ModeloExcel();
    principal2 vistaE= new principal2();
    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    int contAccion=0;
    
    public ControladorExcel(principal2 vistaE, ModeloExcel modeloE){
        this.vistaE= vistaE;
        this.modeloE=modeloE;
        this.vistaE.btnExportar.addActionListener(this);
    }
    
    public void AgregarFiltro(){
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        contAccion++;
        if(contAccion==1)AgregarFiltro();
        
    
        if(e.getSource() == vistaE.btnExportar){
            if(selecArchivo.showDialog(null, "Exportar")==JFileChooser.APPROVE_OPTION){
                archivo=selecArchivo.getSelectedFile();
                
                if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")){
                    JOptionPane.showMessageDialog(null, modeloE.Exportar(archivo, vistaE.jtDatos) + "\n Formato ."+ archivo.getName().substring(archivo.getName().lastIndexOf(".")+1));
                }else{
                    JOptionPane.showMessageDialog(null, "INGRESE EL FORMATO .xlsx DESPUES DEL NOMBRE.");
                }
            }
        }
    }
    
}
