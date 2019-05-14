
package formularios;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import base_datos.mysql;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumnModel;
import java.io.File;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.table.TableColumn;


/**
 *
 * @author Angelito
 */
public class principal2 extends javax.swing.JFrame {

    DefaultTableModel model;  //atributo
    mysql con;
    Statement sent;
    ResultSet rs;
   String id;
   String mes2;
   double total=0;
   Boolean actu = true;
    public principal2() {
        
        this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        try{
        setIconImage(new ImageIcon(getClass().getResource("../imagenes/logo angel31.png")).getImage());
        } catch (Exception ex) {}
        inhabilitar();
        bloquearguardar();
        bloquearmodificar();
        bloquearactualizar();
        bloqueareliminar();
   
           
        
    jtDatos.setOpaque(false);
((DefaultTableCellRenderer)jtDatos.getDefaultRenderer(Object.class)).setOpaque(false);

jScrollPane2.setOpaque(false);
jScrollPane2.getViewport().setOpaque(false);

}
    

String detectarmes(String mes){
    String indice="";
    if(mes=="ENERO"){indice="01";}
    if(mes=="FEBRERO"){indice="02";}
    if(mes=="MARZO"){indice="03";}
    if(mes=="ABRIL"){indice="04";}
    if(mes=="MAYO"){indice="05";}
    if(mes=="JUNIO"){indice="06";}
    if(mes=="JULIO"){indice="07";}
    if(mes=="AGOSTO"){indice="08";}
    if(mes=="SEPTIEMBRE"){indice="09";}
    if(mes=="OCTUBRE"){indice="10";}
    if(mes=="NOVIEMBRE"){indice="11";}
    if(mes=="DICIEMBRE"){indice="12";}
    return indice;
}
    
void vencimiento(String sql){
try{
    try {con = new mysql();} catch (Exception ex) {}
  rs = con.Consulta(sql);

//Para establecer el modelo al JTable
 DefaultTableModel modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int rowIndex, int vColIndex) {
                    return false;
                }};
                this.jtDatos.setModel(modelo);

modelo.addColumn("ID");
modelo.addColumn("NOMBRE");
modelo.addColumn("CASA");
modelo.addColumn("MES");
modelo.addColumn("AÑO");
modelo.addColumn("PROVEEDOR");
modelo.addColumn("POLITICA");
TableColumn columna = jtDatos.getColumn("ID");
columna.setMaxWidth(50);
TableColumn columna1 = jtDatos.getColumn("NOMBRE");
columna1.setMaxWidth(600);
TableColumn columna2 = jtDatos.getColumn("CASA");
columna2.setMaxWidth(200);
TableColumn columna3 = jtDatos.getColumn("MES");
columna3.setMaxWidth(120);
TableColumn columna4 = jtDatos.getColumn("AÑO");
columna4.setMaxWidth(100);
TableColumn columna5 = jtDatos.getColumn("PROVEEDOR");
columna5.setMaxWidth(200);
TableColumn columna6 = jtDatos.getColumn("POLITICA");
columna6.setMaxWidth(100);

