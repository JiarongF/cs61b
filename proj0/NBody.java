public class NBody{

	private static final String imgBackground = "images/starfield.jpg";
	private static final String path = "images/";
	private static final String bgm = "audio/2001.mid";

	public static double readRadius(String fileName){
		In in = new In(fileName);
		int numPlanet = in.readInt();
		double radius = in.readDouble();
		return radius;

	}

	public static Planet[] readPlanets(String fileName){
		In in = new In(fileName);
		int numPlanet = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[numPlanet];
		for(int i = 0; i<numPlanet; i++){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m =  in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xP, yP, xV, yV, m, img);
		}
		return planets;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		int n = planets.length;

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, imgBackground);
		StdDraw.show();
		StdAudio.play(bgm);

		for(Planet planet : planets){
			planet.draw();
		}

		double[] xForces = new double[n];
		double[] yForces = new double[n];

		for(double time = 0 ; time < T; time = time + dt){

			for(int i = 0; i < n; i++){
				xForces[i]= planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for(int i = 0; i < n; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.enableDoubleBuffering();
			StdDraw.picture(0, 0, imgBackground);
			for(Planet planet : planets){
				planet.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", n);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < n; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}