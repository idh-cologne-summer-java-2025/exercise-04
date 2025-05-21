Fortgeschrittene Programmierung (Java 2)

# Übung 4

Sie sollten jetzt auch Aufgabe 2 von Übung 3 [https://github.com/idh-cologne-summer-java-2025/excercise-03] lösen können. Bitte bearbeiten Sie zunächst diese! 

Klonen Sie dieses Repository direkt in Eclipse und importieren Sie das Projekt. Legen Sie einen neuen Branch an, den Sie nach Ihrem GitHub-Benutzernamen benennen.



## Aufgabe 1

Die sogenannte Type-Token-Relation (TTR) ist ein Standardmaß aus der Korpuslinguistik, um etwas über die sprachliche Variabilität eines Textes zu erfahren. Dabei wird die Anzahl der verschiedenen Wörter (= Types) durch die Anzahl der Wörter (= Tokens) geteilt. Der Text "Der Hund hat den Hund beschnüffelt." z.B. hätte eine TTR von 5/6, da nur das Wort "Hund" doppelt vorkommt (wir ignorieren Satzzeichen).

In Übung 5 haben wir einen Iterator implementiert, der uns die Tokens eines Dokumentes liefert. Sie finden die Referenzimplementierung von Übung 5 hier in diesem Repository. Basierend darauf, können wir sehr leicht die TTR des Textes bestimmen (der wieder in der Datei `data/dracula.txt` liegt), indem wir die Tokens einmal zählen und außerdem in eine Menge einfügen. Da die Menge jedes Wort nur einmal enthalten kann, entspricht die Größe der Menge hinterher der Anzahl der Types.

Fügen Sie der Klasse `Document` also eine Methode `ttr()` hinzu, die die TTR als double-Wert zurückgibt. Berechnen Sie sie mithilfe eines Set-Objektes.

Zur Selbstkontrolle: Der Wert 0.1141 ist korrekt.


## Aufgabe 2 (freiwillige, aber nette Aufgabe)

Im Spiel ["Türme von Hanoi"](https://de.wikipedia.org/wiki/Türme_von_Hanoi) besteht die Aufgabe darin, einen Stapel scheiben vom linken auf den rechten Stab zu befördern. Dazu darf ein dritter Stab in der Mitte verwendet werden. In jedem Zug darf eine Scheibe auf einen anderen Stab gelegt werden, allerdings darf niemals eine größere auf einer kleineren Scheibe liegen.

![](https://upload.wikimedia.org/wikipedia/commons/0/07/Tower_of_Hanoi.jpeg)

In der Klasse `idh.java.Hanoi` finden Sie eine Rumpfimplementierung für das Spiel, wobei die Stäbe hier waagerecht dargestellt werden, und die Scheibengröße nur durch Zahlen repräsentiert werden. Eine gültige Situation im Spiel sieht in der Fassung so aus:

```
  | 
 l|9 8 7 6
  |
 m|5 4
  |
 r|3 2 1
  |
```

Der Benutzer gibt dabei immer zwei Buchstaben ein, einen für die Quelle (von wo eine Scheibe entnommen wird) und eine für den Zielstab (wo die Scheibe abgelegt wird), also z.B. `lm` für "Nimm die oberste Scheibe vom linken Stab und lege sie auf den mittleren".

Ihre Aufgabe besteht darin, die Klasse so fertig zu implementieren, dass das Spiel spielbar ist. Dazu müssen Sie eine geeignete Datenstruktur auswählen und in allen mit `TODO: Implement` markierten Methoden verwenden. Außerdem sollten Sie die Datenstruktur initialisieren, so dass am Anfang Scheiben der Größen 9 bis 1 auf dem linken Stab liegen.

**Hinweis**

Wir müssen bei dieser Implementierung zwei Anwendungsfälle unterscheiden: Ein:e Spieler:in darf nur auf die oberste Scheibe zugreifen, das entspricht einer Queue in Reinform. Um die Scheiben aber korrekt auf dem Bildschirm darstellen zu können, müssen wir -- für die Darstellung -- auch von der anderen Seite zugreifen können.

----

Wenn Sie fertig sind, committen Sie alle Ihre Änderungen am Quellcode, und pushen Sie den neuen Branch auf das remote namens `origin` (= GitHub). 