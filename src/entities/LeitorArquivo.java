package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorArquivo {
    public ArrayList<Produto> lerProdutos(String arquivo) {
        ArrayList<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] atributos = linha.split(";");
                int id = Integer.parseInt(atributos[0].trim());
                String tipo = atributos[1].trim();
                String marca = atributos[2].trim();
                String modelo = atributos[3].trim();
                double preco = Double.parseDouble(atributos[4].trim());

                Produto produto = null;
                if (tipo.equals("Instrumento")) {
                    String tipoInstrumento = atributos[5].trim();
                    produto = new Instrumento(id, tipo, marca, modelo, preco, tipoInstrumento);
                } else {
                    String compativelCom = atributos[5].trim();
                    String material = atributos[6].trim();
                    produto = new Acessorio(id, tipo, marca, modelo, preco, compativelCom, material);
                }

                produtos.add(produto);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return produtos;
    }

    public ArrayList<Cliente> lerClientes(String arquivo) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] atributos = linha.split(";");
                String nome = atributos[0].trim();
                String cpf = atributos[1].trim();
                String email = atributos[2].trim();
                String telefone = atributos[3].trim();

                Cliente cliente = new Cliente(nome, cpf, email, telefone);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return clientes;
    }
}
