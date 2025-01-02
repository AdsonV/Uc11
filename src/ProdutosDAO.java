import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;


public class ProdutosDAO {
    
    String sql = ("INSERT INTO produtos (id,nome,valor,status)" + " VALUES (?,?,?,?)");
    Connection conn;
   static  ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    
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
    
    public ArrayList<ProdutosDTO> listarProdutos()throws ClassNotFoundException{
        try{
        
                        conectaDAO.connectDB();
        
                        Statement st1 = conn.createStatement();
                        st1.executeQuery("SELECT * FROM produtos");
                        ResultSet r1 = st1.getResultSet();
                        
                        while (r1.next()) {
                            
                            ProdutosDTO linha = new ProdutosDTO((r1.getInt("id")),(r1.getString("nome")),(r1.getInt("valor")),(r1.getString("status")));
                        
                            listagem.add(linha);
                        }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível ver a lista dos produtos");
        }
        
        return listagem;
    }       
}