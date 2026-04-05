import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadVeiculo {
    static List<String> veiculos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Sistema de Cadastro de Veículos!");
        String menu = """
                MENU DE OPÇÕES:
                1 - Cadastrar Veículo
                2 - Listar Veículos Cadastrados
                3 - Buscar Veículo
                4 - Editar Veículo
                5 - Remover Veículo
                6 - Remover Veículo por Nome
                0 - Sair
                """;
        int opcao;
        do {
            System.out.print(menu);
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> {
                    cadastrar();
                    pausa();
                }
                case 2 -> {
                    listar();
                    pausa();
                }
                case 3 -> {
                    buscar();
                    pausa();
                }
                case 4 -> {
                    editar();
                    pausa();
                }
                case 5 -> {
                    excluir();
                    pausa();
                }
                case 6 -> {
                    excluirPorNome();
                    pausa();
                }
                case 0 -> System.out.println("Saindo... até mais!");
                default -> {
                    System.out.println("Opção inválida!");
                    pausa();
                }
            }
        } while (opcao != 0);
        sc.close();
    }

    static void pausa() {
        System.out.print("Pressione Enter para continuar...");
        sc.nextLine();
    }

    static void ordenar() {
        for (int i = 0; i < veiculos.size() - 1; i++) {
            for (int j = 0; j < veiculos.size() - 1 - i; j++) {
                if (veiculos.get(j).toLowerCase().compareTo(veiculos.get(j + 1).toLowerCase()) > 0) {
                    String aux = veiculos.get(j);
                    veiculos.set(j, veiculos.get(j + 1));
                    veiculos.set(j + 1, aux);
                }
            }
        }
    }

    static void cadastrar() {
        System.out.print("Digite o nome do veículo: ");
        String veiculo = sc.nextLine().trim();

        if (veiculo.isEmpty()) {
            System.out.println("Nome inválido.");
            return;
        }

        boolean jaExiste = false;
        for (String v : veiculos) {
            if (v.toLowerCase().equals(veiculo.toLowerCase())) {
                jaExiste = true;
                break;
            }
        }

        if (jaExiste) {
            System.out.println("Esse veículo já está cadastrado!");
        } else {
            veiculos.add(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
        }
    }

    static void listar() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        
        ordenar();
        System.out.println("\n=== LISTA DE VEÍCULOS ===");
        System.out.println("Total: " + veiculos.size());
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println((i + 1) + " - " + veiculos.get(i));
        }
        System.out.println("========================\n");
    }

    static void buscar() {
        System.out.print("Digite o nome do veículo para buscar: ");
        String nome = sc.nextLine().trim();

        boolean achou = false;
        for (String v : veiculos) {
            if (v.toLowerCase().equals(nome.toLowerCase())) {
                achou = true;
                break;
            }
        }

        if (achou) {
            System.out.println("✓ Veículo \"" + nome + "\" encontrado!");
        } else {
            System.out.println("✗ Veículo \"" + nome + "\" não encontrado.");
        }
    }

    static void editar() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        listar();
        System.out.print("Digite o número do veículo para editar: ");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice <= 0 || indice > veiculos.size()) {
            System.out.println("Número inválido.");
            return;
        }

        System.out.print("Digite o novo nome: ");
        String nomeNovo = sc.nextLine().trim();

        if (nomeNovo.isEmpty()) {
            System.out.println("Nome inválido.");
            return;
        }

        boolean jaExiste = false;
        for (String v : veiculos) {
            if (v.toLowerCase().equals(nomeNovo.toLowerCase())) {
                jaExiste = true;
                break;
            }
        }

        if (jaExiste) {
            System.out.println("Já existe um veículo com esse nome!");
        } else {
            veiculos.set(indice - 1, nomeNovo);
            System.out.println("Veículo editado com sucesso!");
        }
    }

    static void excluir() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        listar();
        System.out.print("Digite o número do veículo a remover: ");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice <= 0 || indice > veiculos.size()) {
            System.out.println("Número inválido.");
        } else {
            veiculos.remove(indice - 1);
            System.out.println("Veículo removido com sucesso!");
        }
    }

    static void excluirPorNome() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        System.out.print("Digite o nome do veículo a remover: ");
        String nome = sc.nextLine().trim();

        int indiceAchado = -1;
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).toLowerCase().equals(nome.toLowerCase())) {
                indiceAchado = i;
                break;
            }
        }

        if (indiceAchado == -1) {
            System.out.println("Veículo \"" + nome + "\" não encontrado.");
        } else {
            veiculos.remove(indiceAchado);
            System.out.println("Veículo removido com sucesso!");
        }
    }
}