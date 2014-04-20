Architecture Example
===================

This is a sample application for experiments and discussions about software architecture. The application is a small game in which the player enters english words and gets points dependent on the length of these words.

As you can see in the package structure, three people are implementing parts of this game. Over time, we experiment with different implementations and analyse what effects our decisions have.


open tasks
-----------

1. EINE Client Api
1. b Das große Dictionary verwenden
1. c Ein Sleep von 0.1 Sekunden in den Server einbauen
2. Je eine Implementierung für beide Server
3. Drei JMeter  Tests. Jeweils: Wann bricht der server zusammen, bzw. wird ein Limit erreicht:
a) möglichst schnell Wörter (nur ein Spiel)
b) viele Spieler mit je 3 Wörtern
c) Spieler und Wörter hochdrehen
