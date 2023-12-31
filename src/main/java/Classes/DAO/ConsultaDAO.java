/*
Nomes e matrículas:
Felipe Lazzarini Cunha - 201876040
Pedro Detoni Pereira - 202176031
 */
package Classes.DAO;

import Classes.Consulta;
import Classes.Data.Persistencia;

import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO extends GenericDAO<Consulta>{

    // Construtor para ler o arquivo e carregar a lista de Consultas
    public ConsultaDAO() {
        Persistencia persistencia = new Persistencia();
        List<Consulta> consultas = persistencia.lerArquivoConsulta("src/main/java/Classes/Data/consultas.json");
        if (consultas == null) {
            consultas = new ArrayList<>();
        }
        Banco.Consulta = consultas;
    }

    public void insert(Consulta consulta){
        Banco.Consulta.add(consulta);
    }
    
    
    public boolean update(Consulta consulta){
        
        for (int i = 0; i < Banco.Consulta.size(); i++) {
            if(idSaoIguais(Banco.Consulta.get(i),consulta)){
                Banco.Consulta.set(i, consulta);
                return true;
            }
        }
        return false;      

    }
    
    
    public boolean delete(Consulta Consulta){
        for (Consulta ConsultaLista : Banco.Consulta) {
            if(idSaoIguais(ConsultaLista,Consulta)){
                Banco.Consulta.remove(ConsultaLista);
                return true;
            }
        }
        return false;
    }

    //Ajuste para não ocorrer de retorno null em multiplas classes que usam Consulta
    public List<Consulta> selectAll(){
        List<Consulta> consultas = Banco.Consulta;
        if (consultas == null) {
            consultas = new ArrayList<>();
        }
        return consultas;
    }
    
    
    private boolean idSaoIguais(Consulta consulta, Consulta consultaC) {
        return consulta.getId() ==  consultaC.getId();
    }

    public boolean cpfMedicoExiste(String cpf, int idIgnorado) {
        for (Consulta consulta : Banco.Consulta) {
            if (consulta.getMedicoResponsavel().getCpf().equals(cpf) && consulta.getId() != idIgnorado) {
                return true;
            }
        }
        return false;
    }

    public int getUltimoId() {
        int maiorId = 0;
        for (Consulta consulta : Banco.Consulta) {
            maiorId = Math.max(maiorId, consulta.getId());
        }
        return maiorId + 1;
    }
}
