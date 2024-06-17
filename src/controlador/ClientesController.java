
package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Clientes;
import modelo.ClientesDao;
import modelo.Tables;
import vista.PanelAdmin;

/**
 *
 * @author Jose
 */
public class ClientesController implements ActionListener, MouseListener, KeyListener {
    private Clientes cl;
    private ClientesDao clDao;
    private PanelAdmin views;
    DefaultTableModel modelo = new DefaultTableModel();
    // Constructor con parametros de instancia de clases

    public ClientesController(Clientes cl, ClientesDao clDao, PanelAdmin views) {
        this.cl = cl;
        this.clDao = clDao;
        this.views = views;
        this.views.btnRegistrarCli.addActionListener(this);
        this.views.btnModificarCli.addActionListener(this);
        this.views.btnNuevoCli.addActionListener(this);
        this.views.TableClientes.addMouseListener(this);
        this.views.JMenuEliminarCli.addActionListener(this);
        this.views.JMenuReingresarCli.addActionListener(this);
        this.views.txtBuscarCli.addKeyListener(this);
        listarClienter();
    }
    
    // Metodo abstracto de accion para los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarCli) {
            if (views.txtNombreCliente.getText().equals("")
                    || views.txtTelefonoCli.getText().equals("")
                    || views.txtDireccionCli.getText().equals("")
                    || views.txtCombinacionCli.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "no dejes ESPACIOS EN BLANCO", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                cl.setNombre(views.txtNombreCliente.getText());
                cl.setTelefono(views.txtTelefonoCli.getText());
                cl.setDireccion(views.txtDireccionCli.getText());
                cl.setCombinacion(views.txtCombinacionCli.getText());
                if (clDao.registrar(cl)) {
                    limpiarTable();
                    listarClienter();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Cliente registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == views.btnModificarCli) {
            if (views.txtIdCli.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            } else {
                if (views.txtNombreCliente.getText().equals("")
                        || views.txtTelefonoCli.getText().equals("")
                        || views.txtDireccionCli.getText().equals("")
                        || views.txtCombinacionCli.getText().equals("")) {
                     JOptionPane.showMessageDialog(null, "no dejes ESPACIOS EN BLANCO", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    cl.setNombre(views.txtNombreCliente.getText());
                    cl.setTelefono(views.txtTelefonoCli.getText());
                    cl.setDireccion(views.txtDireccionCli.getText());
                    cl.setCombinacion(views.txtCombinacionCli.getText());
                    cl.setId(Integer.parseInt(views.txtIdCli.getText()));
                    if (clDao.modificar(cl)) {
                        limpiarTable();
                        listarClienter();
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Cliente modificado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al modificar cliente", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else if (e.getSource() == views.JMenuEliminarCli){
            if (views.txtIdCli.getText().equals("")) { 
                 JOptionPane.showMessageDialog(null, "Selecciona una fila", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 int id = Integer.parseInt(views.txtIdCli.getText());
                if (clDao.accion("Inactivo", id)) {
                    limpiarTable();
                    listarClienter();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Cliente eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar cliente");
                }
            }
        } else if (e.getSource() == views.JMenuReingresarCli){
            if (views.txtIdCli.getText().equals("")) {  
                JOptionPane.showMessageDialog(null, "Selecciona una fila", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 int id = Integer.parseInt(views.txtIdCli.getText());
                if (clDao.accion("Activo", id)) {
                    limpiarTable();
                    listarClienter();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Cliente reingresado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al reingresar cliente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            limpiar();
        }
        
    }
    
    // Metodos para el JTable
     // Listar usuarios
    public void listarClienter() {
        Tables color = new Tables();
        views.TableClientes.setDefaultRenderer(views.TableClientes.getColumnClass(0), color);
        List<Clientes> lista = clDao.ListaCliente(views.txtBuscarCli.getText());
        modelo = (DefaultTableModel) views.TableClientes.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getTelefono();
            ob[3] = lista.get(i).getDireccion();
            ob[4] = lista.get(i).getCombinacion();
            ob[5] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        // Establecer modelo a tabla
        views.TableClientes.setModel(modelo);
        // Establecer color a tabla
        JTableHeader header = views.TableClientes.getTableHeader();
        Font headerFont = new Font("SansSerif", Font.BOLD, 16);
        header.setFont(headerFont);
        header.setOpaque(false);
        header.setBackground(new Color(30,30,30)); //16,49,114 0,81,135
        header.setForeground(new Color(255,255,255));
    }

    public void limpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    // Metodos de mouse
    @Override
    public void mouseClicked(MouseEvent e) {
       if (e.getSource() == views.TableClientes) {
            int fila = views.TableClientes.rowAtPoint(e.getPoint());
            views.txtIdCli.setText(views.TableClientes.getValueAt(fila, 0).toString());
            views.txtNombreCliente.setText(views.TableClientes.getValueAt(fila, 1).toString());
            views.txtTelefonoCli.setText(views.TableClientes.getValueAt(fila, 2).toString());
            views.txtDireccionCli.setText(views.TableClientes.getValueAt(fila, 3).toString());
            views.txtCombinacionCli.setText(views.TableClientes.getValueAt(fila, 4).toString());
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
    
    // Metodo para limpiar campos de texto
    private void limpiar() {
        views.txtIdCli.setText("");
        views.txtNombreCliente.setText("");
        views.txtTelefonoCli.setText("");
        views.txtDireccionCli.setText("");
        views.txtCombinacionCli.setText("");
    }
    
    // Metodo de key
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarCli) {
            limpiarTable();
            listarClienter();
        }
    }
    
    


}
