
package vista;


import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import controlador.CategoriaController;
import controlador.ClientesController;
import controlador.MedidaController;
import controlador.Noticias;
import controlador.ProductosController;
import controlador.ProveedorController;
import controlador.UsuariosControllers;
import controlador.textPrompt;
import event.MenuEvent;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import modelo.CategoriaDao;
import modelo.Categorias;
import modelo.Clientes;
import modelo.ClientesDao;
import modelo.MedidaDao;
import modelo.Medidas;
import modelo.Productos;
import modelo.ProductosDao;
import modelo.Proveedor;
import modelo.ProveedorDao;
import modelo.UsuarioDao;
import modelo.Usuarios;
import chart.PieChartExample;
import java.util.Map;

/**
 *
 * @author Jose
 */
public class PanelAdmin extends javax.swing.JFrame {

    Usuarios us = new Usuarios();
    UsuarioDao usDao = new UsuarioDao();

    Proveedor prov = new Proveedor();
    ProveedorDao prDao = new ProveedorDao();

    Clientes cli = new Clientes();
    ClientesDao clDao = new ClientesDao();

    Categorias cat = new Categorias();
    CategoriaDao ctDao = new CategoriaDao();

    Medidas med = new Medidas();
    MedidaDao mdDao = new MedidaDao();

    Productos prod = new Productos();
    ProductosDao proDao = new ProductosDao();
    
    FrmReportes report = new FrmReportes(this, true);

    /**
     * Creates new form PanelAdmin
     */
    public PanelAdmin() {
        initComponents();
        // Obtener los datos y crear la gráfica
        // Obtener los datos y crear la gráfica
        // Obtener los datos y crear la gráfica
        ProductosDao productosDao = new ProductosDao();
        // Obtener los datos y crear la gráfica

        //textPrompt placeHolder1 = new textPrompt("Buscar producto", txtBuscarProducto);
        this.setLocationRelativeTo(null);
        this.setSize(1319, 682);
        this.setTitle("posVentav2 PanelAdmin");
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        iniciar();
        // Instancia de controlador
        UsuariosControllers users = new UsuariosControllers(us, usDao, this);
        ClientesController cliente = new ClientesController(cli, clDao, this);
        ProveedorController proveedores = new ProveedorController(prov, prDao, this);
        CategoriaController categorias = new CategoriaController(cat, ctDao, this);
        MedidaController medidas = new MedidaController(med, mdDao, this);
        ProductosController productos = new ProductosController(prDao, prod, proDao, this);

        // Menu
        MenuEvent event = new MenuEvent() {
            @Override
            public void menuSelected(int index) {
                System.out.println("Selected : " + index);
                switch (index) {
                    case 0: // Inicio
                        ProductosDao productosDao = new ProductosDao();
                        PanelAdmin.this.jTabbedPane1.setSelectedIndex(12);
                        Map<String, Integer> data = productosDao.obtenerCantidadPorCategoria();
                        new PieChartExample(data, panelGrafica);
                        setVisible(true);
                        break;
                    case 1: // Nueva Venta
                        PanelAdmin.this.jTabbedPane1.setSelectedIndex(6);
                        break;
                    case 2: // Nueva Compra
                        PanelAdmin.this.jTabbedPane1.setSelectedIndex(11);
                        break;
                    case 3: // Productos
                        PanelAdmin.this.jTabbedPane1.setSelectedIndex(0);
                        break;
                    case 4: // Clientes
                        PanelAdmin.this.jTabbedPane1.setSelectedIndex(1);
                        break;
                    case 5: // Usuarios
                        PanelAdmin.this.jTabbedPane1.setSelectedIndex(3);
                        break;
                    case 6: // Proveedores
                        PanelAdmin.this.jTabbedPane1.setSelectedIndex(2);
                        break;
                    case 7: // Medidas
                        PanelAdmin.this.jTabbedPane1.setSelectedIndex(5);
                        break;
                    case 8: // Categorias
                        PanelAdmin.this.jTabbedPane1.setSelectedIndex(4);
                        break;
                    case 9: // Configuraciones
                        PanelAdmin.this.jTabbedPane1.setSelectedIndex(9);
                        break;
                    case 10: // Reportes
                         report.setVisible(true);
                        break;
                    case 11: // Salir
                        desertar();
                        break;
                }
            }
        };
        menu.initMenu(event);

        // Imagen
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/posIcono.png"));
        this.setIconImage(icono);

        // Timer para la hora
        // Crear un Timer para actualizar la hora cada segundo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblHora.setText(obtenerHoraActual());
            }
        });

