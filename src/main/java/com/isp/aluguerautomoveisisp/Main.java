package com.isp.aluguerautomoveisisp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== Gestão de Aluguer =====");
            System.out.println("1. Inserir Automóvel");
            System.out.println("2. Inserir Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("Inserir automóvel (em breve)");
                    break;
                case 2:
                    System.out.println("Inserir cliente (em breve)");
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
