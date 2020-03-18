# allwords.txt

W pliku allwords.txt, znajdującym się w katalogu  {user.home} zapisane są (rozdzielone białymi znakami) słowa.
Znaleźć wszystkie anagramy, które można utworzyć z  tych słów i wypisac je jako listy słów na konsoli w porządku liczby anagramów.
Przy takiej samej liczbie anagramów listy wypisywane są w porządku alfabetycznym pierwszego słowa na liście.

Dla realizacji tego zadania w klasie Anagrams utworzyć metodę getSortedByAnQty(), która zwraca listę list słów będacych anagramami, uporządkowaną wedle podanych wyżej kryteriów.
W klasie tej dostarczyć także metody String getAnagramsFor(String word), która zwraca napis, przedstwiający listę anagramów dla podanego słowa w postaci:
```
słowo: [ anagram1, anagram2, ... , anagramN]
```
Jeśli  słowo nie ma nagramow lista jest pusta (po dwukropku mamy [] ). Jesli podanego słowa nie ma w pliku allwords.txt to po dwukropku powinnien znaleźć się napis null.

Słowa dla których będziemy szukać anagramów, wczytywane są z pliku o nazwie {user.home}/wordsToFind.

Rozwiązanie zadania ułatwi klasa Main, utworzona przez generator projektów. Ma ona następującą postać (nie wolno jej zmieniać):
```
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    String home = System.getProperty("user.home");
    String allWords = home + "/allwords.txt";
    Anagrams an = new Anagrams(allWords);
    for(List<String> wlist : an.getSortedByAnQty()) {
      System.out.println(wlist);
    }
    System.out.println("************************");
    Scanner scan = new Scanner(new File(home, "wordsToFind.txt"));
    while(scan.hasNext()) {
      System.out.println(an.getAnagramsFor(scan.next()));
    }
    scan.close();
  }

}
```
Przykładowo, jeśli plik allwords.txt zawiera  słowa:
```
andes danes deans evil gals lags levi live sedan
slag streets testers uprising veil vile
```
a plik wordsToFind słowa:
```
evil streets uprising
```
to program (zaczynający wykonanie od obowiązkowej klasy Main) powinien wyprowadzić następującą informację
```
[evil, levi, live, veil, vile]
[andes, danes, deans, sedan]
[gals, lags, slag]
[streets, testers]
[uprising]
************************
evil: [levi, live, veil, vile]
streets: [testers]
uprising: []
```
Uwaga: programy nie dające pokazanej formy wydruku otrzymują 0 punktów.

Uwaga: nazwy i umiejscowienie plików są obowiązkowe. Niespełnienie tego warunku skutkuje brakiem punktów.

Utworzona przez generator projektów klasa Main zawiera fragment pomocny dla uzyskania wymaganej nazwy pliku.

Uwaga: aby dowiedzieć się który  katalog jest  {user.home} i umieścić w nim pliki testowe można z poziomu Javy użyć:
System.getProperty("user.home");
Np. jeśli identyfikatorem użytkownika jest Janek, to w Windows 7 katalog {user.home} to C:\Users\Janek.

Należy samodzielnie utworzyć testowe pliki i umieścić je w katalogu {user.home}

# customers.txt

W pliku customers.txt umieszczonym w katalogu {user.home} znajdują się dane o zakupach klientów w postaci:
```
id_klienta; nazwisko i imię; nazwa_towaru;cena;zakupiona_ilość
```
Identyfikator klienta ma postać
```
cNNNNN
```
gdzie N cyfra ze zbioru [0...9] np:
```
c00001;Kowalski Jan;bułka;2;100
```
Wczytać dane z pliku i wypisać na konsoli w kolejnych wierszach:
1. poprzedzone napisem "Nazwiska" dane posortowane wg nazwisk w porządku rosnącym (porządek rekordów z tymi samymi nazwiskami jest określany przez identyfikatory klientów - rosnąco),
2. poprzedzone napisem "Koszty" dane posortowane wg kosztów zakupów w porządku malejącym (porządek rekordów z tymi samymi kosztami jest określany przez identyfikatory klientów - rosnąco) z dodatkowym dopiskiem na końcu w nawiasach:  koszty:  kosztZakupu (np. (koszt: 200.0)),
3. poprzedzone napisem "Klient c00001" dane o wszystkich zakupach  klienta  o identyfikatorze "c00001" (w odrębnych wierszach)
4. poprzedzone napisem "Klient c00002" - w odrębnych wierszach -dane o wszystkich zakupach  klienta  o identyfikatorze "c00002"  (w odrebnych wierszach) (a więc uwaga: w pliku muszą być klienci o identyfikatorach c00001 i c00002)