// Iniciar el Timer
        timer.start();

        //  Cambiar de color el selector de campos
        //Cliente
        txtNombreCliente.setSelectionColor(new Color(92, 56, 255));
        // Producto
        // Usuario
        //Medida
        //Categoria
        //Proveedor
        //

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPopupUsuarios = new javax.swing.JPopupMenu();
        JMenuEliminarUsers = new javax.swing.JMenuItem();
        JMenuReingresarUsers = new javax.swing.JMenuItem();
        JPopupClientes = new javax.swing.JPopupMenu();
        JMenuEliminarCli = new javax.swing.JMenuItem();
        JMenuReingresarCli = new javax.swing.JMenuItem();
        JPopupProveedor = new javax.swing.JPopupMenu();
        JMenuEliminarProv = new javax.swing.JMenuItem();
        JMenuReingresarProv = new javax.swing.JMenuItem();
        JPopupCategorias = new javax.swing.JPopupMenu();
        JMenuEliminarCat = new javax.swing.JMenuItem();
        JMenuReingresarCat = new javax.swing.JMenuItem();
        JPopupMedidas = new javax.swing.JPopupMenu();
        JMenuEliminarMed = new javax.swing.JMenuItem();
        JMenuReingresarMed = new javax.swing.JMenuItem();
        JPopupProductos = new javax.swing.JPopupMenu();
        JMenuEliminarProd = new javax.swing.JMenuItem();
        JMenuReingresarProd = new javax.swing.JMenuItem();
        menu = new controlador.Menu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoPro = new javax.swing.JTextField();
        txtDescripcionPro = new javax.swing.JTextField();
        txtPrecioCompraPro = new javax.swing.JTextField();
        txtPrecioVentaPro = new javax.swing.JTextField();
        cbxProveedorPr = new javax.swing.JComboBox<>();
        cbxMedidaPro = new javax.swing.JComboBox<>();
        btnNuevoPro = new javax.swing.JButton();
        btnRegistrarPro = new javax.swing.JButton();
        btnModificarPro = new javax.swing.JButton();
        cbxCategoriaPro = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        PaginadorPro = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        TableProductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtTelefonoCli = new javax.swing.JTextField();
        btnNuevoCli = new javax.swing.JButton();
        btnRegistrarCli = new javax.swing.JButton();
        btnModificarCli = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDireccionCli = new javax.swing.JTextArea();
        txtCombinacionCli = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtBuscarCli = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtIdCli = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableClientes = new javax.swing.JTable();
        PaginadorCli = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombreProv = new javax.swing.JTextField();
        txtTelefonoProv = new javax.swing.JTextField();
        btnNuevoProv = new javax.swing.JButton();
        btnRegistrarProv = new javax.swing.JButton();
        btnModificarProv = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDireccionProv = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txtRfcProv = new javax.swing.JTextField();
        txtBuscarProv = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtIdProv = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        PaginadoProv = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableProveedor = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNombreUser = new javax.swing.JTextField();
        btnNuevoUser = new javax.swing.JButton();
        btnRegistrarUser = new javax.swing.JButton();
        btnModificarUser = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtUsuarioUser = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbxCajaUser = new javax.swing.JComboBox<>();
        cbxRolUser = new javax.swing.JComboBox<>();
        txtClaveUser = new javax.swing.JPasswordField();
        txtIdUser = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtBuscarUsers = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TableUsers = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtNombreCat = new javax.swing.JTextField();
        btnNuevoCat = new javax.swing.JButton();
        btnRegistrarCat = new javax.swing.JButton();
        btnModificarCat = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtBuscarCategoria = new javax.swing.JTextField();
        txtIdCat = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TableCat = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtNombreMed = new javax.swing.JTextField();
        btnNuevoMed = new javax.swing.JButton();
        btnRegistrarMed = new javax.swing.JButton();
        btnModificarMed = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtNombreCortoMed = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtBuscarMed = new javax.swing.JTextField();
        txtIdMed = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TableMed = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableNuevaVenta = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtCodNV = new javax.swing.JTextField();
        txtProductoNV = new javax.swing.JTextField();
        txtCantNV = new javax.swing.JTextField();
        txtPrecioNV = new javax.swing.JTextField();
        txtTotalNV = new javax.swing.JTextField();
        txtStockNV = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        cbxClientes = new javax.swing.JComboBox<>();
        txtPagarCon = new javax.swing.JTextField();
        txtVuelto = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        JLabelTotalPagar = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TableVentas = new javax.swing.JTable();
        PaginadoVentas = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TableCompras = new javax.swing.JTable();
        PaginadoCompras = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtTelefonoEmpresa = new javax.swing.JTextField();
        btnModificarEmpresa = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtDireccionEmpresa = new javax.swing.JTextArea();
        jLabel47 = new javax.swing.JLabel();
        txtRfcEmpresa = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableNuevaCompra = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtCodNC = new javax.swing.JTextField();
        txtProductoNC = new javax.swing.JTextField();
        txtCantNC = new javax.swing.JTextField();
        txtPrecioNC = new javax.swing.JTextField();
        txtTotalNC = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        btnGenerarCompra = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        cbxProvNC = new javax.swing.JComboBox<>();
        txtPagarConNC = new javax.swing.JTextField();
        txtVueltoCompra = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        JLabelTotalCompra = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txtIdNC = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        panelGrafica = new javax.swing.JPanel();
        panelRound1 = new controlador.PanelRound();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        panelRound2 = new controlador.PanelRound();
        panelRound3 = new controlador.PanelRound();
        panelRound4 = new controlador.PanelRound();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        btnUser = new controlador.MyButton();
        btnScroll = new controlador.MyButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblGraficas = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        lblAcercaDe = new javax.swing.JLabel();
        txtBuscarProducto = new controlador.TextFieldAnimation();

        JMenuEliminarUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        JMenuEliminarUsers.setText("Eliminar");
        JPopupUsuarios.add(JMenuEliminarUsers);

        JMenuReingresarUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar-informacion.png"))); // NOI18N
        JMenuReingresarUsers.setText("Reingresar");
        JPopupUsuarios.add(JMenuReingresarUsers);

        JMenuEliminarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        JMenuEliminarCli.setText("Eliminar");
        JPopupClientes.add(JMenuEliminarCli);

        JMenuReingresarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar-informacion.png"))); // NOI18N
        JMenuReingresarCli.setText("Reingresar");
        JPopupClientes.add(JMenuReingresarCli);

        JMenuEliminarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        JMenuEliminarProv.setText("Eliminar");
        JPopupProveedor.add(JMenuEliminarProv);

        JMenuReingresarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar-informacion.png"))); // NOI18N
        JMenuReingresarProv.setText("Reingresar");
        JPopupProveedor.add(JMenuReingresarProv);

        JMenuEliminarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        JMenuEliminarCat.setText("Eliminar");
        JPopupCategorias.add(JMenuEliminarCat);

        JMenuReingresarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar-informacion.png"))); // NOI18N
        JMenuReingresarCat.setText("reingresar");
        JPopupCategorias.add(JMenuReingresarCat);

        JMenuEliminarMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        JMenuEliminarMed.setText("Eliminar");
        JPopupMedidas.add(JMenuEliminarMed);

        JMenuReingresarMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar-informacion.png"))); // NOI18N
        JMenuReingresarMed.setText("Reingresar");
        JPopupMedidas.add(JMenuReingresarMed);

        JMenuEliminarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        JMenuEliminarProd.setText("Eliminar");
        JPopupProductos.add(JMenuEliminarProd);

        JMenuReingresarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar-informacion.png"))); // NOI18N
        JMenuReingresarProd.setText("Reingresar");
        JPopupProductos.add(JMenuReingresarProd);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(32, 32, 32));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(23, 23, 23));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripcion");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio Compra");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio Venta");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Proveedor");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Medida");

        txtCodigoPro.setBackground(new java.awt.Color(47, 47, 47));
        txtCodigoPro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCodigoPro.setForeground(new java.awt.Color(255, 255, 255));

        txtDescripcionPro.setBackground(new java.awt.Color(47, 47, 47));
        txtDescripcionPro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDescripcionPro.setForeground(new java.awt.Color(255, 255, 255));

        txtPrecioCompraPro.setBackground(new java.awt.Color(47, 47, 47));
        txtPrecioCompraPro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPrecioCompraPro.setForeground(new java.awt.Color(255, 255, 255));

        txtPrecioVentaPro.setBackground(new java.awt.Color(47, 47, 47));
        txtPrecioVentaPro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPrecioVentaPro.setForeground(new java.awt.Color(255, 255, 255));

        cbxProveedorPr.setBackground(new java.awt.Color(47, 47, 47));
        cbxProveedorPr.setEditable(true);
        cbxProveedorPr.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbxProveedorPr.setForeground(new java.awt.Color(255, 255, 255));

        cbxMedidaPro.setBackground(new java.awt.Color(47, 47, 47));
        cbxMedidaPro.setEditable(true);
        cbxMedidaPro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbxMedidaPro.setForeground(new java.awt.Color(255, 255, 255));

        btnNuevoPro.setBackground(new java.awt.Color(23, 23, 23));
        btnNuevoPro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNuevoPro.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NuevoRegistro.png"))); // NOI18N
        btnNuevoPro.setBorder(null);

        btnRegistrarPro.setBackground(new java.awt.Color(23, 23, 23));
        btnRegistrarPro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRegistrarPro.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GuardarRegistro.png"))); // NOI18N
        btnRegistrarPro.setBorder(null);

        btnModificarPro.setBackground(new java.awt.Color(23, 23, 23));
        btnModificarPro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModificarPro.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ModificarRegistro.png"))); // NOI18N
        btnModificarPro.setBorder(null);

        cbxCategoriaPro.setBackground(new java.awt.Color(47, 47, 47));
        cbxCategoriaPro.setEditable(true);
        cbxCategoriaPro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbxCategoriaPro.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Categoria");

        txtIdProducto.setBackground(new java.awt.Color(47, 47, 47));
        txtIdProducto.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtIdProducto.setForeground(new java.awt.Color(255, 255, 255));

        jLabel64.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Id Producto");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnNuevoPro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnRegistrarPro)
                .addGap(80, 80, 80)
                .addComponent(btnModificarPro)
                .addGap(57, 57, 57))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigoPro)
                        .addComponent(jLabel2)
                        .addComponent(txtDescripcionPro)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(64, 64, 64)
                            .addComponent(jLabel4))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(txtPrecioCompraPro, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64)
                            .addComponent(txtPrecioVentaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxProveedorPr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxMedidaPro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxCategoriaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel64)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcionPro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioCompraPro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVentaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxProveedorPr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMedidaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCategoriaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarPro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrarPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoPro, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36))
        );

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 560));

        PaginadorPro.setBackground(new java.awt.Color(23, 23, 23));

        javax.swing.GroupLayout PaginadorProLayout = new javax.swing.GroupLayout(PaginadorPro);
        PaginadorPro.setLayout(PaginadorProLayout);
        PaginadorProLayout.setHorizontalGroup(
            PaginadorProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        PaginadorProLayout.setVerticalGroup(
            PaginadorProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.add(PaginadorPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, 690, 50));

        TableProductos.setBackground(new java.awt.Color(30, 30, 30));
        TableProductos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        TableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Codigo", "Descripcion", "Precio", "Stock", "Estado"
            }
        ));
        TableProductos.setComponentPopupMenu(JPopupProductos);
        jScrollPane15.setViewportView(TableProductos);

        jPanel2.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 690, 490));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(32, 32, 32));
        jPanel3.setPreferredSize(new java.awt.Dimension(980, 530));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(23, 23, 23));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel15.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(246, 246, 246));
        jLabel8.setText("Nombre");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(246, 246, 246));
        jLabel9.setText("Telefono");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(246, 246, 246));
        jLabel10.setText("Direccion");

        txtNombreCliente.setBackground(new java.awt.Color(47, 47, 47));
        txtNombreCliente.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombreCliente.setForeground(new java.awt.Color(255, 255, 255));

        txtTelefonoCli.setBackground(new java.awt.Color(47, 47, 47));
        txtTelefonoCli.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtTelefonoCli.setForeground(new java.awt.Color(255, 255, 255));

        btnNuevoCli.setBackground(new java.awt.Color(23, 23, 23));
        btnNuevoCli.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNuevoCli.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NuevoRegistro.png"))); // NOI18N
        btnNuevoCli.setBorder(null);

        btnRegistrarCli.setBackground(new java.awt.Color(23, 23, 23));
        btnRegistrarCli.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRegistrarCli.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GuardarRegistro.png"))); // NOI18N
        btnRegistrarCli.setBorder(null);

        btnModificarCli.setBackground(new java.awt.Color(23, 23, 23));
        btnModificarCli.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModificarCli.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ModificarRegistro.png"))); // NOI18N
        btnModificarCli.setBorder(null);

        txtDireccionCli.setBackground(new java.awt.Color(47, 47, 47));
        txtDireccionCli.setColumns(20);
        txtDireccionCli.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDireccionCli.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccionCli.setRows(5);
        jScrollPane3.setViewportView(txtDireccionCli);

        txtCombinacionCli.setBackground(new java.awt.Color(47, 47, 47));
        txtCombinacionCli.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCombinacionCli.setForeground(new java.awt.Color(255, 255, 255));

        jLabel51.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(246, 246, 246));
        jLabel51.setText("Combi");

        txtBuscarCli.setBackground(new java.awt.Color(47, 47, 47));
        txtBuscarCli.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBuscarCli.setForeground(new java.awt.Color(255, 255, 255));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N

        txtIdCli.setBackground(new java.awt.Color(47, 47, 47));
        txtIdCli.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtIdCli.setForeground(new java.awt.Color(255, 255, 255));

        jLabel53.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(246, 246, 246));
        jLabel53.setText("idCli");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(btnNuevoCli)
                        .addGap(72, 72, 72)
                        .addComponent(btnRegistrarCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarCli))
                    .addComponent(jLabel52)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel51)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarCli)
                    .addComponent(txtNombreCliente)
                    .addComponent(txtTelefonoCli)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(txtCombinacionCli)
                    .addComponent(txtIdCli))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCombinacionCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(btnNuevoCli)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarCli)
                            .addComponent(btnModificarCli))
                        .addContainerGap())))
        );

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 560));

        TableClientes.setBackground(new java.awt.Color(30, 30, 30));
        TableClientes.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        TableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Telefono", "Direccion", "Combinacion", "Estado"
            }
        ));
        TableClientes.setComponentPopupMenu(JPopupClientes);
        jScrollPane2.setViewportView(TableClientes);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 700, 490));

        PaginadorCli.setBackground(new java.awt.Color(23, 23, 23));

        javax.swing.GroupLayout PaginadorCliLayout = new javax.swing.GroupLayout(PaginadorCli);
        PaginadorCli.setLayout(PaginadorCliLayout);
        PaginadorCliLayout.setHorizontalGroup(
            PaginadorCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        PaginadorCliLayout.setVerticalGroup(
            PaginadorCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel3.add(PaginadorCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, 700, 50));

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(32, 32, 32));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(23, 23, 23));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel16.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Telefono");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Direccion");

        txtNombreProv.setBackground(new java.awt.Color(47, 47, 47));
        txtNombreProv.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombreProv.setForeground(new java.awt.Color(255, 255, 255));

        txtTelefonoProv.setBackground(new java.awt.Color(47, 47, 47));
        txtTelefonoProv.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtTelefonoProv.setForeground(new java.awt.Color(255, 255, 255));

        btnNuevoProv.setBackground(new java.awt.Color(23, 23, 23));
        btnNuevoProv.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNuevoProv.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NuevoRegistro.png"))); // NOI18N
        btnNuevoProv.setBorder(null);

        btnRegistrarProv.setBackground(new java.awt.Color(23, 23, 23));
        btnRegistrarProv.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRegistrarProv.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GuardarRegistro.png"))); // NOI18N
        btnRegistrarProv.setBorder(null);

        btnModificarProv.setBackground(new java.awt.Color(23, 23, 23));
        btnModificarProv.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModificarProv.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ModificarRegistro.png"))); // NOI18N
        btnModificarProv.setBorder(null);

        txtDireccionProv.setBackground(new java.awt.Color(47, 47, 47));
        txtDireccionProv.setColumns(20);
        txtDireccionProv.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDireccionProv.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccionProv.setRows(5);
        jScrollPane4.setViewportView(txtDireccionProv);

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Rfc");

        txtRfcProv.setBackground(new java.awt.Color(47, 47, 47));
        txtRfcProv.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtRfcProv.setForeground(new java.awt.Color(255, 255, 255));

        txtBuscarProv.setBackground(new java.awt.Color(47, 47, 47));
        txtBuscarProv.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBuscarProv.setForeground(new java.awt.Color(255, 255, 255));

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N

        txtIdProv.setBackground(new java.awt.Color(47, 47, 47));
        txtIdProv.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtIdProv.setForeground(new java.awt.Color(255, 255, 255));

        jLabel58.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("idProv");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel58)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(jLabel13)
                            .addComponent(txtTelefonoProv, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57)
                            .addComponent(jLabel14)
                            .addComponent(txtIdProv)
                            .addComponent(txtNombreProv))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRfcProv, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarProv, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(btnNuevoProv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrarProv)
                                .addGap(76, 76, 76)
                                .addComponent(btnModificarProv)))
                        .addGap(46, 46, 46))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRfcProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarProv)
                    .addComponent(btnModificarProv)
                    .addComponent(btnNuevoProv))
                .addGap(23, 23, 23))
        );

        jPanel4.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 550));

        PaginadoProv.setBackground(new java.awt.Color(23, 23, 23));

        javax.swing.GroupLayout PaginadoProvLayout = new javax.swing.GroupLayout(PaginadoProv);
        PaginadoProv.setLayout(PaginadoProvLayout);
        PaginadoProvLayout.setHorizontalGroup(
            PaginadoProvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        PaginadoProvLayout.setVerticalGroup(
            PaginadoProvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel4.add(PaginadoProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, 690, 50));

        TableProveedor.setBackground(new java.awt.Color(30, 30, 30));
        TableProveedor.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        TableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "rfc", "Proveedor", "telefono", "Direccion", "Estado"
            }
        ));
        TableProveedor.setComponentPopupMenu(JPopupProveedor);
        jScrollPane5.setViewportView(TableProveedor);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 690, 470));

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel5.setBackground(new java.awt.Color(32, 32, 32));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(23, 23, 23));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nombre");

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Clave");

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Caja");

        txtNombreUser.setBackground(new java.awt.Color(47, 47, 47));
        txtNombreUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombreUser.setForeground(new java.awt.Color(255, 255, 255));

        btnNuevoUser.setBackground(new java.awt.Color(23, 23, 23));
        btnNuevoUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNuevoUser.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NuevoRegistro.png"))); // NOI18N
        btnNuevoUser.setBorder(null);

        btnRegistrarUser.setBackground(new java.awt.Color(23, 23, 23));
        btnRegistrarUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRegistrarUser.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GuardarRegistro.png"))); // NOI18N
        btnRegistrarUser.setBorder(null);

        btnModificarUser.setBackground(new java.awt.Color(23, 23, 23));
        btnModificarUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModificarUser.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ModificarRegistro.png"))); // NOI18N
        btnModificarUser.setBorder(null);

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Usuario");

        txtUsuarioUser.setBackground(new java.awt.Color(47, 47, 47));
        txtUsuarioUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtUsuarioUser.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Rol");

        cbxCajaUser.setBackground(new java.awt.Color(47, 47, 47));
        cbxCajaUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbxCajaUser.setForeground(new java.awt.Color(255, 255, 255));
        cbxCajaUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General" }));

        cbxRolUser.setBackground(new java.awt.Color(47, 47, 47));
        cbxRolUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbxRolUser.setForeground(new java.awt.Color(255, 255, 255));
        cbxRolUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Programador" }));

        txtClaveUser.setBackground(new java.awt.Color(47, 47, 47));
        txtClaveUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtClaveUser.setForeground(new java.awt.Color(255, 255, 255));

        txtIdUser.setBackground(new java.awt.Color(47, 47, 47));
        txtIdUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtIdUser.setForeground(new java.awt.Color(255, 255, 255));

        jLabel49.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("idUser");

        txtBuscarUsers.setBackground(new java.awt.Color(47, 47, 47));
        txtBuscarUsers.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBuscarUsers.setForeground(new java.awt.Color(255, 255, 255));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jLabel49)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17)
                        .addComponent(jLabel23)
                        .addComponent(jLabel22)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24)
                        .addComponent(txtBuscarUsers)
                        .addComponent(txtUsuarioUser)
                        .addComponent(txtNombreUser)
                        .addComponent(txtClaveUser)
                        .addComponent(cbxCajaUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxRolUser, 0, 264, Short.MAX_VALUE))
                    .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnNuevoUser)
                .addGap(86, 86, 86)
                .addComponent(btnRegistrarUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(btnModificarUser)
                .addGap(44, 44, 44))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuarioUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClaveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCajaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxRolUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoUser)
                    .addComponent(btnRegistrarUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarUser))
                .addGap(21, 21, 21))
        );

        jPanel5.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 550));

        TableUsers.setBackground(new java.awt.Color(30, 30, 30));
        TableUsers.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        TableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Usuario", "Nombre", "Caja", "Rol", "Estado"
            }
        ));
        TableUsers.setComponentPopupMenu(JPopupUsuarios);
        jScrollPane8.setViewportView(TableUsers);

        jPanel5.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 690, 550));

        jTabbedPane1.addTab("tab4", jPanel5);

        jPanel6.setBackground(new java.awt.Color(32, 32, 32));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(23, 23, 23));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel19.setForeground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Nombre");

        txtNombreCat.setBackground(new java.awt.Color(47, 47, 47));
        txtNombreCat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombreCat.setForeground(new java.awt.Color(255, 255, 255));

        btnNuevoCat.setBackground(new java.awt.Color(23, 23, 23));
        btnNuevoCat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNuevoCat.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NuevoRegistro.png"))); // NOI18N
        btnNuevoCat.setBorder(null);

        btnRegistrarCat.setBackground(new java.awt.Color(23, 23, 23));
        btnRegistrarCat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRegistrarCat.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GuardarRegistro.png"))); // NOI18N
        btnRegistrarCat.setBorder(null);

        btnModificarCat.setBackground(new java.awt.Color(23, 23, 23));
        btnModificarCat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModificarCat.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ModificarRegistro.png"))); // NOI18N
        btnModificarCat.setBorder(null);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N

        txtBuscarCategoria.setBackground(new java.awt.Color(47, 47, 47));
        txtBuscarCategoria.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        txtIdCat.setBackground(new java.awt.Color(47, 47, 47));
        txtIdCat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtIdCat.setForeground(new java.awt.Color(255, 255, 255));

        jLabel56.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("idCat");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombreCat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtIdCat, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                                        .addComponent(btnNuevoCat)
                                        .addGap(79, 79, 79)
                                        .addComponent(btnRegistrarCat)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                .addComponent(btnModificarCat)))
                        .addGap(46, 46, 46))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel16)
                .addGap(28, 28, 28)
                .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdCat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevoCat, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarCat, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModificarCat)))
                .addGap(114, 114, 114))
        );

        jPanel6.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 530));

        TableCat.setBackground(new java.awt.Color(30, 30, 30));
        TableCat.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        TableCat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Estado"
            }
        ));
        TableCat.setComponentPopupMenu(JPopupCategorias);
        jScrollPane9.setViewportView(TableCat);

        jPanel6.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 700, 530));

        jTabbedPane1.addTab("tab5", jPanel6);

        jPanel7.setBackground(new java.awt.Color(32, 32, 32));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(23, 23, 23));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nueva Medida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel20.setForeground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Nombre");

        txtNombreMed.setBackground(new java.awt.Color(47, 47, 47));
        txtNombreMed.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombreMed.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreMed.setCaretColor(new java.awt.Color(51, 51, 51));
        txtNombreMed.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreMed.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        btnNuevoMed.setBackground(new java.awt.Color(21, 21, 21));
        btnNuevoMed.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNuevoMed.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NuevoRegistro.png"))); // NOI18N
        btnNuevoMed.setBorder(null);

        btnRegistrarMed.setBackground(new java.awt.Color(23, 23, 23));
        btnRegistrarMed.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRegistrarMed.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GuardarRegistro.png"))); // NOI18N
        btnRegistrarMed.setBorder(null);

        btnModificarMed.setBackground(new java.awt.Color(23, 23, 23));
        btnModificarMed.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModificarMed.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ModificarRegistro.png"))); // NOI18N
        btnModificarMed.setBorder(null);

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nombre Corto");

        txtNombreCortoMed.setBackground(new java.awt.Color(47, 47, 47));
        txtNombreCortoMed.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombreCortoMed.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreCortoMed.setCaretColor(new java.awt.Color(51, 51, 51));

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N

        txtBuscarMed.setBackground(new java.awt.Color(47, 47, 47));
        txtBuscarMed.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBuscarMed.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscarMed.setCaretColor(new java.awt.Color(51, 51, 51));

        txtIdMed.setBackground(new java.awt.Color(47, 47, 47));
        txtIdMed.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtIdMed.setForeground(new java.awt.Color(204, 204, 204));
        txtIdMed.setCaretColor(new java.awt.Color(51, 51, 51));

        jLabel61.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("IdMed");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBuscarMed, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(txtNombreCortoMed, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel61)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdMed)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(btnNuevoMed)
                                        .addGap(80, 80, 80)
                                        .addComponent(btnRegistrarMed)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnModificarMed))))))
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18)
                        .addComponent(txtNombreMed, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(txtNombreMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreCortoMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel61)
                .addGap(18, 18, 18)
                .addComponent(txtIdMed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoMed, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrarMed, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnModificarMed, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(57, 57, 57))
        );

        jPanel7.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 540));

        TableMed.setBackground(new java.awt.Color(23, 23, 23));
        TableMed.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        TableMed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Nombre Corto", "Estado"
            }
        ));
        TableMed.setComponentPopupMenu(JPopupMedidas);
        jScrollPane10.setViewportView(TableMed);

        jPanel7.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 690, 540));

        jTabbedPane1.addTab("tab6", jPanel7);

        jPanel8.setBackground(new java.awt.Color(47, 113, 214));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableNuevaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Descripcion", "Cantidad", "Precio", "Total"
            }
        ));
        jScrollPane6.setViewportView(TableNuevaVenta);

        jPanel8.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 137, 1010, 350));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Codigo");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Producto");
        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Cant");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        jLabel30.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Precio");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        txtCodNV.setBackground(new java.awt.Color(255, 255, 255));
        txtCodNV.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtCodNV.setForeground(new java.awt.Color(0, 0, 0));
        jPanel8.add(txtCodNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 160, 30));

        txtProductoNV.setBackground(new java.awt.Color(255, 255, 255));
        txtProductoNV.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtProductoNV.setForeground(new java.awt.Color(0, 0, 0));
        jPanel8.add(txtProductoNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 200, 30));

        txtCantNV.setBackground(new java.awt.Color(255, 255, 255));
        txtCantNV.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtCantNV.setForeground(new java.awt.Color(0, 0, 0));
        jPanel8.add(txtCantNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 60, 30));

        txtPrecioNV.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecioNV.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtPrecioNV.setForeground(new java.awt.Color(0, 0, 0));
        jPanel8.add(txtPrecioNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, 30));

        txtTotalNV.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalNV.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtTotalNV.setForeground(new java.awt.Color(0, 0, 0));
        jPanel8.add(txtTotalNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, 30));

        txtStockNV.setBackground(new java.awt.Color(255, 255, 255));
        txtStockNV.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtStockNV.setForeground(new java.awt.Color(0, 0, 0));
        jPanel8.add(txtStockNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 70, 30));

        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Total");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, -1));

        jLabel32.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Stock");
        jPanel8.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, -1, -1));

        btnGenerarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarVenta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnGenerarVenta.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarVenta.setText("Generar");
        jPanel8.add(btnGenerarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 90, 30));

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Cliente");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        cbxClientes.setBackground(new java.awt.Color(255, 255, 255));
        cbxClientes.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cbxClientes.setForeground(new java.awt.Color(0, 0, 0));
        jPanel8.add(cbxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 210, 30));

        txtPagarCon.setBackground(new java.awt.Color(255, 255, 255));
        txtPagarCon.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtPagarCon.setForeground(new java.awt.Color(0, 0, 0));
        jPanel8.add(txtPagarCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 150, 30));

        txtVuelto.setBackground(new java.awt.Color(255, 255, 255));
        txtVuelto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtVuelto.setForeground(new java.awt.Color(0, 0, 0));
        jPanel8.add(txtVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 150, 30));

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Total Pagar");
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, -1, -1));

        JLabelTotalPagar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabelTotalPagar.setForeground(new java.awt.Color(0, 0, 0));
        JLabelTotalPagar.setText("-------");
        jPanel8.add(JLabelTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 500, -1, -1));

        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Pagar con");
        jPanel8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, -1, -1));

        jLabel34.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Vuelto");
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, -1, -1));

        jTabbedPane1.addTab("tab7", jPanel8);

        jPanel9.setBackground(new java.awt.Color(204, 153, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Cliente", "Total", "Fecha"
            }
        ));
        jScrollPane11.setViewportView(TableVentas);

        jPanel9.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 920, 420));

        javax.swing.GroupLayout PaginadoVentasLayout = new javax.swing.GroupLayout(PaginadoVentas);
        PaginadoVentas.setLayout(PaginadoVentasLayout);
        PaginadoVentasLayout.setHorizontalGroup(
            PaginadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        PaginadoVentasLayout.setVerticalGroup(
            PaginadoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel9.add(PaginadoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 1020, 60));

        jTabbedPane1.addTab("tab8", jPanel9);

        jPanel10.setBackground(new java.awt.Color(153, 255, 153));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Proveedor", "Total", "Fecha"
            }
        ));
        jScrollPane12.setViewportView(TableCompras);

        jPanel10.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 880, 400));

        javax.swing.GroupLayout PaginadoComprasLayout = new javax.swing.GroupLayout(PaginadoCompras);
        PaginadoCompras.setLayout(PaginadoComprasLayout);
        PaginadoComprasLayout.setHorizontalGroup(
            PaginadoComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        PaginadoComprasLayout.setVerticalGroup(
            PaginadoComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel10.add(PaginadoCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 1020, 60));

        jTabbedPane1.addTab("tab9", jPanel10);

        jPanel11.setBackground(new java.awt.Color(30, 64, 175));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(17, 24, 39));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));

        jLabel40.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Nombre");

        jLabel45.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Telefono");

        jLabel46.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Direccion");

        txtNombreEmpresa.setBackground(new java.awt.Color(55, 65, 81));
        txtNombreEmpresa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombreEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        txtTelefonoEmpresa.setBackground(new java.awt.Color(55, 65, 81));
        txtTelefonoEmpresa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtTelefonoEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefonoEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnModificarEmpresa.setBackground(new java.awt.Color(37, 99, 235));
        btnModificarEmpresa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModificarEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEmpresa.setText("Modificar");

        txtDireccionEmpresa.setBackground(new java.awt.Color(55, 65, 81));
        txtDireccionEmpresa.setColumns(20);
        txtDireccionEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccionEmpresa.setRows(5);
        txtDireccionEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane13.setViewportView(txtDireccionEmpresa);

        jLabel47.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Rfc");

        txtRfcEmpresa.setBackground(new java.awt.Color(55, 65, 81));
        txtRfcEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        txtRfcEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel48.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Mensaje");

        txtMensaje.setBackground(new java.awt.Color(55, 65, 81));
        txtMensaje.setColumns(20);
        txtMensaje.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtMensaje.setForeground(new java.awt.Color(255, 255, 255));
        txtMensaje.setRows(5);
        txtMensaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane14.setViewportView(txtMensaje);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtTelefonoEmpresa)
                            .addComponent(txtNombreEmpresa)
                            .addComponent(jScrollPane13)
                            .addComponent(txtRfcEmpresa)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnModificarEmpresa)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRfcEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addGap(27, 27, 27)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addGap(34, 34, 34)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel46)))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel48))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(btnModificarEmpresa)
                .addGap(46, 46, 46))
        );

        jPanel11.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 540));

        jPanel1.setBackground(new java.awt.Color(17, 24, 39));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Sistema Integrado de Punto de venta(POS)");

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoChaskas65.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(99, 99, 99))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel60)
                .addGap(36, 36, 36)
                .addComponent(jLabel54)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 660, 540));

        jTabbedPane1.addTab("tab10", jPanel11);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab11", jPanel12);

        jPanel14.setBackground(new java.awt.Color(47, 113, 214));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableNuevaCompra.setBackground(new java.awt.Color(30, 30, 30));
        TableNuevaCompra.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        TableNuevaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Descripcion", "Cantidad", "Precio", "Total"
            }
        ));
        jScrollPane7.setViewportView(TableNuevaCompra);

        jPanel14.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 107, 960, 380));

        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Codigo");
        jPanel14.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel36.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Producto");
        jPanel14.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel37.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Cant");
        jPanel14.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jLabel38.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Precio");
        jPanel14.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        txtCodNC.setBackground(new java.awt.Color(255, 255, 255));
        txtCodNC.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtCodNC.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(txtCodNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 160, 30));

        txtProductoNC.setBackground(new java.awt.Color(255, 255, 255));
        txtProductoNC.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtProductoNC.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(txtProductoNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 200, 30));

        txtCantNC.setBackground(new java.awt.Color(255, 255, 255));
        txtCantNC.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtCantNC.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(txtCantNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 60, 30));

        txtPrecioNC.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecioNC.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtPrecioNC.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(txtPrecioNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, 30));

        txtTotalNC.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalNC.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtTotalNC.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(txtTotalNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, 30));

        jLabel39.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Total");
        jPanel14.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        btnGenerarCompra.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnGenerarCompra.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarCompra.setText("Generar");
        jPanel14.add(btnGenerarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 90, 30));

        jLabel41.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Proveedor");
        jPanel14.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        cbxProvNC.setBackground(new java.awt.Color(255, 255, 255));
        cbxProvNC.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cbxProvNC.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(cbxProvNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 210, 30));

        txtPagarConNC.setBackground(new java.awt.Color(255, 255, 255));
        txtPagarConNC.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtPagarConNC.setForeground(new java.awt.Color(0, 0, 0));
        txtPagarConNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagarConNCActionPerformed(evt);
            }
        });
        jPanel14.add(txtPagarConNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 150, 30));

        txtVueltoCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtVueltoCompra.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtVueltoCompra.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(txtVueltoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, 150, 30));

        jLabel42.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Total Pagar");
        jPanel14.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 500, -1, -1));

        JLabelTotalCompra.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabelTotalCompra.setForeground(new java.awt.Color(0, 0, 0));
        JLabelTotalCompra.setText("-------");
        jPanel14.add(JLabelTotalCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 500, -1, -1));

        jLabel43.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Pagar con");
        jPanel14.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, -1, -1));

        jLabel44.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Vuelto");
        jPanel14.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, -1, -1));

        jLabel67.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("Id");
        jPanel14.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        txtIdNC.setBackground(new java.awt.Color(255, 255, 255));
        txtIdNC.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtIdNC.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(txtIdNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, -1, 30));

        jTabbedPane1.addTab("Nueva Compra", jPanel14);

        jPanel21.setBackground(new java.awt.Color(33, 33, 33));

        javax.swing.GroupLayout panelGraficaLayout = new javax.swing.GroupLayout(panelGrafica);
        panelGrafica.setLayout(panelGraficaLayout);
        panelGraficaLayout.setHorizontalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );
        panelGraficaLayout.setVerticalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );

        panelRound1.setBackground(new java.awt.Color(49, 46, 126));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Productos");

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caja-abierta (1).png"))); // NOI18N

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jLabel66)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(jLabel66))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound2.setBackground(new java.awt.Color(6, 78, 59));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelRound3.setBackground(new java.awt.Color(120, 53, 15));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );

        panelRound4.setBackground(new java.awt.Color(136, 19, 55));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(panelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jTabbedPane1.addTab("Inicio", jPanel21);

        jPanel22.setBackground(new java.awt.Color(32, 32, 32));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Graficas", jPanel22);

        jPanel23.setBackground(new java.awt.Color(32, 32, 32));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab15", jPanel23);

        btnUser.setForeground(new java.awt.Color(0, 0, 0));
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gerente.png"))); // NOI18N
        btnUser.setText("Programador");
        btnUser.setBorderColor(new java.awt.Color(21, 21, 21));
        btnUser.setColorClick(new java.awt.Color(21, 21, 21));
        btnUser.setColorOver(new java.awt.Color(255, 255, 255));
        btnUser.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnUser.setRadius(50);

        btnScroll.setBackground(new java.awt.Color(92, 56, 255));
        btnScroll.setForeground(new java.awt.Color(255, 255, 255));
        btnScroll.setText("+Add");
        btnScroll.setBorderColor(new java.awt.Color(21, 21, 21));
        btnScroll.setColor(new java.awt.Color(92, 56, 255));
        btnScroll.setColorClick(new java.awt.Color(21, 21, 21));
        btnScroll.setColorOver(new java.awt.Color(92, 56, 255));
        btnScroll.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnScroll.setPreferredSize(new java.awt.Dimension(72, 35));
        btnScroll.setRadius(10);
        btnScroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScrollActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        lblGraficas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblGraficas.setForeground(new java.awt.Color(255, 255, 255));
        lblGraficas.setText("Graficas");
        lblGraficas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGraficasMouseClicked(evt);
            }
        });

        lblHora.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("Loading");

        jLabel55.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("recuerda abrir caja");

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Términos de servicio");

        lblAcercaDe.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblAcercaDe.setForeground(new java.awt.Color(255, 255, 255));
        lblAcercaDe.setText("Acerca de");
        lblAcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAcercaDeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblGraficas)
                                .addGap(18, 18, 18)
                                .addComponent(lblAcercaDe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblHora)
                .addGap(18, 18, 18)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel62)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGraficas)
                            .addComponent(lblAcercaDe)
                            .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHora)
                            .addComponent(jLabel55)
                            .addComponent(jLabel62))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnScrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScrollActionPerformed


    }//GEN-LAST:event_btnScrollActionPerformed

    private void lblAcercaDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAcercaDeMouseClicked
        JOptionPane.showMessageDialog(this, "Sistema: PosVenta" + "\nVersion: 2.1.2"
                + "\nProgramador: Jose Armando Sandoval Santana"
                + "\nSoporte: 3414190809"
                + "\nTodos los derechos rservados"
                + "\n", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblAcercaDeMouseClicked

    private void lblGraficasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGraficasMouseClicked
        ProductosDao productosDao = new ProductosDao();
        PanelAdmin.this.jTabbedPane1.setSelectedIndex(12);
        Map<String, Integer> data = productosDao.obtenerCantidadPorCategoria();
        new PieChartExample(data, panelGrafica);
        setVisible(true);
    }//GEN-LAST:event_lblGraficasMouseClicked

    private void txtPagarConNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagarConNCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagarConNCActionPerformed

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
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());

        } catch (Exception e) {

        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel JLabelTotalCompra;
    private javax.swing.JLabel JLabelTotalPagar;
    public javax.swing.JMenuItem JMenuEliminarCat;
    public javax.swing.JMenuItem JMenuEliminarCli;
    public javax.swing.JMenuItem JMenuEliminarMed;
    public javax.swing.JMenuItem JMenuEliminarProd;
    public javax.swing.JMenuItem JMenuEliminarProv;
    public javax.swing.JMenuItem JMenuEliminarUsers;
    public javax.swing.JMenuItem JMenuReingresarCat;
    public javax.swing.JMenuItem JMenuReingresarCli;
    public javax.swing.JMenuItem JMenuReingresarMed;
    public javax.swing.JMenuItem JMenuReingresarProd;
    public javax.swing.JMenuItem JMenuReingresarProv;
    public javax.swing.JMenuItem JMenuReingresarUsers;
    public javax.swing.JPopupMenu JPopupCategorias;
    private javax.swing.JPopupMenu JPopupClientes;
    public javax.swing.JPopupMenu JPopupMedidas;
    private javax.swing.JPopupMenu JPopupProductos;
    private javax.swing.JPopupMenu JPopupProveedor;
    private javax.swing.JPopupMenu JPopupUsuarios;
    private javax.swing.JPanel PaginadoCompras;
    private javax.swing.JPanel PaginadoProv;
    private javax.swing.JPanel PaginadoVentas;
    public javax.swing.JPanel PaginadorCli;
    private javax.swing.JPanel PaginadorPro;
    public javax.swing.JTable TableCat;
    public javax.swing.JTable TableClientes;
    private javax.swing.JTable TableCompras;
    public javax.swing.JTable TableMed;
    public javax.swing.JTable TableNuevaCompra;
    private javax.swing.JTable TableNuevaVenta;
    public javax.swing.JTable TableProductos;
    public javax.swing.JTable TableProveedor;
    public javax.swing.JTable TableUsers;
    private javax.swing.JTable TableVentas;
    public javax.swing.JButton btnGenerarCompra;
    private javax.swing.JButton btnGenerarVenta;
    public javax.swing.JButton btnModificarCat;
    public javax.swing.JButton btnModificarCli;
    private javax.swing.JButton btnModificarEmpresa;
    public javax.swing.JButton btnModificarMed;
    public javax.swing.JButton btnModificarPro;
    public javax.swing.JButton btnModificarProv;
    public javax.swing.JButton btnModificarUser;
    public javax.swing.JButton btnNuevoCat;
    public javax.swing.JButton btnNuevoCli;
    public javax.swing.JButton btnNuevoMed;
    public javax.swing.JButton btnNuevoPro;
    public javax.swing.JButton btnNuevoProv;
    public javax.swing.JButton btnNuevoUser;
    public javax.swing.JButton btnRegistrarCat;
    public javax.swing.JButton btnRegistrarCli;
    public javax.swing.JButton btnRegistrarMed;
    public javax.swing.JButton btnRegistrarPro;
    public javax.swing.JButton btnRegistrarProv;
    public javax.swing.JButton btnRegistrarUser;
    private controlador.MyButton btnScroll;
    private controlador.MyButton btnUser;
    public javax.swing.JComboBox<String> cbxCajaUser;
    public javax.swing.JComboBox<Object> cbxCategoriaPro;
    private javax.swing.JComboBox<String> cbxClientes;
    public javax.swing.JComboBox<Object> cbxMedidaPro;
    public javax.swing.JComboBox<Object> cbxProvNC;
    public javax.swing.JComboBox<Object> cbxProveedorPr;
    public javax.swing.JComboBox<String> cbxRolUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAcercaDe;
    private javax.swing.JLabel lblGraficas;
    private javax.swing.JLabel lblHora;
    private controlador.Menu menu;
    private javax.swing.JPanel panelGrafica;
    private controlador.PanelRound panelRound1;
    private controlador.PanelRound panelRound2;
    private controlador.PanelRound panelRound3;
    private controlador.PanelRound panelRound4;
    public javax.swing.JTextField txtBuscarCategoria;
    public javax.swing.JTextField txtBuscarCli;
    public javax.swing.JTextField txtBuscarMed;
    public controlador.TextFieldAnimation txtBuscarProducto;
    public javax.swing.JTextField txtBuscarProv;
    public javax.swing.JTextField txtBuscarUsers;
    public javax.swing.JTextField txtCantNC;
    private javax.swing.JTextField txtCantNV;
    public javax.swing.JPasswordField txtClaveUser;
    public javax.swing.JTextField txtCodNC;
    private javax.swing.JTextField txtCodNV;
    public javax.swing.JTextField txtCodigoPro;
    public javax.swing.JTextField txtCombinacionCli;
    public javax.swing.JTextField txtDescripcionPro;
    public javax.swing.JTextArea txtDireccionCli;
    private javax.swing.JTextArea txtDireccionEmpresa;
    public javax.swing.JTextArea txtDireccionProv;
    public javax.swing.JTextField txtIdCat;
    public javax.swing.JTextField txtIdCli;
    public javax.swing.JTextField txtIdMed;
    public javax.swing.JTextField txtIdNC;
    public javax.swing.JTextField txtIdProducto;
    public javax.swing.JTextField txtIdProv;
    public javax.swing.JTextField txtIdUser;
    private javax.swing.JTextArea txtMensaje;
    public javax.swing.JTextField txtNombreCat;
    public javax.swing.JTextField txtNombreCliente;
    public javax.swing.JTextField txtNombreCortoMed;
    private javax.swing.JTextField txtNombreEmpresa;
    public javax.swing.JTextField txtNombreMed;
    public javax.swing.JTextField txtNombreProv;
    public javax.swing.JTextField txtNombreUser;
    private javax.swing.JTextField txtPagarCon;
    public javax.swing.JTextField txtPagarConNC;
    public javax.swing.JTextField txtPrecioCompraPro;
    public javax.swing.JTextField txtPrecioNC;
    private javax.swing.JTextField txtPrecioNV;
    public javax.swing.JTextField txtPrecioVentaPro;
    public javax.swing.JTextField txtProductoNC;
    private javax.swing.JTextField txtProductoNV;
    private javax.swing.JTextField txtRfcEmpresa;
    public javax.swing.JTextField txtRfcProv;
    private javax.swing.JTextField txtStockNV;
    public javax.swing.JTextField txtTelefonoCli;
    private javax.swing.JTextField txtTelefonoEmpresa;
    public javax.swing.JTextField txtTelefonoProv;
    public javax.swing.JTextField txtTotalNC;
    private javax.swing.JTextField txtTotalNV;
    public javax.swing.JTextField txtUsuarioUser;
    private javax.swing.JTextField txtVuelto;
    public javax.swing.JTextField txtVueltoCompra;
    // End of variables declaration//GEN-END:variables

    // Funcion para cerrar sesion
    public void desertar() {
        // Muestra un cuadro de diálogo con la pregunta "¿Deseas salir?"
        int response = JOptionPane.showConfirmDialog(null, "¿Deseas Cerrar Sesion?", "Confirmación de salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Verifica la respuesta del usuario
        if (response == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Cerrando Sesion.....");
            // Aquí puedes poner el código para cerrar la aplicación si es necesario
            // Termina la aplicación
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        } else {
            // No hacer nada

        }
    }

    // Método para obtener la hora actual formateada
    private String obtenerHoraActual() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
        return ahora.format(formateador);
    }

    public void iniciar() {
        ProductosDao productosDao = new ProductosDao();
        PanelAdmin.this.jTabbedPane1.setSelectedIndex(12);
        Map<String, Integer> data = productosDao.obtenerCantidadPorCategoria();
        new PieChartExample(data, panelGrafica);
        setVisible(true);
    }
    // Metodos para seleccion de color

}
