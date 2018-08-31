package controller;

import dto.tbusuarioDto;
import java.sql.SQLException;
import java.util.List;
import model.tbusuarioDao;

public class UsuarioFaces {

    private final tbusuarioDao userdao = new tbusuarioDao();
    private tbusuarioDto usuarioSelecionado;
    private List<tbusuarioDto> usuarios = null;
    
    public UsuarioFaces() {
    }
    
    public List<tbusuarioDto> getUsuario() throws SQLException, ClassNotFoundException {
        if(this.usuarios == null){
            usuarios = userdao.getListaTodosOsUsuarios();
        }
        return usuarios;
    }
    
    public tbusuarioDto getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(tbusuarioDto usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }
    
    public String preparaInclusao(){
        this.usuarioSelecionado = new tbusuarioDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao() throws SQLException, ClassNotFoundException{
        this.userdao.setAdicionar(usuarioSelecionado);
        this.usuarios=null;
        return "index";
    }
    
    public String finalizaDelecao() throws SQLException, ClassNotFoundException{
        this.userdao.setDeletar(usuarioSelecionado);
        this.usuarios=null;
        return "refresh";
    }
    
    public String finalizaEdicao() throws SQLException, ClassNotFoundException{
        this.userdao.setAlterar(usuarioSelecionado);
        this.usuarios=null;
        return "voltaParaListagem";
    }
}