                while (rs.next()) {
                    Object[] fila = new Object[7];

                    for (int i = 0; i < 7; i++) {

                        fila[i]=rs.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERROR DE CONECCION CON BASE DE DATOS");
            }
}
    
void bloqueareliminar(){
    btneliminar.setEnabled(false);
}    

void bloquearguardar(){
        btnguardar.setEnabled(false);
    }

void bloquearactualizar(){
    btnactualizar.setEnabled(false);
}

void bloquearnuevo(){
    btnnuevo.setEnabled(false);
}

void bloquearmodificar(){
    btnmodificar.setEnabled(false);
}



void habilitareliminar(){
    btneliminar.setEnabled(true);
}


void habilitarmodificar(){
    btnmodificar.setEnabled(true);
}

void habilitarguardar(){
    btnguardar.setEnabled(true);
}

void habilitaractualizar(){
    btnactualizar.setEnabled(true);
}

void habilitarnuevo(){
    btnnuevo.setEnabled(true);
}

void limpiar(){
        txtcasa.setText("");
        jTyyyy.setText("");
        txtpolitica.setText("");
        txtproveedor.setText("");
        txtnombre.setText("");
        txtcasa.setBackground(Color.WHITE);
        jTyyyy.setBackground(Color.WHITE);
        txtpolitica.setBackground(Color.WHITE);
        txtproveedor.setBackground(Color.WHITE);
        txtnombre.setBackground(Color.WHITE);
        boxmes.setBackground(Color.WHITE);
        
    }
    
void bloquear(){
       txtcasa.setEnabled(false);
       txtpolitica.setEnabled(false);
       txtproveedor.setEnabled(false);
       jTyyyy.setEnabled(false);
       boxmes.setEnabled(false);
       txtnombre.setEnabled(false); 
    }
    
void inhabilitar()
    {
       txtcasa.setEnabled(false);
       txtpolitica.setEnabled(false);
       txtproveedor.setEnabled(false);
       jTyyyy.setEnabled(false); 
       txtnombre.setEnabled(false);
       boxmes.setEnabled(false);
       txtcasa.setText("");
       txtpolitica.setText("");
       jTyyyy.setText("");
       txtnombre.setText("");
       txtproveedor.setText("");
       
    }
void habilitar()
   {
       txtcasa.setEnabled(true);
       txtpolitica.setEnabled(true);
       txtproveedor.setEnabled(true);
       boxmes.setEnabled(true);
       jTyyyy.setEnabled(true);
       txtnombre.setEnabled(true);
       txtnombre.requestFocus();
    
   }
     
     
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        editable = new javax.swing.JMenuItem();
        lblcodproveedor = new javax.swing.JLabel();
        lblproveedor = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtcasa = new javax.swing.JTextField();
        jTyyyy = new javax.swing.JTextField();
        txtpolitica = new javax.swing.JTextField();
        txtproveedor = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        lbltelefono1 = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();
        txtbuscarproducto = new javax.swing.JTextField();
        lbldireccion1 = new javax.swing.JLabel();
        lbldireccion2 = new javax.swing.JLabel();
        lbldireccion3 = new javax.swing.JLabel();
        lbldireccion4 = new javax.swing.JLabel();
        btnvencimiento = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        btninventario = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        btnpoliticas = new javax.swing.JButton();
        boxfecha = new javax.swing.JComboBox();
        boxmes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        editable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras1.jpg"))); // NOI18N
        editable.setText("Modificar");
        editable.setToolTipText("");
        editable.setComponentPopupMenu(jtDatos.getComponentPopupMenu());
        editable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        editable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editableActionPerformed(evt);
            }
        });
        jPopupMenu1.add(editable);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblcodproveedor.setBackground(new java.awt.Color(0, 0, 0));
        lblcodproveedor.setFont(new java.awt.Font("Arista", 1, 24)); // NOI18N
        lblcodproveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblcodproveedor.setText("Nombre:");
        getContentPane().add(lblcodproveedor);
        lblcodproveedor.setBounds(250, 80, 90, 30);

        lblproveedor.setFont(new java.awt.Font("Arista", 1, 24)); // NOI18N
        lblproveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblproveedor.setText("Casa:");
        getContentPane().add(lblproveedor);
        lblproveedor.setBounds(890, 90, 60, 30);

        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtnombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombreKeyPressed(evt);
            }
        });
        getContentPane().add(txtnombre);
        txtnombre.setBounds(350, 80, 490, 30);

        txtcasa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtcasa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtcasa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcasaKeyPressed(evt);
            }
        });
        getContentPane().add(txtcasa);
        txtcasa.setBounds(960, 90, 150, 30);

        jTyyyy.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTyyyy.setBorder(null);
        jTyyyy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTyyyyKeyPressed(evt);
            }
        });
        getContentPane().add(jTyyyy);
        jTyyyy.setBounds(500, 150, 59, 30);

        txtpolitica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtpolitica.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpolitica.setBorder(null);
        txtpolitica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpoliticaKeyPressed(evt);
            }
        });
        getContentPane().add(txtpolitica);
        txtpolitica.setBounds(680, 150, 90, 30);

        txtproveedor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtproveedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtproveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtproveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtproveedorKeyPressed(evt);
            }
        });
        getContentPane().add(txtproveedor);
        txtproveedor.setBounds(960, 150, 150, 30);

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453895816_plus_16.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        btnnuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnnuevo.setBorderPainted(false);
        btnnuevo.setContentAreaFilled(false);
        btnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnnuevo.setDefaultCapable(false);
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453895822_plus_16.png"))); // NOI18N
        btnnuevo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453895822_plus_16.png"))); // NOI18N
        btnnuevo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        btnnuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnnuevoKeyPressed(evt);
            }
        });
        getContentPane().add(btnnuevo);
        btnnuevo.setBounds(1260, 20, 60, 90);
        btnnuevo.getAccessibleContext().setAccessibleDescription("");

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453895921_block_16.png"))); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.setBorder(null);
        btncancelar.setBorderPainted(false);
        btncancelar.setContentAreaFilled(false);
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btncancelar.setDefaultCapable(false);
        btncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453895927_block_16.png"))); // NOI18N
        btncancelar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453895927_block_16.png"))); // NOI18N
        btncancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        btncancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btncancelarKeyPressed(evt);
            }
        });
        getContentPane().add(btncancelar);
        btncancelar.setBounds(1260, 110, 65, 83);

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453895842_save_16.png"))); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.setBorder(null);
        btnguardar.setBorderPainted(false);
        btnguardar.setContentAreaFilled(false);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453895851_save_16.png"))); // NOI18N
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        btnguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarKeyPressed(evt);
            }
        });
        getContentPane().add(btnguardar);
        btnguardar.setBounds(1260, 200, 70, 83);

        jLabel2.setFont(new java.awt.Font("Arista", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Busqueda de registros");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 570, 260, 30);

        btnactualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnactualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnactualizar.setText("ACTUALIZAR");
        btnactualizar.setBorder(null);
        btnactualizar.setBorderPainted(false);
        btnactualizar.setContentAreaFilled(false);
        btnactualizar.setDefaultCapable(false);
        btnactualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnactualizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar2.png"))); // NOI18N
        btnactualizar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnactualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        btnactualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnactualizarKeyPressed(evt);
            }
        });
        getContentPane().add(btnactualizar);
        btnactualizar.setBounds(1160, 110, 80, 85);

        btnmodificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnmodificar.setForeground(new java.awt.Color(255, 255, 255));
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453896017_gear_16.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.setToolTipText("");
        btnmodificar.setBorder(null);
        btnmodificar.setBorderPainted(false);
        btnmodificar.setContentAreaFilled(false);
        btnmodificar.setDefaultCapable(false);
        btnmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnmodificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453896022_gear_16.png"))); // NOI18N
        btnmodificar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnmodificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        btnmodificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnmodificarKeyPressed(evt);
            }
        });
        getContentPane().add(btnmodificar);
        btnmodificar.setBounds(1160, 20, 80, 90);

        lbltelefono1.setFont(new java.awt.Font("Arista", 1, 24)); // NOI18N
        lbltelefono1.setForeground(new java.awt.Color(255, 255, 255));
        lbltelefono1.setText("proveedor:");
        getContentPane().add(lbltelefono1);
        lbltelefono1.setBounds(835, 150, 119, 30);

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453895864_delete_16.png"))); // NOI18N
        btneliminar.setText("ELIMINAR");
        btneliminar.setBorder(null);
        btneliminar.setBorderPainted(false);
        btneliminar.setContentAreaFilled(false);
        btneliminar.setDefaultCapable(false);
        btneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1453895868_delete_16.png"))); // NOI18N
        btneliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar);
        btneliminar.setBounds(1170, 200, 65, 80);

        txtbuscarproducto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtbuscarproducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtbuscarproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarproductoKeyPressed(evt);
            }
        });
        getContentPane().add(txtbuscarproducto);
        txtbuscarproducto.setBounds(360, 600, 250, 30);

        lbldireccion1.setFont(new java.awt.Font("Arista", 1, 24)); // NOI18N
        lbldireccion1.setForeground(new java.awt.Color(255, 255, 255));
        lbldireccion1.setText("politica:");
        getContentPane().add(lbldireccion1);
        lbldireccion1.setBounds(580, 150, 100, 30);

        lbldireccion2.setFont(new java.awt.Font("Arista", 1, 24)); // NOI18N
        lbldireccion2.setForeground(new java.awt.Color(255, 255, 255));
        lbldireccion2.setText("Caducidad:");
        getContentPane().add(lbldireccion2);
        lbldireccion2.setBounds(250, 150, 120, 30);

        lbldireccion3.setFont(new java.awt.Font("Arista", 1, 24)); // NOI18N
        lbldireccion3.setForeground(new java.awt.Color(255, 255, 255));
        lbldireccion3.setText("AÑO");
        getContentPane().add(lbldireccion3);
        lbldireccion3.setBounds(510, 120, 40, 30);

        lbldireccion4.setFont(new java.awt.Font("Arista", 0, 24)); // NOI18N
        lbldireccion4.setForeground(new java.awt.Color(255, 255, 255));
        lbldireccion4.setText("MES");
        getContentPane().add(lbldireccion4);
        lbldireccion4.setBounds(410, 120, 40, 30);

        btnvencimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnvencimiento.setForeground(new java.awt.Color(255, 255, 255));
        btnvencimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vencimiento1.png"))); // NOI18N
        btnvencimiento.setText("VENCIMIENTO");
        btnvencimiento.setBorder(null);
        btnvencimiento.setBorderPainted(false);
        btnvencimiento.setContentAreaFilled(false);
        btnvencimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnvencimiento.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vencimiento2.png"))); // NOI18N
        btnvencimiento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnvencimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvencimientoActionPerformed(evt);
            }
        });
        getContentPane().add(btnvencimiento);
        btnvencimiento.setBounds(830, 550, 90, 90);

        btnExportar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExportar.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exportar1.png"))); // NOI18N
        btnExportar.setText("EXPORTAR");
        btnExportar.setBorder(null);
        btnExportar.setBorderPainted(false);
        btnExportar.setContentAreaFilled(false);
        btnExportar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExportar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exportar2.png"))); // NOI18N
        btnExportar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnExportar);
        btnExportar.setBounds(970, 560, 67, 80);

        jLabel1.setFont(new java.awt.Font("Arista", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reg.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(470, 0, 630, 290);

        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        jtDatos.setAutoCreateRowSorter(true);
        jtDatos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtDatos.setForeground(new java.awt.Color(255, 255, 255));
        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtDatos.setGridColor(new java.awt.Color(0, 0, 0));
        jtDatos.setSelectionBackground(new java.awt.Color(0, 0, 255));
        jtDatos.getTableHeader().setReorderingAllowed(false);
        jtDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtDatos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(90, 240, 1000, 310);

        btninventario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btninventario.setForeground(new java.awt.Color(255, 255, 255));
        btninventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/invetario.png"))); // NOI18N
        btninventario.setText("INVENTARIO");
        btninventario.setBorder(null);
        btninventario.setBorderPainted(false);
        btninventario.setContentAreaFilled(false);
        btninventario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btninventario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inventario2.png"))); // NOI18N
        btninventario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btninventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninventarioActionPerformed(evt);
            }
        });
        getContentPane().add(btninventario);
        btninventario.setBounds(730, 560, 80, 85);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo angel4.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(390, 200, 500, 290);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar2.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(290, 580, 60, 70);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("by: Angel Torre");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1170, 660, 110, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("angeltorrelopez@hotmail.com");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1130, 680, 190, 20);

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/apagar.png"))); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.setBorder(null);
        btnsalir.setBorderPainted(false);
        btnsalir.setContentAreaFilled(false);
        btnsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/apagar1.png"))); // NOI18N
        btnsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir);
        btnsalir.setBounds(90, 60, 60, 80);

        btnpoliticas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnpoliticas.setForeground(new java.awt.Color(255, 255, 255));
        btnpoliticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LIBRO1.png"))); // NOI18N
        btnpoliticas.setText("POLITICAS");
        btnpoliticas.setBorder(null);
        btnpoliticas.setBorderPainted(false);
        btnpoliticas.setContentAreaFilled(false);
        btnpoliticas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnpoliticas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LIBRO2.png"))); // NOI18N
        btnpoliticas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnpoliticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpoliticasActionPerformed(evt);
            }
        });
        getContentPane().add(btnpoliticas);
        btnpoliticas.setBounds(110, 570, 70, 90);

        boxfecha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "POR FECHA", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        boxfecha.setPreferredSize(new java.awt.Dimension(150, 20));
        boxfecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxfechaItemStateChanged(evt);
            }
        });
        getContentPane().add(boxfecha);
        boxfecha.setBounds(830, 650, 110, 20);

        boxmes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boxmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        boxmes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boxmesKeyPressed(evt);
            }
        });
        getContentPane().add(boxmes);
        boxmes.setBounds(380, 160, 103, 21);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/25E2.jpg"))); // NOI18N
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, -10, 1400, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
     
      limpiar();
      habilitar();
      habilitarguardar();
      bloquearactualizar();
      bloquearmodificar();
      bloqueareliminar();
      
       txtnombre.setBackground(Color.CYAN);
      GregorianCalendar objFecha=new GregorianCalendar();
        int añ;
        añ=objFecha.get(Calendar.YEAR);
        String texto = Integer.toString(añ);
        
      jTyyyy.setText(texto);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
      inhabilitar();
      habilitarnuevo();
      bloquearguardar();
      bloquearactualizar();
      bloquearmodificar();
      bloqueareliminar();
      btnnuevo.requestFocus();
      txtnombre.setBackground(Color.WHITE);
      txtcasa.setBackground(Color.WHITE);
      jTyyyy.setBackground(Color.WHITE);
      txtpolitica.setBackground(Color.WHITE);
      txtproveedor.setBackground(Color.WHITE);
      this.boxfecha.setSelectedItem("POR FECHA");
      jtDatos.setModel(new DefaultTableModel());
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
if (txtnombre.getText().equals("")||jTyyyy.getText().equals("")||txtcasa.getText().equals("")
                ||txtpolitica.getText().equals("")||txtproveedor.getText().equals(""))
        {JOptionPane.showMessageDialog(null, "Faltan Datos: No Puede Dejar Cuadros en Blanco");}
