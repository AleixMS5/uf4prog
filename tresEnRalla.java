import java.util.Scanner;

public class tresEnRalla {
    static int[][] tablerojoc = new int[3][3];

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        plenamar();
        while (true) {
            try {

//partida
                //player 1
                try {
                    jugador1();
                } catch (pleException e) {
                    jugador1();
                }
//printem el tauler
                String[] lletres = new String[]{" A ", " B ", " C "};

                //Posem els numeros de les cordenades del tauler
                System.out.println("    1  2  3 ");
                for (int i = 0; i < tablerojoc.length; i++) {
                    //Introduim les lletres de les cordenades en el tauler
                    System.out.print(lletres[i]);
                    for (int j = 0; j < tablerojoc.length; j++) {
                        //Creem el tauler amb 0
                        if (tablerojoc[i][j] <= 0) {
                            System.out.print(" 0 ");
                        } else if (tablerojoc[i][j] == 1) {
                            System.out.print(" 1 ");
                        } else if (tablerojoc[i][j] == 2) {
                            System.out.print(" 2 ");
                        }

                    }
                    System.out.println();
                }
                win();
                //player 2
                try {
                    jugador2();
                } catch (pleException e) {
                    jugador2();
                }

                //printem el tauler
                //Posem els numeros de les cordenades del tauler
                System.out.println("    1  2  3 ");

                //Creem un for per tal de crear una matriu del tauler
                for (int i = 0; i < tablerojoc.length; i++) {
                    //Introduim les lletres de les cordenades en el tauler
                    System.out.print(lletres[i]);
                    for (int j = 0; j < tablerojoc.length; j++) {
                        //Creem el tauler amb 0
                        if (tablerojoc[i][j] <= 0) {
                            System.out.print(" 0 ");
                        } else if (tablerojoc[i][j] == 1) {
                            System.out.print(" 1 ");
                        } else if (tablerojoc[i][j] == 2) {
                            System.out.print(" 2 ");
                        }

                    }
                    System.out.println();
                }
                win();

            } catch (winException e) {
                break;
            }
        }
    }
//metode per printar el tauler buit que no s'utilitza realment
    public static void plenamar() {
//Creem una array per posar les lletres en el tauler
        String[] lletres = new String[]{" A ", " B ", " C "};

        //Posem els numeros de les cordenades del tauler
        System.out.println("    1  2  3 ");

        //Creem un for per tal de crear una matriu del tauler
        for (int i = 0; i < tablerojoc.length; i++) {
            //Introduim les lletres de les cordenades en el tauler
            System.out.print(lletres[i]);
            for (int j = 0; j < tablerojoc.length; j++) {
                //Creem el tauler amb 0
                if (tablerojoc[i][j] <= 0) {
                    System.out.print(" 0 ");
                } else if (tablerojoc[i][j] == 1) {
                    System.out.print(" 1 ");
                }

            }
            System.out.println();
        }


    }
//metode que serveix per que jugui el jugador 1
    private static void jugador1() throws Exception {
//demanem les coordenades
        int lletranumero = 0;
        System.out.println("digues les cordenades per posar la peça jugador 1");
        //lleguim les cordenades en una sola linea
        String coordenades = sc.nextLine();
        //Agafem el caracter de la primera part de la String
        char columnes = coordenades.charAt(0);
        //descartem la primera part de la String i agafem el resto
        String numeroenlletra = coordenades.substring(1);
        //passem a numero el que ens queda de String
        int numero = Integer.parseInt(numeroenlletra) - 1;

//transformem les lletres en numeros
        if ('A' == columnes) {
            lletranumero = 0;
        } else if (columnes == 'B') {
            lletranumero = 1;
        } else if (columnes == 'C') {
            lletranumero = 2;
        }


        //Posem els numeros de les cordenades del tauler

        try {
            for (int i = 0; i < tablerojoc.length; i++) {
                //Introduim les lletres de les cordenades en el tauler

                for (int j = 0; j < tablerojoc.length; j++) {
                    //Creem el tauler amb 0
                    if (tablerojoc[lletranumero][numero] == 0) {
                        throw new buitException();

                    } else {
                        throw new pleException();
                    }

                }
            }

        } catch (buitException ex) {
            tablerojoc[lletranumero][numero] = 1;
        }


    }
