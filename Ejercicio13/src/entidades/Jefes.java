package entidades;

public class Jefes extends Empleado{
	private int incentivos;

	public int getIncentivos() {
		return incentivos;
	}

	public void setIncentivos(int incentivos) {
		this.incentivos = incentivos;
	}
	
	@Override
	public double sueldoFinal() {
		return this.getSueldoBase() + this.getIncentivos();
	}
}
