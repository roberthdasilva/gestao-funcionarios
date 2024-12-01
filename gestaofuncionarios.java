package com.mycompany.gestaofuncionarios;

import java.util.Scanner;

public class gestaofuncionarios {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nomes[] = new String[100];
        String cargos[] = new String[100];
        int idades[] = new int[100];
        double salarios [] = new double[100];
        int totalFuncionarios = 0;
        int op;
        
        do {
            System.out.println("=======MENU=======");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Pesquisa por Cargo");
            System.out.println("4 - Remover Funcionários");
            System.out.println("5 - Média Salarial");
            System.out.println("6 - Sair");
            System.out.print("Digite uma opção: ");
            op = teclado.nextInt();
            System.out.println(" ");
            
            switch (op){
                case 1:
                    if (totalFuncionarios < nomes.length) {
                        System.out.println("===== Cadastro de Funcionários =====");
                        System.out.print("Nome: ");
                        nomes[totalFuncionarios] = teclado.next();
                        
                        System.out.print("Cargo: ");
                        cargos[totalFuncionarios] = teclado.next();
                        
                        System.out.print("Idade: ");
                        idades[totalFuncionarios] = teclado.nextInt();
                        
                        System.out.print("Salário: ");
                        salarios[totalFuncionarios] = teclado.nextDouble();
                        
                        totalFuncionarios++;
                        
                        System.out.println("===================================");
                        System.out.println("Funcionario Cadastrado com Sucesso.");
                        System.out.println("===================================");
                    } else {
                        System.out.println("Limite de Funcionários Atingidos!");
                    }
                    break;
                    
                case 2:
                    System.out.println("===== Lista de Funcionários =====");
                    for (int i = 0; i < totalFuncionarios; i++) {
                        System.out.println("=====================");
                        System.out.println("Índice: "+ i);
                        System.out.println("Nome: "+ nomes[i]);
                        System.out.println("Cargo: "+ cargos[i]);
                        System.out.println("Idade: "+ idades[i]);
                        System.out.println("Salário: "+ salarios[i]);
                    }
                    break;
                    
                case 3:
                    System.out.println("===== Filtrado por Cargos =====");
                    System.out.print("Digite o cargo para filtrar: ");
                    String cargoFiltro = teclado.next();
                    
                    for (int i = 0; i < totalFuncionarios; i++) {
                        if (cargos[i].equals(cargoFiltro)) {
                            System.out.println("=====================");
                            System.out.println("Nome: "+ nomes[i]);
                            System.out.println("Idade: "+ idades[i]);
                            System.out.println("Salário: "+ salarios[i]);
                        }
                    }
                    break;
                
                case 4:
                    System.out.println("===== Remover Funcionário =====");
                    System.out.print("Digite o índice do funcionário: ");
                    int id_remover = teclado.nextInt();
                    
                    if (id_remover >= 0 && id_remover < totalFuncionarios) {
                        for (int i = id_remover; i < totalFuncionarios - 1; i++) {
                            nomes[i] = nomes[i + 1];
                            cargos[i] = cargos[i + 1];
                            idades[i] = idades[i + 1];
                            salarios[i] = salarios[i + 1];
                        }
                        totalFuncionarios--;
                        
                        System.out.println("===================================");
                        System.out.println("Funcionario Removido com Sucesso.");
                        System.out.println("===================================");
                    } else {
                        System.out.println("Índice Inválido.");
                    }
                    break;
                    
                case 5:
                    if (totalFuncionarios > 0) {
                        double somaSalarios = 0;
                        for (int i = 0; i < totalFuncionarios; i++) {
                            somaSalarios += salarios[i];
                        }
                        System.out.printf("Média Salarial: %.2f \n", somaSalarios / totalFuncionarios);
                    } else {
                        System.out.println("Nenhum Funcionário Cadastrado.");
                    }
                    break;
                    
                case 6:
                    System.out.println("Programa Encerrado. Volte Sempre!");
                    break;
                
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        } while (op != 6);
    }
}
