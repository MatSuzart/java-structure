package dto;
public class tbusuarioDto {
    private int idusuarios;
    private String nome;
    private String email;
    private String senha;

    public tbusuarioDto(int idusuarios, String nome, String email, String senha) {
        this.idusuarios = idusuarios;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public tbusuarioDto() {
    }
    
    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int setIdusuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