else{try{
            try{con = new mysql();
     }catch(Exception ex){JOptionPane.showMessageDialog(null, "Error: ");}
      
//se obtienen los valores de los jTextField
     String indice;
     String nombre = txtnombre.getText();
     String casa = txtcasa.getText();
     String mes=boxmes.getSelectedItem().toString();
     indice=detectarmes(mes);
     String año = jTyyyy.getText();
     String proveedor = txtproveedor.getText();
     String politica = txtpolitica.getText();
     String caducidad = jTyyyy.getText()+"-"+indice+"-01";
                
//sentencias sql para insertar los datos en la base de datos
     String sql = "INSERT INTO `ingreso`(`Nombre`, `Casa`, `Mes`, `Año`, `Proveedor`, "
             + "`Politica`, `Caducidad`, `Meses`) VALUES ('"+nombre+"','"+casa+"','"+indice+"','"
             + ""+año+"','"+proveedor+"','"+politica+"','"+caducidad+"','"+mes+"')";         
       
//funcion para ejecutar la query
     con.ejecutar(sql);
     JOptionPane.showMessageDialog(null, "Producto: "+nombre+" agregado.");
               
//se limpian los campos de texto para seguir agregando mas datos
     limpiar();
                
}catch(Exception ex){JOptionPane.showMessageDialog(null, "Producto no agregado.");}
        
    inhabilitar();
    limpiar();
    bloquearguardar();
    bloquearactualizar();
    bloquearmodificar();
    bloqueareliminar();
    btnnuevo.requestFocus();
    }//GEN-LAST:event_btnguardarActionPerformed
}
    private void txtbuscarproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarproductoKeyPressed
      
    String prod= txtbuscarproducto.getText();
    String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, "
            + "`Politica` FROM ingreso WHERE (Nombre LIKE '%"+prod+"%') OR "
            + "(Casa LIKE '%"+prod+"%') OR (Meses LIKE '%"+prod+"%') OR "
            + "(Proveedor LIKE '%"+prod+"%')";
