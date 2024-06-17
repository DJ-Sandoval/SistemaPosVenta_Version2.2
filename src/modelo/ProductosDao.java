
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Jose
 */
public class ProductosDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Metodo para registrar Proveedores
    public boolean registrar(Productos prod) {
        String sql = "INSERT INTO productos (codigo, descripcion, precio_compra, precio_venta, id_proveedor, id_medida, id_categoria) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getDescripcion());
            ps.setDouble(3, prod.getPrecio_compra());
            ps.setDouble(4, prod.getPrecio_venta());
            ps.setInt(5, prod.getId_proveedor());
            ps.setInt(6, prod.getId_medida());
            ps.setInt(7, prod.getId_categoria());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    // Listar Proveedores listaProveedores
    public List ListaProductos(String valor) {
        List<Productos> listaProductos = new ArrayList();
        // Consulta para ordenar registros listados y buscar en la caja de texto
        String sql = "SELECT * FROM productos ORDER BY estado ASC";
        String buscar = "SELECT * FROM productos  WHERE codigo LIKE '%" + valor + "%' OR descripcion LIKE '%" + valor + "%'";
        try {
            con = cn.getConexion();
            if (valor.equalsIgnoreCase("")) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
            } else {
                ps = con.prepareStatement(buscar);
                rs = ps.executeQuery();
            }
            while (rs.next()) {
                Productos prod = new Productos();
                prod.setId(rs.getInt("id"));
                prod.setCodigo(rs.getString("codigo"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio_venta(rs.getInt("precio_compra"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setEstado(rs.getString("estado"));
                listaProductos.add(prod);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaProductos;
    }

    // Metodo para modificar
    public boolean modificar(Productos prod) {
        String sql = "UPDATE productos SET codigo = ?, descripcion = ?, precio_compra =?, precio_venta = ?, id_proveedor = ?, id_medida = ?, id_categoria = ? WHERE id = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getDescripcion());
            ps.setDouble(3, prod.getPrecio_compra());
            ps.setDouble(4, prod.getPrecio_venta());
            ps.setInt(5, prod.getId_proveedor());
            ps.setInt(6, prod.getId_medida());
            ps.setInt(7, prod.getId_categoria());
            ps.setInt(8, prod.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public boolean accion(String estado, int id) {
        String sql = "UPDATE productos SET estado = ? WHERE id = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public Productos buscarPro(int id) {
        String sql = "SELECT p.*, pr.id, pr.proveedor, m.id, m.medida, c.id, c.categoria FROM productos p INNER JOIN proveedor pr ON p.id_proveedor = pr.id INNER JOIN medidas m ON p.id_medida = m.id INNER JOIN categorias c ON p.id_categoria = c.id WHERE p.id = ?";
        Productos prod = new Productos();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                prod.setCodigo(rs.getString("codigo"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio_compra(rs.getDouble("precio_compra"));
                prod.setPrecio_venta(rs.getDouble("precio_venta"));
                prod.setId_proveedor(rs.getInt("id_proveedor"));
                prod.setId_medida(rs.getInt("id_medida"));
                prod.setId_categoria(rs.getInt("id_categoria"));
                prod.setProveedor(rs.getString("proveedor"));
                prod.setMedida(rs.getString("medida"));
                prod.setCat(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return prod;
    }

    // Método para obtener la cantidad de productos por categoría
    public Map<String, Integer> obtenerCantidadPorCategoria() {
        Map<String, Integer> datos = new HashMap<>();
        String sql = "SELECT c.categoria, COUNT(p.id) AS cantidad FROM productos p "
                + "INNER JOIN categorias c ON p.id_categoria = c.id "
                + "GROUP BY c.categoria";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.put(rs.getString("categoria"), rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return datos;
    }

    // Modulo compras
     public Productos buscarCodigo(String codigo) {
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        Productos prod = new Productos();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                prod.setId(rs.getInt("id"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio_compra(rs.getDouble("precio_compra"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return prod;
    }
}
