/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Classes;

public class Usuario extends Perfil {

    private String senha;
    private String cargo;

    public Usuario(int id, String nome, String senha) {
        super(id, nome);
        this.senha = senha;
    }
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    

    public Usuario(int id, String nome, String cpf, char sexo, int idade, String email, String senha, String cargo) {
        super(id, nome, cpf, sexo, idade, email);
        this.senha = senha;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                ", Nome: " + getNome() +
                ", CPF: " + getCpf() +
                ", Idade: " + getIdade() +
                ", " + getCargo();
    }

    
}
