public class Auswertung {
    public static void main(String[] args)
    {
        Quadrat quad1 = new Quadrat(0f,0f,4f); //Ein neues Objekt der Klasse Quadrat wird "erzeugt"
        float[] q1Pos = quad1.getPosition(); //Die Koordinaten des Quadrats als array
        float q1Width = quad1.getWidth(); //Die Breite des Quadrats 
		
		/*printf wird hier aufgrund des übersichtlicheren Syntax verwendet.
		  Hierbei werden jeweils die %f mit den Werten hinter dem Komma ersetzt.
		  %.2f gibt an das auf 2 Komma stellen gerundet wird. %n fügt einen "line-break" bzw. eine neue Zeile ein*/
        System.out.printf("Neues Quadrat. Position: (%.2f|%.2f), Breite: %.2fcm %n", q1Pos[0], q1Pos[1], q1Width);
        System.out.printf("Gültig: %s %n", quad1.isValid()); //isValid gibt einen boolschen wert zurück, dieser wird hier von printfs %s in einen string covertiert
        quad1.printArea(); //Die methode printArea vom quadrat-objekt wird aufgerufen. Diese gibt die Gesamtgröße des Quadrates aus.
        quad1.printQuadrant();//Die methode printQuadrant vom quadrat-objekt wird aufgerufen. Diese gibt die Größe der Fläche in Q1 aus.
        
		//Ein zweites quadrat wird erstellt, alle Schritte von oben ewrden wiederholt.
        Quadrat quad2 = new Quadrat(-3f,2f,14f);
        float[] q2Pos = quad2.getPosition();
        float q2Width = quad2.getWidth();
        System.out.printf("Neues Quadrat. Position: (%.2f|%.2f), Breite: %.2fcm %n", q2Pos[0], q2Pos[1], q2Width);
        System.out.printf("Gültig: %s %n", quad2.isValid());
        quad2.printArea();
        quad2.printQuadrant();   
    }
}

class Quadrat {
	/*Die Positionen des Quadrates und die Fläche im ersten Quadrant (q1) 
	  sind private und können nicht von Aussen verändert werden. */
    private float posX, posY, width, q1;
    private boolean isValid; //Wird vom Constructor auf True gestzt wenn das Quadrat den Anforderungen entspricht
    
    public Quadrat(float posX, float posY, float width)
    {
        this.posX = posX; this.posY = posY; this.width = width; //Dem Quadrat werden Position und Größe zugewiesen
        this.isValid = this.check(); //Prüfung ob das Quadrat gültig ist
        if(this.isValid) //Wenn das Quadrat gültig ist, kann der Bereich im ersten Quadrant ausgerechnet werden
        {
            this.q1 = this.calculateQuadrant();
        }
    }
    
	//Checkt ob das Quadrat gültig ist
    boolean check()
    {
        boolean valid = false; //Inizial wird davon ausgegangen dass das Quadrat nicht gültig ist
        float rad = this.width / 2; //Der Radius, also die länge vom Mittelpunkt bis zu den Kanten
        
        if(this.posX + rad > 0 && this.posY + rad > 0) //posX + rad ist die position der rechten Kante, posY + rad die der oberen Kante.
        {
            if(this.posX - rad < 0 && this.posY - rad < 0) //Hier jeweils die linke und untere Kante
            {
				//Sind die linke und untere Kante kleiner 0 und die obere und rechte Kante größer 0 sind die Flächeninhalte aller Quadranten > 0
                valid = true;  
            }
        }

        return valid;   
    }
    
	//Berechnet die Fläche im ersten Quadranten des Koordinatensystems
    float calculateQuadrant()
    {
        float pointX = this.posX + (this.width / 2);
        float pointY = this.posY + (this.width / 2);
        System.out.println(pointX);
        return pointX * pointY;
    }
	
	//Getter Methoden
    public float getWidth()
    {
        return this.width; //Gibt die Breite zurück
    }
    public float[] getPosition()
    {
        return new float[] {this.posX, this.posY}; //Gibt ein array mit den Koordinaten zurück
    }
	
	//Ausgabe Methoden
    public void printArea()
    {
        System.out.printf("Die Gesamtfläche des Quadrates beträgt %.2fcm² %n", this.width * this.width);
    }
    public void printQuadrant()
    {
        System.out.printf("Der Breich in Quadrant 1 is %.2fcm² groß %n", this.q1);
    }
	
	//Gibt ein boolschen wert zurück
    public boolean isValid()
    {
        return this.isValid;
    }
}