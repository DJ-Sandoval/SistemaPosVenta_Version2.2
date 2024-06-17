
package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Combo;
import modelo.Productos;
import modelo.ProductosDao;
import modelo.Tables;
import vista.PanelAdmin;
import controlador.ProveedorController;
import modelo.Proveedor;
import modelo.ProveedorDao;

/**
 *
 * @author Jose
 */
public class ProductosController implements ActionListener, MouseListener, KeyListener {
    // Instanciar clases
    private ProveedorDao prDao;
    private Productos prod;
    private ProductosDao proDao;
    private PanelAdmin views;
    //private ProveedorController provC;
    
    
   
    DefaultTableModel modelo = new DefaultTableModel();

    // Constructor con isntancias
    public ProductosController(ProveedorDao prDao, Productos prod, ProductosDao proDao, PanelAdmin views) {
        this.prod = prod;
        this.proDao = proDao;
        this.views = views;
        this.prDao = prDao;
        this.views.btnRegistrarPro.addActionListener(this);
        this.views.btnModificarPro.addActionListener(this);
        this.views.btnNuevoPro.addActionListener(this);
        this.views.JMenuEliminarProd.addActionListener(this);
        this.views.JMenuReingresarProd.addActionListener(this);
        this.views.TableProductos.addMouseListener(this); 
        this.views.txtCodNC.addKeyListener(this);
        this.views.txtCantNC.addKeyListener(this);
        this.views.txtPagarConNC.addKeyListener(this);
        llenarProveedor();
        listarProductos();
        
        

    }
    
