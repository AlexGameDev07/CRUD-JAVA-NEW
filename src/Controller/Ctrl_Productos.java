package Controller;

import View.jfrm_productos;
import Model.Producto;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ctrl_Productos implements MouseListener{
    //1- llamar a la vista y al modelo.
    
    private jfrm_productos Vista;
    private Producto Modelo;
    
    //2- Crear el constructor de la clase
    public Ctrl_Productos(jfrm_productos Vista, Producto Modelo){
        this.Vista = Vista;
        this.Modelo = Modelo;
        
        //Mandar a llamar al botón
        Vista.btnGuardar.addMouseListener(this);
        Vista.tblProductos.addMouseListener(this);
        Modelo.Mostrar(Vista.tblProductos);
    }

    //Mandar a llamar todos los eventos heredados
    @Override
    public void mouseClicked(MouseEvent e) {
        //Programar el evento, si el origen del evento es el boton
        if(e.getSource() == Vista.btnGuardar){
            Modelo.setNombre(Vista.txtNombre.getText());
            Modelo.setCategoría(Vista.txtCategoría.getText());
            Modelo.setPrecio(Double.parseDouble(Vista.txtPrecio.getText()));
            
            //Se ejecuta el método Guardar
            Modelo.Guardar();
            Modelo.Mostrar(Vista.tblProductos);
            
            LimpiarCampos();
            
            
        }
    }
    
    public void LimpiarCampos(){
        Vista.txtCategoría.setText("");
            Vista.txtNombre.setText("");
            Vista.txtPrecio.setText("");
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
            
}
