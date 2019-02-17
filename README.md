# Procesor adnotacji

##### program odpalający metody oznaczone adnotacją @Run

Zadania:

1. Stworzenie własnej adnotacji Run

2. Napisanie programu z dwiema metodami oznaczonymi tą adnotacją

3. Napisanie programu, który odpala tylko wybrane (oznaczone) metody modułu program

4. Mavenowy moduł: adnotacje (rzeczone @Run), tester (sedno zadania) i program (jako zależność używa obu pozostałych modułów, to "kod testowany")

5. Wywołanie całości via mvn:exec (czy główną klasę testera) powinno odpalić każdą z metod, nawet jeśli jedna ma błąd kompilacji czy nieoczekiwany wynik

### Uruchomienie procesora adnotacji

##### Wymagania

Maven minimum 3.5.3
Java minimum 8

##### Instrukcja

1. Odpal terminal i przejdź do folderu, w którym znajduje się projekt

2. Wpisz komendę mvn clean install

3. Odpal program wpisując java -jar ./tester/target/tester.jar
