public class Auswertung {
    public static void main(String[] args)
    {
        Quadrat quad1 = new Quadrat(0f,0f,4f);
        float[] q1Pos = quad1.getPosition();
        float q1Width = quad1.getWidth();
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
    private float posX, posY, width, q1;
    private boolean isValid;
    
    public Quadrat(float posX, float posY, float width)
    {
        this.posX = posX; this.posY = posY; this.width = width;
        this.isValid = this.check();
        if(this.isValid)
        {
            this.q1 = this.calculateQuadrant();
        }
    }
    
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
    
    float calculateQuadrant()
    {
        float pointX = this.posX + (this.width / 2);
        float pointY = this.posY + (this.width / 2);
        System.out.println(pointX);
        return pointX * pointY;
    }
    public float getWidth()
    {
        return this.width;
    }
    public float[] getPosition()
    {
        return new float[] {this.posX, this.posY};
    }
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