class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double g = 6.67e-11;

	public Planet(double xP, double yP, double xV, 
		double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){

		double distance = Math.pow((this.xxPos - p.xxPos),2) + Math.pow((this.yyPos - p.yyPos),2);
		return Math.sqrt(distance);

	}

	public double calcForceExertedBy(Planet p){

		double distance = calcDistance(p);
		double force = g*this.mass*p.mass/Math.pow(distance,2);
		return force;

	}

	public double calcForceExertedByX(Planet p){

		double force = calcForceExertedBy(p);
		double distanceX = p.xxPos - xxPos;
		double distance = calcDistance(p);
		double forceX = force*distanceX/distance;
		return forceX;

	}
	public double calcForceExertedByY(Planet p){

		double force = calcForceExertedBy(p);
		double distanceY = p.yyPos - yyPos;
		double distance = calcDistance(p);
		double forceY = force*distanceY/distance;
		return forceY;

	}

	public double calcNetForceExertedByX(Planet[] ps){

		double forceNetX = 0.0;
		for(Planet p: ps){
			if(this.equals(p)){
				continue;
			}else{
				forceNetX += calcForceExertedByX(p);
			}
			
		}

		return forceNetX;


	}

	public double calcNetForceExertedByY(Planet[] ps){

		double forceNetY = 0.0;
		for(Planet p: ps){
			if(this.equals(p)){
				continue;
			}else{
				forceNetY += calcForceExertedByY(p);
			}
			
		}

		return forceNetY;

	}

	public void update(double dt, double fX, double fY){

		double aXNet = fX/this.mass;
		double aYNet = fY/this.mass;

		this.xxVel = this.xxVel + dt * aXNet;
		this.yyVel = this.yyVel + dt * aYNet;

		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;

	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, NBody.path + imgFileName);
	}

}