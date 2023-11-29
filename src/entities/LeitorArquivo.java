package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorArquivo {
    public static ArrayList<Produto> lerProdutos(String arquivo) {
        ArrayList<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0].trim());
                String tipo = partes[1].trim();
                String marca = partes[2].trim();
                String modelo = partes[3].trim();
                double preco = Double.parseDouble(partes[4].trim());

                Produto produto = null;
                if (tipo.equals("Instrumento")) {
                    String tipoInstrumento = partes[5].trim();
                    produto = new Instrumento(id, tipo, marca, modelo, preco, tipoInstrumento);
                } else if (tipo.equals("Acessorio")) {
                    String compativelCom = partes[5].trim();
                    String material = partes[6].trim();
                    produto = new Acessorio(id, tipo, marca, modelo, preco, compativelCom, material);
                } else {
                    continue;
                }

                produtos.add(produto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public static ArrayList<Cliente> lerClientes(String arquivo) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0].trim();
                String cpf = partes[1].trim();
                String email = partes[2].trim();
                String telefone = partes[3].trim();

                Cliente cliente = new Cliente(nome, cpf, email, telefone);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
