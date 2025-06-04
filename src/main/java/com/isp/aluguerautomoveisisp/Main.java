package com.isp.aluguerautomoveisisp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Automovel> automoveis = new ArrayList<>();
    private static List<Aluguer> alugueres = new ArrayList<>();
    private static final double PRECO_FIXO_POR_DIA = 50.0;
    

    public static void main(String[] args) {
        
        automoveis.add(new Automovel("1234AAA", "Toyota", "Yaris", "Branco", 1200, 2021));
        automoveis.add(new Automovel("5678BBB", "Renault", "Clio", "Cinza", 1300, 2020));
        automoveis.add(new Automovel("9012CCC", "BMW", "Serie 1", "Preto", 1500, 2022));
        automoveis.add(new Automovel("3456DDD", "Volkswagen", "Golf", "Azul", 1400, 2019));
        automoveis.add(new Automovel("7890EEE", "Peugeot", "208", "Vermelho", 1200, 2023));

        int opcao;
        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Menu Clientes");
            System.out.println("2. Menu Automóveis");
            System.out.println("3. Menu Aluguer");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

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
            System.out.println("3. Devolver Aluguer");
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
                case 3:
                    devolverAluguer();
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

        if (nome.isEmpty() || morada.isEmpty() || cc.isEmpty() || carta.isEmpty() || Nif.isEmpty()) {
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

        // matrícula vazia
        if (matricula.isEmpty()) {
            System.out.println("A matrícula não pode estar vazia.");
            return;
        }

        // Verifica se já existe um automóvel com esta matrícula
        for (Automovel a : automoveis) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println("Automóvel com esta matrícula já existe.");
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
            int anoAtual = 2025; // Limite conforme apontamentos
            if (ano > anoAtual) {
                System.out.println("Ano inválido. Não pode ser superior a 2025.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("O ano deve ser um número válido.");
            return;
        }

        if (marca.isEmpty() || modelo.isEmpty() || cor.isEmpty()) {
            System.out.println("Marca, modelo e cor não podem estar vazios.");
            return;
        }

        Automovel novo = new Automovel(matricula, marca, modelo, cor, cilindrada, ano);
        automoveis.add(novo);
        System.out.println("Automóvel inserido com sucesso.");
    }

    private static void listarAutomoveis() {
        if (automoveis.isEmpty()) {
            System.out.println("Não existem automóveis registados.");
        } else {
            System.out.println("===== Lista de Automóveis =====");
            for (Automovel a : automoveis) {
                System.out.println(a);
            }
        }
    }

    private static void eliminarAutomovel() {
        System.out.print("Matrícula do automóvel a eliminar: ");
        String mat = scanner.nextLine();
        boolean removed = automoveis.removeIf(a -> a.getMatricula().equalsIgnoreCase(mat));
        if (removed) {
            System.out.println("Automóvel removido.");
        } else {
            System.out.println("Automóvel não encontrado.");
        }
    }

    
    private static void criarAluguer() {
        System.out.print("Carta de condução do cliente: ");
        String carta = scanner.nextLine().trim();

        Cliente cliente = encontrarClientePorCarta(carta);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Data de início (AAAA-MM-DD): ");
        LocalDate dataInicio;
        try {
            dataInicio = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return;
        }

        System.out.print("Data de fim (AAAA-MM-DD): ");
        LocalDate dataFim;
        try {
            dataFim = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return;
        }

        if (dataFim.isBefore(dataInicio) || dataFim.isEqual(dataInicio)) {
            System.out.println("A data de fim deve ser posterior à data de início.");
            return;
        }

        // Mostrar veículos disponíveis para esse período
        List<Automovel> disponiveis = automoveis.stream()
            .filter(v -> veiculoDisponivel(v.getMatricula(), dataInicio, dataFim))
            .toList();

        if (disponiveis.isEmpty()) {
            System.out.println("Não existem veículos disponíveis para aluguer nesse período.");
            return;
        }

        for (Automovel a : disponiveis) {
            System.out.println(a);
        }

        System.out.print("Matrícula do veículo a alugar: ");
        String matricula = scanner.nextLine().trim();

        Automovel veiculo = automoveis.stream()
                .filter(a -> a.getMatricula().equalsIgnoreCase(matricula))
                .findFirst().orElse(null);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        if (!veiculoDisponivel(matricula, dataInicio, dataFim)) {
            System.out.println("Este veículo já está alugado ou indisponível para o período indicado.");
            return;
        }

        Aluguer novo = new Aluguer(carta, matricula, dataInicio, dataFim);
        alugueres.add(novo);

        System.out.println("Aluguer criado com sucesso:");
        System.out.println(novo);
    }
    
    private static boolean veiculoDisponivel(String matricula, LocalDate dataInicio, LocalDate dataFim) {
        for (Aluguer a : alugueres) {
            if (a.getMatriculaVeiculo().equalsIgnoreCase(matricula)) {
                LocalDate devolucao = a.getDataDevolucao();

                // Se não devolvido, veículo está ocupado
                if (devolucao == null) {
                    // Verifica sobreposição do período do aluguer ativo com o pedido
                    if (!(dataFim.isBefore(a.getInicio()) || dataInicio.isAfter(a.getFim()))) {
                        return false;
                    }
                } else {
                    // Se devolvido, novo aluguer deve começar após a data de devolução
                    if (!dataInicio.isAfter(devolucao)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private static Cliente encontrarClientePorCarta(String carta) {
        for (Cliente c : clientes) {
            if (c.getCartaConducao().equalsIgnoreCase(carta)) {
                return c;
            }
        }
        return null;
    }

    private static void listarAlugueres() {
        if (alugueres.isEmpty()) {
            System.out.println("Não existem alugueres registados.");
            return;
        }
        System.out.println("===== Lista de Alugueres =====");
        for (Aluguer a : alugueres) {
            System.out.println(a);
        }
    }


    private static void devolverAluguer() {
        System.out.print("Matrícula do veículo: ");
        String matricula = scanner.nextLine().trim();

        // Procurar aluguer ativo para esse veículo (sem data de devolução)
        Aluguer aluguerAtivo = alugueres.stream()
            .filter(a -> a.getMatriculaVeiculo().equalsIgnoreCase(matricula) && a.getDataDevolucao() == null)
            .findFirst()
            .orElse(null);

        if (aluguerAtivo == null) {
            System.out.println("Nenhum aluguer ativo encontrado para este veículo.");
            return;
        }

        System.out.print("Data de devolução (AAAA-MM-DD): ");
        LocalDate dataDevolucao;
        try {
            dataDevolucao = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return;
        }

        if (dataDevolucao.isBefore(aluguerAtivo.getInicio())) {
            System.out.println("Data de devolução não pode ser antes da data de início do aluguer.");
            return;
        }

        aluguerAtivo.setDataDevolucao(dataDevolucao);

        long dias = java.time.temporal.ChronoUnit.DAYS.between(
            aluguerAtivo.getInicio(), aluguerAtivo.getFim());

        double valor = dias * PRECO_FIXO_POR_DIA;

        System.out.println("Aluguer devolvido com sucesso:");
        System.out.println(aluguerAtivo);
        System.out.printf("Valor a pagar: %.2f€ (%d dias × %.2f€/dia)%n", valor, dias, PRECO_FIXO_POR_DIA);
    }

    
    private static boolean veiculoDisponivel(String matricula) {
        return alugueres.stream().noneMatch(a ->
            a.getMatriculaVeiculo().equalsIgnoreCase(matricula) && a.getDataDevolucao() == null
        );
    }

    
    private static boolean veiculoDisponivelNoPeriodo(String matricula, LocalDate inicio, LocalDate fim) {
        return alugueres.stream().noneMatch(a ->
            a.getMatriculaVeiculo().equalsIgnoreCase(matricula) && (
                // Sobreposição de datas
                (a.getDataDevolucao() == null && !inicio.isAfter(a.getFim())) || 
                (a.getDataDevolucao() != null && a.getDataDevolucao().equals(inicio)) // devolvido no mesmo dia
            )
        );
    }

}