vencimiento(sql);
 
    }//GEN-LAST:event_txtbuscarproductoKeyPressed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
       
//BOTON PARA MODIFICAR LOS DATOS DE UN PRODUCTOS EN LA BASE DE DATOS

// validaciones para saber que no se deja algun campo en blanco
    if (txtcasa.getText().equals("")||jTyyyy.getText().equals("")||txtpolitica.getText().equals("")
      ||txtproveedor.getText().equals("")||txtproveedor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Faltan Datos: No Puede Dejar Cuadros en Blanco");}
    else{
//por si se da clic antes de hacer la busqueda
//se validan los textfield
    String indice;
    String casa = txtcasa.getText();
    String mes=boxmes.getSelectedItem().toString();
    indice=detectarmes(mes);
    String año = jTyyyy.getText();
    String politica = txtpolitica.getText();
    String proveedor = txtproveedor.getText();
    String nombre = txtnombre.getText();
    String caducidad = jTyyyy.getText()+"-"+indice+"-01";

    try {
//se crea la conexion y las consultas
        con = new mysql();
               
        int id2 = Integer.parseInt(id);
// se crea la sentecia sql y se ejecuta para hacer la modificacion
        String modifica = "UPDATE `ingreso` SET `Nombre`='"+nombre+"',`Casa`='"+casa+"',"
                + "`Mes`='"+indice+"',`Año`='"+año+"',`Proveedor`='"+proveedor+"',"
                + "`Politica`='"+politica+"',`Caducidad`='"+caducidad+"',`"
                + "Meses`='"+mes+"' WHERE Id = '"+id2+"'";
        con.ejecutar(modifica);
        JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
} catch (Exception ex) {}
}//end if
    inhabilitar();
    limpiar();
    bloqueareliminar();
    bloquearmodificar();
    bloquearactualizar();
    habilitarnuevo();
    actu=true;
    btnnuevo.requestFocus();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void editableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editableActionPerformed
    habilitar();
    }//GEN-LAST:event_editableActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
    habilitar();
    habilitaractualizar();
    bloquearguardar();
    bloquearnuevo();
    bloqueareliminar();
    txtnombre.setBackground(Color.CYAN);
    GregorianCalendar objFecha=new GregorianCalendar();
    int añ=objFecha.get(Calendar.YEAR);
    String texto = Integer.toString(añ);
    jTyyyy.setText(texto);
    actu = false;
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
//BOTON PARA ELIMINAR LOS DATOS DE UN PRODUCTOS EN LA BASE DE DATOS
    int fila = jtDatos.getSelectedRow();

