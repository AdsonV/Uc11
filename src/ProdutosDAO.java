import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    String sql = ("INSERT INTO produtos (id,nome,valor,status)" + " VALUES (?,?,?,?)");
    
    Connection conn;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto) throws ClassNotFoundException{
        
        try {
            
            conectaDAO.connectDB();
        
        PreparedStatement stt = conn.prepareStatement(sql);
        
                stt.setInt(1,produto.getId());
                stt.setString(2,produto.getNome().trim());
                stt.setInt(3,produto.getValor());
                stt.setString(4,produto.getStatus());
                stt.execute();
                
                 } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "VOCÊ INSERIU ALGUM DADO INCORRETO.", "ERRO.", JOptionPane.INFORMATION_MESSAGE);
        }
        conectaDAO.desconectar();
}
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }       
}