Np. dla pliku w postaci:
```
c00004;Nowak Anna;banany;4.0;50.0
c00003;Kowalski Jan;mleko;4.0;5.0
c00001;Kowalski Jan;mleko;4.0;10.0
c00001;Kowalski Jan;mleko;5.0;2.0
c00002;Malina Jan;mleko;4.0;2.0
c00002;Malina Jan;chleb;3.0;5.0
c00001;Kowalski Jan;bulka;2.0;100.0


Nazwiska
c00001;Kowalski Jan;mleko;4.0;10.0
c00001;Kowalski Jan;mleko;5.0;2.0
c00001;Kowalski Jan;bulka;2.0;100.0
c00003;Kowalski Jan;mleko;4.0;5.0
c00002;Malina Jan;mleko;4.0;2.0
c00002;Malina Jan;chleb;3.0;5.0
c00004;Nowak Anna;banany;4.0;50.0

Koszty
c00001;Kowalski Jan;bulka;2.0;100.0 (koszt: 200.0)
c00004;Nowak Anna;banany;4.0;50.0 (koszt: 200.0)
c00001;Kowalski Jan;mleko;4.0;10.0 (koszt: 40.0)
c00003;Kowalski Jan;mleko;4.0;5.0 (koszt: 20.0)
c00002;Malina Jan;chleb;3.0;5.0 (koszt: 15.0)
c00001;Kowalski Jan;mleko;5.0;2.0 (koszt: 10.0)
c00002;Malina Jan;mleko;4.0;2.0 (koszt: 8.0)

Klient c00001
c00001;Kowalski Jan;mleko;4.0;10.0
c00001;Kowalski Jan;mleko;5.0;2.0
c00001;Kowalski Jan;bulka;2.0;100.0

Klient c00002
c00002;Malina Jan;mleko;4.0;2.0
c00002;Malina Jan;chleb;3.0;5.0
```
Uwaga: programy nie dające pokazanej formy wydruku otrzymują 0 punktów.

Niezbędne jest stworzenie klasy, opisującej zakupy klientów (Purchase) i operowanie na jej obiektach. Nie przyjmuję rozwiązań działających na "surowych" Stringach.

Aplikacja powinna zawierać klasy Purchase,  CustomersPurchaseSortFind oraz Main.
Ta ostatnia ma obowiązakową postać (nie wolno jej zmienić):
```
      public class Main {
  
        public static void main(String[] args)  {
          CustomersPurchaseSortFind cpsf = new CustomersPurchaseSortFind();
          String fname = System.getProperty("user.home") + "/customers.txt";
          cpsf.readFile(fname);
          cpsf.showSortedBy("Nazwiska");
          cpsf.showSortedBy("Koszty");
  
          String[] custSearch = { "c00001", "c00002" };
  
          for (String id : custSearch) {
            cpsf.showPurchaseFor(id);
          }
        }
  
      }
```      
Generator projektów utworzy wymagane klasy.

Wykonanie programu rozpoczyna się od metody main(...) w klasie Main.

Uwaga: nazwa pliku jest obowiązkowe. Niespełnienie tego warunku skutkuje brakiem punktów.
Utworzona przez generator projektów klasa Main zawiera fragment pomocny dla uzyskania wymaganej nazwy pliku.