try {
//se crea la conexion y las consultas
    con = new mysql();
    
// se crea la sentecia sql y se ejecuta para hacer la Eliminacion
    String eliminar = "DELETE FROM ingreso WHERE Id="+jtDatos.getValueAt(fila, 0);
    con.ejecutar(eliminar);
    JOptionPane.showMessageDialog(null, "Datos Eliminados");
    } catch (Exception ex) {JOptionPane.showMessageDialog(null, "No Eliminado");}

    inhabilitar();
    bloqueareliminar();
    bloquearmodificar();
   
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnvencimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvencimientoActionPerformed
try {
    
    GregorianCalendar objFecha=new GregorianCalendar();
    int añ=objFecha.get(Calendar.YEAR);
    String año = Integer.toString(añ);
    
    int me=objFecha.get(Calendar.MONTH);
    String mes = Integer.toString(me);
// se comienza la conexion con la base de datos
     try {con = new mysql();} catch (Exception ex) {}

    String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
    + "WHERE DATE(Caducidad) = DATE(NOW()) OR DATEDIFF(Caducidad,NOW()) <= (Politica*30)";
    rs = con.Consulta(sql);

//Para establecer el modelo al JTable
    DefaultTableModel modelo = new DefaultTableModel(){
    @Override
    public boolean isCellEditable(int rowIndex, int vColIndex) {
        return false;
        }};
    this.jtDatos.setModel(modelo);

//Obteniendo la informacion de las columnas que estan siendo consultadas
    ResultSetMetaData rsMd = rs.getMetaData();
//La cantidad de columnas que tiene la consulta
    int cantidadColumnas = rsMd.getColumnCount();
//Establecer como cabezeras el nombre de las colimnas
    for (int i = 1; i <= cantidadColumnas; i++) {
          modelo.addColumn(rsMd.getColumnLabel(i));}

            while (rs.next()) {
              Object[] fila = new Object[7];

              for (int i = 0; i < 7; i++) {
                  fila[i]=rs.getObject(i+1);}
                    modelo.addRow(fila);
                }

} catch (Exception ex) { JOptionPane.showMessageDialog(null, "ERROR DE CONECCION CON BASE DE DATOS");}
    }//GEN-LAST:event_btnvencimientoActionPerformed

    private void btninventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninventarioActionPerformed

    String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM ingreso";
  vencimiento(sql);
    }//GEN-LAST:event_btninventarioActionPerformed

    private void jtDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDatosMouseClicked
    int Opcion=this.jtDatos.getSelectedRow();
