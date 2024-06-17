
package modelo;

//import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Jose
 */
public class UsuarioDao {
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Usuarios login(String usuario, String clave){
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ?";
        Usuarios us = new Usuarios();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            if (rs.next()) {
                us.setId(rs.getInt("id"));
                us.setUsuario(rs.getString("usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setCaja(rs.getString("caja"));
                us.setRol(rs.getString("rol"));
                us.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return us;
    }
    /*
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
     public Usuarios login(String usuario, String clave) {
        String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND clave = ?";
        Usuarios us = new Usuarios();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            if (rs.next()) {
                us.setId(rs.getInt("id"));
                us.setUsuario(rs.getString("usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setCaja(rs.getString("caja"));
                us.setRol(rs.getString("rol"));
                us.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.toString());
            }
        }
        return us;
    }
     public boolean loginUser(Usuarios objeto) {
    boolean respuesta = false;
    String sql = "SELECT usuario, clave FROM Usuarios WHERE usuario = ? AND clave = ?";
    
    try (Connection cn = Conexion.conectar();
         PreparedStatement pst = cn.prepareStatement(sql)) {
        
        pst.setString(1, objeto.getUsuario());
        pst.setString(2, objeto.getClave());
        
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                respuesta = true;
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al Iniciar Sesion: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion: " + e.getMessage());
    }
    
    return respuesta;
}

   /*
   public Usuarios loginUser(Usuarios objeto) {
        String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND clave = ?";
        Usuarios us = new Usuarios();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getClave());
            rs = ps.executeQuery();
            if (rs.next()) {
                us.setId(rs.getInt("id"));
                us.setUsuario(rs.getString("usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setCaja(rs.getString("caja"));
                us.setRol(rs.getString("rol"));
                us.setEstado(rs.getString("estado"));
            } else {
                us = null; // No se encontró el usuario
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return us;
    }
   */

   public boolean registrar(Usuarios us) {
       String sql = "INSERT INTO Usuarios (usuario, nombre, clave, caja, rol) VALUES (?,?,?,?,?)";
       try {
           con = cn.getConexion();
           ps = con.prepareStatement(sql);
           ps.setString(1, us.getUsuario());
           ps.setString(2, us.getNombre());
           ps.setString(3, us.getClave());
           ps.setString(4, us.getCaja());
           ps.setString(5, us.getRol());
           ps.execute();
           return true;
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           return false;
       }
   }
   
    // Listar Usuarios
    public List ListaUsuario(String valor) {
        List<Usuarios> listaUsers = new ArrayList();
        // Consulta para ordenar registros listados y buscar en la caja de texto
        String sql = "SELECT * FROM Usuarios ORDER BY estado ASC";
        String buscar = "SELECT * FROM Usuarios WHERE usuario LIKE '%" + valor + "%' OR nombre LIKE '%" + valor + "%'";
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
                Usuarios us = new Usuarios();
                us.setId(rs.getInt("id"));
                us.setUsuario(rs.getString("usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setCaja(rs.getString("caja"));
                us.setRol(rs.getString("rol"));
                us.setEstado(rs.getString("estado"));
                listaUsers.add(us);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaUsers;
    }
   
   // Modificar registro
   public boolean modificar(Usuarios us) {
       String sql = "UPDATE Usuarios SET usuario = ?, nombre = ?, caja =?, rol = ? WHERE id = ?";
       try {
           con = cn.getConexion();
           ps = con.prepareStatement(sql);
           ps.setString(1, us.getUsuario());
           ps.setString(2, us.getNombre());
           ps.setString(3, us.getCaja());
           ps.setString(4, us.getRol());
           ps.setInt(5, us.getId());
           ps.execute();
           return true;
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           return false;
       }
   }
   
   public boolean accion(String estado, int id) {
       String sql = "UPDATE Usuarios SET estado = ? WHERE id = ?";
       try {
           con = cn.getConexion();
           ps = con.prepareStatement(sql);
           ps.setString(1,estado);
           ps.setInt(2, id);
           ps.execute();
           return true;
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           return false;
        }
   }
}
