public class Auswertung {
    public static void main(String[] args)
    {
        Quadrat quad1 = new Quadrat(0f,0f,4f); //Ein neues Objekt der Klasse Quadrat wird "erzeugt"
        float[] q1Pos = quad1.getPosition(); //Die Koordinaten des Quadrats als array
        float q1Width = quad1.getWidth(); //Die Breite des Quadrats 
		
		/*printf wird hier aufgrund des übersichtlicheren Syntax verwendet.
		  Hierbei werden jeweils die %f mit den Werten hinter dem Komma ersetzt.
		  %.2f gibt an das auf 2 KOmma stellen gerundet wird */
        System.out.printf("Neues Quadrat. Position: (%.2f|%.2f), Breite: %.2fcm %n", q1Pos[0], q1Pos[1], q1Width);
        System.out.printf("Gültig: %s %n", quad1.isValid());
        quad1.printArea();
        quad1.printQuadrant();
        
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
        boolean valid = false;
        float rad = this.width / 2;
        
        if(this.posX + rad > 0 && this.posY + rad > 0)
        {
            if(this.posX - rad < 0 && this.posY - rad < 0)
            {
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
	
    public boolean isValid()
    {
        return this.isValid;
    }
}