//muestra el no. de renglon
    id =  jtDatos.getValueAt(Opcion,0).toString();
    this.txtnombre.setText(this.jtDatos.getValueAt(Opcion, 1).toString());
    this.txtcasa.setText(this.jtDatos.getValueAt(Opcion, 2).toString());
    String mes=(this.jtDatos.getValueAt(Opcion, 3).toString());
    this.boxmes.setSelectedItem(mes);
    this.jTyyyy.setText(this.jtDatos.getValueAt(Opcion, 4).toString());
    this.txtproveedor.setText(this.jtDatos.getValueAt(Opcion, 5).toString());
    this.txtpolitica.setText(this.jtDatos.getValueAt(Opcion, 6).toString());
       
    bloquear();
    habilitarmodificar();
    habilitareliminar();
    bloquearguardar();
    bloquearactualizar();
    btnmodificar.requestFocus();
    }//GEN-LAST:event_jtDatosMouseClicked

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
    System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnpoliticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpoliticasActionPerformed
try {
    File path = new File ("C:\\Users\\ANGELITO\\OneDrive\\vencidos\\POLITICA DE VENCIDOS POR CASA COMERCIAL.xlsx");
    Desktop.getDesktop().open(path);
}catch (IOException ex) {ex.printStackTrace();}
    }//GEN-LAST:event_btnpoliticasActionPerformed

    private void boxfechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxfechaItemStateChanged
    String fecha=boxfecha.getSelectedItem().toString();
    GregorianCalendar objFecha=new GregorianCalendar();
    int añ=objFecha.get(Calendar.YEAR);
    String texto = Integer.toString(añ);  
    int añ2=añ+1;
    String tex = Integer.toString(añ2);
        
if(fecha == "ENERO"){         
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=01) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=02) && (Politica=1))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=03) && (Politica=2)) OR ((Año LIKE '%"+texto+"%') && (Mes=04) && (Politica=3))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=05) && (Politica=4)) OR ((Año LIKE '%"+texto+"%') && (Mes=06) && (Politica=5))";
vencimiento(sql);}
        
if(fecha == "FEBRERO"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=02) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=03) && (Politica=1))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=04) && (Politica=2)) OR ((Año LIKE '%"+texto+"%') && (Mes=05) && (Politica=3))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=06) && (Politica=4)) OR ((Año LIKE '%"+texto+"%') && (Mes=07) && (Politica=5))";
vencimiento(sql);}
  
if(fecha == "MARZO"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=03) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=04) && (Politica=1))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=05) && (Politica=2)) OR ((Año LIKE '%"+texto+"%') && (Mes=06) && (Politica=3))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=07) && (Politica=4)) OR ((Año LIKE '%"+texto+"%') && (Mes=08) && (Politica=5))";
vencimiento(sql);}   
        
if(fecha == "ABRIL"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=04) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=05) && (Politica=1))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=06) && (Politica=2)) OR ((Año LIKE '%"+texto+"%') && (Mes=07) && (Politica=3))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=08) && (Politica=4)) OR ((Año LIKE '%"+texto+"%') && (Mes=09) && (Politica=5))";
vencimiento(sql);}
        
if(fecha == "MAYO"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=05) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=06) && (Politica=1))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=07) && (Politica=2)) OR ((Año LIKE '%"+texto+"%') && (Mes=08) && (Politica=3))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=09) && (Politica=4)) OR ((Año LIKE '%"+texto+"%') && (Mes=10) && (Politica=5))";
vencimiento(sql);}
     
if(fecha == "JUNIO"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=06) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=07) && (Politica=1))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=08) && (Politica=2)) OR ((Año LIKE '%"+texto+"%') && (Mes=09) && (Politica=3))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=10) && (Politica=4)) OR ((Año LIKE '%"+texto+"%') && (Mes=11) && (Politica=5))";
vencimiento(sql);}
     
if(fecha == "JULIO"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=07) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=08) && (Politica=1))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=09) && (Politica=2)) OR ((Año LIKE '%"+texto+"%') && (Mes=10) && (Politica=3))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=11) && (Politica=4)) OR ((Año LIKE '%"+texto+"%') && (Mes=12) && (Politica=5))";
vencimiento(sql);}
     
if(fecha == "AGOSTO"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=08) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=09) && (Politica=1))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=10) && (Politica=2)) OR ((Año LIKE '%"+texto+"%') && (Mes=11) && (Politica=3))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=12) && (Politica=4)) OR ((Año LIKE '%"+tex+"%') && (Mes=01) && (Politica=5))";
vencimiento(sql);}
     
