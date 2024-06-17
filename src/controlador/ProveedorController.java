
package controlador;

/**
 *
 * @author Jose
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Combo;
import modelo.Proveedor;
import modelo.ProveedorDao;
import modelo.Tables;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import vista.PanelAdmin;

/**
 *
 * @author Jose
 */
public class ProveedorController implements ActionListener, MouseListener, KeyListener {
    private Proveedor prov;
    private ProveedorDao prDao;
    private PanelAdmin views;
    DefaultTableModel modelo = new DefaultTableModel();
    
    // Constructor con parametros de instancia de clases
    public ProveedorController(Proveedor prov, ProveedorDao prDao, PanelAdmin views) {    
        this.prov = prov;
        this.prDao = prDao;
        this.views = views;
        this.views.btnModificarProv.addActionListener(this);
        this.views.btnNuevoProv.addActionListener(this);
        this.views.btnRegistrarProv.addActionListener(this);
        this.views.txtBuscarProv.addKeyListener(this);
        this.views.TableProveedor.addMouseListener(this);
       this.views.JMenuEliminarProv.addActionListener(this);
       this.views.JMenuReingresarProv.addActionListener(this);
       llenarProveedor();
       AutoCompleteDecorator.decorate(views.cbxProveedorPr);
       listarProveedores();
    }
    
    

    // Metodo abstracto
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarProv) {
            if (views.txtRfcProv.getText().equals("")
                    || views.txtNombreProv.getText().equals("")
                    || views.txtTelefonoProv.getText().equals("")
                    || views.txtDireccionProv.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "no dejes ESPACIOS EN BLANCO", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                prov.setRfc(views.txtRfcProv.getText());
                prov.setNombre(views.txtNombreProv.getText());
                prov.setTelefono(views.txtTelefonoProv.getText());
                prov.setDireccion(views.txtDireccionProv.getText());
                if (prDao.registrar(prov)) {
                    limpiarTable();
                    listarProveedores();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Proveedor registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == views.btnModificarProv) {
            if (views.txtIdProv.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            } else {
                if (views.txtRfcProv.getText().equals("")
                        || views.txtNombreProv.getText().equals("")
                        || views.txtTelefonoProv.getText().equals("")
                        || views.txtDireccionProv.getText().equals("")) {
                     JOptionPane.showMessageDialog(null, "no dejes ESPACIOS EN BLANCO", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    prov.setRfc(views.txtRfcProv.getText());
                    prov.setNombre(views.txtNombreProv.getText());
                    prov.setTelefono(views.txtTelefonoProv.getText());
                    prov.setDireccion(views.txtDireccionProv.getText());
                    prov.setId(Integer.parseInt(views.txtIdProv.getText()));
                    if (prDao.modificar(prov)) {
                        limpiarTable();
                        listarProveedores();
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Proveedor modificado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al modificar proveedor", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }                  
        } else if (e.getSource() == views.JMenuEliminarProv) {
            if (views.txtIdProv.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int id = Integer.parseInt(views.txtIdProv.getText());
                if (prDao.accion("Inactivo", id)) {
                    limpiarTable();
                    listarProveedores();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar proveedor");
                }
            }
        } else if (e.getSource() == views.JMenuReingresarProv){
            if (views.txtIdProv.getText().equals("")) {  
                JOptionPane.showMessageDialog(null, "Selecciona una fila", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 int id = Integer.parseInt(views.txtIdProv.getText());
                if (prDao.accion("Activo", id)) {
                    limpiarTable();
                    listarProveedores();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Proveedor reingresado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al reingresar proveedor", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
        } else {
            limpiar();
        }
    }

    // Metodo 
    public void listarProveedores() {
        Tables color = new Tables();
        views.TableProveedor.setDefaultRenderer(views.TableProveedor.getColumnClass(0), color);
        List<Proveedor> lista = prDao.ListaProveedor(views.txtBuscarProv.getText());
        modelo = (DefaultTableModel) views.TableProveedor.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getRfc();
            ob[2] = lista.get(i).getNombre();
            ob[3] = lista.get(i).getTelefono();
            ob[4] = lista.get(i).getDireccion();
            ob[5] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        // Establecer modelo a tabla
        views.TableProveedor.setModel(modelo);
        // Establecer color a tabla
        
        JTableHeader header = views.TableProveedor.getTableHeader();
        Font headerFont = new Font("SansSerif", Font.BOLD, 16);
        header.setFont(headerFont);
        //views.TableProveedor.setDefaultRenderer(Object.class, new EstilosDarkTable(color1, color2));
        header.setOpaque(false);
         header.setBackground(new Color(30,30,30)); //16,49,114 0,81,135
        header.setForeground(new Color(255,255,255));
    }
    
    // Metodo para limpiar tabla
    public void limpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    // Metodo para limpiar
    public void limpiar() {
        views.txtRfcProv.setText("");
        views.txtNombreProv.setText("");
        views.txtTelefonoProv.setText("");
        views.txtDireccionProv.setText("");
        views.txtIdProv.setText("");
    }
    
    // Metodos de mouse
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == views.TableProveedor) {
            int fila = views.TableProveedor.rowAtPoint(e.getPoint());
            views.txtIdProv.setText(views.TableProveedor.getValueAt(fila, 0).toString());
            views.txtRfcProv.setText(views.TableProveedor.getValueAt(fila, 1).toString());
            views.txtNombreProv.setText(views.TableProveedor.getValueAt(fila, 2).toString());
            views.txtTelefonoProv.setText(views.TableProveedor.getValueAt(fila, 3).toString());
            views.txtDireccionProv.setText(views.TableProveedor.getValueAt(fila, 4).toString());
        }
   }

    @Override
    public void mousePressed(MouseEvent e) {
   }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    // Metodos de key
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarProv) {
            limpiarTable();
            listarProveedores();
        }
    }
    
    // Metodo para llenar comboBox Proveedor
    private void llenarProveedor() {
         List<Proveedor> lista = prDao.ListaProveedor(views.txtBuscarProv.getText());   
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId();
            String nombre = lista.get(i).getNombre();
            views.cbxProveedorPr.addItem(new Combo(id, nombre));
        }
    }
}

