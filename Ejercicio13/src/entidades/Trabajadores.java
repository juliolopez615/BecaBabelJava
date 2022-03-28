package entidades;

public class Trabajadores extends Empleado {
	private int valoracion;

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	@Override
	public double sueldoFinal() {
		switch(this.getValoracion())
		{
		   case 0:
		   case 1:
		   case 2:
		   case 3:
		   case 4:
		      return this.getSueldoBase();
		   case 5:
		   case 6:
			   return this.getSueldoBase() + 50;
		   case 7:
		   case 8:
			   return this.getSueldoBase() + 100;
		   case 9:
		   case 10:
			   return this.getSueldoBase() + 200;
		   default:
			   System.out.println("Algo fue mal >.<");
			   return -1;
		}
	}
}