    // Metodos de accion
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.btnRegistrarPro) {
            if (views.txtCodigoPro.getText().equals("")
                    || views.txtDescripcionPro.getText().equals("")
                    || views.txtPrecioCompraPro.getText().equals("")
                    || views.txtPrecioVentaPro.getText().equals("")
                    || views.cbxProveedorPr.getSelectedItem().equals("")
                    || views.cbxCategoriaPro.getSelectedItem().equals("")
                    || views.cbxMedidaPro.getSelectedItem().equals("")){                
                JOptionPane.showMessageDialog(null, "no dejes ESPACIOS EN BLANCO");
            } else {
                prod.setCodigo(views.txtCodigoPro.getText());
                prod.setDescripcion(views.txtDescripcionPro.getText());
                prod.setPrecio_compra(Double.parseDouble(views.txtPrecioCompraPro.getText()));
                prod.setPrecio_venta(Double.parseDouble(views.txtPrecioVentaPro.getText()));
                Combo itemP = (Combo) views.cbxProveedorPr.getSelectedItem();
                Combo itemC = (Combo) views.cbxCategoriaPro.getSelectedItem();
                Combo itemM = (Combo) views.cbxMedidaPro.getSelectedItem();
                prod.setId_proveedor(itemP.getId());
                prod.setId_categoria(itemC.getId());
                prod.setId_medida(itemM.getId());
                
                if (proDao.registrar(prod)) {
                    limpiarTable();
                    listarProductos();
                    
                    JOptionPane.showMessageDialog(null, "Producto Registrado con exito");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar el producto");
                }
            }
        } else if (e.getSource() == views.btnModificarPro) {
            if (views.txtCodigoPro.getText().equals("")
                    || views.txtDescripcionPro.getText().equals("")
                    || views.txtPrecioCompraPro.getText().equals("")
                    || views.txtPrecioVentaPro.getText().equals("")
                    || views.cbxProveedorPr.getSelectedItem().equals("")
                    || views.cbxCategoriaPro.getSelectedItem().equals("")
                    || views.cbxMedidaPro.getSelectedItem().equals("")){     
                JOptionPane.showMessageDialog(null, "Selecciona una fila");
            } else {
                prod.setCodigo(views.txtCodigoPro.getText());
                prod.setDescripcion(views.txtDescripcionPro.getText());
                prod.setPrecio_compra(Double.parseDouble(views.txtPrecioCompraPro.getText()));
                prod.setPrecio_venta(Double.parseDouble(views.txtPrecioVentaPro.getText()));
                Combo itemP = (Combo) views.cbxProveedorPr.getSelectedItem();
                Combo itemC = (Combo) views.cbxCategoriaPro.getSelectedItem();
                Combo itemM = (Combo) views.cbxMedidaPro.getSelectedItem();
                prod.setId_proveedor(itemP.getId());
                prod.setId_categoria(itemC.getId());
                prod.setId_medida(itemM.getId());
                prod.setId(Integer.parseInt(views.txtIdProducto.getText()));
                if (proDao.modificar(prod)) {
                    limpiarTable();
                    listarProductos();
                    
                    JOptionPane.showMessageDialog(null, "Producto Modificado con exito");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el producto");
                }
            }
        } else if (e.getSource() == views.JMenuEliminarProd) {
            if (views.txtIdProducto.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
            } else {
                int id = Integer.parseInt(views.txtIdProducto.getText());
                if (proDao.accion("Inactivo", id)) {
                    limpiarTable();
                    listarProductos();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Producto eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar producto");
                }
            }
        } else if (e.getSource() == views.JMenuReingresarProd) {
            if (views.txtIdProducto.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para reingresar");
            } else {
                int id = Integer.parseInt(views.txtIdProducto.getText());
                if (proDao.accion("Activo", id)) {
                    limpiarTable();
                    listarProductos();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Producto reingresado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al reingresar producto");
                }
            }
        } else {
            limpiar();
        }
        
    }
    
     // Metodo para limpiar tabla
    public void limpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    public void limpiar() {
        views.txtCodigoPro.setText("");
        views.txtDescripcionPro.setText("");
        views.txtPrecioCompraPro.setText("");
        views.txtIdProducto.setText("");
        views.txtPrecioVentaPro.setText("");
    }
    
     public void listarProductos() {
        Tables color = new Tables();
        views.TableProductos.setDefaultRenderer(views.TableProductos.getColumnClass(0), color);
        List<Productos> lista = proDao.ListaProductos(views.txtBuscarProducto.getText());
        modelo = (DefaultTableModel) views.TableProductos.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getCodigo();
            ob[2] = lista.get(i).getDescripcion();
            ob[3] = lista.get(i).getPrecio_venta();
            ob[4] = lista.get(i).getCantidad();
            ob[5] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        // Establecer modelo a tabla
        views.TableProductos.setModel(modelo);
        
        // Establecer color a tabla
        JTableHeader header = views.TableProductos.getTableHeader();
        Font headerFont = new Font("SansSerif", Font.BOLD, 16);
        header.setFont(headerFont);
        header.setOpaque(false);
        header.setBackground(new Color(30,30,30)); //16,49,114 0,81,135
        header.setForeground(new Color(255,255,255));
    }
    
    // Metodos de Mouse
    @Override
    public void mouseClicked(MouseEvent e) {
        
         if (e.getSource() == views.TableProductos) {
            int fila = views.TableProductos.rowAtPoint(e.getPoint());
            views.txtIdProducto.setText(views.TableProductos.getValueAt(fila, 0).toString());
            prod = proDao.buscarPro(Integer.parseInt(views.txtIdProducto.getText()));
            views.txtCodigoPro.setText(prod.getCodigo());
            views.txtDescripcionPro.setText(prod.getDescripcion());
            views.txtPrecioCompraPro.setText(""+prod.getPrecio_compra());
            views.txtPrecioVentaPro.setText(""+prod.getPrecio_venta());
            views.cbxProveedorPr.setSelectedItem(new Combo(prod.getId_proveedor(), prod.getProveedor()));
            views.cbxMedidaPro.setSelectedItem(new Combo(prod.getId_medida(), prod.getMedida()));
            views.cbxCategoriaPro.setSelectedItem(new Combo(prod.getId_categoria(), prod.getCat()));  

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

    // Metodos de Key
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == views.txtCodNC) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (views.txtCodNC.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese el codigo");
                } else {
                    String cod = views.txtCodNC.getText();
                    prod = proDao.buscarCodigo(cod);
                     views.txtIdNC.setText(""+prod.getId());
                    views.txtProductoNC.setText(prod.getDescripcion());
                    views.txtPrecioNC.setText(""+prod.getPrecio_compra());
                    views.txtCantNC.requestFocus();
                }
            }
        } else if (e.getSource() == views.txtCantNC) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                int cant = Integer.parseInt(views.txtCantNC.getText());
                String desc = views.txtProductoNC.getText();
                double precio = Double.parseDouble(views.txtPrecioNC.getText());
                // Calcular el total
                int id = Integer.parseInt(views.txtIdNC.getText());
                if (cant > 0) {
                    DefaultTableModel tmp = (DefaultTableModel) views.TableNuevaCompra.getModel();
                    ArrayList lista = new ArrayList();
                    int item = 1;
                    lista.add(item);
                    lista.add(id);
                    lista.add(desc);
                    lista.add(cant);
                    lista.add(precio);
                    lista.add(cant * precio);
                    Object[] obj = new Object[5];
                    obj[0] = lista.get(1);
                    obj[1] = lista.get(2);
                    obj[2] = lista.get(3);
                    obj[3] = lista.get(4);
                    obj[4] = lista.get(5);
                    tmp.addRow(obj);
                    views.TableNuevaCompra.setModel(tmp);
                    JTableHeader header = views.TableNuevaCompra.getTableHeader();
                    Font headerFont = new Font("SansSerif", Font.BOLD, 16);
                    header.setOpaque(false);
                    header.setBackground(new Color(30, 30, 30)); //16,49,114 0,81,135
                    header.setForeground(new Color(255, 255, 255));
                    header.setFont(headerFont);
                    limpiarCampos();
                    calcularCompra();
                    views.txtCodNC.requestFocus();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtCantNC) {
                int cantidad;
                double precio;
            if (views.txtCantNC.getText().equals("")) {
                    cantidad = 1;
                    precio = Double.parseDouble(views.txtPrecioNC.getText());
                    views.txtTotalNC.setText(""+precio);
            } else {
                cantidad = Integer.parseInt(views.txtCantNC.getText());
                precio = Double.parseDouble(views.txtPrecioNC.getText());
                views.txtTotalNC.setText(""+cantidad * precio);
            }
        } else if (e.getSource() == views.txtPagarConNC) {
            int pagar;
            if (views.txtPagarConNC.getText().equals("")) {
                views.txtVueltoCompra.setText("");
            } else {
                pagar = Integer.parseInt(views.txtPagarConNC.getText());
                double total = Double.parseDouble(views.JLabelTotalCompra.getText());
                views.txtVueltoCompra.setText(""+ (pagar - total));
            }
        }
    }

    private void limpiarCampos() {
        views.txtCodNC.setText("");
        views.txtIdNC.setText("");
        views.txtProductoNC.setText("");
        views.txtCantNC.setText("");
        views.txtPrecioNC.setText("");
        views.txtTotalNC.setText("");
    }
    
    private void calcularCompra() {
        double total = 0.00;
        int numFila = views.TableNuevaCompra.getRowCount();
        for (int i = 0; i < numFila; i++) {
            total = total + Double.parseDouble(String.valueOf(views.TableNuevaCompra.getValueAt(i, 4))); // String.valueof(views.tabla de comora)
        }
        views.JLabelTotalCompra.setText(""+ total);
    }
    
    // Llenar combo de proveedores para venta
    // Metodo para llenar comboBox Proveedor
    public void llenarProveedor() {
         List<Proveedor> lista = prDao.ListaProveedor(views.txtBuscarProv.getText());   
        for (int i = 0; i < lista.size(); i++) {
            int id = lista.get(i).getId();
            String nombre = lista.get(i).getNombre();
            views.cbxProvNC.addItem(new Combo(id, nombre));
        }
    }
    

    

}
