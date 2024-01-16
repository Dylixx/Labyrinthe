### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

Menu.class : Menu.java BoutonMenu.class
	${JC} ${JCFLAGS} Menu.java

AlgoAleatoire.class : AlgoAleatoire.java Deplacement.class
	${JC} ${JCFLAGS} AlgoAleatoire.java

AlgoDeterm.class : AlgoDeterm.java 
	${JC} ${JCFLAGS} AlgoDeterm.java

BoutonMenu.class : BoutonMenu.java Grille.class Lecture.class
	${JC} ${JCFLAGS} BoutonMenu.java

BoutonMenuS.class : BoutonMenuS.java PeutAvancer.class AlgoAleatoire.class AlgoDeterm.class Sauvegarde.class
	${JC} ${JCFLAGS} BoutonMenuS.java

Deplacement.class : Deplacement.java
	${JC} ${JCFLAGS} Deplacement.java

Grille.class : Grille.java Murs.class Modifications.class MenuSecondaire.class
	${JC} ${JCFLAGS} Grille.java

GrilleFichier.class : GrilleFichier.java MursFichier.class
	${JC} ${JCFLAGS} GrilleFichier.java

Lecture.class : Lecture.java
	${JC} ${JCFLAGS} Lecture.java

MenuSecondaire.class : MenuSecondaire.java BoutonMenuS.class
	${JC} ${JCFLAGS} MenuSecondaire.java

Modifications.class : Modifications.java Murs.class
	${JC} ${JCFLAGS} Modifications.java

Murs.class : Murs.java
	${JC} ${JCFLAGS} Murs.java

MursFichier.class : MursFichier.java
	${JC} ${JCFLAGS} MursFichier.java

PeutAvancer.class : PeutAvancer.java
	${JC} ${JCFLAGS} PeutAvancer.java

RotationTableau.class : RotationTableau.java
	${JC} ${JCFLAGS} RotationTableau.java

Sauvegarde.class : Sauvegarde.java BoutonMenuS.class RotationTableau.class
	${JC} ${JCFLAGS} Sauvegarde.java

### REGLES OPTIONNELLES ###

run : Menu.class
	${JVM} ${JVMFLAGS} Menu

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###
