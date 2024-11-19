//package com.example.energia;
//
//import com.example.energia.Procedure.CadastroDAO;
//import com.example.energia.Procedure.ConfiguracaoCarroDAO;
//import com.example.energia.Procedure.PontoRecargaDAO;
//import com.example.energia.Procedure.UsuarioDAO;
//import com.example.energia.Procedure.ViagemDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//
//@Component
//public class MainRunner implements CommandLineRunner {
//
//    @Autowired
//    private CadastroDAO cadastroDAO;
//
//    @Autowired
//    private UsuarioDAO usuarioDAO;
//
//    @Autowired
//    private ConfiguracaoCarroDAO configuracaoCarroDAO;
//
//    @Autowired
//    private PontoRecargaDAO pontoRecargaDAO;
//
//    @Autowired
//    private ViagemDAO viagemDAO;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Inserir dados de exemplo
//
//
//        // Inserir Usuário
//        usuarioDAO.inserirUsuario(5, "teste Silva", "teste111@gmaiç.com", "senha111", "Modelo A", 50, 350);
//
//        // Inserir Configuração de Carro
//        configuracaoCarroDAO.inserirConfiguracaoCarro(4, 2, "Modelo A", 400, 0.15);
//
//        // Inserir Ponto de Recarga
//        pontoRecargaDAO.inserirPontoRecarga(4, "Ponto Recarga 1", "Rua B, 456", -23.550520, -46.633308, "Tipo A", 22, "Disponível", 0.75);
//
//        // Inserir Viagem
//        viagemDAO.inserirViagem(4, 2, "São Paulo", "Rio de Janeiro", Date.valueOf("2024-11-20"), 450, "Em andamento");
//
//
//    }
//}