Uwaga: aby dowiedzieć się który  katalog jest  {user.home} i umieścić w nim plik testowy można z poziomu Javy użyć:
System.getProperty("user.home");
Np. jeśli identyfikatorem użytkownika jest Janek, to w Windows 7 katalog {user.home} to C:\Users\Janek.

Należy samodzielnie utworzyć testowy plikii umieścić je w katalogu {user.home}.

# programmers.txt

Firma software'owa prowadzi projekty w różnych językach programowania.
Plik Prpgrammers.tsv z katalogu {user.home} zawiera informacje o programistach w postaci:
``` 
język1<TAB>nazwisko(1)<TAB>nazwisko(2)<TAB> itd
język2<TAB>nazwisko(1)<TAB>nazwisko(2)<TAB> itd
...
``` 
Stworzyć klasę ProgLang, mającą:

1. konstruktor ProgLang(String nazwaPliku), w którym następuje wczytanie pliku o podanej nazwie,
2. metodę getLangsMap() - zwracająca mapę, w której pod kluczem nazwa języka znajduje się kolekcja programistów tego języka,
3. metodę getProgsMap() - zwracającą mapę, w której pod kluczem nazwisko programisty znajduje się kolekcja języków, w których programuje,
4. metodę getLangsMapSortedByNumOfProgs()  - zwracającą mapę z wejściami  język -> kolekcja programistów. uporządkowaną malejąco według liczby osób znających poszczególne języki, w przypadku równej liczbu porządek jest alfabetyczny wg nazw języków,
5. metodę getProgsMapSortedByNumOfLangs() - zwracającą mapę z wejścimi programista -> kolekcja językow, uporządkowaną malejąco wg liczby języków znanych programiści; w przypadku równej liczby porządek jest alfabetyczny wg nazwisk,
6. metodę getProgsMapForNumOfLangsGreaterThan(int n) - zwracającą mapę z wejściami programista -> kolekcja języków, dla ktorych liczba języków jest większa od podanego n.
7. metodę sorted(...), wołaną z argumentami mapa i lambda-wyrażenie. Metoda zwraca posortowaną wersję dowolnej mapy przekazanej jako piewrszy argument, a porządek sortowania jest określony przez lambda wyrażenia, podane jako drugi argument,
8. metodę filtered(...) z argumentami: dowolna mapa i  lambda. Metoda zwraca  mapę, która zawiera tylko te wejścia z przekazanej jako pierwszy argument mapy, które spelniają warunek podany jako drugi argument (lambda z wynikiem typu boolean).
9. Metode sorted(...) lub filtered(...) użyć w oprogramowaniu innych, odpowiednich, metod klasy. Mają one jednak ogólniejsze znaczenia, bo mogą być używane dla dowolnych innych map  z warunkami sortowania czy filtrowania, zadawanymi przez własściwe w danych przypadkach lambdy.

Uwaga: uniwersalność metod sorted i filtered )możliwość ich zasobędzie sprawdzana

Poniższa klasa Main (ktorej w projekcie nie wolno modyfikować):
``` 
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    ProgLang pl = null;
    try {
      pl =  new ProgLang(System.getProperty("user.home") + "/Programmers.tsv");
    } catch (Exception exc) {
      System.out.println("Wadliwy konstruktor: " + exc);
    }
    System.out.println("@1 Mapa językow:");
    pl.getLangsMap().forEach((k,v)->System.out.println(k+ " = " + v));
    System.out.println("@2 Mapa programistów:");
    pl.getProgsMap().forEach((k,v)->System.out.println(k+ " = " + v));
    System.out.println("@3 Języki posortowane wg liczby programistów:");
    pl.getLangsMapSortedByNumOfProgs()
      .forEach((k,v)->System.out.println(k+ " = " + v));
    System.out.println("@4 Programiści posortowani wg liczby języków:");
    pl.getProgsMapSortedByNumOfLangs()
      .forEach((k,v)->System.out.println(k+ " = " + v));
    System.out.println("@5 Oryginalna mapa języków niezmieniona:");
    pl.getLangsMap().forEach((k,v)->System.out.println(k+ " = " + v));
    System.out.println("@6 Oryginalna mapa programistów niezmienione:");
    pl.getProgsMap().forEach((k,v)->System.out.println(k+ " = " + v));
    System.out.println("@7 Mapa programistów znających więcej niż 1 język:");
    pl.getProgsMapForNumOfLangsGreaterThan(1)
      .forEach((k,v)->System.out.println(k+ " = " + v));
    System.out.println("@8 Oryginalna mapa programistów nie jest zmieniona:");
    pl.getProgsMap().forEach((k,v)->System.out.println(k+ " = " + v));
  }

}
``` 
dla nastepującej zawartości pliku Programmers.tsv:
``` 
Groovy	Z	Y	X	D
Java	V	B	C	D	A	Z
C++	G	J	H
C#	P	S	Q	V	D
Scala	A	D	A
``` 
(uwaga: sepratorami są znaki tabulacji)

