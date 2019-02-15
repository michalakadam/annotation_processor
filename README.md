# TESTER

##### program odpalający metody oznaczone adnotacją @Run

Zadania:

1. Stworzenie własnej adnotacji Run

2. Napisanie programu z dwiema metodami oznaczonymi tą adnotacją

3. Napisanie programu, który odpala tylko wybrane (oznaczone) metody modułu program

4. Mavenowy moduł: adnotacje (rzeczone @Run), tester (sedno zadania) i program (jako zależność używa obu pozostałych modułów, to "kod testowany")

5. Wywołanie całości via mvn:exec (czy główną klasę testera) powinno odpalić każdą z metod, nawet jeśli jedna ma błąd kompilacji czy nieoczekiwany wynik