//exactament el mateix que a dal però per al jugador 2
    private static void jugador2() throws Exception {

        int lletranumero = 0;
        System.out.println("digues les cordenades per posar la peça jugador 2");
        //lleguim les cordenades en una sola linea
        String coordenades = sc.nextLine();
        //Agafem el caracter de la primera part de la String
        char columnes = coordenades.charAt(0);
        //descartem la primera part de la String i agafem el resto
        String numeroenlletra = coordenades.substring(1);
        //passem a numero el que ens queda de String
        int numero = Integer.parseInt(numeroenlletra) - 1;


        if ('A' == columnes) {
            lletranumero = 0;
        } else if (columnes == 'B') {
            lletranumero = 1;
        } else if (columnes == 'C') {
            lletranumero = 2;
        }


        //Posem els numeros de les cordenades del tauler

        try {
            for (int i = 0; i < tablerojoc.length; i++) {
                //Introduim les lletres de les cordenades en el tauler

                for (int j = 0; j < tablerojoc.length; j++) {
                    //Creem el tauler amb 0
                    if (tablerojoc[lletranumero][numero] == 0) {
                        throw new buitException();

                    } else {
                        throw new pleException();
                    }

                }
            }

        } catch (buitException ex) {
            tablerojoc[lletranumero][numero] = 2;
        }


    }
//metode per comprovar victories
        public static void win() throws Exception {
        //comprovar victoria jugador 1
                //horitzontal
        if (    (tablerojoc[0][0] == 1 && tablerojoc[0][1] == 1 && tablerojoc[0][2] == 1) ||
                (tablerojoc[1][0] == 1 && tablerojoc[1][1] == 1 && tablerojoc[1][2] == 1) ||
                (tablerojoc[2][0] == 1 && tablerojoc[2][1] == 1 && tablerojoc[2][2] == 1) ||
                //vertical
                (tablerojoc[0][0] == 1 && tablerojoc[1][0] == 1 && tablerojoc[2][0] == 1) ||
                (tablerojoc[0][1] == 1 && tablerojoc[1][1] == 1 && tablerojoc[2][1] == 1) ||
                (tablerojoc[0][2] == 1 && tablerojoc[1][2] == 1 && tablerojoc[2][2] == 1) ||
                //diagonal
                (tablerojoc[0][0] == 1 && tablerojoc[1][1] == 1 && tablerojoc[2][2] == 1) ||
                (tablerojoc[0][2] == 1 && tablerojoc[1][1] == 1 && tablerojoc[2][0] == 1)

        ) {
            System.out.println("ha guañat el jugador1");
            throw new winException();

            //comprovar victoria jugador 2
        } else if ( (tablerojoc[0][0] == 2 && tablerojoc[0][1] == 2 && tablerojoc[0][2] == 2) ||
                (tablerojoc[1][0] == 2 && tablerojoc[1][1] == 2 && tablerojoc[1][2] == 2) ||
                (tablerojoc[2][0] == 2 && tablerojoc[2][1] == 2 && tablerojoc[2][2] == 2) ||
                //vertical
                (tablerojoc[0][0] == 2 && tablerojoc[1][0] == 2 && tablerojoc[2][0] == 2) ||
                (tablerojoc[0][1] == 2 && tablerojoc[1][1] == 2 && tablerojoc[2][1] == 2) ||
                (tablerojoc[0][2] == 2 && tablerojoc[1][2] == 2 && tablerojoc[2][2] == 2) ||
                //diagonal
                (tablerojoc[0][0] == 2 && tablerojoc[1][1] == 2 && tablerojoc[2][2] == 2) ||
                (tablerojoc[0][2] == 2 && tablerojoc[1][1] == 2 && tablerojoc[2][0] == 2))
        {
            System.out.println("ha guañat el jugador2");
            throw new winException();


            //comprovar empat
        } else if ((tablerojoc[0][0] != 0 && tablerojoc[0][1] != 0 && tablerojoc[0][2] != 0) &&
                (tablerojoc[1][0] != 0 && tablerojoc[1][1] != 0 && tablerojoc[1][2] != 0) &&
                (tablerojoc[2][0] != 0 && tablerojoc[2][1] != 0 && tablerojoc[2][2] != 0) ) {throw new empatException();

        }

        }

//exepcions usades per a les diferens funcions
    public static class buitException extends Exception {
        public buitException() {

        }
    }

    public static class pleException extends Exception {
        public pleException() {

        }
    }
    public static class winException extends Exception {
        public winException() {

        }
    }
    public static class empatException extends Exception {
        public empatException() {

        }
    }
}

