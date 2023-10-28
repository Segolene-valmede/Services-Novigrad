public class PointCP4 {
    private double x;
    private double y;

    PointCP4(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Contains C(artesian) or P(olar) to identify the type of
     * coordinates that are being dealt with.
     */
    private char typeCoord;
    /**
     * Contains the current value of X or RHO depending on the type
     * of coordinates.
     */
    private double xOrRho;
    /**
     * Contains the current value of Y or THETA value depending on the
     * type of coordinates.
     */
    private double yOrTheta;

    //To store the cartesian and  polar points respectively
    private PointCP4  cartesian,polar;

    //Constructors ******************************************************
    /**
     * Constructs a coordinate object, with a type identifier.
     */


    public PointCP4(char type, double xOrRho, double yOrTheta)
    {
        if (type != 'C' && type != 'P')
            throw new IllegalArgumentException();
        this.xOrRho = xOrRho;
        this.yOrTheta = yOrTheta;
        typeCoord = type;
    }
    //Instance methods **************************************************
    public double getX()
    {
        if (typeCoord == 'C')
            return xOrRho;
        else
            return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
    }
    public double getY()
    {
        if (typeCoord == 'C')
            return yOrTheta;
        else
            return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
    }
    public double getRho()
    {
        if (typeCoord == 'P')
            return xOrRho;
        else
            return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
    }
    public double getTheta()
    {
        if (typeCoord == 'P')
            return yOrTheta;
        else
            return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
    }
    /*getCartesianCoord function stores the Polar coordinates and returns the same.*/

    public PointCP4 getCartesianCoord(){

        double x=getX();
        double y= getY();

        cartesian= new PointCP4(x,y);

        return cartesian;
    }

    // getPolarCoord function stores the cartesian coordinates and returns the same
    public PointCP4 getPolarCoord(){

        double x=getX();
        double y= getY();

        polar= new PointCP4(x,y);

        return polar;
    }
    /**
     * Converts Cartesian coordinates to Polar coordinates.
     */
    public void convertStorageToPolar()
    {
        if (typeCoord != 'P')
        {
            //Calculate RHO and THETA
            double temp = getRho();
            yOrTheta = getTheta();
            xOrRho = temp;
            typeCoord = 'P'; //Change coord type identifier
        }
    }
    /**
     * Converts Polar coordinates to Cartesian coordinates.
     */
    public void convertStorageToCartesian()
    {
        if (typeCoord != 'C')
        {
            //Calculate X and Y
            double temp = getX();
            yOrTheta = getY();
            xOrRho = temp;
            typeCoord = 'C'; //Change coord type identifier
        }
    }
    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @parampointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public double getDistance(PointCP4 pointB)
    {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();
        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }
    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @parampoint The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public PointCP4 rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();
        return new PointCP4('C',
                (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }
    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString()
    {
        return "Stored as " + (typeCoord == 'C' ? "Cartesian (" + getX() + "," + getY() + ")" : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
    }
}