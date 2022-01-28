# Zadanie: Generics
Stworzyć sparametryzowane interfejsy:

1. Selector - z metodą select, zwracającą true jesli argument spełnia warunek zapisany w metodzoe i false w przeciwnym razie
2. Mapper - z metodą map, będącą dowolną funkcją: argument -> wynik
3. oraz sparametryzowaną klasę ListCreator, zawierającą:
4. statyczną metodę collectFrom (lista)
5. metodę when
6. metodę mapEvery
7. które działają w taki sposób, że symboliczny zapis:

collectFrom(list1).when(selektor).mapEvery(mapper)
spowoduje utworzenie listy wynikowej, której elementy stanowią wybrane przez selektor elementy listy list1, przekształacone za pomocą podanego mappera.

Gdy w metodzie test1 selektor wybiera z listy liczby < 10, a mapper zwraca liczbę-argument powiększoną o 10, to na konsoli powinniśmy zobaczyć: [11, 17, 19]

Gdy w metodzie test2 selektor wybiera z listy napisy, których długiość jest większa od 3 znakow, a mapper dzwraca dlugość przekazanego napisu, powiększoną o 10, to na konsoli zobaczymy: [14, 17]
