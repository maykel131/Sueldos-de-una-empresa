/*Desarrolle un programa que cuenta con dos clase una llamada Sueldo para leer la cédula,nombre y sueldo base y
la classe Principal se instanciara el objeto, y los llamados a los metodos.Calcular el sueldo neto, consideran
lo siguiente: Si el sueldo base es menor o igual a 16000 recibirá un aumento del 50% sobre su sueldo, en caso
contrario será del 35%. Además se desea saber quién de los empleados tiene mayor sueldo.Mostra los datos  de los empleados
El tamaño del arreglo se introducirá por teclado*/
package ejerarre;
import javax.swing.JOptionPane;
/**
 *
 * @author Esteben
 */
public class Sueldo {

    public final float PORC = 1.50f, PORC1 = 1.35f;
    public String[] nom;
    public int[] ced;
    public float[] Sb, Sn;
    public float mayor;
    public int tam;

    public Sueldo() {
    }

    public String[] getNom() {
        return nom;
    }

    public void setNom(String[] nom) {
        this.nom = nom;
    }

    public int[] getCed() {
        return ced;
    }

    public void setCed(int[] ced) {
        this.ced = ced;
    }

    public float[] getSb() {
        return Sb;
    }

    public void setsN(float[] Sb) {
        this.Sb = Sb;
    }

    public void ObtenerTamanoArreglo() {
        do {
            tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados a registrar [1-100]"));
            if ((tam < 1) || (tam > 100)) {
                JOptionPane.showMessageDialog(null, "Error intente nuevamente");
            }
        } while ((tam < 1) || (tam > 100));
        Sb = new float[tam];
        nom = new String[tam];
        ced = new int[tam];
        Sn = new float[tam];
    }

    public void LeerDatos() {
        for (int i = 0; i < tam; i++) {
            ced[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "\t\tIntroduzca la Cedula: " + (i + 1) + " de " + Sb.length));
            nom[i] = JOptionPane.showInputDialog(null, "\t\tIntroduzca el Nombre: " + (i + 1) + " de " + Sb.length);
            Sb[i] = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduzca el Sueldo Base: " + (i + 1) + " de " + Sb.length));
        }//fin del for
    } //fin del metodo

    public void CalcularSn() {
        for (int i = 0; i < Sb.length; i++) {
            if (Sb[i] <= 16000) {
                Sn[i] = Sb[i] * PORC;
            } else {
                Sn[i] = Sb[i] * PORC1;
            }

        }//fin del for
    }//fin del metodo

    public void Nomina() {
        for (int x = 0; x < ced.length; x++) {
            JOptionPane.showMessageDialog(null, "\n\t\tCedula[" +x+ "]:\t\t " + ced[x] + "\n\t\t\tNombre[" + x + "]:\t\t " + nom[x]
                    + "\n\t\tSueldo Neto[" + x + "]: \t\t" + Sn[x], "Nomina de los Empleados", 1);
        }
    }
    public float MayorSn() {
        mayor = Sn[0];
        for (int i = 0; i <= Sn.length - 1; i++) {
            if (Sn[i] > mayor) {
                mayor = Sn[i];
            }
        }
        return mayor;
    }
    public void ImprimirMayorSueldo() {
        for (int x = 0; x < ced.length; x++) {
            if (Sn[x] == mayor) {
                JOptionPane.showMessageDialog(null, "Cedula[" + (x+1) + "]: " + ced[x] + "\n\tNombre[" + (x+1) + "]: " + nom[x]
                        + "\n\tSueldo Mayor[" + (x+1) + "]: " + Sn[x], "Datos de los Empleado con Mayor Sueldo", 1);
            }
        }
    }

}
