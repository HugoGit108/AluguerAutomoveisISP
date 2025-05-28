package com.isp.aluguerautomoveisisp;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.*;

public class Main {
    
        private static final Scanner scanner = new Scanner(System.in);
        private static final List<Cliente> clientes = new ArrayList<>();
        private static final List<Automovel> automoveis = new ArrayList<>();
        private static final List<Aluguer> alugueres = new ArrayList<>();
        private static final double PRECO_FIXO_POR_DIA = 50.0;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Menu Clientes");
            System.out.println("2. Menu Automóveis");
            System.out.println("3. Menu Aluguer");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            // menu inicial -> depois vai sair daqui para fazer parte visual
            switch (opcao) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuAutomoveis();
                    break;
                case 3:
                    menuAluguer();
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuClientes() {
        int opcao;
        do {
            System.out.println("\n--- Menu Clientes ---");
            System.out.println("1. Inserir Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Eliminar Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    inserirCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuAutomoveis() {
        int opcao;
        do {
            System.out.println("\n--- Menu Automóveis ---");
            System.out.println("1. Inserir Automóvel");
            System.out.println("2. Listar Automóveis");
            System.out.println("3. Eliminar Automóvel");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    inserirAutomovel();
                    break;
                case 2:
                    listarAutomoveis();
                    break;
                case 3:
                    eliminarAutomovel();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuAluguer() {
        int opcao;
        do {
            System.out.println("\n--- Menu Aluguer ---");
            System.out.println("1. Criar Aluguer");
            System.out.println("2. Listar Alugueres");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    criarAluguer();
                    break;
                case 2:
                    listarAlugueres();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void inserirCliente() {
        System.out.print("NIF: ");
        String nif = scanner.nextLine();
        for (Cliente c : clientes) {
            if (c.getNif().equals(nif)) {
                System.out.println("Cliente já existe.");
                return;
            }
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Carta de Condução: ");
        String carta = scanner.nextLine();

        Cliente novo = new Cliente(nome, nif, carta);
        clientes.add(novo);
        System.out.println("Cliente inserido com sucesso.");
    }

    private static void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    private static void eliminarCliente() {
        System.out.print("NIF do cliente a eliminar: ");
        String nif = scanner.nextLine();
        clientes.removeIf(c -> c.getNif().equals(nif));
        System.out.println("Cliente removido.");
    }

    private static void inserirAutomovel() {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine().trim();

        // Verifica se a matrícula já existe na lista de automóveis
        for (Automovel a : automoveis) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println("Automóvel já existe.");
                return;
            }
        }

        System.out.print("Marca: ");
        String marca = scanner.nextLine().trim();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine().trim();

        // Verifica se os campos marca e modelo estão vazios
        if (marca.isEmpty() || modelo.isEmpty()) {
            System.out.println("Marca e/ou modelo não podem estar vazios.");
            return;
        }

        System.out.print("Ano: ");
        int ano;
        try {
            ano = Integer.parseInt(scanner.nextLine());

            // validar a data
            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
            if (ano < 1880 || ano > anoAtual) {
                System.out.println("Ano inválido. Deve estar entre 1900 e " + anoAtual + ".");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("O ano deve ser um número inteiro.");
            return;
        }

        Automovel novo = new Automovel(matricula, marca, modelo, ano);
        automoveis.add(novo);

        System.out.println("Automóvel inserido com sucesso: " +
            novo.getMarca() + " " + novo.getModelo() + " (" + novo.getAno() + ")");

    }

    private static void listarAutomoveis() {
        for (Automovel a : automoveis) {
            System.out.println(a);
        }
    }

    private static void eliminarAutomovel() {
        System.out.print("Matrícula do automóvel a eliminar: ");
        String mat = scanner.nextLine();
        automoveis.removeIf(a -> a.getMatricula().equalsIgnoreCase(mat));
        System.out.println("Automóvel removido.");
    }

    private static void criarAluguer() {
        System.out.print("NIF do cliente: ");
        String nif = scanner.nextLine();
        Cliente cliente = clientes.stream().filter(c -> c.getNif().equals(nif)).findFirst().orElse(null);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        // Verifica se já tem um aluguer ativo
        for (Aluguer a : alugueres) {
            if (a.getCliente().equals(cliente)) {
                if (!a.getDataFim().isBefore(LocalDate.now())) {
                    System.out.println("Este cliente já tem um aluguer ativo.");
                    return;
                }
            }
        }

        System.out.print("Matrícula do automóvel: ");
        String mat = scanner.nextLine();
        Automovel carro = automoveis.stream().filter(a -> a.getMatricula().equalsIgnoreCase(mat)).findFirst().orElse(null);
        if (carro == null) {
            // do later -> fazer aqui loop while ate colocar a matricula direita
            System.out.println("Automóvel não encontrado.");
            return;
        }

        // Verificar se está disponível
        for (Aluguer a : alugueres) {
            if (a.getAutomovel().equals(carro)) {
                if (!a.getDataFim().isBefore(LocalDate.now())) {
                    // do later -> fazer aqui loop while ate colocar a matricula direita

                    System.out.println("Este automóvel está ocupado.");
                    return;
                }
            }
        }


        System.out.print("Data início (AAAA-MM-DD): ");
        LocalDate inicio = LocalDate.parse(scanner.nextLine());
        System.out.print("Data fim (AAAA-MM-DD): ");
        LocalDate fim = LocalDate.parse(scanner.nextLine());
        if (fim.isBefore(inicio)) {
            System.out.println("Data de fim inválida.");
            return;
        }

        Aluguer novo = new Aluguer(cliente, carro, inicio, fim);
        alugueres.add(novo);
        System.out.println("Aluguer criado: " + novo);
    }

    private static void listarAlugueres() {
        for (Aluguer a : alugueres) {
            System.out.println(a);
        }
    }
}
