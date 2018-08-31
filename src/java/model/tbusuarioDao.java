package model;

import dto.tbusuarioDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class tbusuarioDao extends DaoUtil{
    
    public tbusuarioDao(){
        super();
    }
    
    public boolean setAdicionar(tbusuarioDto usuarios) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO usuarios (nome, email, senha)VALUES"+"(?, ?, ?)";
        
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setString(1,usuarios.getNome());
        ps.setString(2,usuarios.getEmail());
        ps.setString(3,usuarios.getSenha());
        int ret = ps.executeUpdate();
        ps.close();
        //super.getFechaConexao();
        
        return ret > 0;
    }
    
    public boolean setAlterar(tbusuarioDto usuarios) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE usuarios SET nome=?, email=?, senha=?, WHERE idusuarios=?";
        
        PreparedStatement ps = super.getPreparedStatement(sql);

        ps.setString(1,usuarios.getNome());
        ps.setString(2,usuarios.getEmail());
        ps.setString(3,usuarios.getSenha());
        ps.setInt(4, usuarios.getIdusuarios());
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaConexao();
        
        return ret > 0;
    }
        
    public boolean setDeletar(tbusuarioDto produto) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM usuarios WHERE idusuarios=?";
    
       PreparedStatement ps = super.getPreparedStatement(sql);
       ps.setInt(1, produto.getIdusuarios());
       int ret = ps.executeUpdate();
       ps.close();
       //super.getFechaConexao();
        
        return ret > 0;
    }
    
    public List<tbusuarioDto> getListaTodosOsUsuarios() throws SQLException, ClassNotFoundException{
        List<tbusuarioDto> lstRetDto = new LinkedList<tbusuarioDto>();
        String sql = "SELECT idusuarios, nome, email, senha FROM usuarios";
        ResultSet rs = super.getStatement().executeQuery(sql);
    
        while(rs.next() ){
            lstRetDto.add(new tbusuarioDto(rs.getInt("idusuarios"), rs.getString("nome"), rs.getString("email"), rs.getString("senha")));
        }
        rs.close();
        //super.getFechaConexao();
        return lstRetDto;
    }
    
    public tbusuarioDto getBuscaId(tbusuarioDto usuarios) throws ClassNotFoundException, SQLException{
        tbusuarioDto retornoDto = new tbusuarioDto();
        String sql = "SELECT idusuarios, nome, email, senha FROM usuarios";
            
        
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, usuarios.setIdusuarios());
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next() ){
            retornoDto = (new tbusuarioDto(rs.getInt("idusuarios"), rs.getString("nome"), rs.getString("email"), rs.getString("senha")));
        }
        rs.close();
        //super.getFechaConexao();
        return retornoDto; 
    }

}