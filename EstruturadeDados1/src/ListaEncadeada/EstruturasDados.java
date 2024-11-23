package ListaEncadeada;

import java.util.Scanner;

public class EstruturasDados {

    // Classe para a Lista Duplamente Encadeada
    static class ListaDuplamenteEncadeada {
        class No {
            int dado;
            No proximo;
            No anterior;

            No(int dado) {
                this.dado = dado;
                this.proximo = null;
                this.anterior = null;
            }
        }

        private No cabeca;
        private No cauda;

        public ListaDuplamenteEncadeada() {
            cabeca = null;
            cauda = null;
        }

        public void inserirNoInicio(int dado) {
            No novoNo = new No(dado);
            if (cabeca == null) {
                cabeca = cauda = novoNo;
            } else {
                novoNo.proximo = cabeca;
                cabeca.anterior = novoNo;
                cabeca = novoNo;
            }
        }

        public void inserirNoFinal(int dado) {
            No novoNo = new No(dado);
            if (cauda == null) {
                cabeca = cauda = novoNo;
            } else {
                cauda.proximo = novoNo;
                novoNo.anterior = cauda;
                cauda = novoNo;
            }
        }

        public void removerDoInicio() {
            if (cabeca == null) {
                System.out.println("A lista está vazia.");
                return;
            }
            if (cabeca == cauda) {
                cabeca = cauda = null;
            } else {
                cabeca = cabeca.proximo;
                cabeca.anterior = null;
            }
        }

        public void removerDoFinal() {
            if (cauda == null) {
                System.out.println("A lista está vazia.");
                return;
            }
            if (cabeca == cauda) {
                cabeca = cauda = null;
            } else {
                cauda = cauda.anterior;
                cauda.proximo = null;
            }
        }

        public boolean buscar(int dado) {
            No atual = cabeca;
            while (atual != null) {
                if (atual.dado == dado) {
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }

        public void exibir() {
            No atual = cabeca;
            if (atual == null) {
                System.out.println("A lista está vazia.");
                return;
            }
            while (atual != null) {
                System.out.print(atual.dado + " ");
                atual = atual.proximo;
            }
            System.out.println();
        }
    }

    // Classe para a Árvore Binária
    static class ArvoreBinaria {
        class No {
            int dado;
            No esquerda;
            No direita;

            No(int dado) {
                this.dado = dado;
                this.esquerda = null;
                this.direita = null;
            }
        }

        private No raiz;

        public ArvoreBinaria() {
            raiz = null;
        }

        // Inserir elemento na árvore binária de busca
        public void inserir(int dado) {
            raiz = inserirRecursivo(raiz, dado);
        }

        private No inserirRecursivo(No raiz, int dado) {
            if (raiz == null) {
                return new No(dado);
            }
            if (dado < raiz.dado) {
                raiz.esquerda = inserirRecursivo(raiz.esquerda, dado);
            } else if (dado > raiz.dado) {
                raiz.direita = inserirRecursivo(raiz.direita, dado);
            }
            return raiz;
        }

        // Buscar elemento na árvore
        public boolean buscar(int dado) {
            return buscarRecursivo(raiz, dado);
        }

        private boolean buscarRecursivo(No raiz, int dado) {
            if (raiz == null) {
                return false;
            }
            if (dado == raiz.dado) {
                return true;
            }
            if (dado < raiz.dado) {
                return buscarRecursivo(raiz.esquerda, dado);
            } else {
                return buscarRecursivo(raiz.direita, dado);
            }
        }

        // Exibir a árvore em ordem (in-order)
        public void exibir() {
            exibirInOrder(raiz);
            System.out.println();
        }

        private void exibirInOrder(No raiz) {
            if (raiz != null) {
                exibirInOrder(raiz.esquerda);
                System.out.print(raiz.dado + " ");
                exibirInOrder(raiz.direita);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        // Valores iniciais para a lista duplamente encadeada
        lista.inserirNoInicio(10);
        lista.inserirNoFinal(20);
        lista.inserirNoFinal(30);
        lista.inserirNoFinal(40);
        
        // Valores iniciais para a árvore binária
        arvore.inserir(15);
        arvore.inserir(25);
        arvore.inserir(5);
        arvore.inserir(20);
        arvore.inserir(30);
        
        int opcao;

        do {
            System.out.println("\nEscolha a estrutura para manipular:");
            System.out.println("1. Lista Duplamente Encadeada");
            System.out.println("2. Árvore Binária");
            System.out.println("3. Sair");
            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    manipularLista(scanner, lista);
                    break;

                case 2:
                    manipularArvore(scanner, arvore);
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    // Métodos para manipular a lista
    private static void manipularLista(Scanner scanner, ListaDuplamenteEncadeada lista) {
        int opLista;
        do {
            System.out.println("\nEscolha uma operação para a Lista Duplamente Encadeada:");
            System.out.println("1. Inserir no início");
            System.out.println("2. Inserir no final");
            System.out.println("3. Remover do início");
            System.out.println("4. Remover do final");
            System.out.println("5. Exibir lista");
            System.out.println("6. Buscar elemento");
            System.out.println("7. Voltar");
            System.out.print("Digite a opção: ");
            opLista = scanner.nextInt();

            switch (opLista) {
                case 1:
                    System.out.print("Digite o valor a ser inserido no início: ");
                    int inicio = scanner.nextInt();
                    lista.inserirNoInicio(inicio);
                    break;

                case 2:
                    System.out.print("Digite o valor a ser inserido no final: ");
                    int fim = scanner.nextInt();
                    lista.inserirNoFinal(fim);
                    break;

                case 3:
                    lista.removerDoInicio();
                    break;

                case 4:
                    lista.removerDoFinal();
                    break;

                case 5:
                    System.out.print("Lista atual: ");
                    lista.exibir();
                    break;

                case 6:
                    System.out.print("Digite o valor a ser buscado: ");
                    int buscar = scanner.nextInt();
                    if (lista.buscar(buscar)) {
                        System.out.println("Elemento encontrado na lista.");
                    } else {
                        System.out.println("Elemento não encontrado na lista.");
                    }
                    break;

                case 7:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opLista != 7);
    }

    // Métodos para manipular a árvore binária
    private static void manipularArvore(Scanner scanner, ArvoreBinaria arvore) {
        int opArvore;
        do {
            System.out.println("\nEscolha uma operação para a Árvore Binária:");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Exibir árvore");
            System.out.println("4. Voltar");
            System.out.print("Digite a opção: ");
            opArvore = scanner.nextInt();

            switch (opArvore) {
                case 1:
                    System.out.print("Digite o valor a ser inserido na árvore: ");
                    int valor = scanner.nextInt();
                    arvore.inserir(valor);
                    break;

                case 2:
                    System.out.print("Digite o valor a ser buscado: ");
                    int buscar = scanner.nextInt();
                    if (arvore.buscar(buscar)) {
                        System.out.println("Elemento encontrado na árvore.");
                    } else {
                        System.out.println("Elemento não encontrado na árvore.");
                    }
                    break;

                case 3:
                    System.out.print("Árvore em ordem: ");
                    arvore.exibir();
                    break;

                case 4:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opArvore != 4);
    }
}
