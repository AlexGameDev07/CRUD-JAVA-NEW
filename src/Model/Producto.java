package Model;

import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Producto {
        //parametros
        String UUID_Producto;
        String nombre;
        double precio;
        String categoría;
        
        //Getters y Setters

    public String getUUID_Producto() {
        return UUID_Producto;
    }

    public void setUUID_Producto(String UUID_Producto) {
        this.UUID_Producto = UUID_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String caregoría) {
        this.categoría = caregoría;
    }
    
    public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        java.sql.Connection conexion = Connection.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloPinulito = new DefaultTableModel();
        modeloPinulito.setColumnIdentifiers(new Object[]{"UUID", "Nombre", "Precio", "Categoría"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_Productos");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloPinulito.addRow(new Object[]{rs.getString("UUID"), 
                    rs.getString("Nombre"), 
                    rs.getInt("Precio"), 
                    rs.getString("Categoría")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloPinulito);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        java.sql.Connection conexion = Connection.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO TB_Productos(UUID, Nombre, Precio, Categoría) VALUES (?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addProducto.setString(1, UUID.randomUUID().toString());
            addProducto.setString(2, getNombre());
            addProducto.setDouble(3, getPrecio());
            addProducto.setString(4, getCategoría());
 
            //Ejecutar la consulta
            addProducto.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo Persona:metodo guardar " + ex);
        }
    }
}