if(fecha == "SEPTIEMBRE"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=09) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=10) && (Politica=1))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=11) && (Politica=2)) OR ((Año LIKE '%"+texto+"%') && (Mes=12) && (Politica=3))"
+ "OR ((Año LIKE '%"+tex+"%') && (Mes=01) && (Politica=4)) OR ((Año LIKE '%"+tex+"%') && (Mes=02) && (Politica=5))";
vencimiento(sql);}
     
if(fecha == "OCTUBRE"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=10) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=11) && (Politica=1))"
+ "OR ((Año LIKE '%"+texto+"%') && (Mes=12) && (Politica=2)) OR ((Año LIKE '%"+tex+"%') && (Mes=01) && (Politica=3))"
+ "OR ((Año LIKE '%"+tex+"%') && (Mes=02) && (Politica=4)) OR ((Año LIKE '%"+tex+"%') && (Mes=03) && (Politica=5))";
vencimiento(sql);}
     
if(fecha == "NOVIEMBRE"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=11) && (Politica=0)) OR ((Año LIKE '%"+texto+"%') && (Mes=12) && (Politica=1))"
+ "OR ((Año LIKE '%"+tex+"%') && (Mes=01) && (Politica=2)) OR ((Año LIKE '%"+tex+"%') && (Mes=02) && (Politica=3))"
+ "OR ((Año LIKE '%"+tex+"%') && (Mes=03) && (Politica=4)) OR ((Año LIKE '%"+tex+"%') && (Mes=04) && (Politica=5))";
vencimiento(sql);}
     
if(fecha == "DICIEMBRE"){
String sql ="SELECT `Id`, `Nombre`, `Casa`, `Meses`, `Año`, `Proveedor`, `Politica` FROM `ingreso` "
+ "WHERE ((Año LIKE '%"+texto+"%') && (Mes=12) && (Politica=0)) OR ((Año LIKE '%"+tex+"%') && (Mes=01) && (Politica=1))"
+ "OR ((Año LIKE '%"+tex+"%') && (Mes=02) && (Politica=2)) OR ((Año LIKE '%"+tex+"%') && (Mes=03) && (Politica=3))"
+ "OR ((Año LIKE '%"+tex+"%') && (Mes=04) && (Politica=4)) OR ((Año LIKE '%"+tex+"%') && (Mes=05) && (Politica=5))";
vencimiento(sql);}
    }//GEN-LAST:event_boxfechaItemStateChanged

    private void txtnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    txtcasa.requestFocus();
    txtcasa.setBackground(Color.CYAN);
    txtnombre.setBackground(Color.WHITE);
}
    }//GEN-LAST:event_txtnombreKeyPressed

    private void txtcasaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcasaKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    boxmes.requestFocus();
    boxmes.setBackground(Color.CYAN);
    txtcasa.setBackground(Color.WHITE);
}
    }//GEN-LAST:event_txtcasaKeyPressed

    private void jTyyyyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTyyyyKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    txtpolitica.requestFocus();
    txtpolitica.setBackground(Color.CYAN);
    jTyyyy.setBackground(Color.WHITE);
}
    }//GEN-LAST:event_jTyyyyKeyPressed

    private void txtpoliticaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpoliticaKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    txtproveedor.requestFocus();
    txtproveedor.setBackground(Color.CYAN);
    txtpolitica.setBackground(Color.WHITE);
}
    }//GEN-LAST:event_txtpoliticaKeyPressed

    private void txtproveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproveedorKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    if(actu == false){
        btnactualizar.requestFocus();
    }else{btnguardar.requestFocus();}
    txtproveedor.setBackground(Color.WHITE);
}
    }//GEN-LAST:event_txtproveedorKeyPressed

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    if (txtnombre.getText().equals("")||jTyyyy.getText().equals("")||txtcasa.getText().equals("")
        ||txtpolitica.getText().equals("")||txtproveedor.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Faltan Datos: No Puede Dejar Cuadros en Blanco");}

    else{try{
        try{con = new mysql();}catch(Exception ex){JOptionPane.showMessageDialog(null, "Error: ");}
      
//se obtienen los valores de los jTextField
    String indice;
    String nombre = txtnombre.getText();
    String casa = txtcasa.getText();
    String mes=boxmes.getSelectedItem().toString();
    indice=detectarmes(mes);
    String año = jTyyyy.getText();
    String proveedor = txtproveedor.getText();
    String politica = txtpolitica.getText();
    String caducidad = jTyyyy.getText()+"-"+indice+"-01";
                
//sentencias sql para insertar los datos en la base de datos
    String sql = "INSERT INTO `ingreso`(`Nombre`, `Casa`, `Mes`, `Año`, `Proveedor`, "
            + "`Politica`, `Caducidad`, `Meses`) VALUES ('"+nombre+"','"+casa+"','"+indice+"','"
            + ""+año+"','"+proveedor+"','"+politica+"','"+caducidad+"','"+mes+"')";         
       
//funcion para ejecutar la query
    con.ejecutar(sql);

JOptionPane.showMessageDialog(null, "Producto: "+nombre+" agregado.");
              
//se limpian los campos de texto para seguir agregando mas datos
    limpiar();
                
}catch(Exception ex){JOptionPane.showMessageDialog(null, "Producto no agregado.");}
        
    inhabilitar();
    limpiar();
    bloquearguardar();
    bloquearactualizar();
    bloquearmodificar();
    bloqueareliminar();
    btnnuevo.requestFocus();
    }}
    }//GEN-LAST:event_btnguardarKeyPressed

    private void btnnuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnnuevoKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           
    limpiar();
    habilitar();
    habilitarguardar();
    bloquearactualizar();
    bloquearmodificar();
    bloqueareliminar();
     
    txtnombre.setBackground(Color.CYAN);
    GregorianCalendar objFecha=new GregorianCalendar();
    int añ=objFecha.get(Calendar.YEAR);
    String texto = Integer.toString(añ);
    jTyyyy.setText(texto);    
}

