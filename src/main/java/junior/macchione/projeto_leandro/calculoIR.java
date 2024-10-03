package junior.macchione.projeto_leandro;

import java.util.Scanner;
/** Classe para realizar o cálculo do imposto de renda, seguindo documentação do projeto!
 * @author Junior Macchione e Caio Ubirajara
 */
public class calculoIR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        double salario;

        do {
            menu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("CÁLCULO MENSAL \n======================== \nInsira o Salário: ");
                    salario = sc.nextDouble();
                    System.out.println();
                    calculoMensal(salario);
                    break;
                case 2:
                    System.out.print("CÁLCULO ANUAL \n======================== \nInsira o Salário: ");
                    salario = sc.nextDouble();
                    System.out.println();
                    calculoAnual(salario);
                    break;
                case 3:
                    System.out.println("Tchau tchau!");
                    break;
                default:
                    System.out.println("INSIRA UMA OPÇÃO VÁLIDA\n");
                    break;
            }

        } while (opcao != 3);

        sc.close();
    }

    //metodo para mostrar o menu
    public static void menu() {
        System.out.print("""
                Programa para Cálcular Imposto de Renda
                [1] Cálcular Salário Mensal
                [2] Cálcular Salário Anual
                [3] Sair
                 
                """);
        System.out.print("Escolha uma opção: ");
    }

    //Metodo para calcular o imposto mensal
    public static double calculoMensal(double salario) {
        double imposto = 0;
        double salarioOriginal = salario;

        if (salario > 0) {
            if (salario > 1903.98) {
                // Faixa de 27.5%
                if (salario > 4664.68) {
                    imposto += (salario - 4664.68) * 0.275;
                    salario = 4664.68;
                    System.out.println("TOTAL DO DESCONTO: R$" + String.format("%.2f", (imposto)));
                }
                // Faixa de 22.5%
                if (salario > 3751.06) {
                    imposto += (salario - 3751.06) * 0.225;
                    salario = 3751.06;
                    System.out.println("TOTAL DO DESCONTO: R$" + String.format("%.2f", (imposto)));
                }
                // Faixa de 15%
                if (salario > 2826.66) {
                    imposto += (salario - 2826.66) * 0.15;
                    salario = 2826.66;
                    System.out.println("TOTAL DO DESCONTO: R$" + String.format("%.2f", (imposto)));
                }
                // Faixa de 7.5%
                if (salario > 1903.98) {
                    imposto += (salario - 1903.98) * 0.075;
                    salario = 1903.98;
                    System.out.println("TOTAL DO DESCONTO: R$" + String.format("%.2f", (imposto)) + "\n");
                }
            } else {
                // Faixa isento
                System.out.println("Isento de Imposto de Renda.");
            }

            System.out.println("O TOTAL DE DESCONTO É: " + String.format("%.2f", (imposto)));

            double aliquotaEfetiva = (imposto / salarioOriginal) * 100;
            System.out.println("ALÍQUOTA EFETIVA: " + String.format("%.2f", aliquotaEfetiva) + "%\n");

        } else {
            // Exibe mensagem caso o salário seja menor ou igual a zero
            System.out.println("INSIRA UM VALOR MAIOR QUE R$0.00\n");
        }

        return salario;
    }

    // Método para calcular o imposto anual
    public static double calculoAnual(double salario) {
        double imposto = 0;
        double salarioOriginal = salario;

        if (salario > 0) {
            // Faixa isenta
            if (salario > 22847.76) {
                // Faixa de 27.5%
                if (salario > 55976.16) {
                    imposto += (salario - 55976.16) * 0.275;
                    salario = 55976.16;
                    System.out.println("TOTAL DO DESCONTO: R$" + String.format("%.2f", (imposto)));
                }
                // Faixa de 22.5%
                if (salario > 45012.60) {
                    imposto += (salario - 45012.60) * 0.225;
                    salario = 45012.60;
                    System.out.println("TOTAL DO DESCONTO: R$" + String.format("%.2f", (imposto)));
                }
                // Faixa de 15%
                if (salario > 33919.80) {
                    imposto += (salario - 33919.80) * 0.15;
                    salario = 33919.80;
                    System.out.println("TOTAL DO DESCONTO: R$" + String.format("%.2f", (imposto)));
                }
                // Faixa de 7.5%
                if (salario > 22847.76) {
                    imposto += (salario - 22847.76) * 0.075;
                    salario = 22847.76;
                    System.out.println("TOTAL DO DESCONTO: R$" + String.format("%.2f", (imposto)) + "\n");
                }
            } else {
                // Faixa isento
                System.out.println("Isento de Imposto de Renda.");
            }

            System.out.println("O TOTAL DE DESCONTO ANUAL É: R$" + String.format("%.2f", imposto));

            double aliquotaEfetiva = (imposto / salarioOriginal) * 100;
            System.out.println("ALÍQUOTA EFETIVA: " + String.format("%.2f", aliquotaEfetiva) + "%\n");

        } else {
            // Exibe mensagem caso o salário seja menor ou igual a zero
            System.out.println("INSIRA UM VALOR MAIOR QUE R$0.00\n");
        }

        return imposto;
    }

}
