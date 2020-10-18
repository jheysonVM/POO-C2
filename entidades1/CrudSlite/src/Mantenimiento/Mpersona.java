
package Mantenimiento;

import Entidades.Persona;
import Conexion.conexion;
import java.sql.ResultSet;
import java.util.*;



import java.sql.SQLException;
import java.sql.Statement;



public class Mpersona {
        Statement stmt=null;
        conexion cx = new conexion();
        ResultSet rset= null;
        public void registrarPersona(Persona p){
            String sql="INSERT INTO personas( id, nombres, sexo) VALUES('"+p.getId()+"','"+p.getNombres()+"','"+p.getSexo()+"')";
            try {
                stmt= cx.connect().createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
                cx.connect().close();
                System.out.println("consulta: "+sql);
                System.out.println("Se registro satisdfactoriamente");
                
            }catch(SQLException ex ){
                System.out.println("Capturar error:"+ex.getMessage());
                
            }
        }
        public  List<Persona> listarPersonas(){
            String sql = "select * from personas";
            List<Persona> lp = new ArrayList<Persona>();
            try {
                stmt= cx.connect().createStatement();
                rset=stmt.executeQuery(sql);
                while(rset.next()){
                            Persona p= new Persona();
                            p.setId(Integer.parseInt(rset.getString(1)));
                            p.setNombres(rset.getString(2));
                            p.setSexo(rset.getString(3));
                            lp.add(p);
                            
                }
                {
                    
                }
            }catch(SQLException e){
                System.out.println("Capturar Error: "+e.getMessage());   
            
                
            }
            return lp;
        }
        public void eliminarRegistro(String pid){
            String sql="delete from personas where id ='"+pid+"'";
            try{
                stmt=cx.connect().createStatement();
                stmt.executeUpdate(sql);
            }catch(SQLException e){
                System.out.println("Capturar Error :"+e.getMessage());
                
            }
            
        }
        public void actualizarRegistro(Persona pa){
            String sql="update personas set nombres='"+pa.getNombres()+"','"+pa.getSexo()+"' where id='"+pa.getId()+"'";
            try{
                stmt=cx.connect().createStatement();
                stmt.executeUpdate(sql);
                System.out.println("Se actualizo un registro");
                
            }catch(SQLException e){
                System.out.println("Capturar Error: "+e.getMessage());
                
            }
            
        }
         
        public static void main(String[] args){
            Mpersona mp= new Mpersona();
            Persona p1= new Persona();
            p1.setId(3);
            p1.setNombres("mario");
            p1.setSexo("femenino");
            mp.registrarPersona(p1);
            //mp.listarPersonas();
            //mp.actualizarRegistro(p1);
            System.out.println(mp.listarPersonas().size());
            for (Persona r : mp.listarPersonas()){
                System.out.println(r.getId());
                System.out.println(r.getNombres());
                System.out.println(r.getSexo());
                
                
            }
            
        }
}

        
