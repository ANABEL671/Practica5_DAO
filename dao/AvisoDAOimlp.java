
package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import com.emergentes.conexionbd.conexionbd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAOimlp extends conexionbd implements AvisoDAO {

    @Override
    public void insert(Aviso aviso) throws Exception {
       try{
        this.conectar();
        String sql = "INSERT into avisos (titulo, contenido) values (?,?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, aviso.getTitulo());
        ps.setString(2, aviso.getContenido());
        ps.executeUpdate();
       }catch(Exception e){
            throw e;
    }finally{
          this.desconectar();
       }
    }

    @Override
    public void update(Aviso aviso) throws Exception {
    try{
        this.conectar();
        String sql = "UPDATE  avisos set titulo=?, contenido=? where id=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, aviso.getTitulo());
        ps.setString(2, aviso.getContenido());
        ps.setInt(3, aviso.getId());
        ps.executeUpdate();
       }catch(Exception e){
            throw e;
    }finally{
          this.desconectar();
       }
    }

    @Override
    public void delete(int id) throws Exception {
         try{
        this.conectar();
        String sql ="DELETE FROM  avisos WHERE id=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
       }catch(Exception e){
            throw e;
    }finally{
          this.desconectar();
       }
    }

    @Override
    public Aviso getById(int id) throws Exception {
        Aviso avi = new Aviso();
         try{
        this.conectar();
        String sql = "SELECT * FROM  avisos WHERE id=? ";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();/* executeQuery devuelve un result set*/
        if(rs.next()){
            avi.setId(rs.getInt("id"));
            avi.setTitulo(rs.getString("titulo"));
            avi.setContenido(rs.getString("contenido"));
        }
       }catch(Exception e){
            throw e;
    }finally{
          this.desconectar();
       }
        return avi;
    }

    @Override
    public List<Aviso> getAll() throws Exception {
        List<Aviso> lista = null;
         try{
        this.conectar();
        String sql = "SELECT * FROM  avisos ";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Aviso>();
        while(rs.next()){
            Aviso avi = new Aviso();
            avi.setId(rs.getInt("id"));
            avi.setTitulo(rs.getString("titulo"));
            avi.setContenido(rs.getString("contenido"));
            lista.add(avi);
        }
        /*rs.close();
        ps.close();*/
       }catch(Exception e){
            throw e;
    }finally{
          this.desconectar();
       }
        return lista;
    }
    
}
