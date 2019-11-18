import java.util.Scanner;

public class kolko_i_krzyzyk {
    public static void main(String[] args) {
        char obecnyGracz = 'x';
        char[][] plansza = new char[3][3];

        while (true) {
           kolko_i_krzyzyk.drukujPlansze(plansza);
            boolean ruchPoprawny = wykonajRuch(plansza,obecnyGracz);
            if(!ruchPoprawny) continue;
            boolean wygranaWiersze = sprawdzWiersze(plansza,obecnyGracz);
            boolean wygranaKolumny = sprawdzKolumny(plansza,obecnyGracz);
            boolean wygranaSkos1 = sprawdzSkos1(plansza,obecnyGracz);
            boolean wygranaSkos2 = sprawdzSkos2(plansza,obecnyGracz);
            if(wygranaWiersze || wygranaKolumny || wygranaSkos1 || wygranaSkos2){
                System.out.println("Gratulacje " +obecnyGracz);
                break;
            }


            obecnyGracz = obecnyGracz == 'x' ? 'o' : 'x';
        }
    }
    public static boolean wykonajRuch(char[][] plansza, char symbol){
        System.out.println(symbol + " twoja kolej");
        System.out.println("Podaj numer wiersza");
        int wiersz = new Scanner(System.in).nextInt();
        System.out.println("Podaj numer kolumny");
        int kolumna = new Scanner(System.in).nextInt();
        boolean ruchPoprawny;

        if (plansza[wiersz][kolumna] == 0) ruchPoprawny = true;

        else {
            ruchPoprawny = false;
            System.out.println("Ruch niepoprawny");

        }

        plansza[wiersz][kolumna] = symbol;
        kolko_i_krzyzyk.drukujPlansze(plansza);
        return ruchPoprawny;
    }
    public static boolean sprawdzWiersze(char[][] plansza, char symbol){
        int wymiar = plansza.length;
        for(int wiersz = 0;wiersz<wymiar;wiersz++){
            boolean wygrana = true;
            for(int kolumna = 0;kolumna<wymiar;kolumna++){
                if (plansza[wiersz][kolumna]!=symbol){
                    wygrana= false;
                    break;
                }
            }
            if(wygrana){return true;}
        }
    return false;
    }
    public static boolean sprawdzKolumny(char[][] plansza, char symbol){
        int wymiar = plansza.length;
        for(int kolumna = 0;kolumna<wymiar;kolumna++){
            boolean wygrana = true;
            for(int wiersz = 0;kolumna<wymiar;wiersz++){
                if (plansza[wiersz][kolumna]!=symbol){
                    wygrana= false;
                    break;
                }
            }
            if(wygrana){return true;}
        }
        return false;
    }
    public static  boolean sprawdzSkos1(char[][]plansza, char symbol){
        int wymiar = plansza.length;
        for(int i=0;i<wymiar;i++){
            if(plansza[i][i]!=symbol){
                return false;
            }
        }
        return true;
    }
    public static  boolean sprawdzSkos2(char[][]plansza, char symbol){
        int wymiar = plansza.length;
        for(int i=0;i<wymiar;i++){
            if(plansza[i][wymiar - i - 1]!=symbol){
                return false;
            }
        }
        return true;
    }
    public static void drukujPlansze(char[][] plansza){
        System.out.println("    0   1   2");
        for (int wiersz = 0; wiersz<plansza.length; wiersz++) {
            System.out.print(wiersz + " : ");
            for (int kolumna = 0; kolumna<plansza.length; kolumna++) {
                System.out.print(plansza[wiersz][kolumna] + "   ");
            }
            System.out.println();
        }
    }
}