wyprowadzi na konsolę wynik:
``` 
@1 Mapa językow:
Groovy = [Z, Y, X, D]
Java = [V, B, C, D, A, Z]
C++ = [G, J, H]
C# = [P, S, Q, V, D]
Scala = [A, D]
@2 Mapa programistów:
Z = [Groovy, Java]
Y = [Groovy]
X = [Groovy]
D = [Groovy, Java, C#, Scala]
V = [Java, C#]
B = [Java]
C = [Java]
A = [Java, Scala]
G = [C++]
J = [C++]
H = [C++]
P = [C#]
S = [C#]
Q = [C#]
@3 Języki posortowane wg liczby programistów:
Java = [V, B, C, D, A, Z]
C# = [P, S, Q, V, D]
Groovy = [Z, Y, X, D]
C++ = [G, J, H]
Scala = [A, D]
@4 Programiści posortowani wg liczby języków:
D = [Groovy, Java, C#, Scala]
A = [Java, Scala]
V = [Java, C#]
Z = [Groovy, Java]
B = [Java]
C = [Java]
G = [C++]
H = [C++]
J = [C++]
P = [C#]
Q = [C#]
S = [C#]
X = [Groovy]
Y = [Groovy]
@5 Oryginalna mapa języków niezmieniona:
Groovy = [Z, Y, X, D]
Java = [V, B, C, D, A, Z]
C++ = [G, J, H]
C# = [P, S, Q, V, D]
Scala = [A, D]
@6 Oryginalna mapa programistów niezmienione:
Z = [Groovy, Java]
Y = [Groovy]
X = [Groovy]
D = [Groovy, Java, C#, Scala]
V = [Java, C#]
B = [Java]
C = [Java]
A = [Java, Scala]
G = [C++]
J = [C++]
H = [C++]
P = [C#]
S = [C#]
Q = [C#]
@7 Mapa programistów znających więcej niż 1 język:
Z = [Groovy, Java]
D = [Groovy, Java, C#, Scala]
V = [Java, C#]
A = [Java, Scala]
@8 Oryginalna mapa programistów nie jest zmieniona:
Z = [Groovy, Java]
Y = [Groovy]
X = [Groovy]
D = [Groovy, Java, C#, Scala]
V = [Java, C#]
B = [Java]
C = [Java]
A = [Java, Scala]
G = [C++]
J = [C++]
H = [C++]
P = [C#]
S = [C#]
Q = [C#]
``` 
Ważne uwagi:

1. zgodność informacji wyjściowej z oczekiwanym wynikiem (w tym kolejność pokazywania danych)  jest istotna - wynika z zastosowania odpowiednich map i innych klas kolekcyjnych, za niezgodność w którymkolwiek z punktów 1-8 będą odejmowane 2 punkty,
2. uniwersalność metod sorted i filtered (możliwość ich zastosowania dla innych niż w zadaniu map) będzie sprawdzana; brak uniwersalności każdej z metod skutkuje odjęciem 4 punktów,
3. w klasie ProgLang  nie wolno używac surowych typów.

