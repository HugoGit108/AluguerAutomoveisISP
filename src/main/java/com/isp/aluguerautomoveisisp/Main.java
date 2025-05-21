package com.isp.aluguerautomoveisisp;

import com.rentcar.gestaoaluguer.Automovel;
import com.rentcar.gestaoaluguer.Cliente;
import com.rentcar.gestaoaluguer.Aluguer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Automovel> automoveis = new ArrayList<>();
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static List<Aluguer> alugueres = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== Gestão de Aluguer =====");
            System.out.println("1. Inserir Automóvel");
            System.out.println("2. Inserir Cliente");
            System.out.println("3. Listar Automóveis");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Alterar Automóvel");
            System.out.println("6. Eliminar Automóvel");
            System.out.println("7. Alterar Cliente");
            System.out.println("8. Eliminar Cliente");

            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    inserirAutomovel(scanner);
                    break;
                case 2:
                    inserirCliente(scanner);
                    break;
                case 3:
                    listarAutomoveis();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    alterarAutomovel(scanner);
                    break;
                case 6:
                    eliminarAutomovel(scanner);
                    break;
                case 7:
                    alterarCliente(scanner);
                    break;
                case 8:
                    eliminarCliente(scanner);
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void inserirAutomovel(Scanner scanner) {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        for (Automovel a : automoveis) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println("Erro: Matrícula já existente.");
                return;
            }
        }

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        System.out.print("Cilindrada: ");
        int cilindrada = scanner.nextInt();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Valor por dia: ");
        double valorDia = scanner.nextDouble();
        scanner.nextLine(); // limpar buffer

        Automovel automovel = new Automovel(marca, modelo, cor, cilindrada, ano, matricula, valorDia);
        automoveis.add(automovel);
        System.out.println("Automóvel inserido com sucesso.");
    }
    
    private static void alterarAutomovel(Scanner scanner) {
        System.out.print("Matrícula do automóvel a alterar: ");
        String matricula = scanner.nextLine();

        for (Automovel a : automoveis) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.print("Nova marca: ");
                a.setMarca(scanner.nextLine());
                System.out.print("Novo modelo: ");
                a.setModelo(scanner.nextLine());
                System.out.print("Nova cor: ");
                a.setCor(scanner.nextLine());
                System.out.print("Nova cilindrada: ");
                a.setCilindrada(scanner.nextInt());
                System.out.print("Novo ano: ");
                a.setAno(scanner.nextInt());
                System.out.print("Novo valor por dia: ");
                a.setValorDia(scanner.nextDouble());
                scanner.nextLine(); // limpar buffer
                System.out.println("Automóvel alterado com sucesso.");
                return;
            }
        }

        System.out.println("Automóvel não encontrado.");
    }
    
    
    private static void alterarCliente(Scanner scanner) {
        if (clientes.isEmpty()) {
            System.out.println("Não existem clientes registados.");
            return;
        }

        System.out.println("==== Lista de Clientes ====");
        for (Cliente c : clientes) {
            System.out.println("Nome: " + c.getNome() + " | CC: " + c.getCc() + " | Carta: " + c.getCartaConducao());
        }

        System.out.print("Carta de condução do cliente a alterar: ");
        String carta = scanner.nextLine();

        for (Cliente c : clientes) {
            if (c.getCartaConducao().equalsIgnoreCase(carta)) {
                System.out.print("Novo nome: ");
                c.setNome(scanner.nextLine());
                System.out.print("Nova morada: ");
                c.setMorada(scanner.nextLine());
                System.out.print("Novo CC: ");
                c.setCc(scanner.nextLine());

                System.out.println("Cliente alterado com sucesso.");
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }

    
    private static void eliminarCliente(Scanner scanner) {
        System.out.print("Carta de condução do cliente a eliminar: ");
        String carta = scanner.nextLine();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCartaConducao().equalsIgnoreCase(carta)) {
                clientes.remove(i);
                System.out.println("Cliente eliminado com sucesso.");
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }


    
    private static void eliminarAutomovel(Scanner scanner) {
        if (automoveis.isEmpty()) {
            System.out.println("Não existem automóveis registados.");
            return;
        }

        System.out.println("==== Lista de Automóveis ====");
        for (Automovel a : automoveis) {
            System.out.println("Marca: " + a.getMarca() + " | Modelo: " + a.getModelo() +
                               " | Matrícula: " + a.getMatricula());
        }

        System.out.print("Matrícula do automóvel a eliminar: ");
        String matricula = scanner.nextLine();

        for (int i = 0; i < automoveis.size(); i++) {
            if (automoveis.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                automoveis.remove(i);
                System.out.println("Automóvel eliminado com sucesso.");
                return;
            }
        }

        System.out.println("Automóvel não encontrado.");
    }




    private static void inserirCliente(Scanner scanner) {
        System.out.print("Carta de Condução: ");
        String carta = scanner.nextLine();
        for (Cliente c : clientes) {
            if (c.getCartaConducao().equalsIgnoreCase(carta)) {
                System.out.println("Erro: Carta de condução já registada.");
                return;
            }
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Morada: ");
        String morada = scanner.nextLine();
        System.out.print("CC: ");
        String cc = scanner.nextLine();

        Cliente cliente = new Cliente(nome, morada, cc, carta);
        clientes.add(cliente);
        System.out.println("Cliente inserido com sucesso.");
    }

    private static void listarAutomoveis() {
        if (automoveis.isEmpty()) {
            System.out.println("Nenhum automóvel registado.");
        } else {
            for (Automovel a : automoveis) {
                System.out.println(a);
            }
        }
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente registado.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }
}
    