if(evt.getKeyCode()==KeyEvent.VK_DOWN){
    btncancelar.requestFocus();
}

    }//GEN-LAST:event_btnnuevoKeyPressed

    private void boxmesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxmesKeyPressed
     if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    jTyyyy.requestFocus();
    jTyyyy.setBackground(Color.CYAN);
    boxmes.setBackground(Color.WHITE);
}
    }//GEN-LAST:event_boxmesKeyPressed

    private void btnactualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnactualizarKeyPressed
 //BOTON PARA MODIFICAR LOS DATOS DE UN PRODUCTOS EN LA BASE DE DATOS

// validaciones para saber que no se deja algun campo en blanco
    if (txtcasa.getText().equals("")||jTyyyy.getText().equals("")||txtpolitica.getText().equals("")
      ||txtproveedor.getText().equals("")||txtproveedor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Faltan Datos: No Puede Dejar Cuadros en Blanco");}
    else{
//por si se da clic antes de hacer la busqueda
//se validan los textfield
    String indice;
    String casa = txtcasa.getText();
    String mes=boxmes.getSelectedItem().toString();
    indice=detectarmes(mes);
    String año = jTyyyy.getText();
    String politica = txtpolitica.getText();
    String proveedor = txtproveedor.getText();
    String nombre = txtnombre.getText();
    String caducidad = jTyyyy.getText()+"-"+indice+"-01";

    try {
//se crea la conexion y las consultas
        con = new mysql();
               
        int id2 = Integer.parseInt(id);
// se crea la sentecia sql y se ejecuta para hacer la modificacion
        String modifica = "UPDATE `ingreso` SET `Nombre`='"+nombre+"',`Casa`='"+casa+"',"
                + "`Mes`='"+indice+"',`Año`='"+año+"',`Proveedor`='"+proveedor+"',"
                + "`Politica`='"+politica+"',`Caducidad`='"+caducidad+"',`Meses`='"
                +mes+"' WHERE Id = '"+id2+"'";
        con.ejecutar(modifica);
        JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS");
} catch (Exception ex) {}
}//end if
    inhabilitar();
    limpiar();
    bloqueareliminar();
    bloquearmodificar();
    bloquearactualizar();
    habilitarnuevo();
    actu=true;
    btnnuevo.requestFocus();

    }//GEN-LAST:event_btnactualizarKeyPressed

    private void btnmodificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnmodificarKeyPressed
    habilitar();
    habilitaractualizar();
    bloquearguardar();
    bloquearnuevo();
    bloqueareliminar();
    txtnombre.setBackground(Color.CYAN);
    GregorianCalendar objFecha=new GregorianCalendar();
    int añ=objFecha.get(Calendar.YEAR);
    String texto = Integer.toString(añ);
    jTyyyy.setText(texto);
    actu = false;
    }//GEN-LAST:event_btnmodificarKeyPressed

    private void btncancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btncancelarKeyPressed
      inhabilitar();
      habilitarnuevo();
      bloquearguardar();
      bloquearactualizar();
      bloquearmodificar();
      bloqueareliminar();
      btnnuevo.requestFocus();
      txtnombre.setBackground(Color.WHITE);
      txtcasa.setBackground(Color.WHITE);
      jTyyyy.setBackground(Color.WHITE);
      txtpolitica.setBackground(Color.WHITE);
      txtproveedor.setBackground(Color.WHITE);
      this.boxfecha.setSelectedItem("POR FECHA");
      jtDatos.setModel(new DefaultTableModel());
    }//GEN-LAST:event_btncancelarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxfecha;
    private javax.swing.JComboBox<String> boxmes;
    public javax.swing.JButton btnExportar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btninventario;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnpoliticas;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnvencimiento;
    private javax.swing.JMenuItem editable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTyyyy;
    public javax.swing.JTable jtDatos;
    private javax.swing.JLabel lblcodproveedor;
    private javax.swing.JLabel lbldireccion1;
    private javax.swing.JLabel lbldireccion2;
    private javax.swing.JLabel lbldireccion3;
    private javax.swing.JLabel lbldireccion4;
    private javax.swing.JLabel lblproveedor;
    private javax.swing.JLabel lbltelefono1;
    private javax.swing.JTextField txtbuscarproducto;
    private javax.swing.JTextField txtcasa;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtpolitica;
    private javax.swing.JTextField txtproveedor;
    // End of variables declaration//GEN-END:variables
}
