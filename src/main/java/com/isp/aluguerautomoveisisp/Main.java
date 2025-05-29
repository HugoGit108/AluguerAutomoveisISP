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
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Eliminar Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    inserirCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
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
        System.out.print("Carta de Condução: ");
        String carta = scanner.nextLine().trim();
       
        // Verificar duplicação da carta de condução 
        for (Cliente c : clientes) {
            if (c.getCartaConducao().equalsIgnoreCase(carta)) {
                System.out.println("Cliente com esta carta de condução já existe.");
                return;
            }
        }
        System.out.print("Vat/Nif: ");
        String Nif = scanner.nextLine().trim();
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Morada: ");
        String morada = scanner.nextLine().trim();

        System.out.print("Cartão de Cidadão (CC): ");
        String cc = scanner.nextLine().trim();


        // Validação de campos vazios
        if (nome.isEmpty() || morada.isEmpty() || cc.isEmpty() || carta.isEmpty()|| Nif.isEmpty()) {
            System.out.println("Nenhum campo pode estar vazio.");
            return;
        }

        

        Cliente novo = new Cliente(nome, morada, cc, carta, Nif);
        clientes.add(novo);
        System.out.println("Cliente inserido com sucesso.");
    }
    
    private static void alterarCliente() {
        System.out.print("Carta de condução do cliente a alterar: ");
        String carta = scanner.nextLine().trim();

        Cliente clienteEncontrado = null;

        // Procura o cliente pela carta de condução
        for (Cliente c : clientes) {
            if (c.getCartaConducao().equalsIgnoreCase(carta)) {
                clienteEncontrado = c;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Deixe em branco para manter o valor atual do campo.");

        System.out.print("Nome (" + clienteEncontrado.getNome() + "): ");
        String nome = scanner.nextLine().trim();
        if (!nome.isEmpty()) {
            clienteEncontrado.setNome(nome);
        }
        System.out.print("Nif/Vat (" + clienteEncontrado.getNif() + "): ");
        String Nif = scanner.nextLine().trim();
        if (!Nif.isEmpty()) {
            clienteEncontrado.setNif(Nif);
        }

        System.out.print("Morada (" + clienteEncontrado.getMorada() + "): ");
        String morada = scanner.nextLine().trim();
        if (!morada.isEmpty()) {
            clienteEncontrado.setMorada(morada);
        }

        System.out.print("CC (" + clienteEncontrado.getCc() + "): ");
        String cc = scanner.nextLine().trim();
        if (!cc.isEmpty()) {
            clienteEncontrado.setCc(cc);
        }

        System.out.print("Carta de condução (" + clienteEncontrado.getCartaConducao() + "): ");
        String novaCarta = scanner.nextLine().trim();
        if (!novaCarta.isEmpty()) {
            // Verifica se a nova carta já existe para outro cliente
            for (Cliente c : clientes) {
                if (c.getCartaConducao().equalsIgnoreCase(novaCarta) && c != clienteEncontrado) {
                    System.out.println("Já existe um cliente com essa carta de condução.");
                    return;
                }
            }
            clienteEncontrado.setCartaConducao(novaCarta);
        }

        System.out.println("Cliente alterado com sucesso.");
    }



    private static void listarClientes() {
        if (clientes.isEmpty()) {
         System.out.println("Não existem clientes registados.");
        } else {
            System.out.println("===== Lista de Clientes =====");
            for (Cliente c : clientes) {
            System.out.println(c);
            }
        }
    }


    private static void eliminarCliente() {
        System.out.print("Carta de Condução do cliente a eliminar: ");
        String carta = scanner.nextLine().trim();

        if (clientes.isEmpty()) {
            System.out.println("Não existem clientes registados.");
            return;
        }

        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente c = iterator.next();
            if (c.getCartaConducao().equalsIgnoreCase(carta)) {
                iterator.remove();
                System.out.println("Cliente eliminado com sucesso.");
                return;
            }
        }

        System.out.println("Cliente não encontrado.");
    }



    private static void inserirAutomovel() {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine().trim();

        // Verifica se já existe um automóvel com esta matrícula
        for (Automovel a : automoveis) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println("Automóvel já existe.");
                return;
            }
        }

        // Introdução dos restantes dados
        System.out.print("Marca: ");
        String marca = scanner.nextLine().trim();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine().trim();

        System.out.print("Cor: ");
        String cor = scanner.nextLine().trim();

        System.out.print("Cilindrada (cc): ");
        int cilindrada;
        try {
            cilindrada = Integer.parseInt(scanner.nextLine().trim());
            if (cilindrada <= 0) {
                System.out.println("A cilindrada deve ser um número positivo.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Cilindrada inválida.");
            return;
        }

        System.out.print("Ano de aquisição: ");
        int ano;
        try {
            ano = Integer.parseInt(scanner.nextLine().trim());
            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
            if (ano > anoAtual) {
                System.out.println("Ano inválido.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("O ano deve ser um número válido.");
            return;
        }


        // Validação de campos obrigatórios
        if (marca.isEmpty() || modelo.isEmpty() || cor.isEmpty()) {
            System.out.println("Marca, modelo e cor não podem estar vazios.");
            return;
        }

        // Criação do objeto e adição à lista
        Automovel novo = new Automovel(matricula, marca, modelo, cor, cilindrada, ano);
        automoveis.add(novo);
        System.out.println("Automóvel inserido com sucesso.");

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
